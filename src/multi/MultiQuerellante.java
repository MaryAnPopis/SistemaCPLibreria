package multi;

import com.acceso.Conector;
import objetos.Querellante;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class MultiQuerellante {

    private AccesoBD conn;
    /**
     * Registra un querellante en la base de datos
     * @param nombre nombre del querellante
     * @param apellido1 apellido del querellante
     * @param apellido2
     * @param cedula
     * @param telefono
     * @param direccion 
     */
    public void registarQuerellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_querellante]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','" + telefono + "','" + direccion + "'";

        try {
            conn = new Conector().getConector();

            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiQuerellante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Querellante> listarQuerellante() throws Exception {
        ArrayList<Querellante> listQuerellante = new ArrayList<>();

        String query;
        query = "SELECT * FROM tQuerellante";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Querellante querellante = new Querellante(
                    rs.getInt("id_querellante"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("direccion"));

            listQuerellante.add(querellante);
        }
        return listQuerellante;

    }

    public Querellante logIn(String cedula) throws Exception {
        Querellante miQuerellante = null;

        String query = "select cedula from [dbo].[tQuerellante] where cedula = '" + cedula + "'";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        
        while (rs.next()) {
            miQuerellante = new Querellante(rs.getString("cedula"));
        }

        return miQuerellante;
    }
    /**
     * Este metodo busca el nombre de un querellante segun su
     * cedula para devolverlo en un String
     * @param cedula cedula del nombre a buscar
     * @return String con el nombre del querellante encontrado
     * @throws SQLException
     * @throws Exception 
     */
    public String nombreByCedula(String cedula) throws SQLException, Exception {
        String nombreQuere = "";
        String query = "select nombre, apellido1, apellido2 from tQuerellante where cedula = '"+cedula+"'";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        
        while (rs.next()) {
            nombreQuere = (rs.getString("nombre"));
        }
        
        return nombreQuere;
    }
    
    
}
