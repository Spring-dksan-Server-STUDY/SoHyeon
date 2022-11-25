package com.dksanServer.sohyeon.week3.login;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new KakaoLogin());
        userService.login();
    }
}
