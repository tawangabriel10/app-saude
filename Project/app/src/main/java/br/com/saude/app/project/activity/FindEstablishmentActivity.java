package br.com.saude.app.project.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.saude.app.project.R;
import br.com.saude.app.project.adapter.ListaEstabelecimentoAdapter;
import br.com.saude.app.project.component.Page;
import br.com.saude.app.project.exception.EstabelecimentoException;
import br.com.saude.app.project.model.Estabelecimento;
import br.com.saude.app.project.service.EstabelecimentoService;
import br.com.saude.app.project.util.RestUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindEstablishmentActivity extends AppCompatActivity {

    @BindView(R.id.listaEstabelecimento)
    ListView listView;

    private Retrofit retrofit;

    private EstabelecimentoService estabelecimentoService;

    List<Estabelecimento> estabelecimentoList;
    ArrayList<Estabelecimento> selectedEstabelecimentos = new ArrayList<>();
    Estabelecimento estabelecimentoSelecionado;

    ListaEstabelecimentoAdapter listaEstabelecimentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_establishment);
        ButterKnife.bind(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(RestUtil.URL_BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ProgressDialog dialog = ProgressDialog.show(this, "", "Buscando estabelecimentos...", true);

        estabelecimentoService = retrofit.create(EstabelecimentoService.class);
        Call<List<Estabelecimento>> resposta = estabelecimentoService.buscarEstabelecimentos(1, 10);

        resposta.enqueue(new Callback<List<Estabelecimento>>() {
            @Override
            public void onResponse(Call<List<Estabelecimento>> call, Response<List<Estabelecimento>> response) {

                estabelecimentoList = response.body();
                listaEstabelecimentoAdapter = new ListaEstabelecimentoAdapter(estabelecimentoList, FindEstablishmentActivity.this);
                listView.setAdapter(listaEstabelecimentoAdapter);
                listView.setDivider(null);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        estabelecimentoSelecionado = (Estabelecimento) parent.getItemAtPosition(position);
                    }
                });

                dialog.hide();
            }

            @Override
            public void onFailure(Call<List<Estabelecimento>> call, Throwable t) {
                new EstabelecimentoException("Falha ao buscar Estabelecimentos de Saúde.");
                dialog.hide();

            }
        });
    }
}
