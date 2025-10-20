package com.project.genomebankapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
    private String nombre;
    private String email;
    private String password;
    private String rol;
}
