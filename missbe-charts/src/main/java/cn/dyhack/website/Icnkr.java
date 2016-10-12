package cn.dyhack.website;

/*
 * 一个奋斗韩国论坛类
 * 实现存入类的信息，以及方便了将数据存入数据库
 * QQ:534737859
 * Date:2016/10/8
 */
public class Icnkr extends Enjoykorea{
	private int id;//编号
	private String author;//作者
	private int view;//查看次数(阅读人数)
	private int comment;//评论次数
    private String content;//帖子内容
    private String date;//发帖时间
    private String tags;//帖子分类
    private String title;//帖子的标题
    private String Url;//帖子的Url地址
    public int GetID()
    {
         return id;
    }
    public void SetID(int id)
    {
    	this.id=id;
    }
    public String GetAuthor()
    {
    	return author;
    }
    public void SetAuthor(String  author)
    {
    	this.author=author;
    }
    public int GetView()
    {
    	return view;
    }
    public void SetView(int view)
    {
    	this.view=view;
    }
    public int GetComment()
    {
    	return comment;
    }
    public void SetComment(int comment)
    {
    	this.comment=comment;
    }
    public String  GetContent()
    {
    	return content;
    }
    public void SetContent(String content)
    {
    	this.content=content;
    }
    public String GetDate()
    {
    	return date;
    }
    public void SetDate(String date)
    {
    	this.date=date;
    }
    public String GetTitle()
    {
    	return title;
    }
    public void SetTitle(String title)
    {
    	this.title=title;
    }
    public String  GetTags()
    {
    	return tags;
    	
    }
    public void SetTags(String tags)
    {
    	this.tags=tags;
    }
    public String GetUrl()
    {
    	return Url;
    }
    public void SetUrl(String url)
    {
    	this.Url=url;
    }
    @Override
    public String toString()
    {
    	return date+" :"+Url.toString()+" "+tags;
    	//return "Icnkr["+"id:"+id+"author:"+author+"view:"+view+"comment:"+comment+"content:"+content+"date:"+date+"]";
    	
    }


}
