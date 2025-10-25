package bg;

import java.util.ArrayList;
import java.util.List;

public class CalculVolume {
	
	List<ProfilCloche> profils;
	List<ProfilCloche> profilsNormalized = new ArrayList<>();
	double dz=0.1;
	double hauteurTotal=0.;
	double volumeTotal=0.;
	double poidTotal=0.;
	double rayonMax=0.;
	static final double densiteBronze_g_cm3 =8.7; // g/cm3
	
	public	CalculVolume(List<ProfilCloche> profils) {
		this.profils =profils;
		System.out.println("CalculVolume instance created.");
		hauteurTotal=profils.get(profils.size()-1).z;
		rayonMax=profils.get(profils.size()-1).r1;
		normalizeProfils();
		
		volumeTotal =calculateVolume();
		poidTotal = volumeTotal * densiteBronze_g_cm3 ; // g
		System.out.println("---- Résultats ----");
		System.out.println("Rayon max: " + String.format("%8.3f", rayonMax) + " cm");
		System.out.println("Hauteur totale: " + String.format("%8.3f", hauteurTotal) + " cm");
		System.out.println("Volume total: " + String.format("%8.3f", volumeTotal) + " cm3");
		System.out.println("Poid total: " + String.format("%8.3f", poidTotal) + " g");
		System.out.println("Volume total: " + String.format("%8.3f", volumeTotal/1000.) + " litres");
		System.out.println("Poid total: " + String.format("%8.3f", poidTotal/1000.) + " kg");
	}


	private double calculateVolume() {
		double v =0.;
		for(int i=0; i<profilsNormalized.size()-1; i++) {
			ProfilCloche p1 = profilsNormalized.get(i);
			ProfilCloche p2 = profilsNormalized.get(i+1);
			double r1 = p1.r1;
			double r2 = p2.r1;
			double h = p2.z - p1.z;
			double e =( p1.e+p2.e)/2.;
			double r = (r1 + r2)/2.;
			double vSegment = Math.PI *h*e*2*r;
			v+=vSegment;
		}	
		return v;
	}


	private void normalizeProfils() {
		for (double z=0.; z<=hauteurTotal; z+=dz) {
			double rInterpolated = interpolateRAtZ(z);
			double eInterpolated = interpolateEAtZ(z);
			profilsNormalized.add( new ProfilCloche(z, rInterpolated, eInterpolated) );
		}	
		
	}


	private double interpolateEAtZ(double z) {
		for (int i=0; i<profils.size()-1; i++) {
			ProfilCloche p1 = profils.get(i);
			ProfilCloche p2 = profils.get(i+1);
			if (z>=p1.z && z<=p2.z) {
				double eInterpolated = p1.e + (p2.e - p1.e)*(z - p1.z)/(p2.z - p1.z);
				return eInterpolated;
			}
		}
		return 0.;
	}

	private double interpolateRAtZ(double z) {
		for (int i=0; i<profils.size()-1; i++) {
			ProfilCloche p1 = profils.get(i);
			ProfilCloche p2 = profils.get(i+1);
			if (z>=p1.z && z<=p2.z) {
				double rInterpolated = p1.r1 + (p2.r1 - p1.r1)*(z - p1.z)/(p2.z - p1.z);
				return rInterpolated;
			}
		}
		return 0.;
		
	}
}
