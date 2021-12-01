package dp;
import java.util.*;

interface Iterator1{
	boolean hasNext();
	Object moveNext();
}

interface Iterable1{
	Iterator1 createIterator();
}

class MyCollection implements Iterable1{

	List<Integer> cur=new ArrayList<>();
	@Override
	public ConcreteIterator createIterator() {
		return new ConcreteIterator(this);
	}
	void addItem(Integer a)
	{
		cur.add(a);
	}
	Integer remove()
	{
		return cur.remove(0);
	}
}
class ConcreteIterator implements Iterator1{

	 MyCollection item;
	 Iterator<Integer> iter;
	public ConcreteIterator(MyCollection cur) {
		this.item=cur;
		iter=item.cur.iterator();
	}
	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}

	@Override
	public Integer moveNext() {
		return (Integer) iter.next();
	}
	
}
public class Iteratorpat {
	public static void main(String[] args) {
		MyCollection coll=new MyCollection();
		coll.addItem(2);
		coll.addItem(3);
		ConcreteIterator it=coll.createIterator();
		while(it.hasNext())
		{
			System.out.println(it.moveNext());
		}
		coll.remove();
		
	}
}
