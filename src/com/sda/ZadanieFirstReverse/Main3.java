package com.sda.ZadanieFirstReverse;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj tekst " );
        String dane_uzytkownika = scanner.nextLine ();

        StringBuilder new_string = new StringBuilder();

        // łączenie ciągu do StringBuilder
        new_string.append(dane_uzytkownika);

        // rewersowanie ciagu
        new_string.reverse();

        System.out.println(new_string);
    }
}
