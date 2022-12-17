package com.proyecto;


import com.proyecto.views.Home;

import javax.swing.*;
import java.awt.*;


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

        //ABRIR VENTANA!!!
        JFrame frame = new JFrame("Order Manager");
        frame.setContentPane(new Home().Home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}