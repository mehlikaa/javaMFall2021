package YiyecekOtomatGrup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Otomat {
	
	private static List<String> urun = new ArrayList<>(Arrays.asList("Cokonat", "Kitkat", "Ciklet", "Cizi", "Cips", "Bueno",
			"Oreo", "Cekirdek", "Sakiz", "Kakaolu Sut", "Gazoz", "Meyve Suyu", "Kahve", "Cay", "Su"));
	private static List<Double> fiyat=new ArrayList(Arrays.asList(1.50,1.00,0.25,0.75, 1.00,1.25,1.00,0.50,0.50,2.00,1.50,2.50,2.00,0.15,0.25));
	private static List<String> sepetim=new ArrayList<>();
	private static List<Integer> sepetimAdet=new ArrayList<>();
	private static List<Double> sepetimFiyat=new ArrayList<>();
	
	
	public List<String> getUrun() {
		return urun;
	}
	
	public void setUrun(List<String> urun) {
		this.urun = urun;
	}
	
	public List<Double> getFiyat() {
		return fiyat;
	}
	public void setFiyat(List<Double> fiyat) {
		this.fiyat = fiyat;
	}

	@Override
	public String toString() {
		return "Otomat [urun=" + urun + ", fiyat=" + fiyat + "]";
	}

	public static List<String> getSepetim() {
		return sepetim;
	}

	public  static void setSepetim(String sepete) {
		
		sepetim.add(sepete);
		//System.out.println("Sepete eklendi "+ sepete);
		
	}
	public static void setSepetim(List<String> sepetim) {
		Otomat.sepetim = sepetim;
	}


	public static List<Integer> getSepetimAdet() {
		return sepetimAdet;
	}

	public static void setSepetimAdet(List<Integer> sepetimAdet) {
		Otomat.sepetimAdet = sepetimAdet;
	}
	public static void setSepetimAdet(Integer sepetAdet) {
		sepetimAdet.add(sepetAdet);
		//System.out.println("SepetAdete e adet eklendi "+ sepetimAdet);
	}

	public static List<Double> getSepetimFiyat() {
		return sepetimFiyat;
	}

	public static void setSepetimFiyat(Double sepetFiyat) {
		sepetimFiyat.add(sepetFiyat);
	}



	
	
	
}
