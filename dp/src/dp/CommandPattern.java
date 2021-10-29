package dp;

interface Command{
	void execute();
}

class Light
{
	public void swithon()
	{
		System.out.println("lights on");
	}
	public void swithoff()
	{
		System.out.println("lioghts off");
	}
}
class Lightson implements Command
{
	Light light;
	
	public Lightson(Light light) {
		super();
		this.light = light;
	}
	@Override
	public void execute() {
		
		light.swithon();
	}
	public void setLight(Light light) {
		this.light = light;
	}
}
class Lightsoff implements Command
{
	Light light;
	public Lightsoff(Light light) {
		super();
		this.light = light;
	}
	@Override
	public void execute() {
		light.swithoff();
	}
	public void setLight(Light light) {
		this.light = light;
	}
	
}
class Remote
{
	Command c;
	public void execute()
	{
		c.execute();
	}
	public void setC(Command c) {
		this.c = c;
	}
	
}
public class CommandPattern {
	public static void main(String[] args) {
		Remote r=new Remote();
		Light myLight=new Light();
		
		r.setC(new Lightson(myLight));
		r.execute();
		r.setC(new Lightsoff(myLight));
		r.execute();
	}
}
