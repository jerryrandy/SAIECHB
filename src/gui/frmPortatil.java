/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPortatil.java
 *
 * Created on 01/10/2011, 03:28:35 AM
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
public class frmPortatil extends javax.swing.JFrame {

    private Usuario objUsuarioAdmin = new Usuario();
     private ComponenteCOM objComponenteCOM = new ComponenteCOM();
    private DepartamentoCOM objDepartamentoCOM = new DepartamentoCOM();
     private AreaCOM objAreaCOM = new AreaCOM();
    private EmpleadoCOM objEmpleadoCOM= new EmpleadoCOM(); 
    private PortatilCOM objPortatilCOM= new PortatilCOM(); 
 

           private CPatrimonialCOM objCPatrimonialCOM= new CPatrimonialCOM();
           private SoftwareCOM objSoftwareCOM= new SoftwareCOM();
           



      
      
   private DefaultComboBoxModel ComboSoftware = new DefaultComboBoxModel();
   private DefaultComboBoxModel ComboProgramas = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboComponenteMonitor = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboDepartamento = new DefaultComboBoxModel();
      private DefaultComboBoxModel ComboArea = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboEmpleado = new DefaultComboBoxModel();
     
     private DefaultListModel modeloEmpleado = new DefaultListModel();
     
    /** Creates new form frmPortatil */
    public frmPortatil(Usuario usuario) {
        initComponents();
        this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);
         this.objUsuarioAdmin = usuario;
          cb_ListarArea.setModel(ComboArea);
         cb_ListarDepartamento.setModel(ComboDepartamento);

         cb_ListarEmpleado.setModel(ComboEmpleado);
         
         jListaEmpleado.setModel(modeloEmpleado);
         cb_ListarSistema.setModel(ComboSoftware);
       
          cb_ListarPortatil.setModel(ComboComponenteMonitor);
         

         listarComboPortatil();
         listarComboDepartamento();
         listarEmpleado();
         listarSistema();
         listarProgramas();

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
          
     
              public void listarSistema()
    {
        ComboSoftware.removeAllElements();
        ComboSoftware.addElement("(Seleccione una Opcion)");
        try {
            List<Software> listSoftware = objSoftwareCOM.listarTipoActivo(1);
            if(listSoftware!=null)
            {
                for(Software s : listSoftware)
                {
                    ComboSoftware.addElement(s);
                }
            }
        } catch (Exception e) {
      
        }
    }
         
                     public void listarProgramas()
    {
        ComboProgramas.removeAllElements();
        ComboProgramas.addElement("(Seleccione una Opcion)");
        try {
            List<Software> listSoftware = objSoftwareCOM.listarTipoActivo(3);
            if(listSoftware!=null)
            {
                for(Software s : listSoftware)
                {
                    ComboProgramas.addElement(s);
                }
            }
        } catch (Exception e) {
      
        }
    }
         
         public void listarComboPortatil()
    {
        ComboComponenteMonitor.removeAllElements();
        ComboComponenteMonitor.addElement("(Seleccione una Opcion)");
         try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxUbicacion(6,1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteMonitor.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
          
         
  
    }
         
       
          

       public void limpiarControles()
    {
        cb_ListarSistema.setSelectedIndex(0);
        cb_ListarDepartamento.setSelectedIndex(0);
   
     cb_ListarPortatil.setSelectedIndex(0);

      txtIdPortatil.setText("");

      txtBuscar.setText("");
      txtNPortatil.setText("");
    

       listarEmpleado();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtIdPortatil = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNPortatil = new javax.swing.JTextField();
        cb_ListarPortatil = new javax.swing.JComboBox();
        lblNPMonitor = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cb_ListarSistema = new javax.swing.JComboBox();
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
        jPanel9 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Ingreso de Portatil");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Portatil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        txtIdPortatil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdPortatilKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel21.setText("Numero Patrimonial :");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel22.setText("Nombre de Portatil :");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setText("Sistema Operativo :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_ListarPortatil, 0, 414, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblNPMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarSistema, 0, 229, Short.MAX_VALUE)
                        .addGap(80, 80, 80))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(lblNPMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarPortatil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ListarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)))
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
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_ListarDepartamento, 0, 208, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_ListarEmpleado, 0, 208, Short.MAX_VALUE)
                            .addComponent(cb_ListarArea, 0, 208, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ListarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ListarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ListarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblCargo)))
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
            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso de Portatil");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/portatil.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        try {
     
        Portatil objPortatil = new Portatil();
        objPortatil.setStr_nombre(txtNPortatil.getText());
        objPortatil.setStr_id_portatil(txtIdPortatil.getText());
        objPortatil.setObjComponente(((Componente)cb_ListarPortatil.getSelectedItem()));
        objPortatil.setObjEmpleado(((Empleado)cb_ListarEmpleado.getSelectedItem()));
        objPortatil.setObjSoftware(((Software)cb_ListarSistema.getSelectedItem()));
        objPortatil.setInt_estado(0);
         if(objCPatrimonialCOM.insertar(txtIdPortatil.getText()))
            if(objPortatilCOM.insertar(objPortatil))
            JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");

        } catch (Exception ex) {

        }


         listarComboDepartamento();
         listarEmpleado();
         listarComboPortatil();
         limpiarControles();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
         limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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

    private void txtIdPortatilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPortatilKeyReleased
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
                if(!"".equals(objCPatrimonialCOM.verificarNSerie(txtIdPortatil.getText())))
                {
                     txtIdPortatil.setBackground(Color.red);
                     lblNPMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNPMonitor.setToolTipText("El Codigo Patrimonial es Repetido");
                }
                else{
                    txtIdPortatil.setBackground(Color.white);
                    lblNPMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNPMonitor.setToolTipText("El Campo Es Correcto");
                }
                    
                    
        } catch (Exception ex) {
            Logger.getLogger(frmPortatil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtIdPortatilKeyReleased

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
        // TODO add your handling code here:
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
      if(objUsuarioAdmin.getInt_nivel()==1)
            new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
            else
                new frmPrincipalUser(objUsuarioAdmin).setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cb_ListarArea;
    private javax.swing.JComboBox cb_ListarDepartamento;
    private javax.swing.JComboBox cb_ListarEmpleado;
    private javax.swing.JComboBox cb_ListarPortatil;
    private javax.swing.JComboBox cb_ListarSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListaEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNPMonitor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdPortatil;
    private javax.swing.JTextField txtNPortatil;
    // End of variables declaration//GEN-END:variables
}
