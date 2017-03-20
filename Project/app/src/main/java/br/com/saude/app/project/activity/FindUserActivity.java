package br.com.saude.app.project.activity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.saude.app.project.R;
import br.com.saude.app.project.component.NetworkRequestCallback;
import br.com.saude.app.project.service.UsuarioService;
import br.com.saude.app.project.util.HTTPUtils;

/**
 * Created by tawan on 3/3/17.
 */

public class FindUserActivity extends AppCompatActivity {

    private static final String TAG = "FindUserActivity";

    private static final String URL ="http://localhost:8080/usuario";

    private ListView lista;
    private Button btnBuscarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        lista = (ListView) findViewById(R.id.lista);
    }

    public void buscarUserOnClick(View v) {
        new TwitterTask().execute();
    }


    private class TwitterTask extends AsyncTask<String, Void, String[]> {

        ProgressDialog dialog;

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String urlTwitter = "http://localhost:8080/usuario";
                String url = Uri.parse(urlTwitter).toString();

                String conteudo = HTTPUtils.acessar(url);

                JSONObject jsonObject = new JSONObject(conteudo);
                JSONArray resultados = jsonObject.getJSONArray("results");

                String[] tweets = new String[resultados.length()];
                for (int i = 0; i < resultados.length(); i++) {
                    JSONObject tweet = resultados.getJSONObject(i);
                    String texto = tweet.getString("text");
                    String usuario = tweet.getString("from_user");
                    tweets[i] = usuario + " - " + texto;
                }
                return tweets;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(FindUserActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(String[] result) {
            if(result != null){
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(getBaseContext(),
                                android.R.layout.simple_list_item_1, result);
                lista.setAdapter(adapter);
            }
            dialog.dismiss();
        }
    }

}
