package com.dksanServer.sohyeon.week1;

public class User {
    private int id;
    private String name;
    private String part;

    public void introduce() {
        System.out.println("이름은 " + name + "이고, 파트는 " + part + "파트입니다.");
    }

    /**
     * User 객체 생성자
     * 매개변수가 있는 생성자
     *
     * @param id    유저 고유 번호
     * @param name  유저 이름
     * @param part  유저 파트
     */
    public User(int id, String name, String part) {
        this.id = id;
        this.name = name;
        this.part = part;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPart() {
        return part;
    }
}
