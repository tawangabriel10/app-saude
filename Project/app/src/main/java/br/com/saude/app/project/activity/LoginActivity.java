package br.com.saude.app.project.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.saude.app.project.R;
import br.com.saude.app.project.model.Usuario;
import br.com.saude.app.project.model.dto.LoginDTO;
import br.com.saude.app.project.service.UsuarioService;
import br.com.saude.app.project.util.RestUtil;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.emailLogin)
    private EditText email;

    @BindView(R.id.senhaLogin)
    private EditText senha;

    private Retrofit retrofit;

    private UsuarioService usuarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = new Retrofit.Builder()
                .baseUrl(RestUtil.getURLBASE())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        email = (EditText) findViewById(R.id.emailLogin);
        senha = (EditText) findViewById(R.id.senhaLogin);

    }

    public void entrarOnClick(View v) {
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Acessando sistema", true);

        LoginDTO dados = new LoginDTO(
            email.getText().toString(),
            senha.getText().toString()
        );
        usuarioService = retrofit.create(UsuarioService.class);

        Call<Usuario> resposta = usuarioService.autenticarUsuario(dados.getEmail(), dados.getSenha());
        resposta.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                dialog.hide();

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                dialog.hide();

                String mensagemErro = getString(R.string.erro_autenticao);
                Toast toast = Toast.makeText(LoginActivity.this, mensagemErro,
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
