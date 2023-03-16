package com.brigido.contas.rest;

import com.brigido.contas.dto.currency.CurrencyResponseDTO;
import com.brigido.contas.enumeration.CurrencyToReal;
import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyRest {

    @Autowired
    private Gson gson;

    private static final String URL = "http://economia.awesomeapi.com.br/json/last/";

    public List<CurrencyResponseDTO.Currency> getCurrenciesBase() {
        List<String> currencies = CurrencyToReal.getAcronyms();
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(URL + String.join(",", currencies));
            String responseBody = httpClient.execute(httpGet, response -> EntityUtils.toString(response.getEntity()));
            CurrencyResponseDTO currencyResponse = gson.fromJson(responseBody, CurrencyResponseDTO.class);
            return currencyResponse.getCurrenciesBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
