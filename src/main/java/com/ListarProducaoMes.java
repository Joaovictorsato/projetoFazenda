
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


public class ListarProducaoMes {
     private Dao <Producao> daoProducao;
      private Dao <Vaca> daoVaca;
     private String selecionada;
     
    @FXML
    private TableView<Producao> tabelaProducao;
    @FXML
    private TextField mes;

    private LocalDate data;
    
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
        selecionada =  mes.getText();
        List <Producao> listaProd = daoProducao.listarTodos();
        ObservableList <Producao> listaFiltrada  = FXCollections.observableArrayList();
        for(Producao v : listaProd){
            //System.out.println();
            if(v.getData().substring(5,7).equals(selecionada)){
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