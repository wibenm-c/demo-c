package com.info.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <p>
 * Title: Product
 * </p>
 * <p>
 * Description:
 * //TODO : WIBEN
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
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name="current_balance")
    private BigDecimal currentBalance;

    /**
     * Gets currentBalance.
     *
     * @return Value of currentBalance.
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new currentBalance.
     *
     * @param currentBalance New value of currentBalance.
     */
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return Value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets productId.
     *
     * @return Value of productId.
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Sets new productId.
     *
     * @param productId New value of productId.
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }
}
