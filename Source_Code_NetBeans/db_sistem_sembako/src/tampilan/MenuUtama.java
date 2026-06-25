package tampilan;

public class MenuUtama extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuUtama.class.getName());

    public MenuUtama() {
        initComponents();
        
        PanelUtama.setLayout(new java.awt.BorderLayout());
        
        btn_barangActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_barang = new javax.swing.JButton();
        btn_pelanggan = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_lihat_data = new javax.swing.JButton();
        PanelUtama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        btn_barang.setText("Data Barang");
        btn_barang.addActionListener(this::btn_barangActionPerformed);

        btn_pelanggan.setText("Data Pelanggan");
        btn_pelanggan.addActionListener(this::btn_pelangganActionPerformed);

        btn_transaksi.setText("Transaksi");
        btn_transaksi.addActionListener(this::btn_transaksiActionPerformed);

        btn_lihat_data.setText("Lihat Data");
        btn_lihat_data.addActionListener(this::btn_lihat_dataActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_lihat_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btn_barang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pelanggan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lihat_data)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        PanelUtama.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelUtamaLayout = new javax.swing.GroupLayout(PanelUtama);
        PanelUtama.setLayout(PanelUtamaLayout);
        PanelUtamaLayout.setHorizontalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelUtamaLayout.setVerticalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(686, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        // TODO add your handling code here:
        PanelUtama.removeAll();
        PanelBarang pBarang = new PanelBarang();
        PanelUtama.add(pBarang, java.awt.BorderLayout.CENTER);
        PanelUtama.revalidate();
        PanelUtama.repaint();
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pelangganActionPerformed
        // TODO add your handling code here:
        PanelUtama.removeAll();
        PanelPelanggan pPelanggan = new PanelPelanggan();
        PanelUtama.add(pPelanggan, java.awt.BorderLayout.CENTER);
        PanelUtama.revalidate();
        PanelUtama.repaint();
    }//GEN-LAST:event_btn_pelangganActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        // TODO add your handling code here:
        PanelUtama.removeAll();
        PanelTransaksi pTransaksi = new PanelTransaksi();
        PanelUtama.add(pTransaksi, java.awt.BorderLayout.CENTER);
        PanelUtama.revalidate();
        PanelUtama.repaint();
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_lihat_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihat_dataActionPerformed
        // TODO add your handling code here:
        // Menghapus isi panel utama saat ini
        PanelUtama.removeAll();
        
        // Memanggil panel Lihat Data
        lihat_data pLihatData = new lihat_data();
        PanelUtama.add(pLihatData, java.awt.BorderLayout.CENTER);
        
        // Menyegarkan tampilan
        PanelUtama.revalidate();
        PanelUtama.repaint();
    }//GEN-LAST:event_btn_lihat_dataActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuUtama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelUtama;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_lihat_data;
    private javax.swing.JButton btn_pelanggan;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
