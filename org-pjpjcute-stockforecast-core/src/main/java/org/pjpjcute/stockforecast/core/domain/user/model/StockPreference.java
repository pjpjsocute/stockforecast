package org.pjpjcute.stockforecast.core.domain.user.model;

import org.pjpjcute.stockforecast.core.domain.common.MarketType;
import org.pjpjcute.stockforecast.core.domain.common.StockType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StockPreference {

    /**
     * market
     */
    private MarketType marketType;

    /**
     * stock type
     */
    private StockType  stockType;

    /**
     * id
     */
    private String     id;

    public static StockPreference createStockPreference(String marketType, String stockType, String id) {
        StockPreference stockPreference = new StockPreference();
        stockPreference.marketType = MarketType.valueOf(marketType);
        stockPreference.stockType = StockType.valueOf(stockType);
        stockPreference.id = id;
        return stockPreference;
    }
}
