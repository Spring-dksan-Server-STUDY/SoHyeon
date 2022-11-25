package com.dksanServer.sohyeon.week3.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int age;

//    public Member() {}
//
//    public Member(Long id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
}
