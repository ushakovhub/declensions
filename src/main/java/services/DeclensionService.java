package services;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class DeclensionService {
    private Map<String, String> fullName;
    private DeclensionRulesService declensionRulesService;
    private GenderService genderService;

    public DeclensionService() {
        genderService = new GenderService();
        declensionRulesService = new DeclensionRulesService();
    }

    public String getDeclension(String lastName, String firstName, String middleName, String caseName) {
        try {
            if(lastName.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || caseName.isEmpty()){
                throw new Exception("Значения полей не должны быть пустыми");
            }
            fullName = new HashMap<>();
            fullName.put("lastname", lastName.toLowerCase(Locale.ROOT));
            fullName.put("firstname", firstName.toLowerCase(Locale.ROOT));
            fullName.put("middlename", middleName.toLowerCase(Locale.ROOT));

            return declensionRulesService.applyRule(fullName, caseName, genderService.chekGender(fullName));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "Error";
    }
}