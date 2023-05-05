public class Main {
    public static void main(String[] args) {
        String[] passwords = {"u ma", "u ma123", "Uma123", "Umama123!"};

        for (String password : passwords) {
            PasswordValidator.ValidationResult result = PasswordValidator.validate(password);
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