interface ServicioAutenticacion {
    boolean autenticar(String usuario, String credencial);
}

class AutenticacionLocal implements ServicioAutenticacion {
    @Override
    public boolean autenticar(String usuario, String credencial) {
        System.out.println("Verificando usuario " + usuario + " en la base de datos local.");
        return "admin".equals(usuario) && "12345".equals(credencial);
    }
}

class AutenticacionOAuth implements ServicioAutenticacion {
    @Override
    public boolean autenticar(String usuario, String credencial) {
        System.out.println("Conectando con servidor OAuth externo para validar a " + usuario + ".");
        return "token_valido".equals(credencial);
    }
}

class GestorAutenticacion {
    private ServicioAutenticacion servicio;

    public GestorAutenticacion(ServicioAutenticacion servicio) {
        this.servicio = servicio;
    }

    public void iniciarSesion(String usuario, String credencial) {
        if (servicio.autenticar(usuario, credencial)) {
            System.out.println("Acceso concedido para: " + usuario);
        } else {
            System.out.println("Acceso denegado para: " + usuario);
        }
    }
}

public class PruebaInversionDependencia {
    public static void main(String[] args) {
        ServicioAutenticacion local = new AutenticacionLocal();
        GestorAutenticacion gestorLocal = new GestorAutenticacion(local);
        gestorLocal.iniciarSesion("admin", "12345");

        ServicioAutenticacion oauth = new AutenticacionOAuth();
        GestorAutenticacion gestorOAuth = new GestorAutenticacion(oauth);
        gestorOAuth.iniciarSesion("manuel@correo.com", "token_valido");
    }
}