package demo.entities;
import demo.entities.*;

public class Item {
	//private Products product=new Products();
	private ProductLanguages productLanguages=new ProductLanguages();
	private int quantity;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(ProductLanguages productLanguages, int quantity) {
		super();
		this.productLanguages = productLanguages;
		this.quantity = quantity;
	}
	public ProductLanguages getProductLanguages() {
		return productLanguages;
	}
	public void setProductLanguages(ProductLanguages productLanguages) {
		this.productLanguages = productLanguages;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
