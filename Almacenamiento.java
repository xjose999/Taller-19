interface Almacenamiento {
    void guardar(String nombreArchivo, String contenido);
    String recuperar(String nombreArchivo);
}

class AlmacenamientoLocal implements Almacenamiento {
    @Override
    public void guardar(String nombreArchivo, String contenido) {
        System.out.println("Guardando " + nombreArchivo + " en el disco duro local.");
    }

    @Override
    public String recuperar(String nombreArchivo) {
        System.out.println("Buscando " + nombreArchivo + " en el disco duro local.");
        return "Contenido local de " + nombreArchivo;
    }
}

class AlmacenamientoNube implements Almacenamiento {
    @Override
    public void guardar(String nombreArchivo, String contenido) {
        System.out.println("Subiendo " + nombreArchivo + " al servidor en la nube.");
    }

    @Override
    public String recuperar(String nombreArchivo) {
        System.out.println("Descargando " + nombreArchivo + " desde el servidor en la nube.");
        return "Contenido remoto de " + nombreArchivo;
    }
}

class GestorArchivos {
    private Almacenamiento almacenamiento;

    public GestorArchivos(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void ejecutarGuardado(String archivo, String datos) {
        almacenamiento.guardar(archivo, datos);
    }

    public void ejecutarRecuperacion(String archivo) {
        String resultado = almacenamiento.recuperar(archivo);
        System.out.println("Resultado: " + resultado);
    }
}

public class PruebaInversionAlmacenamiento {
    public static void main(String[] args) {
        Almacenamiento local = new AlmacenamientoLocal();
        GestorArchivos gestorLocal = new GestorArchivos(local);
        gestorLocal.ejecutarGuardado("notas.txt", "Texto de prueba");
        gestorLocal.ejecutarRecuperacion("notas.txt");

        Almacenamiento nube = new AlmacenamientoNube();
        GestorArchivos gestorNube = new GestorArchivos(nube);
        gestorNube.ejecutarGuardado("foto.jpg", "Datos de imagen");
        gestorNube.ejecutarRecuperacion("foto.jpg");
    }
}