/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmArea.java
 *
 * Created on 06/09/2011, 05:59:13 PM
 */
package gui;
import com.*;
import entidades.*;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.*;
/**
 *
 * @author Toditos
 */
public class frmArmadoComputadoraPoPartes extends javax.swing.JFrame {
    
 private Usuario  objUsuarioAdmin= new Usuario();

    private ComponenteCOM objComponenteCOM = new ComponenteCOM();
    private DepartamentoCOM objDepartamentoCOM = new DepartamentoCOM();
     private AreaCOM objAreaCOM = new AreaCOM();
    private EmpleadoCOM objEmpleadoCOM= new EmpleadoCOM(); 
    private ComputadorCOM objComputadorCOM= new ComputadorCOM(); 
     private CPUCOM objCPUCOM= new CPUCOM(); 
     private MonitorCOM objMonitorCOM= new MonitorCOM(); 
           private AccesoriosCOM objAccesoriosCOM= new AccesoriosCOM(); 
           private CPatrimonialCOM objCPatrimonialCOM= new CPatrimonialCOM();
           private SoftwareCOM objSoftwareCOM= new SoftwareCOM();
           

     
      private ModeloDetalleCPU modeloTablaComponente = new ModeloDetalleCPU();
       private ModeloAccesorios modeloTablaAccesorios = new ModeloAccesorios();
      

   
    
     private DefaultComboBoxModel ComboDepartamento = new DefaultComboBoxModel();
      private DefaultComboBoxModel ComboArea = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboEmpleado = new DefaultComboBoxModel();
    
     
     private DefaultListModel modeloEmpleado = new DefaultListModel();
     

