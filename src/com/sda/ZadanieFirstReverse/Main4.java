package com.sda.ZadanieFirstReverse;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj tekst " );
        String dane_uzytkownika = scanner.nextLine ();


        // konwersja Stringa na chars
        // za pomocą CharArray
        char[] tablica = dane_uzytkownika.toCharArray();

        for (int i = tablica.length - 1; i >= 0; i--)
            System.out.print(tablica[i]);
    }
}
