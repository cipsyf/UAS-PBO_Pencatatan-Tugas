import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tugas extends javax.swing.JFrame {
    private void load_table() {
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Mata Kuliah");
        model.addColumn("Tanggal Tugas");
        model.addColumn("Deadline");
        model.addColumn("Status");
        model.addColumn("Detail");
        model.addColumn("Prioritas");
        
        //menampilkan data database kedalam tabel
        try {
            String sql = "select * from t_tugas";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new 
Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4) ,res.getString(5),res.getString(6),res.getString(7),res.getString(8)});
            }
            tblTugas.setModel(model);
        } catch(Exception e) {
        }
    }
    
    private void reset(){
        txtNo.setText(null);
        txtNama.setText(null);
        txtDetail.setText(null);
        cbMatkul.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbPrio.setSelectedIndex(0);
        dateTanggal.setDate(null);
        dateDeadline.setDate(null);
        txtNama.requestFocus();
        txtNo.setEnabled(true);
    }
    
    private void matkul(){
        cbMatkul.removeAllItems();
        try {
            String sql = "SELECT singkatan FROM t_matkul";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                cbMatkul.addItem(res.getString("singkatan"));
            }
        }catch(Exception e) {
        }
    }
    /**
     * Creates new form PencatatanTugas
     */
    public Tugas() {
        initComponents();
        load_table();
        matkul();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTugas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btTambah = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        cbMatkul = new javax.swing.JComboBox<>();
        dateTanggal = new com.toedter.calendar.JDateChooser();
        dateDeadline = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        cbStatus = new javax.swing.JComboBox<>();
        cbPrio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        miDashboard = new javax.swing.JMenuItem();
        miLogout = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        miMatkul = new javax.swing.JMenuItem();

        jLabel8.setText("jLabel8");

        jFormattedTextField1.setText("jFormattedTextField1");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("TAMBAH TUGAS");

        jLabel2.setText("Nama Tugas    :");

        jLabel3.setText("Mata Kuliah      :");

        jLabel4.setText("Tanggal Tugas :");

        jLabel5.setText("Deadline Tugas :");

        jLabel6.setText("Status Tugas    :");

        tblTugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblTugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTugas);

        jLabel7.setText("Prioritas Tugas  :");

        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btReset.setText("Clear");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        jLabel9.setText("Detail Tugas    :");

        txtDetail.setColumns(20);
        txtDetail.setRows(5);
        jScrollPane2.setViewportView(txtDetail);

        cbMatkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PIlih--", "RPL", "PBO", "PEMWEB", "STRUKTUR DATA", "ADM JARINGAN", "ADM BASISDATA", "PPB", "DPSIKC" }));

        dateTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTanggalPropertyChange(evt);
            }
        });

        dateDeadline.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDeadlinePropertyChange(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Selesai", "Belum Selesai", "Sedang Dikerjakan" }));

        cbPrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Waktu Dekat", "Masih Lama" }));

        jLabel10.setText("No                     :");

        jMenu5.setText("Menu");

        miDashboard.setText("Dashboard");
        miDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDashboardActionPerformed(evt);
            }
        });
        jMenu5.add(miDashboard);

        miLogout.setText("Logout");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        jMenu5.add(miLogout);

        jMenuBar2.add(jMenu5);

        jMenu3.setText("Tambah");

        jMenuItem3.setText("List Tugas");
        jMenu3.add(jMenuItem3);

        miMatkul.setText("List Mata Kuliah");
        miMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMatkulActionPerformed(evt);
            }
        });
        jMenu3.add(miMatkul);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btReset)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btHapus)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btEdit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btTambah))
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel10))
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNo, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                .addComponent(dateTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(15, 15, 15)
                                                            .addComponent(jLabel5))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel3)))
                                                    .addGap(18, 18, 18))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(6, 6, 6)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dateDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbPrio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(78, 78, 78)))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addComponent(dateTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(cbPrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btTambah)
                            .addComponent(btEdit)
                            .addComponent(btHapus)
                            .addComponent(btReset)))
                    .addComponent(dateDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String deadline;
    private void dateDeadlinePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDeadlinePropertyChange
        // TODO add your handling code here:
        if (dateDeadline.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            deadline = format.format(dateDeadline.getDate());
        }
    }//GEN-LAST:event_dateDeadlinePropertyChange

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btResetActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM t_tugas WHERE no ='"+txtNo.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        reset();
    }//GEN-LAST:event_btHapusActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE t_tugas SET nama = '"+txtNama.getText()+
                    "', matkul = '"+cbMatkul.getSelectedItem()+
                    "', tanggal_tugas = '"+tanggal_tugas+
                    "', deadline = '"+deadline+
                    "', status = '"+cbStatus.getSelectedItem()+
                    "', detail = '"+txtDetail.getText()+
                    "', prioritas = '"+cbPrio.getSelectedItem()+
                    "' WHERE no = '"+txtNo.getText()+"'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        load_table();
        reset();
    }//GEN-LAST:event_btEditActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO t_tugas VALUES('"+txtNo.getText()+
                    "','"+txtNama.getText()+
                    "','"+cbMatkul.getSelectedItem()+
                    "','"+tanggal_tugas+
                    "','"+deadline+
                    "','"+cbStatus.getSelectedItem()+
                    "','"+txtDetail.getText()+
                    "','"+cbPrio.getSelectedItem()+"')";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table();
            reset();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btTambahActionPerformed

    private void tblTugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTugasMouseClicked
        // TODO add your handling code here:
        int baris = tblTugas.rowAtPoint(evt.getPoint());
    
        if (baris >= 0 && baris < tblTugas.getRowCount()) {
            String no = tblTugas.getValueAt(baris, 0).toString();
            String nama = tblTugas.getValueAt(baris, 1).toString();
            String matkul = tblTugas.getValueAt(baris, 2).toString();
            String tanggal_tugas = tblTugas.getValueAt(baris, 3).toString();
            String deadline = tblTugas.getValueAt(baris, 4).toString();
            String status = tblTugas.getValueAt(baris, 5).toString();
            String prioritas = tblTugas.getValueAt(baris, 7).toString();
            
            // Assuming 'detail' is in the 6th column, adjust if needed
            String detail = tblTugas.getValueAt(baris, 6).toString(); 
    
            txtNo.setText(no);
            txtNama.setText(nama);
            
            cbMatkul.setSelectedItem(matkul);
    
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date tugas = dateFormat.parse(tanggal_tugas);
                java.util.Date dl = dateFormat.parse(deadline);

                dateTanggal.setDate(tugas);
                dateDeadline.setDate(dl);
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            cbStatus.setSelectedItem(status);
            txtDetail.setText(detail);
            cbPrio.setSelectedItem(prioritas);
            txtNo.setEnabled(false);
        }
    }//GEN-LAST:event_tblTugasMouseClicked

    public String tanggal_tugas;
    private void dateTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTanggalPropertyChange
        // TODO add your handling code here:
        if (dateTanggal.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tanggal_tugas = format.format(dateTanggal.getDate());
        }
    }//GEN-LAST:event_dateTanggalPropertyChange

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
        JOptionPane.showMessageDialog(this, "Berhasil logout");
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard();
        this.setVisible(false);
        dashboard.setVisible(true);
    }//GEN-LAST:event_miDashboardActionPerformed

    private void miMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMatkulActionPerformed
        // TODO add your handling code here:
        Matkul matkul = new Matkul();
        this.setVisible(false);
        matkul.setVisible(true);
    }//GEN-LAST:event_miMatkulActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Tugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMatkul;
    private javax.swing.JComboBox<String> cbPrio;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser dateDeadline;
    private com.toedter.calendar.JDateChooser dateTanggal;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem miDashboard;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miMatkul;
    private javax.swing.JTable tblTugas;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNo;
    // End of variables declaration//GEN-END:variables
}
