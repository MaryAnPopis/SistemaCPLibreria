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

    public void crear(String numero, int id_demandante, int id_mediador, int id_estado, LocalDate fecha, String descripcion, String comentarioInicial) throws Exception {

        String query;
        query = "INSERT INTO tCaso(numero_caso, descripcion, fecha_registro, id_estado, id_juez, id_querellante, comentario_estado)"
                + "VALUES ('" + numero + "','" + descripcion + "', '" + fecha + "'," + id_estado + " , " + id_mediador + " , " + id_demandante + ", '"+comentarioInicial+"' );";

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
                + "id_estado, comentario_estado from tCaso  where id_juez =  "+id_juez+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiQuerellante multi = new MultiQuerellante();    
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    multi.getQuerellanteById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion"), rs.getString("comentario_estado")));

        }
        conn.finalize();
        return listCasos;
    }
    
    
    public ArrayList<Caso> getListaCasosByQuerellante(int id_querellante) throws SQLException, Exception {

        ArrayList<Caso> listCasos = new ArrayList<>();
        String query = "select numero_caso, fecha_registro, id_juez, descripcion, id_estado, comentario_estado "
                + "from tCaso  where id_querellante =  "+id_querellante+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiJuez mulJuez = new MultiJuez();
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    mulJuez.getJuezById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion"), rs.getString("comentario_estado")));

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
    
    public int getIdCasoByNumero(String numeroCaso) throws Exception{
        int id_caso = 0;
        
        String query = "select id_caso from tCaso where numero_caso = '"+numeroCaso+"' ;";
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
 
        while (rs.next()) {
            id_caso = rs.getInt("id_caso");  
        }

        conn.finalize();

        
        return id_caso;
    }
    
    public int getIdEstadoByIdCaso(int idCaso) throws Exception{
        int id_estado = 0;
        
        String query = "select id_estado from tCaso where id_caso = "+idCaso+";";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
 
        while (rs.next()) {
            id_estado = rs.getInt("id_estado");  
        }

        conn.finalize();
        
        return id_estado;
    }
    
    
    public void updateCaso(int idEstado, String comentario, int idCaso) throws Exception{
        String query = "update tCaso "
                + "set id_estado = "+idEstado+", comentario_estado = '"+comentario+"' "
                + "where id_caso = "+idCaso+";";
        
        
        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();

        
    }
    
    public void insertarHistorial(String comentario, int idEstado, int idCaso, LocalDate fechaCambio) throws Exception{
        String query = "insert into tHistorialCasos(comentario_estado, id_estado, id_caso, fecha_cambio)" +
                        "values ('"+comentario+"', "+idEstado+" , "+idCaso+", '"+fechaCambio+"');";
        
        
        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();
    }
}

