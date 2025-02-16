
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import java.awt.Color;


public class Payment extends javax.swing.JFrame {

    private New_Sale saleWindow;
    
    public Payment(New_Sale saleWindow) {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        
        this.saleWindow = saleWindow;
    }

    public New_Sale getSaleWindow() {
        return saleWindow;
    }
    
    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btDebit = new javax.swing.JButton();
        btCredit = new javax.swing.JButton();
        btCreditAndMoney = new javax.swing.JButton();
        btMoney = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel2.setForeground(new java.awt.Color(0, 176, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Forma de Pagamento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, 30));

        btDebit.setBackground(new java.awt.Color(108, 81, 233));
        btDebit.setFont(new java.awt.Font("Tahoma", 0, 14));         btDebit.setForeground(new java.awt.Color(255, 255, 255));
        btDebit.setText("Débito");
        btDebit.setBorderPainted(false);
        btDebit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDebitActionPerformed(evt);
            }
        });
        jPanel1.add(btDebit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 200, 50));

        btCredit.setBackground(new java.awt.Color(108, 81, 233));
        btCredit.setFont(new java.awt.Font("Tahoma", 0, 14));         btCredit.setForeground(new java.awt.Color(255, 255, 255));
        btCredit.setText("Crédito");
        btCredit.setBorderPainted(false);
        btCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreditActionPerformed(evt);
            }
        });
        jPanel1.add(btCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 200, 50));

        btCreditAndMoney.setBackground(new java.awt.Color(108, 81, 233));
        btCreditAndMoney.setFont(new java.awt.Font("Tahoma", 0, 14));         btCreditAndMoney.setForeground(new java.awt.Color(255, 255, 255));
        btCreditAndMoney.setText("Dinheiro + Crédito");
        btCreditAndMoney.setBorderPainted(false);
        btCreditAndMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreditAndMoneyActionPerformed(evt);
            }
        });
        jPanel1.add(btCreditAndMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 200, 50));

        btMoney.setBackground(new java.awt.Color(108, 81, 233));
        btMoney.setFont(new java.awt.Font("Tahoma", 0, 14));         btMoney.setForeground(new java.awt.Color(255, 255, 255));
        btMoney.setText("Dinheiro");
        btMoney.setBorderPainted(false);
        btMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoneyActionPerformed(evt);
            }
        });
        jPanel1.add(btMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 200, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png")));         jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_Pagamento.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void btMoneyActionPerformed(java.awt.event.ActionEvent evt) {        saleWindow.getSale().setPayment(Sale.MONEY);
        
        this.dispose();
        new Payment_Money(this, true).setVisible(true);
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btDebitActionPerformed(java.awt.event.ActionEvent evt) {        saleWindow.getSale().setPayment(Sale.DEBIT);
        
        this.dispose();
        new Payment_Debit(this, true).setVisible(true);
    }
    private void btCreditActionPerformed(java.awt.event.ActionEvent evt) {        saleWindow.getSale().setPayment(Sale.CREDIT);
        
        this.dispose();
        new Payment_Credit(this, true).setVisible(true);
    }
    private void btCreditAndMoneyActionPerformed(java.awt.event.ActionEvent evt) {        saleWindow.getSale().setPayment(Sale.MONEY_CREDIT);
        
        this.dispose();
        new Payment_MoneyAndCredit(this, true).setVisible(true);
    }

        private javax.swing.JButton btCredit;
    private javax.swing.JButton btCreditAndMoney;
    private javax.swing.JButton btDebit;
    private javax.swing.JButton btMoney;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    }
