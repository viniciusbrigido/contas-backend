package com.brigido.contas.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum CurrencyToReal {

    USD("USD", "Dólar Americano"),
    EUR("EUR", "Euro"),
    ARS("ARS", "Peso Argentino"),
    AUD("AUD", "Dólar Australiano"),
    CAD("CAD", "Dólar Canadense"),
    CHF("CHF", "Franco Suíço"),
    CLP("CLP", "Peso Chileno"),
    DKK("DKK", "Coroa Dinamarquesa"),
    HKD("HKD", "Dólar de Hong Kong"),
    JPY("JPY", "Iene Japonês"),
    MXN("MXN", "Peso Mexicano"),
    SGD("SGD", "Dólar de Cingapura"),
    AED("AED", "Dirham dos Emirados"),
    BBD("BBD", "Dólar de Barbados"),
    BHD("BHD", "Dinar do Bahrein"),
    CNY("CNY", "Yuan Chinês"),
    CZK("CZK", "Coroa Checa"),
    EGP("EGP", "Libra Egípcia"),
    GBP("GBP", "Libra Esterlina"),
    HUF("HUF", "Florim Húngaro"),
    IDR("IDR", "Rupia Indonésia"),
    ILS("ILS", "Novo Shekel Israelense"),
    INR("INR", "Rúpia Indiana"),
    ISK("ISK", "Coroa Islandesa"),
    JMD("JMD", "Dólar Jamaicano"),
    JOD("JOD", "Dinar Jordaniano"),
    KES("KES", "Shilling Queniano"),
    KRW("KRW", "Won Sul-Coreano"),
    LBP("LBP", "Libra Libanesa"),
    LKR("LKR", "Rúpia de Sri Lanka"),
    MAD("MAD", "Dirham Marroquino"),
    MYR("MYR", "Ringgit Malaio"),
    NAD("NAD", "Dólar Namíbio"),
    NOK("NOK", "Coroa Norueguesa"),
    NPR("NPR", "Rúpia Nepalesa"),
    NZD("NZD", "Dólar Neozelandês"),
    OMR("OMR", "Rial Omanense"),
    PAB("PAB", "Balboa Panamenho"),
    PHP("PHP", "Peso Filipino"),
    PKR("PKR", "Rúpia Paquistanesa"),
    PLN("PLN", "Zlóti Polonês"),
    QAR("QAR", "Rial Catarense"),
    RON("RON", "Leu Romeno"),
    RUB("RUB", "Rublo Russo"),
    SAR("SAR", "Riyal Saudita"),
    SEK("SEK", "Coroa Sueca"),
    THB("THB", "Baht Tailandês"),
    TRY("TRY", "Nova Lira Turca"),
    VEF("VEF", "Bolívar Venezuelano"),
    XAF("XAF", "Franco CFA Central"),
    XCD("XCD", "Dólar do Caribe Oriental"),
    XOF("XOF", "Franco CFA Ocidental"),
    ZAR("ZAR", "Rand Sul-Africano"),
    TWD("TWD", "Dólar Taiuanês"),
    PYG("PYG", "Guarani Paraguaio"),
    UYU("UYU", "Peso Uruguaio"),
    COP("COP", "Peso Colombiano"),
    PEN("PEN", "Sol do Peru"),
    BOB("BOB", "Boliviano");

    private final String acronym;
    private final String name;


    public static List<String> getAcronyms() {
        return Arrays.stream(CurrencyToReal.values())
                .map(currency -> String.format("BRL-%s", currency.getAcronym()))
                .collect(Collectors.toList());
    }

}
