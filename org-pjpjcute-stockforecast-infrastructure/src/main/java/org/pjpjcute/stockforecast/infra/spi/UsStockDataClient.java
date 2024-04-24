package org.pjpjcute.stockforecast.infra.spi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@FeignClient(name = "stock-data-service", url = "https://api.example.com")
public interface UsStockDataClient {

    @GetMapping("/query")
    Object getStockData();
}
