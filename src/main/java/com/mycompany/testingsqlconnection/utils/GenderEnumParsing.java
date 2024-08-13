package com.mycompany.testingsqlconnection.utils;

import com.mycompany.testingsqlconnection.model.Gender;

public class GenderEnumParsing {



    public static Gender parseGender(String gender) {
        switch(gender) {
            case "MALE":
                return Gender.MALE;
            case "FEMALE":
                return Gender.FEMALE;
            case "OTHER":
                return Gender.OTHER;
            default: return null;
        }
    }

}
