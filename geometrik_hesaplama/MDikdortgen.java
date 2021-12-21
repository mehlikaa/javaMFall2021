package geometrik_hesaplama;

public class MDikdortgen extends MSekil {

	public MDikdortgen(double uzunKenar, double kisaKenar) {

		super(uzunKenar, kisaKenar);

	}

	public double dikdortgenCevre() {
		return (uzunKenar + kisaKenar) * 2;

	}

	public double dikdortgenAlan() {
		return (uzunKenar * kisaKenar);

	}

	@Override
	public String toString() {
		return "Dikdortgen  uzunKenar=" + uzunKenar + ", kisaKenar=" + kisaKenar ;
	}
}
