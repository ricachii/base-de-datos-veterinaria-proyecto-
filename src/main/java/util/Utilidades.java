package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
    public static String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public static boolean validarCorreoElectronico(String correo) {
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
