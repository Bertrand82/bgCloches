package bg;

public class ProfilCloche {
	
	double z = 0;
	double r1 = 0;
	double e = 0;
	public ProfilCloche(double z, double r1, double e) {
		super();
		this.z = z;
		this.r1 = r1;
		this.e = e;
	}
	@Override
	public String toString() {
		return "ProfilCloche [z=" +  String.format("%8.3f", z) + ", r1=" +  String.format("%8.3f", r1) + ", e=" + String.format("%8.3f", e) + "]";
	}

}
