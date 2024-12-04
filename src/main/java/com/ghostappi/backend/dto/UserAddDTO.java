package com.ghostappi.backend.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserAddDTO {
    
    @JsonIgnore
    @Id
    private Integer idUser;

    @NotNull(message = "El nombre no debe ser nulo")
    @NotEmpty(message = "El nombre no debe estar vacío")
    @NotBlank(message = "El nombre no debe contener solo espacios en blanco")
    @Size(min = 2, max = 25, message = "El nombre debe tener entre 2 y 25 caracteres")
    @Column(nullable = false, length = 25)
    private String name;

    @NotNull(message = "El apellido no debe ser nulo")
    @NotEmpty(message = "El apellido no debe estar vacío")
    @NotBlank(message = "El apellido no debe contener solo espacios en blanco")
    @Size(min = 2, max = 25, message = "El apellido debe tener entre 2 y 25 caracteres")
    @Column(nullable = false, length = 25)
    private String lastName;

    @NotNull(message = "El correo no debe ser nulo")
    @NotEmpty(message = "El correo no debe estar vacío")
    //@Email(message = "El correo debe tener un formato válido")
    @Size(max = 50, message = "El correo debe tener un máximo de 50 caracteres")
    @Column(nullable = false, length = 50)
    private String email;

    @NotNull(message = "La contraseña no debe ser nula")
    @NotEmpty(message = "La contraseña no debe estar vacía")
    @Size(min = 6, max = 30, message = "La contraseña debe tener entre 6 y 30 caracteres")
    @Column(nullable = false, length = 30)
    private String password;

    @NotNull(message = "El teléfono no debe ser nulo")
    @NotEmpty(message = "El teléfono no debe estar vacío")
    @Size(min = 10, max = 10, message = "El teléfono debe tener entre 10 y 15 caracteres")
    @Column(nullable = false, length = 15)
    private String phone;

    @NotNull(message = "El género no debe ser nulo")
    @NotEmpty(message = "El género no debe estar vacío")
    @Size(min = 4, max = 10, message = "El género debe tener entre 4 y 10 caracteres")
    @Column(nullable = false, length = 10)
    private String gender;

    @NotNull(message = "El estado no debe ser nulo")
    @Column(nullable = false)
    private Boolean status;

    @NotNull(message = "La fecha de nacimiento no debe ser nula")
    @Column(nullable = false)
    private Date bornDate;

    @NotNull(message = "El estado de cliente no debe ser nulo")
    @Column(nullable = false)
    private Boolean isCostumer;
}
