/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
        if(brinks.isEmpty()||nomeDaVaca.isEmpty()||racaDaVaca.isEmpty()){
            Alerta("ERRO", "Todos os campos devem ser preenchidos.");
        }
        else{
        Vaca vaca = new Vaca(brinks, nomeDaVaca, racaDaVaca);
        Dao<Vaca> dao= new Dao(Vaca.class);
        dao.inserir(vaca);
        limpar();
        }
    }
    
    @FXML
    private void cancelar()throws IOException{
        App.setRoot("menu");
        
    }
   private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
   }
   private void limpar(){
       brinco.clear();
       nome.clear();
       raca.clear();
   }
}
