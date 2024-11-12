/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ControleUsuario {
    @FXML
    private TextField nome; 
    @FXML 
    private TextField login;
    @FXML
    private TextField senha; 
    
    @FXML
    private void gravar(){
        String userName = nome.getText();
        String loginUser = login.getText();
        String password = senha.getText();
        
        Usuario user = new Usuario(userName, loginUser, password);
        Dao<Usuario> dao= new Dao(Usuario.class);
        dao.inserir(user);
    }
    
    @FXML
    private void cancelar(){
        nome.clear();
        login.clear();
        senha.clear();
        
    }
}
