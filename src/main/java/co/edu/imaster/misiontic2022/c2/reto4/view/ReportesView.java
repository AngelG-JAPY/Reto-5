package co.edu.imaster.misiontic2022.c2.reto4.view;

import java.sql.SQLException;

import co.edu.imaster.misiontic2022.c2.reto4.controller.ReportesController;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;

public class ReportesView {

    private ReportesController controlador;

    public ReportesView() {
        controlador = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD",
                    "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));

            try {
                var listaProyectos = controlador.proyectosPorBanco(banco);

                for (ProyectoBancoVo proyecto : listaProyectos) {
                    System.out.printf("%3d %-25s %-20s %-15s %7d %-30s %n", proyecto.getId(), proyecto.getConstructora(),
                            proyecto.getCiudad(), proyecto.getClasificacion(), proyecto.getEstrato(), proyecto.getLider());
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {

        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO " + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));

            try {
                var listaDeudas = controlador.deudas(limiteInferior,"","");

                for (DeudasPorProyectoVo proyecto : listaDeudas) {
                    System.out.printf("%3d %,15.1f %n", proyecto.getIdProyecto(), proyecto.getValor());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES " + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));

        try {
            var listaGastos = controlador.compras();

            for (ComprasDeLiderVo lider : listaGastos) {
                System.out.printf("%-25s %,15.1f %n", lider.getLider(), lider.getValor());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

}
