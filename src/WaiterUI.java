import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JList;

public class WaiterUI {

	private JFrame frame;
	Map<String, JPanel> tableMap;
	Map<String, ArrayList<String>> tabMap = new HashMap<String, ArrayList<String>>();
	
	private final JPanel table_layout = new JPanel();
	
	
	ArrayList<MenuItem> menu = new FileReader().getMenu();
	ArrayList<MenuItem> apps = new ArrayList<MenuItem>();
	ArrayList<MenuItem> saladsSoups = new ArrayList<MenuItem>();
	ArrayList<MenuItem> entrees = new ArrayList<MenuItem>();
	ArrayList<MenuItem> favs = new ArrayList<MenuItem>();
	ArrayList<MenuItem> sandwhiches = new ArrayList<MenuItem>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterUI window = new WaiterUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WaiterUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/////////////////////////////////
		/// Cards ///////////////////////
		/////////////////////////////////

		
		JPanel sidebar = new JPanel();
		sidebar.setBackground(Color.GRAY);
		sidebar.setBounds(873, 0, 311, 761);
		frame.getContentPane().add(sidebar);
		sidebar.setLayout(new CardLayout(0, 0));
		
		
		// Menu 1A
		JPanel tableOps = new JPanel();
		tableOps.setBackground(Color.GRAY);
		sidebar.add(tableOps, "tableOptions");
		GridBagLayout gbl_tableOps = new GridBagLayout();
		gbl_tableOps.columnWidths = new int[]{311, 0};
		gbl_tableOps.rowHeights = new int[] {80, 65, 500, 65};
		gbl_tableOps.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tableOps.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		tableOps.setLayout(gbl_tableOps);
		
		JPanel opsTitle = new JPanel();
		opsTitle.setBackground(Color.GRAY);
		GridBagConstraints gbc_opsTitle = new GridBagConstraints();
		gbc_opsTitle.insets = new Insets(0, 0, 5, 0);
		gbc_opsTitle.fill = GridBagConstraints.BOTH;
		gbc_opsTitle.gridx = 0;
		gbc_opsTitle.gridy = 0;
		tableOps.add(opsTitle, gbc_opsTitle);
		
		JLabel labelOpsCurrentTable = new JLabel("Table: 1A");
		labelOpsCurrentTable.setHorizontalAlignment(SwingConstants.CENTER);
		labelOpsCurrentTable.setFont(new Font("Tahoma", Font.BOLD, 50));
		opsTitle.add(labelOpsCurrentTable);
		
		JPanel opsStatus = new JPanel();
		
		opsStatus.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		opsStatus.setBackground(Color.GRAY);
		GridBagConstraints gbc_opsStatus = new GridBagConstraints();
		gbc_opsStatus.insets = new Insets(0, 0, 5, 0);
		gbc_opsStatus.fill = GridBagConstraints.BOTH;
		gbc_opsStatus.gridx = 0;
		gbc_opsStatus.gridy = 1;
		tableOps.add(opsStatus, gbc_opsStatus);
		GridBagLayout gbl_opsStatus = new GridBagLayout();
		gbl_opsStatus.columnWidths = new int[] {75, 235};
		gbl_opsStatus.rowHeights = new int[] {65};
		gbl_opsStatus.columnWeights = new double[]{1.0, 0.0};
		gbl_opsStatus.rowWeights = new double[]{1.0};
		opsStatus.setLayout(gbl_opsStatus);
		
		JPanel opsStatusColor = new JPanel();
		opsStatusColor.setBackground(Color.GREEN);
		GridBagConstraints gbc_opsStatusColor = new GridBagConstraints();
		gbc_opsStatusColor.insets = new Insets(15, 15, 15, 15);
		gbc_opsStatusColor.fill = GridBagConstraints.BOTH;
		gbc_opsStatusColor.gridx = 0;
		gbc_opsStatusColor.gridy = 0;
		opsStatus.add(opsStatusColor, gbc_opsStatusColor);
		
		JPanel opsStatusMsg = new JPanel();
		opsStatusMsg.setBackground(Color.GRAY);
		GridBagConstraints gbc_opsStatusMsg = new GridBagConstraints();
		gbc_opsStatusMsg.insets = new Insets(0, 10, 0, 0);
		gbc_opsStatusMsg.fill = GridBagConstraints.BOTH;
		gbc_opsStatusMsg.gridx = 1;
		gbc_opsStatusMsg.gridy = 0;
		opsStatus.add(opsStatusMsg, gbc_opsStatusMsg);
		opsStatusMsg.setLayout(new BorderLayout(0, 0));
		
		JLabel labelOpsStatusMsg = new JLabel("Status: Dirty");
		labelOpsStatusMsg.setFont(new Font("Tahoma", Font.BOLD, 24));
		opsStatusMsg.add(labelOpsStatusMsg);
		
		JPanel opsCurrentTab = new JPanel();
		opsCurrentTab.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_opsCurrentTab = new GridBagConstraints();
		gbc_opsCurrentTab.insets = new Insets(12, 12, 12, 12);
		gbc_opsCurrentTab.fill = GridBagConstraints.BOTH;
		gbc_opsCurrentTab.gridx = 0;
		gbc_opsCurrentTab.gridy = 2;
		tableOps.add(opsCurrentTab, gbc_opsCurrentTab);
		opsCurrentTab.setLayout(new BorderLayout(0, 0));
		
		JList<String> currentTabList = new JList<String>(new DefaultListModel<String>());
		currentTabList.setBackground(Color.LIGHT_GRAY);
		currentTabList.setFont(new Font("Tahoma", Font.BOLD, 20));
		opsCurrentTab.add(currentTabList, BorderLayout.WEST);
		
