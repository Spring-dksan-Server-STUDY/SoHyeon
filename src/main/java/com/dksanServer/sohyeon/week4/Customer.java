package com.dksanServer.sohyeon.week4;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private String name;
    private int age;
    private final String email;
    private final LocalDateTime createAt;

    public Customer(UUID customerId, String name, int age, String email, LocalDateTime createAt) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createAt = createAt;
    }

    private void validName(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException("이름에 빈칸이 포함되어 있지 않아야 합니다.");
        }
    }

    public void changeName(String name) {
        this.name = name;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
