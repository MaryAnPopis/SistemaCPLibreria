package objetos;

public class Secretario extends Persona {

    private int id_secretario;
    private String usuario;
    private String clave;

    public Secretario(int id_secretario, String nombre , String apellido1, String apellido2, String telefono, String usuario, String clave) {
        super(nombre, apellido1, apellido2, telefono);
        this.id_secretario = id_secretario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Secretario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
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

    @Override
    public String toString() {
        return "Secretario{" + "id_secretario=" + id_secretario + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", usuario=" + usuario + ", clave=" + clave + '}';
    }

}