		JPanel opsAddOrder = new JPanel();
		opsAddOrder.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		opsAddOrder.setBackground(Color.GRAY);
		GridBagConstraints gbc_opsAddOrder = new GridBagConstraints();
		gbc_opsAddOrder.fill = GridBagConstraints.BOTH;
		gbc_opsAddOrder.gridx = 0;
		gbc_opsAddOrder.gridy = 3;
		tableOps.add(opsAddOrder, gbc_opsAddOrder);
		opsAddOrder.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAddOrder1A = new JLabel("Add Order");
		labelAddOrder1A.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelAddOrder1A.setHorizontalAlignment(SwingConstants.CENTER);
		opsAddOrder.add(labelAddOrder1A);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.GRAY);
		sidebar.add(panelMenu, "menuTab");
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{311, 0};
		gbl_panelMenu.rowHeights = new int[] {95, 95, 600, 30};
		gbl_panelMenu.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMenu.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		panelMenu.setLayout(gbl_panelMenu);
		
		JPanel opsTitle_1 = new JPanel();
		opsTitle_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_opsTitle_1 = new GridBagConstraints();
		gbc_opsTitle_1.fill = GridBagConstraints.BOTH;
		gbc_opsTitle_1.insets = new Insets(0, 0, 5, 0);
		gbc_opsTitle_1.gridx = 0;
		gbc_opsTitle_1.gridy = 0;
		panelMenu.add(opsTitle_1, gbc_opsTitle_1);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 50));
		opsTitle_1.add(lblMenu);
		
		JPanel panelCatSelect = new JPanel();
		panelCatSelect.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCatSelect.setBackground(Color.GRAY);
		GridBagConstraints gbc_panelCatSelect = new GridBagConstraints();
		gbc_panelCatSelect.fill = GridBagConstraints.BOTH;
		gbc_panelCatSelect.insets = new Insets(0, 0, 5, 0);
		gbc_panelCatSelect.gridx = 0;
		gbc_panelCatSelect.gridy = 1;
		panelMenu.add(panelCatSelect, gbc_panelCatSelect);
		GridBagLayout gbl_panelCatSelect = new GridBagLayout();
		gbl_panelCatSelect.columnWidths = new int[] {62, 62, 62, 62, 62};
		gbl_panelCatSelect.rowHeights = new int[]{65, 0, 0};
		gbl_panelCatSelect.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0};
		gbl_panelCatSelect.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelCatSelect.setLayout(gbl_panelCatSelect);
		
		JPanel selectCatApps = new JPanel();
		selectCatApps.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_selectCatApps = new GridBagConstraints();
		gbc_selectCatApps.fill = GridBagConstraints.BOTH;
		gbc_selectCatApps.insets = new Insets(5, 5, 5, 5);
		gbc_selectCatApps.gridx = 0;
		gbc_selectCatApps.gridy = 0;
		panelCatSelect.add(selectCatApps, gbc_selectCatApps);
		selectCatApps.setLayout(new BorderLayout(0, 0));
		
		JLabel labelApps = new JLabel("APPS");
		labelApps.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelApps.setHorizontalAlignment(SwingConstants.CENTER);
		selectCatApps.add(labelApps);
		
		JPanel selectCatSoupsSalads = new JPanel();
		selectCatSoupsSalads.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_selectCatSoupsSalads = new GridBagConstraints();
		gbc_selectCatSoupsSalads.insets = new Insets(5, 5, 5, 5);
		gbc_selectCatSoupsSalads.fill = GridBagConstraints.BOTH;
		gbc_selectCatSoupsSalads.gridx = 1;
		gbc_selectCatSoupsSalads.gridy = 0;
		panelCatSelect.add(selectCatSoupsSalads, gbc_selectCatSoupsSalads);
		selectCatSoupsSalads.setLayout(new BorderLayout(0, 0));
		
		JLabel labelSoupsSalads = new JLabel("SS");
		labelSoupsSalads.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSoupsSalads.setHorizontalAlignment(SwingConstants.CENTER);
		selectCatSoupsSalads.add(labelSoupsSalads, BorderLayout.CENTER);
		
		JPanel selectCatEntrees = new JPanel();
		selectCatEntrees.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_selectCatEntrees = new GridBagConstraints();
		gbc_selectCatEntrees.insets = new Insets(5, 5, 5, 5);
		gbc_selectCatEntrees.fill = GridBagConstraints.BOTH;
		gbc_selectCatEntrees.gridx = 2;
		gbc_selectCatEntrees.gridy = 0;
		panelCatSelect.add(selectCatEntrees, gbc_selectCatEntrees);
		selectCatEntrees.setLayout(new BorderLayout(0, 0));
		
		JLabel labelEntrees = new JLabel("EN");
		labelEntrees.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEntrees.setHorizontalAlignment(SwingConstants.CENTER);
		selectCatEntrees.add(labelEntrees, BorderLayout.CENTER);
		
		JPanel SelectCatFavs = new JPanel();
		SelectCatFavs.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_SelectCatFavs = new GridBagConstraints();
		gbc_SelectCatFavs.insets = new Insets(5, 5, 5, 5);
		gbc_SelectCatFavs.fill = GridBagConstraints.BOTH;
		gbc_SelectCatFavs.gridx = 3;
		gbc_SelectCatFavs.gridy = 0;
		panelCatSelect.add(SelectCatFavs, gbc_SelectCatFavs);
		SelectCatFavs.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("FAVS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		SelectCatFavs.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel SelectCatSandwhichs = new JPanel();
		SelectCatSandwhichs.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_SelectCatSandwhichs = new GridBagConstraints();
		gbc_SelectCatSandwhichs.insets = new Insets(5, 5, 5, 5);
		gbc_SelectCatSandwhichs.fill = GridBagConstraints.BOTH;
		gbc_SelectCatSandwhichs.gridx = 4;
		gbc_SelectCatSandwhichs.gridy = 0;
		panelCatSelect.add(SelectCatSandwhichs, gbc_SelectCatSandwhichs);
		SelectCatSandwhichs.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("SW");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		SelectCatSandwhichs.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel menuCurrentCat = new JPanel();
		menuCurrentCat.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_menuCurrentCat = new GridBagConstraints();
		gbc_menuCurrentCat.fill = GridBagConstraints.BOTH;
		gbc_menuCurrentCat.insets = new Insets(12, 12, 12, 12);
		gbc_menuCurrentCat.gridx = 0;
		gbc_menuCurrentCat.gridy = 2;
		panelMenu.add(menuCurrentCat, gbc_menuCurrentCat);
		menuCurrentCat.setLayout(new CardLayout(0, 0));
		
		JPanel catApps = new JPanel();
		catApps.setBackground(Color.LIGHT_GRAY);
		menuCurrentCat.add(catApps, "menu_APPS");
		catApps.setLayout(new BorderLayout(0, 0));
		
		JLabel titleCatApps = new JLabel("Appetizers");
		titleCatApps.setHorizontalAlignment(SwingConstants.CENTER);
		titleCatApps.setFont(new Font("Tahoma", Font.BOLD, 20));
		catApps.add(titleCatApps, BorderLayout.NORTH);
		
		JList<String> menuListApps = new JList<String>(new DefaultListModel<String>());
		menuListApps.setBackground(Color.LIGHT_GRAY);
		catApps.add(menuListApps, BorderLayout.CENTER);
		
		JPanel catSS = new JPanel();
		catSS.setBackground(Color.LIGHT_GRAY);
		menuCurrentCat.add(catSS, "menu_SS");
		catSS.setLayout(new BorderLayout(0, 0));
		
		JLabel titleCatSS = new JLabel("Soups/Salads");
		titleCatSS.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleCatSS.setHorizontalAlignment(SwingConstants.CENTER);
		catSS.add(titleCatSS, BorderLayout.NORTH);
		

		JList<String> menuListSS = new JList<String>(new DefaultListModel<String>());
		menuListSS.setBackground(Color.LIGHT_GRAY);
		menuListSS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		catSS.add(menuListSS, BorderLayout.CENTER);
		
		JPanel catEN = new JPanel();
		catEN.setBackground(Color.LIGHT_GRAY);
		menuCurrentCat.add(catEN, "menu_EN");
		catEN.setLayout(new BorderLayout(0, 0));
		
		JLabel titleCatEn = new JLabel("Entrees");
		titleCatEn.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleCatEn.setHorizontalAlignment(SwingConstants.CENTER);
		catEN.add(titleCatEn, BorderLayout.NORTH);
		

		JList<String> menuListEN = new JList<String>(new DefaultListModel<String>());
		menuListEN.setBackground(Color.LIGHT_GRAY);
		catEN.add(menuListEN, BorderLayout.CENTER);
		
		JPanel catFAVS = new JPanel();
		catFAVS.setBackground(Color.LIGHT_GRAY);
		menuCurrentCat.add(catFAVS, "menu_FAVS");
		catFAVS.setLayout(new BorderLayout(0, 0));
		
		JLabel titleCatFAVS = new JLabel("Favorites");
		titleCatFAVS.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleCatFAVS.setHorizontalAlignment(SwingConstants.CENTER);
		catFAVS.add(titleCatFAVS, BorderLayout.NORTH);
		

		JList<String> menuListFAVS = new JList<String>(new DefaultListModel<String>());
		menuListFAVS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuListFAVS.setBackground(Color.LIGHT_GRAY);
		catFAVS.add(menuListFAVS, BorderLayout.CENTER);
		
		JPanel catSW = new JPanel();
		catSW.setBackground(Color.LIGHT_GRAY);
		menuCurrentCat.add(catSW, "menu_SW");
		catSW.setLayout(new BorderLayout(0, 0));
		
		JLabel titleCatSW = new JLabel("Sandwhiches");
		titleCatSW.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleCatSW.setHorizontalAlignment(SwingConstants.CENTER);
		catSW.add(titleCatSW, BorderLayout.NORTH);
		

		JList<String> menuListSW = new JList<String>(new DefaultListModel<String>());
		menuListSW.setBackground(Color.LIGHT_GRAY);
		catSW.add(menuListSW, BorderLayout.CENTER);
		
		/////////////////////////////////
		/////////////////////////////////
		/////////////////////////////////
		
	
		
		JPanel header = new JPanel();
		header.setBackground(Color.LIGHT_GRAY);
		header.setBounds(0, 0, 874, 50);
		frame.getContentPane().add(header);
		header.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelName = new JPanel();
		panelName.setBackground(Color.LIGHT_GRAY);
		header.add(panelName);
		panelName.setLayout(new BorderLayout(0, 0));
		
		JLabel labelPanelName = new JLabel(" Name: Rosa Smith");
		labelPanelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanelName.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelName.add(labelPanelName);
		
		JPanel paneIID = new JPanel();
		paneIID.setBackground(Color.LIGHT_GRAY);
		header.add(paneIID);
		paneIID.setLayout(new BorderLayout(0, 0));
		
		JLabel labelPanelID = new JLabel("ID: 01");
		labelPanelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanelID.setFont(new Font("Tahoma", Font.BOLD, 18));
		paneIID.add(labelPanelID);
		
		JPanel panelTime = new JPanel();
		panelTime.setBackground(Color.LIGHT_GRAY);
		header.add(panelTime);
		panelTime.setLayout(new BorderLayout(0, 0));
		
		JLabel labelPanelTime = new JLabel("3:52PM 4/30/2021");
		labelPanelTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanelTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelTime.add(labelPanelTime);
		table_layout.setBounds(0, 50, 874, 711);
		frame.getContentPane().add(table_layout);
		GridBagLayout gbl_table_layout = new GridBagLayout();
		gbl_table_layout.columnWidths = new int[]{874, 0};
		gbl_table_layout.rowHeights = new int[] {118, 118, 118, 118, 118, 32};
		gbl_table_layout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_table_layout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0};
		table_layout.setLayout(gbl_table_layout);
		
		JPanel row1 = new JPanel();
		GridBagConstraints gbc_row1 = new GridBagConstraints();
		gbc_row1.fill = GridBagConstraints.BOTH;
		gbc_row1.gridx = 0;
		gbc_row1.gridy = 0;
		table_layout.add(row1, gbc_row1);
		GridBagLayout gbl_row1 = new GridBagLayout();
		gbl_row1.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row1.rowHeights = new int[] {136};
		gbl_row1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row1.rowWeights = new double[]{0.0};
		row1.setLayout(gbl_row1);
		
		JPanel key1 = new JPanel();
		GridBagConstraints gbc_key1 = new GridBagConstraints();
		gbc_key1.fill = GridBagConstraints.BOTH;
		gbc_key1.insets = new Insets(0, 0, 0, 5);
		gbc_key1.gridx = 0;
		gbc_key1.gridy = 0;
		row1.add(key1, gbc_key1);
		key1.setLayout(new BorderLayout(0, 0));
		
		JLabel labelKey1 = new JLabel("1");
		labelKey1.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKey1.setHorizontalAlignment(SwingConstants.CENTER);
		key1.add(labelKey1, BorderLayout.CENTER);
		
		JPanel table1A = new JPanel();
		table1A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1A.setBackground(Color.GREEN);
		table1A.setLayout(null);
		GridBagConstraints gbc_table1A = new GridBagConstraints();
		gbc_table1A.fill = GridBagConstraints.BOTH;
		gbc_table1A.insets = new Insets(33, 25, 33, 25);
		gbc_table1A.gridx = 1;
		gbc_table1A.gridy = 0;
		row1.add(table1A, gbc_table1A);
		
		JPanel table1B = new JPanel();
		table1B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1B.setBackground(Color.GREEN);
		table1B.setLayout(null);
		GridBagConstraints gbc_table1B = new GridBagConstraints();
		gbc_table1B.fill = GridBagConstraints.BOTH;
		gbc_table1B.insets = new Insets(33, 25, 33, 25);
		gbc_table1B.gridx = 2;
		gbc_table1B.gridy = 0;
		row1.add(table1B, gbc_table1B);
		
		JPanel table1C = new JPanel();
		table1C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1C.setBackground(Color.GREEN);
		table1C.setLayout(null);
		GridBagConstraints gbc_table1C = new GridBagConstraints();
		gbc_table1C.fill = GridBagConstraints.BOTH;
		gbc_table1C.insets = new Insets(33, 25, 33, 25);
		gbc_table1C.gridx = 3;
		gbc_table1C.gridy = 0;
		row1.add(table1C, gbc_table1C);
		
		JPanel table1D = new JPanel();
		table1D.setBackground(Color.GREEN);
		table1D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1D.setLayout(null);
		GridBagConstraints gbc_table1D = new GridBagConstraints();
		gbc_table1D.fill = GridBagConstraints.BOTH;
		gbc_table1D.insets = new Insets(33, 25, 33, 25);
		gbc_table1D.gridx = 4;
		gbc_table1D.gridy = 0;
		row1.add(table1D, gbc_table1D);
		
		JPanel table1E = new JPanel();
		table1E.setBackground(Color.GREEN);
		table1E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1E.setLayout(null);
		GridBagConstraints gbc_table1E = new GridBagConstraints();
		gbc_table1E.fill = GridBagConstraints.BOTH;
		gbc_table1E.insets = new Insets(33, 25, 33, 25);
		gbc_table1E.gridx = 5;
		gbc_table1E.gridy = 0;
		row1.add(table1E, gbc_table1E);
		
		JPanel table1F = new JPanel();
		table1F.setBackground(Color.GREEN);
		table1F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table1F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table1F.setLayout(null);
		GridBagConstraints gbc_table1F = new GridBagConstraints();
		gbc_table1F.insets = new Insets(33, 25, 33, 25);
		gbc_table1F.fill = GridBagConstraints.BOTH;
		gbc_table1F.gridx = 6;
		gbc_table1F.gridy = 0;
		row1.add(table1F, gbc_table1F);
		
		
		// Row 2
		
		
		JPanel row2 = new JPanel();
		GridBagConstraints gbc_row2 = new GridBagConstraints();
		gbc_row2.fill = GridBagConstraints.BOTH;
		gbc_row2.gridx = 0;
		gbc_row2.gridy = 1;
		table_layout.add(row2, gbc_row2);
		GridBagLayout gbl_row2 = new GridBagLayout();
		gbl_row2.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row2.rowHeights = new int[] {136};
		gbl_row2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row2.rowWeights = new double[]{0.0};
		row2.setLayout(gbl_row2);
		
		JPanel key2 = new JPanel();
		GridBagConstraints gbc_key2 = new GridBagConstraints();
		gbc_key2.fill = GridBagConstraints.BOTH;
		gbc_key2.insets = new Insets(0, 0, 0, 5);
		gbc_key2.gridx = 0;
		gbc_key2.gridy = 0;
		row2.add(key2, gbc_key2);
		key2.setLayout(new BorderLayout(0, 0));
		
		JLabel labelKey2 = new JLabel("2");
		labelKey2.setHorizontalAlignment(SwingConstants.CENTER);
		labelKey2.setFont(new Font("Tahoma", Font.BOLD, 20));
		key2.add(labelKey2, BorderLayout.CENTER);
		
		JPanel table2A = new JPanel();
		table2A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2A.setLayout(null);
		table2A.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2A = new GridBagConstraints();
		gbc_table2A.fill = GridBagConstraints.BOTH;
		gbc_table2A.insets = new Insets(33, 25, 33, 25);
		gbc_table2A.gridx = 1;
		gbc_table2A.gridy = 0;
		row2.add(table2A, gbc_table2A);
		
		JPanel table2B = new JPanel();
		table2B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2B.setLayout(null);
		table2B.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2B = new GridBagConstraints();
		gbc_table2B.fill = GridBagConstraints.BOTH;
		gbc_table2B.insets = new Insets(33, 25, 33, 25);
		gbc_table2B.gridx = 2;
		gbc_table2B.gridy = 0;
		row2.add(table2B, gbc_table2B);
		
		JPanel table2C = new JPanel();
		table2C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2C.setLayout(null);
		table2C.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2C = new GridBagConstraints();
		gbc_table2C.fill = GridBagConstraints.BOTH;
		gbc_table2C.insets = new Insets(33, 25, 33, 25);
		gbc_table2C.gridx = 3;
		gbc_table2C.gridy = 0;
		row2.add(table2C, gbc_table2C);
		
		JPanel table2D = new JPanel();
		table2D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2D.setLayout(null);
		table2D.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2D = new GridBagConstraints();
		gbc_table2D.fill = GridBagConstraints.BOTH;
		gbc_table2D.insets = new Insets(33, 25, 33, 25);
		gbc_table2D.gridx = 4;
		gbc_table2D.gridy = 0;
		row2.add(table2D, gbc_table2D);
		
		JPanel table2E = new JPanel();
		table2E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2E.setLayout(null);
		table2E.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2E = new GridBagConstraints();
		gbc_table2E.fill = GridBagConstraints.BOTH;
		gbc_table2E.insets = new Insets(33, 25, 33, 25);
		gbc_table2E.gridx = 5;
		gbc_table2E.gridy = 0;
		row2.add(table2E, gbc_table2E);
		
		JPanel table2F = new JPanel();
		table2F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table2F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table2F.setLayout(null);
		table2F.setBackground(Color.GREEN);
		GridBagConstraints gbc_table2F = new GridBagConstraints();
		gbc_table2F.insets = new Insets(33, 25, 33, 25);
		gbc_table2F.fill = GridBagConstraints.BOTH;
		gbc_table2F.gridx = 6;
		gbc_table2F.gridy = 0;
		row2.add(table2F, gbc_table2F);
		
		JPanel row3 = new JPanel();
		GridBagConstraints gbc_row3 = new GridBagConstraints();
		gbc_row3.fill = GridBagConstraints.BOTH;
		gbc_row3.gridx = 0;
		gbc_row3.gridy = 2;
		table_layout.add(row3, gbc_row3);
		GridBagLayout gbl_row3 = new GridBagLayout();
		gbl_row3.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row3.rowHeights = new int[] {136};
		gbl_row3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row3.rowWeights = new double[]{0.0};
		row3.setLayout(gbl_row3);
		
		JPanel key3 = new JPanel();
		GridBagConstraints gbc_key3 = new GridBagConstraints();
		gbc_key3.fill = GridBagConstraints.BOTH;
		gbc_key3.insets = new Insets(0, 0, 0, 5);
		gbc_key3.gridx = 0;
		gbc_key3.gridy = 0;
		row3.add(key3, gbc_key3);
		key3.setLayout(new BorderLayout(0, 0));
		
		JLabel labelKey3 = new JLabel("3");
		labelKey3.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKey3.setHorizontalAlignment(SwingConstants.CENTER);
		key3.add(labelKey3, BorderLayout.CENTER);
		
		JPanel table3A = new JPanel();
		table3A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3A.setLayout(null);
		table3A.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3A = new GridBagConstraints();
		gbc_table3A.fill = GridBagConstraints.BOTH;
		gbc_table3A.insets = new Insets(33, 25, 33, 25);
		gbc_table3A.gridx = 1;
		gbc_table3A.gridy = 0;
		row3.add(table3A, gbc_table3A);
		
		JPanel table3B = new JPanel();
		table3B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3B.setLayout(null);
		table3B.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3B = new GridBagConstraints();
		gbc_table3B.fill = GridBagConstraints.BOTH;
		gbc_table3B.insets = new Insets(33, 25, 33, 25);
		gbc_table3B.gridx = 2;
		gbc_table3B.gridy = 0;
		row3.add(table3B, gbc_table3B);
		
		JPanel table3C = new JPanel();
		table3C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3C.setLayout(null);
		table3C.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3C = new GridBagConstraints();
		gbc_table3C.fill = GridBagConstraints.BOTH;
		gbc_table3C.insets = new Insets(33, 25, 33, 25);
		gbc_table3C.gridx = 3;
		gbc_table3C.gridy = 0;
		row3.add(table3C, gbc_table3C);
		
		JPanel table3D = new JPanel();
		table3D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3D.setLayout(null);
		table3D.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3D = new GridBagConstraints();
		gbc_table3D.fill = GridBagConstraints.BOTH;
		gbc_table3D.insets = new Insets(33, 25, 33, 25);
		gbc_table3D.gridx = 4;
		gbc_table3D.gridy = 0;
		row3.add(table3D, gbc_table3D);
		
		JPanel table3E = new JPanel();
		table3E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3E.setLayout(null);
		table3E.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3E = new GridBagConstraints();
		gbc_table3E.fill = GridBagConstraints.BOTH;
		gbc_table3E.insets = new Insets(33, 25, 33, 25);
		gbc_table3E.gridx = 5;
		gbc_table3E.gridy = 0;
		row3.add(table3E, gbc_table3E);
		
		JPanel table3F = new JPanel();
		table3F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table3F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table3F.setLayout(null);
		table3F.setBackground(Color.GREEN);
		GridBagConstraints gbc_table3F = new GridBagConstraints();
		gbc_table3F.insets = new Insets(33, 25, 33, 25);
		gbc_table3F.fill = GridBagConstraints.BOTH;
		gbc_table3F.gridx = 6;
		gbc_table3F.gridy = 0;
		row3.add(table3F, gbc_table3F);
		
		JPanel row4 = new JPanel();
		GridBagConstraints gbc_row4 = new GridBagConstraints();
		gbc_row4.fill = GridBagConstraints.BOTH;
		gbc_row4.gridx = 0;
		gbc_row4.gridy = 3;
		table_layout.add(row4, gbc_row4);
		GridBagLayout gbl_row4 = new GridBagLayout();
		gbl_row4.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row4.rowHeights = new int[] {136};
		gbl_row4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row4.rowWeights = new double[]{0.0};
		row4.setLayout(gbl_row4);
		
		JPanel key4 = new JPanel();
		GridBagConstraints gbc_key4 = new GridBagConstraints();
		gbc_key4.fill = GridBagConstraints.BOTH;
		gbc_key4.insets = new Insets(0, 0, 0, 5);
		gbc_key4.gridx = 0;
		gbc_key4.gridy = 0;
		row4.add(key4, gbc_key4);
		key4.setLayout(new BorderLayout(0, 0));
		
		JLabel labelKey4 = new JLabel("4");
		labelKey4.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKey4.setHorizontalAlignment(SwingConstants.CENTER);
		key4.add(labelKey4, BorderLayout.CENTER);
		
		JPanel table4A = new JPanel();
		table4A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4A.setLayout(null);
		table4A.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4A = new GridBagConstraints();
		gbc_table4A.fill = GridBagConstraints.BOTH;
		gbc_table4A.insets = new Insets(33, 25, 33, 25);
		gbc_table4A.gridx = 1;
		gbc_table4A.gridy = 0;
		row4.add(table4A, gbc_table4A);
		
		JPanel table4B = new JPanel();
		table4B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4B.setLayout(null);
		table4B.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4B = new GridBagConstraints();
		gbc_table4B.fill = GridBagConstraints.BOTH;
		gbc_table4B.insets = new Insets(33, 25, 33, 25);
		gbc_table4B.gridx = 2;
		gbc_table4B.gridy = 0;
		row4.add(table4B, gbc_table4B);
		
		JPanel table4C = new JPanel();
		table4C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4C.setLayout(null);
		table4C.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4C = new GridBagConstraints();
		gbc_table4C.fill = GridBagConstraints.BOTH;
		gbc_table4C.insets = new Insets(33, 25, 33, 25);
		gbc_table4C.gridx = 3;
		gbc_table4C.gridy = 0;
		row4.add(table4C, gbc_table4C);
		
		JPanel table4D = new JPanel();
		table4D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4D.setLayout(null);
		table4D.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4D = new GridBagConstraints();
		gbc_table4D.fill = GridBagConstraints.BOTH;
		gbc_table4D.insets = new Insets(33, 25, 33, 25);
		gbc_table4D.gridx = 4;
		gbc_table4D.gridy = 0;
		row4.add(table4D, gbc_table4D);
		
		JPanel table4E = new JPanel();
		table4E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4E.setLayout(null);
		table4E.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4E = new GridBagConstraints();
		gbc_table4E.fill = GridBagConstraints.BOTH;
		gbc_table4E.insets = new Insets(33, 25, 33, 25);
		gbc_table4E.gridx = 5;
		gbc_table4E.gridy = 0;
		row4.add(table4E, gbc_table4E);
		
		JPanel table4F = new JPanel();
		table4F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table4F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table4F.setLayout(null);
		table4F.setBackground(Color.GREEN);
		GridBagConstraints gbc_table4F = new GridBagConstraints();
		gbc_table4F.insets = new Insets(33, 25, 33, 25);
		gbc_table4F.fill = GridBagConstraints.BOTH;
		gbc_table4F.gridx = 6;
		gbc_table4F.gridy = 0;
		row4.add(table4F, gbc_table4F);
		
		JPanel row5 = new JPanel();
		GridBagConstraints gbc_row5 = new GridBagConstraints();
		gbc_row5.fill = GridBagConstraints.BOTH;
		gbc_row5.gridx = 0;
		gbc_row5.gridy = 4;
		table_layout.add(row5, gbc_row5);
		GridBagLayout gbl_row5 = new GridBagLayout();
		gbl_row5.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row5.rowHeights = new int[] {136};
		gbl_row5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row5.rowWeights = new double[]{0.0};
		row5.setLayout(gbl_row5);
		
		JPanel key5 = new JPanel();
		GridBagConstraints gbc_key5 = new GridBagConstraints();
		gbc_key5.fill = GridBagConstraints.BOTH;
		gbc_key5.insets = new Insets(0, 0, 0, 5);
		gbc_key5.gridx = 0;
		gbc_key5.gridy = 0;
		row5.add(key5, gbc_key5);
		key5.setLayout(new BorderLayout(0, 0));
		
		JLabel labelkey5 = new JLabel("5");
		labelkey5.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelkey5.setHorizontalAlignment(SwingConstants.CENTER);
		key5.add(labelkey5, BorderLayout.CENTER);
		
		JPanel table5A = new JPanel();
		table5A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5A.setLayout(null);
		table5A.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5A = new GridBagConstraints();
		gbc_table5A.fill = GridBagConstraints.BOTH;
		gbc_table5A.insets = new Insets(33, 25, 33, 25);
		gbc_table5A.gridx = 1;
		gbc_table5A.gridy = 0;
		row5.add(table5A, gbc_table5A);
		
		JPanel table5B = new JPanel();
		table5B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5B.setLayout(null);
		table5B.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5B = new GridBagConstraints();
		gbc_table5B.fill = GridBagConstraints.BOTH;
		gbc_table5B.insets = new Insets(33, 25, 33, 25);
		gbc_table5B.gridx = 2;
		gbc_table5B.gridy = 0;
		row5.add(table5B, gbc_table5B);
		
		JPanel table5C = new JPanel();
		table5C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5C.setLayout(null);
		table5C.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5C = new GridBagConstraints();
		gbc_table5C.fill = GridBagConstraints.BOTH;
		gbc_table5C.insets = new Insets(33, 25, 33, 25);
		gbc_table5C.gridx = 3;
		gbc_table5C.gridy = 0;
		row5.add(table5C, gbc_table5C);
		
		JPanel table5D = new JPanel();
		table5D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5D.setLayout(null);
		table5D.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5D = new GridBagConstraints();
		gbc_table5D.fill = GridBagConstraints.BOTH;
		gbc_table5D.insets = new Insets(33, 25, 33, 25);
		gbc_table5D.gridx = 4;
		gbc_table5D.gridy = 0;
		row5.add(table5D, gbc_table5D);
		
		JPanel table5E = new JPanel();
		table5E.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5E.setLayout(null);
		table5E.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5E = new GridBagConstraints();
		gbc_table5E.fill = GridBagConstraints.BOTH;
		gbc_table5E.insets = new Insets(33, 25, 33, 25);
		gbc_table5E.gridx = 5;
		gbc_table5E.gridy = 0;
		row5.add(table5E, gbc_table5E);
		
		JPanel table5F = new JPanel();
		table5F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSideBar(table5F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList, sidebar);
			}
		});
		table5F.setLayout(null);
		table5F.setBackground(Color.GREEN);
		GridBagConstraints gbc_table5F = new GridBagConstraints();
		gbc_table5F.insets = new Insets(33, 25, 33, 25);
		gbc_table5F.fill = GridBagConstraints.BOTH;
		gbc_table5F.gridx = 6;
		gbc_table5F.gridy = 0;
		row5.add(table5F, gbc_table5F);
		
		//
		
		//
		
		JPanel row6 = new JPanel();
		GridBagConstraints gbc_row6 = new GridBagConstraints();
		gbc_row6.fill = GridBagConstraints.BOTH;
		gbc_row6.gridx = 0;
		gbc_row6.gridy = 5;
		table_layout.add(row6, gbc_row6);
		GridBagLayout gbl_row6 = new GridBagLayout();
		gbl_row6.columnWidths = new int[] {32, 124, 124, 124, 124, 124, 124};
		gbl_row6.rowHeights = new int[] {32, 0};
		gbl_row6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_row6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		row6.setLayout(gbl_row6);
		
		JPanel blank = new JPanel();
		GridBagConstraints gbc_blank = new GridBagConstraints();
		gbc_blank.fill = GridBagConstraints.BOTH;
		gbc_blank.insets = new Insets(0, 0, 0, 5);
		gbc_blank.gridx = 0;
		gbc_blank.gridy = 0;
		row6.add(blank, gbc_blank);
		blank.setLayout(new BorderLayout(0, 0));
		
		JLabel labelKeyA = new JLabel("A");
		labelKeyA.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKeyA.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelKeyA = new GridBagConstraints();
		gbc_labelKeyA.insets = new Insets(0, 0, 0, 5);
		gbc_labelKeyA.gridx = 1;
		gbc_labelKeyA.gridy = 0;
		row6.add(labelKeyA, gbc_labelKeyA);
		
		JLabel labelKeyB = new JLabel("B");
		labelKeyB.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKeyB.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelKeyB = new GridBagConstraints();
		gbc_labelKeyB.insets = new Insets(0, 0, 0, 5);
		gbc_labelKeyB.gridx = 2;
		gbc_labelKeyB.gridy = 0;
		row6.add(labelKeyB, gbc_labelKeyB);
		
		JLabel labelKeyC = new JLabel("C");
		labelKeyC.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKeyC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelKeyC = new GridBagConstraints();
		gbc_labelKeyC.insets = new Insets(0, 0, 0, 5);
		gbc_labelKeyC.gridx = 3;
		gbc_labelKeyC.gridy = 0;
		row6.add(labelKeyC, gbc_labelKeyC);
		
		JLabel labelKeyD = new JLabel("D");
		labelKeyD.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKeyD.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelKeyD = new GridBagConstraints();
		gbc_labelKeyD.insets = new Insets(0, 0, 0, 5);
		gbc_labelKeyD.gridx = 4;
		gbc_labelKeyD.gridy = 0;
		row6.add(labelKeyD, gbc_labelKeyD);
		
		JLabel labelKeyE = new JLabel("E");
		labelKeyE.setHorizontalAlignment(SwingConstants.CENTER);
		labelKeyE.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_labelKeyE = new GridBagConstraints();
		gbc_labelKeyE.insets = new Insets(0, 0, 0, 5);
		gbc_labelKeyE.gridx = 5;
		gbc_labelKeyE.gridy = 0;
		row6.add(labelKeyE, gbc_labelKeyE);
		
		JLabel labelKeyF = new JLabel("F");
		labelKeyF.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelKeyF.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelKeyF = new GridBagConstraints();
		gbc_labelKeyF.gridx = 6;
		gbc_labelKeyF.gridy = 0;
		row6.add(labelKeyF, gbc_labelKeyF);
		
		
		

		opsAddOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(sidebar.getLayout());
			    cl.show(sidebar, "menuTab");
			}
		});
		
		
		
		//
		

		selectCatApps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(menuCurrentCat.getLayout());
			    cl.show(menuCurrentCat, "menu_APPS");
			}
		});

		selectCatSoupsSalads.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(menuCurrentCat.getLayout());
			    cl.show(menuCurrentCat, "menu_SS");
			}
		});
		
		selectCatEntrees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(menuCurrentCat.getLayout());
			    cl.show(menuCurrentCat, "menu_EN");
			}
		});
		
		SelectCatFavs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(menuCurrentCat.getLayout());
			    cl.show(menuCurrentCat, "menu_FAVS");
			}
		});
		
		SelectCatSandwhichs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    CardLayout cl = (CardLayout)(menuCurrentCat.getLayout());
			    cl.show(menuCurrentCat, "menu_SW");
			}
		});
		
		
		//
		
		// Cycles Specific Table Status... > Green > Yellow > Red >	
		
		tableMap = Stream.of(new Object[][] { 
		     { "1A", table1A }, 
		     { "1B", table1B }, 
		     { "1C", table1C }, 
		     { "1D", table1D }, 
		     { "1E", table1E }, 
		     { "1F", table1F }, 
		     { "2A", table2A }, 
		     { "2B", table2B }, 
		     { "2C", table2C }, 
		     { "2D", table2D }, 
		     { "2E", table2E }, 
		     { "2F", table2F }, 
		     { "3A", table3A }, 
		     { "3B", table3B }, 
		     { "3C", table3C }, 
		     { "3D", table3D }, 
		     { "3E", table3E }, 
		     { "3F", table3F }, 
		     { "4A", table4A }, 
		     { "4B", table4B }, 
		     { "4C", table4C }, 
		     { "4D", table4D }, 
		     { "4E", table4E }, 
		     { "4F", table4F }, 
		     { "5A", table5A }, 
		     { "5B", table5B }, 
		     { "5C", table5C }, 
		     { "5D", table5D }, 
		     { "5E", table5E }, 
		     { "5F", table5F },
		 }).collect(Collectors.toMap(data -> (String) data[0], data -> (JPanel) data[1]));
			
		opsStatus.addMouseListener(new MouseAdapter() {
			
			// Checks when opsStatus is clicked
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Color currentStatus = opsStatusColor.getBackground();
				
				String strTable = labelOpsCurrentTable.getText().replace("Table: ", "");
				
				if(currentStatus == Color.GREEN) {
					
					tableMap.get(strTable).setBackground(Color.YELLOW);
					opsStatusColor.setBackground(Color.YELLOW);
					labelOpsStatusMsg.setText("Status: Occupied");
				}
				
				if(currentStatus == Color.RED) {
					tableMap.get(strTable).setBackground(Color.GREEN);
					opsStatusColor.setBackground(Color.GREEN);
					labelOpsStatusMsg.setText("Status: Ready");
				}
				
				if(currentStatus == Color.YELLOW) {
					tableMap.get(strTable).setBackground(Color.RED);
					opsStatusColor.setBackground(Color.RED);	
					labelOpsStatusMsg.setText("Status: Dirty");			
				}
			}
		});
		
		
		getMenuItems(menuListApps, menuListSS, menuListEN, menuListFAVS, menuListSW);
		
		JPanel addSW = new JPanel();
		addSW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTab(menuListSW, labelOpsCurrentTable);
			}
		});
		addSW.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addSW.setBackground(Color.LIGHT_GRAY);
		catSW.add(addSW, BorderLayout.SOUTH);
		addSW.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Add to Order");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		addSW.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel addFAVS = new JPanel();
		addFAVS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTab(menuListFAVS, labelOpsCurrentTable);
			}
		});
		addFAVS.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addFAVS.setBackground(Color.LIGHT_GRAY);
		catFAVS.add(addFAVS, BorderLayout.SOUTH);
		addFAVS.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Add to Order");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		addFAVS.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel addEN = new JPanel();
		addEN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTab(menuListEN, labelOpsCurrentTable);
			}
		});
		addEN.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addEN.setBackground(Color.LIGHT_GRAY);
		catEN.add(addEN, BorderLayout.SOUTH);
		addEN.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Add to Order");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		addEN.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JPanel addSS = new JPanel();
		addSS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTab(menuListSS, labelOpsCurrentTable);
			}
		});
		addSS.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addSS.setBackground(Color.LIGHT_GRAY);
		catSS.add(addSS, BorderLayout.SOUTH);
		addSS.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Add to Order");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		addSS.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel addApp = new JPanel();
		addApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTab(menuListApps, labelOpsCurrentTable);
			}
		});
		addApp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addApp.setBackground(Color.LIGHT_GRAY);
		catApps.add(addApp, BorderLayout.SOUTH);
		addApp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Add to Tab");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addApp.add(lblNewLabel, BorderLayout.CENTER);
		
	}
	
	public void addToTab(JList<String> list, JLabel labelOpsCurrentTable) {
		String item = (String) list.getSelectedValue();
		String currentTable = labelOpsCurrentTable.getText().replace("Table: ", "").trim();
		System.out.println("Table: " + currentTable);				
		System.out.println("Item to add: " + item);
		ArrayList<String> currentTab = tabMap.get(currentTable);
		if(currentTab == null) {
			currentTab = new ArrayList<String>();
			currentTab.add(item);
			tabMap.put(currentTable, currentTab);
		} else {
			currentTab.add(item);
		}
		System.out.println("TabMap: " + tabMap);
	}
	
	@SuppressWarnings("unchecked")
	public void updateSideBar(JPanel table, JPanel opsStatusColor, JLabel labelOpsStatusMsg, JLabel labelOpsCurrentTable, JList<String> tabList, JPanel sidebar){
		Color currentStatus = table.getBackground();

	    CardLayout cl = (CardLayout)(sidebar.getLayout());
	    cl.show(sidebar, "tableOptions");
		
		String selectedTable = getTableLabel(table);
		labelOpsCurrentTable.setText("Table: " + selectedTable);
		 
		if(currentStatus == Color.GREEN) {
			opsStatusColor.setBackground(Color.GREEN);
			labelOpsStatusMsg.setText("Status: Ready");
		}
		
		if(currentStatus == Color.RED) {
			opsStatusColor.setBackground(Color.RED);
			labelOpsStatusMsg.setText("Status: Dirty");
		}
		
		if(currentStatus == Color.YELLOW) {
			opsStatusColor.setBackground(Color.YELLOW);	
			labelOpsStatusMsg.setText("Status: Occupied");			
		}
		
		((DefaultListModel<String>)tabList.getModel()).removeAllElements();
		
		System.out.println("Selected: '" + selectedTable + "'");
		System.out.println("TabMap: " + tabMap);
		if(tabMap.get(selectedTable) == null) return;
		System.out.println("Tab: '" + tabMap.get(selectedTable) + "'");
		for(String item : tabMap.get(selectedTable)) {
			 ((DefaultListModel<String>)tabList.getModel()).addElement(item);
		}
		
	}
	
	public String getTableLabel(JPanel table) {
		
	    for(String key : tableMap.keySet()) {
	    	if(tableMap.get(key) == table) {
	    		return key;
	    	}
	    } 
	    return null;
	}

	
	@SuppressWarnings("unchecked")
	public void getMenuItems(JList listApps, JList listSS, JList listEN, JList listFAVS, JList listSW) {
		for(MenuItem item : menu) {
			if(item.getID().startsWith("AP-")) {
				apps.add(item);
				((DefaultListModel<String>)listApps.getModel()).addElement(" - $" + item.getCost() + "0 : " + item.getName());
			}
			if(item.getID().startsWith("SS-")) {
				((DefaultListModel<String>)listSS.getModel()).addElement(" - $" + item.getCost() + "0 : " + item.getName());
			}
			if(item.getID().startsWith("EN-")) {
				((DefaultListModel<String>)listEN.getModel()).addElement(" - $" + item.getCost() + "0 : " + item.getName());
			}
			if(item.getID().startsWith("FEN-")) {
				System.out.println(item);
				((DefaultListModel<String>)listFAVS.getModel()).addElement(" - $" + item.getCost() + "0 : " + item.getName());
			}
			if(item.getID().startsWith("SW-")) {
				((DefaultListModel<String>)listSW.getModel()).addElement(" - $" + item.getCost() + "0 : " + item.getName());
			}
		}
	}
}
