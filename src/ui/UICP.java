/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gestor.GestorSecretario;
import gestor.GestorQuerellante;
import gestor.GestorJuez;
import objetos.Juez;
import objetos.Querellante;
import objetos.Secretario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class UICP {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static GestorJuez gestorJuez = new GestorJuez();
    static GestorQuerellante gestorQuerellante = new GestorQuerellante();
    static GestorSecretario gestorSecretario = new GestorSecretario();

    public static void main(String args[]) throws IOException, ClassNotFoundException, Exception {
        mostrarMenu();
    }

    public static void mostrarMenu() throws IOException, ClassNotFoundException, Exception {
        int opcion = -1;
        do {

            out.println("1. Registrar juez");
            out.println("2. Registrar querrellante");
            out.println("3. Registrar secretario");
            out.println("4. Listar juez");
            out.println("5. Listar querellante");
            out.println("6. Listar secreatari(a)");
            out.println("4. Listar querellante");
            out.println("0. Salir");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
            out.println("La opcion ingresada fue: " + opcion);

        } while (opcion != 4);
    }

    public static void procesarOpcion(int popcion) throws IOException, ClassNotFoundException, Exception {

        switch (popcion) {
            case 0:
                out.println("Gracias por usar el sistema");
                break;
            case 1:
                registarJuez();
                break;

            case 2:
                registrarQuerellante();
                break;
            case 3:
                registrarSecretario();
                break;
            case 4:
                listarJuez();
                break;
            case 5:
                listarQuerellante();
                break;
            case 6:
                listarSecretario();
                break;

            default:
                out.println("Opción invalida");

        }
    }

    public static void registarJuez() throws java.io.IOException, ClassNotFoundException, Exception {
        String nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave;

        out.println("Nombre: ");
        nombre = in.readLine();
        out.println("Primer apellido: ");
        apellido1 = in.readLine();
        out.println("Segundo apellido: ");
        apellido2 = in.readLine();
        out.println("Cedula: ");
        cedula = in.readLine();
        out.println("Telefono: ");
        telefono = in.readLine();
        out.println("Numero de sala: ");
        numero_sala = in.readLine();
        out.println("Usuario: ");
        usuario = in.readLine();
        out.println("Clave: ");
        clave = in.readLine();
        //se crea el gestor de la clase para insertar la carrera
        try {
            
            gestorJuez.registrarJuez(nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave);
        } catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        }
    }

    public static void registrarQuerellante() throws java.io.IOException, ClassNotFoundException, Exception {
        String nombre, apellido1, apellido2, cedula, telefono, direccion;

        out.println("Nombre: ");
        nombre = in.readLine();
        out.println("Primer apellido: ");
        apellido1 = in.readLine();
        out.println("Segundo apellido: ");
        apellido2 = in.readLine();
        out.println("Cedula: ");
        cedula = in.readLine();
        out.println("Telefono: ");
        telefono = in.readLine();
        out.println("Direccion ");
        direccion = in.readLine();

        //se crea el gestor de la clase para insertar la carrera
        try {
            gestorQuerellante.registarQuerellante(nombre, apellido1, apellido2, cedula, telefono, direccion);
        } catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        }
    }

    public static void registrarSecretario() throws java.io.IOException, ClassNotFoundException, Exception {
        String nombre, apellido1, apellido2, telefono, usuario, clave;

        out.println("Nombre: ");
        nombre = in.readLine();
        out.println("Primer apellido: ");
        apellido1 = in.readLine();
        out.println("Segundo apellido: ");
        apellido2 = in.readLine();
        out.println("Telefono: ");
        telefono = in.readLine();
        out.println("Usuario: ");
        usuario = in.readLine();
        out.println("Clave ");
        clave = in.readLine();

        //se crea el gestor de la clase para insertar la carrera
        try {
            gestorSecretario.registrarSecretario(nombre, apellido1, apellido2, telefono, usuario, clave);
        } catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        }
    }

    public static void listarQuerellante() throws Exception {
        ArrayList<Querellante> listaQuerellante = gestorQuerellante.listarQuerellante();
        for (Querellante c : listaQuerellante) {
            System.out.println(c.toString());

        }
    }

    public static void listarJuez() throws Exception {
        ArrayList<Juez> listaJuez = gestorJuez.listarJuez();
        for (Juez c : listaJuez) {
            System.out.println(c.toString());

        }
    }

    public static void listarSecretario() throws Exception {
        ArrayList<Secretario> listaSecretario = gestorSecretario.listarSecretario();
        for (Secretario c : listaSecretario) {
            System.out.println(c.toString());

        }
    }

}
