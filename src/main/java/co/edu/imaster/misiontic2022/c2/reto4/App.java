package co.edu.imaster.misiontic2022.c2.reto4;

import co.edu.imaster.misiontic2022.c2.reto4.view.ReportesView;

/**
 * Hello world!
 *
 */
public class App {

    public static void xd(String[] args) {

        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);


        /*
         * var reportesView = new ReportesView(); var limiteInferior = 50_000d;
         * reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
         */

 /*
        var reportesView = new ReportesView();
        reportesView.lideresQueMasGastan();*/
    }
}
