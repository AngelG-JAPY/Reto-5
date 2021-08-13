/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.imaster.misiontic2022.c2.reto4.view;

import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USUARIO
 */
public class GastosTableModel extends AbstractTableModel {
    
    
    private List<ComprasDeLiderVo> compras;
    
    public GastosTableModel(){
        compras = new ArrayList<ComprasDeLiderVo>();
    }
    
    
     public void llenarLista(List<ComprasDeLiderVo> lista){
        this.compras = lista;
    }
    
    public ComprasDeLiderVo getProyecto(int row){
        return compras.get(row);
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
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var informacion = compras.get(row);

        switch (column) {
            case 0:
                return informacion.getID();
            case 1:
                return informacion.getValor();
            case 2:
                return informacion.getLider();
            default:
                return "";

        }
    }
    
}
