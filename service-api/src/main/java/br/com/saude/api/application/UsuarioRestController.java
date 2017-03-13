package br.com.saude.api.application;

import br.com.saude.api.domain.dto.LoginDTO;
import br.com.saude.api.domain.entity.Usuario;
import br.com.saude.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by tawan on 2/27/17.
 */
@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity acessarSistema(@RequestBody LoginDTO dados) {
        usuarioService.autenticarLogin(dados);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity salvarUsuario(@RequestBody Usuario usuario) {
        usuario = usuarioService.salvar(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> buscar() {
        return new ResponseEntity<List<Usuario>>(usuarioService.buscar(), HttpStatus.OK);
    }
}
