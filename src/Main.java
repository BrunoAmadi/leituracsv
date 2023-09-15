import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entities.Product;


public class Main {

	public static void main(String[] args) {

		List<Product> listP = new ArrayList<>();
		
		String path = "vendas.csv";
		File file = new File(path);
		Scanner sc = null;
		
		try {
			sc = new Scanner (file);
			while(sc.hasNextLine()) {
		// cortando cada linha da leitura do arquivo e colocando em um array de string
				
			String[] linhas = sc.nextLine().split(",");
			
		// fazendo casting de cada valor do array e transformando em outro tipo
			int id = Integer.parseInt(linhas[0].trim());
			String nomeP = linhas[1].trim();
			double value = Double.parseDouble(linhas[2]);
			int qntVendida = Integer.parseInt(linhas[3]);
			String data = linhas[4].substring(0,10);
			LocalDate dataVenda = LocalDate.parse(data);

			
			// instanciando o Obj produto
			Product product = new Product(id,nomeP, value, qntVendida, dataVenda);
			
			// adicionando um produto(Objeto) na lista
			listP.add(product);
			
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
			
		}finally {
			sc.close();
		}
		
		double sum = 0.0;
		int totalItens = 0;

		
        Collections.sort(listP, new Comparator<Product>() {
            public int compare(Product product1, Product product2) {
                return Integer.compare(product2.getQntVendida(), product1.getQntVendida());
            }
            
        });
        
  
    		for(Product product : listP) {
    			
    		System.out.println("Id: " + product.getId() );
    		System.out.println("Nome: " + product.getName() );
    		System.out.println("Valor: " + product.getValue() );
    		System.out.println("Quantidade vendida: " + product.getQntVendida() );	
    		System.out.println();

    		}

    				
    		
    		System.out.println();
    		System.out.println("======================================================================");
    		System.out.println("Mais vendidos: ");
    
        
    			for(int i = 0; i < 3; i++){
				
				System.out.println("Id: $" + listP.get(i).getId());
				System.out.println("Nome: $" + listP.get(i).getName());
				System.out.println("Valor: $" + listP.get(i).getValue());


			}
    	
    	// percorrendo a lista e mostrando na tela o valor total e a quantidade total;
		for(Product product : listP) {
			
			sum += product.totalValue();
			totalItens += product.getQntVendida();		
		
		}
		
		
		
		
		
			System.out.printf("valor total: $ %.2f%n", sum);
			System.out.printf("Quantidade total: %d%n", totalItens);
		
		

	}

}
