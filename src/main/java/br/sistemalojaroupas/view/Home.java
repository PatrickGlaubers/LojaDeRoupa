package br.sistemalojaroupas.view;

import br.sistemalojaroupas.view.registration.Register_And_Edit_Employee;
import br.sistemalojaroupas.view.registration.Register_And_Edit_Customer;
import br.sistemalojaroupas.view.stock.Register_And_Edit_Products;
import br.sistemalojaroupas.view.sale.New_Sale;
import br.sistemalojaroupas.db.DB;
import br.sistemalojaroupas.model.dao.BrandDao;
import br.sistemalojaroupas.model.dao.CategoryDao;
import br.sistemalojaroupas.model.dao.ColorDao;
import br.sistemalojaroupas.model.dao.CustomerDao;
import br.sistemalojaroupas.model.dao.EmployeeDao;
import br.sistemalojaroupas.model.dao.ProductDao;
import br.sistemalojaroupas.model.dao.SaleDao;
import br.sistemalojaroupas.model.entities.Brand;
import br.sistemalojaroupas.model.entities.Category;
import br.sistemalojaroupas.model.entities.Color;
import br.sistemalojaroupas.model.entities.Customer;
import br.sistemalojaroupas.model.entities.Employee;
import br.sistemalojaroupas.model.entities.Product;
import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.services.SaleService;
import br.sistemalojaroupas.view.listeners.DataChangeListener;
import br.sistemalojaroupas.view.registration.Change_Password;
import br.sistemalojaroupas.view.sale.SaleInfo;
import br.sistemalojaroupas.view.stock.Add_Product;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class Home extends javax.swing.JFrame implements DataChangeListener {

    private Boolean isMenuHided = true;
    private List<JPanel> menuButtonsList = new ArrayList<>();
    private CardLayout panelsCardLayout;
    private JTable visibleTable;
    private Boolean productFilterVisibility = false;
    private Boolean saleFilterVisibility = false;
    private Boolean homeInfoVisibility = false;
    
    private int mouseX;
    private int mouseY;
    
    private Map<String, Object> productSelectedFilters = new HashMap<>();
    
    private final String PERMISSION_ERROR = "Você não tem permissão para acessar esta funcionalidade.";

    public Home() {

        initComponents();

        panelsCardLayout = (CardLayout) CollectionCard.getLayout();

                menuButtonsList.add(menu_home);
        menuButtonsList.add(menu_customers);
        menuButtonsList.add(menu_sale);
        menuButtonsList.add(menu_settings);
        menuButtonsList.add(menu_employees);
        menuButtonsList.add(menu_product);

        setMenuButtonsColor(menu_home);

        refreshHomeData();
    }
    
    private boolean hasPermission(String key) {
                if (Login.getLoggedUser() == null) {
            return true;
        }
        else {
            return Login.getLoggedUser().hasPermission(key);
        }
    }

    private void setMenuButtonsColor(JPanel pn1) {

        pn1.setBackground(new java.awt.Color(108, 81, 233));

        menuButtonsList.forEach(pn2 -> {
            if (!pn2.equals(pn1)) {
                pn2.setBackground(new java.awt.Color(0, 0, 51));
            }
        });
    }

    public void setDefaultColor(JPanel pnl) {
        pnl.setBackground(new java.awt.Color(98, 85, 158));
    }

    public void resetDefaultColor(JPanel pnl) {
        pnl.setBackground(new java.awt.Color(108, 81, 233));
    }

    public void changePaneSize(JPanel pnl, Dimension dim) {
        pnl.setPreferredSize(dim);
    }

    @Override
    public void onDataChanged() {
        refreshHomeData();
        Utils.updateTable(SaleDao.findAll(), tableSales);
    }

    private void setVisibleTable(JTable table) {
        this.visibleTable = table;
    }

    private void refreshHomeData() {
        
        if (homeInfoVisibility) {
            txtTotalSales.setText(SaleDao.size().toString());
            txtFaturamentoValor.setText(String.format("R$ %.2f", SaleDao.revenues(0)));
            txtTicketValor.setText(String.format("R$ %.2f", SaleService.ticketMedio()));
            txtReceitaValor.setText(String.format("R$ %.2f", SaleService.receitaLiquida()));
        }
        
        else {
            txtTotalSales.setText("---");
            txtFaturamentoValor.setText("R$ -,--");
            txtTicketValor.setText("R$ -,--");
            txtReceitaValor.setText("R$ -,--");
        }
    }

    @SuppressWarnings("unchecked")
        private void initComponents() {

        popupProductsTable = new javax.swing.JPopupMenu();
        btnAddProduct = new javax.swing.JMenuItem();
        popupSaleTable = new javax.swing.JPopupMenu();
        menuSaleInfo = new javax.swing.JMenuItem();
        Head = new javax.swing.JPanel();
        MaxMinClose = new javax.swing.JPanel();
        pnl_Max = new javax.swing.JPanel();
        btn_Max = new javax.swing.JLabel();
        pnl_Close = new javax.swing.JPanel();
        btn_Close = new javax.swing.JLabel();
        pnl_Min = new javax.swing.JPanel();
        btn_Min = new javax.swing.JLabel();
        pnl_HeaderMenu = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Mid_Header = new javax.swing.JPanel();
        pnl_IconMenu = new javax.swing.JPanel();
        btn_ShowHideMenu = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        menu_home = new javax.swing.JPanel();
        btn_home = new javax.swing.JLabel();
        icon_home = new javax.swing.JLabel();
        menu_sale = new javax.swing.JPanel();
        btn_sales = new javax.swing.JLabel();
        icon_sales = new javax.swing.JLabel();
        menu_product = new javax.swing.JPanel();
        btn_products = new javax.swing.JLabel();
        icon_products = new javax.swing.JLabel();
        menu_employees = new javax.swing.JPanel();
        btn_employees = new javax.swing.JLabel();
        icon_employees = new javax.swing.JLabel();
        menu_customers = new javax.swing.JPanel();
        btn_customers = new javax.swing.JLabel();
        icon_customers = new javax.swing.JLabel();
        menu_settings = new javax.swing.JPanel();
        btn_settings = new javax.swing.JLabel();
        icon_settings = new javax.swing.JLabel();
        CollectionCard = new javax.swing.JPanel();
        Card_Home = new javax.swing.JPanel();
        iconeOcultar1 = new javax.swing.JLabel();
        txtBemVindo1 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        panelInformacoes1 = new javax.swing.JPanel();
        pnFaturamento = new javax.swing.JPanel();
        txtFaturamento = new javax.swing.JLabel();
        txtFaturamentoValor = new javax.swing.JLabel();
        iconFaturamento = new javax.swing.JLabel();
        fundoFaturamento = new javax.swing.JLabel();
        pnReceita = new javax.swing.JPanel();
        txtReceita = new javax.swing.JLabel();
        txtReceitaValor = new javax.swing.JLabel();
        iconReceita = new javax.swing.JLabel();
        fundoReceita = new javax.swing.JLabel();
        pnVendas = new javax.swing.JPanel();
        txtVendas = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JLabel();
        iconVendas = new javax.swing.JLabel();
        fundoVendas = new javax.swing.JLabel();
        pnTicket = new javax.swing.JPanel();
        txtTicket = new javax.swing.JLabel();
        txtTicketValor = new javax.swing.JLabel();
        iconTicket = new javax.swing.JLabel();
        fundoTicket = new javax.swing.JLabel();
        bgButtonsHome = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        novaVenda2 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        novoProduto2 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        novoCliente2 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        buscarCliente2 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        buscarVenda2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Card_Sales = new javax.swing.JPanel();
        lbl_FinalDate = new javax.swing.JLabel();
        lbl_InitialDate = new javax.swing.JLabel();
        dateEnd = new com.toedter.calendar.JDateChooser();
        dateStart = new com.toedter.calendar.JDateChooser();
        filter_btn_Cancel_Sale = new javax.swing.JLabel();
        filter_btn_Apply_Sale = new javax.swing.JLabel();
        btn_Filter_Sale = new javax.swing.JLabel();
        Filter_BackgroundSale = new javax.swing.JLabel();
        btn_NewSale = new javax.swing.JLabel();
        btn_SearchSale = new javax.swing.JLabel();
        searchSale = new javax.swing.JTextField();
        btn_DeleteSale = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSales = new javax.swing.JTable();
        Card_Products = new javax.swing.JPanel();
        filter_btn_Cancel = new javax.swing.JLabel();
        filter_btn_Apply = new javax.swing.JLabel();
        filter_cb_Color = new javax.swing.JComboBox<>();
        filter_cb_Size = new javax.swing.JComboBox<>();
        filter_cb_Brand = new javax.swing.JComboBox<>();
        filter_cb_Category = new javax.swing.JComboBox<>();
        Filter_Background = new javax.swing.JLabel();
        btn_editProduct = new javax.swing.JLabel();
        btn_removeProduct = new javax.swing.JLabel();
        btn_addProduct = new javax.swing.JLabel();
        txtProductsSearchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Products = new javax.swing.JTable();
        btn_Filter = new javax.swing.JLabel();
        btn_SearchProducts = new javax.swing.JLabel();
        Card_Employees = new javax.swing.JPanel();
        btnNewEmployee = new javax.swing.JLabel();
        btnEditEmployee = new javax.swing.JLabel();
        btnDeleteEmployee = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pane_Employee = new javax.swing.JScrollPane();
        table_Employees = new javax.swing.JTable();
        Panel_Employees = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        BirthDate = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        Job = new javax.swing.JLabel();
        CPF = new javax.swing.JLabel();
        Neighbourhood = new javax.swing.JLabel();
        txtEmployeeBirthDate = new javax.swing.JTextField();
        txtEmployeeCPF = new javax.swing.JTextField();
        State = new javax.swing.JLabel();
        CEP = new javax.swing.JLabel();
        HouseNumber = new javax.swing.JLabel();
        txtEmployeeCEP01 = new javax.swing.JTextField();
        txtEmployeeCEP02 = new javax.swing.JTextField();
        CPFSeparator = new javax.swing.JLabel();
        txtEmployeeAddress = new javax.swing.JTextField();
        City = new javax.swing.JLabel();
        txtEmployeeCity = new javax.swing.JTextField();
        txtEmployeeState = new javax.swing.JTextField();
        txtEmployeeAddressNum = new javax.swing.JTextField();
        Phone = new javax.swing.JLabel();
        txtEmployeeJob = new javax.swing.JTextField();
        txtEmployeePhone = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        txtEmployeeEmail = new javax.swing.JTextField();
        txtEmployeeNeigh = new javax.swing.JTextField();
        Card_Customers = new javax.swing.JPanel();
        btnRemoveCustomer = new javax.swing.JLabel();
        btnSearchCustomer = new javax.swing.JLabel();
        btnNewCustomer = new javax.swing.JLabel();
        cSearchCustomer = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        btnEditCustomer = new javax.swing.JLabel();
        Card_Settings = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnChangePassword = new javax.swing.JLabel();
        btnExitSystem = new javax.swing.JLabel();

        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais_claro.png")));         btnAddProduct.setText("Adicionar");
        btnAddProduct.setToolTipText("");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        popupProductsTable.add(btnAddProduct);

        menuSaleInfo.setText("Ver informações");
        menuSaleInfo.setToolTipText("");
        menuSaleInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaleInfoActionPerformed(evt);
            }
        });
        popupSaleTable.add(menuSaleInfo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Head.setBackground(new java.awt.Color(108, 81, 233));
        Head.setMaximumSize(new java.awt.Dimension(1000, 50));
        Head.setMinimumSize(new java.awt.Dimension(1000, 50));
        Head.setPreferredSize(new java.awt.Dimension(1000, 50));
        Head.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeadMouseDragged(evt);
            }
        });
        Head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeadMousePressed(evt);
            }
        });
        Head.setLayout(new java.awt.BorderLayout());

        MaxMinClose.setMaximumSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setMinimumSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setPreferredSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Max.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Max.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Max.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Max.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_Max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_maximizar.png")));         btn_Max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_MaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_MaxMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_MaxLayout = new javax.swing.GroupLayout(pnl_Max);
        pnl_Max.setLayout(pnl_MaxLayout);
        pnl_MaxLayout.setHorizontalGroup(
            pnl_MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MaxLayout.createSequentialGroup()
                .addComponent(btn_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_MaxLayout.setVerticalGroup(
            pnl_MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_MaxLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(btn_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MaxMinClose.add(pnl_Max, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        pnl_Close.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Close.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Close.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Close.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_fechar.png")));         btn_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_CloseLayout = new javax.swing.GroupLayout(pnl_Close);
        pnl_Close.setLayout(pnl_CloseLayout);
        pnl_CloseLayout.setHorizontalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CloseLayout.createSequentialGroup()
                .addComponent(btn_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_CloseLayout.setVerticalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CloseLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(btn_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MaxMinClose.add(pnl_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        pnl_Min.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Min.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Min.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Min.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_Min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mimizar.png")));         btn_Min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_MinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_MinMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_MinLayout = new javax.swing.GroupLayout(pnl_Min);
        pnl_Min.setLayout(pnl_MinLayout);
        pnl_MinLayout.setHorizontalGroup(
            pnl_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MinLayout.createSequentialGroup()
                .addComponent(btn_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_MinLayout.setVerticalGroup(
            pnl_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_MinLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(btn_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MaxMinClose.add(pnl_Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Head.add(MaxMinClose, java.awt.BorderLayout.LINE_END);

        pnl_HeaderMenu.setBackground(new java.awt.Color(108, 81, 233));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_unisales.png"))); 
        jLabel14.setText("Backoffice");

        javax.swing.GroupLayout pnl_HeaderMenuLayout = new javax.swing.GroupLayout(pnl_HeaderMenu);
        pnl_HeaderMenu.setLayout(pnl_HeaderMenuLayout);
        pnl_HeaderMenuLayout.setHorizontalGroup(
            pnl_HeaderMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_HeaderMenuLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        pnl_HeaderMenuLayout.setVerticalGroup(
            pnl_HeaderMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Head.add(pnl_HeaderMenu, java.awt.BorderLayout.LINE_START);

        Mid_Header.setBackground(new java.awt.Color(108, 81, 233));
        Mid_Header.setLayout(new java.awt.BorderLayout());

        pnl_IconMenu.setBackground(new java.awt.Color(108, 81, 233));
        pnl_IconMenu.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_IconMenu.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_IconMenu.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_ShowHideMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_ShowHideMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_menu.png")));         btn_ShowHideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ShowHideMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ShowHideMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ShowHideMenuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_IconMenuLayout = new javax.swing.GroupLayout(pnl_IconMenu);
        pnl_IconMenu.setLayout(pnl_IconMenuLayout);
        pnl_IconMenuLayout.setHorizontalGroup(
            pnl_IconMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_ShowHideMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        pnl_IconMenuLayout.setVerticalGroup(
            pnl_IconMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_ShowHideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Mid_Header.add(pnl_IconMenu, java.awt.BorderLayout.LINE_START);

        Head.add(Mid_Header, java.awt.BorderLayout.CENTER);

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        pnMenu.setBackground(new java.awt.Color(0, 0, 51));
        pnMenu.setMinimumSize(new java.awt.Dimension(70, 100));
        pnMenu.setPreferredSize(new java.awt.Dimension(200, 650));

        menu_home.setBackground(new java.awt.Color(0, 0, 51));
        menu_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_homeMouseClicked(evt);
            }
        });
        menu_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(255, 255, 255));
        btn_home.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_home.setText("Início");
        menu_home.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_home.png")));         icon_home.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_home.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_home.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_home.add(icon_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_sale.setBackground(new java.awt.Color(0, 0, 51));
        menu_sale.setPreferredSize(new java.awt.Dimension(200, 50));
        menu_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_saleMouseClicked(evt);
            }
        });
        menu_sale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_sales.setBackground(new java.awt.Color(255, 255, 255));
        btn_sales.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_sales.setForeground(new java.awt.Color(255, 255, 255));
        btn_sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_sales.setText("Vendas");
        menu_sale.add(btn_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_money.png")));         icon_sales.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_sales.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_sales.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_sale.add(icon_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_product.setBackground(new java.awt.Color(0, 0, 51));
        menu_product.setPreferredSize(new java.awt.Dimension(200, 50));
        menu_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_productMouseClicked(evt);
            }
        });
        menu_product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_products.setBackground(new java.awt.Color(255, 255, 255));
        btn_products.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_products.setForeground(new java.awt.Color(255, 255, 255));
        btn_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_products.setText("Produtos");
        menu_product.add(btn_products, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_products.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_clothes.png")));         icon_products.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_products.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_products.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_product.add(icon_products, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_employees.setBackground(new java.awt.Color(0, 0, 51));
        menu_employees.setPreferredSize(new java.awt.Dimension(200, 50));
        menu_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_employeesMouseClicked(evt);
            }
        });
        menu_employees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_employees.setBackground(new java.awt.Color(255, 255, 255));
        btn_employees.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_employees.setForeground(new java.awt.Color(255, 255, 255));
        btn_employees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_employees.setText("Funcionários");
        menu_employees.add(btn_employees, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_employees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_users.png")));         icon_employees.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_employees.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_employees.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_employees.add(icon_employees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_customers.setBackground(new java.awt.Color(0, 0, 51));
        menu_customers.setPreferredSize(new java.awt.Dimension(200, 50));
        menu_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_customersMouseClicked(evt);
            }
        });
        menu_customers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_customers.setBackground(new java.awt.Color(255, 255, 255));
        btn_customers.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_customers.setForeground(new java.awt.Color(255, 255, 255));
        btn_customers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_customers.setText("Clientes");
        menu_customers.add(btn_customers, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_customers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_customers.png")));         icon_customers.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_customers.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_customers.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_customers.add(icon_customers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_settings.setBackground(new java.awt.Color(0, 0, 51));
        menu_settings.setPreferredSize(new java.awt.Dimension(200, 50));
        menu_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_settingsMouseClicked(evt);
            }
        });
        menu_settings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_settings.setBackground(new java.awt.Color(255, 255, 255));
        btn_settings.setFont(new java.awt.Font("Tahoma", 0, 14));         btn_settings.setForeground(new java.awt.Color(255, 255, 255));
        btn_settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_settings.setText("Configurações");
        menu_settings.add(btn_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 50));

        icon_settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_settings.png")));         icon_settings.setMaximumSize(new java.awt.Dimension(70, 50));
        icon_settings.setMinimumSize(new java.awt.Dimension(70, 50));
        icon_settings.setPreferredSize(new java.awt.Dimension(70, 50));
        menu_settings.add(icon_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_sale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_employees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menu_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(menu_sale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_customers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMenuLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(menu_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(490, Short.MAX_VALUE)))
        );

        getContentPane().add(pnMenu, java.awt.BorderLayout.WEST);

        CollectionCard.setMinimumSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setPreferredSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setLayout(new java.awt.CardLayout());

        Card_Home.setBackground(new java.awt.Color(255, 255, 255));
        Card_Home.setPreferredSize(new java.awt.Dimension(1110, 583));

        iconeOcultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_olhoFechar.png")));         iconeOcultar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeOcultar1MouseClicked(evt);
            }
        });

        txtBemVindo1.setFont(new java.awt.Font("Tahoma", 1, 20));         txtBemVindo1.setForeground(new java.awt.Color(29, 73, 153));
        txtBemVindo1.setText("  Olá, bem-vindo!");
        txtBemVindo1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(0, 0, 51)));

        panelInformacoes1.setBackground(new java.awt.Color(0,0,0,0));
        panelInformacoes1.setOpaque(false);
        panelInformacoes1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 50, 5));

        pnFaturamento.setBackground(new java.awt.Color(0,0,0,0));
        pnFaturamento.setOpaque(false);
        pnFaturamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFaturamento.setFont(new java.awt.Font("Tahoma", 1, 13));         txtFaturamento.setForeground(new java.awt.Color(255, 255, 255));
        txtFaturamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFaturamento.setText("Faturamento");
        pnFaturamento.add(txtFaturamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 20));

        txtFaturamentoValor.setFont(new java.awt.Font("Tahoma", 1, 16));         txtFaturamentoValor.setForeground(new java.awt.Color(255, 255, 255));
        txtFaturamentoValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFaturamentoValor.setText("R$ 39.482,49");
        pnFaturamento.add(txtFaturamentoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        iconFaturamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_dinheiro.png")));         pnFaturamento.add(iconFaturamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fundoFaturamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo1_home.png")));         pnFaturamento.add(fundoFaturamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInformacoes1.add(pnFaturamento);

        pnReceita.setBackground(new java.awt.Color(0,0,0,0));
        pnReceita.setOpaque(false);
        pnReceita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReceita.setFont(new java.awt.Font("Tahoma", 1, 13));         txtReceita.setForeground(new java.awt.Color(255, 255, 255));
        txtReceita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtReceita.setText("Receita líquida");
        pnReceita.add(txtReceita, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 20));

        txtReceitaValor.setFont(new java.awt.Font("Tahoma", 1, 16));         txtReceitaValor.setForeground(new java.awt.Color(255, 255, 255));
        txtReceitaValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtReceitaValor.setText("R$ 3.482,49");
        pnReceita.add(txtReceitaValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, -1));

        iconReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cifrão.png")));         pnReceita.add(iconReceita, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fundoReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo2_home.png")));         pnReceita.add(fundoReceita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInformacoes1.add(pnReceita);

        pnVendas.setBackground(new java.awt.Color(0,0,0,0));
        pnVendas.setOpaque(false);
        pnVendas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVendas.setFont(new java.awt.Font("Tahoma", 1, 13));         txtVendas.setForeground(new java.awt.Color(255, 255, 255));
        txtVendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVendas.setText("Total de vendas");
        pnVendas.add(txtVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 20));

        txtTotalSales.setFont(new java.awt.Font("Tahoma", 1, 16));         txtTotalSales.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalSales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalSales.setText("986");
        pnVendas.add(txtTotalSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 10, 100, -1));

        iconVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_carrinhoDeCompras.png")));         pnVendas.add(iconVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fundoVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo3_home.png")));         pnVendas.add(fundoVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInformacoes1.add(pnVendas);

        pnTicket.setBackground(new java.awt.Color(0,0,0,0));
        pnTicket.setOpaque(false);
        pnTicket.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTicket.setFont(new java.awt.Font("Tahoma", 1, 13));         txtTicket.setForeground(new java.awt.Color(255, 255, 255));
        txtTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTicket.setText("Ticket médio");
        pnTicket.add(txtTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 20));

        txtTicketValor.setFont(new java.awt.Font("Tahoma", 1, 16));         txtTicketValor.setForeground(new java.awt.Color(255, 255, 255));
        txtTicketValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTicketValor.setText("R$ 482,50");
        pnTicket.add(txtTicketValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, -1));

        iconTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_ticket.png")));         pnTicket.add(iconTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        fundoTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo4_home.png")));         pnTicket.add(fundoTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInformacoes1.add(pnTicket);

        bgButtonsHome.setBackground(new java.awt.Color(0,0,0,0));
        bgButtonsHome.setForeground(new java.awt.Color(51, 51, 51));
        bgButtonsHome.setMaximumSize(new java.awt.Dimension(1900, 1080));
        bgButtonsHome.setOpaque(false);
        bgButtonsHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0,0,0,0));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

        novaVenda2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        novaVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novaVenda.png")));         novaVenda2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        novaVenda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novaVenda2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                novaVenda2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                novaVenda2MouseExited(evt);
            }
        });
        jPanel6.add(novaVenda2);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator15.setPreferredSize(new java.awt.Dimension(3, 180));
        jPanel6.add(jSeparator15);

        novoProduto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoProduto.png")));         novoProduto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novoProduto2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                novoProduto2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                novoProduto2MouseExited(evt);
            }
        });
        jPanel6.add(novoProduto2);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator16.setPreferredSize(new java.awt.Dimension(3, 180));
        jPanel6.add(jSeparator16);

        novoCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoCliente.png")));         novoCliente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novoCliente2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                novoCliente2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                novoCliente2MouseExited(evt);
            }
        });
        jPanel6.add(novoCliente2);

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator17.setPreferredSize(new java.awt.Dimension(3, 180));
        jPanel6.add(jSeparator17);

        buscarCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarCliente.png")));         buscarCliente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarCliente2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarCliente2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarCliente2MouseExited(evt);
            }
        });
        jPanel6.add(buscarCliente2);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator18.setPreferredSize(new java.awt.Dimension(3, 180));
        jPanel6.add(jSeparator18);

        buscarVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarVenda.png")));         buscarVenda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarVenda2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarVenda2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarVenda2MouseExited(evt);
            }
        });
        jPanel6.add(buscarVenda2);

        bgButtonsHome.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1050, 280));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo_botoes_home.png")));         bgButtonsHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout Card_HomeLayout = new javax.swing.GroupLayout(Card_Home);
        Card_Home.setLayout(Card_HomeLayout);
        Card_HomeLayout.setHorizontalGroup(
            Card_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card_HomeLayout.createSequentialGroup()
                .addGroup(Card_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Card_HomeLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtBemVindo1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Card_HomeLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Card_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelInformacoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgButtonsHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconeOcultar1))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Card_HomeLayout.setVerticalGroup(
            Card_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card_HomeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtBemVindo1)
                .addGap(25, 25, 25)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconeOcultar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(bgButtonsHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CollectionCard.add(Card_Home, "cardHome");

        Card_Sales.setBackground(new java.awt.Color(255, 255, 255));
        Card_Sales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_FinalDate.setFont(new java.awt.Font("Tahoma", 1, 12));         lbl_FinalDate.setForeground(new java.awt.Color(102, 102, 102));
        lbl_FinalDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FinalDate.setText("Data final :");
        Card_Sales.add(lbl_FinalDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 80, 30));

        lbl_InitialDate.setFont(new java.awt.Font("Tahoma", 1, 12));         lbl_InitialDate.setForeground(new java.awt.Color(102, 102, 102));
        lbl_InitialDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_InitialDate.setText("Data inicial :");
        Card_Sales.add(lbl_InitialDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 30, 80, 30));

        dateEnd.setBackground(new java.awt.Color(242, 242, 242));
        dateEnd.setForeground(new java.awt.Color(102, 102, 102));
        dateEnd.setDateFormatString("dd/MM/yyyy");
        Card_Sales.add(dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 120, 30));

        dateStart.setBackground(new java.awt.Color(242, 242, 242));
        dateStart.setForeground(new java.awt.Color(102, 102, 102));
        dateStart.setDateFormatString("dd/MM/yyyy");
        Card_Sales.add(dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 32, 120, 30));

        filter_btn_Cancel_Sale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filter_btn_Cancel_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltro.png")));         filter_btn_Cancel_Sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filter_btn_Cancel_SaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filter_btn_Cancel_SaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filter_btn_Cancel_SaleMouseExited(evt);
            }
        });
        Card_Sales.add(filter_btn_Cancel_Sale, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, 25));

        filter_btn_Apply_Sale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filter_btn_Apply_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltro.png")));         filter_btn_Apply_Sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filter_btn_Apply_SaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filter_btn_Apply_SaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filter_btn_Apply_SaleMouseExited(evt);
            }
        });
        Card_Sales.add(filter_btn_Apply_Sale, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, 25));

        btn_Filter_Sale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Filter_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_filtrar.png")));         btn_Filter_Sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Filter_SaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_Filter_SaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_Filter_SaleMouseExited(evt);
            }
        });
        Card_Sales.add(btn_Filter_Sale, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        Filter_BackgroundSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_FiltroAplicado.png")));         Filter_BackgroundSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Filter_BackgroundSaleMouseClicked(evt);
            }
        });
        Card_Sales.add(Filter_BackgroundSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        btn_NewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));         btn_NewSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NewSaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_NewSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_NewSaleMouseExited(evt);
            }
        });
        Card_Sales.add(btn_NewSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 174, -1, -1));

        btn_SearchSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));         btn_SearchSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SearchSaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SearchSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SearchSaleMouseExited(evt);
            }
        });
        Card_Sales.add(btn_SearchSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(943, 174, -1, -1));
        Card_Sales.add(searchSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 174, 623, 30));

        btn_DeleteSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));         btn_DeleteSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DeleteSaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_DeleteSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_DeleteSaleMouseExited(evt);
            }
        });
        Card_Sales.add(btn_DeleteSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 174, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel32.setForeground(new java.awt.Color(0, 0, 51));
        jLabel32.setText(" Vendas");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Sales.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, 100, -1));
        Card_Sales.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, 1060, 10));

        tableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, null},
                {"", "", null, null, null},
                {"", "", null, null, null},
                {"", "", null, null, null},
                {"", "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cód. da Venda", "Total", "Data", "Nome Cliente", "CPF Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSales.setGridColor(new java.awt.Color(204, 204, 204));
        tableSales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSales);
        if (tableSales.getColumnModel().getColumnCount() > 0) {
            tableSales.getColumnModel().getColumn(0).setMinWidth(50);
            tableSales.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableSales.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        Card_Sales.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 214, 961, 342));

        CollectionCard.add(Card_Sales, "cardSales");

        Card_Products.setBackground(new java.awt.Color(255, 255, 255));
        Card_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card_ProductsMouseClicked(evt);
            }
        });
        Card_Products.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filter_btn_Cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filter_btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltro.png")));         filter_btn_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filter_btn_CancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filter_btn_CancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filter_btn_CancelMouseExited(evt);
            }
        });
        Card_Products.add(filter_btn_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, 25));

        filter_btn_Apply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filter_btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltro.png")));         filter_btn_Apply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filter_btn_ApplyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filter_btn_ApplyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filter_btn_ApplyMouseExited(evt);
            }
        });
        Card_Products.add(filter_btn_Apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, 25));

        filter_cb_Color.setBackground(new java.awt.Color(204, 204, 204));
        filter_cb_Color.setFont(new java.awt.Font("Tahoma", 1, 10));         filter_cb_Color.setForeground(new java.awt.Color(102, 102, 102));
        filter_cb_Color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cor..", "Item 1", "Item 2", "Item 3", "Item 4" }));
        Card_Products.add(filter_cb_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 100, -1));

        filter_cb_Size.setBackground(new java.awt.Color(204, 204, 204));
        filter_cb_Size.setFont(new java.awt.Font("Tahoma", 1, 10));         filter_cb_Size.setForeground(new java.awt.Color(102, 102, 102));
        filter_cb_Size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tamanho...", "PP", "P", "M", "G", "GG", "XG", "XGG", "XGGG", "U", "1", "2", "3", "4", "5", "6", "7", "8", "10", "12", "14", "16", "32", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56", "58", "60" }));
        Card_Products.add(filter_cb_Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 80, 100, -1));

        filter_cb_Brand.setBackground(new java.awt.Color(204, 204, 204));
        filter_cb_Brand.setFont(new java.awt.Font("Tahoma", 1, 10));         filter_cb_Brand.setForeground(new java.awt.Color(102, 102, 102));
        filter_cb_Brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca..", "Item 1", "Item 2", "Item 3", "Item 4" }));
        Card_Products.add(filter_cb_Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 100, -1));

        filter_cb_Category.setBackground(new java.awt.Color(204, 204, 204));
        filter_cb_Category.setFont(new java.awt.Font("Tahoma", 1, 10));         filter_cb_Category.setForeground(new java.awt.Color(102, 102, 102));
        filter_cb_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria..", "Item 1", "Item 2", "Item 3", "Item 4" }));
        Card_Products.add(filter_cb_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 40, 100, -1));

        Filter_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_FiltroAplicado.png")));         Filter_Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Filter_BackgroundMouseClicked(evt);
            }
        });
        Card_Products.add(Filter_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        btn_editProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));         btn_editProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_editProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 174, -1, -1));

        btn_removeProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));         btn_removeProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_removeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 174, -1, -1));

        btn_addProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));         btn_addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 174, -1, -1));

        txtProductsSearchField.setFont(new java.awt.Font("Tahoma", 0, 12));         txtProductsSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductsSearchFieldKeyPressed(evt);
            }
        });
        Card_Products.add(txtProductsSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 174, 540, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText(" Produtos");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Products.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, 100, -1));
        Card_Products.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, 1060, 10));

        table_Products.setForeground(new java.awt.Color(0, 0, 51));
        table_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód.", "Descrição", "Cor", "Tamanho", "Categoria", "Marca", "P. Custo", "P. Venda", "Qtd.", "Data entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Products.setGridColor(new java.awt.Color(204, 204, 204));
        table_Products.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Products);
        if (table_Products.getColumnModel().getColumnCount() > 0) {
            table_Products.getColumnModel().getColumn(0).setMinWidth(25);
            table_Products.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_Products.getColumnModel().getColumn(0).setMaxWidth(75);
            table_Products.getColumnModel().getColumn(1).setMinWidth(150);
            table_Products.getColumnModel().getColumn(1).setPreferredWidth(220);
            table_Products.getColumnModel().getColumn(1).setMaxWidth(300);
            table_Products.getColumnModel().getColumn(2).setMinWidth(60);
            table_Products.getColumnModel().getColumn(2).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(2).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(3).setMinWidth(60);
            table_Products.getColumnModel().getColumn(3).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(3).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(4).setMinWidth(50);
            table_Products.getColumnModel().getColumn(4).setPreferredWidth(110);
            table_Products.getColumnModel().getColumn(4).setMaxWidth(150);
            table_Products.getColumnModel().getColumn(5).setMinWidth(50);
            table_Products.getColumnModel().getColumn(5).setPreferredWidth(110);
            table_Products.getColumnModel().getColumn(5).setMaxWidth(150);
            table_Products.getColumnModel().getColumn(6).setMinWidth(60);
            table_Products.getColumnModel().getColumn(6).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(6).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(7).setMinWidth(60);
            table_Products.getColumnModel().getColumn(7).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(7).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(8).setMinWidth(25);
            table_Products.getColumnModel().getColumn(8).setPreferredWidth(40);
            table_Products.getColumnModel().getColumn(8).setMaxWidth(60);
            table_Products.getColumnModel().getColumn(9).setMinWidth(80);
            table_Products.getColumnModel().getColumn(9).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        Card_Products.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 214, 983, 338));

        btn_Filter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Filter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_filtrar.png")));         btn_Filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FilterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_FilterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_FilterMouseExited(evt);
            }
        });
        Card_Products.add(btn_Filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        btn_SearchProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));         btn_SearchProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseExited(evt);
            }
        });
        Card_Products.add(btn_SearchProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(962, 174, -1, -1));

        CollectionCard.add(Card_Products, "cardProducts");

        Card_Employees.setBackground(new java.awt.Color(255, 255, 255));
        Card_Employees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNewEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNewEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));         btnNewEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewEmployeeMouseExited(evt);
            }
        });
        Card_Employees.add(btnNewEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 38));

        btnEditEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));         btnEditEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditEmployeeMouseExited(evt);
            }
        });
        Card_Employees.add(btnEditEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 38));

        btnDeleteEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));         btnDeleteEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteEmployeeMouseExited(evt);
            }
        });
        Card_Employees.add(btnDeleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, 38));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel34.setForeground(new java.awt.Color(0, 0, 51));
        jLabel34.setText(" Funcionários");
        jLabel34.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Employees.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));
        Card_Employees.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1060, 10));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel37.setForeground(new java.awt.Color(108, 81, 233));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("FUNCIONÁRIOS");
        Card_Employees.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 150, 47));

        jPanel2.setBackground(new java.awt.Color(0, 0, 61));

        table_Employees.setForeground(new java.awt.Color(0, 0, 51));
        table_Employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CPF", "Funcionários"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Employees.setGridColor(new java.awt.Color(204, 204, 204));
        table_Employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_EmployeesMouseClicked(evt);
            }
        });
        pane_Employee.setViewportView(table_Employees);
        if (table_Employees.getColumnModel().getColumnCount() > 0) {
            table_Employees.getColumnModel().getColumn(0).setMinWidth(0);
            table_Employees.getColumnModel().getColumn(0).setPreferredWidth(0);
            table_Employees.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        Panel_Employees.setBackground(new java.awt.Color(0, 0, 51));
        Panel_Employees.setForeground(new java.awt.Color(255, 255, 255));
        Panel_Employees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setFont(new java.awt.Font("Segoe UI", 0, 14));         Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("NOME");
        Panel_Employees.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        txtEmployeeName.setEditable(false);
        txtEmployeeName.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeName.setFont(new java.awt.Font("Segoe UI", 0, 14));         txtEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeNameActionPerformed(evt);
            }
        });
        Panel_Employees.add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 540, 30));

        BirthDate.setFont(new java.awt.Font("Segoe UI", 0, 14));         BirthDate.setForeground(new java.awt.Color(255, 255, 255));
        BirthDate.setText("DATA NASC.");
        Panel_Employees.add(BirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        Address.setFont(new java.awt.Font("Segoe UI", 0, 14));         Address.setForeground(new java.awt.Color(255, 255, 255));
        Address.setText("LOGRADOURO");
        Panel_Employees.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        Job.setFont(new java.awt.Font("Segoe UI", 0, 14));         Job.setForeground(new java.awt.Color(255, 255, 255));
        Job.setText("CARGO");
        Panel_Employees.add(Job, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 53, -1, -1));

        CPF.setFont(new java.awt.Font("Segoe UI", 0, 14));         CPF.setForeground(new java.awt.Color(255, 255, 255));
        CPF.setText("CPF");
        Panel_Employees.add(CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 53, -1, -1));

        Neighbourhood.setFont(new java.awt.Font("Segoe UI", 0, 14));         Neighbourhood.setForeground(new java.awt.Color(255, 255, 255));
        Neighbourhood.setText("BAIRRO");
        Panel_Employees.add(Neighbourhood, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, 30));

        txtEmployeeBirthDate.setEditable(false);
        txtEmployeeBirthDate.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeBirthDate.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 94, 30));

        txtEmployeeCPF.setEditable(false);
        txtEmployeeCPF.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeCPF.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 50, 114, -1));

        State.setFont(new java.awt.Font("Segoe UI", 0, 14));         State.setForeground(new java.awt.Color(255, 255, 255));
        State.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        State.setText("UF");
        Panel_Employees.add(State, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 24, -1));

        CEP.setFont(new java.awt.Font("Segoe UI", 0, 14));         CEP.setForeground(new java.awt.Color(255, 255, 255));
        CEP.setText("CEP");
        Panel_Employees.add(CEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, 30));

        HouseNumber.setBackground(new java.awt.Color(255, 255, 255));
        HouseNumber.setFont(new java.awt.Font("Segoe UI", 0, 14));         HouseNumber.setForeground(new java.awt.Color(255, 255, 255));
        HouseNumber.setText("Nº");
        Panel_Employees.add(HouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        txtEmployeeCEP01.setEditable(false);
        txtEmployeeCEP01.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeCEP01.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeCEP01, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 60, 30));

        txtEmployeeCEP02.setEditable(false);
        txtEmployeeCEP02.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeCEP02.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeCEP02, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 30));

        CPFSeparator.setFont(new java.awt.Font("Segoe UI", 0, 14));         CPFSeparator.setForeground(new java.awt.Color(255, 255, 255));
        CPFSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CPFSeparator.setText("-");
        Panel_Employees.add(CPFSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 20, 30));

        txtEmployeeAddress.setEditable(false);
        txtEmployeeAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeAddress.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 430, 30));

        City.setFont(new java.awt.Font("Segoe UI", 0, 14));         City.setForeground(new java.awt.Color(255, 255, 255));
        City.setText("CIDADE");
        Panel_Employees.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txtEmployeeCity.setEditable(false);
        txtEmployeeCity.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeCity.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, -1));

        txtEmployeeState.setEditable(false);
        txtEmployeeState.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeState.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeState, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 30, -1));

        txtEmployeeAddressNum.setEditable(false);
        txtEmployeeAddressNum.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeAddressNum.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeAddressNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 60, -1));

        Phone.setFont(new java.awt.Font("Segoe UI", 0, 14));         Phone.setForeground(new java.awt.Color(255, 255, 255));
        Phone.setText("CELULAR");
        Panel_Employees.add(Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        txtEmployeeJob.setEditable(false);
        txtEmployeeJob.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeJob.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 50, 210, -1));

        txtEmployeePhone.setEditable(false);
        txtEmployeePhone.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeePhone.setFont(new java.awt.Font("Segoe UI", 0, 14));         txtEmployeePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeePhoneActionPerformed(evt);
            }
        });
        Panel_Employees.add(txtEmployeePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 120, 30));

        Email.setFont(new java.awt.Font("Segoe UI", 0, 14));         Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("E-MAIL");
        Panel_Employees.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 30));

        txtEmployeeEmail.setEditable(false);
        txtEmployeeEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeEmail.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 103, 350, 30));

        txtEmployeeNeigh.setEditable(false);
        txtEmployeeNeigh.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeNeigh.setFont(new java.awt.Font("Segoe UI", 0, 14));         Panel_Employees.add(txtEmployeeNeigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 270, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pane_Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel_Employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pane_Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        Card_Employees.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 920, 350));

        CollectionCard.add(Card_Employees, "cardEmployees");

        Card_Customers.setBackground(new java.awt.Color(255, 255, 255));
        Card_Customers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));         btnRemoveCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnRemoveCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, 40));

        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));         btnSearchCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(941, 174, -1, -1));

        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));         btnNewCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnNewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 174, -1, -1));

        cSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cSearchCustomerKeyPressed(evt);
            }
        });
        Card_Customers.add(cSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 174, 410, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel33.setForeground(new java.awt.Color(0, 0, 51));
        jLabel33.setText(" Clientes");
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Customers.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, 100, -1));
        Card_Customers.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, 1060, 10));

        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Celular", "E-maill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomers.setGridColor(new java.awt.Color(204, 204, 204));
        tableCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tableCustomers);

        Card_Customers.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 214, 960, 350));

        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));         btnEditCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 174, -1, -1));

        CollectionCard.add(Card_Customers, "cardCustomers");

        Card_Settings.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18));         jLabel35.setForeground(new java.awt.Color(0, 0, 51));
        jLabel35.setText(" Configurações");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avatar.png"))); 
        labelUserName.setFont(new java.awt.Font("Segoe UI", 1, 12));         labelUserName.setForeground(new java.awt.Color(0, 0, 0));
        labelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUserName.setText("%NOME%");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Vendas realizadas:");

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total vendido:");

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)))
                            .addComponent(labelUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        btnChangePassword.setFont(new java.awt.Font("Calibri", 1, 18));         btnChangePassword.setForeground(new java.awt.Color(0, 0, 0));
        btnChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/synchronize (1).png")));         btnChangePassword.setText("  Alterar senha");
        btnChangePassword.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangePasswordMouseClicked(evt);
            }
        });

        btnExitSystem.setFont(new java.awt.Font("Calibri", 1, 18));         btnExitSystem.setForeground(new java.awt.Color(0, 0, 0));
        btnExitSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png")));         btnExitSystem.setText("        Sair do sistema");
        btnExitSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitSystemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Card_SettingsLayout = new javax.swing.GroupLayout(Card_Settings);
        Card_Settings.setLayout(Card_SettingsLayout);
        Card_SettingsLayout.setHorizontalGroup(
            Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card_SettingsLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(Card_SettingsLayout.createSequentialGroup()
                        .addGroup(Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Card_SettingsLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExitSystem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        Card_SettingsLayout.setVerticalGroup(
            Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Card_SettingsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Card_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Card_SettingsLayout.createSequentialGroup()
                        .addComponent(btnChangePassword)
                        .addGap(32, 32, 32)
                        .addComponent(btnExitSystem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        CollectionCard.add(Card_Settings, "cardSettings");

        getContentPane().add(CollectionCard, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1311, 679));
        setLocationRelativeTo(null);
    }
    private void btn_CloseMouseEntered(java.awt.event.MouseEvent evt) {                pnl_Close.setBackground(new java.awt.Color(232, 17, 35));
    }
    private void btn_CloseMouseExited(java.awt.event.MouseEvent evt) {                resetDefaultColor(pnl_Close);
    }
    private void btn_CloseMouseClicked(java.awt.event.MouseEvent evt) {                int op;
        op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (op == 0) {
            DB.close();
            System.exit(0);
        }
    }
    private void btn_MaxMouseEntered(java.awt.event.MouseEvent evt) {        setDefaultColor(pnl_Max);
    }
    private void btn_MaxMouseExited(java.awt.event.MouseEvent evt) {        resetDefaultColor(pnl_Max);
    }
    private void btn_MaxMouseClicked(java.awt.event.MouseEvent evt) {                if (this.getExtendedState() != java.awt.Frame.MAXIMIZED_BOTH) {
            this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(java.awt.Frame.NORMAL);
        }
    }
    private void btn_MinMouseEntered(java.awt.event.MouseEvent evt) {        setDefaultColor(pnl_Min);
    }
    private void btn_MinMouseExited(java.awt.event.MouseEvent evt) {        resetDefaultColor(pnl_Min);
    }
    private void btn_MinMouseClicked(java.awt.event.MouseEvent evt) {                this.setExtendedState(java.awt.Frame.ICONIFIED);
    }
    private void btn_ShowHideMenuMouseEntered(java.awt.event.MouseEvent evt) {        setDefaultColor(pnl_IconMenu);
    }
    private void btn_ShowHideMenuMouseExited(java.awt.event.MouseEvent evt) {        resetDefaultColor(pnl_IconMenu);
    }
    private void btn_ShowHideMenuMouseClicked(java.awt.event.MouseEvent evt) {        if (isMenuHided == true) {
            changePaneSize(pnl_HeaderMenu, new Dimension(70, pnl_HeaderMenu.getHeight()));
            changePaneSize(pnMenu, new Dimension(70, pnMenu.getHeight()));
            SwingUtilities.updateComponentTreeUI(this);
            isMenuHided = false;
        } else {
            changePaneSize(pnl_HeaderMenu, new Dimension(200, pnl_HeaderMenu.getHeight()));
            changePaneSize(pnMenu, new Dimension(200, pnMenu.getHeight()));
            SwingUtilities.updateComponentTreeUI(this);
            isMenuHided = true;
        }

    }
    private void btn_addProductMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("product")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        productSelectedFilters.clear();
        
        Register_And_Edit_Products dialog = new Register_And_Edit_Products(this, true);
        dialog.subscribeDataChangeListener(this);
        dialog.setVisible(true);
        Utils.updateTable(ProductDao.findAll(), table_Products);
    }
    private void btn_removeProductMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("product")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = table_Products.getSelectedRow();

        if (row > -1) {
            DefaultTableModel dtm = (DefaultTableModel) table_Products.getModel();
            Long id = (Long) dtm.getValueAt(row, 0);

            int op;
            op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse produto?",
                    "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (op == 0) {
                ProductDao.removeById(id);
                Utils.updateTable(ProductDao.findAll(), table_Products);
            }
        }
    }
    private void btn_editProductMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("product")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = table_Products.getSelectedRow();
        productSelectedFilters.clear();
        if (selectedRow > -1) {

            DefaultTableModel dtm = (DefaultTableModel) table_Products.getModel();

            Long id = (Long) dtm.getValueAt(selectedRow, 0);
            Product p = ProductDao.findById(id);

            Register_And_Edit_Products dialog = new Register_And_Edit_Products(null, true, p);
            dialog.subscribeDataChangeListener(this);
            dialog.setVisible(true);
            Utils.updateTable(ProductDao.findAll(), table_Products);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um produto para poder editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnNewEmployeeMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("employee")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new Register_And_Edit_Employee(this, true).setVisible(true);
        Utils.updateTable(EmployeeDao.findAll(), table_Employees);
        Utils.clearFields(Panel_Employees);
    }
    private void btnEditEmployeeMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("employee")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = table_Employees.getSelectedRow();

        if (selectedRow > -1) {

            DefaultTableModel dtm = (DefaultTableModel) table_Employees.getModel();

            String cpf = (String) dtm.getValueAt(selectedRow, 0);
            Employee emp = EmployeeDao.findByCpf(cpf);

            Register_And_Edit_Employee dialog = new Register_And_Edit_Employee(this, true, emp);
            dialog.setVisible(true);
            Utils.updateTable(EmployeeDao.findAll(), table_Employees);
            Utils.clearFields(Panel_Employees);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um funcionário para poder editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnDeleteEmployeeMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("employee")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = table_Employees.getSelectedRow();
        
        if (selectedRow > -1) {
            int option = JOptionPane.showConfirmDialog(this, "Você tem certeza que quer remover este funcionário?", 
                    "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            
            if (option != 0) return;
            
            DefaultTableModel dtm = (DefaultTableModel) table_Employees.getModel();
            
            String cpf = (String) dtm.getValueAt(selectedRow, 0);
            
            EmployeeDao.removeByCpf(cpf);
            Utils.updateTable(EmployeeDao.findAll(), table_Employees);
            Utils.clearFields(Panel_Employees);
        }
    }
    private void btn_NewSaleMouseClicked(java.awt.event.MouseEvent evt) {        if (hasPermission("sale")) {
            New_Sale frame = new New_Sale();
            frame.subscribeDataChangeListener(this);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Você não tem permissão para acessar esta função.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btn_SearchSaleMouseClicked(java.awt.event.MouseEvent evt) {            }
    private void btn_DeleteSaleMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("sale")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = tableSales.getSelectedRow();

        if (row > -1) {
            DefaultTableModel dtm = (DefaultTableModel) tableSales.getModel();
            Long id = (Long) dtm.getValueAt(row, 0);

            int op;
            op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?",
                    "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (op == 0) {
                SaleDao.removeById(id);
                Utils.updateTable(SaleDao.findAll(), tableSales);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Você deve selecionar uma venda para poder excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void menu_saleMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardSales");
        setMenuButtonsColor(menu_sale);

        setVisibleTable(tableSales);
        Utils.updateTable(SaleDao.findAll(), tableSales);
        
        Filter_BackgroundSale.setVisible(false); filter_btn_Cancel_Sale.setVisible(false); dateEnd.setVisible(false);
        dateStart.setVisible(false); lbl_FinalDate.setVisible(false); lbl_InitialDate.setVisible(false); filter_btn_Apply_Sale.setVisible(false);  
        
    }
    private void menu_homeMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardHome");
        setMenuButtonsColor(menu_home);

        setVisibleTable(null);
        refreshHomeData();
    }
    private void menu_productMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardProducts");
        setMenuButtonsColor(menu_product);

        setVisibleTable(table_Products);
        Utils.updateTable(ProductDao.findAll(), table_Products);
        productSelectedFilters.clear();
        
        Filter_Background.setVisible(false); filter_btn_Cancel.setVisible(false); filter_cb_Category.setVisible(false);
        filter_cb_Color.setVisible(false); filter_cb_Brand.setVisible(false); filter_cb_Size.setVisible(false); filter_btn_Apply.setVisible(false);
    }
    private void menu_employeesMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardEmployees");
        setMenuButtonsColor(menu_employees);

        setVisibleTable(table_Employees);
        Utils.updateTable(EmployeeDao.findAll(), table_Employees);
    }
    private void menu_customersMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardCustomers");
        setMenuButtonsColor(menu_customers);

        setVisibleTable(tableCustomers);
        Utils.updateTable(CustomerDao.findAll(), tableCustomers);
    }
    private void menu_settingsMouseClicked(java.awt.event.MouseEvent evt) {        panelsCardLayout.show(CollectionCard, "cardSettings");
        setMenuButtonsColor(menu_settings);
        labelUserName.setText(Login.getLoggedUser().getEmployeeName().toUpperCase());
    }
    private void btn_addProductMouseEntered(java.awt.event.MouseEvent evt) {                btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }
    private void btn_addProductMouseExited(java.awt.event.MouseEvent evt) {                btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }
    private void btn_editProductMouseEntered(java.awt.event.MouseEvent evt) {                btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_EditarEscuro.png")));
    }
    private void btn_editProductMouseExited(java.awt.event.MouseEvent evt) {                btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));
    }
    private void btn_removeProductMouseEntered(java.awt.event.MouseEvent evt) {                btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }
    private void btn_removeProductMouseExited(java.awt.event.MouseEvent evt) {                btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {
    }
    private void btnRemoveCustomerMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("customer")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int linha = tableCustomers.getSelectedRow();

        if (linha > -1) {

            DefaultTableModel dtm = (DefaultTableModel) tableCustomers.getModel();
            String id = (String) dtm.getValueAt(linha, 1);
            Customer v = CustomerDao.findByCpf(id);

            int ex;
            ex = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (ex == 0) {
                CustomerDao.remove(v);
                Utils.updateTable(CustomerDao.findAll(), tableCustomers);
            }
        }
        
    }
    private void btnNewCustomerMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("customer")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new Register_And_Edit_Customer(this, true).setVisible(true);
        Utils.updateTable(CustomerDao.findAll(), tableCustomers);
    }
    private void txtProductsSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_SearchProductsMouseClicked(null);
        }
    }
    private void btn_NewSaleMouseEntered(java.awt.event.MouseEvent evt) {        btn_NewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }
    private void btn_NewSaleMouseExited(java.awt.event.MouseEvent evt) {        btn_NewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }
    private void btn_DeleteSaleMouseEntered(java.awt.event.MouseEvent evt) {        btn_DeleteSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }
    private void btn_DeleteSaleMouseExited(java.awt.event.MouseEvent evt) {        btn_DeleteSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }
    private void btn_SearchSaleMouseEntered(java.awt.event.MouseEvent evt) {        btn_SearchSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisar.png")));
    }
    private void btn_SearchSaleMouseExited(java.awt.event.MouseEvent evt) {        btn_SearchSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));
    }
    private void btnNewEmployeeMouseEntered(java.awt.event.MouseEvent evt) {        btnNewEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }
    private void btnNewEmployeeMouseExited(java.awt.event.MouseEvent evt) {        btnNewEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }
    private void btnEditEmployeeMouseEntered(java.awt.event.MouseEvent evt) {        btnEditEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_EditarEscuro.png")));
    }
    private void btnEditEmployeeMouseExited(java.awt.event.MouseEvent evt) {        btnEditEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));
    }
    private void btnDeleteEmployeeMouseEntered(java.awt.event.MouseEvent evt) {        btnDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }
    private void btnDeleteEmployeeMouseExited(java.awt.event.MouseEvent evt) {        btnDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }
    private void btnNewCustomerMouseEntered(java.awt.event.MouseEvent evt) {        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }
    private void btnNewCustomerMouseExited(java.awt.event.MouseEvent evt) {        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }
    private void btnRemoveCustomerMouseEntered(java.awt.event.MouseEvent evt) {        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }
    private void btnRemoveCustomerMouseExited(java.awt.event.MouseEvent evt) {        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }
    private void btnSearchCustomerMouseClicked(java.awt.event.MouseEvent evt) {        String str = cSearchCustomer.getText();

        Utils.updateTable(CustomerDao.search(str), tableCustomers);
    }
    private void btnSearchCustomerMouseEntered(java.awt.event.MouseEvent evt) {        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisar.png")));
    }
    private void btnSearchCustomerMouseExited(java.awt.event.MouseEvent evt) {        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));
    }
    private void novaVenda2MouseEntered(java.awt.event.MouseEvent evt) {        novaVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novaVendaAzul.png")));
    }
    private void novaVenda2MouseExited(java.awt.event.MouseEvent evt) {        novaVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novaVenda.png")));
    }
    private void novoProduto2MouseEntered(java.awt.event.MouseEvent evt) {        novoProduto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoProdutoAzul.png")));
    }
    private void novoProduto2MouseExited(java.awt.event.MouseEvent evt) {        novoProduto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoProduto.png")));
    }
    private void novoCliente2MouseEntered(java.awt.event.MouseEvent evt) {        novoCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoClienteAzul.png")));
    }
    private void novoCliente2MouseExited(java.awt.event.MouseEvent evt) {        novoCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novoCliente.png")));
    }
    private void buscarCliente2MouseEntered(java.awt.event.MouseEvent evt) {        buscarCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarClienteAzul.png")));
    }
    private void buscarCliente2MouseExited(java.awt.event.MouseEvent evt) {        buscarCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarCliente.png")));
    }
    private void buscarVenda2MouseEntered(java.awt.event.MouseEvent evt) {        buscarVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarVendaAzul.png")));
    }
    private void buscarVenda2MouseExited(java.awt.event.MouseEvent evt) {        buscarVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscarVenda.png")));
    }
    private void btn_FilterMouseClicked(java.awt.event.MouseEvent evt) {        productFilterVisibility = !productFilterVisibility;
        
        Filter_Background.setVisible(productFilterVisibility);
        filter_btn_Cancel.setVisible(productFilterVisibility);        
        filter_cb_Category.setVisible(productFilterVisibility);
        filter_cb_Color.setVisible(productFilterVisibility);
        filter_cb_Brand.setVisible(productFilterVisibility);
        filter_cb_Size.setVisible(productFilterVisibility);
        filter_btn_Apply.setVisible(productFilterVisibility);
        
        Utils.updateComboBox(CategoryDao.findAll(), filter_cb_Category, "Categoria...");
        Utils.updateComboBox(BrandDao.findAll(), filter_cb_Brand, "Marca...");
        Utils.updateComboBox(ColorDao.findAll(), filter_cb_Color, "Cor...");
        
        if (productFilterVisibility && productSelectedFilters.size() > 0) {
            setSelectedProductFilterOrNull("color", filter_cb_Color);
            setSelectedProductFilterOrNull("category", filter_cb_Category);
            setSelectedProductFilterOrNull("brand", filter_cb_Brand);
            setSelectedProductFilterOrNull("size", filter_cb_Size);
        }
    }
    private void setSelectedProductFilterOrNull(String key, javax.swing.JComboBox comboBox) {
        Object obj = productSelectedFilters.get(key);
        if (obj == null) {
            comboBox.setSelectedIndex(0);  
        }
        else {
            comboBox.setSelectedItem(obj);
        }
    }
    
    private void btn_FilterMouseEntered(java.awt.event.MouseEvent evt) {        
    }
    private void btn_FilterMouseExited(java.awt.event.MouseEvent evt) {        
    }
    private void btnEditCustomerMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("customer")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = tableCustomers.getSelectedRow();

        if (selectedRow > -1) {

            DefaultTableModel dtm = (DefaultTableModel) tableCustomers.getModel();

            String cpf = (String) dtm.getValueAt(selectedRow, 1);
            Customer customer = CustomerDao.findByCpf(cpf);

            Register_And_Edit_Customer dialog = new Register_And_Edit_Customer(null, true, customer);
            dialog.setVisible(true);
            Utils.updateTable(CustomerDao.findAll(), tableCustomers);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um cliente para poder editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnEditCustomerMouseEntered(java.awt.event.MouseEvent evt) {        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_EditarEscuro.png")));
    }
    private void btnEditCustomerMouseExited(java.awt.event.MouseEvent evt) {        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));
    }
    private void cSearchCustomerKeyPressed(java.awt.event.KeyEvent evt) {        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String str = cSearchCustomer.getText();

            Utils.updateTable(CustomerDao.search(str), tableCustomers);

        }
    }
    private void novaVenda2MouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("sale")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        New_Sale frame = new New_Sale();
        frame.subscribeDataChangeListener(this);
        frame.setVisible(true);
    }
    private void novoProduto2MouseClicked(java.awt.event.MouseEvent evt) {        menu_productMouseClicked(evt);
        btn_addProductMouseClicked(evt);
    }
    private void novoCliente2MouseClicked(java.awt.event.MouseEvent evt) {        menu_customersMouseClicked(evt);
        btnNewCustomerMouseClicked(evt);
    }
    private void buscarCliente2MouseClicked(java.awt.event.MouseEvent evt) {        menu_customersMouseClicked(evt);
    }
    private void buscarVenda2MouseClicked(java.awt.event.MouseEvent evt) {        menu_saleMouseClicked(evt);
    }
    private void table_EmployeesMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("employee")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = table_Employees.getSelectedRow();
        
        if (selectedRow > -1) {
            DefaultTableModel dtm = (DefaultTableModel) table_Employees.getModel();
            
            String cpf = (String) dtm.getValueAt(selectedRow, 0);
            Employee emp = EmployeeDao.findByCpf(cpf);
            String cep = emp.getAddress().getCep();
            
            txtEmployeeName.setText(emp.getName());
            txtEmployeeCPF.setText(emp.getCpf());
            txtEmployeeCEP01.setText(cep.substring(0, 5));
            txtEmployeeCEP02.setText(cep.substring(5));
            txtEmployeeBirthDate.setText(emp.getFormattedBirthDate());
            txtEmployeePhone.setText(emp.getPhone());
            txtEmployeeJob.setText(emp.getOffice().getName());
            txtEmployeeAddress.setText(emp.getAddress().getStreet());
            txtEmployeeState.setText(emp.getAddress().getState());
            txtEmployeeAddressNum.setText(emp.getAddress().getNumber());
            txtEmployeeEmail.setText(emp.getEmail());
            txtEmployeeNeigh.setText(emp.getAddress().getNeighborhood());
            txtEmployeeCity.setText(emp.getAddress().getCity());
        }
    }
    private void txtEmployeePhoneActionPerformed(java.awt.event.ActionEvent evt) {            }
    private void txtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {            }
    private void btn_SearchProductsMouseClicked(java.awt.event.MouseEvent evt) {        String str = txtProductsSearchField.getText();
        
        if (productSelectedFilters.size() > 0) {
            Category cat = (Category) productSelectedFilters.get("category");
            Brand brand = (Brand) productSelectedFilters.get("brand");
            Color color = (Color) productSelectedFilters.get("color");
            String size = (String) productSelectedFilters.get("size");
            
            Utils.updateTable(Utils.productFilters(ProductDao.search(str), cat, brand, color, size), table_Products);
        }
        else {
            Utils.updateTable(ProductDao.search(str), table_Products);
        }
    }
    private void btn_SearchProductsMouseEntered(java.awt.event.MouseEvent evt) {       btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisar.png")));
    }
    private void btn_SearchProductsMouseExited(java.awt.event.MouseEvent evt) {        btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));
    }
    private void filter_btn_CancelMouseClicked(java.awt.event.MouseEvent evt) {        filter_cb_Brand.setSelectedIndex(0);
        filter_cb_Category.setSelectedIndex(0);
        filter_cb_Color.setSelectedIndex(0);
        filter_cb_Size.setSelectedIndex(0);
        
        productSelectedFilters.clear();
        
        Utils.updateTable(ProductDao.findAll(), table_Products);
    }
    private void filter_btn_CancelMouseEntered(java.awt.event.MouseEvent evt) {    filter_btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltroEscuro.png")));
    }
    private void filter_btn_CancelMouseExited(java.awt.event.MouseEvent evt) {    filter_btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltro.png")));
    }
    private void filter_btn_ApplyMouseClicked(java.awt.event.MouseEvent evt) {        int selectedCategory = filter_cb_Category.getSelectedIndex();
        int selectedBrand = filter_cb_Brand.getSelectedIndex();
        int selectedColor = filter_cb_Color.getSelectedIndex();
        int selectedSize = filter_cb_Size.getSelectedIndex();
        
        Category cat = (selectedCategory > 0) ? (Category) filter_cb_Category.getSelectedItem() : null;
        Brand brand = (selectedBrand > 0) ? (Brand) filter_cb_Brand.getSelectedItem() : null;
        Color color = (selectedColor > 0) ? (Color) filter_cb_Color.getSelectedItem() : null;
        String size = (selectedSize > 0) ? (String) filter_cb_Size.getSelectedItem() : null;
        
        productSelectedFilters.put("category", cat);
        productSelectedFilters.put("brand", brand);
        productSelectedFilters.put("color", color);
        productSelectedFilters.put("size", size);
        
        List<Product> products = Utils.productFilters(ProductDao.findAll(), cat, brand, color, size);
        products.sort((p1, p2) -> p1.getDescription().compareTo(p2.getDescription()));
        Utils.updateTable(products, table_Products);
    }
    private void filter_btn_ApplyMouseEntered(java.awt.event.MouseEvent evt) {        filter_btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltroEscuro.png"))); 
    }
    private void filter_btn_ApplyMouseExited(java.awt.event.MouseEvent evt) {    filter_btn_Apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltro.png"))); 
    }
    private void Card_ProductsMouseClicked(java.awt.event.MouseEvent evt) {        if (productFilterVisibility) {
            btn_FilterMouseClicked(evt);
        }
    }
    private void Filter_BackgroundMouseClicked(java.awt.event.MouseEvent evt) {                Filter_Background.requestFocusInWindow();
    }
    private void btn_Filter_SaleMouseClicked(java.awt.event.MouseEvent evt) {        saleFilterVisibility = !saleFilterVisibility;
        
        Filter_BackgroundSale.setVisible(saleFilterVisibility);
        filter_btn_Cancel_Sale.setVisible(saleFilterVisibility);        
        filter_btn_Apply_Sale.setVisible(saleFilterVisibility);        
        dateEnd.setVisible(saleFilterVisibility);
        dateStart.setVisible(saleFilterVisibility);
        lbl_FinalDate.setVisible(saleFilterVisibility);
        lbl_InitialDate.setVisible(saleFilterVisibility);  
        
        if(dateEnd != null || dateStart != null){
            dateStart.setDate(null);
            dateEnd.setDate(null);
        }
        
        if (saleFilterVisibility) {
            try {
                dateStart.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
                dateEnd.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            dateEnd.setMaxSelectableDate(new Date());
            dateStart.setMaxSelectableDate(new Date());
        }
    }
    private void btn_Filter_SaleMouseEntered(java.awt.event.MouseEvent evt) {            }
    private void btn_Filter_SaleMouseExited(java.awt.event.MouseEvent evt) {            }
    private void Filter_BackgroundSaleMouseClicked(java.awt.event.MouseEvent evt) {            }
    private void filter_btn_Cancel_SaleMouseClicked(java.awt.event.MouseEvent evt) {                dateStart.setDate(null);
        dateEnd.setDate(null);
        Utils.updateTable(SaleDao.findAll(), tableSales);
    }
    private void filter_btn_Cancel_SaleMouseEntered(java.awt.event.MouseEvent evt) {        filter_btn_Cancel_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltroEscuro.png")));
    }
    private void filter_btn_Cancel_SaleMouseExited(java.awt.event.MouseEvent evt) {        filter_btn_Cancel_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_CancelarFiltro.png")));
    }
    private void filter_btn_Apply_SaleMouseClicked(java.awt.event.MouseEvent evt) {        Date start = dateStart.getDate();
        Date end = dateEnd.getDate();
        
        try {
            Utils.updateTable(SaleDao.filterByPeriod(start, end), tableSales);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void filter_btn_Apply_SaleMouseEntered(java.awt.event.MouseEvent evt) {        filter_btn_Apply_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltroEscuro.png")));
    }
    private void filter_btn_Apply_SaleMouseExited(java.awt.event.MouseEvent evt) {        filter_btn_Apply_Sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_AplicarFiltro.png")));
    }
    private void tableSalesMouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("sale")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JTable table =(JTable) evt.getSource();
        java.awt.Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        table.setRowSelectionInterval(row, row);
        
        if (evt.getButton() == MouseEvent.BUTTON3) {
            evt = SwingUtilities.convertMouseEvent(evt.getComponent(), evt, this);
            
            int xPos = evt.getX();
            int yPos = evt.getY();
            
            popupSaleTable.show(this, xPos, yPos);
        }
        else if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            menuSaleInfoActionPerformed(null);
        }
    }
    private void iconeOcultar1MouseClicked(java.awt.event.MouseEvent evt) {        if (!hasPermission("homeinfo")) {
            JOptionPane.showMessageDialog(null, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        homeInfoVisibility = !homeInfoVisibility;
        refreshHomeData();
    }
    private void table_ProductsMouseClicked(java.awt.event.MouseEvent evt) {        JTable table =(JTable) evt.getSource();
        java.awt.Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        table.setRowSelectionInterval(row, row);
        
        if (evt.getButton() == MouseEvent.BUTTON3) {
            evt = SwingUtilities.convertMouseEvent(evt.getComponent(), evt, this);
            
            int xPos = evt.getX();
            int yPos = evt.getY();
            
            popupProductsTable.show(this, xPos, yPos);
        }
        
        else if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            btnAddProductActionPerformed(null);
        }
    }
    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {        if (!hasPermission("product")) {
            JOptionPane.showMessageDialog(this, PERMISSION_ERROR, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = table_Products.getSelectedRow();
        
        if (selectedRow > -1) {
            DefaultTableModel dtm = (DefaultTableModel) table_Products.getModel();
            Long id = (Long) dtm.getValueAt(selectedRow, 0);
            
            Product p = ProductDao.findById(id);
            
            Add_Product dialog = new Add_Product(this, true, p);
            dialog.setVisible(true);
            Utils.updateTable(ProductDao.findAll(), table_Products);
        }
    }
    private void HeadMousePressed(java.awt.event.MouseEvent evt) {        mouseX = evt.getX();
        mouseY = evt.getY();
    }
    private void HeadMouseDragged(java.awt.event.MouseEvent evt) {        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }
    private void menuSaleInfoActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableSales.getSelectedRow();
        
        if (row != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tableSales.getModel();
            Long id = (Long) dtm.getValueAt(row, 0);
            Sale sale = SaleDao.findById(id);
            
            SaleInfo dialog = new SaleInfo(this, true, sale);
            dialog.setVisible(true);
        }
    }
    private void btnChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {        Change_Password dialog = new Change_Password(this, true);
        dialog.setVisible(true);
    }
    private void btnExitSystemMouseClicked(java.awt.event.MouseEvent evt) {        int option = JOptionPane.showConfirmDialog(this, "Você tem certeza que quer sair?", 
                    "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            
        if (option != 0) return;
        
        new Login().setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

        private javax.swing.JLabel Address;
    private javax.swing.JLabel BirthDate;
    private javax.swing.JLabel CEP;
    private javax.swing.JLabel CPF;
    private javax.swing.JLabel CPFSeparator;
    private javax.swing.JPanel Card_Customers;
    private javax.swing.JPanel Card_Employees;
    private javax.swing.JPanel Card_Home;
    private javax.swing.JPanel Card_Products;
    private javax.swing.JPanel Card_Sales;
    private javax.swing.JPanel Card_Settings;
    private javax.swing.JLabel City;
    private javax.swing.JPanel CollectionCard;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Filter_Background;
    private javax.swing.JLabel Filter_BackgroundSale;
    private javax.swing.JPanel Head;
    private javax.swing.JLabel HouseNumber;
    private javax.swing.JLabel Job;
    private javax.swing.JPanel MaxMinClose;
    private javax.swing.JPanel Mid_Header;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Neighbourhood;
    private javax.swing.JPanel Panel_Employees;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel State;
    private javax.swing.JPanel bgButtonsHome;
    private javax.swing.JMenuItem btnAddProduct;
    private javax.swing.JLabel btnChangePassword;
    private javax.swing.JLabel btnDeleteEmployee;
    private javax.swing.JLabel btnEditCustomer;
    private javax.swing.JLabel btnEditEmployee;
    private javax.swing.JLabel btnExitSystem;
    private javax.swing.JLabel btnNewCustomer;
    private javax.swing.JLabel btnNewEmployee;
    private javax.swing.JLabel btnRemoveCustomer;
    private javax.swing.JLabel btnSearchCustomer;
    private javax.swing.JLabel btn_Close;
    private javax.swing.JLabel btn_DeleteSale;
    private javax.swing.JLabel btn_Filter;
    private javax.swing.JLabel btn_Filter_Sale;
    private javax.swing.JLabel btn_Max;
    private javax.swing.JLabel btn_Min;
    private javax.swing.JLabel btn_NewSale;
    private javax.swing.JLabel btn_SearchProducts;
    private javax.swing.JLabel btn_SearchSale;
    private javax.swing.JLabel btn_ShowHideMenu;
    private javax.swing.JLabel btn_addProduct;
    private javax.swing.JLabel btn_customers;
    private javax.swing.JLabel btn_editProduct;
    private javax.swing.JLabel btn_employees;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_products;
    private javax.swing.JLabel btn_removeProduct;
    private javax.swing.JLabel btn_sales;
    private javax.swing.JLabel btn_settings;
    private javax.swing.JLabel buscarCliente2;
    private javax.swing.JLabel buscarVenda2;
    private javax.swing.JTextField cSearchCustomer;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JLabel filter_btn_Apply;
    private javax.swing.JLabel filter_btn_Apply_Sale;
    private javax.swing.JLabel filter_btn_Cancel;
    private javax.swing.JLabel filter_btn_Cancel_Sale;
    private javax.swing.JComboBox<Object> filter_cb_Brand;
    private javax.swing.JComboBox<Object> filter_cb_Category;
    private javax.swing.JComboBox<Object> filter_cb_Color;
    private javax.swing.JComboBox<String> filter_cb_Size;
    private javax.swing.JLabel fundoFaturamento;
    private javax.swing.JLabel fundoReceita;
    private javax.swing.JLabel fundoTicket;
    private javax.swing.JLabel fundoVendas;
    private javax.swing.JLabel iconFaturamento;
    private javax.swing.JLabel iconReceita;
    private javax.swing.JLabel iconTicket;
    private javax.swing.JLabel iconVendas;
    private javax.swing.JLabel icon_customers;
    private javax.swing.JLabel icon_employees;
    private javax.swing.JLabel icon_home;
    private javax.swing.JLabel icon_products;
    private javax.swing.JLabel icon_sales;
    private javax.swing.JLabel icon_settings;
    private javax.swing.JLabel iconeOcultar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel lbl_FinalDate;
    private javax.swing.JLabel lbl_InitialDate;
    private javax.swing.JMenuItem menuSaleInfo;
    private javax.swing.JPanel menu_customers;
    private javax.swing.JPanel menu_employees;
    private javax.swing.JPanel menu_home;
    private javax.swing.JPanel menu_product;
    private javax.swing.JPanel menu_sale;
    private javax.swing.JPanel menu_settings;
    private javax.swing.JLabel novaVenda2;
    private javax.swing.JLabel novoCliente2;
    private javax.swing.JLabel novoProduto2;
    private javax.swing.JScrollPane pane_Employee;
    private javax.swing.JPanel panelInformacoes1;
    private javax.swing.JPanel pnFaturamento;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnReceita;
    private javax.swing.JPanel pnTicket;
    private javax.swing.JPanel pnVendas;
    private javax.swing.JPanel pnl_Close;
    private javax.swing.JPanel pnl_HeaderMenu;
    private javax.swing.JPanel pnl_IconMenu;
    private javax.swing.JPanel pnl_Max;
    private javax.swing.JPanel pnl_Min;
    private javax.swing.JPopupMenu popupProductsTable;
    private javax.swing.JPopupMenu popupSaleTable;
    private javax.swing.JTextField searchSale;
    private javax.swing.JTable tableCustomers;
    private javax.swing.JTable tableSales;
    private javax.swing.JTable table_Employees;
    private javax.swing.JTable table_Products;
    private javax.swing.JLabel txtBemVindo1;
    private javax.swing.JTextField txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeAddressNum;
    private javax.swing.JTextField txtEmployeeBirthDate;
    private javax.swing.JTextField txtEmployeeCEP01;
    private javax.swing.JTextField txtEmployeeCEP02;
    private javax.swing.JTextField txtEmployeeCPF;
    private javax.swing.JTextField txtEmployeeCity;
    private javax.swing.JTextField txtEmployeeEmail;
    private javax.swing.JTextField txtEmployeeJob;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtEmployeeNeigh;
    private javax.swing.JTextField txtEmployeePhone;
    private javax.swing.JTextField txtEmployeeState;
    private javax.swing.JLabel txtFaturamento;
    private javax.swing.JLabel txtFaturamentoValor;
    private javax.swing.JTextField txtProductsSearchField;
    private javax.swing.JLabel txtReceita;
    private javax.swing.JLabel txtReceitaValor;
    private javax.swing.JLabel txtTicket;
    private javax.swing.JLabel txtTicketValor;
    private javax.swing.JLabel txtTotalSales;
    private javax.swing.JLabel txtVendas;
    
}
