package com.fmontalvoo.conversor;

public interface Conversor {

	public int binarioDecimal(String binario, int base);

	public String decimalBinario(int numero);

	public String clase(int valor);

	public String ipBinaria(String octetos[]);

	public String ipDecimal(String octetos[]);

	public String ipRedBroadcast(String ipBinaria, int mascara, String a, String b);

	public String mascaraRed(String ipBinaria, int mascara);

	public String wildcard(String ipBinaria, int mascara);

	public String ipHost(String octetos[], int n);

	public String[] subnetting(String ipBinaria, int mascara, int nuevaMascara, int numRedes);

	public int elevar(int b, int e);

	public String invertirCadena(String numero);

	public boolean validar(String datos);

	public String completar(String octeto, int limite);

	public String divIP(String ip);

}
