
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class LoginControle {
    @FXML
    private TextField nome;
    
    @FXML 
    private TextField senha;
    
    @FXML
    public void logar()throws IOException{

      Dao<Usuario> dao = new Dao (Usuario.class);
      if(dao.buscarPorChave("login", nome.getText())==null || dao.buscarPorChave("senha", senha.getText())==null){
       Alerta("Erro", "Usuario ja existente");
      }
      else if (nome.getText().isEmpty()|| senha.getText().isEmpty()){
          Alerta("ERRO", "campos nao podem estar vazios");
      }
      else {
          App.setRoot("Menu");
      }
        
    }
    @FXML
    public void apagar(){
        nome.clear();
        senha.clear();
    }
    
    @FXML
    public void cadastrarUsuario()throws IOException{
        App.setRoot("TelaUser");
    }
    
    private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
   }
}
