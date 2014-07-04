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

import com.TipoCOM;
import entidades.Tipo;
import entidades.Usuario;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Toditos
 */
public class frmTipo extends javax.swing.JFrame {
    
    private Usuario objUsuarioAdmin = new Usuario();
    private TipoCOM objTipoCOM = new TipoCOM();
     private DefaultListModel modeloTipo = new DefaultListModel();
     private boolean principal=true;
     
    public frmTipo(Usuario usuario,boolean Principal) {
        initComponents();
        this.principal=Principal;
          setLocationRelativeTo(null);
          this.objUsuarioAdmin = usuario;
             this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
        jListaTipo.setModel(modeloTipo);
        listarTipo();
    }
      public void listarTipo()
    {
        modeloTipo.clear();
        try {
            List<Tipo> listTipo = objTipoCOM.listarTodosOrdenado();
            if(listTipo!=null)
            {
                for(Tipo m : listTipo)
                {
                    modeloTipo.addElement(m);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
       public void limpiarControles()
    {

            txtCaracteristica.setText("");
        txtNombre.setText("");
        txtBuscar.setText("");
        lblIdTipo.setText("Autogenerado");  
       cboEstado.setSelectedIndex(0);
       cboUbicacion.setSelectedIndex(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaTipo = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblIdTipo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cboUbicacion = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCaracteristica = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Mantenimiento Tipo de Componente");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jListaTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaTipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListaTipo);

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento Tipo de Componente");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Nombre :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Codigo :");

        lblIdTipo.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblIdTipo.setText("Autogenerado");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setText("Ubicacion :");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Activo", "Activo" }));

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editclear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar)
                .addGap(4, 4, 4)
                .addComponent(btnActualizar)
                .addGap(8, 8, 8)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar))
        );

        cboUbicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccione un Opción)", "Computador Monitor", "CPU", "Accesorios", "Equipo Externo", "Equipo de Impresion", "Computador Portatil" }));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setText("Estado :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Rquisito :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCaracteristica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblIdTipo)
                    .addComponent(cboEstado, 0, 138, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(cboUbicacion, 0, 138, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblIdTipo))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
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

private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
       
    if(lblIdTipo.getText().equals("Autogenerado"))
    {
     if( !txtNombre.getText().equals("") && cboUbicacion.getSelectedIndex()!=0)

        try {
            Tipo objTipo= new Tipo();
            
            objTipo.setInt_activa(cboEstado.getSelectedIndex());
            objTipo.setInt_ubicacion(cboUbicacion.getSelectedIndex());

            objTipo.setStr_nombre(txtNombre.getText());

            objTipo.setStr_caractarestica(txtCaracteristica.getText());
             

            
            if(objTipoCOM.insertar(objTipo))
            {
                JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");
                listarTipo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
            //JOptionPane.showMessageDialog(this,"Nombre Duplicado");
     }
          else
            JOptionPane.showMessageDialog(this,"Ingrese datos");
    }
        limpiarControles();
    
}//GEN-LAST:event_btnGrabarActionPerformed

private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    if(!lblIdTipo.getText().equals("Autogenerado"))
      try {
                Tipo objTipo= new Tipo();
            
            objTipo.setInt_activa(cboEstado.getSelectedIndex());
            objTipo.setInt_ubicacion(cboUbicacion.getSelectedIndex());

            objTipo.setStr_nombre(txtNombre.getText());

            objTipo.setStr_caractarestica(txtCaracteristica.getText());
             
            objTipo.setInt_id_tipo(Integer.parseInt(lblIdTipo.getText()));
            
            if(objTipoCOM.actualizar(objTipo))
            {
                JOptionPane.showMessageDialog(this,"Se Actualizo Correctamente");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

    else
     JOptionPane.showMessageDialog(this,"Seleccione una Tipo");
         listarTipo();   

}//GEN-LAST:event_btnActualizarActionPerformed

private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    limpiarControles();
}//GEN-LAST:event_btnLimpiarActionPerformed

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
     if(!lblIdTipo.getText().equals("Autogenerado"))
        {
            try {
            if(objTipoCOM.eliminar(Integer.parseInt(lblIdTipo.getText())))
            {
                JOptionPane.showMessageDialog(this,"Se Elimino Correctamemte");
                listarTipo();
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }            
        }
        else
            JOptionPane.showMessageDialog(this,"Seleccione una Tipo");
        limpiarControles();
        
}//GEN-LAST:event_btnEliminarActionPerformed

private void jListaTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaTipoMouseClicked

       String criterio = jListaTipo.getSelectedValue().toString();
       if(!criterio.toString().trim().equals(""))
       {
                
                txtNombre.setText(((Tipo)jListaTipo.getModel().getElementAt(jListaTipo.getSelectedIndex())).getStr_nombre());
                lblIdTipo.setText(String.valueOf(((Tipo)jListaTipo.getModel().getElementAt(jListaTipo.getSelectedIndex())).getInt_id_tipo()));
                cboEstado.setSelectedIndex((((Tipo)jListaTipo.getModel().getElementAt(jListaTipo.getSelectedIndex())).getInt_activa()));
                cboUbicacion.setSelectedIndex((((Tipo)jListaTipo.getModel().getElementAt(jListaTipo.getSelectedIndex())).getInt_ubicacion()));
                
                txtCaracteristica.setText(((Tipo)jListaTipo.getModel().getElementAt(jListaTipo.getSelectedIndex())).getStr_caractarestica());
               


       }
    
}//GEN-LAST:event_jListaTipoMouseClicked

private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
// TODO add your handling code here:
      modeloTipo.clear();
        try {
            List<Tipo> listTipo = objTipoCOM.listarFiltro(txtBuscar.getText());
            if(listTipo!=null)
            {
                for(Tipo m : listTipo)
                {
                    modeloTipo.addElement(m);
                }
            }
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
}//GEN-LAST:event_txtBuscarKeyReleased

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
    if(principal)
    {
        if(objUsuarioAdmin.getInt_nivel()==1)
            new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
            else
                new frmPrincipalUser(objUsuarioAdmin).setVisible(true);
    }

}//GEN-LAST:event_formWindowClosed


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListaTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdTipo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCaracteristica;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
