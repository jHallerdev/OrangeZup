package br.com.vehicles.vehiclesapi.model;

import java.util.List;

public class FipeResponse {
    
    private String nome;
    private String codigo;
    private List<FipeModelos> modelos;

    public FipeResponse(String nome, String codigo, List<FipeModelos> modelos) {
        this.nome = nome;
        this.codigo = codigo;
        this.modelos = modelos;
    }

    public FipeResponse(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<FipeModelos> getModelos() {
        return modelos;
    }

    public void setModelos(List<FipeModelos> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString(){
        return this.nome + " " + this.codigo + " " + this.getModelos().toString(); 
    }
}
