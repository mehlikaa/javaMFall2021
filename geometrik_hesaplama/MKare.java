package geometrik_hesaplama;

public class MKare extends MSekil {

	public MKare(double uzunKenar, double kisaKenar) {

		super(uzunKenar, kisaKenar);

	}

	@Override
	public String toString() {
		return "Kenar uzunlugu=" + kisaKenar;
	}

}
