package com.springmvcjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class RegisterDto {


    @NotEmpty(message = "email alanını boş geçemezsiniz")
    @Email(message = "lütfen geçerli bir email giriniz")
    private String email;

    @NotEmpty(message = "name alanını boş geçemezsiniz")
    private String name;

    @NotEmpty(message = "surname alanını boş geçemezsiniz")
    private String surname;

    @NotEmpty(message = "password alanını boş geçemezsiniz")
    @Size(min = 6,max = 16)
    private String password;
}
