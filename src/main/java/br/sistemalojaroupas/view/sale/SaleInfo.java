
package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.entities.SaleItem;
import br.sistemalojaroupas.view.util.Utils;
import java.util.List;
import java.util.Set;


public class SaleInfo extends javax.swing.JDialog {

    private Sale sale;
    
    public SaleInfo(java.awt.Frame parent, boolean modal, Sale sale) {
        super(parent, modal);
        initComponents();
        this.sale = sale;
        
        Utils.updateTable(sale.getItems(), saleItemsTable);
        txtCode.setText(sale.getId().toString());
        txtCustomer.setText(sale.getCustomerName());
        txtCustomerCpf.setText(sale.getCustomerCpf());
        txtEmployee.setText(sale.getEmployeeName());
        txtTotal.setText(String.format("R$ %.2f", sale.getTotal()));
        txtMoment.setValue(sale.getMoment());
        txtInstallments.setText(sale.getInstallments().toString());
        txtPayment.setText(sale.getPaymentName());
    }

    
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleItemsTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtCustomer = new javax.swing.JTextField();
        txtCustomerCpf = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEmployee = new javax.swing.JTextField();
        txtPayment = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMoment = new javax.swing.JFormattedTextField();
        txtInstallments = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_MinInformation = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Código da venda:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data e horário:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Forma pgto:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Vendedor:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CPF do cliente:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cliente:");

        saleItemsTable.setBackground(new java.awt.Color(255, 255, 255));
        saleItemsTable.setForeground(new java.awt.Color(0, 0, 0));
        saleItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Produto", "Marca", "Tamanho", "Cor", "Preço Un.", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleItemsTable.setGridColor(new java.awt.Color(204, 204, 204));
        saleItemsTable.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(saleItemsTable);
        if (saleItemsTable.getColumnModel().getColumnCount() > 0) {
            saleItemsTable.getColumnModel().getColumn(0).setMinWidth(50);
            saleItemsTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            saleItemsTable.getColumnModel().getColumn(0).setMaxWidth(150);
            saleItemsTable.getColumnModel().getColumn(3).setMinWidth(50);
            saleItemsTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            saleItemsTable.getColumnModel().getColumn(3).setMaxWidth(120);
            saleItemsTable.getColumnModel().getColumn(4).setMinWidth(50);
            saleItemsTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            saleItemsTable.getColumnModel().getColumn(4).setMaxWidth(150);
            saleItemsTable.getColumnModel().getColumn(5).setMinWidth(50);
            saleItemsTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            saleItemsTable.getColumnModel().getColumn(5).setMaxWidth(150);
            saleItemsTable.getColumnModel().getColumn(6).setMinWidth(50);
            saleItemsTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            saleItemsTable.getColumnModel().getColumn(6).setMaxWidth(150);
            saleItemsTable.getColumnModel().getColumn(7).setMinWidth(60);
            saleItemsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            saleItemsTable.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ITENS:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));         jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Total:");

        txtCode.setEditable(false);
        txtCode.setBackground(new java.awt.Color(204, 204, 204));
        txtCode.setForeground(new java.awt.Color(0, 0, 0));

        txtCustomer.setEditable(false);
        txtCustomer.setBackground(new java.awt.Color(204, 204, 204));
        txtCustomer.setForeground(new java.awt.Color(0, 0, 0));

        txtCustomerCpf.setEditable(false);
        txtCustomerCpf.setBackground(new java.awt.Color(204, 204, 204));
        txtCustomerCpf.setForeground(new java.awt.Color(0, 0, 0));
        txtCustomerCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerCpfActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(204, 204, 204));
        txtTotal.setForeground(new java.awt.Color(0, 0, 0));

        txtEmployee.setEditable(false);
        txtEmployee.setBackground(new java.awt.Color(204, 204, 204));
        txtEmployee.setForeground(new java.awt.Color(0, 0, 0));

        txtPayment.setEditable(false);
        txtPayment.setBackground(new java.awt.Color(204, 204, 204));
        txtPayment.setForeground(new java.awt.Color(0, 0, 0));
        txtPayment.setText("DINHEIRO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));         jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Parcelamento:");

        txtMoment.setEditable(false);
        txtMoment.setBackground(new java.awt.Color(204, 204, 204));
        txtMoment.setForeground(new java.awt.Color(0, 0, 0));
        txtMoment.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss"))));

        txtInstallments.setEditable(false);
        txtInstallments.setBackground(new java.awt.Color(204, 204, 204));
        txtInstallments.setForeground(new java.awt.Color(0, 0, 0));
        txtInstallments.setText("N/A");

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_MinInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mimizar.png")));         btn_MinInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MinInformationMouseClicked(evt);
            }
        });
        jPanel6.add(btn_MinInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel11.setForeground(new java.awt.Color(108, 81, 233));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("INFORMAÇÃO DA VENDA");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(188, 188, 188)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtInstallments)
                            .addComponent(txtPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtMoment))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCode, txtCustomerCpf});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMoment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstallments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void btn_MinInformationMouseClicked(java.awt.event.MouseEvent evt) {        this.dispose();
    }
    private void txtCustomerCpfActionPerformed(java.awt.event.ActionEvent evt) {            }

        private javax.swing.JLabel btn_MinInformation;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable saleItemsTable;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtCustomerCpf;
    private javax.swing.JTextField txtEmployee;
    private javax.swing.JTextField txtInstallments;
    private javax.swing.JFormattedTextField txtMoment;
    private javax.swing.JTextField txtPayment;
    private javax.swing.JTextField txtTotal;
    }
