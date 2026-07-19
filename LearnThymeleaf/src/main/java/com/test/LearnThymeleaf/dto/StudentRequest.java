package com.test.LearnThymeleaf.dto;

import com.test.LearnThymeleaf.enums.Gender;
import com.test.LearnThymeleaf.enums.StudentStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentRequest {

    @NotBlank(message = "First Name is required.")
    private String firstName;

    @NotBlank(message = "Last Name is required.")
    private String lastName;

    @Email(message = "Please enter a valid Email address.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Phone is required.")
    private String phone;

    @NotBlank(message = "Course  is required")
    private String course;

    @NotNull(message = "Age is required.")
    @Min(value = 16, message = "Minimum age is 16.")
    private Integer age;

    @NotNull(message = "Gender is required.")
    private Gender gender;

    @NotNull(message = "Status is required.")
    private StudentStatus status;

}
