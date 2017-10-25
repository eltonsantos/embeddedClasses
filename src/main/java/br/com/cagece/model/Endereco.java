package br.com.cagece.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    
    private String rua;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco() {
    }
    
    public Endereco(String rua, String cep, String cidade, String estado) {
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}