/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class DetalleComponente {
   private Componente objComponente;
    private OrdenCompra objOrdenCompra;


   
    public DetalleComponente() {
    }

    public DetalleComponente(Componente objComponente, OrdenCompra objOrdenCompra) {
        this.objComponente = objComponente;
        this.objOrdenCompra = objOrdenCompra;
    }

    public Componente getObjComponente() {
        return objComponente;
    }

    public void setObjComponente(Componente objComponente) {
        this.objComponente = objComponente;
    }

    public OrdenCompra getObjOrdenCompra() {
        return objOrdenCompra;
    }

    public void setObjOrdenCompra(OrdenCompra objOrdenCompra) {
        this.objOrdenCompra = objOrdenCompra;
    }

    
    


    

     @Override
    public String toString()
    {
        return objOrdenCompra.getStr_id_orden_compra();
    }
}
