
package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarProducaoPorVaca {  
    private Dao <Vaca> daoVaca;
    private Dao <Producao> daoProducao;
    private Vaca vaca;
 
    @FXML
    private ComboBox <Vaca> comboVaca;
    
    @FXML
    private TableView tabelaProducao;
     
    @FXML
    private void initialize(){
        daoProducao = new Dao(Producao.class);
        daoVaca = new Dao(Vaca.class);
        List<Vaca> vacasCadastradas = daoVaca.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);
        comboVaca.setItems(itensComboBox);
        TableColumn <Producao, LocalDate> colunaData = new TableColumn <> ("Data");
        colunaData.setCellValueFactory (new PropertyValueFactory <> ("data"));
        TableColumn <Producao, Integer> colunaQuantidade = new TableColumn <> ("Quantidade");
        colunaQuantidade.setCellValueFactory (new PropertyValueFactory<>("quantidade"));
        tabelaProducao.getColumns().addAll(colunaData, colunaQuantidade);
        
    }
    @FXML
    private void atualizarCampos(){
        vaca = comboVaca.getValue();
        List <Producao> listaProd = daoProducao.listarTodos();
        ObservableList <Producao> listaFiltrada  = FXCollections.observableArrayList();
        for(Producao v : listaProd){
            if(v.getVac().getBrinco().equals(vaca.getBrinco()) ){
                listaFiltrada.add(v);
            }
        }
        tabelaProducao.setItems(listaFiltrada);
        
    }
             
     @FXML
    public void cancelar()throws IOException{
        App.setRoot("menu");
        
    }
}
