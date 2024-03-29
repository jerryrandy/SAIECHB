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
public class frmIngresoCPU extends javax.swing.JFrame {
    
 private Usuario objUsuarioAdmin = new Usuario();
    private TipoCOM objTipoCOM = new TipoCOM();
    private ComponenteCOM objComponenteCOM = new ComponenteCOM();
     private CPUCOM objCPUCOM= new CPUCOM(); 
           private CPatrimonialCOM objCPatrimonialCOM= new CPatrimonialCOM();
             private SoftwareCOM objSoftwareCOM= new SoftwareCOM();
           

     
      private ModeloDetalleCPU modeloTablaComponente = new ModeloDetalleCPU();
       private ModeloSoftware modeloTablaSoftware = new ModeloSoftware();
       private ModeloAccesorios modeloTablaAccesorios = new ModeloAccesorios();
      
      

     private DefaultComboBoxModel ComboComponenteCPU = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboTipo = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboComponenteAcc = new DefaultComboBoxModel();
      private DefaultComboBoxModel ComboSoftware = new DefaultComboBoxModel();

    public frmIngresoCPU(Usuario usuario) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);
         this.objUsuarioAdmin = usuario;
         cb_ListarTipo.setModel(ComboTipo);

         cb_ListarComponenteCPU.setModel(ComboComponenteCPU);
         

          cb_ListarSistema.setModel(ComboSoftware);
        
         tablaDetalleCPU.setModel(modeloTablaComponente);

         
       
         
         tablaDetalleCPU.getColumnModel().getColumn(0).setMaxWidth(100);

           tablaDetalleCPU.getColumnModel().getColumn(0).setMinWidth(100);

            listarComboTipo();
            listarComboAccesorios();
            listarSistema();
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
         
           
          
         public void listarComboTipo()
    {
        ComboTipo.removeAllElements();
        ComboTipo.addElement("(Seleccione una Opcion)");
        try {
            List<Tipo> listTipo = objTipoCOM.listarTipoUbicacionActivo(2);
            if(listTipo!=null)
            {
                for(Tipo t : listTipo)
                {
                    ComboTipo.addElement(t);
                }
            }
        } catch (Exception e) {
      
        }
    }
             
         
               
     
  
         

         
            public void listarComboAccesorios()
    {
        ComboComponenteAcc.removeAllElements();
        ComboComponenteAcc.addElement("(Seleccione una Opcion)");
         try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxUbicacion(3,1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteAcc.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
  
    }
          

       public void limpiarControles()
    {
             cb_ListarTipo.setSelectedIndex(0);

      txtIdCPU.setText("");

      cb_ListarSistema.setSelectedIndex(0);
      modeloTablaAccesorios.limpiar();
      modeloTablaAccesorios.fireTableDataChanged();
      modeloTablaComponente.limpiar();
      modeloTablaComponente.fireTableDataChanged();
       modeloTablaSoftware.limpiar();
      modeloTablaSoftware.fireTableDataChanged();


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
        lblNComputador = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtIdCPU = new javax.swing.JTextField();
        lblNPCPU = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCPU = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cb_ListarTipo = new javax.swing.JComboBox();
        cb_ListarComponenteCPU = new javax.swing.JComboBox();
        btnAgregarCPU = new javax.swing.JButton();
        btnQuitarCPU = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cb_ListarSistema = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();

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
        setTitle("Formulario de Ingreso de Computador");
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
        jLabel1.setText("Ingreso de CPU");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cpu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jLabel11))
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
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnGrabar)
                .addComponent(btnLimpiar))
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setText("Nro. Patrimonial :");

        txtIdCPU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdCPUKeyReleased(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPU.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaDetalleCPU);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Tipo :");

        cb_ListarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarTipoActionPerformed(evt);
            }
        });

        btnAgregarCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_detalle_prod.png"))); // NOI18N
        btnAgregarCPU.setToolTipText("Agregar Componentes");
        btnAgregarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCPUActionPerformed(evt);
            }
        });

        btnQuitarCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_detalle_prod.png"))); // NOI18N
        btnQuitarCPU.setToolTipText("Quitar Componentes");
        btnQuitarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarCPU))
                    .addComponent(cb_ListarComponenteCPU, javax.swing.GroupLayout.Alignment.TRAILING, 0, 360, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuitarCPU)
                    .addComponent(btnAgregarCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarComponenteCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Software", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sisoperativo.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setText("Sistema Operativo :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel25))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarSistema, 0, 219, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNPCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNPCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtIdCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cb_ListarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarTipoActionPerformed
        // TODO add your handling code here:
            ComboComponenteCPU.removeAllElements();
            ComboComponenteCPU.addElement("(Seleccione una Opcion)");
         if(cb_ListarTipo.getSelectedIndex()!=0)
         {
        try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxTipo(((Tipo)cb_ListarTipo.getSelectedItem()).getInt_id_tipo(),1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteCPU.addElement(c);
                }
            }
        } catch (Exception e) {
         
        }
         cb_ListarComponenteCPU.setModel(ComboComponenteCPU);
      
         }

    }//GEN-LAST:event_cb_ListarTipoActionPerformed

    
    private void btnAgregarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCPUActionPerformed

 if(cb_ListarTipo.getSelectedIndex()!=0 && cb_ListarComponenteCPU.getSelectedIndex()!=0)
 {

        Componente objComponente = new Componente();
        objComponente.setStr_id_componente(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_id_componente());
        objComponente.setInt_estado(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_estado());
        objComponente.setInt_garantia(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_garantia());
        objComponente.setStr_caracteristica(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_caracteristica());
        objComponente.setObjModelo(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getObjModelo());

        CPU.DetalleCPU items = new CPU.DetalleCPU(objComponente);
           
      if(!modeloTablaComponente.insertarDetalle(items))
                    JOptionPane.showMessageDialog(this,"Numero de Serie Duplicado");
                    else
                    modeloTablaComponente.fireTableDataChanged();
           cb_ListarTipo.setSelectedIndex(0);
               cb_ListarComponenteCPU.setSelectedIndex(0);


 }
 else
             JOptionPane.showMessageDialog(this,"Selecione un Tipo o un Componente");
        
             
    
    }//GEN-LAST:event_btnAgregarCPUActionPerformed

    private void btnQuitarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCPUActionPerformed
        // TODO add your handling code here:
         if(tablaDetalleCPU.getSelectedRow()>-1)
        {
            

            modeloTablaComponente.removerItemDetalle(tablaDetalleCPU.getSelectedRow());
            modeloTablaComponente.fireTableDataChanged();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
        
    }//GEN-LAST:event_btnQuitarCPUActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
           
  try {
      
        Software objSoftware= new Software();
        objSoftware.setInt_id_software(((Software)cb_ListarSistema.getSelectedItem()).getInt_id_software());
        
        CPU objCPU = new CPU();
        objCPU.setStr_id_cpu(txtIdCPU.getText());
        objCPU.setObjSoftware(objSoftware);
        objCPU.setInt_estado(1);
        objCPU.setDetalleCPU(modeloTablaComponente.listar());


        
        if(objCPatrimonialCOM.insertar(txtIdCPU.getText()))
             if(objCPUCOM.insertar(objCPU))
            JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");
        else  
        JOptionPane.showMessageDialog(this,"Ocurio un Error");
      
        } catch (Exception ex) {
            Logger.getLogger(frmIngresoCPU.class.getName()).log(Level.SEVERE, null, ex);
        }


       listarComboTipo();

         listarComboAccesorios();
         limpiarControles();

    }//GEN-LAST:event_btnGrabarActionPerformed

private void txtIdCPUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCPUKeyReleased
// TODO add your handling code here:
     try {
            // TODO add your handling code here:
                 if(!"".equals(objCPatrimonialCOM.verificarNSerie(txtIdCPU.getText())))
                            {
                                txtIdCPU.setBackground(Color.red);
                     lblNPCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNPCPU.setToolTipText("El Codigo Patrimonial es Repetido");
                            }
                             else{
                    txtIdCPU.setBackground(Color.white);
                    lblNPCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNPCPU.setToolTipText("El Campo Es Correcto");
                }
        } catch (Exception ex) {
            Logger.getLogger(frmIngresoCPU.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
}//GEN-LAST:event_txtIdCPUKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

 limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed
 
    
    
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCPU;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarCPU;
    private javax.swing.JComboBox cb_ListarComponenteCPU;
    private javax.swing.JComboBox cb_ListarSistema;
    private javax.swing.JComboBox cb_ListarTipo;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNComputador;
    private javax.swing.JLabel lblNPCPU;
    private javax.swing.JTable tablaDetalleCPU;
    private javax.swing.JTextField txtIdCPU;
    // End of variables declaration//GEN-END:variables
}
