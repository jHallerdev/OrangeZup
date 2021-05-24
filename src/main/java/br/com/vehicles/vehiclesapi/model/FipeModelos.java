package br.com.vehicles.vehiclesapi.model;

public class FipeModelos {
    
    private String nome;
    private String codigo;

    public FipeModelos(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public FipeModelos(){

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

    @Override
    public String toString(){
        return "NOME: "+this.nome + "CODIGO: "+this.codigo;
    }
}