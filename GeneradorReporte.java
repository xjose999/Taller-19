interface GeneradorReporte {
    void generar(String datos);
}

class ReportePDF implements GeneradorReporte {
    @Override
    public void generar(String datos) {
        System.out.println("Exportando reporte en formato PDF con los datos: " + datos);
    }
}

class ReporteExcel implements GeneradorReporte {
    @Override
    public void generar(String datos) {
        System.out.println("Exportando reporte en formato Excel con los datos: " + datos);
    }
}

class GestorReportes {
    private GeneradorReporte generador;

    public GestorReportes(GeneradorReporte generador) {
        this.generador = generador;
    }

    public void procesarReporte(String informacion) {
        generador.generar(informacion);
    }
}

public class PruebaInversionReportes {
    public static void main(String[] args) {
        GeneradorReporte pdf = new ReportePDF();
        GestorReportes gestorPDF = new GestorReportes(pdf);
        gestorPDF.procesarReporte("Ventas_Mayo");

        GeneradorReporte excel = new ReporteExcel();
        GestorReportes gestorExcel = new GestorReportes(excel);
        gestorExcel.procesarReporte("Inventario_Actual");
    }
}
