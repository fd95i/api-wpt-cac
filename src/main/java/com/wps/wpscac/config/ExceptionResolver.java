package com.wps.wpscac.config;

import com.wps.wpscac.contact.exception.ContactNotFoundException;
import com.wps.wpscac.products.exception.ProductNotFoundException;
import com.wps.wpscac.utils.ApiError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice(basePackages = "com")
public class ExceptionResolver extends DefaultHandlerExceptionResolver {

    @ExceptionHandler({ContactNotFoundException.class, ProductNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(Exception e, HttpServletRequest req) {
        return ApiError.forException(e, HttpStatus.NOT_FOUND.value(), req);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handle(Exception e, HttpServletRequest req) {
        return ApiError.forException(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), req);
    }
}
