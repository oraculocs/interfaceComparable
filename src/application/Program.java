package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		/*
		 * Faça um programa para ler um arquivo contendo funcionários (nome e salário) no
		 * formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar
		 * o resultado na tela. Nota: o caminho do arquivo pode ser informado "hardcode".
		 * Maria Brown,4300.00
		 * Alex Green,3100.00
		 * Bob Grey,3100.00
		 * Anna White,3500.00
		 * Alex Black,2450.00
		 * Eduardo Rose,4390.00
		 * Willian Red,2900.00
		 * Marta Blue,6100.00
		 * Alex Brown,5000.00
		 */

		List<Funcionario> list = new ArrayList<>();
		String path = "C:\\temp\\comp.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list.add(new Funcionario(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			Collections.sort(list);
			for (Funcionario func : list) {
				System.out.println(func.getNome() + ", " + func.getSalario());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}


