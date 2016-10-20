package cn.missbe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;
/**
 * 工具类，获取数据库的连接
 * @author Administrator
 *
 */
public final class DBUtil {

	private static String url = "jdbc:mysql://119.29.251.86:3306/missbe";
	private static String user = "root";
	private static String psw = "missbe@cn";
	private static Connection conn;
	private static Logger logger = Logger.getLogger(DBUtil.class);

	public DBUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("初始化失败." + SimpleDateFormateUtil.formateDateyyyy_MM_ddHHmmss(new Date()));
			throw new RuntimeException(e);
		} ///
		catch (SQLException e) {
			e.printStackTrace();
			logger.error("获取数据连接失败."+SimpleDateFormateUtil.formateDateyyyy_MM_ddHHmmss(new Date()));
			throw new RuntimeException(e);
		}
    }

	/**
	 * 获取数据库的连接
	 * 
	 * @return conn
	 */
	public  Connection getConnection() {
		
		return null != conn? conn : null;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public  void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("关闭结果数据集失败."+SimpleDateFormateUtil.formateDateyyyy_MM_ddHHmmss(new Date()));
				throw new RuntimeException(e);
			} finally {
				if (null != pstmt) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						logger.error("关闭查询语句失败."+SimpleDateFormateUtil.formateDateyyyy_MM_ddHHmmss(new Date()));
						throw new RuntimeException(e);
					} finally {
						if (null != conn) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
								logger.error("连接关闭失败."+SimpleDateFormateUtil.formateDateyyyy_MM_ddHHmmss(new Date()));
								throw new RuntimeException(e);
							}
						}
					}
				}
			}
		}
	}

}
