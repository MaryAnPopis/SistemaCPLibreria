package multi;

import com.acceso.Conector;
import objetos.Juez;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiJuez {
    private AccesoBD conn;
    
    
    public void crear(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_juez]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','"
                + telefono + "','" + numero_sala + "','" + usuario + "','"
                + clave + "'";
        try {
            conn = new Conector().getConector();
            
            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiJuez.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Juez> listarJuez() throws Exception {
        ArrayList<Juez> listJuez = new ArrayList<>();

        String query;
        query = "SELECT * FROM tJuez";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Juez juez = new Juez(
                    rs.getInt("id_juez"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("numero_sala"),
                    rs.getString("usuario"),
                    rs.getString("clave"));

            listJuez.add(juez);
        }
        return listJuez;

    }
    
    /**
     * Busca el nombre de usuario y la contraseña de un
     * juez en la base de datos, y lo asigna al constructor del 
     * juez si conincide, devolviendo al juez encontrado
     * @param username nombre de usuario del juez a buscar en la base de datos
     * @param password contraseña a buscar en la base de datos
     * @return juez de tipo Juez
     * @throws SQLException expecion de Sql
     * @throws Exception 
     */
    public Juez logIn(String username, String password) throws SQLException, Exception{
        
        Juez miJuez = null;
        
        String query = "SELECT usuario, clave FROM tJuez WHERE usuario = '"+ username +"'"
                + " AND clave = '"+ password +"'";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            miJuez = new Juez(rs.getString("usuario"), rs.getString("clave"));  
        }
        
        return miJuez;
    }
}
