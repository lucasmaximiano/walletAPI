package com.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * UserDTO
 */
@Data
public class UserDTO {

    private long id;

    @Length(min = 3, max = 50, message = "O Nome deve conter entre 3 e 50 caracteres")
    private String name;

    @NotNull
    @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
    private String password;

    @Email(message = "Email inválido")
    private String email;

}