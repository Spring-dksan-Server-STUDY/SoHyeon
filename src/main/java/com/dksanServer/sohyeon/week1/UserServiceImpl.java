package com.dksanServer.sohyeon.week1;

public class UserServiceImpl implements UserInterface{
    @Override
    public void introduce(String name, int age, String mbti) {
        System.out.println("안녕하세요! 이름은 " + name + ", 나이는 " + age + "살, MBTI는 " + mbti + " 입니다. 반갑습니다!");
    }

    @Override
    public void getInfo(int generation, String part) {
        UserInterface.super.getInfo(generation, part);
    }

    public void getSOPT() {
        UserInterface.introduceSOPT();
    }

}
