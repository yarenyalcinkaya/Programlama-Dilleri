package gramerkontrol; 

import java.util.Scanner;

public class gramerkontrol{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen cumleyi girin:");
        String cumle = scanner.nextLine();
        cumle = cumle.trim(); 
        String[] kelimeler = cumle.split("\\s+"); 

        if (kelimeler.length != 3) { 
            System.out.println("Cumle eksik veya fazla öge içeriyor.");
        } else {
            String ozne = kelimeler[0];
            String nesne = kelimeler[1];
            String yuklem = kelimeler[2];

            
            if (isValidElement(ozne, getOzneSet()) &&
                isValidElement(nesne, getNesneSet()) &&
                isValidElement(yuklem, getYuklemSet())) {
                System.out.println("EVET!!! Cumle gramer kurallarina uygun.");
            } else {
                System.out.println("HAYIR!!! Cumle gramer kurallarina uymuyor.");
            }
        }
    }

   
    public static String[] getOzneSet() {
        return new String[]{"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
    }

    
    public static String[] getNesneSet() {
        return new String[]{"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
    }

    
    public static String[] getYuklemSet() {
        return new String[]{"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};
    }

    
    public static boolean isValidElement(String kelime, String[] kume) {
        for (String eleman : kume) {
            if (eleman.equals(kelime)) {
                return true;
            }
        }
        return false;
    }
}