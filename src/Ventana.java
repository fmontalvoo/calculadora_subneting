import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtIP;
	private JTextField txtMascara;
	private JComboBox comboBox;
	private JLabel lblClase;
	private JLabel lblMascara;
	private JLabel lblIpRed;
	private JLabel lblIpBroadcast;
	private JLabel lblIpHostMin;
	private JLabel lblIpHostmax;
	private JLabel lblWildcard;
	private JLabel lblHosts;
	private JLabel lblMaskDec;
	private JLabel lblClassDec;
	private JLabel lblWildDec;
	private JLabel lblNetDec;
	private JPanel panel;
	private JLabel lblHmDec;
	private JLabel lblHMDec;
	private JLabel lblBrodDec;
	private JLabel lblHost;
	private JLabel lblMaskBin;
	private JLabel lblWildBin;
	private JLabel lblNetBin;
	private JLabel lblHmBin;
	private JLabel lblHMBin;
	private JLabel lblBrodBin;
	private JLabel lbligual1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblDesarrolladoPorFgmo;
	private JTextField txtBits;
	private JLabel lblSubRedes;
	private Conversor conv = new Conversor();
	private String octetos[];
	private int mascara;
	private int nuevaMascara;
	private String ipBinaria;
	private String ipRed;
	private String ipBroadcast;
	private String ipHostMin;
	private String ipHostMax;
	private String mascaraRed;
	private String wildcard;
	private String hosts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Calculadora IP's");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblIp = new JLabel("IP:");
		lblIp.setForeground(Color.WHITE);
		lblIp.setBounds(12, 12, 30, 15);
		contentPane.add(lblIp);

		txtIP = new JTextField();
		txtIP.setForeground(Color.WHITE);
		txtIP.setBackground(Color.BLACK);
		txtIP.setBounds(48, 10, 285, 19);
		txtIP.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtIP);
		txtIP.setColumns(10);

		JLabel lblSlash = new JLabel("/");
		lblSlash.setForeground(Color.WHITE);
		lblSlash.setBounds(351, 12, 12, 15);
		contentPane.add(lblSlash);

		txtMascara = new JTextField();
		txtMascara.setForeground(Color.WHITE);
		txtMascara.setBackground(Color.BLACK);
		txtMascara.setBounds(370, 10, 50, 19);
		txtMascara.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtMascara);
		txtMascara.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validar(txtMascara.getText())) {
					if (conv.validar(txtIP.getText())) {

						octetos = txtIP.getText().split("\\.");
						mascara = Integer.valueOf(txtMascara.getText());
						ipBinaria = conv.ipBinaria(octetos);
						ipRed = conv.ipDecimal(conv.ipRed_Broadcats(ipBinaria, mascara, "1", "0").split("\\."));
						ipBroadcast = conv.ipDecimal(conv.ipRed_Broadcats(ipBinaria, mascara, "0", "1").split("\\."));
						ipHostMin = conv.ipHost(ipRed.split("\\."), 1);
						ipHostMax = conv.ipHost(ipBroadcast.split("\\."), -1);
						mascaraRed = conv.ipDecimal(conv.mascara_Red(ipBinaria, mascara).split("\\."));
						wildcard = conv.ipDecimal(conv.wildcard(ipBinaria, mascara).split("\\."));
						hosts = String.valueOf(conv.elevar(2, 32 - mascara) - 2);

						if (txtBits.getText().isEmpty()) {
							comboBox.removeAllItems();
							comboBox.addItem("");
							calculadora();
						} else
							subnetting();
					} else
						JOptionPane.showMessageDialog(contentPane, "Por favor verifique la IP e intentelo nuevamente",
								"IP mal igresada", 0);
				} else
					JOptionPane.showMessageDialog(contentPane,
							"Por favor verifique que los datos ingresados sean numericos",
							"Mascara de Red mal ingresada", 0);
			}
		});
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setBounds(530, 7, 107, 25);
		contentPane.add(btnAceptar);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Subnetting", TitledBorder.CENTER,
				TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(12, 75, 692, 239);
		panel.setLayout(null);
		contentPane.add(panel);

		lblClassDec = new JLabel("");
		lblClassDec.setForeground(Color.RED);
		lblClassDec.setBounds(120, 21, 70, 15);
		panel.add(lblClassDec);

		lblMaskDec = new JLabel("");
		lblMaskDec.setForeground(Color.GRAY);
		lblMaskDec.setBounds(120, 48, 125, 15);
		panel.add(lblMaskDec);

		lblWildDec = new JLabel("");
		lblWildDec.setForeground(Color.GRAY);
		lblWildDec.setBounds(120, 75, 125, 15);
		panel.add(lblWildDec);

		lblNetDec = new JLabel("");
		lblNetDec.setForeground(Color.GRAY);
		lblNetDec.setBounds(120, 105, 125, 15);
		panel.add(lblNetDec);

		lblClase = new JLabel("Clase:");
		lblClase.setForeground(Color.WHITE);
		lblClase.setBounds(14, 21, 94, 15);
		panel.add(lblClase);

		lblMascara = new JLabel("Mascara:");
		lblMascara.setForeground(Color.WHITE);
		lblMascara.setBounds(14, 48, 94, 15);
		panel.add(lblMascara);

		lblIpRed = new JLabel("IP Red:");
		lblIpRed.setForeground(Color.WHITE);
		lblIpRed.setBounds(14, 105, 94, 15);
		panel.add(lblIpRed);

		lblIpBroadcast = new JLabel("IP Broadcast:");
		lblIpBroadcast.setForeground(Color.WHITE);
		lblIpBroadcast.setBounds(14, 186, 94, 15);
		panel.add(lblIpBroadcast);

		lblIpHostMin = new JLabel("IP HostMin:");
		lblIpHostMin.setForeground(Color.WHITE);
		lblIpHostMin.setBounds(14, 132, 94, 15);
		panel.add(lblIpHostMin);

		lblIpHostmax = new JLabel("IP HostMax:");
		lblIpHostmax.setForeground(Color.WHITE);
		lblIpHostmax.setBounds(14, 159, 94, 15);
		panel.add(lblIpHostmax);

		lblWildcard = new JLabel("Wildcard:");
		lblWildcard.setForeground(Color.WHITE);
		lblWildcard.setBounds(14, 75, 94, 15);
		panel.add(lblWildcard);

		lblHosts = new JLabel("Hosts:");
		lblHosts.setForeground(Color.WHITE);
		lblHosts.setBounds(14, 213, 107, 15);
		panel.add(lblHosts);

		lblHmDec = new JLabel("");
		lblHmDec.setForeground(Color.GRAY);
		lblHmDec.setBounds(120, 132, 125, 15);
		panel.add(lblHmDec);

		lblHMDec = new JLabel("");
		lblHMDec.setForeground(Color.GRAY);
		lblHMDec.setBounds(120, 159, 125, 15);
		panel.add(lblHMDec);

		lblBrodDec = new JLabel("");
		lblBrodDec.setForeground(Color.GRAY);
		lblBrodDec.setBounds(120, 186, 125, 15);
		panel.add(lblBrodDec);

		lblHost = new JLabel("");
		lblHost.setForeground(Color.GREEN);
		lblHost.setBounds(120, 213, 100, 15);
		panel.add(lblHost);

		lblMaskBin = new JLabel("", SwingConstants.CENTER);
		lblMaskBin.setForeground(Color.GRAY);
		lblMaskBin.setBounds(362, 48, 320, 15);
		panel.add(lblMaskBin);

		lblWildBin = new JLabel("", SwingConstants.CENTER);
		lblWildBin.setForeground(Color.GRAY);
		lblWildBin.setBounds(362, 75, 320, 15);
		panel.add(lblWildBin);

		lblNetBin = new JLabel("", SwingConstants.CENTER);
		lblNetBin.setForeground(Color.GRAY);
		lblNetBin.setBounds(362, 105, 320, 15);
		panel.add(lblNetBin);

		lblHmBin = new JLabel("", SwingConstants.CENTER);
		lblHmBin.setForeground(Color.GRAY);
		lblHmBin.setBounds(362, 132, 320, 15);
		panel.add(lblHmBin);

		lblHMBin = new JLabel("", SwingConstants.CENTER);
		lblHMBin.setForeground(Color.GRAY);
		lblHMBin.setBounds(362, 159, 320, 15);
		panel.add(lblHMBin);

		lblBrodBin = new JLabel("", SwingConstants.CENTER);
		lblBrodBin.setForeground(Color.GRAY);
		lblBrodBin.setBounds(362, 186, 320, 15);
		panel.add(lblBrodBin);

		lbligual1 = new JLabel("=>", SwingConstants.CENTER);
		lbligual1.setForeground(Color.WHITE);
		lbligual1.setBounds(272, 48, 31, 15);
		panel.add(lbligual1);

		label_1 = new JLabel("=>", SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(272, 75, 31, 15);
		panel.add(label_1);

		label_2 = new JLabel("=>", SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(272, 102, 31, 15);
		panel.add(label_2);

		label_3 = new JLabel("=>", SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(272, 132, 31, 15);
		panel.add(label_3);

		label_4 = new JLabel("=>", SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(272, 159, 31, 15);
		panel.add(label_4);

		label_5 = new JLabel("=>", SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(272, 186, 31, 15);
		panel.add(label_5);

		lblDesarrolladoPorFgmo = new JLabel("Desarrollado por FGMO", SwingConstants.CENTER);
		lblDesarrolladoPorFgmo.setBounds(564, 325, 140, 15);
		contentPane.add(lblDesarrolladoPorFgmo);

		JLabel lblPlus = new JLabel("+", SwingConstants.CENTER);
		lblPlus.setForeground(Color.WHITE);
		lblPlus.setBounds(430, 12, 12, 14);
		contentPane.add(lblPlus);

		txtBits = new JTextField();
		txtBits.setForeground(Color.WHITE);
		txtBits.setBackground(Color.BLACK);
		txtBits.setHorizontalAlignment(JTextField.CENTER);
		txtBits.setBounds(452, 9, 50, 20);
		contentPane.add(txtBits);
		txtBits.setColumns(10);

		lblSubRedes = new JLabel("Sub Redes:");
		lblSubRedes.setForeground(Color.WHITE);
		lblSubRedes.setBounds(10, 50, 70, 14);
		contentPane.add(lblSubRedes);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!txtBits.getText().isEmpty() && comboBox.getItemCount() != 0) {
					String linea[] = comboBox.getSelectedItem().toString().split("\\) ");
					String bits[] = linea[1].split("/");
					octetos = bits[0].split("\\.");
					ipBinaria = conv.ipBinaria(octetos);
					ipRed = conv.ipDecimal(conv.ipRed_Broadcats(ipBinaria, nuevaMascara, "1", "0").split("\\."));
					ipBroadcast = conv.ipDecimal(conv.ipRed_Broadcats(ipBinaria, nuevaMascara, "0", "1").split("\\."));
					ipHostMin = conv.ipHost(ipRed.split("\\."), 1);
					ipHostMax = conv.ipHost(ipBroadcast.split("\\."), -1);
					mascaraRed = conv.ipDecimal(conv.mascara_Red(ipBinaria, nuevaMascara).split("\\."));
					wildcard = conv.ipDecimal(conv.wildcard(ipBinaria, nuevaMascara).split("\\."));
					hosts = String.valueOf(conv.elevar(2, 32 - nuevaMascara) - 2);
					calculadora();
				}
			}
		});
		comboBox.addItem("");
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(90, 44, 243, 20);
		contentPane.add(comboBox);

		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setBackground(Color.DARK_GRAY);
		btnReiniciar.setBounds(530, 43, 107, 23);
		contentPane.add(btnReiniciar);
	}

	private void subnetting() {

		if (validar(txtBits.getText())) {
			int bits = Integer.valueOf(txtBits.getText());
			nuevaMascara = mascara + bits;
			comboBox.removeAllItems();
			if (nuevaMascara <= 30) {
				int numRedes = conv.elevar(2, bits);
				String subRedes[] = conv.subnetting(conv.ipBinaria(ipRed.split("\\.")), mascara, nuevaMascara,
						numRedes);
				for (int i = 0; i < subRedes.length; i++) {
					comboBox.addItem(subRedes[i]);
				}
			} else
				JOptionPane.showMessageDialog(contentPane, "La mascara de red no puede ser mayor a 30",
						"Error de mascara", 0);
		} else
			JOptionPane.showMessageDialog(contentPane, "Por favor verifique que los datos ingresados sean numericos",
					"Macara de Red mal ingresada", 0);
	}

	private void calculadora() {

		lblClassDec.setText(conv.clase(octetos));

		lblMaskDec.setText(mascaraRed);
		lblMaskBin.setText(conv.ipBinaria(mascaraRed.split("\\.")));

		lblWildDec.setText(wildcard);
		lblWildBin.setText(conv.ipBinaria(wildcard.split("\\.")));

		lblNetDec.setText(ipRed);
		lblNetBin.setText(conv.ipBinaria(ipRed.split("\\.")));

		lblHmDec.setText(ipHostMin);
		lblHmBin.setText(conv.ipBinaria(ipHostMin.split("\\.")));

		lblHMDec.setText(ipHostMax);
		lblHMBin.setText(conv.ipBinaria(ipHostMax.split("\\.")));

		lblBrodDec.setText(ipBroadcast);
		lblBrodBin.setText(conv.ipBinaria(ipBroadcast.split("\\.")));

		lblHost.setText(hosts);
	}

	private void reiniciar() {
		txtIP.setText("");
		txtMascara.setText("");
		txtBits.setText("");
		comboBox.removeAllItems();
		comboBox.addItem("");
		comboBox.setSelectedIndex(0);
		lblClassDec.setText("");
		lblMaskDec.setText("");
		lblMaskBin.setText("");
		lblWildDec.setText("");
		lblWildBin.setText("");
		lblNetDec.setText("");
		lblNetBin.setText("");
		lblHmDec.setText("");
		lblHmBin.setText("");
		lblHMDec.setText("");
		lblHMBin.setText("");
		lblBrodDec.setText("");
		lblBrodBin.setText("");
		lblHost.setText("");

	}

	private boolean validar(String linea) {
		try {
			if (Integer.parseInt(linea) > 30)
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
