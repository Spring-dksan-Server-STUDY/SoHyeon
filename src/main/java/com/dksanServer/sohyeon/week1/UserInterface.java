package com.dksanServer.sohyeon.week1;

public interface UserInterface {
    String CLUB = "SOPT";

    void introduce(String name, int age, String mbti);

    default void getInfo(int generation, String part) {
        System.out.println("SOPT " + generation + "기 " + part + " 파트입니다.");
    }

    static void introduceSOPT() {
        System.out.println("Shout Our Passion Together.");
    }
}
