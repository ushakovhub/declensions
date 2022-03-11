package services;

import java.util.Map;

public class GenderService {
    public String chekGender(Map<String, String> fullName) {
        String mN = fullName.get("middlename");
        String genderID = "";

        if(mN.endsWith("ич")) {
            genderID = "male";
        }

        if(mN.endsWith("на")) {
            genderID = "female";
        }
        return genderID;
    }
}