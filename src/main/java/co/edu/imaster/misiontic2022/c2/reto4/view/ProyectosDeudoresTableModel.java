/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.imaster.misiontic2022.c2.reto4.view;

import co.edu.imaster.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class ProyectosDeudoresTableModel extends AbstractTableModel {
    
    private List<DeudasPorProyectoVo> deudas;

    public ProyectosDeudoresTableModel() {
        deudas = new ArrayList<DeudasPorProyectoVo>();
    }
    
    public void llenarLista(List<DeudasPorProyectoVo> lista){
        this.deudas = lista;
    }
    
    public DeudasPorProyectoVo getProyecto(int row){
        return deudas.get(row);
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0:
               return "ID";
           case 1:
               return "Valor";
           case 2:
               return "Lider";
           default :
               return "";
       }
       
    }
    
    @Override
    public int getRowCount() {
        return deudas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var informacion = deudas.get(row);

        switch (column) {
            case 0:
                return informacion.getIdProyecto();
            case 1:
                return informacion.getValor();
            case 2:
                return informacion.getLider();
            default:
                return "";

        }
    }
    
}
