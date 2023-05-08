package org.example.service;

import org.example.User;
import org.example.exceptions.ForbiddenSymbolException;
import org.example.exceptions.WrongLoginException;
import org.example.exceptions.WrongPasswordException;

public class AuthServiceImpl implements AuthService {
    private final String regEx = "\\w";

    public AuthServiceImpl() {
    }

    @Override
    public User registerNewUser(String login, String password, String confirmPassword){
        try {
            checkPassword(password);
            if(!password.equals(confirmPassword)){
                throw new WrongPasswordException("Passwords don't match!");
            }
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println("Inappropriate login!");
            return null;
        } catch (WrongPasswordException e){
            System.out.println("Inappropriate password!");
            return null;
        }

        return new User(login, password);
    }

    @Override
    public void checkLogin(String login) throws WrongLoginException {
        //латицина, цифры, прочерк, <= 20
        if (login.length() > 20) {
            throw new WrongLoginException("Login must not be longer than 20 symbols!");
        } else {
            try {
                checkInput(login);
            } catch (ForbiddenSymbolException e) {
                throw new WrongLoginException("Forbidden symbol in login!", e);
            }
        }
    }


    @Override
    public void checkPassword(String password) throws WrongPasswordException {
        //латицина, цифры, прочерк, < 20
        if (password.length() >= 20) {
            throw new WrongPasswordException("Login must be shorter than 20 symbols!");
        } else {
            try {
                checkInput(password);
            } catch (ForbiddenSymbolException e) {
                throw new WrongPasswordException("Forbidden symbol in password!", e);
            }
        }
    }

    private void checkInput(String string) throws ForbiddenSymbolException {
        for (int i = 0; i < string.length(); i++) {
            if (!string.substring(i, i + 1).matches(regEx)) {
                throw new ForbiddenSymbolException(string.charAt(i) + "is forbidden!");
            }
        }
    }

}

