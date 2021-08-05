package com.sda.ZadanieAlphabetSoup;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj tekst ");
        String dane_uzytkownika = scanner.nextLine ( );

        char charArray[] = dane_uzytkownika.toCharArray ( );
        Arrays.sort (charArray);
        System.out.println (new String (charArray));
    }
}