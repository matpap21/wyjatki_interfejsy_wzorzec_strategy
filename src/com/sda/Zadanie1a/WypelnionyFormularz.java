package com.sda.Zadanie1a;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WypelnionyFormularz {
    private String Czy_Chroba_W_ostatnim_Czasie;
    private String czy_posiada_maseczke ;
    private KWS kraje_wys_ryzyka ;
    private OSNK Czy_przebywano_w_otoczeniu_osob_na_kwarantannie ;



    @Override
    public String toString() {
        return "CzyChrobaWostatnimCzasie=" + Czy_Chroba_W_ostatnim_Czasie + "\n" +
                "czy_posiada_maseczke=" + czy_posiada_maseczke + "\n" +
                "kraje_wys_ryzyka=" + kraje_wys_ryzyka + "\n" +
                "Czy_przebywano_w_otoczeniu_osob_na_kwarantannie=" + Czy_przebywano_w_otoczeniu_osob_na_kwarantannie + "\n";
    }
}
