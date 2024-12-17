
package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class ExcluirCadastroUsuario {
   private Dao<Usuario> dao;
   private Usuario usuario;
    
    @FXML 
     private ComboBox <Usuario> comboUser;
    
    @FXML
    private TextField senha;
    
    
    @FXML
    public void initialize(){
        dao = new Dao(Usuario.class);
        List<Usuario> usuariosCadastrados = dao.listarTodos();
        ObservableList<Usuario> itensComboBox = FXCollections.observableArrayList(usuariosCadastrados);    
        comboUser.setItems(itensComboBox);
        
    }
    
    @FXML
    public void excluir(){
        if(dao.buscarPorChave("senha", senha.getText())==null){
            Alerta("Erro","senha incorreta");
        }
        else if(senha.getText().isEmpty()){
            Alerta("Erro", "senha vazia");
        }
        else{
     usuario = comboUser.getValue();
     dao.excluir("login", usuario.getLogin());
     Alerta("Sucesso","excluido com sucesso");
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
