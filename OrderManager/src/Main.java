import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PedidosController;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;
import com.proyecto.utils.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {


        System.out.println(PedidosController.top5Piezas()[0][1]);
        /**
        int[][] top5piezas = PedidosController.top5Piezas();
        for (int i = 0; i<5; i++){
            System.out.println("PIEZA-" + top5piezas[i][0] + " (" + top5piezas[i][1] + ")");
        }
         */

    }
}