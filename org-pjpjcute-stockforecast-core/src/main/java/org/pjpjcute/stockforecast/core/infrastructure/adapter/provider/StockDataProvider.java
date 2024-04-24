package org.pjpjcute.stockforecast.core.infrastructure.adapter.provider;

import org.pjpjcute.stockforecast.core.domain.stock.Stock;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public interface StockDataProvider {

    Stock getStockData(String symbol);

    String getMarketType();
}
