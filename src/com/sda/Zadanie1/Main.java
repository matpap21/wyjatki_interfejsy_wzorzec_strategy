package com.sda.Zadanie1;

import org.cef.OS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        String sciezkaRelatywna = "Zadanie5_zapis";
        File sciezka = new File (sciezkaRelatywna);
        Scanner scanner = new Scanner (System.in);
        String ccwc, cpm, cwwkwr, cpwoowk;
        List<Pytania> pytania = new ArrayList<> ( );
        KWS wybrany_enum_kraje_wysokiego_ryzyka = null;
        OSWK przebywano_w_otoczeniu_osob_na_kwarantannie =null;

        do {
            ccwc = null;

            System.out.println ("Czy chorował*ś w ostatnim czasie ? \n " +
                    "Dostępne odpowiedzi: TAK, NIE");

                ccwc = scanner.nextLine ( );
                if (ccwc.toUpperCase ( ).equalsIgnoreCase ("TAK")) {
                    System.out.println ("Well done");
                    break;
                }else if (ccwc.toUpperCase ( ).equalsIgnoreCase ("NIE")) {
                    System.out.println ("Not good");
                    break;
                } else {
                    System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
                }

        } while (!ccwc.toUpperCase ( ).equalsIgnoreCase ("yes") && !ccwc.toUpperCase ( ).equalsIgnoreCase ("no"));


        do {
            cpm = null;
            try {
                System.out.println ("Czy posiada maseczkę?(RE) \n " +
                        "Dostępne odpowiedzi: TAK, NIE");

                    cpm = scanner.nextLine ( );
                    if (cpm.toUpperCase ( ).equalsIgnoreCase ("TAK")) {
                        System.out.println ("Well done");
                        break;
                    }else if (cpm.toUpperCase ( ).equalsIgnoreCase ("NIE")) {
                        System.out.println ("Not good");
                        break;
                    } else {
                        System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
                    }

            } catch (IllegalArgumentException e){
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        }while (!cpm.toUpperCase ( ).equalsIgnoreCase ("yes") && (!cpm.toUpperCase ( ).equalsIgnoreCase ("no"))) ;


        do {
            wybrany_enum_kraje_wysokiego_ryzyka =null;
            try {
                System.out.println ("Czy przebywał*ś w krajach wysokiego ryzyka?(E)\n " +
                        "dostepne odpowiedzi:  ");
                for (KWS kraje_wys_ryzyka : KWS.values ( )) {
                    System.out.println (" - " + kraje_wys_ryzyka);
                }
                cwwkwr = scanner.nextLine ( );
                wybrany_enum_kraje_wysokiego_ryzyka = KWS.valueOf ((cwwkwr.toUpperCase ( )));

                if (wybrany_enum_kraje_wysokiego_ryzyka == KWS.PRZEBYWANO) {
                    System.out.println ("ZAPISZ do klasy HighRiskPatient");
                }else if (wybrany_enum_kraje_wysokiego_ryzyka == KWS.NIE_PRZEBYWANO){
                    System.out.println ("ZAPISZ do klasy LowRiskPatient");
                }
            }catch (IllegalArgumentException error){
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        }while (wybrany_enum_kraje_wysokiego_ryzyka ==null);



        //Czy przebywał w otoczeniu osób na kwarantannie?(E)

        do{
            przebywano_w_otoczeniu_osob_na_kwarantannie=null;
            try{
                System.out.println ("Czy przebywał*ś w otoczeniu osób na kwarantannie?(E) \n "  +
                      " dostepne odpowiedzi: TAK, NIE ");

                for (OSWK e: OSWK.values ()){
                    System.out.println (" - " + e );
                }

                cpwoowk =  scanner.nextLine ();
                przebywano_w_otoczeniu_osob_na_kwarantannie = OSWK.valueOf (cpwoowk.toUpperCase (  ));

                if (przebywano_w_otoczeniu_osob_na_kwarantannie == OSWK.TAK){
                    System.out.println ("ZAPISZ do klasy HighRiskPatient ");
                }else if (przebywano_w_otoczeniu_osob_na_kwarantannie == OSWK.NIE){
                    System.out.println ("LowRiskPatient" );
                }else {
                    System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
                }

            }catch (IllegalArgumentException e){
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        }while (przebywano_w_otoczeniu_osob_na_kwarantannie ==null);



        //Jeśli pacjent był chory,lub nie posiada maseczki to jest pacjentem niskiego ryzyka.

        //https://github.com/SaintAmeN/zd_java_92_zadania_domowe/blob/master/src/main/java/com/sda/z92/zad_31_7/abstrakcjazolniez/Main.java
        //https://github.com/SaintAmeN/zd_java_92_zadania_domowe/blob/master/src/main/java/com/sda/z92/zad_dom_31_7/zad_5/Main.java




    }
}