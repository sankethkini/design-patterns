package dp;
interface Movable{
	double speed();
}
interface MovableAdapter{
	double speed();
}

class Mycar implements Movable{

	@Override
	public double speed() {
		return 200.0;
	}
	
}
class MphToKmph implements MovableAdapter{

	Movable mcar;
	MphToKmph(Movable c){
		this.mcar=c;
	}
	@Override
	public double speed() {
		return mphtokmph(mcar.speed());
	}
	private double mphtokmph(double sp) {
		return 1.6*sp;
	}
	
}
public class Adapter {
	MovableAdapter myadapt=new MphToKmph(new Mycar());
}
