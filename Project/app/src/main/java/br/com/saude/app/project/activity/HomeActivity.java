package br.com.saude.app.project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.saude.app.project.R;

/**
 * Created by tawan on 3/2/17.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void acessarBuscarEstabelecimentos(View view) {
        Intent intent = new Intent(this, FindEstablishmentActivity.class);
        startActivity(intent);
    }
}
