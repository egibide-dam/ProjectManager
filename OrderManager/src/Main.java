import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.views.Home;

import javax.swing.*;

public class Main {

    //VARIABLES COMPARTIDAS
    public static PiezasEntity currentPieza = null;
    public static ProveedoresEntity currentProveedor = null;
    public static ProyectosEntity currentProyecto = null;
    public static PedidosEntity currentPedido = null;

    public static void main(String[] args) {

        //ABRIR VENTANA!!!
        JFrame frame = new JFrame("Order Manager");
        frame.setContentPane(new Home().Home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}