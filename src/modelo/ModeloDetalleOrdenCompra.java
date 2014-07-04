package modelo;

import entidades.OrdenCompra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloDetalleOrdenCompra extends AbstractTableModel {
    List<OrdenCompra.DetalleOrdenCompra> items = null;
    List<String> headers = null;

    public ModeloDetalleOrdenCompra() {
        items = new ArrayList<OrdenCompra.DetalleOrdenCompra>();
        headers = new ArrayList<String>();
        headers.add(new String("Nro.Serie"));
         headers.add(new String("Tipo"));
         headers.add(new String("Marca"));
        headers.add(new String("Descripcion"));
    }

    public void limpiar()
    {
        items.clear();
    }
    

      public void insertarLista(List<OrdenCompra.DetalleOrdenCompra> listaDetalle)
    {
        items =listaDetalle;
    }

    public boolean insertarDetalle(OrdenCompra.DetalleOrdenCompra ordenCompra)
    {
      
        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                    OrdenCompra.DetalleOrdenCompra item = items.get(i);
                    if(item.getObComponente().getStr_id_componente().equals(ordenCompra.getObComponente().getStr_id_componente()))
                        igual=false;
                }
            if(igual)
            items.add(ordenCompra);
        return igual;
    }

    public void removerItemDetalle(int rowIndex)
    {

        items.remove(rowIndex);
    }
     public void removerItems()
    {

        items.clear();
    }
    public List<OrdenCompra.DetalleOrdenCompra> listar()
    {
        return items;
    }

    public int getRowCount() {
        return items.size();
    }

    public int getColumnCount() {
        return headers.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headers.get(columnIndex).toString();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        OrdenCompra.DetalleOrdenCompra datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getObComponente().getStr_id_componente();
           case 1:
                return 
                        datos.getObComponente().getObjModelo().getObjTipo().getStr_nombre();
            case 2:
                return 
                       datos.getObComponente().getObjModelo().getObjMarca().getStr_nombre();
           case 3:
                return 
                        "Modelo "+datos.getObComponente().getObjModelo().getStr_nombre()+" "+
                         datos.getObComponente().getObjModelo().getObjTipo().getStr_caractarestica()+" "+
                          datos.getObComponente().getStr_caracteristica();

        }
        return null;
    }
}