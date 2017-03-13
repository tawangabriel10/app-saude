package br.com.saude.app.project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;

import br.com.saude.app.project.R;
import br.com.saude.app.project.component.NetworkRequestCallback;
import br.com.saude.app.project.service.UsuarioService;

/**
 * Created by tawan on 3/3/17.
 */

public class FindUserActivity extends AppCompatActivity {

    private static final String TAG = "FindUserActivity";

    private static final String URL ="http://localhost:8080/usuario";

    private Button btnBuscarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

    }

    public void buscarUserOnClick(View v) {
        UsuarioService us = new UsuarioService();
        us.buscarUsuario(TAG, x -> {
            Log.d(TAG, x.toString());});
    }

}
