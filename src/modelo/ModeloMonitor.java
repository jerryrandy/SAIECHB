package modelo;

import entidades.Monitor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloMonitor extends AbstractTableModel {
    List<Monitor> itemsAccesorios = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloMonitor() {
       itemsAccesorios = new ArrayList<Monitor>();
        headers = new ArrayList<String>();
        headers.add(new String("Nro.Patrimonial"));
         headers.add(new String("Nro.Serie"));
        headers.add(new String("Descripcion"));
    }

    public void limpiar()
    {
        itemsAccesorios.clear();
    }

   public boolean insertar(Monitor monitor)
    {

        boolean igual=true;

            for(int i=0;i<itemsAccesorios.size();i++)
                {
                  Monitor item = itemsAccesorios.get(i);
                    if(item.getStr_id_monitor().equals(monitor.getStr_id_monitor()))
                       igual=false;
                    if(item.getObjComponente().getStr_id_componente().equals(monitor.getObjComponente().getStr_id_componente()))
                        igual=false;
                }
            if(igual)
            itemsAccesorios.add(monitor);
        return igual;
    }
   


   public void removerItemDetalle(int rowIndex)
    {

        itemsAccesorios.remove(rowIndex);
    }
    
    public List<Monitor> listar()
    {
        return itemsAccesorios;
    }

    public int getRowCount() {
        return itemsAccesorios.size();
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
            Monitor datos = itemsAccesorios.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getStr_id_monitor();
           case 1:
                return 
                       datos.getObjComponente().getStr_id_componente();
           case 2:
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
