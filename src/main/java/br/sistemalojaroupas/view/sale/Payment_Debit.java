
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import java.awt.Color;


public class Payment_Debit extends javax.swing.JDialog {

    private Sale sale;
    private New_Sale saleWindow;
    
    public Payment_Debit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        saleWindow = ((Payment)parent).getSaleWindow();
        sale = saleWindow.getSale();
        
        txtSaleValue.setText(String.format("R$ %.2f", sale.getTotal()));
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSaleValue = new javax.swing.JTextField();
        btnFinish = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel3.setForeground(new java.awt.Color(0, 176, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento em Débito");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor da venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 170, 30));

        txtSaleValue.setEditable(false);
        txtSaleValue.setFont(new java.awt.Font("Tahoma", 0, 14));         txtSaleValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaleValue.setText("125,00");
        jPanel1.add(txtSaleValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 120, 30));

        btnFinish.setBackground(new java.awt.Color(0, 176, 80));
        btnFinish.setFont(new java.awt.Font("Tahoma", 0, 14));         btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finalizar Venda");
        btnFinish.setBorderPainted(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 150, 40));

        jButton1.setBackground(new java.awt.Color(192, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));         jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_Pagamento_Debito.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        this.dispose();
    }
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {        saleWindow.finishSale();
        this.dispose();
    }

        private javax.swing.JButton btnFinish;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtSaleValue;
    }
