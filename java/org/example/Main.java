package org.example;


import org.example.service.AuthService;
import org.example.service.AuthServiceImpl;

public class Main {
    public static void main(String[] args) {
        final AuthService authService = new AuthServiceImpl();
        User Ivan = authService.registerNewUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        try {
            System.out.println(Ivan.toString());
        } catch (NullPointerException e){
            System.out.println("No users were created!");
        }

    }
}