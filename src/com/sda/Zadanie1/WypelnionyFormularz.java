package com.sda.Zadanie1;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WypelnionyFormularz {
    private LocalDate dataUrodzenia;
    private KWS KWS;
    private boolean pali;
    private boolean chodziZestresowany;

    @Override
    public String toString() {
        return "dataUrodzenia=" + dataUrodzenia + "\n" +
                "gender=" + KWS + "\n" +
                "pali=" + pali + "\n" +
                "chodziZestresowany=" + chodziZestresowany + "\n";
    }
}