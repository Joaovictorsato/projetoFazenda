/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListarProducaoDia {
    @FXML
    private TableView<Producao> tabelaProducao;
    @FXML
    private TextField dia;
    @FXML
    private String selecionada;
    
    private LocalDate data;
    
    Dao <Producao> daoProducao;
    Dao <Vaca> daoVaca;
    @FXML
    private void initialize(){
        daoProducao = new Dao(Producao.class);
        daoVaca = new Dao(Vaca.class);
        TableColumn <Producao, String> colunaBrinco = new TableColumn <> ("Brinco");
        colunaBrinco.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getVac().getBrinco())
        );
        TableColumn <Producao, LocalDate> colunaData = new TableColumn <> ("Data");
        colunaData.setCellValueFactory (new PropertyValueFactory <> ("data"));
        TableColumn <Producao, Integer> colunaQuantidade = new TableColumn <> ("Quantidade");
        colunaQuantidade.setCellValueFactory (new PropertyValueFactory<>("quantidade"));
        tabelaProducao.getColumns().addAll(colunaBrinco, colunaData, colunaQuantidade);
        
    }
    @FXML
    private void atualizarCampos(){
        selecionada =  dia.getText();
        List <Producao> listaProd = daoProducao.listarTodos();
        ObservableList <Producao> listaFiltrada  = FXCollections.observableArrayList();
        for(Producao v : listaProd){
            System.out.println();
            if(v.getData().equals(selecionada)){
                listaFiltrada.add(v);
            }
        }
        tabelaProducao.setItems(listaFiltrada);
        
    }
    
    @FXML
    public void voltar() throws IOException{
        App.setRoot("Menu");
    }

}
