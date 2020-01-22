public class Vendor{
  // Fields:
  private int price;
  private int stock;
  private int change;
  private int deposit;
  prinvate int totalSale;

  //constructor
  public Vendor(int cents, int stk){
	price = cents;
	stock = stk;
	change = 0;
	deposit = 0;
	totalSale = 0;
  }

  //methods
  public void setStock(int stk){
	  stock = stk;
  }

  public int getStock(){
    return stock;
  }

  public void addMoney(int add){
    deposit += add;
  }
  
  public int getDeposit(){
    return deposit;
  }
  public boolean makeSale(){
	  if (stock == 0){
		  return false;
	  }
	  if (deposit >= price){
		  change = deposit - price;
		  totalSale += price;
		  deposit = 0;
		  stock -= 1;
		  return true;
	  }else{
		  change = deposit;
		  deposit = 0;
		  return false;
	  }
  }

  public int getChange(){
    return change;
  }
  public int getTotalSale(){
	  return totalSale;
  }
  public String toString(){
	  return ("price: " + price + " stock: " + stock + " total sale: " + totalSale);
  }
}
