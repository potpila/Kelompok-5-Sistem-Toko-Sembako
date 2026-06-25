package tampilan;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import koneksi.koneksi;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelPelanggan extends javax.swing.JPanel {
private TableRowSorter<DefaultTableModel> sorter;
    
    public PanelPelanggan() {
        initComponents();
        
        tampilData();
    }

    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("No. Hp");
        model.addColumn("Alamat Pelanggan");

        try {
            Connection conn = koneksi.getConnection();
            String sql = "SELECT * FROM pelanggan"; 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_pelanggan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("no_hp"),           
                    rs.getString("alamat_pelanggan")   
                });
            }
            jTable1.setModel(model);
            sorter = new TableRowSorter<>(model);
            jTable1.setRowSorter(sorter);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data : " + e.getMessage());
        }
    }
    
    private void cariData() {
        String keyword = txtCari.getText().trim();
        if (sorter == null) {
            tampilData(); // reload data jika sorter belum siap
            if (sorter == null) {
                JOptionPane.showMessageDialog(this, "Data belum siap, coba lagi.");
                return;
            }
        }
        if (keyword.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JButton();
        btnPrintPelanggan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nama Pelanggan");

        jLabel2.setText("No. Telepon");

        jLabel3.setText("Alamat Pelanggan");

        jButton1.setText("Simpan");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Clear");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Update");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Delete");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel4.setText("Kelola Data Pelanggan");

        jLabel5.setText("Cari");

        btn_Cari.setText("Cari");
        btn_Cari.addActionListener(this::btn_CariActionPerformed);

        btnPrintPelanggan.setText("Print");
        btnPrintPelanggan.addActionListener(this::btnPrintPelangganActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(51, 51, 51))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(25, 25, 25)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(95, 95, 95)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_Cari))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1))
                                .addGap(18, 18, 18)
                                .addComponent(btnPrintPelanggan))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel4)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btn_Cari)
                    .addComponent(btnPrintPelanggan))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Tombol Simpan
        try {
            Connection conn = koneksi.getConnection();
            String sql = "INSERT INTO pelanggan (nama_pelanggan, no_hp, alamat_pelanggan) VALUES (?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, jTextField1.getText()); // Nama Pelanggan
            stat.setString(2, jTextField2.getText()); // No Telepon
            stat.setString(3, jTextField3.getText()); // Alamat

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");

            tampilData(); // Refresh tabel

            // Mengosongkan form
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Tombol Clear
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTable1.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // Tombol Update
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            String id = jTable1.getValueAt(baris, 0).toString();
            try {
                String sql = "UPDATE pelanggan SET nama_pelanggan='" + jTextField1.getText() +
                             "', no_hp='" + jTextField2.getText() +
                             "', alamat_pelanggan='" + jTextField3.getText() +
                             "' WHERE id_pelanggan='" + id + "'";

                Connection conn = koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

                tampilData();
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Perubahan Gagal: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data di tabel terlebih dahulu");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // Tombol Delete
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            String id = jTable1.getValueAt(baris, 0).toString();
            try {
                String sql = "DELETE FROM pelanggan WHERE id_pelanggan='" + id + "'";

                Connection conn = koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                tampilData();
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");

            } catch (SQLIntegrityConstraintViolationException e) {
            // Pesan spesifik untuk pelanggaran Foreign Key
            JOptionPane.showMessageDialog(null, "Gagal menghapus Pelanggan!\nPelanggan ini masih memiliki riwayat Transaksi.");
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hapus Data Gagal: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data di tabel terlebih dahulu");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            jTextField1.setText(jTable1.getValueAt(baris, 1).toString()); // Nama Pelanggan
            jTextField2.setText(jTable1.getValueAt(baris, 2).toString()); // No Telepon
            jTextField3.setText(jTable1.getValueAt(baris, 3).toString()); // Alamat
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CariActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_btn_CariActionPerformed

    private void btnPrintPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPelangganActionPerformed
        // TODO add your handling code here:
        try {
            String html = "<html>"
                    + "<head>"
                    + "<title>Laporan Data Pelanggan</title>"
                    + "<style>"
                    + "table{border-collapse:collapse;width:100%;margin-top:20px;}"
                    + "th,td{border:1px solid black;padding:8px;text-align:left;}"
                    + "th{background:#2196F3;color:white;}"
                    + "</style>"
                    + "</head>"
                    + "<body>";

            // Header
            html += "<div style='text-align:center; margin-bottom:20px;'>";
            html += "<h2>LAPORAN DATA PELANGGAN</h2>";
            html += "<p>Tanggal Cetak: " + new SimpleDateFormat("dd MMMM yyyy").format(new Date()) + "</p>";
            html += "</div>";

            // Tabel
            html += "<table>";
            html += "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nama Pelanggan</th>"
                    + "<th>No. HP</th>"
                    + "<th>Alamat</th>"
                    + "</tr>";

            // Ambil data dari tabel (yang sudah terfilter)
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                html += "<tr>";
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    Object value = jTable1.getValueAt(i, j);
                    html += "<td>" + (value == null ? "" : value.toString()) + "</td>";
                }
                html += "</tr>";
            }

            html += "</table>";

            // Tanda tangan
            html += "<br><br><br>";
            html += "<div style='float:right; text-align:center; margin-right:40px;'>";
            html += "<b>Admin Sembako</b>";
            html += "</div>";
            html += "<div style='clear:both;'></div>";

            html += "</body></html>";

            // Simpan file HTML
            File file = new File("laporan_pelanggan.html");
            FileWriter fw = new FileWriter(file);
            fw.write(html);
            fw.close();

            JOptionPane.showMessageDialog(null, "Laporan berhasil dibuat! Membuka browser...");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membuat laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPrintPelangganActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintPelanggan;
    private javax.swing.JButton btn_Cari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
