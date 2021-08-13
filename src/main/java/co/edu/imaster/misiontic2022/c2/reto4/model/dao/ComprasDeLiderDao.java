package co.edu.imaster.misiontic2022.c2.reto4.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import co.edu.imaster.misiontic2022.c2.reto4.util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> comprasPorLider(int limite, String order, String form) throws SQLException {
        var compras = new ArrayList<ComprasDeLiderVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {

            var query = "SELECT l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido LIDER,  SUM(c.Cantidad * mc.Precio_Unidad)  VALOR, p.ID_Proyecto ID"
            +" FROM Lider l"
            +" JOIN Proyecto p ON (p.ID_Lider = l.ID_Lider)"
            +" JOIN Compra c ON (c.ID_Proyecto = p.ID_Proyecto)"
            +" JOIN MaterialConstruccion mc ON (mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion)"
            +" GROUP BY LIDER"
            +" ORDER BY "+order+" "+form+" "
            +" LIMIT ?";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1,limite);
            rset = stmt.executeQuery();

            while(rset.next()){
                var resultado = new ComprasDeLiderVo();
                resultado.setLider(rset.getString("LIDER"));
                resultado.setValor(rset.getDouble("VALOR"));
                resultado.setID(rset.getString("ID"));
                compras.add(resultado);
            }

        } finally {
            if (rset != null) {
                rset.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return compras;
    }
}
