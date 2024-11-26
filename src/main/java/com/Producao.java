
package com;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Producao {
    @BsonProperty(value ="vac")
    private Vaca vac;
    @BsonProperty(value ="data")
    private String data;
     @BsonProperty(value ="quantidade")
    private int quantidade;
    
    public Producao(){
        vac = new Vaca();
        data = "";
        quantidade = 0;
    }
    public Producao(Vaca vac, String data, int quantidade){
        this.vac = vac;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Vaca getVac() {
        return vac;
    }

    public void setVac(Vaca vac) {
        this.vac = vac;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
