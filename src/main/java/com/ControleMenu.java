
package com;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControleMenu {
    @FXML
    public void usuario()throws IOException{
         App.setRoot("TelaLogin");
    }
    @FXML
    public void vaca()throws IOException{
        App.setRoot("TelaVaca");
    }
    @FXML 
    public void producao()throws IOException{
        App.setRoot("TelaProducao");
    }
    @FXML 
    public void alterarUsuario() throws IOException{ 
        App.setRoot("TelaAlterarUsuario");
    }
    @FXML
    public void excluirUsuario() throws IOException{
        App.setRoot("telaExcluirUsuario");
    }
     @FXML 
    public void alterarVaca() throws IOException{ 
        App.setRoot("TelaAlterarVaca");
    }
    @FXML 
    public void excluirVaca() throws IOException{ 
        App.setRoot("TelaExcluirVaca");
    }
    
   @FXML 
    public void producaoMensal() throws IOException{ 
        App.setRoot("TelaProducaoMensal");
    }
    
     @FXML 
    public void producaoDia() throws IOException{ 
        App.setRoot("TelaProducaoDia");
    }
       @FXML 
    public void producaoPorVaca() throws IOException{ 
        App.setRoot("TelaProducaoPorVaca");
    }
}
