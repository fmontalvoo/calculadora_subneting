package com.fmontalvoo.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 2375984707135285564L;

	private static final String CONSOLAS = "Consolas";
	public static final String PROPERTIES = "com.fmontalvoo.i18n.Etiquetas";

	private JPanel contentPane;
	public JTextField txtIP;
	public JTextField txtMascara;
	private JLabel lblPlus;
	public JTextField txtBits;
	private JPanel panel;
	private JLabel lblSubRedes;
	public JComboBox<String> cbxSubRedes;
	public JButton btnAceptar;
	public JButton btnReiniciar;
	private JLabel lblClase;
	private JLabel lblMascara;
	private JLabel lblWildcard;
	private JLabel lblIPRed;
	private JLabel lblHostMin;
	private JLabel lblHostMax;
	private JLabel lblBroadcast;
	private JLabel lblHosts;
	public JLabel lblDeveloper;

	public JLabel lblClass;
	public JLabel lblMaskDec;
	public JLabel lblWildcardDec;
	public JLabel lblRedDec;
	public JLabel lblHostMinDec;
	public JLabel lblHostMaxDec;
	public JLabel lblBroadcastDec;
	public JLabel lblHost;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	private JLabel lbl_4;
	private JLabel lbl_5;
	private JLabel lbl_6;
	public JLabel lblMaskBin;
	public JLabel lblWildcardBin;
	public JLabel lblRedBin;
	public JLabel lblHostMinBin;
	public JLabel lblHostMaxBin;
	public JLabel lblBroadcastBin;

	public Ventana() {
		setTitle(ResourceBundle.getBundle(PROPERTIES).getString("tituloVentana"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 10.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblIP = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblIP") + ":");
		GridBagConstraints gbc_lblIP = new GridBagConstraints();
		gbc_lblIP.insets = new Insets(0, 0, 5, 5);
		gbc_lblIP.anchor = GridBagConstraints.WEST;
		gbc_lblIP.gridx = 0;
		gbc_lblIP.gridy = 0;
		gbc_lblIP.weightx = 1;
		contentPane.add(lblIP, gbc_lblIP);

		txtIP = new JTextField();
		txtIP.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		txtIP.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtIP = new GridBagConstraints();
		gbc_txtIP.insets = new Insets(0, 0, 5, 5);
		gbc_txtIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIP.gridx = 1;
		gbc_txtIP.gridy = 0;
		gbc_txtIP.weightx = 5;
		contentPane.add(txtIP, gbc_txtIP);
		txtIP.setColumns(10);

		JLabel lblSlash = new JLabel("/");
		lblSlash.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSlash = new GridBagConstraints();
		gbc_lblSlash.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlash.anchor = GridBagConstraints.CENTER;
		gbc_lblSlash.gridx = 2;
		gbc_lblSlash.gridy = 0;
		gbc_lblSlash.weightx = 1;
		contentPane.add(lblSlash, gbc_lblSlash);

		txtMascara = new JTextField();
		txtMascara.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		txtMascara.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtMascara = new GridBagConstraints();
		gbc_txtMascara.insets = new Insets(0, 0, 5, 5);
		gbc_txtMascara.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMascara.gridx = 3;
		gbc_txtMascara.gridy = 0;
		gbc_txtMascara.weightx = 2;
		contentPane.add(txtMascara, gbc_txtMascara);
		txtMascara.setColumns(1);

		lblPlus = new JLabel("+");
		lblPlus.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPlus = new GridBagConstraints();
		gbc_lblPlus.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlus.anchor = GridBagConstraints.CENTER;
		gbc_lblPlus.gridx = 4;
		gbc_lblPlus.gridy = 0;
		gbc_lblPlus.weightx = 1;
		contentPane.add(lblPlus, gbc_lblPlus);

		txtBits = new JTextField();
		txtBits.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		txtBits.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtBits = new GridBagConstraints();
		gbc_txtBits.insets = new Insets(0, 0, 5, 5);
		gbc_txtBits.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBits.gridx = 5;
		gbc_txtBits.gridy = 0;
		gbc_txtBits.weightx = 2;
		contentPane.add(txtBits, gbc_txtBits);
		txtBits.setColumns(1);

		btnAceptar = new JButton(ResourceBundle.getBundle(PROPERTIES).getString("btnAceptar"));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAceptar.gridx = 6;
		gbc_btnAceptar.gridy = 0;
		gbc_btnAceptar.weightx = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);

		lblSubRedes = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblSubRedes") + ":");
		GridBagConstraints gbc_lblSubRedes = new GridBagConstraints();
		gbc_lblSubRedes.anchor = GridBagConstraints.WEST;
		gbc_lblSubRedes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubRedes.gridx = 0;
		gbc_lblSubRedes.gridy = 1;
		gbc_lblSubRedes.weightx = 1;
		contentPane.add(lblSubRedes, gbc_lblSubRedes);

		cbxSubRedes = new JComboBox<String>();
		cbxSubRedes.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_cbxSubRedes = new GridBagConstraints();
		gbc_cbxSubRedes.insets = new Insets(0, 0, 5, 5);
		gbc_cbxSubRedes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxSubRedes.gridx = 1;
		gbc_cbxSubRedes.gridy = 1;
		gbc_cbxSubRedes.weightx = 5;
		contentPane.add(cbxSubRedes, gbc_cbxSubRedes);

		btnReiniciar = new JButton(ResourceBundle.getBundle(PROPERTIES).getString("btnReiniciar"));
		GridBagConstraints gbc_btnReiniciar = new GridBagConstraints();
		gbc_btnReiniciar.insets = new Insets(0, 0, 5, 0);
		gbc_btnReiniciar.gridx = 6;
		gbc_btnReiniciar.gridy = 1;
		gbc_btnReiniciar.weightx = 2;
		contentPane.add(btnReiniciar, gbc_btnReiniciar);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, ResourceBundle.getBundle(PROPERTIES).getString("tituloPanel"),
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblClase = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblClase") + ":");
		GridBagConstraints gbc_lblClase = new GridBagConstraints();
		gbc_lblClase.insets = new Insets(0, 0, 5, 5);
		gbc_lblClase.anchor = GridBagConstraints.WEST;
		gbc_lblClase.gridx = 0;
		gbc_lblClase.gridy = 0;
		gbc_lblClase.weighty = 1;
		gbc_lblClase.weightx = 1;
		panel.add(lblClase, gbc_lblClase);

		lblClass = new JLabel("");
		lblClass.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		lblClass.setForeground(Color.RED);
		GridBagConstraints gbc_lblClass = new GridBagConstraints();
		gbc_lblClass.insets = new Insets(0, 0, 5, 5);
		gbc_lblClass.anchor = GridBagConstraints.CENTER;
		gbc_lblClass.gridx = 1;
		gbc_lblClass.gridy = 0;
		gbc_lblClass.weightx = 4;
		panel.add(lblClass, gbc_lblClass);

		lblMascara = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblMascara") + ":");
		GridBagConstraints gbc_lblMascara = new GridBagConstraints();
		gbc_lblMascara.insets = new Insets(0, 0, 5, 5);
		gbc_lblMascara.anchor = GridBagConstraints.WEST;
		gbc_lblMascara.gridx = 0;
		gbc_lblMascara.gridy = 1;
		gbc_lblMascara.weighty = 1;
		gbc_lblMascara.weightx = 1;
		panel.add(lblMascara, gbc_lblMascara);

		lblMaskDec = new JLabel("");
		lblMaskDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblMaskDec = new GridBagConstraints();
		gbc_lblMaskDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaskDec.anchor = GridBagConstraints.CENTER;
		gbc_lblMaskDec.gridx = 1;
		gbc_lblMaskDec.gridy = 1;
		gbc_lblMaskDec.weightx = 4;
		panel.add(lblMaskDec, gbc_lblMaskDec);

		lbl_1 = new JLabel("=>");
		GridBagConstraints gbc_lbl_1 = new GridBagConstraints();
		gbc_lbl_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_1.anchor = GridBagConstraints.CENTER;
		gbc_lbl_1.gridx = 2;
		gbc_lbl_1.gridy = 1;
		gbc_lbl_1.weightx = 1;
		panel.add(lbl_1, gbc_lbl_1);

		lblMaskBin = new JLabel("");
		lblMaskBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblMaskBin = new GridBagConstraints();
		gbc_lblMaskBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaskBin.anchor = GridBagConstraints.CENTER;
		gbc_lblMaskBin.gridx = 3;
		gbc_lblMaskBin.gridy = 1;
		gbc_lblMaskBin.weightx = 5;
		panel.add(lblMaskBin, gbc_lblMaskBin);

		lblWildcard = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblWildcard") + ":");
		GridBagConstraints gbc_lblWildcard = new GridBagConstraints();
		gbc_lblWildcard.insets = new Insets(0, 0, 5, 5);
		gbc_lblWildcard.anchor = GridBagConstraints.WEST;
		gbc_lblWildcard.gridx = 0;
		gbc_lblWildcard.gridy = 2;
		gbc_lblWildcard.weighty = 1;
		gbc_lblWildcard.weightx = 1;
		panel.add(lblWildcard, gbc_lblWildcard);

		lblWildcardDec = new JLabel("");
		lblWildcardDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblWildcardDec = new GridBagConstraints();
		gbc_lblWildcardDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblWildcardDec.anchor = GridBagConstraints.CENTER;
		gbc_lblWildcardDec.gridx = 1;
		gbc_lblWildcardDec.gridy = 2;
		gbc_lblWildcardDec.weightx = 4;
		panel.add(lblWildcardDec, gbc_lblWildcardDec);

		lbl_2 = new JLabel("=>");
		GridBagConstraints gbc_lbl_2 = new GridBagConstraints();
		gbc_lbl_2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_2.anchor = GridBagConstraints.CENTER;
		gbc_lbl_2.gridx = 2;
		gbc_lbl_2.gridy = 2;
		gbc_lbl_2.weightx = 1;
		panel.add(lbl_2, gbc_lbl_2);

		lblWildcardBin = new JLabel("");
		lblWildcardBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblWildcardBin = new GridBagConstraints();
		gbc_lblWildcardBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblWildcardBin.anchor = GridBagConstraints.CENTER;
		gbc_lblWildcardBin.gridx = 3;
		gbc_lblWildcardBin.gridy = 2;
		gbc_lblWildcardBin.weightx = 5;
		panel.add(lblWildcardBin, gbc_lblWildcardBin);

		lblIPRed = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblIPRed") + ":");
		GridBagConstraints gbc_lblIPRed = new GridBagConstraints();
		gbc_lblIPRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblIPRed.anchor = GridBagConstraints.WEST;
		gbc_lblIPRed.gridx = 0;
		gbc_lblIPRed.gridy = 3;
		gbc_lblIPRed.weighty = 1;
		gbc_lblIPRed.weightx = 1;
		panel.add(lblIPRed, gbc_lblIPRed);

		lblRedDec = new JLabel("");
		lblRedDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblRedDec = new GridBagConstraints();
		gbc_lblRedDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblRedDec.anchor = GridBagConstraints.CENTER;
		gbc_lblRedDec.gridx = 1;
		gbc_lblRedDec.gridy = 3;
		gbc_lblRedDec.weightx = 4;
		panel.add(lblRedDec, gbc_lblRedDec);

		lbl_3 = new JLabel("=>");
		GridBagConstraints gbc_lbl_3 = new GridBagConstraints();
		gbc_lbl_3.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_3.anchor = GridBagConstraints.CENTER;
		gbc_lbl_3.gridx = 2;
		gbc_lbl_3.gridy = 3;
		gbc_lbl_3.weightx = 1;
		panel.add(lbl_3, gbc_lbl_3);

		lblRedBin = new JLabel("");
		lblRedBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblRedBin = new GridBagConstraints();
		gbc_lblRedBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblRedBin.anchor = GridBagConstraints.CENTER;
		gbc_lblRedBin.gridx = 3;
		gbc_lblRedBin.gridy = 3;
		gbc_lblRedBin.weightx = 5;
		panel.add(lblRedBin, gbc_lblRedBin);

		lblHostMin = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblHostMin") + ":");
		GridBagConstraints gbc_lblHostMin = new GridBagConstraints();
		gbc_lblHostMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostMin.anchor = GridBagConstraints.WEST;
		gbc_lblHostMin.gridx = 0;
		gbc_lblHostMin.gridy = 4;
		gbc_lblHostMin.weighty = 1;
		gbc_lblHostMin.weightx = 1;
		panel.add(lblHostMin, gbc_lblHostMin);

		lblHostMinDec = new JLabel("");
		lblHostMinDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblHostMinDec = new GridBagConstraints();
		gbc_lblHostMinDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostMinDec.anchor = GridBagConstraints.CENTER;
		gbc_lblHostMinDec.gridx = 1;
		gbc_lblHostMinDec.gridy = 4;
		gbc_lblHostMinDec.weightx = 4;
		panel.add(lblHostMinDec, gbc_lblHostMinDec);

		lbl_4 = new JLabel("=>");
		GridBagConstraints gbc_lbl_4 = new GridBagConstraints();
		gbc_lbl_4.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_4.anchor = GridBagConstraints.CENTER;
		gbc_lbl_4.gridx = 2;
		gbc_lbl_4.gridy = 4;
		gbc_lbl_4.weightx = 1;
		panel.add(lbl_4, gbc_lbl_4);

		lblHostMinBin = new JLabel("");
		lblHostMinBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblHostMinBin = new GridBagConstraints();
		gbc_lblHostMinBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblHostMinBin.anchor = GridBagConstraints.CENTER;
		gbc_lblHostMinBin.gridx = 3;
		gbc_lblHostMinBin.gridy = 4;
		gbc_lblHostMinBin.weightx = 5;
		panel.add(lblHostMinBin, gbc_lblHostMinBin);

		lblHostMax = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblHostMax") + ":");
		GridBagConstraints gbc_lblHostMax = new GridBagConstraints();
		gbc_lblHostMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostMax.anchor = GridBagConstraints.WEST;
		gbc_lblHostMax.gridx = 0;
		gbc_lblHostMax.gridy = 5;
		gbc_lblHostMax.weighty = 1;
		gbc_lblHostMax.weightx = 1;
		panel.add(lblHostMax, gbc_lblHostMax);

		lblHostMaxDec = new JLabel("");
		lblHostMaxDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblHostMaxDec = new GridBagConstraints();
		gbc_lblHostMaxDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostMaxDec.anchor = GridBagConstraints.CENTER;
		gbc_lblHostMaxDec.gridx = 1;
		gbc_lblHostMaxDec.gridy = 5;
		gbc_lblHostMaxDec.weightx = 4;
		panel.add(lblHostMaxDec, gbc_lblHostMaxDec);

		lbl_5 = new JLabel("=>");
		GridBagConstraints gbc_lbl_5 = new GridBagConstraints();
		gbc_lbl_5.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_5.anchor = GridBagConstraints.CENTER;
		gbc_lbl_5.gridx = 2;
		gbc_lbl_5.gridy = 5;
		gbc_lbl_5.weightx = 1;
		panel.add(lbl_5, gbc_lbl_5);

		lblHostMaxBin = new JLabel("");
		lblHostMaxBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblHostMaxBin = new GridBagConstraints();
		gbc_lblHostMaxBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblHostMaxBin.anchor = GridBagConstraints.CENTER;
		gbc_lblHostMaxBin.gridx = 3;
		gbc_lblHostMaxBin.gridy = 5;
		gbc_lblHostMaxBin.weightx = 5;
		panel.add(lblHostMaxBin, gbc_lblHostMaxBin);

		lblBroadcast = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblBroadcast") + ":");
		GridBagConstraints gbc_lblBroadcast = new GridBagConstraints();
		gbc_lblBroadcast.insets = new Insets(0, 0, 5, 5);
		gbc_lblBroadcast.anchor = GridBagConstraints.WEST;
		gbc_lblBroadcast.gridx = 0;
		gbc_lblBroadcast.gridy = 6;
		gbc_lblBroadcast.weighty = 1;
		gbc_lblBroadcast.weightx = 1;
		panel.add(lblBroadcast, gbc_lblBroadcast);

		lblBroadcastDec = new JLabel("");
		lblBroadcastDec.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblBroadcastDec = new GridBagConstraints();
		gbc_lblBroadcastDec.insets = new Insets(0, 0, 5, 5);
		gbc_lblBroadcastDec.anchor = GridBagConstraints.CENTER;
		gbc_lblBroadcastDec.gridx = 1;
		gbc_lblBroadcastDec.gridy = 6;
		gbc_lblBroadcastDec.weightx = 4;
		panel.add(lblBroadcastDec, gbc_lblBroadcastDec);

		lbl_6 = new JLabel("=>");
		GridBagConstraints gbc_lbl_6 = new GridBagConstraints();
		gbc_lbl_6.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_6.anchor = GridBagConstraints.CENTER;
		gbc_lbl_6.gridx = 2;
		gbc_lbl_6.gridy = 6;
		gbc_lbl_6.weightx = 1;
		panel.add(lbl_6, gbc_lbl_6);

		lblBroadcastBin = new JLabel("");
		lblBroadcastBin.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		GridBagConstraints gbc_lblBroadcastBin = new GridBagConstraints();
		gbc_lblBroadcastBin.insets = new Insets(0, 0, 5, 0);
		gbc_lblBroadcastBin.anchor = GridBagConstraints.CENTER;
		gbc_lblBroadcastBin.gridx = 3;
		gbc_lblBroadcastBin.gridy = 6;
		gbc_lblBroadcastBin.weightx = 5;
		panel.add(lblBroadcastBin, gbc_lblBroadcastBin);

		lblHosts = new JLabel(ResourceBundle.getBundle(PROPERTIES).getString("lblHosts") + ":");
		GridBagConstraints gbc_lblHosts = new GridBagConstraints();
		gbc_lblHosts.insets = new Insets(0, 0, 0, 5);
		gbc_lblHosts.anchor = GridBagConstraints.WEST;
		gbc_lblHosts.gridx = 0;
		gbc_lblHosts.gridy = 7;
		gbc_lblHosts.weighty = 1;
		gbc_lblHosts.weightx = 1;
		panel.add(lblHosts, gbc_lblHosts);

		lblHost = new JLabel("");
		lblHost.setFont(new Font(CONSOLAS, Font.PLAIN, 14));
		lblHost.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.insets = new Insets(0, 0, 0, 5);
		gbc_lblHost.anchor = GridBagConstraints.CENTER;
		gbc_lblHost.gridx = 1;
		gbc_lblHost.gridy = 7;
		gbc_lblHost.weightx = 4;
		panel.add(lblHost, gbc_lblHost);

		lblDeveloper = new JLabel("<html><a href=''>fmontalvoo.com</a></html>");
		lblDeveloper.setForeground(Color.BLUE.darker());
		lblDeveloper.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_lblDeveloper = new GridBagConstraints();
		gbc_lblDeveloper.gridx = 6;
		gbc_lblDeveloper.gridy = 4;
		contentPane.add(lblDeveloper, gbc_lblDeveloper);
	}

}
