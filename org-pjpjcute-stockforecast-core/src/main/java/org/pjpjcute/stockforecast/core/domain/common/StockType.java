package org.pjpjcute.stockforecast.core.domain.common;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

public enum StockType {

    /**
     * Technology Stocks
     */
    TECHNOLOGY("001", "Technology Stocks"),

    /**
     * Finance Stocks
     */
    FINANCE("002", "Finance Stocks"),

    /**
     * Healthcare Stocks
     */
    HEALTHCARE("003", "Healthcare Stocks");

    /**
     * type cpde
     */
    private String typeCode;

    /**
     * desc
     */
    private String description;

    StockType(String typeCode, String description) {
        this.typeCode = typeCode;
        this.description = description;
    }

}
