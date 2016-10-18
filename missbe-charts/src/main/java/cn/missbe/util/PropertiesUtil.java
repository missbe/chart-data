package cn.missbe.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private  Properties pro;
	private String proFileName;

	public PropertiesUtil(String proFileName) {
		try {
			System.out.println("初始化PropertiesUtil:"+proFileName);
			this.proFileName=proFileName;
			pro = new Properties();
			InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(this.proFileName);
			pro.load(in);
			in.close();
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("属性文件读取错误");
		}
	}

	public  String getValue(String key) {
		String value = pro.getProperty(key);
//		System.out.println("Value:"+value);
		return value;
	}
}
