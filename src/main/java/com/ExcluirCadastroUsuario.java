
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ExcluirCadastroUsuario {
    
    @FXML 
    private TextField login;
    
    @FXML
    private TextField senha;
    
    @FXML
    public void excluir(){
        Dao<Usuario> dao = new Dao(Usuario.class);
        boolean result = dao.excluir(login.getText(), senha.getText());  // para dar certo
        System.out.println(result);
    
}
    @FXML
    public void cancelar()throws IOException{
        App.setRoot("menu");
        
    }
    
}
