package objetos;

public class Querellante extends Persona {

    private int id_querellante;
    private String cedula;
    private String direccion;

    public Querellante(int id_querellante, String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) {
        super(nombre, apellido1, apellido2, telefono);
        this.id_querellante = id_querellante;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public int getId_querellante() {
        return id_querellante;
    }

    public void setId_querellante(int id_querellante) {
        this.id_querellante = id_querellante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Querellante{" + "id_querellante=" + id_querellante + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", cedula=" + cedula + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
