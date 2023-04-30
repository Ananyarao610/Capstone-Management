package com.pes.entities;

public class UserFactory {
    public static Users createUser(String userType) {
        if (userType.equals("student")) {
            return new student();
        } else if (userType.equals("teacher")) {
            return new teacher();
        } else if (userType.equals("admin")) {
            return new admin();
        } else {
            throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
