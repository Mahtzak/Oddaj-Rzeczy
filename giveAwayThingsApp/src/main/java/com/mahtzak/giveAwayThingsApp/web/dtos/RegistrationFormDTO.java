package com.mahtzak.giveAwayThingsApp.web.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {

    @NotNull
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",
    message="Nieprawidłowy format email")
    //@Size(min=5)
    private String email;
    @NotNull
    @Size(min=3, message="Nazwa użytkownika musi mieć co najmniej 3 znaki")
    private String username;
    @NotNull @Size(min = 8, max = 20,
            message="Hasło musi zawierać od 8 do 20 znaków")
    private String password;
    @NotNull @Size(min = 8, max = 20,
            message="Hasło musi zawierać od 8 do 20 znaków")
    private String confirmedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistrationFormDTO email(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RegistrationFormDTO username(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationFormDTO password(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public RegistrationFormDTO confirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
        return this;
    }


}