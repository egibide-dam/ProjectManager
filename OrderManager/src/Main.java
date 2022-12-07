import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;
import com.proyecto.utils.HibernateUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {


        ProveedoresEntity p = new ProveedoresEntity();
        p.setNombre("Irene");
        p.setApellidos("Brea Elorza");
        p.setDireccion("Avenida ciudad 44");
        p.setAlta((byte)1);
        HibernateUtil.guardar(p);

    }
}