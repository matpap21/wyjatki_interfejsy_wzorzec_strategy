package com.sda.ZadanieFirstReverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj tekst " );
        String dane_uzytkownika = scanner.nextLine ();

        StringBuffer new_string = new StringBuffer(dane_uzytkownika);
        new_string.reverse();
        System.out.println(new_string);

    }
}
