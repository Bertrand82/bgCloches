package bg;
public class MainCalculVolume {
	
	ProfilCloche pc = new ProfilCloche(10., 20., 30.);
	
	public static void main(String[] args) {
		CalculVolume cv = new CalculVolume( FactoryProfils.getProfils_R14());
	}

}
