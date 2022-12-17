package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;

public class DetalleProyecto extends JFrame{
    JPanel detalleProyecto;
    private JLabel idDetalleProyecto;
    private JLabel estadoDetalleProyecto;
    private JLabel ciudadDetalleProyecto;
    private JLabel nombreDetalleProyecto;



    public DetalleProyecto(){

        setContentPane(detalleProyecto);

        idDetalleProyecto.setText("PROY-" + Main.currentProyecto.getIdproyecto());
        if (Main.currentProyecto.getAlta() == 1){
            estadoDetalleProyecto.setText("ALTA");
        } else {
            estadoDetalleProyecto.setText("BAJA");
        }
        ciudadDetalleProyecto.setText(Main.currentProyecto.getCiudad());
        nombreDetalleProyecto.setText(Main.currentProyecto.getNombre());

    }
}
