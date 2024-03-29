package com.currency;

import com.currency.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyConversionService {

    @Value("${api.base.url}")
    private String apiurl;
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate template;

    public double convertCurrency(String baseCurrency, double amount, String targetCurrency) {
        System.out.println("Enter in currency");
        String apiUrl = String.format("%s?apikey=%s&base=%s&currencies=%s", apiurl , apiKey, baseCurrency, targetCurrency);
        AppConfig appConfig = new AppConfig();
        template = appConfig.restTemplate();

        System.out.println("After configuration");

        Map<String, Map<String, Double>> conversion = template.getForObject(apiUrl, Map.class);
        Map<String, Double> conversions = conversion.get("data");
        if (conversion == null || !conversions.containsKey(targetCurrency)) {
            throw new IllegalArgumentException("Conversion rate not available for currency: " + targetCurrency);
        }
        System.out.println(conversion.get("data"));
        Object rateObject = conversions.get(targetCurrency);
        System.out.println(rateObject);
        double rate;
        if (rateObject instanceof Integer) {
            rate = ((Integer) rateObject).doubleValue();
        } else {
            rate = (Double) rateObject;
        }
        return amount * rate;
    }
}

