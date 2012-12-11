/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca.ui;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Util {
	
	private static Scanner in = new Scanner(System.in);
	
	public static String lerString(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		String entrada = "";
		do{
			entrada = JOptionPane.showInputDialog(msg);
			if(entrada == null || entrada.equals(""))
				alert("Entrada inválida!");
			else
				fim = true;
		}while(!fim);
		return entrada;
	}

	public static int lerInteiro(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		int valor = 0;
		do{
			try{
				String entrada = "";
				entrada = lerString(msg);
				valor = Integer.parseInt(entrada);
				fim = true;
			}catch(Exception e){
				alert("Entrada inválida!");
			}
		}while(!fim);
		return valor;
	}

	
	public static void alert(String msg){
		JOptionPane.showMessageDialog(null,msg);
	}

}
