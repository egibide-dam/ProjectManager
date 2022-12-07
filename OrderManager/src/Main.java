import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
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


        List<PedidosEntity> ps = PedidosController.buscarPedidos("er");
        for (PedidosEntity p : ps){
            System.out.println("\n" + p.getIdpedido() + "- " + " " + p.getCantidad());
        }



    }
}