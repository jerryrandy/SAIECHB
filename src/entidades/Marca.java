/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


/**
 *
 * @author Toditos
 */
public class Marca {
    private int int_id_marca;
    private String str_nombre;
    private int intl_activa;
    
    private String str_descripcion;
     

    public Marca() {
    }

    public Marca(int int_id_marca, String str_nombre) {
        this.int_id_marca = int_id_marca;
        this.str_nombre = str_nombre;
    }

    
    public Marca(int int_id_marca, String str_nombre, int intl_activa, String str_descripcion) {
        this.int_id_marca = int_id_marca;
        this.str_nombre = str_nombre;
        this.intl_activa = intl_activa;
        this.str_descripcion = str_descripcion;
    }
    

    public int getInt_id_marca() {
        return int_id_marca;
    }

    public void setInt_id_marca(int int_id_marca) {
        this.int_id_marca = int_id_marca;
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

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
      @Override
    public String toString()
    {
        return str_nombre;
    }
     
}
