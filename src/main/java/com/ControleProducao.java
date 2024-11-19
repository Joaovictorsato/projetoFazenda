
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.time.LocalDate;

public class ControleProducao {
    @FXML
    private ComboBox <Vaca> vaca;
    
    @FXML
    private DatePicker data;
    
    @FXML
    private TextField quantidade;
    
    public void getDate(ActionEvent event){
        LocalDate myDate = data.getValue();
        System.out.println(myDate.toString());
    }
    public void gravar(){
        
    }
    public void cancelar()throws IOException{
        App.setRoot("Menu");
    }
}
