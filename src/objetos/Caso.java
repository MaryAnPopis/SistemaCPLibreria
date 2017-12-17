
package objetos;

import java.time.LocalDate;

/**
 *
 * @author Mariam Domínguez y Daniel Rodriguez
 * @version 1.0 17/12/2017
 */
public class Caso {
    private String numero; 
    private String descripcion; 
    private Querellante demandante;
    private Juez mediador;
    private int estado;
    private LocalDate fecha;

    public Caso(String numero, Querellante demandante, Juez mediador, int estado, LocalDate fecha, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.demandante = demandante;
        this.mediador = mediador;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Querellante getDemandante() {
        return demandante;
    }

    public void setDemandante(Querellante demandante) {
        this.demandante = demandante;
    }

    public Juez getMediador() {
        return mediador;
    }

    public void setMediador(Juez mediador) {
        this.mediador = mediador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Caso{" + "numero=" + numero + ", descripcion=" + descripcion + ", demandante=" + demandante + ", mediador=" + mediador + ", estado=" + estado + ", fecha=" + fecha + '}';
    }
    
    
    
    
    
}
