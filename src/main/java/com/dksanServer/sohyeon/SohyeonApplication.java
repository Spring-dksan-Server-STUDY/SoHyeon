package com.dksanServer.sohyeon;

import com.dksanServer.sohyeon.week1.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SohyeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SohyeonApplication.class, args);

		User user = new User(1, "김소현", "서버");
		user.introduce();

		user.setName("양지영");
		user.setPart("안드");

		String name = user.getName();
		System.out.println("name = " + name);
		user.introduce();

		UserServiceImpl userService = new UserServiceImpl();

		String club = userService.CLUB;
		System.out.println(club);

		userService.introduce("김소현", 23, "ESFP");
		userService.getInfo(31, "server");

		// 정적 메소드는 인터페이스에서만 호출 가능
		userService.getSOPT();

		Server server = new Server("김소현", "스프링 안무서버");
		String serverName = server.getName();
		String serverStudy = server.getStudy();
		System.out.println("name = " + serverName + " study = " + serverStudy);

		PrintObject<Integer> object1 = new PrintObject<>(31);
		PrintObject<String> object2 = new PrintObject<>("server");
		object1.printData();
		object2.printData();


	}

}
