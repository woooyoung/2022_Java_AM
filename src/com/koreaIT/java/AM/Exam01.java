package com.koreaIT.java.AM;

import java.text.SimpleDateFormat;
import java.util.Date;
// 현재 시간 날짜 테스트
public class Exam01 {
	public static void main(String[] args) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		String time1 = format1.format(time);

		System.out.println(time1);
	}
}
