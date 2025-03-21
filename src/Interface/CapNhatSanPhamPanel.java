/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Classssss.SanPhamClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Classssss.ImageSP;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import database.Connect;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author Nhi
 */
public class CapNhatSanPhamPanel extends javax.swing.JPanel {
       
    /**
     * Creates new form CapNhatSanPhamPanel
     */
    public CapNhatSanPhamPanel() {
        initComponents();
    }
    private frmMain parentFrmMain;
    private byte[] SPimages;
    private void Showtable() {
        try {
            jTableSanPham.removeAll();
        String[] arr ={"maloaiSP","maSP","tenSP","size","mausac","soluong","maNSX","gia"};
        DefaultTableModel model =new DefaultTableModel(arr,0);
         
        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM sanpham WHERE 1";
        PreparedStatement ps =connection.prepareStatement(query);
        ResultSet rs =ps.executeQuery();
        
        while (rs.next()) {
            Vector vector =new Vector();
            vector.add(rs.getString("maloaiSP"));
            vector.add(rs.getString("maSP"));
            vector.add(rs.getString("tenSP"));
            vector.add(rs.getString("size"));
            vector.add(rs.getString("mausac"));
            vector.add(rs.getString("soluong"));
            vector.add(rs.getString("maNSX"));
            vector.add(rs.getString("gia"));
            model.addRow(vector);
        }
            System.out.println();
        
        Connect.closeConnection(connection);
        jTableSanPham.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private boolean CheckTrung(){
        try {
            Connection connection = Connect.getConnection();
            String sql = "SELECT * FROM `sanpham` WHERE `maSP` = ? ";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,txtMasp.getText());
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                return true;
            }
        Connect.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    private boolean CheckTrungAllbtnSua(){
        try {
            Connection connection = Connect.getConnection();
            String sql = "SELECT * FROM `sanpham` WHERE `tenSP`=? AND `size`=? AND `mausac`=? AND `maNSX`=? AND `soluong`=? AND `gia`=? ";
            PreparedStatement ps =connection.prepareStatement(sql);
             ps.setString(1,txttensp.getText());
            ps.setString(2,txtSize.getText());
            ps.setString(3,txtMausac.getText());
            ps.setString(4,ComboBox3_maNSX.getSelectedItem().toString());
            ps.setString(5,txtsoluong.getText());
            ps.setString(6,txtgiaban.getText());
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                return true;
            }
            Connect.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
        return false;
    }
    public void EnableTrue(){
        ComboBox1_MaloaiSP.setEnabled(true);
//        txtMasp.setEnabled(true);
        txttensp.setEnabled(true);
        txtSize.setEnabled(true);
        txtMausac.setEnabled(true);
        txtsoluong.setEnabled(true);
        txtgiaban.setEnabled(true);
        ComboBox3_maNSX.setEnabled(true);
    }
    public void EnableFalse(){
        ComboBox1_MaloaiSP.setEnabled(false);
        txtMasp.setEnabled(false);
        txttensp.setEnabled(false);
        txtSize.setEnabled(false);
        txtMausac.setEnabled(false);
        txtsoluong.setEnabled(false);
        txtgiaban.setEnabled(false);
        ComboBox3_maNSX.setEnabled(false);
    }
    public void EqualsNull(){
        txtMasp.setText("");
        txttensp.setText("");
        txtSize.setText("");
        txtMausac.setText("");
        txtsoluong.setText("");
        txtgiaban.setText("");
    }
    
//        
//    
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LableimgSP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboBox1_MaloaiSP = new javax.swing.JComboBox<>();
        txttensp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtgiaban = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        ComboBoxTimKiem = new javax.swing.JComboBox<>();
        ComboBox3_maNSX = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMausac = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        txtTukhoa = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 608));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        LableimgSP.setBackground(new java.awt.Color(255, 204, 204));
        LableimgSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/authentic11.jpg"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Loại sản phẩm :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Mã sản phẩm:");

        txtMasp.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tên sản phẩm:");

        ComboBox1_MaloaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nike", "Puma", "Vans" }));

        txttensp.setForeground(new java.awt.Color(0, 51, 204));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Số lượng:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Mã nhà sản xuất:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Giá:");

        jTableSanPham.setAutoCreateRowSorter(true);
        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã loại sản phẩm", "Mã sản phẩm", "Tên sản phẩm", "Kích thước", "Màu sắc", "Mã nhà sản xuất", "Số lượng", "Giá "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        jTableSanPham.setRequestFocusEnabled(false);
        jTableSanPham.setSelectionBackground(new java.awt.Color(0, 153, 204));
        jTableSanPham.getTableHeader().setReorderingAllowed(false);
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSanPham);
        if (jTableSanPham.getColumnModel().getColumnCount() > 0) {
            jTableSanPham.getColumnModel().getColumn(0).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(1).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(2).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(3).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(4).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(5).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(6).setResizable(false);
            jTableSanPham.getColumnModel().getColumn(7).setResizable(false);
        }

        btnThem.setBackground(new java.awt.Color(126, 146, 182));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(126, 146, 182));
        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(126, 146, 182));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        ComboBoxTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ComboBoxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã loại SP", "Mã SP", "Tên SP", "Size ", "Màu sắc", "Mã NSX", "Số lượng", "Giá" }));

        ComboBox3_maNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NSX01", "NSX02", "NSX03", " " }));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Size:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Màu sắc:");

        btnLuu.setBackground(new java.awt.Color(126, 146, 182));
        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtTukhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTukhoaMouseClicked(evt);
            }
        });
        txtTukhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTukhoaActionPerformed(evt);
            }
        });

        btnTimkiem.setBackground(new java.awt.Color(126, 146, 182));
        btnTimkiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimkiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnRefesh.setBackground(new java.awt.Color(126, 146, 182));
        btnRefesh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRefesh.setText("Refresh");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LableimgSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBox1_MaloaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMausac, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox3_maNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(ComboBoxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtTukhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimkiem)
                        .addGap(67, 67, 67)
                        .addComponent(btnRefesh)
                        .addGap(19, 19, 19)
                        .addComponent(btnLuu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LableimgSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ComboBox1_MaloaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBox3_maNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ComboBoxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTukhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimkiem)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnRefesh))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnLuu)))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        EnableFalse();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);
        btnTimkiem.setEnabled(false);
        Showtable();
    }//GEN-LAST:event_formComponentShown

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnLuu.setEnabled(false);
        btnThem.setEnabled(true);
        EnableFalse();
        int i = jTableSanPham.getSelectedRow();
        DefaultTableModel dtm =(DefaultTableModel) this.jTableSanPham.getModel();
        String maloaiSPString = (String)dtm.getValueAt(i, 0);
        String maSPString = (String)dtm.getValueAt(i, 1);
        String tenSPString = (String)dtm.getValueAt(i, 2);
        String sizeString = (String)dtm.getValueAt(i, 3);
        String mausacString = (String)dtm.getValueAt(i, 4);
        String soluongString = (String)dtm.getValueAt(i, 5);
        String maNSXString = (String)dtm.getValueAt(i, 6);
        String giaString = (String)dtm.getValueAt(i, 7);
        this.ComboBox1_MaloaiSP.setSelectedItem(maloaiSPString);
        this.txtMasp.setText(maSPString);
        this.txttensp.setText(tenSPString);
        this.txtSize.setText(sizeString);
        this.txtMausac.setText(mausacString);
        this.txtsoluong.setText(soluongString);
        this.ComboBox3_maNSX.setSelectedItem(maNSXString);
        this.txtgiaban.setText(giaString);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       EnableTrue();
       txtMasp.setEnabled(true);
        btnLuu.setEnabled(true);
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        SPimages=null;
        EqualsNull();

    }//GEN-LAST:event_btnThemActionPerformed
 
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtMasp.setEnabled(false);
        btnLuu.setEnabled(true);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        EnableTrue();
        ComboBox1_MaloaiSP.setEnabled(false);
        ComboBox3_maNSX.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        //them
        if (btnThem.isEnabled()==false && btnSua.isEnabled()==false && btnXoa.isEnabled()==false) {
            if (txtMasp.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Chưa nhập: Mã sản phẩm");
            txtMasp.requestFocus();
            return;
        }else if(txttensp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Tên sản phẩm");
            txttensp.requestFocus();
            return;
        }else if(txtSize.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Size");
            txtSize.requestFocus();
            return;
        }
        else if(txtMausac.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Màu sắc");
            txtMausac.requestFocus();
            return;
        }
        else if(txtsoluong.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Số lượng");
            txtsoluong.requestFocus();
            return;
        }
        else if(txtgiaban.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Giá bán");
            txtgiaban.requestFocus();
            return;
        }
        if (CheckTrung()==true) {
            JOptionPane.showMessageDialog(null,"Mã sản phẩm đã trùng !");
            txtMasp.requestFocus();
            return;
        }else{
            try {
                Connection connection = Connect.getConnection();
            String input_sql = "INSERT INTO `sanpham` (`maloaiSP`,`maSP`, `tenSP`, `size`, `mausac`,`maNSX`,`soluong`,`gia`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps =connection.prepareStatement(input_sql);
            ps.setString(1,ComboBox1_MaloaiSP.getSelectedItem().toString());
            ps.setString(2,txtMasp.getText());
            ps.setString(3,txttensp.getText());
            ps.setString(4,txtSize.getText());
            ps.setString(5,txtMausac.getText());
            ps.setString(6,ComboBox3_maNSX.getSelectedItem().toString());
            ps.setString(7,txtsoluong.getText());
            ps.setString(8,txtgiaban.getText());
           
            ps.executeUpdate();
            Connect.closeConnection(connection);
            Showtable();
            JOptionPane.showMessageDialog(null,"Thêm thành công");
            btnLuu.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        }
        
        //sua
        if (btnThem.isEnabled()==false && btnSua.isEnabled()==true && btnXoa.isEnabled()==false ) {
             int i = jTableSanPham.getSelectedRow();
        if (i<0) {
            JOptionPane.showMessageDialog(this,"Chưa chọn sản phẩm cần sửa!");
            return;
        }
        DefaultTableModel dtm =(DefaultTableModel) this.jTableSanPham.getModel();
        //lay du lieu dong i, cot 0 ( mã sp)
        String masp = (String)dtm.getValueAt(i, 0);
            String maloaiSPNew = this.ComboBox1_MaloaiSP.getSelectedItem().toString();
            String maSPNew = this.txtMasp.getText();
            String tenSPNew = this.txttensp.getText();
            String sizeNew = this.txtSize.getText();
            String mausacNew = this.txtMausac.getText();
            String maNSXNew = this.ComboBox3_maNSX.getSelectedItem().toString();
            String soluongNew = this.txtsoluong.getText();
            String giaNew = this.txtgiaban.getText();
            if(txttensp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Tên sản phẩm");
            txttensp.requestFocus();
            return;
            }
            if(txtSize.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Size");
            txtSize.requestFocus();
            return;
            }
            if(txtMausac.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Màu sắc");
            txtMausac.requestFocus();
            return;
            }
            if(txtsoluong.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Số lượng");
            txtsoluong.requestFocus();
            return;
            }
            if(txtgiaban.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Giá bán");
            txtgiaban.requestFocus();
            return;
            }
            if (CheckTrungAllbtnSua()==true) {
                JOptionPane.showMessageDialog(null, "Sản phẩm chưa được sửa thông tin");
                return;
            }
            //hoi lại
            int res = JOptionPane.showConfirmDialog(this, "Sửa sản phẩm","Bạn có chắc muốn sửa?",
                                                JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION) {
            Connection connection = Connect.getConnection();
            if(connection==null){
                JOptionPane.showMessageDialog(this,"Lỗi kết nối CSDL !");
                return;
            }
            //truy van SQL
            String sql = "UPDATE `sanpham` SET `maloaiSP`=?, `maSP`=?,`tenSP`=?,`size`=?,`mausac`=?,`maNSX`=?,`soluong`=?,`gia`=? WHERE `maSP`=?";
            try {
                PreparedStatement ps =  connection.prepareStatement(sql);
                ps.setString(1,maloaiSPNew);
                ps.setString(2,maSPNew);
                ps.setString(3,tenSPNew);
                ps.setString(4,sizeNew);
                ps.setString(5,mausacNew);
                ps.setString(6,maNSXNew);
                ps.setString(7,soluongNew);
                ps.setString(8,giaNew);
                ps.setString(9,maSPNew);
                
                int n= ps.executeUpdate();//thực hiện sql và trả về số dòng dươc thư hien
                if (n>0) {
                    JOptionPane.showMessageDialog(this,"Sửa thông tin thành công!");
                    Showtable();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Lỗi SQL!");
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            
        }
        
        //xoa 
         if (btnThem.isEnabled()==false && btnSua.isEnabled()==false && btnXoa.isEnabled()==true ) {
           int i = jTableSanPham.getSelectedRow();
            if (i<0) {
            JOptionPane.showMessageDialog(this,"Bạn chưa chọn sản phẩm cần xóa!");
            return;
            }
            String data =jTableSanPham.getModel().getValueAt(i,1).toString();
            System.out.println(data);
            int res = JOptionPane.showConfirmDialog(this, "Xóa sản phẩm","Bạn có chắc muốn xóa?",
                                                JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION) {
                Connection connection = Connect.getConnection();
                if(connection==null){
                    JOptionPane.showMessageDialog(this,"Lỗi kết nối CSDL!");
                    return;
                }
                try {
                String delsql = "DELETE FROM `sanpham` WHERE `maSP`= ?";
                PreparedStatement ps =connection.prepareStatement(delsql);
                ps.setString(1,data);
                ps.executeUpdate();
                Connect.closeConnection(connection);
                Showtable();
                JOptionPane.showMessageDialog(null,"Xóa thành công");
                } catch (SQLException ex) {
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
         }
        btnSua.setEnabled(false);
        btnLuu.setEnabled(false);
        btnXoa.setEnabled(false);
        EnableFalse();
        EqualsNull();
        btnThem.setEnabled(true);
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        btnSua.setEnabled(false);
        btnLuu.setEnabled(true);
        btnThem.setEnabled(false);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        
        String tukhoa = this.txtTukhoa.getText();
        Connection connection = Connect.getConnection();
        if(connection==null){//ketnoi that bai
            JOptionPane.showMessageDialog(this,"Lỗi kết nối CSDL!");
            return;
        }else{
            String sql = "SELECT * FROM sanpham ";
            if(txtTukhoa.getText().equals("")==false){// neu tu khóa k trống thì cộng thêm
                String data =ComboBoxTimKiem.getSelectedItem().toString();
                
                if (data=="Mã loại SP") {
                    sql += "WHERE `maloaiSP` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Mã SP") {
                    sql += "WHERE `maSP` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Tên SP") {
                    sql += "WHERE `tenSP` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Size") {
                    sql += "WHERE `size` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Màu sắc") {
                    sql += "WHERE `mausac` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Mã NSX") {
                    sql += "WHERE `maNSX` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Số lượng") {
                    sql += "WHERE `soluong` LIKE '%"+tukhoa+"%'";
                }
                if (data=="Giá") {
                    sql += "WHERE `gia` LIKE '%"+tukhoa+"%'";
                }
            }
            try {
                PreparedStatement ps =connection.prepareStatement(sql);
                ResultSet rs =ps.executeQuery(sql);
                DefaultTableModel dtm =(DefaultTableModel) this.jTableSanPham.getModel();
                dtm.setRowCount(0);
                int dem =0;
                while (rs.next()){
                    String maloaiSP =rs.getString("maloaiSP");
                    String masp =rs.getString("MaSP");
                    String tensp =rs.getString("TenSP");
                    String size =rs.getString("size");
                    String masac =rs.getString("mausac");
                    String maNSX =rs.getString("maNSX");
                    String soluong =rs.getString("soluong");
                    String gia =rs.getString("gia");
                    
                     
                    dtm.addRow(new Object[] {maloaiSP,masp,tensp,size,masac,maNSX,soluong,gia});
                    dem++;
                }
                if (dem==0){
                    JOptionPane.showMessageDialog(this,"Chưa có sản phẩm!");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        btnTimkiem.setEnabled(false);
        txtTukhoa.setText("");
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        Showtable();
        btnTimkiem.setEnabled(false);
        EnableFalse();
        EqualsNull();
        txtTukhoa.setText("");
        btnLuu.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void txtTukhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTukhoaActionPerformed
        
    }//GEN-LAST:event_txtTukhoaActionPerformed

    private void txtTukhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTukhoaMouseClicked
        if (txtTukhoa.getText().trim()==null) {
            btnTimkiem.setEnabled(false);
        } else {
            btnTimkiem.setEnabled(true);
        }
    }//GEN-LAST:event_txtTukhoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1_MaloaiSP;
    private javax.swing.JComboBox<String> ComboBox3_maNSX;
    private javax.swing.JComboBox<String> ComboBoxTimKiem;
    private javax.swing.JLabel LableimgSP;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtMausac;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTukhoa;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
