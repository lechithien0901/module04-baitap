package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDto implements Validator {
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public UserDto(Long id, String firstname, String lastname, String phoneNumber, Double age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Double age;
    private String email;

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    public static boolean ValidaterName(String name){
        String nameRegex = "^[a-zA-Z\\s]{5,45}$";
        Pattern pattern=Pattern.compile(nameRegex);
        Matcher matcher=pattern.matcher(name);
        return matcher.matches();

    }
    public static boolean ValidatePhoneNumber(String phoneNumber){

        String phoneRegex="^[0-9]{10,11}$";
        Pattern pattern=Pattern.compile(phoneRegex);
        Matcher matcher=pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean ValidateAge(Double age){
      String ageString=String.valueOf(age);
        String doubleRegex = "^[+\\-]?[0-9]*\\.?[0-9]+$";
        Pattern pattern = Pattern.compile(doubleRegex);
        Matcher matcher = pattern.matcher(ageString);
      if (matcher.matches()){
          Double ageNew=Double.parseDouble(ageString);
          return ageNew>=18.0;
      };
      return false;
    }
    public static boolean ValidateEmail(String email){
        String regex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto=(UserDto) target;
        String firstName=userDto.getFirstname();
        String lastName=userDto.getLastname();
        String phoneNumber=userDto.getPhoneNumber();
        Double age=userDto.getAge();
        String email=userDto.getEmail();

        if (!ValidaterName(firstName)){
            errors.rejectValue("firstname","","Firstname,bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự ");
        }
        if (!ValidaterName(lastName)){
            errors.rejectValue("lastname",""," lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự");
        }
        if (!ValidatePhoneNumber(phoneNumber)){
            errors.rejectValue("phoneNumber","","Phonenumber chưa đúng quy tắc của sđt");
        }
        if (!ValidateAge(age)){
            errors.rejectValue("age","","Bạn không đủ điều kiện theo yêu cầu tuổi hoặc đã nhập không đúng định dạng.");

        }
        if (!ValidateEmail(email)){
            errors.rejectValue("email","","Email của bạn không đúng định dạng hoặc không tồn tại ");
        }

    }
}
