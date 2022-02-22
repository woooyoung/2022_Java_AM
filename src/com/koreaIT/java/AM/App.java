package com.koreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.AM.controller.ArticleController;
import com.koreaIT.java.AM.controller.MemberController;
import com.koreaIT.java.AM.dto.Article;
import com.koreaIT.java.AM.dto.Member;
import com.koreaIT.java.AM.util.Util;

public class App {

	private List<Article> articles;
	private List<Member> members;

	App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void start() {
		System.out.println("== 프로그램 시작 ==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc, members);
		ArticleController articleController = new ArticleController(sc, articles);

		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			if (command.equals("member join")) {
				memberController.doJoin();

			} else if (command.equals("article write")) {
				articleController.doWrite();
			} else if (command.startsWith("article list")) {
				articleController.showList(command);
			} else if (command.startsWith("article detail ")) {
				articleController.showDetail(command);
			} else if (command.startsWith("article modify ")) {
				articleController.doModify(command);
			} else if (command.startsWith("article delete ")) {
				articleController.doDelete(command);
			} else {
				System.out.printf("%s는(은) 존재하지 않는 명령어 입니다.\n", command);
			}
		}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");

		articles.add(new Article(1, Util.getNowDateTimeStr(), "제목1", "내용1", 11));
		articles.add(new Article(2, Util.getNowDateTimeStr(), "제목2", "내용2", 22));
		articles.add(new Article(3, Util.getNowDateTimeStr(), "제목3", "내용3", 33));
	}
}
