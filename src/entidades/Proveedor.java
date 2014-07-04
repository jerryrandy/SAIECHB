/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


/**
 *
 * @author Toditos
 */
public class Proveedor {
    private int int_id_proveedor;
    private String str_nombre;
    private String str_telefono;
    private String str_direccion;
    private String str_fax;
    private int intl_activa;  
    private String str_descripcion;
     

    public Proveedor() {
    }

    public Proveedor(int int_id_proveedor, String str_nombre, String str_telefono, String str_direccion, String str_fax, int intl_activa, String str_descripcion) {
        this.int_id_proveedor = int_id_proveedor;
        this.str_nombre = str_nombre;
        this.str_telefono = str_telefono;
        this.str_direccion = str_direccion;
        this.str_fax = str_fax;
        this.intl_activa = intl_activa;
        this.str_descripcion = str_descripcion;
    }

    

    public int getInt_id_proveedor() {
        return int_id_proveedor;
    }

    public void setInt_id_proveedor(int int_id_proveedor) {
        this.int_id_proveedor = int_id_proveedor;
    }

    public int getIntl_activa() {
        return intl_activa;
    }

    public void setIntl_activa(int intl_activa) {
        this.intl_activa = intl_activa;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_fax() {
        return str_fax;
    }

    public void setStr_fax(String str_fax) {
        this.str_fax = str_fax;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

    


    
      @Override
    public String toString()
    {
        return str_nombre;
    }
     
}
