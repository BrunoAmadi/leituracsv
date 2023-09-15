package entities;
import java.time.LocalDate;
import java.util.Date;

public class Product {

	private int id;
	private String name;
	private double value;
	private LocalDate date;
	private int qntVendida;

	public Product(int id, String name, double value, int qntVendida, LocalDate date) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.qntVendida = qntVendida;
		this.date = date;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getValue() {
		return this.value;

	}
	
	public int getQntVendida() {
		return this.qntVendida;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public double totalValue() {
	
		 return this.qntVendida * this.value;
		
	}

}
