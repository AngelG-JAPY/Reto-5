package co.edu.imaster.misiontic2022.c2.reto4.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.imaster.misiontic2022.c2.reto4.model.dao.ComprasDeLiderDao;
import co.edu.imaster.misiontic2022.c2.reto4.model.dao.DeudasPorProyectoDao;
import co.edu.imaster.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;

public class ReportesController {
    
    private DeudasPorProyectoDao deudasProyecto;
    private ComprasDeLiderDao comprasLider;
    private ProyectoBancoDao proyectosBanco;

    public ReportesController(){
        deudasProyecto = new DeudasPorProyectoDao();
        comprasLider = new ComprasDeLiderDao();
        proyectosBanco = new ProyectoBancoDao();
    }

    public List<DeudasPorProyectoVo> deudas(double limite, String order, String form) throws SQLException {
        return deudasProyecto.deudas(limite, order, form);
    }

    public List<ComprasDeLiderVo> compras(int limite,String order, String form) throws SQLException {
        return comprasLider.comprasPorLider(limite, order, form);
    }

    public List<ProyectoBancoVo> proyectosPorBanco(String banco) throws SQLException {
        return proyectosBanco.listaDeProyectosFinanciadosPorUnBanco(banco);
    }
}
