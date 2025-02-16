
package br.sistemalojaroupas.view.stock;

import br.sistemalojaroupas.db.DBException;
import br.sistemalojaroupas.model.dao.ColorDao;
import br.sistemalojaroupas.model.entities.Color;
import br.sistemalojaroupas.view.util.Utils;
import javax.swing.JOptionPane;


public class New_Color extends javax.swing.JDialog {

    
    private java.awt.Dialog parent;
    
    public New_Color(java.awt.Dialog parent, boolean modal) {
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
        txt_newColor = new javax.swing.JTextField();
        btn_close = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));         jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Nova cor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 30));

        txt_newColor.setBackground(new java.awt.Color(108, 81, 233));
        txt_newColor.setFont(new java.awt.Font("Tahoma", 1, 12));         txt_newColor.setForeground(new java.awt.Color(0, 0, 51));
        txt_newColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_newColor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 51)));
        txt_newColor.setOpaque(false);
        txt_newColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_newColorKeyPressed(evt);
            }
        });
        jPanel1.add(txt_newColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 120, 30));

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
        if (!txt_newColor.getText().equals("")){
            Color c = new Color(txt_newColor.getText().toUpperCase());
            try {
                ColorDao.insert(c);
                
                JOptionPane.showMessageDialog(null, "Cor salva!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                if (parent instanceof Register_And_Edit_Products) {
                    Utils.updateComboBox(ColorDao.findAll(),
                            ((Register_And_Edit_Products)parent).getCbColor());
                }
                
            } catch (DBException e) {
                JOptionPane.showMessageDialog(null, "Essa cor já está cadastrada.", 
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
    private void txt_newColorKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_saveMouseClicked(null);
        }
    }

        private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_newColor;
    }
