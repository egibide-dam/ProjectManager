package com.proyecto;


import com.proyecto.views.Home;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {

    //VARIABLES COMPARTIDAS
    public static PiezasEntity currentPieza = null;
    public static ProveedoresEntity currentProveedor = null;
    public static ProyectosEntity currentProyecto = null;
    public static PedidosEntity currentPedido = null;

    public static Color white = new Color(255,255,255);
    public static Color error = new Color(255,229,242);
    public static Color warn = new Color(251,244,227);



    public static void main(String[] args) {

        System.out.println("\nIniciando la aplicación OrderManager, por favor, espere.");

        //Quita los logs de hibernate de la consola
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(Level.OFF);

        //ABRIR VENTANA!!!
        JFrame frame = new JFrame("Order Manager");
        frame.setContentPane(new Home().Home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}