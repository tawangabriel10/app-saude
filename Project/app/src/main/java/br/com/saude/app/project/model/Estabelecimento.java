package br.com.saude.app.project.model;

import java.io.Serializable;

/**
 * Created by tawan on 3/26/17.
 */

public class Estabelecimento implements Serializable {

    private Long id;
    private String bairro;
    private String categoriaUnidade;
    private String cep;
    private String cidade;
    private String cnpj;
    private String codCnes;
    private String codIbge;
    private String codUnidade;
    private String descricaoCompleta;
    private String email;
    private String esferaAdministrativa;
    private String fluxoClientela;
    private String grupo;
    private String logradouro;
    private String natureza;
    private String nomeFantasia;
    private String numero;
    private String origemGeografica;
    private String retencao;
    private String telefone;
    private String temAtendimentoAmbulatorial;
    private String temAtendimentoUrgencia;
    private String temCentroCirurgico;
    private String temDialise;
    private String temNeoNatal;
    private String temObstetra;
    private String tipoUnidade;
    private String tipoUnidadeCnes;
    private String turnoAtendimento;
    private String uf;
    private String vinculoSus;
    private Double latitude;
    private Double longitude;

    public Estabelecimento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCategoriaUnidade() {
        return categoriaUnidade;
    }

    public void setCategoriaUnidade(String categoriaUnidade) {
        this.categoriaUnidade = categoriaUnidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodCnes() {
        return codCnes;
    }

    public void setCodCnes(String codCnes) {
        this.codCnes = codCnes;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public String getCodUnidade() {
        return codUnidade;
    }

    public void setCodUnidade(String codUnidade) {
        this.codUnidade = codUnidade;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEsferaAdministrativa() {
        return esferaAdministrativa;
    }

    public void setEsferaAdministrativa(String esferaAdministrativa) {
        this.esferaAdministrativa = esferaAdministrativa;
    }

    public String getFluxoClientela() {
        return fluxoClientela;
    }

    public void setFluxoClientela(String fluxoClientela) {
        this.fluxoClientela = fluxoClientela;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrigemGeografica() {
        return origemGeografica;
    }

    public void setOrigemGeografica(String origemGeografica) {
        this.origemGeografica = origemGeografica;
    }

    public String getRetencao() {
        return retencao;
    }

    public void setRetencao(String retencao) {
        this.retencao = retencao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTemAtendimentoAmbulatorial() {
        return temAtendimentoAmbulatorial;
    }

    public void setTemAtendimentoAmbulatorial(String temAtendimentoAmbulatorial) {
        this.temAtendimentoAmbulatorial = temAtendimentoAmbulatorial;
    }

    public String getTemAtendimentoUrgencia() {
        return temAtendimentoUrgencia;
    }

    public void setTemAtendimentoUrgencia(String temAtendimentoUrgencia) {
        this.temAtendimentoUrgencia = temAtendimentoUrgencia;
    }

    public String getTemCentroCirurgico() {
        return temCentroCirurgico;
    }

    public void setTemCentroCirurgico(String temCentroCirurgico) {
        this.temCentroCirurgico = temCentroCirurgico;
    }

    public String getTemDialise() {
        return temDialise;
    }

    public void setTemDialise(String temDialise) {
        this.temDialise = temDialise;
    }

    public String getTemNeoNatal() {
        return temNeoNatal;
    }

    public void setTemNeoNatal(String temNeoNatal) {
        this.temNeoNatal = temNeoNatal;
    }

    public String getTemObstetra() {
        return temObstetra;
    }

    public void setTemObstetra(String temObstetra) {
        this.temObstetra = temObstetra;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getTipoUnidadeCnes() {
        return tipoUnidadeCnes;
    }

    public void setTipoUnidadeCnes(String tipoUnidadeCnes) {
        this.tipoUnidadeCnes = tipoUnidadeCnes;
    }

    public String getTurnoAtendimento() {
        return turnoAtendimento;
    }

    public void setTurnoAtendimento(String turnoAtendimento) {
        this.turnoAtendimento = turnoAtendimento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getVinculoSus() {
        return vinculoSus;
    }

    public void setVinculoSus(String vinculoSus) {
        this.vinculoSus = vinculoSus;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public void setLat(Double latitude) {
        this.latitude = latitude;
    }

    public void setLong(Double longitude) {
        this.longitude = longitude;
    }
}
