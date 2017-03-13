package br.com.saude.api.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tawan on 2/27/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginDTO implements Serializable {

    private String email;

    private String senha;
}
