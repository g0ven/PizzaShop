package by.pizzasp.ics.exception.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {

    private List<String> errors = new ArrayList<>();

    public ValidationErrorDTO() {}

    public void addValidationError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }


}
