package cn.missbe.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 客户留言实体(联系我们)
 *
 * @author leiyuangang
 * @date 2016年10月7日 下午10:23:34
 */
@Entity
@Table(name="admin_inf")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	@Column(name="user_name",length=18,nullable=false)
    private String name;

	@Column(name="user_pass",length=20,nullable=false)
    private String pass;
	
	@Temporal(TemporalType.DATE)
	@Column(name="update_time")
	private Date update_time;
	
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
   
}
