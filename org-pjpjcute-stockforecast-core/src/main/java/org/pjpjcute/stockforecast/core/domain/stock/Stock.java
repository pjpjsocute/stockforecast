package org.pjpjcute.stockforecast.core.domain.stock;

import org.pjpjcute.stockforecast.core.domain.common.MarketType;

import lombok.Getter;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@Getter
public class Stock {
    /**
     * 股票代码，作为主键
     */
    private String     symbol;
    /**
     * 股票名称
     */
    private String     name;

    /**
     * 最新价格
     */
    private double     currentPrice;

    /**
     * 股票市场
     */
    private MarketType marketType;
}
