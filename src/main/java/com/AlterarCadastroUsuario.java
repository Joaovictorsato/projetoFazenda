
package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class AlterarCadastroUsuario {
    private Dao <Usuario> daoUser;
    private Usuario us;
    
     @FXML
    private ComboBox <Usuario> comboUser;  
     
     @FXML
    private TextField atualLogin;
    
    @FXML
    private TextField novoNome;
    
    @FXML
    private TextField novaSenha;
    
     @FXML
     public void initialize(){
       daoUser = new Dao(Usuario.class);
        List<Usuario> usuariosCadastrados = daoUser.listarTodos();
        ObservableList<Usuario> itensComboBox = FXCollections.observableArrayList(usuariosCadastrados);    
        comboUser.setItems(itensComboBox);
        
        
    }

    @FXML 
    private void atualizarCampo(){
        us = comboUser.getValue();
        atualLogin.setText(us.getNome());       
    }
   
    @FXML
    public void atualizarLogin(){
        if(novoNome.getText().isEmpty()|| novaSenha.getText().isEmpty()){
            Alerta("Erro","todos os campos devem ser preenchidos");
        }
        else{
           us.setNome(novoNome.getText());
           us.setSenha(novaSenha.getText());
           daoUser.alterar("login", us.getLogin(), us);
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
