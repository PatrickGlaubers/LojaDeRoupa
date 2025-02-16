
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.services.SaleService;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class Payment_MoneyAndCredit extends javax.swing.JDialog {

    private Sale sale;
    private Double totalValue;
    private Double moneyToReceive;
    private New_Sale saleWindow;
    
    public Payment_MoneyAndCredit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        saleWindow = ((Payment)parent).getSaleWindow();
        sale = saleWindow.getSale();
        
        txtSalePrice.setText(String.format("R$ %.2f", sale.getTotal()));
        btnFinish.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        txtSalePrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRemainingValue = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAmountReceived = new javax.swing.JFormattedTextField();
        txtInstallments = new javax.swing.JFormattedTextField();
        txtMoneyValue = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel3.setForeground(new java.awt.Color(0, 176, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento em Crédito");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 400, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor recebido :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor da venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Troco :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 170, 30));

        txtChange.setEditable(false);
        txtChange.setFont(new java.awt.Font("Tahoma", 0, 14));         txtChange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChangeActionPerformed(evt);
            }
        });
        jPanel1.add(txtChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 120, 30));

        txtSalePrice.setEditable(false);
        txtSalePrice.setFont(new java.awt.Font("Tahoma", 0, 14));         txtSalePrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtSalePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 120, 30));

        jButton1.setBackground(new java.awt.Color(192, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));         jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 150, 40));

        btnContinue.setBackground(new java.awt.Color(108, 81, 233));
        btnContinue.setFont(new java.awt.Font("Tahoma", 0, 14));         btnContinue.setForeground(new java.awt.Color(255, 255, 255));
        btnContinue.setText("Continuar");
        btnContinue.setBorderPainted(false);
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 150, 40));

        btnFinish.setBackground(new java.awt.Color(0, 176, 80));
        btnFinish.setFont(new java.awt.Font("Tahoma", 0, 14));         btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finalizar Venda");
        btnFinish.setBorderPainted(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 150, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 176, 240));
        jSeparator1.setForeground(new java.awt.Color(0, 176, 240));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 10, 330));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel7.setForeground(new java.awt.Color(0, 176, 240));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pagamento em Dinheiro");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor restante :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 170, 30));

        txtRemainingValue.setEditable(false);
        txtRemainingValue.setFont(new java.awt.Font("Tahoma", 0, 14));         txtRemainingValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtRemainingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Quantidade de parcelas :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Valor a ser cobrado :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 30));

        txtAmountReceived.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtAmountReceived.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmountReceived.setToolTipText("");
        txtAmountReceived.setFont(new java.awt.Font("Tahoma", 0, 14));         txtAmountReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountReceivedActionPerformed(evt);
            }
        });
        txtAmountReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountReceivedKeyReleased(evt);
            }
        });
        jPanel1.add(txtAmountReceived, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 120, 30));

        txtInstallments.setEditable(false);
        txtInstallments.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtInstallments.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInstallments.setText("1");
        txtInstallments.setFont(new java.awt.Font("Tahoma", 0, 14));         jPanel1.add(txtInstallments, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 120, 30));

        txtMoneyValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtMoneyValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMoneyValue.setFont(new java.awt.Font("Tahoma", 0, 14));         jPanel1.add(txtMoneyValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_Pagamento_CreditoComDinheiro.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        this.dispose();
    }
    private void txtChangeActionPerformed(java.awt.event.ActionEvent evt) {            }
    private void txtAmountReceivedActionPerformed(java.awt.event.ActionEvent evt) {            }
    private void txtAmountReceivedKeyReleased(java.awt.event.KeyEvent evt) {        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double amountReceived = Utils.tryParseToDouble(txtAmountReceived.getText().replace(',', '.'));
            moneyToReceive = Utils.tryParseToDouble(txtMoneyValue.getText().replace(',', '.'));
            Double change = amountReceived - moneyToReceive;
            
            if (change < 0) {
                change = null;
                moneyToReceive = null;
                JOptionPane.showMessageDialog(this, "O valor recebido não pode ser menor que o valor cobrado", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            txtChange.setText(String.format("%.2f", change));
        }
    }
    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {        
        if (moneyToReceive == null) {
            JOptionPane.showMessageDialog(this, "Digite o valor em dinheiro antes de continuar", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        totalValue = sale.getTotal() - moneyToReceive;
        txtRemainingValue.setText(String.format("R$ %.2f", totalValue));
        
        txtInstallments.setEditable(true);
        btnFinish.setEnabled(true);
    }
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {        Integer installments = Utils.tryParseToInt(txtInstallments.getText());
        if (installments < 1) {
            JOptionPane.showMessageDialog(this, "Número inválido de parcelas.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        sale.setInstallments(installments);
        
        saleWindow.finishSale();
        this.dispose();
    }
        private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtAmountReceived;
    private javax.swing.JTextField txtChange;
    private javax.swing.JFormattedTextField txtInstallments;
    private javax.swing.JFormattedTextField txtMoneyValue;
    private javax.swing.JTextField txtRemainingValue;
    private javax.swing.JTextField txtSalePrice;
    }
