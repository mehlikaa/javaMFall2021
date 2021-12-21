package geometrik_hesaplama;

public class MCember extends MSekil{

	static final double piSayi=3.14;
	
	public MCember(double yariCap) {
		
		super(yariCap);
	
	}
		
	public double cevreHesaplama() {
		return (yariCap*2*3.14);
	}

	public double alanHesaplamaCember() {
		return yariCap*yariCap*3.14;
	}

	@Override
	public String toString() {
		return " yariCap=" + yariCap ;
	}

		
	}


