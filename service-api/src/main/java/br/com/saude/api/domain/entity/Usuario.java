package br.com.saude.api.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by tawan on 2/27/17.
 */
@Getter
@Setter
@Entity
@Table(name = "tb_usuario", schema = "appsaude")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "appsaude.tb_usuario_seq", name = "tb_usuario_seq")
    @GeneratedValue(generator = "tb_usuario_seq", strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "ds_nome")
    private String nome;

    @NotEmpty
    @Column(name = "ds_email")
    private String email;

    @NotEmpty
    @Column(name = "ds_senha")
    private String senha;

    public Usuario() {}

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
