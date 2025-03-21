/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Interface.frmDangNhap;
import java.sql.Connection;
import database.Connect;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Classssss.HoaDonClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.collections.map.HashedMap;
/**
 *
 * @author Nhi
 */
public class HoaDonBan extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonBan
     */
   DefaultListModel dm =new DefaultListModel();
    public HoaDonBan() {
        initComponents();
    }
    private void removeTableCThoadon(){
        DefaultTableModel dml = (DefaultTableModel) TableCTHoaDon.getModel();
        int rowCount = dml.getRowCount();
for (int i = rowCount - 1; i >= 0; i--) {
    dml.removeRow(i);
}
    }

    private void showSP(){
        try {
        TableCTHoaDon.removeAll();
        String[] arr ={"Tên loại sản phẩm","Mã sản phẩm","Tên sản phẩm","Số lượng","Thành tiền"};
        DefaultTableModel model =new DefaultTableModel(arr,0);
        Connection connection = Connect.getConnection();
        String query = "SELECT tenloaiSP,chitiethd.maSP,tenSP,soluongban,thanhtien FROM `sanpham` INNER JOIN `loaisanpham` ON sanpham.maloaiSP=loaisanpham.maloaiSP INNER JOIN `chitiethd` ON chitiethd.maSP= sanpham.maSP WHERE chitiethd.maHD =?";
        PreparedStatement ps =connection.prepareStatement(query);
        ps.setString(1,txtMaHD.getText());
        ResultSet rs =ps.executeQuery();
        while (rs.next()) {
            Vector vector =new Vector();
            vector.add(rs.getString("tenloaiSP"));
            vector.add(rs.getString("maSP"));
            vector.add(rs.getString("tenSP"));
            vector.add(rs.getString("soluongban"));
            vector.add(rs.getString("thanhtien"));
            model.addRow(vector);
        }
        Connect.closeConnection(connection);
        TableCTHoaDon.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void showHoaDon(){
        try {
        TableHoaDon.removeAll();
        String[] arr ={"Mã hóa đơn","Ngày tạo","Tổng tiền"};
        DefaultTableModel model =new DefaultTableModel(arr,0);
        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM `hoadon` WHERE  1";
        PreparedStatement ps =connection.prepareStatement(query);
        ResultSet rs =ps.executeQuery();
        while (rs.next()) {
            Vector vector =new Vector();
            vector.add(rs.getString("maHD"));
            vector.add(rs.getString("ngaytao"));
            vector.add(rs.getString("tong"));
            model.addRow(vector);
        }
        Connect.closeConnection(connection);
        TableHoaDon.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void clearTablemodel(){
        DefaultTableModel dtm = (DefaultTableModel) TableCTHoaDon.getModel();
        dtm.setRowCount(0);
    }
    public void EnableFalse(){
        txtMaKH.setEnabled(false);
        txtMasp.setEnabled(false);
        txtsoluong.setEnabled(false);
        txtgiaban.setEnabled(false);
        txtThanhtien.setEnabled(false);
    }
    public void ClearTextRight(){
        txtMasp.setText("");
        txtsoluong.setText("");
        txtgiaban.setText("");
        txtThanhtien.setText("");
    }
    public void EnableTrue(){
        txtMasp.setEnabled(true);
        txtsoluong.setEnabled(true);
        txtgiaban.setEnabled(true);
        txtThanhtien.setEnabled(true);
   }
    public void EnableFalseRight(){
        txtMasp.setEnabled(false);
        txtsoluong.setEnabled(false);
        txtgiaban.setEnabled(false);
        txtThanhtien.setEnabled(false);
        
   }
    private boolean CheckTrungHD(){
        try {
            Connection connection = Connect.getConnection();
            String sql = "SELECT * FROM `hoadon` WHERE `maHD` = ? ";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,txtMaHD.getText());
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                return true;
            }
        Connect.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    private boolean CheckTrungKH(){
        try {
            Connection connection = Connect.getConnection();
            String sql = "SELECT * FROM `khachhang` WHERE `maKH` = ? ";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,txtMaKH.getText());
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
    private void getStringSP(){
        try {
            Connection connection = Connect.getConnection();
            String maloaiSPP ;
            String giaSP;
            Statement stament = connection.createStatement();
            String sql = "SELECT gia FROM `sanpham` WHERE maSP='"+txtMasp.getText()+"'";
            ResultSet rs =stament.executeQuery(sql);
            if (rs.next()) {
                giaSP=rs.getString("gia");
                txtgiaban.setText(giaSP);
                dispose();
            }
        connection.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void themSP(){
        
        if(txtMaKH.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Tên khách hàng");
            txtMaKH.requestFocus();
            return;
        }
        if(txtMasp.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Mã sản phẩm");
            txtMasp.requestFocus();
            return;
        }
        if(txtgiaban.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Giá bán");
            txtgiaban.requestFocus();
            return;
        }
        if(txtsoluong.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Số lượng");
            txtsoluong.requestFocus();
            return;
        }
        if(txtThanhtien.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Thành tiền");
            txtThanhtien.requestFocus();
            return;
        }else
            try {
                Connection connection = Connect.getConnection();
            String input_sql = "INSERT INTO `chitiethd` (`maHD`,`ngaytao`, `maSP`, `maKH`, `soluongban`,`thanhtien`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps =connection.prepareStatement(input_sql);
            ps.setString(1,txtMaHD.getText());
            ps.setString(2,txtNgaytao.getText());
            ps.setString(3,txtMasp.getText());
            ps.setString(4,txtMaKH.getText());
            ps.setString(5,txtsoluong.getText());
            ps.setInt(6,Integer.parseInt(txtThanhtien.getText()));
            ps.executeUpdate();
            Connect.closeConnection(connection);
            showSP();
            JOptionPane.showMessageDialog(null,"Thêm thành công");
            btnupdate.setEnabled(true);
            txtMaHD.setEnabled(false);
            txtMaKH.setEnabled(false);
            btnLuu.setEnabled(false);
            txtMasp.setText("");
            txtsoluong.setText("");
            txtgiaban.setText("");
            txtThanhtien.setText("");
            EnableFalseRight();
           btnLuu.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    private void themHD(){
        if (txtMaHD.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Chưa nhập: Mã hóa đơn");
            txtMaHD.requestFocus();
            return;
        } else if (txtNgaytao.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Chưa nhập: Ngày tạo");
            txtNgaytao.requestFocus();
            return;
        }
        else
            CheckTrungHD();
            try {
                Connection connection = Connect.getConnection();
            String input_sql = "INSERT INTO `hoadon` (`maHD`,`ngaytao`) VALUES (?,?)";
            PreparedStatement ps =connection.prepareStatement(input_sql);
            ps.setString(1,txtMaHD.getText());
            ps.setString(2,txtNgaytao.getText());
            ps.executeUpdate();
            Connect.closeConnection(connection);
            showSP();
            JOptionPane.showMessageDialog(null,"Thêm thành công hóa đơn");
            showHoaDon();
            btnRefresh.setEnabled(true);
            btnThemHoadonMoi.setEnabled(false);
            btnThem.setEnabled(true);
            txtMaHD.setEnabled(false);
            txtMaKH.setEnabled(false);
            btnLuu.setEnabled(false);
            txtNgaytao.setEnabled(false);
            txtsoluong.setText("");
            txtgiaban.setText("");
            txtThanhtien.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatSanPhamPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
    private  void UPDate(){
        String sql = "UPDATE hoadon SET tong = (SELECT SUM(thanhtien) AS \"Tong\" FROM chitiethd WHERE chitiethd.ngaytao LIKE '%"+txtNgaytao.getText()+"%' AND maHD='"+txtMaHD.getText()+"')  WHERE hoadon.ngaytao LIKE '%"+txtNgaytao.getText()+"%'  AND maHD='"+txtMaHD.getText()+"' ";
            try {
                Connection connection = Connect.getConnection();
                PreparedStatement ps =  connection.prepareStatement(sql);
                int n= ps.executeUpdate();//thực hiện sql và trả về số dòng dươc thư hien
                if (n>0) {
                    JOptionPane.showMessageDialog(this,"UpDATe thông tin thành công!");
                     btnupdate.setEnabled(false);
                    btnLuu.setEnabled(false);
                    btnThem.setEnabled(true);
                    btnThemHoadonMoi.setEnabled(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Lỗi SQL!");
                Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
                }
    }
    private void getMaKH(){
            try {
            Connection connection = Connect.getConnection();
            String soluongban;
            String thanhtien;
            String maSP;
            Statement stament = connection.createStatement();
            String sql = "SELECT  chitiethd.maKH FROM chitiethd WHERE chitiethd.maHD='"+txtMaHD.getText()+"' AND chitiethd.ngaytao='"+txtNgaytao.getText()+"'";
            ResultSet rs =stament.executeQuery(sql);
            if (rs.next()) {
                String maKHH=rs.getString("maKH");
                this.txtMaKH.setText(maKHH);
                dispose();
            }
        connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThemHoadonMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCTHoaDon = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableHoaDon = new javax.swing.JTable();
        txtNgaytao = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        txtMasp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtThanhtien = new javax.swing.JTextField();
        txtgiaban = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 408));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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

        btnLuu.setBackground(new java.awt.Color(126, 146, 182));
        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThemHoadonMoi.setBackground(new java.awt.Color(126, 146, 182));
        btnThemHoadonMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemHoadonMoi.setText("Thêm hóa đơn");
        btnThemHoadonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoadonMoiActionPerformed(evt);
            }
        });

        TableCTHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên loại sản phẩm", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCTHoaDon.setMaximumSize(new java.awt.Dimension(300, 64));
        TableCTHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCTHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCTHoaDon);
        if (TableCTHoaDon.getColumnModel().getColumnCount() > 0) {
            TableCTHoaDon.getColumnModel().getColumn(0).setResizable(false);
            TableCTHoaDon.getColumnModel().getColumn(1).setResizable(false);
            TableCTHoaDon.getColumnModel().getColumn(2).setResizable(false);
            TableCTHoaDon.getColumnModel().getColumn(3).setResizable(false);
            TableCTHoaDon.getColumnModel().getColumn(4).setResizable(false);
        }

        btnupdate.setBackground(new java.awt.Color(126, 146, 182));
        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel13.setText("QUẢN LÝ HÓA ĐƠN BÁN HÀNG");

        TableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableHoaDon.setGridColor(new java.awt.Color(0, 0, 0));
        TableHoaDon.setName(""); // NOI18N
        TableHoaDon.setSelectionBackground(new java.awt.Color(0, 0, 0));
        TableHoaDon.setSelectionForeground(new java.awt.Color(51, 102, 255));
        TableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableHoaDon);
        if (TableHoaDon.getColumnModel().getColumnCount() > 0) {
            TableHoaDon.getColumnModel().getColumn(0).setHeaderValue("Mã hóa đơn");
            TableHoaDon.getColumnModel().getColumn(1).setHeaderValue("Ngày tạo");
            TableHoaDon.getColumnModel().getColumn(2).setHeaderValue("Tổng tiền");
        }
        TableHoaDon.getAccessibleContext().setAccessibleName("Chi tiết hóa đơn");

        txtNgaytao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaytaoActionPerformed(evt);
            }
        });

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Mã Hóa đơn:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Ngày tạo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Mã khách hàng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Số lượng:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Mã sản phẩm:");

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        txtMasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaspActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Thành tiền:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Giá:");

        btnRefresh.setBackground(new java.awt.Color(126, 146, 182));
        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel13))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(txtNgaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnThem)
                        .addGap(48, 48, 48)
                        .addComponent(btnSua)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThemHoadonMoi)
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnLuu)
                        .addGap(257, 257, 257)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnupdate))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThanhtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel12))
                                    .addComponent(txtNgaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSua)
                                        .addComponent(btnXoa)
                                        .addComponent(btnLuu)
                                        .addComponent(btnThemHoadonMoi)
                                        .addComponent(btnupdate)
                                        .addComponent(btnRefresh))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(txtThanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel11))
                            .addComponent(jLabel1))))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        btnLuu.setEnabled(false);
        btnRefresh.setEnabled(true);
        btnupdate.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(false);
        showHoaDon();
        if (txtMaHD.getText().equals("")==true) {
            EnableFalseRight();
            txtMaHD.setEnabled(false);
            txtNgaytao.setEnabled(false);
            txtMaKH.setEnabled(false);
        }
        if (btnSua.isEnabled()==false && btnThemHoadonMoi.isEnabled()==false && btnXoa.isEnabled()==false ) {
            btnThem.setEnabled(true);
            btnLuu.setEnabled(true);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnThemHoadonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoadonMoiActionPerformed
        //hoi 
            int res = JOptionPane.showConfirmDialog(this, "Bạn muốn tạo hóa đơn mới?","Tạo hóa đơn mới",
                                                JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION) {
                 clearTablemodel();
                EnableFalse();
                btnThem.setEnabled(false);
                btnThemHoadonMoi.setEnabled(false);
                btnSua.setEnabled(false);
                btnXoa.setEnabled(false);
                btnLuu.setEnabled(true);
                ClearTextRight();
                txtMaHD.setText("");
                txtMaHD.setEnabled(true);
                txtNgaytao.setEnabled(true);
                txtNgaytao.setText("");
                txtMaKH.setEnabled(false);
                txtMaKH.setText("");
            }
    }//GEN-LAST:event_btnThemHoadonMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnLuu.setEnabled(true);
        btnRefresh.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        btnLuu.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnRefresh.setEnabled(true);
        ClearTextRight();
        if (txtMaKH.getText().equals("")&& txtMaHD.isEnabled()==false && txtNgaytao.isEnabled()==false) {
            txtMaKH.setEnabled(true);
        } else
            txtMaKH.setEnabled(false);
        EnableTrue();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        btnLuu.setEnabled(true);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThemHoadonMoi.setEnabled(false);
        txtMasp.setEnabled(false);
        txtgiaban.setEnabled(false);
        txtsoluong.setEnabled(true);
        txtThanhtien.setEnabled(true);
        txtThanhtien.setText("");
        txtsoluong.setText("");
        btnRefresh.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        //themhd
        if (btnThem.isEnabled()==false && btnSua.isEnabled()==false && btnXoa.isEnabled()==false && btnThemHoadonMoi.isEnabled()==false) {
            themHD();
        }
        //them sp 
        if (btnThem.isEnabled()==true && btnLuu.isEnabled()==true ) {
            themSP();
            ClearTextRight();
        }
        //sua
        if (btnThem.isEnabled()==false && btnSua.isEnabled()==true && btnXoa.isEnabled()==false && btnLuu.isEnabled()==true) {
             int i = TableCTHoaDon.getSelectedRow();
        if (i<0) {
            JOptionPane.showMessageDialog(this,"Chưa chọn sản phẩm cần sửa!");
            return;
        }
        DefaultTableModel dtm =(DefaultTableModel) this.TableCTHoaDon.getModel();
        //lay du lieu dong i, cot 0 ( mã sp)
//        String masp = (String)dtm.getValueAt(i, 0);
            if(txtsoluong.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Số lượng");
            txtsoluong.requestFocus();
            return;
            }else if(txtThanhtien.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Chưa nhập: Thành tiền");
            txtThanhtien.requestFocus();
            return;
               }
            //hoi lại
            int res = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa?","Sửa thông tin sản phẩm",
                                                JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION) {
            Connection connection = Connect.getConnection();
            if(connection==null){
                JOptionPane.showMessageDialog(this,"Lỗi kết nối CSDL !");
                return;
            }
            //truy van SQL
            String sql = "UPDATE `chitiethd` SET `maHD`=?,`ngaytao`=?,`maSP`=?,`maKH`=?, `soluongban`=?,`thanhtien`=? WHERE `maHD`='"+txtMaHD.getText()+"' AND `maSP`='"+txtMasp.getText()+"'";
            try {
                PreparedStatement ps =  connection.prepareStatement(sql);
                
                ps.setString(1,txtMaHD.getText());
                ps.setString(2,txtNgaytao.getText());
                ps.setString(3,txtMasp.getText());
                ps.setString(4,txtMaKH.getText());
                ps.setString(5,txtsoluong.getText());
                ps.setString(6,txtThanhtien.getText());
                
                int n= ps.executeUpdate();//thực hiện sql và trả về số dòng dươc thư hien
                if (n>0) {
                    JOptionPane.showMessageDialog(this,"Sửa thông tin thành công!");
                     showSP();
                    btnSua.setEnabled(false);
                    btnLuu.setEnabled(false);
                    btnThemHoadonMoi.setEnabled(true);
                    btnThem.setEnabled(true);
                    btnupdate.setEnabled(true);
                    EnableFalseRight();
                    ClearTextRight();
                    EnableFalseRight();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Lỗi SQL!");
                Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        //xoa 
         if (btnThem.isEnabled()==false && btnSua.isEnabled()==false && btnXoa.isEnabled()==true ) {
           int i = TableCTHoaDon.getSelectedRow();
            if (i<0) {
            JOptionPane.showMessageDialog(this,"Mời chọn sản phẩm cần xóa!");
            return;
            }
            String data =TableCTHoaDon.getModel().getValueAt(i,0).toString();
            int res = JOptionPane.showConfirmDialog(this,  "Bạn có chắc muốn xóa?","Xóa sản phẩm",
                                                JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION) {
                Connection connection = Connect.getConnection();
                if(connection==null){
                    JOptionPane.showMessageDialog(this,"Lỗi kết nối CSDL!");
                    return;
                }
                try {
                String delsql = "DELETE FROM `chitiethd` WHERE chitiethd.maHD='"+txtMaHD.getText()+"' AND maSP='"+txtMasp.getText()+"'";
                PreparedStatement ps =connection.prepareStatement(delsql);
                
                ps.executeUpdate();
                Connect.closeConnection(connection);
                showSP();
                JOptionPane.showMessageDialog(null,"Xóa sản phẩm thành công");
                btnXoa.setEnabled(false);
                btnupdate.setEnabled(true);
                } catch (SQLException ex) {
                Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
         }
//         EnableFalseRight();
//         btnThem.setEnabled(true);
//         btnThemHoadonMoi.setEnabled(true);
         
    }//GEN-LAST:event_btnLuuActionPerformed

    private void TableCTHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCTHoaDonMouseClicked
        if( btnThem.isEnabled()==true ){
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            btnLuu.setEnabled(false);
        }
        int i = TableCTHoaDon.getSelectedRow();
        DefaultTableModel dtm =(DefaultTableModel) this.TableCTHoaDon.getModel();
        String maSPString = (String)dtm.getValueAt(i, 1);
        try {
            Connection connection = Connect.getConnection();
            
            String giaSP;
            String soluongban;
            String thanhtien;
            String maSP;
            Statement stament = connection.createStatement();
            String sql = "SELECT  chitiethd.soluongban,sanpham.gia,chitiethd.thanhtien,chitiethd.maKH,chitiethd.ngaytao  "
                    + "FROM chitiethd INNER JOIN khachhang ON chitiethd.maKH=khachhang.maKH "
                    + "INNER JOIN sanpham ON sanpham.maSP=chitiethd.maSP WHERE chitiethd.maHD='"+txtMaHD.getText()+"' AND chitiethd.maSP='"+maSPString+"'";
            ResultSet rs =stament.executeQuery(sql);
            if (rs.next()) {
                String maKHH=rs.getString("maKH");
                String ngaytao=rs.getString("ngaytao");
                giaSP=rs.getString("gia");
                soluongban= rs.getString("soluongban");
                thanhtien =rs.getString("thanhtien");
                this.txtMaKH.setText(maKHH);
                txtMasp.setText(ngaytao);
                txtMasp.setText(maSPString);
                txtgiaban.setText(giaSP);
                txtsoluong.setText(soluongban);
                txtThanhtien.setText(thanhtien);
                dispose();
            }
        connection.close();
        
        EnableFalse();
        txtMaHD.setEnabled(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
           
        }
        
    }//GEN-LAST:event_TableCTHoaDonMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       UPDate();
       showHoaDon();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void TableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableHoaDonMouseClicked
        ClearTextRight();
        btnLuu.setEnabled(false);
        txtMaHD.setEnabled(false);
        txtNgaytao.setEnabled(false);
        int i = TableHoaDon.getSelectedRow();
        DefaultTableModel dtm =(DefaultTableModel) this.TableHoaDon.getModel();
        String maHDString = (String)dtm.getValueAt(i, 0);
        txtMaHD.setText(maHDString);
        String Ngaytao = (String)dtm.getValueAt(i, 1);
        txtNgaytao.setText(Ngaytao);
        getMaKH();
        try {
        TableCTHoaDon.removeAll();
        String[] arr ={"Tên loại sản phẩm","Mã sản phẩm","Tên sản phẩm","Số lượng","Thành tiền"};
        DefaultTableModel model =new DefaultTableModel(arr,0);
        Connection connection = Connect.getConnection();
        String query = "SELECT  loaisanpham.tenloaiSP,chitiethd.maSP,chitiethd.maKH,sanpham.tenSP,soluongban,thanhtien FROM `chitiethd` INNER JOIN `sanpham` ON chitiethd.maSP= sanpham.maSP INNER JOIN `loaisanpham` ON sanpham.maloaiSP=loaisanpham.maloaiSP  WHERE chitiethd.maHD =?";
        PreparedStatement ps =connection.prepareStatement(query);
        ps.setString(1,maHDString);
        ResultSet rs =ps.executeQuery();
        while (rs.next()) {
            Vector vector =new Vector();
            
            vector.add(rs.getString("tenloaiSP"));
            vector.add(rs.getString("maSP"));
            vector.add(rs.getString("tenSP"));
            vector.add(rs.getString("soluongban"));
            vector.add(rs.getString("thanhtien"));
            model.addRow(vector);
        }
        Connect.closeConnection(connection);
        TableCTHoaDon.setModel(model);
        EnableFalse();
        btnThem.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_TableHoaDonMouseClicked

    private void txtNgaytaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaytaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaytaoActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        btnThemHoadonMoi.setEnabled(true);

        try {
            TableCTHoaDon.removeAll();
            String[] arr ={"Tên loại sản phẩm","Mã sản phẩm","Tên sản phẩm","Số lượng","Thành tiền"};
            DefaultTableModel model =new DefaultTableModel(arr,0);
            Connection connection = Connect.getConnection();
            String query = "SELECT loaisanpham.tenloaiSP,chitiethd.maSP,sanpham.tenSP,soluongban,thanhtien FROM `chitiethd` INNER JOIN `sanpham` ON chitiethd.maSP= sanpham.maSP INNER JOIN `loaisanpham` ON sanpham.maloaiSP=loaisanpham.maloaiSP  WHERE chitiethd.maHD =?";
            PreparedStatement ps =connection.prepareStatement(query);
            ps.setString(1,txtMaHD.getText());
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                Vector vector =new Vector();
                vector.add(rs.getString("tenloaiSP"));
                vector.add(rs.getString("maSP"));
                vector.add(rs.getString("tenSP"));
                vector.add(rs.getString("soluongban"));
                vector.add(rs.getString("thanhtien"));
                model.addRow(vector);
            }
            Connect.closeConnection(connection);
            TableCTHoaDon.setModel(model);
            EnableFalse();

            btnThem.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBan.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        int thanhtien;
        String soluong=txtsoluong.getText();
        int fsoluong =Integer.parseInt(soluong);
        String gia =  txtgiaban.getText();
        int fgia =Integer.parseInt(gia);
        if (!txtsoluong.getText().trim().equals("")) {
            thanhtien = fsoluong*fgia;
            String Sthanhtien = String.valueOf(thanhtien);
            txtThanhtien.setText(Sthanhtien);
        }
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void txtMaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaspActionPerformed
        if (!txtMasp.getText().trim().equals("")) {
            getStringSP();
        }
    }//GEN-LAST:event_txtMaspActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        btnThemHoadonMoi.setEnabled(true);
        TableCTHoaDon.removeAll();
        btnLuu.setEnabled(false);
        btnSua.setEnabled(false);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnupdate.setEnabled(false);
        txtMaHD.setEnabled(false);
        txtMasp.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtNgaytao.setEnabled(false);
        txtNgaytao.setText("");
        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMasp.setText("");
        EnableFalseRight();
        ClearTextRight();
        removeTableCThoadon();
       
        
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCTHoaDon;
    private javax.swing.JTable TableHoaDon;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemHoadonMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtNgaytao;
    private javax.swing.JTextField txtThanhtien;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
