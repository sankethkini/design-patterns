package dp;

interface Stateinf{
	void print();
}
class ConcreteA implements Stateinf
{
	public void print()
	{
		System.out.println("A state");
	}
}
class ConcreteB implements Stateinf
{
	public void print()
	{
		System.out.println("B state");
	}
}

public class State {
	//Context class
	
	Stateinf state;
	State(Stateinf init)
	{
		this.state=init;
	}
	public void setState(Stateinf state) {
		this.state = state;
	}
	public void print()
	{
		this.state.print();
	}
	public static void main(String args[])
	{
		State curr=new State(new ConcreteA());
		curr.print();
		curr.setState(new ConcreteB());
		curr.print();
	}
}
