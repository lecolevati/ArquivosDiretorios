package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosDiretorios implements 
	IArquivosDiretorios {

	@Override
	public void leDiretorio(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()){
			File[] lista = dir.listFiles();
			for (File f : lista){
				if (f.isDirectory()){
					System.out.println("["+
							f.getName()+"]");
				}
			}
			for (File f : lista){
				if (f.isFile()){
					System.out.println(f.getName());
				}
			}
		} else {
			throw new IOException("Diret�rio Inv�lido");
		}
	}

	@Override
	public void criaTxt(String path, String nome) throws IOException {
		File dir = new File(path);
		File arquivo = new File(path, nome + ".txt");
		if (dir.exists()){
			boolean arquivoExiste = false;
			if (arquivo.exists()){
				arquivoExiste = true;
			}
			String conteudo = geraConteudoTxt();
			FileWriter fw = 
				new FileWriter(arquivo, arquivoExiste);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(conteudo);
			pw.flush();
			pw.close();
			fw.close();
		} else {
			throw new IOException("Diret�rio Inv�lido");
		}
	}

	@Override
	public void leTxt(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()){
			FileInputStream fluxo =
				new FileInputStream(arquivo);
			InputStreamReader leitor = 
				new InputStreamReader(fluxo);
			BufferedReader buffer = 
				new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inv�lido");
		}
	}
	
	private String geraConteudoTxt(){
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (!linha.equals("fim")){
			linha = JOptionPane.showInputDialog(null,
					"Digite uma frase", "Entrada",
					JOptionPane.INFORMATION_MESSAGE);
			buffer.append(linha+"\r\n");
		}
		return buffer.toString();
	}

	@Override
	public void abreArquivoApp(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()){
			Desktop desk = Desktop.getDesktop();
			desk.open(arquivo);
		} else {
			throw new IOException("Arquivo Inv�lido");
		}
	}

	@Override
	public void propriedades(String absolutePath) throws IOException {
		File arquivo = new File(absolutePath);
		if (arquivo.exists()){
			if (arquivo.canRead()){
				System.out.println("Permite leitura");
			} else {
				System.out.println("N�o permite leitura");
			}
			if (arquivo.canWrite()){
				System.out.println("Permite escrita");
			} else {
				System.out.println("N�o permite escrita");
			}
			System.out.println(arquivo.getTotalSpace());
			if (arquivo.isHidden()){
				System.out.println("Arquivo oculto");
			} else {
				System.out.println("Arquivo vis�vel");
			}
		} else {
			throw new IOException("Arquivo inv�lido");
		}
	}
	
}
