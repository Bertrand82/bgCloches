package bg;
public class MainCalculVolume {
	
	ProfilCloche pc = new ProfilCloche(10., 20., 30.);
	
	public static void main(String[] args) {
		CalculVolume cv_14 = new CalculVolume( FactoryProfils.getProfils_R14());
		CalculVolume cv_12 = new CalculVolume( FactoryProfils.getProfils_R12());
	}

}
