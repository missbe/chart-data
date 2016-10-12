package cn.missbe.app;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import cn.dyhack.db.DBConnection;
import cn.dyhack.website.*;
public class HappyKorea implements PageProcessor {
    public static boolean flag=false;
    public static Date indextime;
    public static final String URL_LIST = "http://bbs.enjoykorea.net/forum-\\d+-\\d+\\.html";
    public static final String Index_URL_regex="[a-zA-z]+://[^\\s]*";
    public static final String URL_POST = "http://bbs.enjoykorea.net/thread-\\d+\\-1-1.html";
    public static DateFormat dft=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
    public static String timeformat="yyyy-MM-dd HH:mm:ss"; 
    @SuppressWarnings("static-access")
	public HappyKorea(int subdays) //构造器初始化时间。当前时间减去30天
    {
    	
    	Calendar Cal = Calendar.getInstance();
    	Cal.setTime(new Date());
    	Cal.add(Cal.DATE, subdays);
    	indextime = Cal.getTime();

    	
    }
    public HappyKorea()//无参构造，提供给子类调用默认的无参构造函数
    {
    	
    }
    private Site site = Site
            .me()
            .setDomain("bbs.enjoykorea.net")
            .setCharset("GBK")
            .setTimeOut(25000)
            .setRetryTimes(5)
            .setSleepTime(10000)
            .setUserAgent(
                    "Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");
    
    
    public static java.util.List<String> UrlIsInDB(java.util.List<String> UrlList)
    {
    	for(@SuppressWarnings("unused") String str : UrlList)
    	{
    		
    	}
		return UrlList;
    	
    }
    @Override
    public void process(Page page) {
        //列表页
    	if(page.getUrl().regex(Index_URL_regex).match()&&flag==false)
    	{
                flag=true;
    			page.addTargetRequests(page.getHtml().xpath("//*[@id=\"ct\"]").links().regex(URL_LIST).all());

    	}
        if (page.getUrl().regex(URL_LIST).match()) {
               page.addTargetRequests(page.getHtml().xpath("//*[@id=\"threadlisttableid\"]").links().regex(URL_POST).all());
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
            //文章页
        }
    	 else if(page.getUrl().regex(URL_POST).match()){
        	//建立一个HappyKorea对象，用来存放爬虫爬取的数据
    		
        	Enjoykorea enjoykorea=new Enjoykorea();
        	
        	enjoykorea.SetTitle(page.getHtml().xpath("//*[@id=\"thread_subject\"]/a/text()").toString());
        	enjoykorea.SetTags(page.getHtml().xpath("//*[@id=\"postlist\"]/table/tbody/tr/td[2]/h1/allText()").toString());
        	enjoykorea.SetAuthor(page.getHtml().xpath("//div[contains(@class,'authi')]/a/text()").toString());
        	if(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString()!=null)
        	{
        		if(Judgementdate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString(),indextime,timeformat))
        		{
        			
        			page.setSkip(true);
        		}
        		
        		enjoykorea.SetDate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString());
        		
        	}
        	else {
        		if(Judgementdate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(4,page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length()),indextime,timeformat))
        		{
        			
        			page.setSkip(true);
        		}
        		enjoykorea.SetDate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(4,page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length()));
        		
			}
        	
		    enjoykorea.SetView(Integer.parseInt(page.getHtml().xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[2]/text()").toString()));
            enjoykorea.SetComment(Integer.parseInt(page.getHtml().xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[5]/text()").toString()));
            enjoykorea.SetContent(page.getHtml().xpath("//td[contains(@id,'postmessage')]/html()").replace("class=\"jammer.*?\"", "style=\"display:none\"").toString());
            enjoykorea.SetUrl(page.getRequest().getUrl());
            enjoykorea.toString();
            if(Judgementdate(enjoykorea.GetDate(), indextime,timeformat)==false)
            {
            
        	new DBConnection().AddtoMysql_EnjoyKorea(enjoykorea);
            }
        	
        	/*
            page.putField("title", page.getHtml().xpath("//*[@id=\"thread_subject\"]/a/text()").toString());
            page.putField("tags",page.getHtml().xpath("//*[@id=\"postlist\"]/table/tbody/tr/td[2]/h1/text()").toString());
            page.putField("author", page.getHtml().xpath("//div[contains(@class,'authi')]/a/text()").toString());
            if(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString()!=null)
        	{
        		page.putField("date",page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString());
        	}
        	else
        	{
            page.putField("date",
                                page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(3,page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length()));
        	}
            page.putField("view",page.getHtml().xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[2]/text()").toString());
            //page.putField("comment", page.getHtml().xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[5]").toString());
            //page.putField("content", page.getHtml().xpath("//td[contains(@id,'postmessage')]/html()").replace("class=\"jammer.*?\"", "style=\"display:none\"").toString());
            page.putField("url", page.getRequest().getUrl());
            */
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
    public boolean Judgementdate(String pagetime,Date indextime,String timeformat)
    {
    	 
    	 SimpleDateFormat dft = new SimpleDateFormat(timeformat);
    	 try
    	 {
    	 Date date1=dft.parse(pagetime);
    	 if (indextime.after(date1)) {
    		 
    		  return true;
    		 }
    	 else
    	 {
    		 
    		 return false;
    	 }
    	 
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println("error"+pagetime+" "+indextime); 
    		 return false;
    	 }
    	 
    }
   
     
    public  void invokeHappyKorea() {
    	
        Spider.create(new HappyKorea(-30)).addUrl("http://bbs.enjoykorea.net").thread(20).run();
    	
    }
}