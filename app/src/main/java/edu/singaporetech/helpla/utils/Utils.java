package edu.singaporetech.helpla.utils;

public class Utils {

    private Utils() {
        throw new AssertionError();
    }

    public static boolean validateEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern)){
            return true;
        }
        return false;
    }


}
