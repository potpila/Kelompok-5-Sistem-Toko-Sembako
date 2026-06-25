package tampilan;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelBarang extends javax.swing.JPanel {
private TableRowSorter<DefaultTableModel> sorter;

    public PanelBarang() {
        initComponents();
        
        tampilData();
    }

    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Ukuran & Satuan"); // Kolom gabungan
        model.addColumn("Harga Satuan");
        model.addColumn("Stok");

        try {
            Connection conn = koneksi.getConnection();
            String sql = "SELECT * FROM barang"; 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                // Mengambil data murni dari database
                String nilaiUkuran = rs.getString("ukuran"); 
                String nilaiSatuan = rs.getString("satuan");

                // Mencegah error tulisan "null" jika ukuran belum diisi
                if (nilaiUkuran == null) nilaiUkuran = "0";
                if (nilaiSatuan == null) nilaiSatuan = "";

                // Menggabungkan angka dan teks
                String ukuranLengkap = nilaiUkuran + " " + nilaiSatuan; 

                model.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori_barang"),
                    ukuranLengkap, // Masukkan variabel gabungan ke sini
                    rs.getString("harga_satuan"),
                    rs.getString("stok")
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
            // Jika sorter belum diinisialisasi (misal data gagal dimuat), reload data dulu
            tampilData();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_ukuran = new javax.swing.JTextField();
        cb_satuan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JButton();

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
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        jLabel1.setText("Kategori Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Harga Satuan");

        jLabel4.setText("Stok");

        jLabel5.setText("Kelola Data Sembako");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beras", "Minyak Goreng", "Gula", "Bumbu", "Sabun" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButton1.setText("Simpan");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jButton2.setText("Clear");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Update");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Delete");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel7.setText("Ukuran & Satuan");

        txt_ukuran.addActionListener(this::txt_ukuranActionPerformed);

        cb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gram", "Kg", "Liter", "Pcs", "Dus", "Karung" }));

        jLabel6.setText("Cari");

        txtCari.addActionListener(this::txtCariActionPerformed);

        btn_Cari.setText("Cari");
        btn_Cari.addActionListener(this::btn_CariActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_satuan, 0, 201, Short.MAX_VALUE))
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))
                                    .addComponent(txtCari))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(btn_Cari))))))
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cari))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // Mendapatkan baris yang diklik
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            // Indeks bergeser karena kolom 3 sekarang diisi "Ukuran & Satuan"
            jTextField1.setText(jTable1.getValueAt(baris, 1).toString()); // Nama
            jComboBox1.setSelectedItem(jTable1.getValueAt(baris, 2).toString()); // Kategori

            // Kolom 3 adalah gabungan ukuran & satuan, kita lewati dulu pengisiannya ke form
            jTextField2.setText(jTable1.getValueAt(baris, 4).toString()); // Harga Satuan (Sekarang di indeks 4)
            jTextField3.setText(jTable1.getValueAt(baris, 5).toString()); // Stok (Sekarang di indeks 5)
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //save
        try {
            Connection conn = koneksi.getConnection();

            String sql = "INSERT INTO barang (nama_barang, kategori_barang, ukuran, satuan, harga_satuan, stok) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);

            // NAMA VARIABEL SUDAH DISESUAIKAN DENGAN DESAIN JFRAME-MU
            stat.setString(1, jTextField1.getText());
            stat.setString(2, jComboBox1.getSelectedItem().toString());
            stat.setString(3, txt_ukuran.getText());
            stat.setString(4, cb_satuan.getSelectedItem().toString());
            stat.setString(5, jTextField2.getText());
            stat.setString(6, jTextField3.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");

            tampilData(); // Refresh tabel

            // (Opsional) Mengosongkan form otomatis setelah berhasil simpan
            jTextField1.setText("");
            jComboBox1.setSelectedIndex(0);
            txt_ukuran.setText("");
            cb_satuan.setSelectedIndex(0);
            jTextField2.setText("");
            jTextField3.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTable1.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            String id = jTable1.getValueAt(baris, 0).toString();
            try {
                String sql = "UPDATE Barang SET nama_barang='" + jTextField1.getText() +
                "', kategori_barang='" + jComboBox1.getSelectedItem() +
                "', harga_satuan='" + jTextField2.getText() +
                "', stok='" + jTextField3.getText() +
                "' WHERE id_barang='" + id + "'";

                // BARIS YANG DIPERBAIKI
                Connection conn = koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

                tampilData();
                jTextField1.setText("");
                jComboBox1.setSelectedIndex(0);
                jTextField2.setText("");
                jTextField3.setText("");

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Perubahan Gagal: " + e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih data di tabel terlebih dahulu");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            String id = jTable1.getValueAt(baris, 0).toString();
            try {
                String sql = "DELETE FROM Barang WHERE id_barang='" + id + "'";

                // BARIS YANG DIPERBAIKI
                Connection conn = koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                tampilData();
                jTextField1.setText("");
                jComboBox1.setSelectedIndex(0);
                jTextField2.setText("");
                jTextField3.setText("");

            } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus Barang!\nBarang ini masih memiliki riwayat Transaksi.");
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hapus Data Gagal: " + e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih data di tabel terlebih dahulu");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_ukuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ukuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ukuranActionPerformed

    private void btn_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CariActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_btn_CariActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cari;
    private javax.swing.JComboBox<String> cb_satuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txt_ukuran;
    // End of variables declaration//GEN-END:variables
}
