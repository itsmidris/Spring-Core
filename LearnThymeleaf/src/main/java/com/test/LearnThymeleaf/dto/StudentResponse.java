package com.test.LearnThymeleaf.dto;

import com.test.LearnThymeleaf.enums.Gender;
import com.test.LearnThymeleaf.enums.StudentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String course;

    private Integer age;

    private Gender gender;

    private StudentStatus status;
}
