package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;


public class Main {

	public static void main(String[] args) {
		String strpath = "D:\\eclipse\\projetos\\Trabalhando_com_Arquivos\\exercicio.txt";
		String newstrpath = "D:\\eclipse\\projetos\\Trabalhando_com_Arquivos\\summary.txt";
		File path = new File (strpath);
		File newpath = new File (newstrpath);
		String []produtos = new String [3];
		List<Produto> list = new ArrayList<>();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path));){
			String produto = br.readLine();
			while(produto != null) {
				produtos = produto.split(",");
				String nome = produtos[0];
				double preco = Double.parseDouble(produtos[1]);
				int quant = Integer.parseInt(produtos[2]);
				Produto prod = new Produto(nome,preco,quant);
				list.add(prod);
				System.out.println(prod.toString()); 
				produto = br.readLine();
				
			}
			
		
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(newpath))){
				for(Produto pro : list ) {
					bw.write(pro.toString());
					bw.newLine();
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
