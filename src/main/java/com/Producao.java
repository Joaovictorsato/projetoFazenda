
package com;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Producao {
    @BsonProperty(value ="vac")
    private Vaca vac;
     @BsonProperty(value ="quantidade")
    private int quantidade;
    
    public Producao(){
        vac = new Vaca();
        quantidade = 0;
    }
    public Producao(Vaca vac, int quantidade){
        this.vac = vac;
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
    
}
