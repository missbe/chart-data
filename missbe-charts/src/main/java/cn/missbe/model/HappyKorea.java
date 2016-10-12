package cn.missbe.model;

/**
 * 论坛用户相关详细信息
 * @author Administrator
 *处理论坛用户相关模型
 */
public class HappyKorea {
     private String rank;
     private String author;
     private String postNumber;
     private String webSiteName;
     
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getWebSiteName() {
		return webSiteName;
	}
	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}
}
