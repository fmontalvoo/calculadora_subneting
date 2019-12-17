
public class Conversor {

	public int binario_decimal(String binario, int base) {
		int resultado = 0;
		for (int i = binario.length() - 1, j = 0; i >= 0; i--, j++)
			resultado += Integer.parseInt("" + binario.charAt(i)) * elevar(base, j);
		return resultado;
	}

	public String decimal_binario(int numero) {
		String binario = "";
		if (numero == 0)
			return "0";
		for (int i = numero; i > 0; i /= 2)
			binario += i % 2;
		return invertir(binario);
	}

	public String clase(String octetos[]) {
		int clase = Integer.valueOf(octetos[0]);
		if (clase >= 0 && clase <= 127)
			return "A";
		if (clase >= 128 && clase <= 191)
			return "B";
		if (clase >= 192 && clase <= 223)
			return "C";
		if (clase >= 224 && clase <= 239)
			return "D";
		if (clase >= 240 && clase <= 255)
			return "E";
		return "";
	}

	public String ipBinaria(String octetos[]) {
		String binarios = "";
		for (int i = 0; i < octetos.length; i++)
			if (i < 3)
				binarios += completar(decimal_binario(Integer.valueOf(octetos[i])), 8) + ".";
			else
				binarios += completar(decimal_binario(Integer.valueOf(octetos[i])), 8);
		return binarios;
	}

	public String ipDecimal(String octetos[]) {
		String decimales = "";
		for (int i = 0; i < octetos.length; i++)
			if (i < 3)
				decimales += binario_decimal(octetos[i], 2) + ".";
			else
				decimales += binario_decimal(octetos[i], 2);
		return decimales;
	}

	public String ipRed_Broadcats(String ipBinaria, int mascara, String a, String b) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara) + "" + ip.substring(mascara, 32).replace(a, b);
		return divIP(ipRes);
	}

	public String mascara_Red(String ipBinaria, int mascara) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara).replace("0", "1") + "" + ip.substring(mascara, 32).replace("1", "0");
		return divIP(ipRes);
	}

	public String wildcard(String ipBinaria, int mascara) {
		String ip = ipBinaria.replace(".", "");
		String ipRes = ip.substring(0, mascara).replace("1", "0") + "" + ip.substring(mascara, 32).replace("0", "1");
		return divIP(ipRes);
	}

	public String ipHost(String octetos[], int n) {
		String host = "";
		for (int i = 0; i < octetos.length; i++)
			if (i < 3)
				host += octetos[i] + ".";
			else
				host += (Integer.valueOf(octetos[i]) + n);
		return host;
	}

	public String[] subnetting(String ipBinaria, int mascara, int nuevaMascara, int numRedes) {
		String subRedes[] = new String[numRedes];
		String ip = ipBinaria.replace(".", "");
		for (int i = 0; i < numRedes; i++) {
			subRedes[i] = (i + 1) + ") "
					+ ipDecimal(divIP(ip.substring(0, mascara)
							+ completar("" + decimal_binario(Integer.valueOf(i)), nuevaMascara - mascara)
							+ ip.substring(nuevaMascara, 32)).split("\\."))
					+ "/" + nuevaMascara;
		}

		return subRedes;
	}

	public int elevar(int b, int e) {
		int res = b;
		if (e == 0)
			res = 1;
		else
			for (int i = 1; i < e; i++)
				res *= b;
		return res;
	}

	public String invertir(String numero) {
		String resultado = "";
		for (int i = numero.length() - 1; i >= 0; i--)
			resultado += numero.charAt(i);
		return resultado;
	}

	public boolean validar(String datos) {

		String octetos[] = datos.split("\\.");

		for (int i = 0; i < octetos.length; i++) {
			String frase = octetos[i];
			for (int j = 0; j < frase.length(); j++) {
				char c = (char) frase.charAt(j);
				if (c < 48 || c > 57 || octetos.length > 4 || !datos.contains("."))
					return false;
			}
		}
		for (int i = 0; i < 4; i++)
			if ((Integer.valueOf(octetos[i]) < 0) || (Integer.valueOf(octetos[i]) > 255) || octetos[i].equals("."))
				return false;
		return true;
	}

	public String completar(String octeto, int limite) {
		for (int i = octeto.length(); i < limite; i++)
			octeto = "0" + octeto;
		return octeto;
	}

	public String divIP(String ip) {
		String res = "";
		for (int i = 0, j = 8; i < 32; i += 8, j += 8) {
			if (i < 24)
				res += ip.substring(i, j) + ".";
			else
				res += ip.substring(i, j);
		}
		return res;
	}

}
