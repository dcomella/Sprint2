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
	
	private final JPanel table_layout = new JPanel();

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
		sidebar.add(tableOps, "1A");
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
				updateSideBar(table1A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table1B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table1C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table1D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table1E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table1F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table2F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table3F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table4F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5A, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5B, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5C, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5D, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5E, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
				updateSideBar(table5F, opsStatusColor, labelOpsStatusMsg, labelOpsCurrentTable, currentTabList);
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
		
		ArrayList<MenuItem> menu = new FileReader().getMenu();
		
		ArrayList<MenuItem> apps = new ArrayList<MenuItem>();
		ArrayList<MenuItem> saladsSoups = new ArrayList<MenuItem>();
		ArrayList<MenuItem> entrees = new ArrayList<MenuItem>();
		ArrayList<MenuItem> favs = new ArrayList<MenuItem>();
		ArrayList<MenuItem> sandwhiches = new ArrayList<MenuItem>();
		for(MenuItem item : menu) {
			if(item.getID().startsWith("AP-")) {
				apps.add(item);
			}
			if(item.getID().startsWith("SS-")) {
				saladsSoups.add(item);
			}
			if(item.getID().startsWith("EN-")) {
				entrees.add(item);
			}
			if(item.getID().startsWith("FE-")) {
				favs.add(item);
			}
			if(item.getID().startsWith("SW-")) {
				sandwhiches.add(item);
			}
		}
		System.out.println("Appetizers: " + apps);
		System.out.println("Soups/Salads: " + apps);
		System.out.println("Entrees: " + apps);
		System.out.println("Fav Entrees: " + apps);
		System.out.println("Sandwhiches: " + apps);
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateSideBar(JPanel table, JPanel opsStatusColor, JLabel labelOpsStatusMsg, JLabel labelOpsCurrentTable, JList<String> tabList){
		Color currentStatus = table.getBackground();
		
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
		
		ArrayList<String> tab = getCurrentTab(table);
		((DefaultListModel<String>)tabList.getModel()).removeAllElements();
		if(tab == null) return;
		for(String item : tab) {
			 ((DefaultListModel<String>)tabList.getModel()).addElement(" - $05.00 : " + item);
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
	
	public ArrayList<String> getCurrentTab(JPanel table) {
		String label = getTableLabel(table);
		ArrayList<String> tab = new ArrayList<String>();
		if(label == "1A") {
			System.out.println("1A");
			tab.add("Oysters");
			tab.add("Coke");
			tab.add("Quesadilla");
		}

		if(label == "1B") {
			System.out.println("1B");
			tab.add("Salad");
			tab.add("Dr. Pepper");
			tab.add("Cheeseburger");
		}

		return tab;
	}
	
	public void getMenuItems() {
		
	}
}
