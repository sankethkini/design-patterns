package dp;
abstract class Middleware{
	Middleware next=null;
	public Middleware Linkwith(Middleware next)
	{
		this.next=next;
		return next;
	}
	abstract public boolean check();
	public boolean checkNext() {
		if(this.next==null)
			return true;
		return this.next.check();
	}
}
class Authorize extends Middleware{

	Authorize(){}
	@Override
	
	public boolean check() {
		System.out.println("authorized");
		return checkNext();
	}
	
}
class Authentication extends Middleware{

	@Override
	public boolean check() {
		System.out.println("authnticated");
		return checkNext();
	}
	
}
class Canaccess extends Middleware{

	@Override
	public boolean check() {
		System.out.println("accessed");
		return checkNext();
	}
	
}
public class ChainOfResponsibility {
	public static void main(String[] args) {
		Middleware auth=new Authorize();
		auth.Linkwith(new Authentication());
		auth.next.Linkwith(new Canaccess());
		System.out.println(auth.check());
	}
}
