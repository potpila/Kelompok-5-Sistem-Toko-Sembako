package tampilan;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelTransaksi extends javax.swing.JPanel {

    DefaultTableModel modelKeranjang;
    int grandTotal = 0;
    
    public PanelTransaksi() {
        initComponents();
        
        // Mempersiapkan kolom keranjang sementara
        modelKeranjang = new DefaultTableModel();
        modelKeranjang.addColumn("Nama Barang");
        modelKeranjang.addColumn("Harga Satuan");
        modelKeranjang.addColumn("Jumlah Beli");
        modelKeranjang.addColumn("Subtotal");
        modelKeranjang.addColumn("Tanggal Transaksi");
        tabelKeranjang.setModel(modelKeranjang);
        
        // Memanggil data awal
        loadPelanggan();
        loadBarang();
    }
    
    private int getIdPelanggan(String nama) {
    int id = 0;
    try {
        Connection conn = koneksi.getConnection();
        String sql = "SELECT id_pelanggan FROM pelanggan WHERE nama_pelanggan = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id_pelanggan");
        }
    } catch (Exception e) {
        System.out.println("Gagal mengambil ID Pelanggan: " + e.getMessage());
    }
    return id;
    }

    private int getIdBarang(String nama) {
    int id = 0;
    try {
        Connection conn = koneksi.getConnection();
        String sql = "SELECT id_barang FROM barang WHERE nama_barang = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id_barang");
        }
    } catch (Exception e) {
        System.out.println("Gagal mengambil ID Barang: " + e.getMessage());
    }
    return id;
    }
    
    private void loadPelanggan() {
        try {
            cb_pelanggan.removeAllItems();
            Connection conn = koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_pelanggan FROM pelanggan");
            while (rs.next()) {
                cb_pelanggan.addItem(rs.getString("nama_pelanggan"));
            }
        } catch (Exception e) {
            System.out.println("Error Pelanggan: " + e.getMessage());
        }
    }

    private void loadBarang() {
        try {
            cb_barang.removeAllItems();
            Connection conn = koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_barang FROM barang");
            while (rs.next()) {
                cb_barang.addItem(rs.getString("nama_barang"));
            }
        } catch (Exception e) {
            System.out.println("Error Barang: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        cb_pelanggan = new javax.swing.JComboBox<>();
        cb_barang = new javax.swing.JComboBox<>();
        txt_harga = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        btnPrintTransaksi = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKeranjang = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Kelola Data Transaksi");

        jLabel2.setText("Pilih Pelanggan");

        jLabel3.setText("Pilih Barang");

        jLabel4.setText("Harga Satuan");

        jLabel5.setText("Jumlah Beli");

        btn_tambah.setText("Tambah Ke Keranjang");
        btn_tambah.addActionListener(this::btn_tambahActionPerformed);

        cb_pelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_barang.addActionListener(this::cb_barangActionPerformed);

        txt_harga.setEditable(false);

        jLabel6.setText("Total Belanja");

        txt_total.setEditable(false);

        jLabel7.setText("Uang Bayar");

        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
        });

        jLabel8.setText("Uang Kembalian");

        txt_kembalian.setEditable(false);

        btnPrintTransaksi.setText("Print Transaksi");
        btnPrintTransaksi.addActionListener(this::btnPrintTransaksiActionPerformed);

        btn_simpan.setText("Simpan Transaksi");
        btn_simpan.addActionListener(this::btn_simpanActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(259, 259, 259)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_tambah))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_harga)
                                .addComponent(txt_jumlah)
                                .addComponent(txt_total)
                                .addComponent(txt_bayar)
                                .addComponent(cb_pelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_barang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_kembalian)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrintTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cb_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(btnPrintTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_simpan)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelKeranjang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_barangActionPerformed
        // TODO add your handling code here:
        if (cb_barang.getSelectedItem() != null) {
            String namaDipilih = cb_barang.getSelectedItem().toString();
            try {
                Connection conn = koneksi.getConnection();
                String sql = "SELECT harga_satuan FROM barang WHERE nama_barang = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, namaDipilih);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    txt_harga.setText(rs.getString("harga_satuan"));
                }
            } catch (Exception e) {
                System.out.println("Gagal ambil harga: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_cb_barangActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        // Mengambil nilai dari form
        String namaBarang = cb_barang.getSelectedItem().toString();
        int harga = Integer.parseInt(txt_harga.getText());
        int jumlah = Integer.parseInt(txt_jumlah.getText());
        
        // Penjumlahan biasa untuk subtotal
        int subtotal = harga * jumlah;
        
        // Mengambil tanggal hari ini secara otomatis (Format: YYYY-MM-DD)
        String tanggal = java.time.LocalDate.now().toString();
        
        // Memasukkan ke tabel keranjang (pastikan urutannya sama dengan constructor)
        modelKeranjang.addRow(new Object[]{
            namaBarang,
            harga,
            jumlah,
            subtotal,
            tanggal // Tambahan variabel tanggal
        });
        
        // Menambahkan ke Grand Total
        grandTotal = grandTotal + subtotal;
        txt_total.setText(String.valueOf(grandTotal));
        
        // Mengosongkan isian untuk barang berikutnya
        txt_jumlah.setText("");
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        // TODO add your handling code here:
        try {
            int bayar = Integer.parseInt(txt_bayar.getText());
            int kembalian = bayar - grandTotal;
            txt_kembalian.setText(String.valueOf(kembalian));
        } catch (NumberFormatException e) {
            txt_kembalian.setText("0"); // Mencegah error jika inputan kosong/huruf
        }
    }//GEN-LAST:event_txt_bayarKeyReleased

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        int jumlahBaris = tabelKeranjang.getRowCount();
    
        if (jumlahBaris == 0) {
        JOptionPane.showMessageDialog(null, "Keranjang belanja masih kosong!");
        return; // Menghentikan proses jika kosong
        }
    
        try {
        Connection conn = koneksi.getConnection();
        
        // 1. Ambil nama dari ComboBox pelanggan, lalu cari ID-nya
        String namaPelanggan = cb_pelanggan.getSelectedItem().toString();
        int idPelanggan = getIdPelanggan(namaPelanggan);
        
        // 2. Ambil tanggal hari ini secara otomatis dari sistem komputer
        java.sql.Date tanggalHariIni = new java.sql.Date(System.currentTimeMillis());
        
        // Looping membaca isi keranjang dari baris pertama (indeks 0) sampai habis
        for (int i = 0; i < jumlahBaris; i++) {
            String namaBarang = tabelKeranjang.getValueAt(i, 0).toString();
            
            // Cari ID Barang berdasarkan nama barang
            int idBarang = getIdBarang(namaBarang); 
            
            int jumlahBeli = Integer.parseInt(tabelKeranjang.getValueAt(i, 2).toString());
            int subtotal = Integer.parseInt(tabelKeranjang.getValueAt(i, 3).toString());
            
            // Mengambil tanggal dari tabel antarmuka (Indeks ke-4) dan mengubahnya ke format SQL
            String stringTanggal = tabelKeranjang.getValueAt(i, 4).toString();
            java.sql.Date tanggalTransaksi = java.sql.Date.valueOf(stringTanggal);
            
            // 1. Simpan ke tabel transaksi
            String sqlTransaksi = "INSERT INTO transaksi (id_pelanggan, id_barang, jumlah_beli, tanggal_transaksi, total_harga) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstTrans = conn.prepareStatement(sqlTransaksi);
            pstTrans.setInt(1, idPelanggan);
            pstTrans.setInt(2, idBarang);
            pstTrans.setInt(3, jumlahBeli);
            pstTrans.setDate(4, tanggalTransaksi); // Menggunakan tanggal dari tabel
            pstTrans.setInt(5, subtotal);
            pstTrans.executeUpdate();
            
            // 2. Potong Stok Otomatis di tabel barang
            String sqlStok = "UPDATE barang SET stok = stok - ? WHERE id_barang = ?";
            PreparedStatement pstStok = conn.prepareStatement(sqlStok);
            pstStok.setInt(1, jumlahBeli);
            pstStok.setInt(2, idBarang);
            pstStok.executeUpdate();
        }
        
        JOptionPane.showMessageDialog(null, "Transaksi Berhasil Disimpan ke Database!");
        
        // Bersihkan seluruh form inputan kasir
        modelKeranjang.setRowCount(0);
        grandTotal = 0;
        txt_total.setText("0");
        txt_bayar.setText("");
        txt_kembalian.setText("0");
        txt_jumlah.setText("");
        
        } catch (SQLIntegrityConstraintViolationException e) {
        // Ini terjadi jika ID Pelanggan atau ID Barang tiba-tiba tidak valid/ hilang
        JOptionPane.showMessageDialog(null, "Transaksi Gagal!\nPastikan Pelanggan dan Barang yang dipilih masih tersedia di database.");
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Transaksi Gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btnPrintTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTransaksiActionPerformed
        // TODO add your handling code here:
         try {
            // Cek apakah keranjang kosong
            if (tabelKeranjang.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Keranjang belanja kosong! Tidak ada yang bisa dicetak.");
                return;
            }

            String html = "<html>"
                    + "<head>"
                    + "<title>Struk Transaksi</title>"
                    + "<style>"
                    + "table{border-collapse:collapse;width:100%;margin-top:20px;}"
                    + "th,td{border:1px solid black;padding:8px;text-align:left;}"
                    + "th{background:#FF9800;color:white;}"
                    + ".total{font-size:18px;font-weight:bold;margin-top:20px;text-align:right;}"
                    + "</style>"
                    + "</head>"
                    + "<body>";

            // Header
            html += "<div style='text-align:center; margin-bottom:20px;'>";
            html += "<h2>STRUK BELANJA</h2>";
            html += "<p>Tanggal Cetak: " + new SimpleDateFormat("dd MMMM yyyy").format(new Date()) + "</p>";
            html += "</div>";

            // Tabel keranjang
            html += "<table>";
            html += "<tr>"
                    + "<th>Nama Barang</th>"
                    + "<th>Harga Satuan</th>"
                    + "<th>Jumlah Beli</th>"
                    + "<th>Subtotal</th>"
                    + "<th>Tanggal</th>"
                    + "</tr>";

            for (int i = 0; i < tabelKeranjang.getRowCount(); i++) {
                html += "<tr>";
                for (int j = 0; j < tabelKeranjang.getColumnCount(); j++) {
                    Object value = tabelKeranjang.getValueAt(i, j);
                    html += "<td>" + (value == null ? "" : value.toString()) + "</td>";
                }
                html += "</tr>";
            }

            html += "</table>";

            // Total Belanja
            html += "<div class='total'>";
            html += "Total Belanja: Rp " + txt_total.getText();
            html += "</div>";

            // Tanda tangan
            html += "<br><br><br>";
            html += "<div style='float:right; text-align:center; margin-right:40px;'>";
            html += "<b>Kasir</b><br>";
            html += "_________________";
            html += "</div>";
            html += "<div style='clear:both;'></div>";

            html += "</body></html>";

            // Simpan file HTML
            File file = new File("struk_transaksi.html");
            FileWriter fw = new FileWriter(file);
            fw.write(html);
            fw.close();

            JOptionPane.showMessageDialog(null, "Struk berhasil dibuat! Membuka browser untuk mencetak...");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membuat struk: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPrintTransaksiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintTransaksi;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_barang;
    private javax.swing.JComboBox<String> cb_pelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelKeranjang;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
