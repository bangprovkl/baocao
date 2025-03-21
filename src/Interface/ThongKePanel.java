/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhi
 */
public class ThongKePanel extends javax.swing.JPanel {
DefaultListModel dm =new DefaultListModel();
    /**
     * Creates new form ThongKePanel
     */
    public ThongKePanel() {
        initComponents();
    }
    public void Tinhtongdoanhthu(){
        int rowcount = jTable1.getRowCount();
        int sum =0;
        for (int i = 0; i < rowcount; i++) {
            sum += Integer.parseInt(jTable1.getValueAt(i, 2).toString());
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        
        labTongdoanhthu.setText("TỔNG DOANH THU BÁN HÀNG :"+String.valueOf(formatter.format(sum)+" VNĐ"));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labTongdoanhthu = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 950, 230));

        labTongdoanhthu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add(labTongdoanhthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 395, 437, 33));
        add(txtTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 137, -1));

        btnTimkiem.setBackground(new java.awt.Color(126, 146, 182));
        btnTimkiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });
        add(btnTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("THỐNG KÊ  BÁN HÀNG");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Thống kê theo ngày");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 137, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
       try {
        jTable1.removeAll();
        String[] arr ={"Mã hóa đơn","Ngày tạo","Tổng tiền"};
        DefaultTableModel model =new DefaultTableModel(arr,0);
        Connection connection = Connect.getConnection();
        String query  ="SELECT * FROM `hoadon` WHERE ngaytao ='"+txtTimkiem.getText()+"'";
        PreparedStatement ps =connection.prepareStatement(query);
        ResultSet rs =ps.executeQuery();
        while (rs.next()) {
            Vector vector =new Vector();
            vector.add(rs.getString("maHD"));
            vector.add(rs.getString("ngaytao"));
            vector.add(rs.getString("Tong"));
            model.addRow(vector);
        }
        Connect.closeConnection(connection);
        jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
       Tinhtongdoanhthu();
    }//GEN-LAST:event_btnTimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labTongdoanhthu;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
