package br.com.saude.app.project.model.dto;

import java.io.Serializable;

/**
 * Created by tawan on 4/2/17.
 */
public class LoginDTO implements Serializable {

    private String email;

    private String senha;

    public LoginDTO(){}

    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
