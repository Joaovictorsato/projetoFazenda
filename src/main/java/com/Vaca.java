
package com;

import org.bson.codecs.pojo.annotations.BsonProperty;


public class Vaca {
    @BsonProperty(value = "brinco")
    private String brinco; 
     @BsonProperty(value = "nomeVaca")
    private String nomeVaca; 
     @BsonProperty(value = "raca")
    private String raca;
    
    public Vaca(){
        brinco = "";
        nomeVaca = "";
        raca = "";
    }
    public Vaca(String brinco, String nome, String raca){
        this.brinco = brinco;
        this.nomeVaca = nome;
        this.raca = raca;
    }

    public String getBrinco() {
        return brinco;
    }

    public void setBrinco(String brinco) {
        this.brinco = brinco;
    }

    public String getNomeVaca() {
        return nomeVaca;
    }

    public void setNomeVaca(String nome) {
        this.nomeVaca = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString(){
        return brinco;
    }
}
