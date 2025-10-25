package bg;

import java.util.List;

public class FactoryProfils {

	public static List<ProfilCloche> getProfils_R14() {
		List<ProfilCloche> profils = List.of(
				new ProfilCloche(0., 4., 7.),
				new ProfilCloche(1., 6., 4.),
				new ProfilCloche(2., 8., 2.),
				new ProfilCloche(3., 8.5, 1.5),
				new ProfilCloche(4., 9., 1.3),	
				new ProfilCloche(5., 9.5, 1.1),
				new ProfilCloche(6., 9.5, 1.),	
				new ProfilCloche(10., 9.5, 1.),
				new ProfilCloche(15., 10., 1.4),
				new ProfilCloche(20., 11.5, 2.),
				new ProfilCloche(20., 11.5, 2.),
				new ProfilCloche(25., 14., 2.),
				new ProfilCloche(28., 15., 1.)
				);	
		return profils;
	}
	
	public static List<ProfilCloche> getProfils_R12() {
		List<ProfilCloche> profils = List.of(
				new ProfilCloche(0., 2.5, 5.),
				new ProfilCloche(1., 6., 2.),
				new ProfilCloche(2., 7.,1.5 ),
				new ProfilCloche(3., 7.5, 1.25),
				new ProfilCloche(4., 8., 1.2),
				new ProfilCloche(5., 8., 1.),
				new ProfilCloche(10.,8. , 1.),
				new ProfilCloche(15.,9. , 1.3),
				new ProfilCloche(20.,11. , 2.),
				new ProfilCloche(21.,11.5 ,1.5 ),
				new ProfilCloche(22.,12. , 1.5),
				new ProfilCloche(23., 12., 1.),
				new ProfilCloche(24., 12., 1.)
				
				
				);	
		return profils;
	}

}
