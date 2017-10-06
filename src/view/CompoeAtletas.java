package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompoeAtletas {

	public static void main(String[] args) throws IOException {
		
		BufferedReader readAtletas = new BufferedReader(new FileReader("C:\\TEMP\\inputAtletas.txt"));
		FileWriter fw = new FileWriter("C:\\TEMP\\outputAtletas.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		List<String> lstAtletasIni = new ArrayList<String>();

		String linha = readAtletas.readLine();
		while (linha != null) {
			int indice = linha.indexOf(" ");
			if (linha.charAt(indice - 1) == 'a') {
				linha = "2  " + linha;

			} else if ((linha.charAt(indice - 1) == 'o')) {
				linha = "1  " + linha;
			} else {
				linha = "99  " + linha;
			}
			lstAtletasIni.add(linha);
			linha = readAtletas.readLine();
		}
		readAtletas.close();

		for (String lst : lstAtletasIni) {
			bw.write(lst + "\r\n");
		}

		bw.close();
		fw.close();
	}
}