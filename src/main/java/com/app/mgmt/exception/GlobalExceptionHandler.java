package com.app.mgmt.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
 
 @ExceptionHandler(value= {CustomException.class})
 public ResponseEntity<ErrorMessage> customException(Exception exception ,WebRequest webRequest){
  ErrorMessage errorMessage =  new ErrorMessage();
  errorMessage.setErrormsg(exception.getMessage());
  List<String> details = new ArrayList<>();
  details.add(exception.getLocalizedMessage());
  errorMessage.setErrorDetails(details);
  errorMessage.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR);
  return new  ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
 }
}

