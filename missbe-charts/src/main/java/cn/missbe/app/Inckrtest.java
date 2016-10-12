package cn.missbe.app;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import cn.dyhack.db.DBConnection;
import cn.dyhack.website.*;

public class Inckrtest extends HappyKorea {
	public static String timeformat = "yyyy/MM/dd HH:MM:SS";
	public static DateFormat dft = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS");
	public static Date indextime;
	public static final String URL_LIST = "http://bbs.icnkr.com/forum-\\d+-\\d+\\.html";
	public static final String Index_URL_regex = "[a-zA-z]+://[^\\s]*";
	public static final String URL_POST = "http://bbs.icnkr.com/thread-\\d+\\-1-1.html";

	@SuppressWarnings("static-access")
	public Inckrtest(int subdays)// 初始化时间。当前时间减去30天
	{

		Calendar Cal = Calendar.getInstance();
		Cal.setTime(new Date());
		Cal.add(Cal.DATE, subdays);
		indextime = Cal.getTime();

	}

	private Site site = Site.me().setDomain("http://bbs.icnkr.com/").setTimeOut(25000).setRetryTimes(5)
			.setSleepTime(10000).setCharset("UTF-8")
			.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
			.addHeader("Accept-Encoding", "gzip, deflate, br")
			.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3").addHeader("Cache-Control", "no-cache")
			.addHeader("Connection", "keep-alive").addHeader("Pragma", "no-cache")
			.addHeader("Upgrade-Insecure-Requests", "1")
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");

	@Override
	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		if (page.getUrl().regex(Index_URL_regex).match() && flag == false) {
			flag = true;
			page.addTargetRequests(page.getHtml().xpath("//*[@id=\"ct\"]").links().regex(URL_LIST).all());

		}
		if (page.getUrl().regex(URL_LIST).match()) {
			page.addTargetRequests(
					page.getHtml().xpath("//*[@id=\"threadlisttableid\"]").links().regex(URL_POST).all());
			page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
			// 文章页
		} else if (page.getUrl().regex(URL_POST).match()) {
			// 建立一个Icnkr对象，用来存放爬虫爬取的数据

			Icnkr icnkr = new Icnkr();

			icnkr.SetTitle(page.getHtml().xpath("//*[@id=\"thread_subject\"]/a/text()").toString());
			icnkr.SetTags(page.getHtml().xpath("//*[@id=\"postlist\"]/table/tbody/tr/td[2]/h1/a/text()").toString());
			icnkr.SetAuthor(page.getHtml().xpath("//div[contains(@class,'authi')]/a/text()").toString());
			if (page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString() != null) {

				if (Judgementdate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString(),
						indextime, timeformat)) {

					page.setSkip(true);
				}
				System.out.println(
						"time1" + page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString()
								+ " " + page.getRequest().getUrl());
				icnkr.SetDate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/span/@title").toString());
			} else {

				if (Judgementdate(
						page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(4,
								page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length()),
						indextime, timeformat)) {

					page.setSkip(true);
				}
				// System.out.println("time2"+page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(4,page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length())+"
				// "+page.getRequest().getUrl());
				icnkr.SetDate(page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().substring(4,
						page.getHtml().xpath("//em[contains(@id,'authorposton')]/text()").toString().length()));
			}

			icnkr.SetView(Integer.parseInt(page.getHtml()
					.xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[2]/text()").toString()));
			icnkr.SetComment(Integer.parseInt(page.getHtml()
					.xpath("//*[@id=\"postlist\"]/table[1]/tbody/tr/td[1]/div/span[5]/text()").toString()));
			icnkr.SetContent(page.getHtml().xpath("//td[contains(@id,'postmessage')]/html()")
					.replace("class=\"jammer.*?\"", "style=\"display:none\"").toString());
			icnkr.SetUrl(page.getRequest().getUrl());

			if (Judgementdate(icnkr.GetDate(), indextime, timeformat) == false) {

				new DBConnection().AddtoMysql_Icnkr(icnkr);
			}
		}
	}

	public static void main(String args[]) {
		Spider.create((new Inckrtest(-30))).addPipeline(new ConsolePipeline()).addUrl("http://bbs.icnkr.com/")
				.thread(20).run();
	}

}
