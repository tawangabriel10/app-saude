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
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindEstablishmentActivity extends AppCompatActivity {

    @BindView(R.id.listaEstabelecimento)
    ListView listView;

    @Inject
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

        final ProgressDialog dialog = ProgressDialog.show(this, "", "Loading. Please wait...", true);
        estabelecimentoService.buscarEstabelecimentos(1, 10, new Callback<Page<Estabelecimento>>() {
            @Override
            public void onResponse(Call<Page<Estabelecimento>> call, Response<Page<Estabelecimento>> response) {
                try {
                    response = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                estabelecimentoList = response.body().getContent();
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
            public void onFailure(Call<Page<Estabelecimento>> call, Throwable t) {
                new EstabelecimentoException("Falha ao buscar Estabelecimentos de Saúde.");
                dialog.hide();

            }
        });
    }
}
