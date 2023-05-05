import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordValidator {

    public static ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }

        int numCount = 0;
        int capCount = 0;
        int specialCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numCount++;
            } else if (Character.isUpperCase(c)) {
                capCount++;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }

        if (numCount < 2) {
            errors.add("The password must contain at least 2 numbers");
        }

        if (capCount < 1) {
            errors.add("Password must contain at least one capital letter");
        }

        if (specialCount < 1) {
            errors.add("Password must contain at least one special character");
        }

        if (errors.isEmpty()) {
            return new ValidationResult(true, Collections.emptyList());
        } else {
            return new ValidationResult(false, errors);
        }
    }

    public static class ValidationResult {
        private final boolean valid;
        private final List<String> errors;

        public ValidationResult(boolean valid, List<String> errors) {
            this.valid = valid;
            this.errors = errors;
        }

        public boolean isValid() {
            return valid;
        }

        public List<String> getErrors() {
            return errors;
        }
    }
}