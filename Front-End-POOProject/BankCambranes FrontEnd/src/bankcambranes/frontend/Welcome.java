
package bankcambranes.frontend;


public class Welcome extends javax.swing.JFrame {

   
    public Welcome() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        Subtittle = new java.awt.Label();
        ScrolPane = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        AccountBtn = new javax.swing.JMenu();
        OutBtn = new javax.swing.JMenuItem();
        TransactionBtn = new javax.swing.JMenu();
        DepositBtn = new javax.swing.JMenuItem();
        TransferBtn = new javax.swing.JMenuItem();
        WithdrawBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(255, 255, 255));

        Image.setIcon(new javax.swing.ImageIcon("D:\\Notas de clase\\POO\\Front-End-POOProject\\bank3.jpg")); // NOI18N
        Image.setMaximumSize(new java.awt.Dimension(307, 167));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Tittle.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Tittle.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Tittle)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tittle)
                .addContainerGap())
        );

        Subtittle.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Subtittle.setText("Welcome!!");

        TextArea.setEditable(false);
        TextArea.setColumns(20);
        TextArea.setRows(5);
        TextArea.setText("Welcome");
        ScrolPane.setViewportView(TextArea);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        AccountBtn.setText("Account");
        AccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountBtnActionPerformed(evt);
            }
        });

        OutBtn.setText("Log out");
        OutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutBtnActionPerformed(evt);
            }
        });
        AccountBtn.add(OutBtn);

        MenuBar.add(AccountBtn);

        TransactionBtn.setText("Transaction");
        TransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionBtnActionPerformed(evt);
            }
        });

        DepositBtn.setText("Deposit");
        DepositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositBtnActionPerformed(evt);
            }
        });
        TransactionBtn.add(DepositBtn);

        TransferBtn.setText("Transfer");
        TransferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferBtnActionPerformed(evt);
            }
        });
        TransactionBtn.add(TransferBtn);

        WithdrawBtn.setText("Withdraw");
        WithdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawBtnActionPerformed(evt);
            }
        });
        TransactionBtn.add(WithdrawBtn);

        MenuBar.add(TransactionBtn);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(Subtittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Subtittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountBtnActionPerformed
        
    }//GEN-LAST:event_AccountBtnActionPerformed

    private void TransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TransactionBtnActionPerformed

    private void DepositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositBtnActionPerformed
        Deposit trans = new Deposit();
        trans.setVisible(true);
        dispose();
    }//GEN-LAST:event_DepositBtnActionPerformed

    private void TransferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferBtnActionPerformed
        Transfer trans = new Transfer();
        trans.setVisible(true);
        dispose();
    }//GEN-LAST:event_TransferBtnActionPerformed

    private void WithdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawBtnActionPerformed
        Withdraw trans = new Withdraw();
        trans.setVisible(true);
        dispose();
    }//GEN-LAST:event_WithdrawBtnActionPerformed

    private void OutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutBtnActionPerformed
       Home out = new Home();
       out.setVisible(true);
       dispose();
    }//GEN-LAST:event_OutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AccountBtn;
    private javax.swing.JMenuItem DepositBtn;
    private javax.swing.JLabel Image;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem OutBtn;
    private javax.swing.JScrollPane ScrolPane;
    private java.awt.Label Subtittle;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel Tittle;
    private javax.swing.JMenu TransactionBtn;
    private javax.swing.JMenuItem TransferBtn;
    private javax.swing.JMenuItem WithdrawBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
