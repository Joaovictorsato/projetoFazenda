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


public class ControleUsuario {
    @FXML
    private TextField nome; 
    @FXML 
    private TextField login;
    @FXML
    private TextField senha; 
    
    @FXML
    private void gravar()throws IOException{
        Dao<Usuario> dao= new Dao(Usuario.class);
        String userName = nome.getText();
        String loginUser = login.getText();
        String password = senha.getText();
        if(userName.isEmpty()||loginUser.isEmpty()||password.isEmpty()){
            Alerta("ERRO", "Todos os campos devem ser preenchidos.");
        }
        else if(dao.buscarPorChave("login", login.getText())!=null){
        Alerta("ERRO", "Usuario ja existente");
      }
        else{
        Usuario user = new Usuario(userName, loginUser, password);
        dao.inserir(user);
        App.setRoot("TelaLogin");
        }
    }
    
    @FXML
    private void cancelar()throws IOException{
        App.setRoot("TelaLogin");
        
    }
    private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert (AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    private void limpar(){
        nome.clear();
        login.clear();
        senha.clear();
    }
}
