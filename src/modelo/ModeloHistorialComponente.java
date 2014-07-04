package modelo;



import entidades.HistorialComponente;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloHistorialComponente extends AbstractTableModel {
    List<HistorialComponente> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloHistorialComponente() {
       items = new ArrayList<HistorialComponente>();
        headers = new ArrayList<String>();
          headers.add(new String("Fecha"));
        headers.add(new String("Descripcion"));
    }

    public void limpiar()
    {
        items.clear();
    }

   public boolean insertar(HistorialComponente componente)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  HistorialComponente item = items.get(i);
                    if(item.getObjcomponente().getStr_id_componente().equals(item.getObjcomponente().getStr_id_componente()))
                       igual=false;
                  
                }
            if(igual)
            items.add(componente);
        return igual;
    }

        public void insertarLista(List<HistorialComponente> listaComponente)
    {
        items =listaComponente;
    }

   public void removerItemDetalle(int rowIndex)
    {

        items.remove(rowIndex);
    }
    
    public List<HistorialComponente> listar()
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
            HistorialComponente datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getDat_fecha();
   
            case 1:
                return 
                        datos.getStr_descripcion();


        }
        return null;
    }
}
