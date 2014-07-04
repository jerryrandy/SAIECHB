package modelo;

import entidades.CPU;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloDetalleCPU extends AbstractTableModel {
    List<CPU.DetalleCPU> items = null;
    List<String> headers = null;

    public ModeloDetalleCPU() {
        items = new ArrayList<CPU.DetalleCPU>();
        headers = new ArrayList<String>();
        headers.add(new String("Nro.Serie"));
        headers.add(new String("Descripcion"));
    }

    public void limpiar()
    {
        items.clear();
    }


      public void insertarLista(List<CPU.DetalleCPU> listaDetalle)
    {
        items =listaDetalle;
    }


  public boolean insertarDetalle(CPU.DetalleCPU componentes)
    {
      
        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                   CPU.DetalleCPU item = items.get(i);
                    if(item.getObjComponente().getStr_id_componente().equals(componentes.getObjComponente().getStr_id_componente()))
                        igual=false;
                }
            if(igual)
            items.add(componentes);
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
    public List<CPU.DetalleCPU> listar()
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
        CPU.DetalleCPU datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getObjComponente().getStr_id_componente();
           case 1:
                return 
                       datos.getObjComponente().getObjModelo().getObjTipo().getStr_nombre()+" "+
                       datos.getObjComponente().getObjModelo().getObjMarca().getStr_nombre()+" "+
                       datos.getObjComponente().getObjModelo().getStr_nombre()+" "+
                       datos.getObjComponente().getObjModelo().getObjTipo().getStr_caractarestica()+" "+
                       datos.getObjComponente().getStr_caracteristica();
        }
        return null;
    }
}