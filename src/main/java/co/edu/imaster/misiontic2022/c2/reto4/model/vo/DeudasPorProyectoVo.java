package co.edu.imaster.misiontic2022.c2.reto4.model.vo;

public class DeudasPorProyectoVo {
    
    private Integer idProyecto;
    private Double valor;
    private String lider;

    public DeudasPorProyectoVo(){

    }

    public DeudasPorProyectoVo(Integer idProyecto, Double valor) {
        this.idProyecto = idProyecto;
        this.valor = valor;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    

}
