package com.brigido.contas.dto.currency;

import lombok.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CurrencyResponseDTO {

    public Currency BRLUSD;
    public Currency BRLEUR;
    public Currency BRLARS;
    public Currency BRLAUD;
    public Currency BRLCAD;
    public Currency BRLCHF;
    public Currency BRLCLP;
    public Currency BRLDKK;
    public Currency BRLHKD;
    public Currency BRLJPY;
    public Currency BRLMXN;
    public Currency BRLSGD;
    public Currency BRLAED;
    public Currency BRLBBD;
    public Currency BRLBHD;
    public Currency BRLCNY;
    public Currency BRLCZK;
    public Currency BRLEGP;
    public Currency BRLGBP;
    public Currency BRLHUF;
    public Currency BRLIDR;
    public Currency BRLILS;
    public Currency BRLINR;
    public Currency BRLISK;
    public Currency BRLJMD;
    public Currency BRLJOD;
    public Currency BRLKES;
    public Currency BRLKRW;
    public Currency BRLLBP;
    public Currency BRLLKR;
    public Currency BRLMAD;
    public Currency BRLMYR;
    public Currency BRLNAD;
    public Currency BRLNOK;
    public Currency BRLNPR;
    public Currency BRLNZD;
    public Currency BRLOMR;
    public Currency BRLPAB;
    public Currency BRLPHP;
    public Currency BRLPKR;
    public Currency BRLPLN;
    public Currency BRLQAR;
    public Currency BRLRON;
    public Currency BRLRUB;
    public Currency BRLSAR;
    public Currency BRLSEK;
    public Currency BRLTHB;
    public Currency BRLTRY;
    public Currency BRLVEF;
    public Currency BRLXAF;
    public Currency BRLXCD;
    public Currency BRLXOF;
    public Currency BRLZAR;
    public Currency BRLTWD;
    public Currency BRLPYG;
    public Currency BRLUYU;
    public Currency BRLCOP;
    public Currency BRLPEN;
    public Currency BRLBOB;

    public List<Currency> getCurrenciesBase() {
        return Arrays.asList(
                BRLUSD, BRLEUR, BRLARS, BRLAUD, BRLCAD, BRLCHF, BRLCLP, BRLDKK, BRLHKD, BRLJPY, BRLMXN,
                BRLSGD, BRLAED, BRLBBD, BRLBHD, BRLCNY, BRLCZK, BRLEGP, BRLGBP, BRLHUF, BRLIDR, BRLILS,
                BRLINR, BRLISK, BRLJMD, BRLJOD, BRLKES, BRLKRW, BRLLBP, BRLLKR, BRLMAD, BRLMYR, BRLNAD,
                BRLNOK, BRLNPR, BRLNZD, BRLOMR, BRLPAB, BRLPHP, BRLPKR, BRLPLN, BRLQAR, BRLRON, BRLRUB,
                BRLSAR, BRLSEK, BRLTHB, BRLTRY, BRLVEF, BRLXAF, BRLXCD, BRLXOF, BRLZAR, BRLTWD, BRLPYG,
                BRLUYU, BRLCOP, BRLPEN, BRLBOB
        );
    }

    @Getter @Setter
    @AllArgsConstructor @NoArgsConstructor
    public class Currency {
        public String code;
        public String codein;
        public String name;
        public String high;
        public String low;
        public String varBid;
        public String pctChange;
        public String bid;
        public String ask;
        public String timestamp;
        public String create_date;

        public String getName() {
            return name.replace("Real Brasileiro/", "");
        }

        public BigDecimal getPrice() {
            return BigDecimal.valueOf(Double.parseDouble(high));
        }
    }
}
