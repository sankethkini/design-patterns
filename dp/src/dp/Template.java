package dp;

abstract class Network {
    String userName;
    String password;

   
    
    public boolean post(String message) {
        
        if (logIn(this.userName, this.password)) {
            
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
class Facebook extends Network{
	
	@Override
	boolean logIn(String userName, String password) {
		if(userName=="sank" && password=="1234")
		{
			super.userName=userName;
			super.password=password;
			System.out.println("logging in facebook");
			return true;
		}
		return false;
	}

	@Override
	boolean sendData(byte[] data) {
		System.out.println(data);
		return true;
	}

	@Override
	void logOut() {
		// TODO Auto-generated method stub
		System.out.println("logged out of facebook");
	}
	
}
class Twitter extends Network{

	
	boolean logIn(String userName, String password) {
		if(userName=="sank" && password=="1234")
		{
			super.userName=userName;
			super.password=password;
			System.out.println("logging in facebook");
			return true;
		}
		return false;
	}

	@Override
	boolean sendData(byte[] data) {
		System.out.println(data);
		return true;
	}

	@Override
	void logOut() {
		// TODO Auto-generated method stub
		System.out.println("logged out of facebook");
	}
	
	
}
public class Template {
	public static void main(String[] args) {
		Network net=new Facebook();
		net.logIn("sank", "1234");
		net.post("some thing");
	}
}
