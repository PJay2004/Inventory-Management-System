/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Poorna Jayasinghe
 */
public class SupplierReg extends javax.swing.JFrame {

    /**
     * Creates new form SupplierRegistration
     */
    GRN grn;

    public SupplierReg() {
        initComponents();
        loadSuppliers();
    }

    public SupplierReg(GRN grn) {
        initComponents();
        loadSuppliers();
        this.grn = grn;
    }

//    SupplierRegistration(GRN aThis) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public void loadSuppliers() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `supplier` INNER JOIN `company_branch` ON `supplier`.`company_branch_id`=`company_branch`.`id` INNER JOIN `company_branch_address` ON `company_branch_address`.`id` = `company_branch`.`company_branch_address_id` INNER JOIN `city` ON `city`.`id` = `company_branch_address`.`city_id` ORDER BY `supplier`.`id` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier.id"));
                v.add(rs.getString("supplier.name"));
                v.add(rs.getString("supplier.contact_number"));
                v.add(rs.getString("supplier.email"));
                v.add(rs.getString("company_branch.name"));
                v.add(rs.getString("company_branch.branch_contact"));
//                v.add(rs.getString("company_branch."));
                String address = rs.getString("company_branch_address.line1") + "," + rs.getString("company_branch_address.line2") + "," + rs.getString("city.id");
                v.add(address);
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supplier Management");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Contact Number");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 47, 92, 29));

        jLabel2.setText("Email");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 83, 92, 29));

        jLabel3.setText("Supplier Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 92, 29));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 47, 208, 29));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 13, 208, 29));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 83, 208, 29));

        jButton1.setText("Create New Supplier Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 310, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Supplier Name", "Contact Number", "Email", "Branch Name", "Branch Contact Number", "Branch Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 990, 300));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Branch Id");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, 100, 31));

        jLabel5.setText("Branch");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 31));

        jLabel6.setText("Branch Address");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 31));

        jLabel7.setText("none");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 145, 31));

        jLabel8.setText("none");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 111, 145, 30));

        jLabel9.setText("none");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 145, 31));

        jButton2.setText("Select Branch");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 40));

        jLabel10.setText("Company id");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 100, 31));

        jLabel11.setText("none");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 145, 31));

        jLabel12.setText("Company");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 100, 31));

        jLabel13.setText("none");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 145, 31));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 460, 160));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo_white.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 200, 160));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/2849806_printer_copy_print_multimedia_icon.png"))); // NOI18N
        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, 110, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        BranchReg br = new BranchReg(this, true);
        br.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String name = jTextField2.getText();
        String contact_number = jTextField1.getText();
        String email = jTextField3.getText();
        String bid = jLabel9.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("0[0-9]{9}").matcher(contact_number).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$").matcher(email).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (bid.equals("none")) {
            JOptionPane.showMessageDialog(this, "Please Select branch", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet rs = MySQL.search("SELECT * FROM `supplier` WHERE `email` = '" + email + "' OR `contact_number`= '" + contact_number + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier already Exists", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                MySQL.iud("INSERT INTO `supplier`(`name`, `contact_number`, `email`, `company_branch_id`) VALUES ('" + name + "', '" + contact_number + "', '" + email + "', " + bid + ") ");

                jTextField2.setText("");
                jTextField1.setText("");
                jTextField3.setText("");
                jLabel9.setText("none");
                jLabel7.setText("none");
                jLabel8.setText("none");
                jLabel11.setText("none");
                jLabel13.setText("none");

                jTextField2.grabFocus();
                loadSuppliers();
                JOptionPane.showMessageDialog(this, "New Supplier account created", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

        String mobile = jTextField1.getText();
        String text = mobile + evt.getKeyChar();

        if (text.length() == 1) {
            if (!text.equals("0")) {
                evt.consume();
            }
        } else if (text.length() == 2) {
            if (!text.equals("07")) {
                evt.consume();
            }
        } else if (text.length() == 3) {
            if (!Pattern.compile("07[01245678]").matcher(text).matches()) {
                evt.consume();
            }
        } else if (text.length() <= 10) {
            if (!Pattern.compile("07[01245678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                String sid = jTable1.getValueAt(r, 0).toString();
                String sname = jTable1.getValueAt(r, 1).toString();
                String mobile = jTable1.getValueAt(r, 2).toString();
                String branch = jTable1.getValueAt(r, 4).toString();

                grn.jLabel5.setText(sid);
                grn.jLabel6.setText(sname);
                grn.jLabel7.setText(mobile);
                grn.jLabel8.setText(branch);

                grn.jTextField1.grabFocus();
                           
                this.dispose();

            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int option = JOptionPane.showConfirmDialog(this, "Print Supplier Report?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            try {

                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                String date = s.format(d);

                InputStream stream = SupplierReg.class.getResourceAsStream("supplierreport.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(stream);

                HashMap parameters = new HashMap();
                parameters.put("date", date);

                TableModel tm = jTable1.getModel();
                JRTableModelDataSource dataSource = new JRTableModelDataSource(tm);

                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);
//                JasperViewer.viewReport(jp, false);
                JasperViewer jasperViewer = new JasperViewer(jp, false);
                jasperViewer.setAlwaysOnTop(true);
                jasperViewer.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
