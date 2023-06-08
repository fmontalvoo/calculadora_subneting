package com.fmontalvoo;

import com.fmontalvoo.controlador.Controlador;
import com.fmontalvoo.conversor.Conversor;
import com.fmontalvoo.conversor.ConversorImpl;
import com.fmontalvoo.vista.Ventana;

public class Principal {
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		Conversor conversor = ConversorImpl.getInstance();
		new Controlador(ventana, conversor);
	}
}
