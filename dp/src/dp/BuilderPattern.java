package dp;

class Computer{
	private String ram;//required
	private String storage;//required
	private String display;//optional
	private String os;//optional
	private Computer(ComputerBuilder build) {
		this.ram=build.ram;
		this.storage=build.storage;
		this.display=build.display;
		this.os=build.os;
	}
	
	static class ComputerBuilder{
		private String ram;//required
		private String storage;//required
		private String display;//optional
		private String os;//optional
		ComputerBuilder(String ram,String storage){
			this.ram=ram;
			this.storage=storage;
		}
		public ComputerBuilder setDisplay(String display) {
			this.display = display;
			return this;
		}
		public ComputerBuilder setOs(String os) {
			this.os = os;
			return this;
		}
		public Computer build() {
			return new Computer(this);
		}
	}

	public void print() {
		System.out.println(this.ram+this.storage+this.display+this.os);
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		Computer cp=new Computer.ComputerBuilder("8gb","512 ssd").setDisplay("simple").build();
		cp.print();
	}

	
}
