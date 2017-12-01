/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.ControlEmpleado;
import Controlador.ControlMedico;
import Controlador.ControlPersona;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis
 */
public class InternalAgregarMedico extends javax.swing.JInternalFrame {
    ControlMedico controlMedico;
    ControlPersona controlPersona;
    ControlEmpleado controlEmpleado;
    /**
     * Creates new form InternalAddMedico
     */
    public InternalAgregarMedico(ControlMedico controlMedico, ControlPersona controlPersona, ControlEmpleado controlEmpleado) {
        this.controlMedico = controlMedico;
        this.controlPersona = controlPersona;
        this.controlEmpleado = controlEmpleado;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FieldNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FieldCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FieldDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FieldTelefono = new javax.swing.JTextField();
        ButtonAgregarPersona = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        FieldCargo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        FieldSalario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FieldEmail = new javax.swing.JTextField();
        FieldCedulaJefe = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        FieldArea = new javax.swing.JTextField();
        ButtonAgregarEmpleado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        FieldEspecialidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        FieldNumLicencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FieldUniversidad = new javax.swing.JTextField();
        ButtonAgregarMedico = new javax.swing.JButton();

        setIconifiable(true);
        setResizable(true);
        setTitle("Agregar medico");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos personales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        FieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Cédula");

        jLabel3.setText("Dirección");

        jLabel4.setText("Telefono");

        ButtonAgregarPersona.setText("Registrar Datos Personales");
        ButtonAgregarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FieldDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(FieldCedula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FieldNombre)
                    .addComponent(FieldTelefono))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonAgregarPersona)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButtonAgregarPersona)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel9.setText("Cargo");

        FieldCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldCargoActionPerformed(evt);
            }
        });

        jLabel10.setText("Salario");

        FieldSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldSalarioActionPerformed(evt);
            }
        });

        jLabel11.setText("Email");

        FieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldEmailActionPerformed(evt);
            }
        });

        FieldCedulaJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldCedulaJefeActionPerformed(evt);
            }
        });

        jLabel12.setText("Cédula Jefe");

        jLabel13.setText("Código área");

        FieldArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldAreaActionPerformed(evt);
            }
        });

        ButtonAgregarEmpleado.setText("Registrar Datos Empleado");
        ButtonAgregarEmpleado.setEnabled(false);
        ButtonAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldCedulaJefe))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldArea, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FieldEmail)
                            .addComponent(FieldSalario)
                            .addComponent(FieldCargo))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonAgregarEmpleado)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(FieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(FieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(FieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(FieldCedulaJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ButtonAgregarEmpleado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos medico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel5.setText("Especialidad");

        jLabel8.setText("N° Licencia");

        jLabel6.setText("Universidad");

        ButtonAgregarMedico.setText("Registrar Datos Médico");
        ButtonAgregarMedico.setEnabled(false);
        ButtonAgregarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FieldNumLicencia)
                            .addComponent(FieldUniversidad))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonAgregarMedico)
                .addGap(75, 75, 75))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FieldEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(FieldNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(FieldUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(ButtonAgregarMedico)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldNombreActionPerformed

    private void ButtonAgregarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgregarMedicoActionPerformed
        try{
          if(this.FieldEspecialidad.getText().trim().isEmpty() || this.FieldNumLicencia.getText().trim().isEmpty() ||
             this.FieldUniversidad.getText().trim().isEmpty()){
              JOptionPane.showInternalMessageDialog(this, "Existen casillas vacias.", "Atención", JOptionPane.WARNING_MESSAGE);
          }else{    
              String cedula = this.FieldCedula.getText();
              String especialidad = this.FieldEspecialidad.getText();
              String numLicencia = this.FieldNumLicencia.getText();
              String universidad = this.FieldUniversidad.getText();
              
              String mensaje = controlMedico.insertarMedico(cedula, especialidad, numLicencia, universidad);
              JOptionPane.showMessageDialog(this, mensaje);
              if(mensaje.equals("Médico creado correctamente")){                  
                  this.dispose();
              }                           
          }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Asegurese de ingresar un salario de tipo numérico");           
                        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al capturar los datos");
            System.out.println(e);
        }       
    }//GEN-LAST:event_ButtonAgregarMedicoActionPerformed

    private void FieldCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCargoActionPerformed

    private void FieldSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldSalarioActionPerformed

    private void FieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldEmailActionPerformed

    private void FieldCedulaJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldCedulaJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCedulaJefeActionPerformed

    private void FieldAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldAreaActionPerformed

    private void ButtonAgregarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgregarPersonaActionPerformed
        // TODO add your handling code here:
        try{
          if(this.FieldCedula.getText().trim().isEmpty() || this.FieldNombre.getText().trim().isEmpty()){
              JOptionPane.showInternalMessageDialog(this, "Existen casillas vacias.", "Atención", JOptionPane.WARNING_MESSAGE);
          }else{
              String nombre = this.FieldNombre.getText();
              String cedula = this.FieldCedula.getText();
              String direccion = this.FieldDireccion.getText();
              String telefono = this.FieldTelefono.getText();
                                          
              String mensaje = controlPersona.insertarPersona(cedula, nombre, direccion, telefono);
              if(mensaje.equals("Persona creada correctamente")){
                  this.ButtonAgregarEmpleado.setEnabled(true);                  
                  this.ButtonAgregarPersona.setEnabled(false);
                  this.FieldCedula.setEditable(false);
              }  
              JOptionPane.showMessageDialog(this, mensaje);
          }                         
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al capturar los datos");
            System.out.println(e);
        }  
    }//GEN-LAST:event_ButtonAgregarPersonaActionPerformed

    private void ButtonAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgregarEmpleadoActionPerformed
        // TODO add your handling code here:
        try{
          if(this.FieldCargo.getText().trim().isEmpty() || this.FieldSalario.getText().trim().isEmpty() ||
             this.FieldEmail.getText().trim().isEmpty() || this.FieldArea.getText().trim().isEmpty()){             
              JOptionPane.showInternalMessageDialog(this, "Existen casillas vacias.", "Atención", JOptionPane.WARNING_MESSAGE);
          }else{              
              String cedula = this.FieldCedula.getText();
                                         
              String cargo = this.FieldCargo.getText();
              float salario = Float.parseFloat(this.FieldSalario.getText());
              String email = this.FieldEmail.getText();
              String area;
              String id_jefe;
              if(this.FieldArea.getText().equals("")){
                  area = null;
              }else{
                  area = this.FieldArea.getText();
              } 
              if(this.FieldCedulaJefe.getText().equals("")){
                  id_jefe = null;
              }else{
                  id_jefe = this.FieldCedulaJefe.getText();
              }                
              
              String mensaje = controlEmpleado.insertarEmpleado(cedula, cargo, salario, email, area, id_jefe);
              JOptionPane.showMessageDialog(this, mensaje);
              switch (mensaje) {
                  case "Empleado creado correctamente":
                      this.ButtonAgregarEmpleado.setEnabled(false);
                      this.ButtonAgregarMedico.setEnabled(true);
                      break;
                  case "Ya existe un empleado con esa cédula":
                      this.dispose();
                      break;
              }              
          }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Asegurese de ingresar un salario de tipo numérico");           
                        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al capturar los datos");
            System.out.println(e);
        }       
    }//GEN-LAST:event_ButtonAgregarEmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgregarEmpleado;
    private javax.swing.JButton ButtonAgregarMedico;
    private javax.swing.JButton ButtonAgregarPersona;
    private javax.swing.JTextField FieldArea;
    private javax.swing.JTextField FieldCargo;
    private javax.swing.JTextField FieldCedula;
    private javax.swing.JTextField FieldCedulaJefe;
    private javax.swing.JTextField FieldDireccion;
    private javax.swing.JTextField FieldEmail;
    private javax.swing.JTextField FieldEspecialidad;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JTextField FieldNumLicencia;
    private javax.swing.JTextField FieldSalario;
    private javax.swing.JTextField FieldTelefono;
    private javax.swing.JTextField FieldUniversidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
