package com.example.android.jsontutapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raider on 27-07-2017.
 */

public class Countries extends ArrayList {
    private String name;
    private String capital;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String region;
    private String subregion;
    private String population;
    private String demonym;
    private String area;
    private List<String> timezones;
    private String nativeName;
    private List<Countries.Currency> currencies = new ArrayList<>();
    private List<Countries.Languages> languages=new ArrayList<>();
    private List<String> Borders;
    private String flag;

    @Override
    public String toString() {
        return new Countries().toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {

        this.flag = "https://www.countries-ofthe-world.com/flags-normal/flag-of-"+flag+".png";
    }

    public List<Countries.Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Countries.Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;

    }



    public List<String> getBorders() {
        return Borders;
    }

    public void setBorders(List<String> borders) {
        Borders = borders;
    }

    public  static class Currency{
        private String currencyName;
        private String symbol;
        private String currencyCode;

        @Override
        public String toString() {
            return  currencyName +" "+ symbol+",  " ;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public void setCurrencyName(String currencyName) {
            this.currencyName = currencyName;
        }
        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }
    }

    public static class Languages{
        private String name;
        private String iso639_1;

        @Override
        public  String toString(){
            return name+"  ";
        }
        public String getName() {
            return name;
        }

        public String getIso639_1() {
            return iso639_1;
        }

        public void setIso639_1(String iso639_1) {
            this.iso639_1 = iso639_1;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
