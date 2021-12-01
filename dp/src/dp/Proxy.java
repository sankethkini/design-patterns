package dp;

interface Server{
	void request();
}

class RealServer implements Server{

	@Override
	public void request() {
		System.out.println("request body real server");
	}
	
}

class ProxyServer implements Server{

	Server theOriginal;
	
	public ProxyServer(Server someServer) {
		this.theOriginal=someServer;
	}
	private boolean authorize(){
		return true;
	}
	@Override
	public void request() {
		if(authorize()) {
			theOriginal.request();
		}
		else
		{
			System.out.println("user not authorized");
		}
	}
}

public class Proxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server myserver=new ProxyServer(new RealServer());
		myserver.request();
	}

}
