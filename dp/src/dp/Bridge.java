package dp;

interface Shape{
	void print();
	void make();
}

interface Color{
	String mycolor();
	void paint();
}

class Square implements Shape{

	Color cur;
	Square(Color c)
	{
		this.cur=c;
	}
	@Override
	public void print() {
		System.out.println("I am square with"+cur.mycolor());
	}

	@Override
	public void make() {
	     System.out.println("square made");
	}
	
}

class Red implements Color{
	String color;

	Red(String c)
	{
		this.color=c;
	}
	@Override
	public String mycolor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		System.out.println("painted with "+color+"color");
	}
	
}

public class Bridge {
	
 public static void main(String[] args) {
	Shape sq=new Square(new Red("red"));
	sq.make();
	sq.print();
 }
}
