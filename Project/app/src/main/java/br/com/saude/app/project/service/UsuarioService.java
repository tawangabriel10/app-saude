package br.com.saude.app.project.service;


import br.com.saude.app.project.model.dto.LoginDTO;
import br.com.saude.app.project.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by tawan on 4/2/17.
 */
public interface UsuarioService {

    @Headers({"Content-Type: application/json"})
    @GET("usuario/login")
    Call<Usuario> autenticarUsuario(@Body LoginDTO dados);
}
