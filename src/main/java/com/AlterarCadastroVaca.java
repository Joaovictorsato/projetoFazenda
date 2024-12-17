/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AlterarCadastroVaca {
     private Dao <Vaca> daoVaca;
    private Vaca vaca;
    
     @FXML
    private ComboBox <Vaca> comboVaca;  
     
     @FXML
    private TextField nomeVaca;
    
    @FXML
    private TextField racaDaVaca;
    
      @FXML
    private TextField alterarNomeVaca;
    
  
    
     @FXML
     public void initialize(){
       daoVaca = new Dao(Vaca.class);
        List<Vaca> vacasCadastradas = daoVaca.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);    
        comboVaca.setItems(itensComboBox);
        
        
    }

    @FXML 
    private void atualizarCampo(){
        vaca = comboVaca.getValue();
        nomeVaca.setText(vaca.getNomeVaca());       
    }
   
    @FXML
    public void atualizarVaca(){
        if(racaDaVaca.getText().isEmpty()||alterarNomeVaca.getText().isEmpty()){
            Alerta("Erro","todos os campos devem ser preenchidos");
        }
        else{
           vaca.setNomeVaca(alterarNomeVaca.getText());
           vaca.setRaca(racaDaVaca.getText());
           daoVaca.alterar("brinco", vaca.getBrinco(), vaca);
           Alerta("sucesso", "os campos foram alterados");
}
    }
    
     @FXML
    public void cancelar()throws IOException{
        App.setRoot("menu");
        
    }
    
     private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
   }
   
}
