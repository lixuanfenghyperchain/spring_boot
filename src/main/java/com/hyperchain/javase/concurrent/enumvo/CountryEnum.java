package com.hyperchain.javase.concurrent.enumvo;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

public enum CountryEnum {
    //    ONE(0, "秦"),
    TWO(1, "楚"), THREE(2, "齐"), FOUR(3, "燕"), FIVE(4, "赵"), SIX(5, "魏"), SEVEN(6, "韩");

    @Getter
    private int countryCode;

    @Getter
    private String countryName;

    CountryEnum(int countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    /**
     * 传入国家索引号  返回国家枚举
     *
     * @param countryCode 国家索引
     * @return
     */
    public static CountryEnum getCountry(int countryCode) {

        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element : values) {
            if (countryCode == element.getCountryCode()) {
                return element;
            }
        }

        return null;
    }
}
