package br.com.saude.api.init;


import br.com.saude.api.domain.entity.Usuario;
import br.com.saude.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tawan on 2/27/17.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InicializarUsuario {

    private final static String NOME_USUARIO = "Tawan Gabriel";

    private final static String EMAIL_USUARIO = "tawan.gabriel10@gmail.com";

    private final static String SENHA_USUARIO = "1234";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @EventListener
    public void inicializarUsuarioAdmin(ApplicationReadyEvent event) {
        List<Usuario> usuarios = usuarioRepository.findByNome(NOME_USUARIO);

        if (usuarios.isEmpty()) {
            usuarioRepository.save(new Usuario(NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO));
        }
    }
}
