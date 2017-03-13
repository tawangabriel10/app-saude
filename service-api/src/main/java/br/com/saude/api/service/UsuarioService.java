package br.com.saude.api.service;

import br.com.saude.api.domain.dto.LoginDTO;
import br.com.saude.api.domain.entity.Usuario;
import br.com.saude.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by tawan on 2/27/17.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario autenticarLogin(LoginDTO dados) {
        return usuarioRepository.findEmailAndSenha(dados.getEmail(), dados.getSenha());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscar() {
        return usuarioRepository.findAll();
    }
}
