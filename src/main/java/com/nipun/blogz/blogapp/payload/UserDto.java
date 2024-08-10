package com.nipun.blogz.blogapp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 3, message="Username must be of minimum 3 characters")
    private String name;
    @NotEmpty
    @Email(message="Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min=3, max = 10, message = "Password must be of minimum 3 characters and maximum 10 characters")
    private String password;
    @NotEmpty
    private String about;
}
