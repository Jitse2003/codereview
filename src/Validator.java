import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator {
    public static ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters");
        }
        int digitCount = 0;
        int uppercaseCount = 0;
        int specialCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }
        if (digitCount < 2) {
            errors.add("The password must contain at least 2 numbers");
        }

        if (uppercaseCount < 1) {
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