import services.DeclensionService;

public class App {
    public static void main(String[] args) {
        /*
          Case names:
          genitive - родительный
          dative - дательный
          accusative - винительный
          instrumental - творительный
          prepositional - предложный
        */
        DeclensionService declensionService = new DeclensionService();
        String test = declensionService.getDeclension("Тестов", "Тест", "Тестович", "instrumental");
        System.out.println(test);
    }
}