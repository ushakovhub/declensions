package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.DeclensionRules;
import model.Firstname;
import model.Lastname;
import model.Middlename;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class DeclensionRulesService {
    private DeclensionRules declensionRules;

    public DeclensionRulesService() {
        this.declensionRules = new DeclensionRules();
    }

    private DeclensionRules getRules() {
        try {
            GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
            Gson gson = builder.create();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/rules.json"), StandardCharsets.UTF_8);
            declensionRules = gson.fromJson(reader,DeclensionRules.class);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return declensionRules;
    }

    private String firstCharUpperCase(String name){
        if(name == null || name.isEmpty()) {
            return "";
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private String findLastNameRule(String name, String caseName, String gender, DeclensionRules rules){
        ArrayList<Lastname> lastNameRules =  rules.getLastname();
        ArrayList<Lastname> selectRulesOfGender = new ArrayList<>();
        String selectLastNameMod = "";

        for (Lastname lastNameRule: lastNameRules) {
            if (gender.equals(lastNameRule.getGender())) {
                selectRulesOfGender.add(lastNameRule);
            }
        }

        stop: for (Lastname lastnameRule: selectRulesOfGender) {
            for (int i = 0; i < lastnameRule.getEnding().size(); i++) {
                if(name.endsWith(lastnameRule.getEnding().get(i))){
                    selectLastNameMod = lastnameRule.getMods().getCase(caseName);
                    break stop;
                }
            }
        }
        return selectLastNameMod;
    }

    private String findFirstNameRule(String name, String caseName, String gender, DeclensionRules rules){
        ArrayList<Firstname> firstNameRules =  rules.getFirstname();
        ArrayList<Firstname> selectRulesOfGender = new ArrayList<>();
        String selectFirstNameMod = "";

        for (Firstname firstNameRule: firstNameRules) {
            if (gender.equals(firstNameRule.getGender())) {
                selectRulesOfGender.add(firstNameRule);
            }
        }

        stop: for (Firstname firstNameRule: selectRulesOfGender) {
            for (int i = 0; i < firstNameRule.getEnding().size(); i++) {
                if(name.endsWith(firstNameRule.getEnding().get(i))){
                    selectFirstNameMod = firstNameRule.getMods().getCase(caseName);
                    break stop;
                }
            }
        }
        return selectFirstNameMod;
    }

    private String findMiddleNameRule(String name, String caseName, String gender, DeclensionRules rules){
        ArrayList<Middlename> middleNameRules =  rules.getMiddlename();
        ArrayList<Middlename> selectRulesOfGender = new ArrayList<>();
        String selectMiddleNameMod = "";

        for (Middlename middleNameRule: middleNameRules) {
            if (gender.equals(middleNameRule.getGender())) {
                selectRulesOfGender.add(middleNameRule);
            }
        }

        stop: for (Middlename middleNameRule: selectRulesOfGender) {
            for (int i = 0; i < middleNameRule.getEnding().size(); i++) {
                if(name.endsWith(middleNameRule.getEnding().get(i))){
                    selectMiddleNameMod = middleNameRule.getMods().getCase(caseName);
                    break stop;
                }
            }
        }
        return selectMiddleNameMod;
    }

    private String convertName(String name, String nameMod){
        for (int i = 0; i < nameMod.length(); i++) {
            Character chrLastNameMod = nameMod.charAt(i);
            switch (chrLastNameMod) {
                case '*':
                    break;
                case '-':
                    name = name.substring(0, name.length() - 1);
                    break;
                default:
                    name += chrLastNameMod;
            }
        }
        return name;
    }

    public String applyRule(Map<String, String> fullName, String caseName, String gender){
        String lastName = convertName(fullName.get("lastname"), findLastNameRule(fullName.get("lastname"), caseName, gender, getRules()));
        String firstName = convertName(fullName.get("firstname"), findFirstNameRule(fullName.get("firstname"), caseName, gender, getRules()));
        String middleName = convertName(fullName.get("middlename"), findMiddleNameRule(fullName.get("middlename"), caseName, gender, getRules()));
        return firstCharUpperCase(lastName) + " " + firstCharUpperCase(firstName) + " " + firstCharUpperCase(middleName);
    }
}