package geometrik_hesaplama;

public class MSekil {

	static double uzunKenar;
	static double kisaKenar;
	static double yariCap;

	public MSekil(double uzunKenar, double kisaKenar) {
		this.uzunKenar = uzunKenar;
		this.kisaKenar = kisaKenar;
	}

	public MSekil(double yariCap) {
		this.yariCap = yariCap;

	}

	public double cemberAlan() {
		return yariCap * yariCap * 3.14;

	}

	public double dikdortgenCevre() {
		return (uzunKenar + kisaKenar) * 2;

	}

	public double dikdortgenAlan() {
		return uzunKenar * kisaKenar;

	}

	public double kareAlan() {
		uzunKenar = kisaKenar;
		return uzunKenar * kisaKenar;

	}

	public double kareCevre() {
		uzunKenar = kisaKenar;
		return (uzunKenar + kisaKenar) * 2;
	}

}
