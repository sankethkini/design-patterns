package dp;
import java.util.*;

class Vehicle implements Cloneable{
	private List<String> mylist;
	Vehicle(){
		this.mylist=new ArrayList<>();
	}
	Vehicle(List<String> list)
	{
		this.mylist=list;
	}
	public void insertData() {
		mylist.add("veh 1");
		mylist.add("veh 2");
		mylist.add("veh 3");
		mylist.add("veh 4");
		mylist.add("veh 5");
	}
	@Override
	public Vehicle clone() throws CloneNotSupportedException{
		List<String> cur=new ArrayList<>();
		for(String s:this.mylist)
		{
			cur.add(s);
		}
		return new Vehicle(cur);
	}
	public void print()
	{
		for(String s:this.mylist)
		{
			System.out.println(s);
		}
	}
	public List<String> getList(){
		return this.mylist;
	}
	
}
public class Prototype {
	public static void main(String args[]) throws CloneNotSupportedException{
		Vehicle a=new Vehicle();
		a.insertData();
		Vehicle b=a.clone();
		b.print();
		b.getList().remove("veh 1");
		b.print();
	}
}
