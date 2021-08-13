package co.edu.imaster.misiontic2022.c2.reto4.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.edu.imaster.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.imaster.misiontic2022.c2.reto4.util.JDBCUtilities;
import java.util.HashSet;
import java.util.Set;

public class DeudasPorProyectoDao {
    
    public List<DeudasPorProyectoVo> deudas(double limite, String order, String form) throws SQLException {
        
        var listaDeDeudas = new ArrayList<DeudasPorProyectoVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try{

            var query = "SELECT p.ID_Proyecto ID, SUM(c.Cantidad * mc.Precio_Unidad) VALOR, l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido LIDER"
                    +" FROM Compra c"
                    +" JOIN MaterialConstruccion mc  ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)"
                    +" JOIN Proyecto p ON (c.ID_Proyecto = p.ID_Proyecto)"
                    +" JOIN Lider l ON (p.ID_Lider = l.ID_Lider)"
                    +" WHERE Pagado = 'No' "
                    +" GROUP BY p.ID_Proyecto"
                    +" HAVING VALOR > ?"
                    +" ORDER BY "+order+" "+form+"";

            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, limite);
            rset = stmt.executeQuery();

            while(rset.next()){
                var informacion = new DeudasPorProyectoVo(rset.getInt("ID"), rset.getDouble("VALOR"));
                informacion.setLider(rset.getString("LIDER"));
                
                listaDeDeudas.add(informacion);
            }

        }finally{

            if(rset != null){
                rset.close();
            }

            if(stmt != null){
                stmt.close();
            }

            if(conn != null){
                conn.close();
            }
        }
        return listaDeDeudas;
    }
}
