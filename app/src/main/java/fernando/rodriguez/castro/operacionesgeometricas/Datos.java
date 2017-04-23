package fernando.rodriguez.castro.operacionesgeometricas;

import java.util.ArrayList;

/**
 *
 */
public class Datos {
    private static ArrayList<Operacion> op = new ArrayList();

    public static void guardar(Operacion p){
        op.add(p);
    }

    public static ArrayList<Operacion> getOperaciones(){
        return op;
    }
}
