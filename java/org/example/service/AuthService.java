package org.example.service;

import org.example.User;
import org.example.exceptions.WrongLoginException;
import org.example.exceptions.WrongPasswordException;

public interface AuthService {

    User registerNewUser(String login, String password, String confirmPassword);

    void checkLogin(String login) throws WrongLoginException;

    void checkPassword(String password) throws WrongPasswordException;

}
