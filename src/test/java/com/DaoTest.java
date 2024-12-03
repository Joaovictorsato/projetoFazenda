/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoãoSato
 */
public class DaoTest {
    
    public DaoTest() {
    }

   //    @Test
//    public void testInserirVaca() {
//        Vaca v = new Vaca("B1", "Vaquinha", "Holandesa");
//        Dao<Vaca> dao = new Dao(Vaca.class);
//        dao.inserir(v);    
//    }
    
    @Test
    public void testListar(){
        Dao<Usuario> dao = new Dao(Usuario.class);
        List<Usuario> lista = dao.listarTodos(); 
        for (Usuario v : lista){
            System.out.println(v.getLogin() + " " + v.getSenha());
        }
    }
    
    
//    @Test
//    public void testExcluir(){
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        // boolean result = dao.excluir("brinco", "15"); / para dar errado 
//        boolean result = dao.excluir("carlos", "555");  // para dar certo
//        System.out.println(result);
//    }
    
    
}
