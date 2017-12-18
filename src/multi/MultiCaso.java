/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi;

import com.acceso.AccesoBD;
import com.acceso.Conector;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Caso;
import objetos.Juez;
import objetos.Querellante;

/**
 *
 * @author Mari
 */
public class MultiCaso {

    private AccesoBD conn;

    public void crear(String numero, int id_demandante, int id_mediador, int id_estado, LocalDate fecha, String descripcion) throws Exception {

        String query;
        query = "INSERT INTO tCaso(numero_caso, descripcion, fecha_registro, id_estado, id_juez, id_querellante)"
                + "VALUES ('" + numero + "','" + descripcion + "', '" + fecha + "'," + id_estado + " , " + id_mediador + " , " + id_demandante + " );";

        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();

    }

    public Querellante querellanteIDByCedula(String cedula) throws Exception {
        String query = "select id_querellante from tQuerellante where cedula = '" + cedula + "';";
        Querellante miQuere = null;

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            miQuere = new Querellante(rs.getInt("id_querellante"));
        }

        return miQuere;

    }

    public ArrayList<Integer> listarIdsJuez() throws Exception {
        ArrayList<Integer> listJuez = new ArrayList<>();

        String query;
        query = "SELECT id_juez FROM tJuez";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            int juez = (rs.getInt("id_juez"));

            listJuez.add(juez);
        }
        conn.finalize();
        return listJuez;

    }

    public ArrayList<Caso> getListaCasosByJuez(int id_juez) throws SQLException, Exception {

        ArrayList<Caso> listCasos = new ArrayList<>();
        String query = "select numero_caso, fecha_registro, id_querellante, descripcion, "
                + "id_estado from tCaso  where id_juez =  "+id_juez+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiQuerellante multi = new MultiQuerellante();    
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    multi.getQuerellanteById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion")));

        }
        conn.finalize();
        return listCasos;
    }
    
    
    public ArrayList<Caso> getListaCasosByQuerellante(int id_querellante) throws SQLException, Exception {

        ArrayList<Caso> listCasos = new ArrayList<>();
        String query = "select numero_caso, fecha_registro, id_juez, descripcion, id_estado "
                + "from tCaso  where id_querellante =  "+id_querellante+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiJuez mulJuez = new MultiJuez();
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    mulJuez.getJuezById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion")));

        }
        conn.finalize();
        return listCasos;
    }
    
    
    public String getEstadoById(int id_estado) throws Exception{

        String query = "SELECT nombre_estado FROM tEstado "
                + "WHERE id_estado = '"+ id_estado +"';";
          

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        String nombre = "";
        while (rs.next()) {
            nombre = (rs.getString(1) );  
        }

        conn.finalize();

        return nombre;
    }
}
