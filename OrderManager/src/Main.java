import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;
import com.proyecto.utils.HibernateUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        ProveedorController.editarProveedor(2,"Lucas", "Pérez Gómez", "Calle Falsa 12");
        ProveedoresEntity p = ProveedorController.leerProveedor(2);
        System.out.println(p.getIdproveedor() + " - " + p.getNombre() + " " + p.getApellidos() + "\n" + p.getDireccion() + "\n" + p.getAlta());
    }
}