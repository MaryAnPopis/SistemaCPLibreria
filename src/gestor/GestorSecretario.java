package gestor;


import multi.MultiSecretario;
import objetos.Secretario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorSecretario {

    private static MultiSecretario secretarioNuevo = new MultiSecretario();

    public void registrarSecretario(String nombre, String apellido1, String apellido2, String telefono, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {

        secretarioNuevo.crear(nombre, apellido1, apellido2, telefono, usuario, clave);
    }

    public ArrayList<Secretario> listarSecretario() throws Exception {
        MultiSecretario multi = new MultiSecretario();
        ArrayList<Secretario> listSecretarioMulti = multi.listarSecretario();

        return listSecretarioMulti;

    }
    
    
    /**
     * Recibe el nombre de usuario y la contraseña del formulario de login del
     * secretario
     *
     * @param username nombre de usuario del secretario que hara log in
     * @param password contraseña del secretario que hara log in
     * @throws java.sql.SQLException
     */
    public Secretario inicioSesion(String username, String password) throws SQLException, Exception {
        MultiSecretario multi = new MultiSecretario();
        Secretario miSecretario = multi.logIn(username, password);
        return miSecretario;
    }

}
