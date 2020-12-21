package com.exeptionhandler;

import java.io.IOException;

import com.exeptionhandler.TestExep;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BindException.class)
    private ModelAndView processInvalidData(BindException ex) {
        StringBuilder error = new StringBuilder();
        for (ObjectError objectError: ex.getAllErrors()) {
            error.append(objectError.getDefaultMessage());
            error.append("<br/>");
        }
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", error);
        return model;
    }

    @ExceptionHandler(IOException.class)
    private ModelAndView processIOException(IOException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", ex.getMessage());
        return model;
    }

    @ExceptionHandler(NullPointerException.class)
    private String NullPointerException() {
        return "redirect:/";
    }

    @ExceptionHandler(TestExep.class)
    private String TestExep() {
        return "redirect:/";
    }
}
