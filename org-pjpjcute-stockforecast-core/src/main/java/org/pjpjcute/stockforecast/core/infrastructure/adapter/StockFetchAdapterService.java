package org.pjpjcute.stockforecast.core.infrastructure.adapter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.pjpjcute.stockforecast.core.domain.common.MarketType;
import org.pjpjcute.stockforecast.core.domain.stock.Stock;
import org.pjpjcute.stockforecast.core.infrastructure.adapter.provider.StockDataProvider;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@Component
public class StockFetchAdapterService implements ApplicationContextAware {

    private final Map<String, StockDataProvider> dataProviders;

    private final ApplicationContext             applicationContext;

    public StockFetchAdapterService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        Map<String, StockDataProvider> dataProviders = this.applicationContext.getBeansOfType(StockDataProvider.class);
        this.dataProviders = dataProviders.values()
            .stream()
            .collect(Collectors.toMap(StockDataProvider::getMarketType, Function.identity()));
    }

    public Stock fetchStockData(String symbol, MarketType marketType) {
        StockDataProvider provider = dataProviders.get(marketType);
        if (provider == null) {
            throw new IllegalArgumentException("No data provider registered for market type: " + marketType);
        }
        return provider.getStockData(symbol);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
