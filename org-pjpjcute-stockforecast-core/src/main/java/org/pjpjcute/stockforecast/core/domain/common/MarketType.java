package org.pjpjcute.stockforecast.core.domain.common;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public enum MarketType {


    /**
     * us stock market
     */
    US_STOCK("001", "us stock market"),
    /**
     * china stock market
     */
    CHINA_STOCK("002", "china stock market"),

    /**
     * hk stock market
     */
    HK_STOCK("003", "hk stock market");


    /**
     * 市场code
     */
    private String marketCode;

    /**
     * 描述
     */
    private String desc;


    MarketType(String marketCode, String desc) {
        this.marketCode = marketCode;
        this.desc = desc;
    }
}
