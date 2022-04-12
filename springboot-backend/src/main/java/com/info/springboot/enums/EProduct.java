package com.info.springboot.enums;

/**
 * <p>
 * Title: EProduct
 * </p>
 * <p>
 * Description: To hold different types of product for investors
 * </p>
 * <p>
 * Copyright Notice
 * ================
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2017
 * <p>
 * </p>
 *
 * @author WIBEN
 * @version 1.0
 * @created 12 /04/2022
 */
public enum EProduct {
    /**
     * Retirement e product.
     */
    RETIREMENT(1),
    /**
     * Savings e product.
     */
    SAVINGS(2);
    private final int productCode;

    EProduct(int productCode) {
        this.productCode = productCode;
    }


    /**
     * Is boolean.
     *
     * @param productCode the product code
     * @return the boolean
     */
    public boolean is(int productCode)
    {
        return this.getProductCode() == productCode;
    }

    /**
     * Gets productCode.
     *
     * @return Value of productCode.
     */
    public int getProductCode() {
        return productCode;
    }
}
