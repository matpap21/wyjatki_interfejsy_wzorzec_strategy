package com.sda.ZadanieFirstReverse;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner (System.in);
        System.out.println ("Podaj tekst " );
        String dane_uzytkownika = scanner.nextLine ();

        char[] literki = dane_uzytkownika.toCharArray();
        List<Character> lista = new ArrayList<> ();

        for (char element : literki)
            lista.add(element);

        Collections.reverse(lista);
        ListIterator li = lista.listIterator();
        while (li.hasNext())
            System.out.print(li.next());
    }
}
