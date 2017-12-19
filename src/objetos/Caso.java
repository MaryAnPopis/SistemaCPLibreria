
package objetos;

import java.time.LocalDate;

/**
 *
 * @author Mariam Domínguez y Daniel Rodriguez
 * @version 1.0 17/12/2017
 */
public class Caso {
    private String numero; 
    private LocalDate fecha;
    private Querellante demandante;
    private Juez mediador;
    private int estado;    
    private String estadoNombre;
    private String descripcion; 
    private String comentarioEstado;
    
    
    public Caso(String numero, LocalDate fecha,Querellante demandante, String estadoNombre, String descripcion, String comentarioCaso) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.demandante = demandante;
        this.estadoNombre = estadoNombre;
        this.fecha = fecha;
        this.comentarioEstado = comentarioCaso;
    }
    
    
    public Caso(String numero, LocalDate fecha,Juez mediador, String estadoNombre, String descripcion, String comentarioCaso) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.mediador = mediador;
        this.estadoNombre = estadoNombre;
        this.fecha = fecha;
        this.comentarioEstado = comentarioCaso;
    }

    public Caso(LocalDate fecha, String comentarioEstado, String estadoNombre) {
        this.fecha = fecha;
        this.comentarioEstado = comentarioEstado;
        this.estadoNombre = estadoNombre;
        
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
    
    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getComentarioEstado() {
        return comentarioEstado;
    }

    public void setComentarioEstado(String comentarioEstado) {
        this.comentarioEstado = comentarioEstado;
    }
    
    

    @Override
    public String toString() {
        return "Caso{" + "numero=" + numero + ", fecha=" + fecha + ", demandante=" + demandante + ", estadoNombre=" + estadoNombre + ", descripcion=" + descripcion + ", comentario" + comentarioEstado + '}';
    }
    
    
    
}
