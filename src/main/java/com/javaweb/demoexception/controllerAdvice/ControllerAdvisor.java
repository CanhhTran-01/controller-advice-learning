package com.javaweb.demoexception.controllerAdvice;

import com.javaweb.demoexception.exception.FieldRequiredException;
import com.javaweb.demoexception.model.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    // exception 1
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handlerArithmeticException(ArithmeticException ex, WebRequest request){

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorName(ex.getMessage());

        List<String> details = new ArrayList<>();
        details.add("số nguyên làm sao chia được cho 0");
        details.add("cần ôn lại kiến thức cấp 1!");
        errorResponseDTO.setDetailError(details);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // exception 2
    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handlerFieldRequiredException(FieldRequiredException ex, WebRequest request){

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorName(ex.getMessage());

        List<String> details = new ArrayList<>();
        details.add("check lại name hoặc numberOfBasement xem có null hay không");
        details.add("nhớ ôn tập kĩ 1 chút cái Exception Handler");
        errorResponseDTO.setDetailError(details);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
    }
}
