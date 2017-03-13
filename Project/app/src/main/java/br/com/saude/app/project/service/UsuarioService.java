package br.com.saude.app.project.service;

import org.json.JSONArray;

import br.com.saude.app.project.component.NetworkRequestCallback;
import br.com.saude.app.project.component.RequestResponseInterface;
import br.com.saude.app.project.util.HttpUtil;
/*
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/

/**
 * Created by tawan on 3/2/17.
 */

public class UsuarioService {

    private HttpUtil httpUtil = HttpUtil.getInstance();

    private static final String URL ="http://localhost:8080/usuario";

    /*private void checkLogin(Context context) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>().Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       Log.d("TESTE", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TESTE", "Deu erro;");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }*/

    public void buscarUsuario(String TAG, RequestResponseInterface callback) {

      //  NetworkRequestCallback<JSONArray> callback = (JSONArray jsonObject) -> {return jsonObject.toString();};
        httpUtil.doGetArray(
                URL,
                TAG,
                new NetworkRequestCallback<JSONArray>() {
                    @Override
                    public void onRequestResponse(JSONArray jsonObject) {
                        callback.onRequestResponse(jsonObject.toString());
                    }
                  @Override
                    public void onRequestError(Exception error) {
                        System.out.print(error.getMessage());
                    }
                });
    }

}
