/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author prac_hbt
 */
public class Componente {
    
    private String str_id_componente;
    private Modelo objModelo;
    private int int_estado;
    private double int_garantia;
    private String str_caracteristica;

    public Componente() {
    }

    public Componente(String str_id_componente, Modelo objModelo, int int_estado, double int_garantia, String str_caracteristica) {
        this.str_id_componente = str_id_componente;
        this.objModelo = objModelo;
        this.int_estado = int_estado;
        this.int_garantia = int_garantia;
        this.str_caracteristica = str_caracteristica;
    }

    public String getStr_id_componente() {
        return str_id_componente;
    }

    public void setStr_id_componente(String str_id_componente) {
        this.str_id_componente = str_id_componente;
    }



    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public double getInt_garantia() {
        return int_garantia;
    }

    public void setInt_garantia(double int_garantia) {
        this.int_garantia = int_garantia;
    }


    public Modelo getObjModelo() {
        return objModelo;
    }

    public void setObjModelo(Modelo objModelo) {
        this.objModelo = objModelo;
    }

    public String getStr_caracteristica() {
        return str_caracteristica;
    }

    public void setStr_caracteristica(String str_caracteristica) {
        this.str_caracteristica = str_caracteristica;
    }


    

    
        @Override
    public String toString()
    {
  
        return  "n/s:"+str_id_componente+" - "+getObjModelo().getObjTipo().getStr_nombre()+" "+
                getObjModelo().getObjMarca().getStr_nombre()+" Modelo "+
               getObjModelo().getStr_nombre()+" "+
               getObjModelo().getObjTipo().getStr_caractarestica()+" "+
               getStr_caracteristica();
    }
}
