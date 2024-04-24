package org.pjpjcute.stockforecast.core.domain.stock;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public class Stock {
    /**
     * 股票代码，作为主键
     */
    private String symbol;
    /**
     * 股票名称
     */
    private String name;

    /**
     * 最新价格
     */
    private double currentPrice;
}