    public frmArmadoComputadoraPoPartes(Usuario  usuario) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);
         this.objUsuarioAdmin=usuario;
   

       
       
         
        
         tablaDetalleCPUNuevo.setModel(modeloTablaComponente);
         tablaDetalleAcc.setModel(modeloTablaAccesorios);

         
          cb_ListarArea.setModel(ComboArea);
         cb_ListarDepartamento.setModel(ComboDepartamento);
         


         cb_ListarEmpleado.setModel(ComboEmpleado);
         
         jListaEmpleado.setModel(modeloEmpleado);

          
          
         
         tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMaxWidth(100);
         tablaDetalleAcc.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMinWidth(100);
         tablaDetalleAcc.getColumnModel().getColumn(0).setMinWidth(100);
           tablaDetalleAcc.getColumnModel().getColumn(1).setMaxWidth(100);
            tablaDetalleAcc.getColumnModel().getColumn(1).setMinWidth(100);
           

        listarComboMonitor();
         listarComboDepartamento();
         listarEmpleado();
         listarComboAccesorios();

         listarCPU();

    }
     public void listarComboMonitor()
    {
         DefaultComboBoxModel ComboComponenteMonitor = new DefaultComboBoxModel();
        ComboComponenteMonitor.removeAllElements();
        ComboComponenteMonitor.addElement("(Seleccione una Opcion)");
         try {
            List<Monitor> listMonitor = objMonitorCOM.ListarMonitorXEstado(4);
            if(listMonitor!=null)
            {
                for(Monitor c : listMonitor)
                {
                    ComboComponenteMonitor.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
          cb_ListarMonitor.setModel(ComboComponenteMonitor);
         
  
    }
       
              public void listarCPU()
    {
        DefaultComboBoxModel ComboCPU = new DefaultComboBoxModel();
        ComboCPU.removeAllElements();
          ComboCPU.addElement("(Seleccione una Opcion)");
        try {
            List<CPU> listCPU = objCPUCOM.listarTodosOrdenado(1);
            if(listCPU!=null)
            {
                for(CPU c : listCPU)
                {
                    ComboCPU.addElement(c);
                }
            }
        } catch (Exception e) {
      
        }
         cb_ListarCPU.setModel(ComboCPU);
    }
         
       public void listarEmpleado()
    {     
         modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarEmpleadoAsignado(0);
            if(listEmpleado!=null)
            {
                for(Empleado e : listEmpleado)
                {
                    modeloEmpleado.addElement(e);
                }
            }           
        } catch (Exception e) {
         
        }
    }
    
              public void listarComboDepartamento()
    {
        ComboDepartamento.removeAllElements();
        ComboDepartamento.addElement("(Seleccione una Opcion)");
        try {
            List<Departamento> listDepartamento = objDepartamentoCOM.listarTodosOrdenado();
            if(listDepartamento!=null)
            {
                
                for(Departamento d : listDepartamento)
                {
                    ComboDepartamento.addElement(d);
                }
            }
           
        } catch (Exception e) {
        
        }
    }
          
   
  
            
 
          public void listarComboAccesorios()
    {
         DefaultComboBoxModel ComboComponenteAcc = new DefaultComboBoxModel();
        ComboComponenteAcc.removeAllElements();
        ComboComponenteAcc.addElement("(Seleccione una Opcion)");
         try {
            List<Accesorios> listAccesorios = objAccesoriosCOM.listarTodosOrdenado(4);
            if(listAccesorios!=null)
            {
                for(Accesorios a : listAccesorios)
                {
                    ComboComponenteAcc.addElement(a);
                }
            }
        } catch (Exception e) {
           
        }
         cb_ListarComponenteAcc.setModel(ComboComponenteAcc);
  
    }
          
          

       public void limpiarControles()
    {

        cb_ListarDepartamento.setSelectedIndex(0);
      cb_ListarComponenteAcc.setSelectedIndex(0);
     cb_ListarMonitor.setSelectedIndex(0);
        cb_ListarCPU.setSelectedIndex(0);
      txtIdComputador.setText("");
      txtBuscar.setText("");
      modeloTablaAccesorios.limpiar();
      modeloTablaAccesorios.fireTableDataChanged();

        listarComboMonitor();
         listarComboDepartamento();
         listarEmpleado();
         listarComboAccesorios();
         listarCPU();

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cb_ListarEmpleado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_ListarArea = new javax.swing.JComboBox();
        cb_ListarDepartamento = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaEmpleado = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        txtIdComputador = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblNComputador = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDetalleCPUNuevo = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblSistemaNuevo = new javax.swing.JLabel();
        cb_ListarCPU = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cb_ListarMonitor = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        lblIdMonitorN = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        cb_ListarComponenteAcc = new javax.swing.JComboBox();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleAcc = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Ingreso de Computador por Partes");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Armado de Computador por Partes");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editclear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setText("Encargado :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setText("Cargo :");

        lblCargo.setFont(new java.awt.Font("Arial", 1, 12));
        lblCargo.setText("Autogenerado");

        cb_ListarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarEmpleadoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Departamento :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Area :");

        cb_ListarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarAreaActionPerformed(evt);
            }
        });

        cb_ListarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarDepartamentoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 51, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jListaEmpleado.setVerifyInputWhenFocusTarget(false);
        jListaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListaEmpleado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_ListarEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_ListarArea, 0, 199, Short.MAX_VALUE)
                                    .addComponent(cb_ListarDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ListarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_ListarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_ListarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCargo)
                                    .addComponent(jLabel8))))))
                .addContainerGap())
        );

        txtIdComputador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdComputadorKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel23.setText("Nombre de Computador:");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPUNuevo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPUNuevo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(tablaDetalleCPUNuevo);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel26.setText("Nro. Patrimonial :");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel27.setText("Sistema Operativo :");

        lblSistemaNuevo.setFont(new java.awt.Font("Arial", 1, 12));
        lblSistemaNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSistemaNuevo.setText("Autogenerado");

        cb_ListarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarCPUActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cpu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSistemaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cb_ListarCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(lblSistemaNuevo)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Monitor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        cb_ListarMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarMonitorActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monitor.png"))); // NOI18N

        lblIdMonitorN.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdMonitorN.setText("Autogenerado");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setText("Nro. Patrimonial :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdMonitorN, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cb_ListarMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cb_ListarMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lblIdMonitorN))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevos Accesorios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_detalle_prod.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar Accesorios");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_detalle_prod.png"))); // NOI18N
        btnQuitar.setToolTipText("Quitar Accesorios");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tablaDetalleAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDetalleAcc);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_ListarComponenteAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitar)
                            .addComponent(btnAgregar))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(cb_ListarComponenteAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar)))
                .addGap(22, 22, 22))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mouse.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(94, 94, 94))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(77, 77, 77))
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(txtIdComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
     if(objUsuarioAdmin.getInt_nivel()==1)
     new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
    else
        new frmPrincipalUser(objUsuarioAdmin).setVisible(true);

}//GEN-LAST:event_formWindowClosed

    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
           
  try { 
        Computador objComputador= new Computador();
        objComputador.setObjCPU(((CPU)cb_ListarCPU.getSelectedItem()));
        objComputador.setObjMonitor(((Monitor)cb_ListarMonitor.getSelectedItem()));
        
        objComputador.setObjEmpleado(((Empleado)cb_ListarEmpleado.getSelectedItem()));
        objComputador.setInt_estado(0);
        objComputador.setStr_id_computador(txtIdComputador.getText());
        if(objComputadorCOM.insertar(objComputador))
            JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");
     
        if(modeloTablaAccesorios!=null)
            for(Accesorios objAccesorios: modeloTablaAccesorios.listar())
               {                   
                    
                objAccesoriosCOM.insertarComputadorAccesorios( txtIdComputador.getText(),objAccesorios.getStr_id_accesorios());
            
                    objComponenteCOM.actualizarEstado(objAccesorios.getObjComponente().getStr_id_componente(),2);     

               }
            
           objComponenteCOM.actualizarEstado(((Monitor)cb_ListarMonitor.getSelectedItem()).getObjComponente().getStr_id_componente(),2);   
             objCPUCOM.actualizarEstado(((CPU)cb_ListarCPU.getSelectedItem()).getStr_id_cpu(),0);
      
        } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPoPartes.class.getName()).log(Level.SEVERE, null, ex);
        }

 limpiarControles();


    }//GEN-LAST:event_btnGrabarActionPerformed

    private void cb_ListarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarDepartamentoActionPerformed
        // TODO add your handling code here:
          ComboArea.removeAllElements();
 ComboArea.addElement("(Seleccione una Opcion)");
 if(cb_ListarDepartamento.getSelectedIndex()!=0)
        try {
            List<Area> listGrupo = objAreaCOM.listarActivosXDepartamento(((Departamento)cb_ListarDepartamento.getSelectedItem()).getInt_id_departamento());
            if(listGrupo!=null)
            {
                for(Area c : listGrupo)
                {
                    ComboArea.addElement(c);
                }
            }
        } catch (Exception e) {
        
        }
    }//GEN-LAST:event_cb_ListarDepartamentoActionPerformed

    private void cb_ListarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarAreaActionPerformed

       
        ComboEmpleado = new DefaultComboBoxModel();
        ComboEmpleado.removeAllElements();
        ComboEmpleado.addElement("(Seleccione una Opcion)");
         if(cb_ListarArea.getSelectedIndex()!=0)
            try {
                List<Empleado> listEmpleado = objEmpleadoCOM.listarEmpleadoXAreaAsigando(((Area)cb_ListarArea.getSelectedItem()).getInt_id_area(),0);
                if(listEmpleado!=null)
                {
                    for(Empleado e : listEmpleado)
                    {
                        ComboEmpleado.addElement(e);
                    }
                }           
            } catch (Exception e) {
              
            }
         cb_ListarEmpleado.setModel(ComboEmpleado);
          if(cb_ListarArea.getSelectedIndex()==0 && cb_ListarDepartamento.getSelectedIndex()==0)
               lblCargo.setText("Autogenerado");
          
    }//GEN-LAST:event_cb_ListarAreaActionPerformed

    private void cb_ListarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarEmpleadoActionPerformed
        // TODO add your handling code here:
         if(cb_ListarArea.getSelectedIndex()!=0 && cb_ListarEmpleado.getSelectedIndex()!=0)
                lblCargo.setText(((Empleado)cb_ListarEmpleado.getSelectedItem()).getObjCargo().getStr_nombre());
    }//GEN-LAST:event_cb_ListarEmpleadoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
          modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarFiltroAsignado(txtBuscar.getText(),0);
            if(listEmpleado!=null)
            {
                for(Empleado e : listEmpleado)
                {
                    modeloEmpleado.addElement(e);
                }
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jListaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaEmpleadoMouseClicked
        // TODO add your handling code here:
               String criterio = jListaEmpleado.getSelectedValue().toString();
       if(!"".equals(criterio))
       {         

                  
                int departamento=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getObjArea().getObjDepartamento().getInt_id_departamento();

                   for(int i=1;i<cb_ListarDepartamento.getItemCount();i++)
                   {
                       int buscarDepartamento=((Departamento)cb_ListarDepartamento.getModel().getElementAt(i)).getInt_id_departamento();
                       if(departamento==buscarDepartamento)
                             cb_ListarDepartamento.setSelectedIndex(i); 
                   }
                   
                  int area=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getObjArea().getInt_id_area();

                   for(int i=1;i<cb_ListarArea.getItemCount();i++)
                   {
                       int buscarArea=((Area)cb_ListarArea.getModel().getElementAt(i)).getInt_id_area();
                       if(area==buscarArea)
                             cb_ListarArea.setSelectedIndex(i); 
                   }
                   
                    int empleado=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getInt_id_empleado();
                   for(int i=1;i<cb_ListarEmpleado.getItemCount();i++)
                   {
                       int buscarEmpleado=((Empleado)cb_ListarEmpleado.getModel().getElementAt(i)).getInt_id_empleado();
                       if(empleado==buscarEmpleado)
                             cb_ListarEmpleado.setSelectedIndex(i); 
                   }

       }
    }//GEN-LAST:event_jListaEmpleadoMouseClicked

