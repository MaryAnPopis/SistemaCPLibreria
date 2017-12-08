package gestor;

import multi.MultiJuez;
import objetos.Juez;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorJuez {

    private static MultiJuez juezNuevo = new MultiJuez();

    public void registrarJuez(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {

        juezNuevo.crear(nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave);
    }

    public ArrayList<Juez> listarJuez() throws Exception {
        ArrayList<Juez> listJuezMulti = juezNuevo.listarJuez();

        return listJuezMulti;

    }

    /**
     * Recibe el nombre de usuario y la contraseña del formulario de login del
     * juez
     *
     * @param username nombre de usuario del juez que hara log in
     * @param password contraseña del juez que hara log in
     * @throws java.sql.SQLException
     */
    public Juez inicioSesion(String username, String password) throws SQLException, Exception {
        MultiJuez juez = new MultiJuez();
        Juez miJuez = juez.logIn(username, password);
        return miJuez;
    }
}
