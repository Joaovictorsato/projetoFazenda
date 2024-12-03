
package com;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class AlterarCadastroUsuario {
    private Dao <Usuario> daoUser;
    private Usuario us;
    
     @FXML
     public void initialize(){
       daoUser = new Dao(Usuario.class);
        List<Usuario> usuariosCadastrados = daoUser.listarTodos();
        ObservableList<Usuario> itensComboBox = FXCollections.observableArrayList(usuariosCadastrados);    
        comboUser.setItems(itensComboBox);
    }
    
    @FXML
    private ComboBox <Usuario> comboUser;
    
   
    @FXML 
    private void atualizarCampo(){
        us = comboUser.getValue();
    }
    
    @FXML
    private TextField atualLogin;
    
    @FXML
    private TextField novoLogin;
    
    @FXML
    private TextField novaSenha;
    
    
}
