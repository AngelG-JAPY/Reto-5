package co.edu.imaster.misiontic2022.c2.reto4.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import co.edu.imaster.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;
import co.edu.imaster.misiontic2022.c2.reto4.util.JDBCUtilities;

public class ProyectoBancoDao {
    

    public List<ProyectoBancoVo> listaDeProyectosFinanciadosPorUnBanco(String banco) throws SQLException {
        var listaProyectos = new ArrayList<ProyectoBancoVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {

            var query = "SELECT ID_Proyecto ID,  Constructora , Ciudad ,p.Clasificacion Clasificacion , t.Estrato Estrato, l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido LIDER"
            +" FROM  Proyecto p"
            +" JOIN Lider l ON (p.ID_Lider = l.ID_Lider)"
            +" JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo)"
            +" WHERE Banco_Vinculado  = ?"
            +" ORDER BY p.Fecha_Inicio DESC ,p.Ciudad ASC , p.Constructora";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, banco);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var proyecto = new ProyectoBancoVo();
                proyecto.setId(rset.getInt("ID"));
                proyecto.setConstructora(rset.getString("Constructora"));
                proyecto.setCiudad(rset.getString("Ciudad"));
                proyecto.setClasificacion(rset.getString("Clasificacion"));
                proyecto.setEstrato(rset.getInt("Estrato"));
                proyecto.setLider(rset.getString("LIDER"));

                listaProyectos.add(proyecto);

            }

        } finally {

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

        return listaProyectos;
    }
    
    public List<String> nombreBancos() throws SQLException{
        var listaBancos = new ArrayList<String>();
        
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            
            var query = "SELECT Banco_Vinculado BANCO"
                    +" FROM proyecto p"
                    +" GROUP BY Banco_Vinculado";
            
            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();
            
            while(rset.next()){
                var banco = rset.getString("BANCO");
                
                listaBancos.add(banco);
            }
            
            
        }finally {
            
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
        
        
        
        return listaBancos;
    }
}
