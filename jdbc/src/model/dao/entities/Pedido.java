package model.dao.entities;
import java.sql.Date;

public class Pedido {
    private Integer id_pedido;
    private String fk_cpf;
    private String fk_codigo;
    private Date data;
    private Double total_compra;

    public Integer getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }
    public String getFk_cpf() {
        return fk_cpf;
    }
    public void setFk_cpf(String fk_cpf) {
        this.fk_cpf = fk_cpf;
    }
    public String getFk_codigo() {
        return fk_codigo;
    }
    public void setFk_codigo(String fk_codigo) {
        this.fk_codigo = fk_codigo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Double getTotal_compra() {
        return total_compra;
    }
    public void setTotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido='" + id_pedido + '\'' +
                ", fk_cpf='" + fk_cpf + '\'' +
                ", fk_codigo='" + fk_codigo + '\'' +
                ", date_hora=" + data +
                ", total_compra=" + total_compra +
                '}';
    }
}
