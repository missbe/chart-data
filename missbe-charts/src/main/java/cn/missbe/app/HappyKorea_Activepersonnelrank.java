package cn.missbe.app;

import cn.dyhack.db.DBConnection;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class HappyKorea_Activepersonnelrank implements PageProcessor {

	private Site site = Site.me().setTimeOut(25000).setRetryTimes(5).setSleepTime(10000).setCharset("GBK").setUserAgent(
			"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");

	@Override
	public void process(Page page) {
		// 列表页
		/*
		 * page.addTargetRequests(page.getHtml().xpath("//*[@id=\"ct\"]").links(
		 * ).regex(URL_LIST).all()); if (page.getUrl().regex(URL_LIST).match())
		 * { page.addTargetRequests(page.getHtml().xpath(
		 * "//*[@id=\"threadlisttableid\"]").links().regex(URL_POST).all());
		 * page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
		 * //文章页 } else if(page.getUrl().regex(URL_POST).match()){
		 * //建立一个HappyKorea对象，用来存放爬虫爬取的数据
		 */
		// Enjoykorea enjoykorea=new Enjoykorea();
		// page.putField("rank",page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dd[1]/img/@alt"));
		// System.out.println(page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dd[1]/img/@alt").all().toString());
		// System.out.println(page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dd[1]/text()").all().toString());
		// System.out.println(page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dt[2]/a/text()").all().toString());
		// System.out.println(page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dd[3]/p/a/text()").all().toString());
		new DBConnection().AddtoMysql_EnjoyKorea_PostnumbRank(
				page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dt[2]/a/text()").all(),
				page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[1]/dl/dd[3]/p/a/text()").all(), "乐在韩国");
		// enjoykorea.toString();
		// new DBConnection().AddtoMysql_EnjoyKorea(enjoykorea);

		/*
		 * page.putField("title",
		 * page.getHtml().xpath("//*[@id=\"thread_subject\"]/a/text()").toString
		 * ()); page.putField("tags",page.getHtml().xpath(
		 * "//*[@id=\"postlist\"]/table/tbody/tr/td[2]/h1/text()").toString());
		 * page.putFielNo operations allowed after connection closedd("author",
		 * page.getHtml().xpath("//div[contains(@class,'authi')]/a/text()").
		 * toString()); if(page.getHtml().xpath(
		 * "//em[contains(@id,'authorposton')]/span/@title").toString()!=null) {
		 * page.putField("date",page.getHtml().xpath(
		 * "//em[contains(@id,'authorposton')]/span/@title").toString()); } else
		 * { page.putField("date",
		 * page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").
		 * toString().substring(3,page.getHtml().xpath(
		 * "//em[contains(@id,'authorposton')]/text()").toString().length())); }
		 * page.putField("view",page.getHtml().xpath(
		 * "//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[2]/text()").
		 * toString()); //page.putField("comment", page.getHtml().xpath(
		 * "//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[5]").toString
		 * ()); //page.putField("content",
		 * page.getHtml().xpath("//td[contains(@id,'postmessage')]/html()").
		 * replace("class=\"jammer.*?\"", "style=\"display:none\"").toString());
		 * page.putField("url", page.getRequest().getUrl());
		 */

	}

	@Override
	public Site getSite() {
		return site;
	}
	/**
	 * 外部调用接口-进行enjoykorea论坛数据更新
	 */
	public void invokeUpdate() {

		Spider.create(new HappyKorea_Activepersonnelrank())
				.addUrl("http://bbs.enjoykorea.net/misc.php?mod=ranklist&type=member&view=post&orderby=thismonth")
				.addPipeline(new ConsolePipeline()).thread(1).run();

	}

}
