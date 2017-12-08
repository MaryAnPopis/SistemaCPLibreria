package objetos;

/**
 *
 * @author Dell
 */
public class Juez extends Persona {

    private int id_juez;
    private String numero_sala;
    private String usuario;
    private String clave;
    private String cedula;

    public Juez(int id_juez, String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) {
        super(nombre, apellido1, apellido2, telefono);
        this.id_juez = id_juez;
        this.numero_sala = numero_sala;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
    }

    public Juez(String usuario, String clave) {
        super();
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId_juez() {
        return id_juez;
    }

    public void setId_juez(int id_juez) {
        this.id_juez = id_juez;
    }

    public String getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(String numero_sala) {
        this.numero_sala = numero_sala;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Juez{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", numero_sala=" + numero_sala + ", usuario=" + usuario + ", clave=" + clave + ", cedula=" + cedula + '}';
    }

}
