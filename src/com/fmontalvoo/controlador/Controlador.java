package com.fmontalvoo.controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.fmontalvoo.conversor.Conversor;
import com.fmontalvoo.vista.Ventana;

public class Controlador implements ActionListener, MouseListener {
	private Ventana vista;
	private Conversor conversor;

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
	
	Logger log = Logger.getLogger(Controlador.class.getName());

	public Controlador(Ventana vista, Conversor conversor) {
		this.vista = vista;
		this.conversor = conversor;

		this.vista.setVisible(true);

		this.vista.btnAceptar.addActionListener(this);
		this.vista.btnReiniciar.addActionListener(this);

		this.vista.cbxSubRedes.addActionListener(this);

		this.vista.lblDeveloper.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == this.vista.btnAceptar)
			submit();
		if (evt.getSource() == this.vista.btnReiniciar)
			reset();
		if (evt.getSource() == this.vista.cbxSubRedes)
			selectSubnet();
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		if (evt.getSource() == this.vista.lblDeveloper)
			try {
				Desktop.getDesktop().browse(new URI("https://fmontalvoo.com/"));
			} catch (IOException | URISyntaxException e) {
				log.severe(e.getMessage());
				e.printStackTrace();
			}
	}

	@Override
	public void mousePressed(MouseEvent evt) {
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
	}

	@Override
	public void mouseExited(MouseEvent evt) {
	}

	public void submit() {
		if (validar(this.vista.txtMascara.getText()) && this.conversor.validar(this.vista.txtIP.getText())) {
			octetos = this.vista.txtIP.getText().split("\\.");
			mascara = Integer.valueOf(this.vista.txtMascara.getText());
			ipBinaria = this.conversor.ipBinaria(octetos);
			ipRed = this.conversor.ipDecimal(this.conversor.ipRedBroadcast(ipBinaria, mascara, "1", "0").split("\\."));
			ipBroadcast = this.conversor
					.ipDecimal(this.conversor.ipRedBroadcast(ipBinaria, mascara, "0", "1").split("\\."));
			ipHostMin = this.conversor.ipHost(ipRed.split("\\."), 1);
			ipHostMax = this.conversor.ipHost(ipBroadcast.split("\\."), -1);
			mascaraRed = this.conversor.ipDecimal(this.conversor.mascaraRed(ipBinaria, mascara).split("\\."));
			wildcard = this.conversor.ipDecimal(this.conversor.wildcard(ipBinaria, mascara).split("\\."));
			hosts = String.valueOf(this.conversor.elevar(2, 32 - mascara) - 2);
			if (this.vista.txtBits.getText().isEmpty()) {
				this.vista.cbxSubRedes.removeAllItems();
				this.vista.cbxSubRedes.addItem("");
				showAnswer();
			} else
				subnetting();
		} else
			JOptionPane.showMessageDialog(this.vista,
					ResourceBundle.getBundle(Ventana.PROPERTIES).getString("descripcionErrorIP"),
					ResourceBundle.getBundle(Ventana.PROPERTIES).getString("tituloErrorIP"), 0);
	}

	public void reset() {
		this.vista.txtIP.setText("");
		this.vista.txtMascara.setText("");
		this.vista.txtBits.setText("");
		this.vista.cbxSubRedes.removeAllItems();
		this.vista.cbxSubRedes.addItem("");
		this.vista.cbxSubRedes.setSelectedIndex(0);
		this.vista.lblClass.setText("");
		this.vista.lblMaskDec.setText("");
		this.vista.lblMaskBin.setText("");
		this.vista.lblWildcardDec.setText("");
		this.vista.lblWildcardBin.setText("");
		this.vista.lblRedDec.setText("");
		this.vista.lblRedBin.setText("");
		this.vista.lblHostMinDec.setText("");
		this.vista.lblHostMinDec.setText("");
		this.vista.lblHostMaxDec.setText("");
		this.vista.lblHostMaxBin.setText("");
		this.vista.lblBroadcastDec.setText("");
		this.vista.lblBroadcastBin.setText("");
		this.vista.lblHost.setText("");
	}

	public void selectSubnet() {
		if (!this.vista.txtBits.getText().isEmpty() && this.vista.cbxSubRedes.getItemCount() != 0) {
			String linea[] = this.vista.cbxSubRedes.getSelectedItem().toString().split("\\) ");
			String bits[] = linea[1].split("/");
			octetos = bits[0].split("\\.");
			ipBinaria = this.conversor.ipBinaria(octetos);
			ipRed = this.conversor
					.ipDecimal(this.conversor.ipRedBroadcast(ipBinaria, nuevaMascara, "1", "0").split("\\."));
			ipBroadcast = this.conversor
					.ipDecimal(this.conversor.ipRedBroadcast(ipBinaria, nuevaMascara, "0", "1").split("\\."));
			ipHostMin = this.conversor.ipHost(ipRed.split("\\."), 1);
			ipHostMax = this.conversor.ipHost(ipBroadcast.split("\\."), -1);
			mascaraRed = this.conversor.ipDecimal(this.conversor.mascaraRed(ipBinaria, nuevaMascara).split("\\."));
			wildcard = this.conversor.ipDecimal(this.conversor.wildcard(ipBinaria, nuevaMascara).split("\\."));
			hosts = String.valueOf(this.conversor.elevar(2, 32 - nuevaMascara) - 2);
			showAnswer();
		}
	}

	private boolean validar(String linea) {
		if (linea == null || linea.isEmpty())
			return false;
		try {
			if (Integer.parseInt(linea) > 30)
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private void subnetting() {
		if (validar(this.vista.txtBits.getText())) {
			int bits = Integer.valueOf(this.vista.txtBits.getText());
			nuevaMascara = mascara + bits;
			this.vista.cbxSubRedes.removeAllItems();
			if (nuevaMascara <= 30) {
				int numRedes = this.conversor.elevar(2, bits);
				String subRedes[] = this.conversor.subnetting(this.conversor.ipBinaria(ipRed.split("\\.")), mascara,
						nuevaMascara, numRedes);
				for (int i = 0; i < subRedes.length; i++) {
					this.vista.cbxSubRedes.addItem(subRedes[i]);
				}
			} else
				JOptionPane.showMessageDialog(this.vista,
						ResourceBundle.getBundle(Ventana.PROPERTIES).getString("descripcionErrorMascara"),
						ResourceBundle.getBundle(Ventana.PROPERTIES).getString("tituloErrorMascara"), 0);
		} else
			JOptionPane.showMessageDialog(this.vista,
					ResourceBundle.getBundle(Ventana.PROPERTIES).getString("descripcionMascaraIncorrecta"),
					ResourceBundle.getBundle(Ventana.PROPERTIES).getString("tituloMascaraIncorrecta"), 0);
	}

	private void showAnswer() {
		this.vista.lblClass.setText(this.conversor.clase(octetos));
		this.vista.lblMaskDec.setText(mascaraRed);
		this.vista.lblMaskBin.setText(this.conversor.ipBinaria(mascaraRed.split("\\.")));
		this.vista.lblWildcardDec.setText(wildcard);
		this.vista.lblWildcardBin.setText(this.conversor.ipBinaria(wildcard.split("\\.")));
		this.vista.lblRedDec.setText(ipRed);
		this.vista.lblRedBin.setText(this.conversor.ipBinaria(ipRed.split("\\.")));
		this.vista.lblHostMinDec.setText(ipHostMin);
		this.vista.lblHostMinBin.setText(this.conversor.ipBinaria(ipHostMin.split("\\.")));
		this.vista.lblHostMaxDec.setText(ipHostMax);
		this.vista.lblHostMaxBin.setText(this.conversor.ipBinaria(ipHostMax.split("\\.")));
		this.vista.lblBroadcastDec.setText(ipBroadcast);
		this.vista.lblBroadcastBin.setText(this.conversor.ipBinaria(ipBroadcast.split("\\.")));
		this.vista.lblHost.setText(hosts);
	}
}
