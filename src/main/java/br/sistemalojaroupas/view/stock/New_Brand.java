
package br.sistemalojaroupas.view.stock;

import br.sistemalojaroupas.db.DBException;
import br.sistemalojaroupas.model.dao.BrandDao;
import br.sistemalojaroupas.model.entities.Brand;
import br.sistemalojaroupas.view.util.Utils;
import javax.swing.JOptionPane;


public class New_Brand extends javax.swing.JDialog {

    
    private java.awt.Dialog parent;
    
    public New_Brand(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        this.setBackground(new java.awt.Color(0,0,0,0));
        jPanel1.setBackground(new java.awt.Color(0,0,0,0));
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_newBrand = new javax.swing.JTextField();
        btn_close = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));         jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Nova marca:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        txt_newBrand.setBackground(new java.awt.Color(108, 81, 233));
        txt_newBrand.setFont(new java.awt.Font("Tahoma", 1, 12));         txt_newBrand.setForeground(new java.awt.Color(0, 0, 51));
        txt_newBrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_newBrand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 51)));
        txt_newBrand.setOpaque(false);
        txt_newBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_newBrandKeyPressed(evt);
            }
        });
        jPanel1.add(txt_newBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 110, 30));

        btn_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_X_Preto.png")));         btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 7, 20, 20));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));         btn_save.setToolTipText("");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_saveMouseExited(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundoTelaRoxa.png")));         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 120));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {        
        if (!txt_newBrand.getText().equals("")){
            Brand brand = new Brand(txt_newBrand.getText());
            try {
                BrandDao.insert(brand);
                
                JOptionPane.showMessageDialog(null, "Marca salva!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                if (parent instanceof Register_And_Edit_Products) {
                    Utils.updateComboBox(BrandDao.findAll(),
                            ((Register_And_Edit_Products)parent).getCbBrand());
                }
                
            } catch (DBException e) {
                JOptionPane.showMessageDialog(null, "Essa marca já está cadastrada.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Você deve preencher o campo para salvar.", "Atenção",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {                btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvar.png")));
    }
    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {                btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));
    }
    private void txt_newBrandKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_saveMouseClicked(null);
        }
    }

        private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_newBrand;
    }
