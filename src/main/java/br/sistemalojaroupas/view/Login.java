
package br.sistemalojaroupas.view;

import br.sistemalojaroupas.db.DB;
import br.sistemalojaroupas.model.dao.UserDao;
import br.sistemalojaroupas.model.dao.exceptions.LoginException;
import br.sistemalojaroupas.model.entities.User;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    private static User user;
    
    public Login() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        pnl_background.setBackground(new Color(0,0,0,0));
        
        DB.start();
    }
    
    public static User getLoggedUser() {
        return user;
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        pnl_background = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        btn_login = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_powerOff.png")));         btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        pnl_background.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_login.png")));         btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_loginMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_loginMouseReleased(evt);
            }
        });
        pnl_background.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel3.setForeground(new java.awt.Color(109, 81, 232));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Acessar");
        pnl_background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 100, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bem vindo ao Sistema.");
        pnl_background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txt_user.setFont(new java.awt.Font("Tahoma", 0, 16));         txt_user.setBorder(null);
        txt_user.setOpaque(false);
        pnl_background.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 212, 290, 30));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14));         txt_password.setBorder(null);
        txt_password.setOpaque(false);
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        pnl_background.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 309, 300, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/telaLogin.png")));         pnl_background.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnl_background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {        int op;
        op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op == 0){
            System.exit(0);
        }
    }
    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {            }
    private void btn_loginMouseEntered(java.awt.event.MouseEvent evt) {        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_loginEscuro.png")));
    }
    private void btn_loginMouseExited(java.awt.event.MouseEvent evt) {        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_login.png")));
    }   
    private void btn_loginMouseReleased(java.awt.event.MouseEvent evt) {                try {
            user = UserDao.verify(txt_user.getText(), new String(txt_password.getPassword()));
            new Home().main(null);
            this.dispose();
        }
        catch (LoginException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Falha de Autenticação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_loginMouseReleased(null);
        }
    }
    
    public static void main(String args[]) {
        
                
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

        private javax.swing.JLabel Background;
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnl_background;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    }
