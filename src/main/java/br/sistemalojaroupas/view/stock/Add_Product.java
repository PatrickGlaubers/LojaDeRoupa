
package br.sistemalojaroupas.view.stock;

import br.sistemalojaroupas.model.dao.ProductDao;
import br.sistemalojaroupas.model.entities.Product;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Add_Product extends javax.swing.JDialog {

    private Product product;
    
    public Add_Product(java.awt.Frame parent, boolean modal, Product product) {
        super(parent, modal);
        initComponents();
        jPanel1.setBackground(new Color(0,0,0,0));
        this.product = product;
        
        txt_ProductName.setText(product.getDescription());
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Apply = new javax.swing.JLabel();
        btn_Cancel = new javax.swing.JLabel();
        txt_ProductName = new javax.swing.JLabel();
        spinner_Amount = new javax.swing.JSpinner();
        Filter_BackgroundSale = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10));         jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Inserir qtd. :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 26));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10));         jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Produto : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_aplicar.png")));         btn_Apply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ApplyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ApplyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ApplyMouseExited(evt);
            }
        });
        jPanel1.add(btn_Apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 30));

        btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_cancelar.png")));         btn_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CancelMouseExited(evt);
            }
        });
        jPanel1.add(btn_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        txt_ProductName.setFont(new java.awt.Font("Tahoma", 1, 10));         txt_ProductName.setForeground(new java.awt.Color(102, 0, 153));
        txt_ProductName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ProductName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel1.add(txt_ProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 110, 20));

        spinner_Amount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(spinner_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 70, 26));

        Filter_BackgroundSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filter_BackgroundSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_FiltroAplicado_Purple.png")));         Filter_BackgroundSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Filter_BackgroundSaleMouseClicked(evt);
            }
        });
        jPanel1.add(Filter_BackgroundSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 140));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void Filter_BackgroundSaleMouseClicked(java.awt.event.MouseEvent evt) {            }
    private void btn_CancelMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btn_CancelMouseEntered(java.awt.event.MouseEvent evt) {     btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_cancelarEscuro.png")));
    }
    private void btn_CancelMouseExited(java.awt.event.MouseEvent evt) {     btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_cancelar.png")));
    }
    private void btn_ApplyMouseClicked(java.awt.event.MouseEvent evt) {        try {
            spinner_Amount.commitEdit();
        } catch (ParseException ex) {
            spinner_Amount.setValue(0);
        }
        
        Integer value = (Integer) spinner_Amount.getValue();
        if (value == 0) {
            JOptionPane.showMessageDialog(this, "O valor deve ser maior do que zero para adicionar ao produto.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        product.setQuantity(product.getQuantity() + value);
        ProductDao.update(product);
        
        JOptionPane.showMessageDialog(this, "Quantidade adicionada com sucesso! Nova quantidade do produto: " + product.getQuantity(),
                "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
    private void btn_ApplyMouseEntered(java.awt.event.MouseEvent evt) {      btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_aplicarEscuro.png")));
    }
    private void btn_ApplyMouseExited(java.awt.event.MouseEvent evt) {      btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_aplicar.png")));
    }

        private javax.swing.JLabel Filter_BackgroundSale;
    private javax.swing.JLabel btn_Apply;
    private javax.swing.JLabel btn_Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinner_Amount;
    private javax.swing.JLabel txt_ProductName;
    }
