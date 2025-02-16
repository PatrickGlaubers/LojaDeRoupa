
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Payment_Credit extends javax.swing.JDialog {

    private Sale sale;
    private New_Sale saleWindow;
    
    public Payment_Credit(java.awt.Frame parent, boolean modal) {
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
        txtInstallments = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSaleValue = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtInstallments.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtInstallments.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInstallments.setText("1");
        jPanel1.add(txtInstallments, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 122, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel3.setForeground(new java.awt.Color(0, 176, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento em Crédito");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Quantidade de parcelas :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15));         jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Valor da venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 170, 30));

        txtSaleValue.setEditable(false);
        txtSaleValue.setFont(new java.awt.Font("Tahoma", 0, 14));         txtSaleValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtSaleValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 120, 30));

        jButton1.setBackground(new java.awt.Color(192, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));         jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, 40));

        btnFinish.setBackground(new java.awt.Color(0, 176, 80));
        btnFinish.setFont(new java.awt.Font("Tahoma", 0, 14));         btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finalizar Venda");
        btnFinish.setBorderPainted(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_Pagamento_Credito.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        this.dispose();
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

        private javax.swing.JButton btnFinish;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtInstallments;
    private javax.swing.JTextField txtSaleValue;
    }
