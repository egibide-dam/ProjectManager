import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;
import com.proyecto.utils.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        List<ProveedoresEntity> ps = ProveedorController.buscarProveedor("2 ");
        for (ProveedoresEntity p : ps){
            System.out.println("\n" + p.getIdproveedor() + "- " + p.getNombre() + " " + p.getApellidos());
        }

    }
}