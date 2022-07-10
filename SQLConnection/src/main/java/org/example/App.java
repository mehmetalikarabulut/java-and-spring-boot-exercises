package org.example;

import java.util.List;

public class App {
    public static void main(String[] args) {

        UserService service = new UserService();

        int status = service.userInsert("Mehmet Ali", "Karabulut", "mehmetalikarabulutt@gmail.com", "12345", "2022-07-10");
        System.out.printf("Status : " + status);

        int status2 = service.userUpdate("Mehmet", "Karabulut", 11);

        int status3 = service.userDelete(12);

    }
}