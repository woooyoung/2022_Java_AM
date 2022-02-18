package com.koreaIT.java.AM;

public class Exam02 {
	public static void main(String[] args) {
		App.start();
	}
}

class App {
	public static int a;

	static {
		a = 10;
	}

	public static void start() {
		makeTestData(); // a => 5;
		System.out.println(a);
	}

	private static void makeTestData() {
		a = 5;
	}
}