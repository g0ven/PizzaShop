package by.pizzasp.ics.controller;

import by.pizzasp.ics.exception.AccessDataError;
import by.pizzasp.ics.exception.dto.ErrorDTO;

import by.pizzasp.ics.exception.dto.ValidationErrorDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ErrorHandlerController {

    private static final Logger LOGGER = LogManager.getLogger();



    @ExceptionHandler(AccessDataError.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorDTO handleAccessDataErrorException(AccessDataError ex) {
        ErrorDTO er = new ErrorDTO(ex.getMessage());
        LOGGER.error("handleAccessDataErrorException: ErrorDTO={}",er);
        return er;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public @ResponseBody
    ValidationErrorDTO handleErrorException(MethodArgumentNotValidException ex) {
        ValidationErrorDTO error = new ValidationErrorDTO();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        LOGGER.error("handleErrorException:");
        return error;
    }
    }


