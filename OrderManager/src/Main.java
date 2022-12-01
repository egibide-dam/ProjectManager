import Hibernate.Genericos;
import Modelo.PiezasEntity;

public class Main {
    public static void main(String[] args) {

        PiezasEntity p = new PiezasEntity(1, "Tuerca", 0.96, "Tuerca pequeña", 1, (byte) 1);
        Genericos.save(p);

    }
}