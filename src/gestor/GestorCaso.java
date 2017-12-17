/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import multi.MultiCaso;
import objetos.*;

/**
 *
 * @author Mari
 */
public class GestorCaso {
    public void registrarCaso(String numero, int id_demandante, int id_mediador, int estado, LocalDate fecha, String descripcion) throws ClassNotFoundException, SQLException, Exception {
        MultiCaso caso = new MultiCaso();           
        caso.crear(numero, id_demandante, id_mediador, estado, fecha, descripcion);
    }
    
    public Querellante querellanteIDByCedula(String cedula) throws Exception{
        Querellante miQuerellante;
        MultiCaso caso = new MultiCaso();
        miQuerellante = caso.querellanteIDByCedula(cedula);
        
        return miQuerellante;
    }
    
    public ArrayList<Integer> idJueces() throws Exception{
        MultiCaso juezNuevo = new MultiCaso();
        ArrayList<Integer> listJuezMulti = juezNuevo.listarIdsJuez();

        return listJuezMulti;
    }
    
    public int setRandomJuezId() throws Exception{
        int randomID = 0;
        ArrayList<Integer> listJuezMulti = idJueces();
        
        Random randomizer = new Random();
        randomID = listJuezMulti.get(randomizer.nextInt( listJuezMulti.size()));
        
        return randomID;
    }
}

