package gestor;

import multi.MultiQuerellante;
import objetos.Querellante;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorQuerellante {

    private static MultiQuerellante querellanteNuevo = new MultiQuerellante();

    public void registarQuerellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) throws ClassNotFoundException, SQLException, Exception {

        querellanteNuevo.registarQuerellante(nombre, apellido1, apellido2, cedula, telefono, direccion);
    }

    public ArrayList<Querellante> listarQuerellante() throws Exception {
        ArrayList<Querellante> listQuerellanteMulti = querellanteNuevo.listarQuerellante();

        return listQuerellanteMulti;

    }

}
