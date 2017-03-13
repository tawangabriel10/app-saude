package br.com.saude.api.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by tawan on 2/27/17.
 */
@Getter
@Setter
@Entity
@Table(name = "tb_estabelecimento", schema = "appsaude")
public class Estabelecimento implements Serializable {

    @Id
    @Column(name = "id_estabelecimento")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "appsaude.tb_estabelecimento_seq", name = "tb_estabelecimento_seq")
    @GeneratedValue(generator = "tb_estabelecimento_seq", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_bairro")
    private String bairro;

    @Column(name = "ds_categoria_unidade")
    private String categoriaUnidade;

    @Column(name = "nu_cep")
    private String cep;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "nu_cnpj")
    private String cnpj;

    @Column(name = "nu_codigo_cnes")
    private Long codCnes;

    @Column(name = "nu_codigo_ibge")
    private Long codIbge;

    @Column(name = "nu_codigo_unidade")
    private String codUnidade;

    @Column(name = "ds_descricao_completa")
    private String descricaoCompleta;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_esfera_adminitrativa")
    private String esferaAdministrativa;

    @Column(name = "nu_fluxo_clientela")
    private String fluxoClientela;

    @Column(name = "ds_grupo")
    private String grupo;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "ds_natureza")
    private String natureza;

    @Column(name = "ds_nome_fantasia")
    private String nomeFantasia;

    @Column(name = "nu_numero")
    private String numero;

    @Column(name = "ds_origem_geografica")
    private String origemGeografica;

    @Column(name = "ds_retencao")
    private String retencao;

    @Column(name = "nu_telefone")
    private String telefone;

    @Column(name = "ds_tem_atendimento_ambulatorial")
    private String temAtendimentoAmbulatorial;

    @Column(name = "ds_tem_atendimento_urgencia")
    private String temAtendimentoUrgencia;

    @Column(name = "ds_tem_centro_cirurgico")
    private String temCentroCirurgico;

    @Column(name = "ds_tem_dialise")
    private String temDialise;

    @Column(name = "ds_tem_neo_natal")
    private String temNeoNatal;

    @Column(name = "ds_tem_obstetra")
    private String temObstetra;

    @Column(name = "ds_tipo_unidade")
    private String tipoUnidade;

    @Column(name = "ds_tipo_unidade_cnes")
    private String tipoUnidadeCnes;

    @Column(name = "ds_turno_atendimento")
    private String turnoAtendimento;

    @Column(name = "ds_uf")
    private String uf;

    @Column(name = "ds_vinculo_sus")
    private String vinculoSus;

    @Column(name = "nu_latitude")
    private Double latitude;

    @Column(name = "nu_longitude")
    private Double longitude;

    public Estabelecimento() {}

    public void setLat(Double latitude) {
        this.latitude = latitude;
    }

    public void setLong(Double longitude) {
        this.longitude = longitude;
    }
}
