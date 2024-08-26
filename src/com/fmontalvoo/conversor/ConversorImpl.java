package com.fmontalvoo.conversor;

public class ConversorImpl implements Conversor {

	private static ConversorImpl instance;

	private ConversorImpl() {

	}

	public static ConversorImpl getInstance() {
		if (instance == null)
			instance = new ConversorImpl();

		return instance;
	}

	@Override
	public int binarioDecimal(String binario, int base) {
		int resultado = 0;
		for (int i = binario.length() - 1, j = 0; i >= 0; i--, j++) {
			resultado += Integer.parseInt("" + binario.charAt(i)) * elevar(base, j);
		}
		return resultado;
	}

	@Override
	public String decimalBinario(int numero) {
		String binario = "";
		if (numero == 0) {
			return "0";
		}
		for (int i = numero; i > 0; i /= 2) {
			binario += i % 2;
		}
		return invertirCadena(binario);
	}

	@Override
	public String clase(int valor) {
		if (valor >= 0 && valor <= 127) {
			return "A";
		}
		if (valor >= 128 && valor <= 191) {
			return "B";
		}
		if (valor >= 192 && valor <= 223) {
			return "C";
		}
		if (valor >= 224 && valor <= 239) {
			return "D";
		}
		if (valor >= 240 && valor <= 255) {
			return "E";
		}
		return "";
	}

	@Override
	public String ipBinaria(String octetos[]) {
		String binarios = "";
		for (int i = 0; i < octetos.length; i++) {
			if (i < 3) {
				binarios += completar(decimalBinario(Integer.valueOf(octetos[i])), 8) + ".";
			} else {
				binarios += completar(decimalBinario(Integer.valueOf(octetos[i])), 8);
			}
		}
		return binarios;
	}

	@Override
	public String ipDecimal(String octetos[]) {
		String decimales = "";
		for (int i = 0; i < octetos.length; i++) {
			if (i < 3) {
				decimales += binarioDecimal(octetos[i], 2) + ".";
			} else {
				decimales += binarioDecimal(octetos[i], 2);
			}
		}
		return decimales;
	}

	@Override
	public String ipRedBroadcast(String ipBinaria, int mascara, String a, String b) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara) + "" + ip.substring(mascara, 32).replace(a, b);
		return divIP(ipRes);
	}

	@Override
	public String mascaraRed(String ipBinaria, int mascara) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara).replace("0", "1") + "" + ip.substring(mascara, 32).replace("1", "0");
		return divIP(ipRes);
	}

	@Override
	public String wildcard(String ipBinaria, int mascara) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara).replace("1", "0") + "" + ip.substring(mascara, 32).replace("0", "1");
		return divIP(ipRes);
	}

	@Override
	public String ipHost(String octetos[], int n) {
		String host = "";
		for (int i = 0; i < octetos.length; i++) {
			if (i < 3) {
				host += octetos[i] + ".";
			} else {
				host += (Integer.valueOf(octetos[i]) + n);
			}
		}
		return host;
	}

	@Override
	public String[] subnetting(String ipBinaria, int mascara, int nuevaMascara, int numRedes) {
		String subRedes[] = new String[numRedes];
		String ip = ipBinaria.replace(".", "");
		for (int i = 0; i < numRedes; i++) {
			subRedes[i] = (i + 1) + ") "
					+ ipDecimal(divIP(ip.substring(0, mascara)
							+ completar("" + decimalBinario(Integer.valueOf(i)), nuevaMascara - mascara)
							+ ip.substring(nuevaMascara, 32)).split("\\."))
					+ "/" + nuevaMascara;
		}

		return subRedes;
	}

	@Override
	public int elevar(int b, int e) {
		if (e == 0) {
			return 1;
		}
		return b * elevar(b, e - 1);
	}

	@Override
	public String invertirCadena(String numero) {
		String resultado = "";
		for (int i = numero.length() - 1; i >= 0; i--) {
			resultado += numero.charAt(i);
		}
		return resultado;
	}

	@Override
	public boolean validar(String datos) {
		if (datos == null || datos.isEmpty())
			return false;

		String octetos[] = datos.split("\\.");

		for (int i = 0; i < octetos.length; i++) {
			String frase = octetos[i];
			for (int j = 0; j < frase.length(); j++) {
				char c = (char) frase.charAt(j);
				if (c < 48 || c > 57 || octetos.length > 4 || !datos.contains(".")) {
					return false;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			if ((Integer.valueOf(octetos[i]) < 0) || (Integer.valueOf(octetos[i]) > 255) || octetos[i].equals(".")) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String completar(String octeto, int limite) {
		for (int i = octeto.length(); i < limite; i++) {
			octeto = "0" + octeto;
		}
		return octeto;
	}

	@Override
	public String divIP(String ip) {
		String res = "";
		for (int i = 0, j = 8; i < 32; i += 8, j += 8) {
			if (i < 24) {
				res += ip.substring(i, j) + ".";
			} else {
				res += ip.substring(i, j);
			}
		}
		return res;
	}

}
