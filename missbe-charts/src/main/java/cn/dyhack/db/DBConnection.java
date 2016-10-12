package cn.dyhack.db;
import cn.dyhack.website.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	 
	    	private Connection connection=null;
	    	private Statement  statement=null;
	    	private String DBdriver="com.mysql.jdbc.Driver";
	    	private String ConnectionString="jdbc:mysql://124.161.157.37:3306/missbe?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";//sql6.freemysqlhosting.net/sql6139302?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10
	    	public DBConnection()
	    	{
	             try
	             {
	            	 Class.forName(DBdriver).newInstance();//加载数据库驱动
	            	 connection=DriverManager.getConnection(ConnectionString,"root","123");
	            	 //if(!connection.isClosed())
	            	 //System.out.println("Connection Success");
	            	 //statement=connection.createStatement();
	             }
	             catch(Exception e)
	             {
	            	e.printStackTrace();
	                System.out.println("数据库加载失败！");
	            	 
	             }	         
	    		
	    	}
	    	/**
	    	 * 获取数库连接
	    	 * @return
	    	 */
	    	public Connection getConnection() {
	    		Connection conn=null;
	    		if (null == conn) {
	    			try {
	    				conn=DriverManager.getConnection(ConnectionString,"root","123");
	    			} catch (SQLException e) {
	    				e.printStackTrace();
	    				throw new RuntimeException(e);
	    			}
	    		}
	    		return connection;
	    	}
	    	/*
	    	 * 通用的导入到数据库的方法
	    	 * 通过导入相应的包来实现
	    	 */
	    	public void AddtoMysql_EnjoyKorea(Enjoykorea Ek)
	    	{
	    		try{
	    		String sql="INSERT INTO enjoykorea_spider (Title,Tags,Author,Date,View,Comment,Content,Url) VALUES(?,?,?,?,?,?,?,?);";
	    		PreparedStatement ps=connection.prepareStatement(sql);
	    		System.out.println(Ek.GetUrl()+" "+Ek.GetDate());
	    		ps.setString(1,Ek.GetTitle());
	    		ps.setString(2,Ek.GetTags());
	    		ps.setString(3,Ek.GetAuthor());
	    	    ps.setString(4,Ek.GetDate());
	    		ps.setInt(5,Ek.GetView());
	    		ps.setInt(6,Ek.GetComment());
	    		ps.setString(7, Ek.GetContent());
	    		ps.setString(8,Ek.GetUrl());
	    		ps.executeUpdate();
	    		connection.close();
	    		
	    		}
	    		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException error)
	             {
	            	 System.out.println("此条记录数据库中已经存在");
	             }
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    			System.err.println("有错误!");
	    			
	    		}
	    		
	    		
	    	}
	    	public void AddtoMysql_Icnkr(Icnkr ik)
	    	{
	    		try{
	    		String sql="INSERT INTO inckr_spider (Title,Tags,Author,Date,View,Comment,Content,Url) VALUES(?,?,?,?,?,?,?,?);";
	    		PreparedStatement ps=connection.prepareStatement(sql);
	    		//System.out.println(ik.GetUrl()+" "+ik.GetDate());
	    		System.out.println(ik.toString());
	    		ps.setString(1,ik.GetTitle());
	    		ps.setString(2,ik.GetTags());
	    		ps.setString(3,ik.GetAuthor());
	    	    ps.setString(4,ik.GetDate());
	    		ps.setInt(5,ik.GetView());
	    		ps.setInt(6,ik.GetComment());
	    		ps.setString(7, ik.GetContent());
	    		ps.setString(8,ik.GetUrl());
	    		ps.executeUpdate();
	    		
	    		connection.close();
	    		
	    		}
	    		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException error)
	             {
	            	 System.out.println("此条记录数据库中已经存在");
	             }
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    			System.err.println("有错误!");
	    			
	    		}
	    		
	    		
	    	}
	    	public void AddtoMysql_EnjoyKorea_PostnumbRank(java.util.List<String> Authorlist,java.util.List<String> Postnumberlist,String websitename)
	    	{
	    	    String authorarray[]=new String[Authorlist.size()];
	    	    String postnumberarray[]=new String[Postnumberlist.size()];
                Authorlist.toArray(authorarray);
                Postnumberlist.toArray(postnumberarray);
                
	    		try{
	    			String sql="DELETE FROM happykorea_activepersonnelrank where Websitename='"+websitename+"'";

	    			statement=connection.createStatement();
	    			statement.executeUpdate(sql);
	    			
	    			for(int i=0;i<20;i++)
	    			{
		    		sql="INSERT INTO HappyKorea_Activepersonnelrank (Author,Postnumber,Websitename) VALUES(?,?,?);";
		    	    PreparedStatement ps=connection.prepareStatement(sql);
		    		ps.setString(1, authorarray[i]);
		    		ps.setString(2, postnumberarray[i]);
		    		ps.setString(3, websitename);
		    		
		    		ps.executeUpdate();
		    		
	    			}
	    			System.out.println("chengg ");;
	    			connection.close();
		    		}
		    		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException error)
		             {
		            	 System.out.println("此条记录数据库中已经存在");
		             }
		    		catch(Exception e)
		    		{
		    			e.printStackTrace();
		    			System.err.println("有错误!");
		    			
		    		}
	    		
	    	}
}
