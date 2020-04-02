package com.switchfully.order.service.validation;

import com.switchfully.order.domain.exceptions.EmailNotValidException;

import java.io.IOException;

public class Validation {
    public static void isValidEmailAddress(String email) throws IOException {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if(!m.matches()) {
            throw new EmailNotValidException(email);
        }
    }
}
