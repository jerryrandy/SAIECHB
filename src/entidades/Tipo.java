/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author prac_hbt
 */
public class Tipo {
    private int int_id_tipo;
    private String str_nombre;
    private int int_ubicacion;
    private String str_caractarestica;
    private int int_activa;

    public Tipo() {
    }

    public Tipo(int int_id_tipo, String str_nombre, int int_ubicacion, String str_caractarestica, int int_activa) {
        this.int_id_tipo = int_id_tipo;
        this.str_nombre = str_nombre;
        this.int_ubicacion = int_ubicacion;
        this.str_caractarestica = str_caractarestica;
        this.int_activa = int_activa;
    }

    public String getStr_caractarestica() {
        return str_caractarestica;
    }

    public void setStr_caractarestica(String str_caractarestica) {
        this.str_caractarestica = str_caractarestica;
    }
    
    



    public int getInt_activa() {
        return int_activa;
    }

    public void setInt_activa(int int_activa) {
        this.int_activa = int_activa;
    }

    public int getInt_id_tipo() {
        return int_id_tipo;
    }

    public void setInt_id_tipo(int int_id_tipo) {
        this.int_id_tipo = int_id_tipo;
    }

    public int getInt_ubicacion() {
        return int_ubicacion;
    }

    public void setInt_ubicacion(int int_ubicacion) {
        this.int_ubicacion = int_ubicacion;
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
