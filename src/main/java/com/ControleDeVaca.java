/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ControleDeVaca {
     @FXML
    private TextField brinco; 
    @FXML 
    private TextField nome;
    @FXML
    private TextField raca; 
    
    @FXML
    private void gravar(){
        String brinks = brinco.getText();
        String nomeDaVaca = nome.getText();
        String racaDaVaca = raca.getText();
        
        Vaca vaca = new Vaca(brinks, nomeDaVaca, racaDaVaca);
        Dao<Vaca> dao= new Dao(Vaca.class);
        dao.inserir(vaca);
    }
    
    @FXML
    private void cancelar(){
        brinco.clear();
        nome.clear();
        raca.clear();
        
    }
}
