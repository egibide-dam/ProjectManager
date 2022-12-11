import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PedidosController;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;
import com.proyecto.utils.HibernateUtil;
import com.proyecto.views.Home;

import javax.swing.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {


        //ABRIR VENTANA!!!
        JFrame frame = new JFrame("Order Manager");
        frame.setContentPane(new Home().Home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}