package br.com.saude.app.project.service;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

import br.com.saude.app.project.component.Page;
import br.com.saude.app.project.model.Estabelecimento;
import br.com.saude.app.project.model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tawan on 3/23/17.
 */
public interface EstabelecimentoService {

    @Headers({"Content-Type: application/json"})
    @GET("estabelecimento/buscar/{offset}/{limit}")
    Call<List<Estabelecimento>> buscarEstabelecimentos(@Path("offset") int offset,
                     @Path("limit") int limit);

}
