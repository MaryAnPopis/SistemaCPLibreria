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
    
    /**
     * Este metodo envia la informacion para ser 
     * registrada en la base de datos
     * @param numero numero de caso
     * @param id_demandante id del querellante
     * @param id_mediador id del juez
     * @param estado estado del caso
     * @param fecha fecha de creacion
     * @param descripcion descripcion del caso
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarCaso(String numero, int id_demandante, int id_mediador, int estado, LocalDate fecha, String descripcion) throws ClassNotFoundException, SQLException, Exception {
        MultiCaso caso = new MultiCaso();           
        caso.crear(numero, id_demandante, id_mediador, estado, fecha, descripcion);
    }
    /**
     * Este metodo guarda el id de un querellante
     * registrado en la base de datos
     * @param cedula
     * @return
     * @throws Exception 
     */
    public Querellante querellanteIDByCedula(String cedula) throws Exception{
        Querellante miQuerellante;
        MultiCaso caso = new MultiCaso();
        miQuerellante = caso.querellanteIDByCedula(cedula);
        
        return miQuerellante;
    }
    /**
     * Este metodo guarda todos los id de los jueces
     * registrados en la base de datos
     * @return Arraylist de id de jueces registrados
     * @throws Exception 
     */
    public ArrayList<Integer> idJueces() throws Exception{
        MultiCaso juezNuevo = new MultiCaso();
        ArrayList<Integer> listJuezMulti = juezNuevo.listarIdsJuez();

        return listJuezMulti;
    }
    /**
     * Este metodo devuelve el id de un juez
     * de manera aleatoria
     * @return id de un juez
     * @throws Exception 
     */
    public int setRandomJuezId() throws Exception{
        int randomID = 0;
        ArrayList<Integer> listJuezMulti = idJueces();
        
        Random randomizer = new Random();
        randomID = listJuezMulti.get(randomizer.nextInt( listJuezMulti.size()));
        
        return randomID;
    }
    
    public ArrayList<Caso> getCasosByJuez(int id_juez) throws Exception{
        ArrayList<Caso> listCasosMulti;
        MultiCaso casoNuevo = new MultiCaso();
        listCasosMulti = casoNuevo.getListaCasosByJuez(id_juez);
        
        return listCasosMulti;
    }
}

