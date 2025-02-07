package org.example.novproductservice.ControllerAdvice;

import org.example.novproductservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "Arithmetic exception from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundExceptionException() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "ProductNotFoundException from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }
}