package br.com.saude.app.project.model;

import java.io.Serializable;

/**
 * Created by tawan on 3/3/17.
 */

public class Usuario implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    public Usuario() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
