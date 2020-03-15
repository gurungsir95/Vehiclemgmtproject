package com.app.mgmt.exception;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.http.HttpStatus;
@XmlRootElement(name =  "errorMessage")
public class ErrorMessage {
 private String errormsg;
 private List<String> errorDetails;
 
 private HttpStatus errorStatus;
 public String getErrormsg() {
  return errormsg;
 }
 public void setErrormsg(String errormsg) {
  this.errormsg = errormsg;
 }

 public List<String> getErrorDetails() {
  return errorDetails;
 }
 public void setErrorDetails(List<String> errorDetails) {
  this.errorDetails = errorDetails;
 }
 public HttpStatus getErrorStatus() {
  return errorStatus;
 }
 public void setErrorStatus(HttpStatus errorStatus) {
  this.errorStatus = errorStatus;
 }
  
}
