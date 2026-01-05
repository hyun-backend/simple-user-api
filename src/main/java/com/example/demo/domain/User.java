package com.example.demo.domain;

    public class User {
        private final long id;
        private String name;

        public User(long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void changeName(String newName) {
            this.name = newName;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

