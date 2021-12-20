package YiyecekOtomatGrup;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class OtomatRunner2 {

	static Scanner scan = new Scanner(System.in);
	static Otomat urun = new Otomat();
	static int secim = 0;
	static int adet;
	static boolean flag = true;
	static double araToplam;
	static double toplamTutar = 0;
	static double odeme;
	static double kalan;
	static int sil = 25;

	public static void main(String[] args) {

		System.out.println("\n====   YIYECEK OTOMATIMIZA HOSGELDINIZ  ====\n");

		System.out.println(
				"Bugun sansli gununuzdesiniz, random(rasgele) secilmis HEDIYE urununuzu odemenizle birlikte almayi unutmayin\n");
		menu();
	}

	private static void menu() {

		System.out.print(
				"===    M E N U    ===\n1- Urunlerim \n2- Siparis \n3- Sepetim \n4 - Odeme\n5- Cikis\n\n==> Seciminiz : ");
		try {
			secim = scan.nextInt();

			while (!((secim > 0) && (secim < 6))) {

				System.out.print("\t===>Lutfen, menu seceneklerimizden birini giriniz.<==\nSeciminiz : ");
				secim = scan.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.print("\t\t==>Yanlis Giris<==\n");
			scan.nextLine();
			menu();

		}
		secim();
	}

	private static void secim() {

		switch (secim) {
		case 1:
			listeleme();
			break;
		case 2:
			listeleme();
			siparis();
			break;
		case 3:
			sepetim();
			break;
		case 4:
			odeme();
			break;
		case 5:
			cikis();
			break;
		default:
			menu();
			break;
		}

	}

	private static void listeleme() {
		System.out.println("===== URUNLERIMIZ ====");
		System.out.println("Sira__Urun_____Fiyat___");

		for (int i = 0; i < urun.getUrun().size(); i++) {
			String say = "";
			for (int j = 0; j < (30 - urun.getUrun().get(i).length()); j++) {

				say += ".";
			}
			if ((i >= 0) && (i < 9)) {
				System.out.println("0" + (i + 1) + "  -   " + urun.getUrun().get(i) + say + urun.getFiyat().get(i));
			} else {
				System.out.println((i + 1) + "  -   " + urun.getUrun().get(i) + say + urun.getFiyat().get(i));
			}
		}
		System.out.println("\n\t==> Sepet icin;   0 basiniz.");
		siparis();
	}

	@SuppressWarnings("static-access")
	private static void siparis() {
		flag = true;
		try {
			while (flag) {
				do {
					System.out.print("\nSeciminiz : ");
					secim = scan.nextInt();

					if ((secim > 0) && (secim < 16)) {
						System.out.print("Kac adet almak istiyorsunuz :");
						adet = scan.nextInt();
						urun.setSepetimAdet(adet);
						urun.setSepetimFiyat(urun.getFiyat().get(secim));
					} else if ((secim == 0) || (adet == 0)) {
						flag = false;
						sepetim();
					}

				} while (!((secim > 0) && (secim < 16)));

				for (int i = 0; i < urun.getUrun().size(); i++) {
					if (secim == (i + 1)) {
						araToplam = urun.getFiyat().get(i) * adet;
						System.out.print("Siparisiniz :   " + adet + "  adet  " + urun.getUrun().get(i) + ".........."
								+ urun.getFiyat().get(i) + "==> " + (adet * urun.getFiyat().get(i)));
						urun.setSepetim(adet + " adet " + urun.getUrun().get(i) + "(" + urun.getFiyat().get(i) + ")"
								+ "....." + (adet * urun.getFiyat().get(i)));
					}
				}
				toplamTutar += araToplam;
				System.out.println("\tToplam Tutar : " + toplamTutar + "\t(Sepet icin; 0 )");
			}
		} catch (InputMismatchException e) {
			System.out.print("\t==>Yanlis Giris<==\n");
			scan.nextLine();
			siparis();

		}

	}

	private static void sepetim() {
		if (urun.getSepetim().size() == 0) {
			System.out.println("==>Sepetiniz bos, sizi menuye aliyorum.<==");
			menu();
		}

		System.out.println("\n=== >  Sepet :Tutari : " + toplamTutar);

		for (int i = 0; i < urun.getSepetim().size(); i++) {
			System.out.println((i + 1) + "- " + urun.getSepetim().get(i));
		}
		try {
			System.out.print("\n1- Odeme\n2- Alisverise devam etmek \n3- Urun silmek  \nSeciminiz : ");
			int sec = scan.nextInt();

			switch (sec) {
			case 1:
				odeme();
				break;
			case 2:
				listeleme();
				// siparis();
				break;
			case 3:
				sepetSil();
				break;
			default:
				System.out.println("Lutfen sira numaralarindan birini giriniz ...");
				sepetim();
				break;

			}
		} catch (InputMismatchException e) {
			System.out.print("\t\t==>Yanlis Giris<==\n");
			scan.nextLine();
			sepetim();
		}
	}

	private static void sepetSil() {

		if (urun.getSepetim().size() == 0) {
			System.out.println("\t\t=>Sepetiniz bos,menuye aliyorum.<==");
			menu();
		}

		flag = true;
		while (flag) {

			System.out.print("Hangi siradaki urunu silmek istersiniz : (Odeme icin, 0)");
			sil = scan.nextInt();

			if (!(sil == 0)) {

				while (sil < urun.getSepetim().size()) {
					System.out.println("SOn tutar" + " " + "  " + urun.getSepetim().get(sil - 1) + "  "
							+ urun.getSepetimFiyat().get(sil - 1) + "   " + urun.getSepetimAdet().get(sil - 1) + "  "
							+ (toplamTutar -= (urun.getSepetimFiyat().get(sil - 1)
									* urun.getSepetimAdet().get(sil - 1))));

					urun.getSepetim().remove(sil - 1);
					urun.getSepetimAdet().remove(sil - 1);
					// // toplamTutar-=urun.getSepetimFiyat().get(sil-1);
					urun.getSepetimFiyat().remove(sil - 1);

					for (int i = 0; i < urun.getSepetim().size(); i++) {
						System.out.println(
								(i + 1) + " - " + urun.getSepetimAdet().get(i) + " adet " + urun.getSepetim().get(i)); // "+urun.getSepetim().get(i));
					}
					System.out.println("Baska bir urun sil ");
					sepetSil();
				}
			} else {
				odeme();
			}
		}

	}

	private static void odeme() {
		if (toplamTutar == 0) {
			System.out.println("\t\t=>Sepetiniz bos, sizi menuye aliyorum.<=");
			menu();
		}

		System.out.println(" \nOdenecek Tutariniz :" + toplamTutar);
		flag = true;
		System.out.print("Odemeyi; 1, 5, 10 ve 20 Tl  seklinde yapabilirsiniz.\nOdeme tutariniz :  ");
		odeme = scan.nextDouble();

		if ((odeme == 1) || (odeme == 5) || (odeme == 10) || (odeme == 20)) {
			kalan = toplamTutar - odeme;
			while (flag) {

				System.out.print("Kalan : " + kalan);
				if ((kalan > 0) && ((kalan == 1) || kalan == 5) || (kalan == 10) || (kalan == 20)) {
					System.out.print("Kalan odeme tutariniz : " + kalan + "\nYeni odemeniz :");
					odeme = scan.nextDouble();
					kalan -= odeme;
					//odeme();
				} else  if (kalan < 0) {
					System.out.println("\nAlacaginiz para ustu : " + kalan);
					flag = false;
					cikis();
				}
			}

		} else{// System.out.println("Sadece; 1-5-10-20 seklinde odeme yapabilirsiniz.");

			System.out.println("odemenizi yanlis yaptiniz .");
			odeme();

		}odeme();
	}

	private static void cikis() {
		Random rand = new Random();
		int a = rand.nextInt(15);
		System.out.println(
				"\nRasgele sectigimiz hediye urunumuz; " + urun.getUrun().get(a).toUpperCase() + "   afiyet olsun.\n");

		System.out.println("\n˜˜˜˜˜˜˜~YINE BEKLERIZ ˜˜˜˜˜˜˜˜");
		scan.next();

	}

}
