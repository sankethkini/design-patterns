package dp;
interface discounter{
	int getDiscount();
}
class ChristmasDiscount implements discounter{

	@Override
	public int getDiscount() {
		return 10;
	}
}
class EasterDiscount implements discounter{
	@Override
	public int getDiscount() {
		return 5;
	}
}
class context{
	private int rate;
	private discounter d;
	context(int rate,discounter d)
	{
		this.rate=rate;
		this.d=d;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setD(discounter d) {
		this.d = d;
	}
	public int finalprice()
	{
		return rate*d.getDiscount();
	}
}
public class Strategry {
	public static void main(String args[])
	{
		discounter d1=new ChristmasDiscount();
		discounter d2=new EasterDiscount();
		context c=new context(100,d1);
		c.finalprice();
		c.setD(d2);
		c.finalprice();
	}
}
