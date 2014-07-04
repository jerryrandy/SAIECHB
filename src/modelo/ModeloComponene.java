package modelo;



import entidades.DetalleComponente;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloComponene extends AbstractTableModel {
    List<DetalleComponente> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloComponene() {
       items = new ArrayList<DetalleComponente>();
        headers = new ArrayList<String>();
         headers.add(new String("Nro.Serie"));
         headers.add(new String("Nro. O. Compra"));
          headers.add(new String("Adquisición"));
          headers.add(new String("T.Garantia"));
          headers.add(new String("Garantia"));        
           headers.add(new String("Tipo"));
         headers.add(new String("Marca"));
        headers.add(new String("Descripcion"));
    }

    public void limpiar()
    {
        items.clear();
    }

   public boolean insertar(DetalleComponente componente)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  DetalleComponente item = items.get(i);
                    if(item.getObjComponente().getStr_id_componente().equals(item.getObjComponente().getStr_id_componente()))
                       igual=false;
                  
                }
            if(igual)
            items.add(componente);
        return igual;
    }

        public void insertarLista(List<DetalleComponente> listaComponente)
    {
        items =listaComponente;
    }

   public void removerItemDetalle(int rowIndex)
    {

        items.remove(rowIndex);
    }
    
    public List<DetalleComponente> listar()
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
     
   
    public static synchronized java.util.Date OperarMeses(java.util.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MONTH, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }
    
        public static synchronized int DiasGarantia(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
            DetalleComponente datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getObjComponente().getStr_id_componente();
   
            case 1:
                return 
                         datos.getObjOrdenCompra().getStr_id_orden_compra();
            case 2:
                return 
                         datos.getObjOrdenCompra().getDat_fecha();
           
            case 3:
                
                       if(datos.getObjComponente().getInt_garantia()==0.25)
                           return 
                                   "3 meses";
                       else if(datos.getObjComponente().getInt_garantia()==0.5)
                           return 
                                   "6 meses";
                        else if(datos.getObjComponente().getInt_garantia()==1)
                           return 
                                   "1 año";
                        else if(datos.getObjComponente().getInt_garantia()==2)
                           return 
                                   "2 años";
                       else if(datos.getObjComponente().getInt_garantia()==3)
                           return 
                                   "3 años";
             case 4:
                 String res="";
                 int mes=0;
                        if(datos.getObjComponente().getInt_garantia()==0.25)
                           mes=3;
                       else if(datos.getObjComponente().getInt_garantia()==0.5)
                           mes=6;
                        else if(datos.getObjComponente().getInt_garantia()==1)
                           mes=12;
                        else if(datos.getObjComponente().getInt_garantia()==2)
                           mes=24;
                       else if(datos.getObjComponente().getInt_garantia()==3)
                           mes=36;
                 java.util.Date fecha=OperarMeses( datos.getObjOrdenCompra().getDat_fecha(),mes);
                 int Dias = DiasGarantia(new Date(),fecha);
                 if(Dias>-1)
                       return Dias +" días";
                 else
                    return "Expiró";

             case 5:
                return 
                        datos.getObjComponente().getObjModelo().getObjTipo().getStr_nombre();
            case 6:
                return 
                       datos.getObjComponente().getObjModelo().getObjMarca().getStr_nombre();
                          
           case 7:
                return 
                         datos.getObjComponente().getObjModelo().getStr_nombre()+" "+
                         datos.getObjComponente().getObjModelo().getObjTipo().getStr_caractarestica()+" "+
                          datos.getObjComponente().getStr_caracteristica();

        }
        return null;
    }
}
