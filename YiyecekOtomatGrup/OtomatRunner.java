package YiyecekOtomatGrup;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class OtomatRunner {

	static Scanner scan = new Scanner(System.in);
	static Otomat urun = new Otomat();
	static int secim = 0;
	static int adet;
	static boolean flag = true;
	static double araToplam;
	static double toplamTutar=0;
	static double odeme;
	static double kalan;

	public static void main(String[] args) {

		System.out.println("\n====   YIYECEK OTOMATIMIZA HOSGELDINIZ  ====\n");
		System.out.println("Bugun sansli gununuzdesiniz, ramdom(rasgele) secilmis urununuzu odemenizle birlikte almayi unutmayin\n");
		menu();

	}

	private static void menu() {
		System.out.print(
				"===    M E N U    ===\n1- Urunlerim \n2- Siparis \n3- Sepetim \n4 - Odeme\n5- Cikis\n\n==> Seciminiz : ");

		secim = scan.nextInt();
		while (!((secim > 0) && (secim < 6))) {
			System.out.print("Lutfen, menu seceneklerimizden birini giriniz.Seciminiz : ");
			secim = scan.nextInt();
		}
		secim();

	}

	private static void secim() {
	
		while (!((secim > 0) && (secim < 6))) {
			System.out.print("Lutfen, menu seceneklerimizden birini giriniz. Seciminiz : ");
			secim = scan.nextInt();
		}
		
		switch (secim) {
		case 1:
			listeleme();
			break;
		case 2:
			siparis();
			break;
		case 4:
			odeme();
			break;
		case 3:
			sepetim();
			break;
			
		case 5:
			cikis();
			break;

		}

	}

	
		
	

	private static void listeleme() {
		System.out.println("===== URUNLERIMIZ ====");
		System.out.println("Sira__Urun_____Fiyat___");


		for (int i = 0; i < urun.getUrun().size(); i++) {
			String say="";
			for (int j = 0; j < (30-urun.getUrun().get(i).length() ); j++) {
				
				say+=".";
			}
			if((i >= 0) && (i <9)){
			System.out.println("0"+(i + 1) + "  -   " + urun.getUrun().get(i) +say + urun.getFiyat().get(i));
			}else {
				System.out.println((i + 1) + "  -   " + urun.getUrun().get(i) +say + urun.getFiyat().get(i));
			}
		}
		siparis();
	}

	private static void siparis() {
		
		do {
			System.out.print("Seciminiz :");
			secim = scan.nextInt();
			if ((secim > 0) && (secim < 16)) {
				System.out.print("Kac adet almak istiyorsunuz :");
				adet = scan.nextInt();
			}
		} while (!((secim > 0) && (secim < 16)));

		for (int i = 0; i < urun.getUrun().size(); i++) {
			if (secim == (i + 1)) {
				araToplam = urun.getFiyat().get(i) * adet;
				System.out.println("Siparisiniz : " +adet +"  adet  "+ urun.getUrun().get(i)+".........."+urun.getFiyat().get(i)+"==> "+(adet*urun.getFiyat().get(i)));
				
			urun.sepetim.add(adet+" adet "+ urun.getUrun().get(i)+"("+urun.getFiyat().get(i) +")"+ "....."+ (adet*urun.getFiyat().get(i)));
				
				
			}

		}
		
		toplamTutar += araToplam;
		System.out.println(" Toplam Tutar : "+ toplamTutar);
		flag = true;
		while (flag) {
			System.out.print("Yeni bir urun secmek istiyor musunuz?(E/H) ");
			char secimC = scan.next().charAt(0);
			if ((secimC == 'e') || (secimC == 'E')) {
				siparis();
				flag = false;
			} else if ((secimC == 'h') || (secimC == 'H')) {
				sepetim();
				odeme();
				flag = false;
			}
			
		}
		
	}
	private static void sepetim() {
		System.out.println("\nSepet :Tutari : "+toplamTutar);
		for (int i = 0; i < urun.sepetim.size(); i++) {
			System.out.println((i+1)+"- "+urun.sepetim.get(i));
		}
	

			System.out.print("\n1- Odeme\n2- Alisverise devam etmek \n3- Urun silmek  \nSeciminiz : ");
			int sec=scan.nextInt();
			switch (sec) {
			case 1:
				odeme();
				break;
			case 2:
				listeleme();
				siparis();
				break;
			case 3:
				flag=true;
				while(flag) {
				System.out.print("Hangi suradaki urunu silmek istersiniz : (Sepetim icin, 0)");
				int sil=scan.nextInt();
				if (sil==0) {
					flag=false;
					sepetim();
				}else {
				urun.sepetim.remove(sil-1);
				for (int i = 0; i < urun.sepetim.size(); i++) {
					System.out.println((i+1)+"- "+urun.sepetim.get(i));
				}
				System.out.println("Baska bir urun sil ");
				}
				
				}break;
				default:
					System.out.println("Lutfen sira numaralarindan birini giriniz ...");
					sepetim();
					break;
					
			}
			
	}
		

	private static void odeme() {
		System.out.println(" \nOdenecek Tutariniz :" + toplamTutar);
		flag = true;
		System.out.print("Odemeyi; 1, 5, 10 ve 20 Tl  seklinde yapabilirsiniz.\nOdeme tutariniz :  ");
		odeme = scan.nextDouble();
		if((odeme==1)||(odeme==5)||(odeme==10)||(odeme==20)) {
		kalan = toplamTutar - odeme;
		while (flag) {

			System.out.print("Kalan : " + kalan);
			if ((kalan > 0) && ((kalan==1)||kalan==5)||(kalan==10)||(kalan==20)) {
				System.out.print("Kalan odeme tutariniz : " + kalan + "\nYeni odemeniz :");
				odeme = scan.nextDouble();
				kalan -= odeme;
				odeme();
			}
			else{
				System.out.println("\nAlacaginiz para ustu : " + kalan);
				flag = false;
				cikis();
			}
		}
		}else  if(kalan<0){//System.out.println("Sadece; 1-5-10-20 seklinde odeme yapabilirsiniz.");
				odeme();
		}

	}

	private static void cikis() {
		Random rand = new Random();
		int a = rand.nextInt(15);
		System.out.println("\nRasgele sectigimiz hediye urunumuz; " + urun.getUrun().get(a).toUpperCase() + "   afiyet olsun.\n");

		System.out.println("\n˜˜˜˜˜˜˜~YINE BEKLERIZ ˜˜˜˜˜˜˜˜");

	}
}
