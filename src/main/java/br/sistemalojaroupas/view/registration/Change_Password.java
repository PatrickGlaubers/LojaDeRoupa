
package br.sistemalojaroupas.view.registration;

import br.sistemalojaroupas.model.dao.UserDao;
import br.sistemalojaroupas.model.entities.User;
import br.sistemalojaroupas.view.Login;
import javax.swing.JOptionPane;


public class Change_Password extends javax.swing.JDialog {
    private User user = Login.getLoggedUser();
    
    public Change_Password(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public boolean isAllFieldsFilled() {
        String newPwd = new String(txtNewPassword.getPassword());
        String oldPwd = new String(txtOldPassword.getPassword());
        String newPwdConfirm = new String(txtNewPasswordConfirm.getPassword());
        
        if (newPwd == null || newPwd.equals("")) {
            return false;
        }
        if (oldPwd == null || oldPwd.equals("")) {
            return false;
        }
        if (newPwdConfirm == null || newPwdConfirm.equals("")) {
            return false;
        }
        return true;
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        ChangePassword = new javax.swing.JPanel();
        PasswordCurrent = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ChangePwTitle = new javax.swing.JLabel();
        bnt_save = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        PasswordNew = new javax.swing.JLabel();
        PasswordCheck = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        txtNewPasswordConfirm = new javax.swing.JPasswordField();
        txtOldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        ChangePassword.setBackground(new java.awt.Color(0, 0, 51));
        ChangePassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PasswordCurrent.setBackground(new java.awt.Color(59, 44, 150));
        PasswordCurrent.setFont(new java.awt.Font("Tahoma", 0, 14));         PasswordCurrent.setForeground(new java.awt.Color(255, 255, 255));
        PasswordCurrent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordCurrent.setText("Senha atual:");
        PasswordCurrent.setOpaque(true);
        ChangePassword.add(PasswordCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 30));

        jPanel2.setBackground(new java.awt.Color(108, 81, 233));

        ChangePwTitle.setFont(new java.awt.Font("Tahoma", 1, 16));         ChangePwTitle.setForeground(new java.awt.Color(0, 0, 51));
        ChangePwTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChangePwTitle.setText("Alterar senha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChangePwTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChangePwTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        ChangePassword.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 40));

        bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));         bnt_save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bnt_save.addMouseListener(new java.awt.event.MouseAdapter() {
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
        ChangePassword.add(bnt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));         btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
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
        ChangePassword.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        PasswordNew.setBackground(new java.awt.Color(59, 44, 150));
        PasswordNew.setFont(new java.awt.Font("Tahoma", 0, 14));         PasswordNew.setForeground(new java.awt.Color(255, 255, 255));
        PasswordNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordNew.setText("Nova senha:");
        PasswordNew.setOpaque(true);
        ChangePassword.add(PasswordNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 30));

        PasswordCheck.setBackground(new java.awt.Color(59, 44, 150));
        PasswordCheck.setFont(new java.awt.Font("Tahoma", 0, 14));         PasswordCheck.setForeground(new java.awt.Color(255, 255, 255));
        PasswordCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordCheck.setText("Repita a senha:");
        PasswordCheck.setOpaque(true);
        ChangePassword.add(PasswordCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 30));

        txtNewPassword.setBackground(new java.awt.Color(0, 0, 51));
        txtNewPassword.setFont(new java.awt.Font("Tahoma", 0, 14));         txtNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        ChangePassword.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

        txtNewPasswordConfirm.setBackground(new java.awt.Color(0, 0, 51));
        txtNewPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 14));         txtNewPasswordConfirm.setForeground(new java.awt.Color(255, 255, 255));
        txtNewPasswordConfirm.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        ChangePassword.add(txtNewPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 190, 30));

        txtOldPassword.setBackground(new java.awt.Color(0, 0, 51));
        txtOldPassword.setFont(new java.awt.Font("Tahoma", 0, 14));         txtOldPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtOldPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        ChangePassword.add(txtOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void bnt_saveMouseClicked(java.awt.event.MouseEvent evt) {        String oldPassword = new String(txtOldPassword.getPassword());
        String newPwd = new String(txtNewPassword.getPassword());
        String newPwdConfirm = new String(txtNewPasswordConfirm.getPassword());
        
        if (!isAllFieldsFilled()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!oldPassword.equals(user.getPassword())) {
            JOptionPane.showMessageDialog(this, "A senha atual está incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!newPwd.equals(newPwdConfirm)) {
            JOptionPane.showMessageDialog(this, "As senhas não conferem.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            user.setPassword(newPwd);
            UserDao.update(user);
            JOptionPane.showMessageDialog(this, "A nova senha foi definida com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
    }
    private void bnt_saveMouseEntered(java.awt.event.MouseEvent evt) {                bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvar.png")));
    }
    private void bnt_saveMouseExited(java.awt.event.MouseEvent evt) {                bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));
    }
    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {                btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelar.png")));
    }
    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {                btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));
    }

        private javax.swing.JPanel ChangePassword;
    private javax.swing.JLabel ChangePwTitle;
    private javax.swing.JLabel PasswordCheck;
    private javax.swing.JLabel PasswordCurrent;
    private javax.swing.JLabel PasswordNew;
    private javax.swing.JLabel bnt_save;
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPasswordConfirm;
    private javax.swing.JPasswordField txtOldPassword;
    }
