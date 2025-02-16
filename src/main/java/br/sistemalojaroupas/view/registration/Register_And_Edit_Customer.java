
package br.sistemalojaroupas.view.registration;

import br.sistemalojaroupas.db.DBException;
import br.sistemalojaroupas.model.dao.CustomerDao;
import br.sistemalojaroupas.model.entities.Customer;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Register_And_Edit_Customer extends javax.swing.JDialog {

    private Customer customer;
    private boolean isRegistering;

    
    public Register_And_Edit_Customer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        pnl_Background.setBackground(new Color(0, 0, 0, 0));
        isRegistering = true;
    }

    public Register_And_Edit_Customer(java.awt.Frame owner, boolean modal, Customer customer) {
        super(owner, modal);
        initComponents();

        this.setBackground(new java.awt.Color(0, 0, 0, 0));

        this.customer = customer;
        isRegistering = false;

        title.setText("Editar cliente");
        cName.setText(customer.getName());
        txtfCpf.setValue(customer.getCpf());
        cEmail.setText(customer.getEmail());
        txtfPhone.setValue(customer.getPhone());
    }

    public void limpaCampos() {
        cEmail.setText("");
        txtfCpf.setText("");
        txtfPhone.setText("");
        cName.setText("");
    }

    private Customer instantiateCustomer(Customer customer) {

        customer.setName(cName.getText().toUpperCase());
        customer.setEmail(cEmail.getText());
        customer.setCpf(txtfCpf.getText());
        customer.setPhone(txtfPhone.getText());

        return customer;
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        pnl_Background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cEmail = new javax.swing.JTextField();
        cName = new javax.swing.JTextField();
        txtfCpf = new javax.swing.JFormattedTextField();
        txtfPhone = new javax.swing.JFormattedTextField();
        btn_Savec = new javax.swing.JLabel();
        btn_Cancelc = new javax.swing.JLabel();
        btn_Cleanc = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnl_Background.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Background.setOpaque(false);
        pnl_Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(59, 44, 150));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome:");
        jLabel1.setOpaque(true);
        pnl_Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 30));

        jLabel2.setBackground(new java.awt.Color(59, 44, 150));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CPF:");
        jLabel2.setOpaque(true);
        pnl_Background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 30));

        jLabel3.setBackground(new java.awt.Color(59, 44, 150));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("E-mail:");
        jLabel3.setOpaque(true);
        pnl_Background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 80, 30));

        jLabel4.setBackground(new java.awt.Color(59, 44, 150));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Celular:");
        jLabel4.setOpaque(true);
        pnl_Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 30));

        cEmail.setBackground(new java.awt.Color(0, 0, 51));
        cEmail.setFont(new java.awt.Font("Tahoma", 0, 14));         cEmail.setForeground(new java.awt.Color(255, 255, 255));
        cEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        pnl_Background.add(cEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 329, 30));

        cName.setBackground(new java.awt.Color(0, 0, 51));
        cName.setFont(new java.awt.Font("Tahoma", 0, 14));         cName.setForeground(new java.awt.Color(255, 255, 255));
        cName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        pnl_Background.add(cName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 329, 30));

        txtfCpf.setBackground(new java.awt.Color(0, 0, 51));
        txtfCpf.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txtfCpf.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfCpf.setFont(new java.awt.Font("Tahoma", 0, 14));         pnl_Background.add(txtfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 180, 30));

        txtfPhone.setBackground(new java.awt.Color(0, 0, 51));
        txtfPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txtfPhone.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtfPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfPhone.setFont(new java.awt.Font("Tahoma", 0, 14));         pnl_Background.add(txtfPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 180, 30));

        btn_Savec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));         btn_Savec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SavecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SavecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SavecMouseExited(evt);
            }
        });
        pnl_Background.add(btn_Savec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        btn_Cancelc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));         btn_Cancelc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CancelcMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CancelcMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CancelcMouseExited(evt);
            }
        });
        pnl_Background.add(btn_Cancelc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        btn_Cleanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limparClaro.png")));         btn_Cleanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CleancMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CleancMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CleancMouseExited(evt);
            }
        });
        pnl_Background.add(btn_Cleanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        title.setFont(new java.awt.Font("Tahoma", 1, 18));         title.setForeground(new java.awt.Color(0, 0, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("CADASTRAR NOVO CLIENTE");
        pnl_Background.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tela_cadastro_dark.png")));         pnl_Background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnl_Background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void btn_CleancMouseClicked(java.awt.event.MouseEvent evt) {        limpaCampos();
    }
    private void btn_CancelcMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void btn_SavecMouseClicked(java.awt.event.MouseEvent evt) {        btn_Savec.requestFocusInWindow();
        try {
            if (Utils.isAllFieldsFilled(pnl_Background)) {
                
                if (customer == null || isRegistering) {
                    
                    customer = instantiateCustomer(new Customer());
                    
                    CustomerDao.insert(customer);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    
                    Utils.clearFields(pnl_Background);
                    customer = null;
                } else {
                    instantiateCustomer(customer);
                    CustomerDao.update(customer);
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void btn_CancelcMouseEntered(java.awt.event.MouseEvent evt) {        btn_Cancelc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelar.png")));
    }
    private void btn_CancelcMouseExited(java.awt.event.MouseEvent evt) {        btn_Cancelc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));
    }
    private void btn_SavecMouseEntered(java.awt.event.MouseEvent evt) {        btn_Savec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvar.png")));
    }
    private void btn_SavecMouseExited(java.awt.event.MouseEvent evt) {        btn_Savec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));
    }
    private void btn_CleancMouseEntered(java.awt.event.MouseEvent evt) {        btn_Cleanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limpar.png")));
    }
    private void btn_CleancMouseExited(java.awt.event.MouseEvent evt) {        btn_Cleanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limparClaro.png")));
    }

        private javax.swing.JLabel btn_Cancelc;
    private javax.swing.JLabel btn_Cleanc;
    private javax.swing.JLabel btn_Savec;
    private javax.swing.JTextField cEmail;
    private javax.swing.JTextField cName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnl_Background;
    private javax.swing.JLabel title;
    private javax.swing.JFormattedTextField txtfCpf;
    private javax.swing.JFormattedTextField txtfPhone;
    
}
