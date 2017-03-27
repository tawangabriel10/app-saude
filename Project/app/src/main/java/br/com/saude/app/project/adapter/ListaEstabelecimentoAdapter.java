package br.com.saude.app.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.saude.app.project.R;
import br.com.saude.app.project.activity.FindEstablishmentActivity;
import br.com.saude.app.project.model.Estabelecimento;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tawan on 3/26/17.
 */
public class ListaEstabelecimentoAdapter extends BaseAdapter {

    @BindView(R.id.establishment_nome_fantasia)
    TextView nomeFantasia;

    @BindView(R.id.establishment_descricao_completa)
    TextView descricaoCompleta;

    @BindView(R.id.body_establishment)
    RelativeLayout layout;

    private List<Estabelecimento> estabelecimentos;
    private FindEstablishmentActivity findEstablishmentActivity;



    public ListaEstabelecimentoAdapter(List<Estabelecimento> estabelecimentos, FindEstablishmentActivity findEstablishmentActivity) {
        this.estabelecimentos = estabelecimentos;
        this.findEstablishmentActivity = findEstablishmentActivity;
    }

    @Override
    public int getCount() {
        return getEstabelecimentos().size();
    }

    @Override
    public Estabelecimento getItem(int position) {
        return getEstabelecimentos().get(position);
    }

    @Override
    public long getItemId(int position) {
        return getEstabelecimentos().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Estabelecimento estabelecimento = getEstabelecimentos().get(position);

        LayoutInflater inflater = findEstablishmentActivity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_establishment_list, null);
        ButterKnife.bind(this, view);

        nomeFantasia.setText(estabelecimento.getNomeFantasia());
        descricaoCompleta.setText(estabelecimento.getDescricaoCompleta());

        return view;
    }

    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }
}
