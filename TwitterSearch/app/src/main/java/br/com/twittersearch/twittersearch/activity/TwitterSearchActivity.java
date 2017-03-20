package br.com.twittersearch.twittersearch.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import br.com.twittersearch.twittersearch.R;

public class TwitterSearchActivity extends AppCompatActivity {

    private ListView lista;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_search);

        lista = (ListView) findViewById(R.id.lista);
        texto = (EditText) findViewById(R.id.texto);
    }

    public void buscar(View v) {
        private class TwitterTask extends AsyncTask<String, Void, String[]> {
            ProgressDialog dialog;
            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(TwitterSearchActivity.this);
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

}
