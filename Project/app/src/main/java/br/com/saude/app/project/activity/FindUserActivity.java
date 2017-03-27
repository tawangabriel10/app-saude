package br.com.saude.app.project.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import br.com.saude.app.project.R;
import br.com.saude.app.project.model.Usuario;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tawan on 3/3/17.
 */
public class FindUserActivity extends AppCompatActivity {

    private static final String TAG = "FindUserActivity";

    @BindView(R.id.lista)
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

    }

    @OnClick(R.id.btnListaUsuario)
    public void buscarUserOnClick(View v) {
        new UsuarioTask().execute();
    }

    private class UsuarioTask extends AsyncTask<String, Void, Usuario> {

        ProgressDialog dialog;

        @Override
        protected Usuario doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(FindUserActivity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Usuario result) {
            if(result != null){
                ArrayAdapter<Usuario> adapter =
                        new ArrayAdapter<Usuario>(getBaseContext(),
                                android.R.layout.simple_list_item_1, Arrays.asList(result));
                lista.setAdapter(adapter);
            }
            dialog.dismiss();
        }
    }

}
