package com.sda.Zadanie1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
//// i.Czy był chory w ostatnim czasie?(RE) ok
//// ii.Czy posiada maseczkę?(RE) ok
//// iii.Czy przebywał w krajach wysokiego ryzyka?(E) ok
//// iv.Czy przebywał w otoczeniu osób na kwarantannie?(E)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        try {
            boolean czyWypelniaszPonownie = true;
            do {
                String Czy_Chroba_W_ostatnim_Czasie = pobierzCzyChrobaWostatnimCzasie (scanner);
                String czy_posiada_maseczke = pobierzCzyPosiasaszMaseczke(scanner);
                KWS kraje_wys_ryzyka = pobierzCzyPrzebywanowKrajachWysokiegoRyzyka (scanner);
                OSNK Czy_przebywano_w_otoczeniu_osob_na_kwarantannie =pobierzCzyPrzebywanowOtoczeniuOsobnaKwarantannie(scanner);


                if (kraje_wys_ryzyka == KWS.TAK) {
                    System.out.println ("ZAPISZ do klasy HighRiskPatient");
                } else {
                    System.out.println ("ZAPISZ do klasy LowRiskPatient");
                }

                // ################################
                zapiszDoPliku (new WypelnionyFormularz (Czy_Chroba_W_ostatnim_Czasie, czy_posiada_maseczke, kraje_wys_ryzyka, Czy_przebywano_w_otoczeniu_osob_na_kwarantannie));

                czyWypelniaszPonownie = zadajPytanieYN (scanner, "Czy chcesz wypełnić ten formularz ponownie?" + "\n" +
                        "wpisz quit by zakończyć ");
            } while (czyWypelniaszPonownie);
        } catch (IWantToSkipThisQuestionaire errror) {
            System.out.println ("Spoko, nie chcesz to nie kończ formularza. :) ");
        }
    }

    private static void zapiszDoPliku(WypelnionyFormularz formularz) {
        String sciezkaRelatywna = "Zadanie5.txt";
        File sciezka = new File (sciezkaRelatywna);
        try (PrintWriter writer = new PrintWriter (new FileOutputStream (sciezka, true))) {
            writer.println (formularz);
        } catch (FileNotFoundException exception) {
            System.err.println ("Nie mogę zapisać do pliku");
        }
    }

    private static boolean zadajPytanieYN(Scanner scanner, String pytanie) throws IWantToSkipThisQuestionaire {
        System.out.println (pytanie);
        String wpisanawartosc = scanner.nextLine ( ).toUpperCase ( );
        if ("QUIT".equalsIgnoreCase (wpisanawartosc.toUpperCase ( ))) {
            throw new IWantToSkipThisQuestionaire ( );
        }

        return "YES".equalsIgnoreCase (wpisanawartosc) || "TAK".equalsIgnoreCase (wpisanawartosc) ||
                (wpisanawartosc.length ( ) == 1 && (wpisanawartosc.charAt (0) == 'T' || wpisanawartosc.charAt (0) == 'Y'));
    }


    private static KWS pobierzCzyPrzebywanowKrajachWysokiegoRyzyka(Scanner scanner) throws IWantToSkipThisQuestionaire {
        KWS wybrany_enum_kraje_wysokiego_ryzyka = null;

        do {
            try {
                System.out.println ("Czy przebywał*ś w krajach wysokiego ryzyka?(E)\n " +
                        "dostepne odpowiedzi:  ");
                for (KWS kraje_wys_ryzyka : KWS.values ( )) {
                    System.out.println (" - " + kraje_wys_ryzyka);
                }
                String cwwkwr = scanner.nextLine ( );
                wybrany_enum_kraje_wysokiego_ryzyka = KWS.valueOf ((cwwkwr.toUpperCase ( )));
                if ("QUIT".equalsIgnoreCase (cwwkwr.toUpperCase ( ))) {
                    throw new IWantToSkipThisQuestionaire ( );
                }

                if (wybrany_enum_kraje_wysokiego_ryzyka == KWS.TAK) {
                    System.out.println ("ZAPISZ do klasy HighRiskPatient");
                } else if (wybrany_enum_kraje_wysokiego_ryzyka == KWS.NIE) {
                    System.out.println ("ZAPISZ do klasy LowRiskPatient");
                }

            } catch (IllegalArgumentException iae) {
                System.err.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybrany_enum_kraje_wysokiego_ryzyka == null);
        return wybrany_enum_kraje_wysokiego_ryzyka;
    }

    private static String pobierzCzyChrobaWostatnimCzasie(Scanner scanner) throws IWantToSkipThisQuestionaire {
        String ccwc = null;
        do {
            try {
                System.out.println ("Czy chorował*ś w ostatnim czasie ? \n " +
                        "Dostępne odpowiedzi: TAK, NIE");
                ccwc = scanner.nextLine ( );
                if ("QUIT".equalsIgnoreCase (ccwc.toUpperCase ( ))) {
                    throw new IWantToSkipThisQuestionaire ( );
                }

                if (ccwc.toUpperCase ( ).equalsIgnoreCase ("TAK")) {
                    break;
                } else if (ccwc.toUpperCase ( ).equalsIgnoreCase ("NIE")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (!ccwc.toUpperCase ( ).equalsIgnoreCase ("yes") && !ccwc.toUpperCase ( ).equalsIgnoreCase ("no"));
        System.out.println ("Wpisano " + ccwc);
        return ccwc;
    }

    private static String pobierzCzyPosiasaszMaseczke(Scanner scanner) throws IWantToSkipThisQuestionaire {
        String czy_posiadasz_maseczke = null;
        do {
            try {
                System.out.println ("Czy posiadasz meseczke ? \n " +
                        "Dostępne odpowiedzi: TAK, NIE");
                czy_posiadasz_maseczke = scanner.nextLine ( );
                if ("QUIT".equalsIgnoreCase (czy_posiadasz_maseczke.toUpperCase ( ))) {
                    throw new IWantToSkipThisQuestionaire ( );
                }

                if (czy_posiadasz_maseczke.toUpperCase ( ).equalsIgnoreCase ("TAK")) {
                    break;
                } else if (czy_posiadasz_maseczke.toUpperCase ( ).equalsIgnoreCase ("NIE")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (!czy_posiadasz_maseczke.toUpperCase ( ).equalsIgnoreCase ("yes") && !czy_posiadasz_maseczke.toUpperCase ( ).equalsIgnoreCase ("no"));
        System.out.println ("Wpisano " + czy_posiadasz_maseczke);
        return czy_posiadasz_maseczke;
    }



    private static OSNK pobierzCzyPrzebywanowOtoczeniuOsobnaKwarantannie(Scanner scanner) throws IWantToSkipThisQuestionaire {
        OSNK wybrany_enum_otoczenie_osob_na_kwarantannie = null;

        do {
            try {
                System.out.println ("Czy_przebywano_w_otoczeniu_osób_na_kwarantannie(E)\n " +
                        "dostepne odpowiedzi:  ");
                for (OSNK Czy_przebywano_w_otoczeniu_osób_na_kwarantannie : OSNK.values ( )) {
                    System.out.println (" - " + Czy_przebywano_w_otoczeniu_osób_na_kwarantannie);
                }
                String cwwoonk = scanner.nextLine ( );
                wybrany_enum_otoczenie_osob_na_kwarantannie = OSNK.valueOf ((cwwoonk.toUpperCase ( )));
                if ("QUIT".equalsIgnoreCase (cwwoonk.toUpperCase ( ))) {
                    throw new IWantToSkipThisQuestionaire ( );
                }

                if (wybrany_enum_otoczenie_osob_na_kwarantannie == OSNK.TAK) {
                    System.out.println ("ZAPISZ do klasy HighRiskPatient");
                    break;
                } else if (wybrany_enum_otoczenie_osob_na_kwarantannie == OSNK.NIE) {
                    System.out.println ("ZAPISZ do klasy LowRiskPatient");
                    break;
                }

            } catch (IllegalArgumentException iae) {
                System.err.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybrany_enum_otoczenie_osob_na_kwarantannie == null);
        return wybrany_enum_otoczenie_osob_na_kwarantannie;
    }
}
