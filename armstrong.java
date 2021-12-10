package PC08_while_dowhile__l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q01_armstrong_kisa {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Sayinizi giriniz : ");
		String sayi = scan.next();

		String[] strArr = sayi.split("");
		int intArr[] = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}

		double arms = 0;
		
		for (int carp : intArr) {
			arms += Math.pow(carp, intArr.length);
		}

		if ((int) arms == Integer.parseInt(sayi)) {
			System.out.println("\nSayim : " + sayi + "\nArmstrong degeri :" + (int) arms+"\n\nSayimiz bir Armstrong Sayidir.");
		} else
			System.out.println("\nSayim : " + sayi + "\nArmstrong sayi degildir");
	}

}
