public class Main {
    public static void main(String[] args) {
        String[] passwords = {"test", "test123", "Test123", "Testest123!"};

        for (String password : passwords) {
            Validator.ValidationResult result = Validator.validate(password);
            if (result.isValid()) {
                System.out.println("Password \"" + password + "\" is valid");
            } else {
                System.out.println("Password \"" + password + "\" is invalid:");
                for (String error : result.getErrors()) {
                    System.out.println("- " + error);
                }
            }
        }
    }
}