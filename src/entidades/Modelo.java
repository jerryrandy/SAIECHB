/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author prac_hbt
 */
public class Modelo {
    private int int_id_modelo;
    private Marca objMarca;
    private Tipo objTipo;
    private String str_nombre;
    private String str_caracteristica;
    private int int_activa;

    public Modelo() {
    }

    public Modelo(int int_id_modelo, Marca objMarca, Tipo objTipo, String str_nombre, String str_caracteristica, int int_activa) {
        this.int_id_modelo = int_id_modelo;
        this.objMarca = objMarca;
        this.objTipo = objTipo;
        this.str_nombre = str_nombre;
        this.str_caracteristica = str_caracteristica;
        this.int_activa = int_activa;
    }

    public int getInt_activa() {
        return int_activa;
    }

    public void setInt_activa(int int_activa) {
        this.int_activa = int_activa;
    }
    

    public int getInt_id_modelo() {
        return int_id_modelo;
    }

    public void setInt_id_modelo(int int_id_modelo) {
        this.int_id_modelo = int_id_modelo;
    }

    public Marca getObjMarca() {
        return objMarca;
    }

    public void setObjMarca(Marca objMarca) {
        this.objMarca = objMarca;
    }

    public Tipo getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(Tipo objTipo) {
        this.objTipo = objTipo;
    }

    public String getStr_caracteristica() {
        return str_caracteristica;
    }

    public void setStr_caracteristica(String str_caracteristica) {
        this.str_caracteristica = str_caracteristica;
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
         return  objMarca.getStr_nombre()+" "+str_nombre;
    }
}

