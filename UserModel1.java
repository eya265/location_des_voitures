package com.example.locationdesvoitures.Model;

public class UserModel1 {


        private String name;
        private String email;
        private String password;

        public UserModel1(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public static String getName() {
            return name;
        }

        public static String getEmail() {
            return email;
        }

        public static String getPassword() {
            return password;
        }
    }

