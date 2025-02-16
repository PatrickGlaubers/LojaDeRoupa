
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.services.SaleService;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Payment_Money extends javax.swing.JDialog {

    private New_Sale saleWindow;
    private Sale sale;
    
    public Payment_Money(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        saleWindow = ((Payment)parent).getSaleWindow();
        sale = saleWindow.getSale();
        txtAmountReceived.requestFocusInWindow();
        
        txtSalePrice.setText(String.format("%.2f", sale.getTotal()));
        btConfirm.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAmountReceived = new javax.swing.JFormattedTextField();
        txtChange = new javax.swing.JTextField();
        txtSalePrice = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btCancel = new javax.swing.JButton();
        btConfirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel3.setForeground(new java.awt.Color(0, 176, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento em Dinheiro");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor recebido :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor da venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Troco :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 30));

        txtAmountReceived.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtAmountReceived.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmountReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountReceivedKeyPressed(evt);
            }
        });
        jPanel1.add(txtAmountReceived, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 122, 120, 30));

        txtChange.setEditable(false);
        txtChange.setFont(new java.awt.Font("Tahoma", 0, 14));         txtChange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 120, 30));

        txtSalePrice.setEditable(false);
        txtSalePrice.setFont(new java.awt.Font("Tahoma", 0, 14));         txtSalePrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtSalePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 120, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        btCancel.setBackground(new java.awt.Color(192, 0, 0));
        btCancel.setFont(new java.awt.Font("Tahoma", 0, 14));         btCancel.setForeground(new java.awt.Color(255, 255, 255));
        btCancel.setText("Cancelar");
        btCancel.setBorderPainted(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 150, 40));

        btConfirm.setBackground(new java.awt.Color(0, 176, 80));
        btConfirm.setFont(new java.awt.Font("Tahoma", 0, 14));         btConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btConfirm.setText("Finalizar Venda");
        btConfirm.setBorderPainted(false);
        btConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(btConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_Pagamento_Dinheiro.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {        this.dispose();
    }
    private void btConfirmActionPerformed(java.awt.event.ActionEvent evt) {        if (txtAmountReceived.getText().equals("") || txtAmountReceived.getText().equals("0,00")) {
            JOptionPane.showMessageDialog(this, "Digite um valor para poder finalizar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        saleWindow.finishSale();
        this.dispose();
    }
    private void txtAmountReceivedKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            Double amountReceived = Utils.tryParseToDouble(txtAmountReceived.getText().replace(',', '.'));
            Double change = amountReceived - sale.getTotal();
            
            if (change < 0) {
                JOptionPane.showMessageDialog(this, "O valor recebido não pode ser menor que o valor cobrado", "Erro", JOptionPane.ERROR_MESSAGE);
                txtAmountReceived.setText("0,00");
                btConfirm.setEnabled(false);
                return;
            }
            
            txtChange.setText(String.format("%.2f", change));
            btConfirm.setEnabled(true);
        }
    }

        private javax.swing.JButton btCancel;
    private javax.swing.JButton btConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtAmountReceived;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtSalePrice;
    }
