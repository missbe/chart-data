package cn.missbe.test;

import org.junit.Test;

import cn.missbe.app.HappyKorea_Activepersonnelrank;
import cn.missbe.app.Icnkr_Activepersonnelrank;

public class WebsiteUpdate {

	@Test
	public void koreaUpdateTest(){
		new HappyKorea_Activepersonnelrank().invokeUpdate();
		System.out.println("TEST:koreaUpdateTest");
	}
	@Test
	public void icnkrUpdateTest(){
		new Icnkr_Activepersonnelrank().invokeUpdate();
		System.out.println("TEST:koreaUpdateTest");
	}
}
