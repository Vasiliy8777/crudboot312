package com.example.crud231.util;

import com.example.crud231.dao.UserDao;
import com.example.crud231.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;


import javax.validation.Validator;


public class UserValidator implements Validator {

    private final UserDao userDao;

    @Autowired
    public UserValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userDao.show(user.getEmail()).isPresent()) {
            // поле, код ошибки, сообщение ошибки
            errors.rejectValue("email", "", "This email is already in use");
        }

        // Проверяем, что у человека имя начинается с заглавной буквы
        // Если имя не начинается с заглавной буквы - выдаем ошибку
        if (!Character.isUpperCase(user.getName().codePointAt(0)))
            errors.rejectValue("name", "", "Name should start with a capital letter");
    }
}
