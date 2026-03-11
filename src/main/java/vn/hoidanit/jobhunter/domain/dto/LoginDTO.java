package vn.hoidanit.jobhunter.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public class LoginDTO {

    @NotBlank(message = "Username khong duoc de trong")
    private String username;
    @NotBlank(message = "Password khong duoc de trong")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
