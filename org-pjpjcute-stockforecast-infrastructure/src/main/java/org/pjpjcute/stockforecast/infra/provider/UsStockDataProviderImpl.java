package org.pjpjcute.stockforecast.infra.provider;

import org.pjpjcute.stockforecast.core.domain.stock.Stock;
import org.pjpjcute.stockforecast.core.infrastructure.adapter.provider.StockDataProvider;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public class UsStockDataProviderImpl implements StockDataProvider {
    @Override
    public Stock getStockData(String symbol) {
        return null;
    }

    @Override
    public String getMarketType() {
        return null;
    }
}
