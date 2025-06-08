package com.project.BlogApp.paylod;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Use to transfer data

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotEmpty
    @Size(min =4, message = "Size should be of minimum 4 characters." )
    private String name;

    @Email(message = "Not a Valid Email.")
    private String email;
   // @NotNull
   @NotEmpty
   @Size(min =6, max = 18, message = "Size should be of minimum 6 and maximum 18 characters." )
    private String password;

    @NotNull
    private String about;

}
