package tampilan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;

public class lihat_data extends javax.swing.JPanel {

    public lihat_data() {
        initComponents();
        
        tampilData();
    }
    
    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        // 1. Ganti nama kolom sesuai data sembako
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Harga Satuan");
        model.addColumn("Stok");

        try {
            Connection conn = koneksi.getConnection();
            String keyword = jTextField1.getText().trim(); 

            // 2. Ganti nama tabel dari 'siswa' menjadi 'barang'
            // Sesuaikan juga nama kolom pencariannya dengan yang ada di databasemu
            String sql = "SELECT * FROM barang WHERE "
                    + "id_barang LIKE ? OR "
                    + "nama_barang LIKE ? OR "
                    + "kategori_barang LIKE ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            // 3. Karena di atas kita pakai 3 'LIKE ?', maka perulangannya cukup sampai 3
            for (int i = 1; i <= 3; i++) {
                pst.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // 4. Pastikan nama getString() sesuai dengan nama kolom di database MySQL-mu
                model.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("harga_satuan"),
                    rs.getString("stok")
                });
            }

            jTable1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pencarian gagal: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Data Sembako");

        jLabel2.setText("Pencarian");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Print");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(61, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampilData(); // Panggil fungsi ini saat tombol cari diklik
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // Menangkap kata kunci dari kolom pencarian
            String keyword = jTextField1.getText().trim();
            String infoPencarian = keyword.isEmpty() ? "Semua Data" : "Pencarian: " + keyword;

            String html = "<html>"
                    + "<head>"
                    + "<title>Laporan Data Barang</title>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; }" // Tambahan font dasar agar lebih rapi
                    + "table { border-collapse: collapse; width: 100%; margin-top: 20px; }"
                    + "th, td { border: 1px solid black; padding: 8px; text-align: left; }"
                    + "th { background: #4CAF50; color: white; }"
                    + "</style>"
                    + "</head>"
                    // Fitur Auto-Print dipanggil saat halaman selesai dimuat
                    + "<body onload='window.print()'>"; 

            // Header Laporan
            html += "<div style='text-align:center; margin-bottom:20px;'>";
            html += "<h2>LAPORAN DATA BARANG SEMBAKO</h2>";
            html += "<p>Tanggal Cetak: " + new java.text.SimpleDateFormat("dd MMMM yyyy").format(new java.util.Date()) + "</p>";
            // Menampilkan informasi filter pencarian
            html += "<p><b>Filter: " + infoPencarian + "</b></p>"; 
            html += "</div>";

            // Tabel
            html += "<table>";
            html += "<tr>";
            
            // Mengambil Header secara dinamis dari jTable1
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                html += "<th>" + jTable1.getColumnName(j) + "</th>";
            }
            html += "</tr>";

            // Ambil data dari tabel
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                html += "<tr>";
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    Object value = jTable1.getValueAt(i, j);
                    html += "<td>" + (value == null ? "" : value.toString()) + "</td>";
                }
                html += "</tr>";
            }

            html += "</table>";

            // Menampilkan Total Data
            html += "<p style='margin-top: 15px;'><b>Total Baris Data: " + jTable1.getRowCount() + " item</b></p>";

            // Tanda tangan Admin
            html += "<br><br>";
            html += "<div style='float:right; text-align:center; margin-right:40px;'>";
            html += "<b>Admin Sembako</b><br><br><br><br>";
            html += "<span style='text-decoration: underline;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"; // Garis untuk tanda tangan fisik
            html += "</div>";
            html += "<div style='clear:both;'></div>";

            html += "</body></html>";

            // Simpan file HTML
            java.io.File file = new java.io.File("laporan_barang.html");
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(html);
            fw.close();

            // Notifikasi sukses
            javax.swing.JOptionPane.showMessageDialog(null, "Laporan berhasil dibuat! Membuka browser...");

            // Buka di browser
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().browse(file.toURI());
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal membuat laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
