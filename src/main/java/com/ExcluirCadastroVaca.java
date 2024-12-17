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


public class ExcluirCadastroVaca {
       private Dao<Vaca> dao;
   private Vaca vaca;
    
    @FXML 
     private ComboBox <Vaca> comboVaca;
    

    @FXML
    public void initialize(){
        dao = new Dao(Vaca.class);
        List<Vaca> vacasCadastradas = dao.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);    
        comboVaca.setItems(itensComboBox);
        
    }
    
    @FXML
    public void excluir(){
     vaca = comboVaca.getValue();
     dao.excluir("brinco", vaca.getBrinco());
    Alerta("Sucesso","Campo excluido");
    
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
