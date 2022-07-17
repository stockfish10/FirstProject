package com.firstownproject.FirstProject.model.dto;

import com.firstownproject.FirstProject.model.validation.PasswordMatch;
import com.firstownproject.FirstProject.model.validation.UniqueEmail;
import com.firstownproject.FirstProject.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@PasswordMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords must match"
)
public class UserRegisterDTO {

    @NotEmpty(message = "Username cannot be empty.")
    @Size(min = 3,max = 20,message = "Username must be between 3 and 20 characters.")
    @UniqueUsername(message = "Username already exists.")
    private String username;

    @Email(message = "Invalid email address.")
    @NotEmpty(message = "Email cannot be empty.")
    @UniqueEmail(message = "Email already used.")
    private String email;

    @NotEmpty(message = "Please type in your first name")
    @Size(min = 2,max = 30,message = "First name cannot be less than 2 or more than 30 characters.")
    private String firstName;

    @NotEmpty(message = "Please type in your last name")
    @Size(min = 2,max = 30,message = "Last name cannot be less than 2 or more than 30 characters.")
    private String lastName;

    @NotEmpty(message = "Password is required")
    @Size(min = 4,max = 20,message = "Password must be between 4 and 20 symbols")
    private String password;

    @NotEmpty
    @Size(min = 4,max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
