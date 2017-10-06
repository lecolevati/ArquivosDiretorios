package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosDiretorios;
import controller.IArquivosDiretorios;

public class Principal {

	public static void main(String[] args) {
//		String absolutePath = "C:\\TEMP\\teste1.xls";
//		IArquivosDiretorios ad = 
//				new ArquivosDiretorios();
//		try {
//			ad.abreArquivoApp(absolutePath);
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, 
//					e.getMessage(), "ERRO",
//					JOptionPane.ERROR_MESSAGE);
//		}
		String absolutePath = "C:\\TEMP\\relatorio.pdf";
		IArquivosDiretorios ad = 
				new ArquivosDiretorios();
		try {
			ad.propriedades(absolutePath);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
