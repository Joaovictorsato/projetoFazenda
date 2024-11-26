
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ControleProducao {
    private Dao <Vaca> daoVaca;
    private Vaca selecionada;
    
      @FXML
        private void initialize(){
        daoVaca = new Dao(Vaca.class);
        List<Vaca> vacasCadastradas = daoVaca.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);    
        comboVaca.setItems(itensComboBox);
    }
    
    @FXML
    private ComboBox <Vaca> comboVaca;
    
    @FXML
    private DatePicker data;
    
    @FXML
    private TextField quantidade;
    
    
    @FXML
    private void atualizaCampos(){
        selecionada = comboVaca.getValue();
    }
    
    public void getDate(ActionEvent event){
        LocalDate myDate = data.getValue();
        System.out.println(myDate.toString());
    }
    public void gravar(){
        Vaca combVaca = comboVaca.getValue();
        LocalDate diaData = data.getValue();
        String quantiaLitros = quantidade.getText();
        if(combVaca == null||diaData == null||quantiaLitros.isEmpty()){
        Alerta("ERRO", "campos nao podem estar vazios.");
    } else{
            String dataFormatada = diaData.toString();
            int quantidade = Integer.parseInt(quantiaLitros);
            Producao producao = new Producao(combVaca,dataFormatada,quantidade);
             Dao<Producao> dao= new Dao(Producao.class);
            dao.inserir(producao);
//            System.out.println("salvo");
        }
        
       
    }
    public void cancelar()throws IOException{
        App.setRoot("Menu");
    }
    private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
   }
   private void limpar(){
       quantidade.clear();
   }
  
}
