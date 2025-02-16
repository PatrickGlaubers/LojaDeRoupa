
package br.sistemalojaroupas.view.stock;


import br.sistemalojaroupas.view.util.ComboBoxRenderer;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Insert_Product extends javax.swing.JDialog {

    
    public Insert_Product(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        pnl_background.setBackground(new Color(0,0,0,0));
        cb_size.setRenderer(new ComboBoxRenderer());
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        pnl_background = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_color = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_purchasePrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_salePrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        cb_size = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_category = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JLabel();
        bnt_save = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inserir produto");
        pnl_background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 610, 40));

        jLabel10.setBackground(new java.awt.Color(59, 44, 150));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Código:");
        jLabel10.setOpaque(true);
        pnl_background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 110, 30));

        txt_cod.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_cod.setForeground(new java.awt.Color(255, 255, 255));
        txt_cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cod.setText("23");
        txt_cod.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_cod.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_cod.setOpaque(false);
        pnl_background.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 100, 30));

        jButton1.setBackground(new java.awt.Color(169, 69, 165));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));         jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pesquisar");
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 120, 30));

        jLabel8.setBackground(new java.awt.Color(59, 44, 150));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Descrição:");
        jLabel8.setOpaque(true);
        pnl_background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 30));

        txt_description.setEditable(false);
        txt_description.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_description.setForeground(new java.awt.Color(255, 255, 255));
        txt_description.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_description.setText("Camisa gola v");
        txt_description.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_description.setOpaque(false);
        pnl_background.add(txt_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 180, 30));

        jLabel9.setBackground(new java.awt.Color(59, 44, 150));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cor:");
        jLabel9.setOpaque(true);
        pnl_background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, 30));

        txt_color.setEditable(false);
        txt_color.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_color.setForeground(new java.awt.Color(255, 255, 255));
        txt_color.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_color.setText("Vermelho escuro");
        txt_color.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_color.setOpaque(false);
        pnl_background.add(txt_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 180, 30));

        jLabel4.setBackground(new java.awt.Color(59, 44, 150));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("P. de custo:");
        jLabel4.setOpaque(true);
        pnl_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 110, 30));

        txt_purchasePrice.setEditable(false);
        txt_purchasePrice.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_purchasePrice.setForeground(new java.awt.Color(255, 255, 255));
        txt_purchasePrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_purchasePrice.setText("100");
        txt_purchasePrice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_purchasePrice.setOpaque(false);
        pnl_background.add(txt_purchasePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 70, 30));

        jLabel7.setBackground(new java.awt.Color(59, 44, 150));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("P. de venda:");
        jLabel7.setOpaque(true);
        pnl_background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 110, 30));

        txt_salePrice.setEditable(false);
        txt_salePrice.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_salePrice.setForeground(new java.awt.Color(255, 255, 255));
        txt_salePrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_salePrice.setText("150");
        txt_salePrice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_salePrice.setOpaque(false);
        pnl_background.add(txt_salePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 70, 30));

        jLabel5.setBackground(new java.awt.Color(59, 44, 150));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Qtd.:");
        jLabel5.setOpaque(true);
        pnl_background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 50, 30));

        txt_amount.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_amount.setForeground(new java.awt.Color(255, 255, 255));
        txt_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_amount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_amount.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_amount.setOpaque(false);
        pnl_background.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 60, 30));

        cb_size.setBackground(new java.awt.Color(108, 81, 233));
        cb_size.setForeground(new java.awt.Color(255, 255, 255));
        cb_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "PP", "P", "M", "G", "GG" }));
        pnl_background.add(cb_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 90, 30));

        jLabel6.setBackground(new java.awt.Color(59, 44, 150));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tamanho:");
        jLabel6.setOpaque(true);
        pnl_background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 110, 30));

        jLabel3.setBackground(new java.awt.Color(59, 44, 150));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoria:");
        jLabel3.setOpaque(true);
        pnl_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 30));

        txt_category.setEditable(false);
        txt_category.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_category.setForeground(new java.awt.Color(255, 255, 255));
        txt_category.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_category.setText("Camisa");
        txt_category.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_category.setOpaque(false);
        pnl_background.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 90, 30));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));         btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
        });
        pnl_background.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));         bnt_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bnt_saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bnt_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bnt_saveMouseExited(evt);
            }
        });
        pnl_background.add(bnt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tela_cadastro_dark.png")));         pnl_background.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        getContentPane().add(pnl_background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {                 btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelar.png")));
    }
    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {                btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));
    }
    private void bnt_saveMouseClicked(java.awt.event.MouseEvent evt) {        if("".equals(txt_amount.getText()) || cb_size.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "É necessário informar o TAMANHO e QUANTIDADE do produto.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }else{
                        txt_cod.setText("");
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void bnt_saveMouseEntered(java.awt.event.MouseEvent evt) {                 bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvar.png")));
    }
    private void bnt_saveMouseExited(java.awt.event.MouseEvent evt) {               bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));
    }
    
    public static void main(String args[]) {
        
                
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Insert_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Insert_Product dialog = new Insert_Product(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

        private javax.swing.JLabel background;
    private javax.swing.JLabel bnt_save;
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JComboBox<String> cb_size;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnl_background;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_purchasePrice;
    private javax.swing.JTextField txt_salePrice;
    }
