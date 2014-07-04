package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class OrdenCompra implements Serializable {

    private String str_id_orden_compra;
    private Proveedor objProveedor;
    private Date dat_fecha;
    private List<DetalleOrdenCompra> detalleOrdenCompra;
    
    public OrdenCompra() {
        this.dat_fecha = new Date();
    }

    public OrdenCompra(String str_id_orden_compra, Proveedor objProveedor, Date dat_fecha, List<DetalleOrdenCompra> detalleOrdenCompra) {
        this.str_id_orden_compra = str_id_orden_compra;
        this.objProveedor = objProveedor;
        this.dat_fecha = dat_fecha;
        this.detalleOrdenCompra = detalleOrdenCompra;
    }
    
    public static class DetalleOrdenCompra implements Serializable
    {
        private Componente objComponente;

 

        public DetalleOrdenCompra(Componente objComponente) {
            this.objComponente = objComponente;
        }

        public Componente getObComponente() {
            return objComponente;
        }

        public void setObjComponente(Componente objComponente) {
            this.objComponente = objComponente;
        }

        
    }

    public Date getDat_fecha() {
        return dat_fecha;
    }

    public void setDat_fecha(Date dat_fecha) {
        this.dat_fecha = dat_fecha;
    }

    public List<DetalleOrdenCompra> getDetalleOrdenCompra() {
        return detalleOrdenCompra;
    }

    public void setDetalleOrdenCompra(List<DetalleOrdenCompra> detalleOrdenCompra) {
        this.detalleOrdenCompra = detalleOrdenCompra;
    }

    public String getStr_id_orden_compra() {
        return str_id_orden_compra;
    }

    public void setStr_id_orden_compra(String str_id_orden_compra) {
        this.str_id_orden_compra = str_id_orden_compra;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }


      @Override
    public String toString()
    {
          String imprimir=str_id_orden_compra+" "+objProveedor.getStr_nombre()+" "+dat_fecha;
        return imprimir;
    }

}
