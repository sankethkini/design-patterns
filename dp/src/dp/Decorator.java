package dp;

abstract class Pizza{
	String description="Unknown";
	public String getDescription() {
		return description;
	}
	abstract public int getCost();
}
abstract class ToppingsDecorator extends Pizza{
	abstract public String getDescription();
}
class PeppyPaneer extends Pizza{

	PeppyPaneer(){
		description="peppy paneer";
	}
	@Override
	public int getCost() {
		return 40;
	}
	
}
class FarmHouse extends Pizza
{
    public FarmHouse() {  description = "FarmHouse"; }
    public int getCost() { return 200; }
}
class Margherita extends Pizza
{
    public Margherita()  { description = "Margherita"; }
    public int getCost() { return 100;  }
}
class ChickenFiesta extends Pizza
{
    public ChickenFiesta() { description = "ChickenFiesta";}
    public int getCost() { return 200; }
}
class SimplePizza extends Pizza
{
	public SimplePizza() { description = "SimplePizza"; }
	public int getCost() {  return 50;  }
}
class FreshTomato extends ToppingsDecorator{

	Pizza pizza;
	FreshTomato(Pizza pizz){
		this.pizza=pizz;
	}
	@Override
	public String getDescription() {
		return pizza.getDescription()+","+"fresh tomato";
	}

	@Override
	public int getCost() {
		return pizza.getCost()+30;
	}
	
}
class Barbeque extends ToppingsDecorator
{
    Pizza pizza;
    public Barbeque(Pizza pizza) {  this.pizza = pizza;  }
    public String getDescription() {
        return pizza.getDescription() + ", Barbeque ";
    }
    public int getCost() { return 90 + pizza.getCost(); }
}
class Paneer extends ToppingsDecorator
{
    Pizza pizza;
    public Paneer(Pizza pizza)  {  this.pizza = pizza; }
    public String getDescription() {
        return pizza.getDescription() + ", Paneer ";
    }
    public int getCost()  {  return 70 + pizza.getCost(); }
}

public class Decorator {
	public static void main(String args[])
	{
		Pizza pizza = new Margherita();
        System.out.println( pizza.getDescription() +
                         " Cost :" + pizza.getCost());
  
        // create new FarmHouse pizza
        Pizza pizza2 = new FarmHouse();
  
        // decorate it with freshtomato topping
        pizza2 = new FreshTomato(pizza2);
  
        //decorate it with paneer topping
        pizza2 = new Paneer(pizza2);
  
        System.out.println( pizza2.getDescription() +
                         " Cost :" + pizza2.getCost());
       
	}
}