private void txtIdComputadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdComputadorKeyReleased
// TODO add your handling code here:
        try {
            // TODO add your handling code here:
                if(!objComputadorCOM.verificarNombre(txtIdComputador.getText()).equals("") )
                {
                     txtIdComputador.setBackground(Color.red);
                     lblNComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNComputador.setToolTipText("El Nombre del Computador es Repetido");
                }
                else{
                    txtIdComputador.setBackground(Color.white);
                    lblNComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNComputador.setToolTipText("El Campo Es Correcto");
                }
                     } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPoPartes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_txtIdComputadorKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

 limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cb_ListarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarCPUActionPerformed
        // TODO add your handling code here:
           if(cb_ListarCPU.getSelectedIndex()!=0)
        try {    
             
                 lblSistemaNuevo.setText(((CPU)cb_ListarCPU.getSelectedItem()).getObjSoftware().getStr_nombre());
        
             List<Componente> listCPU = objComponenteCOM.listarComponentesXCPU(((CPU)cb_ListarCPU.getSelectedItem()).getStr_id_cpu());
             if(listCPU!=null)
             for(Componente componente : listCPU)
                {
                    CPU.DetalleCPU items = new CPU.DetalleCPU(componente);
                    modeloTablaComponente.insertarDetalle(items);
     
                }
             
            modeloTablaComponente.fireTableDataChanged();
            
            
        } catch (Exception ex) {

        }
        else{
            modeloTablaComponente.limpiar();
            modeloTablaComponente.fireTableDataChanged();
            lblSistemaNuevo.setText("Autogenerado");
        }
    }//GEN-LAST:event_cb_ListarCPUActionPerformed

    private void cb_ListarMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarMonitorActionPerformed
        // TODO add your handling code here:
            if(cb_ListarMonitor.getSelectedIndex()!=0)
             lblIdMonitorN.setText(((Monitor)cb_ListarMonitor.getSelectedItem()).getStr_id_monitor());
         else
             lblIdMonitorN.setText("");
    }//GEN-LAST:event_cb_ListarMonitorActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
           if(cb_ListarComponenteAcc.getSelectedIndex()!=0  )
            {
   
                    if(!modeloTablaAccesorios.insertar(((Accesorios)cb_ListarComponenteAcc.getSelectedItem())))
                    JOptionPane.showMessageDialog(this,"Numero de Patrimonial o Serie Duplicado");
                    else
                    modeloTablaAccesorios.fireTableDataChanged();
                    cb_ListarComponenteAcc.setSelectedIndex(0);
            }
            else
             JOptionPane.showMessageDialog(this,"Selecione un Accesorio");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
           if(tablaDetalleAcc.getSelectedRow()>-1)
        {
            

            modeloTablaAccesorios.removerItemDetalle(tablaDetalleAcc.getSelectedRow());
            modeloTablaAccesorios.fireTableDataChanged();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed
 
    
    
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cb_ListarArea;
    private javax.swing.JComboBox cb_ListarCPU;
    private javax.swing.JComboBox cb_ListarComponenteAcc;
    private javax.swing.JComboBox cb_ListarDepartamento;
    private javax.swing.JComboBox cb_ListarEmpleado;
    private javax.swing.JComboBox cb_ListarMonitor;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListaEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblIdMonitorN;
    private javax.swing.JLabel lblNComputador;
    private javax.swing.JLabel lblSistemaNuevo;
    private javax.swing.JTable tablaDetalleAcc;
    private javax.swing.JTable tablaDetalleCPUNuevo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdComputador;
    // End of variables declaration//GEN-END:variables
}
