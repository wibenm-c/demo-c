package com.info.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Title: WithdrawalHistory
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
 * Company:
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
@Table(name = "withdrawal_history")
public class WithdrawalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long withdrawalHistoryId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Investor investor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    private Product product;

    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "withdrawal_date")
    private Date withdrawalDate;


    /**
     * Gets balance.
     *
     * @return Value of balance.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets new investor.
     *
     * @param investor New value of investor.
     */
    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    /**
     * Sets new initialBalance.
     *
     * @param initialBalance New value of initialBalance.
     */
    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    /**
     * Gets investor.
     *
     * @return Value of investor.
     */
    public Investor getInvestor() {
        return investor;
    }

    /**
     * Gets initialBalance.
     *
     * @return Value of initialBalance.
     */
    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    /**
     * Gets withdrawalHistoryId.
     *
     * @return Value of withdrawalHistoryId.
     */
    public long getWithdrawalHistoryId() {
        return withdrawalHistoryId;
    }

    /**
     * Sets new balance.
     *
     * @param balance New value of balance.
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Gets product.
     *
     * @return Value of product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets new withdrawalHistoryId.
     *
     * @param withdrawalHistoryId New value of withdrawalHistoryId.
     */
    public void setWithdrawalHistoryId(long withdrawalHistoryId) {
        this.withdrawalHistoryId = withdrawalHistoryId;
    }

    /**
     * Sets new product.
     *
     * @param product New value of product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets new withdrawalDate.
     *
     * @param withdrawalDate New value of withdrawalDate.
     */
    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    /**
     * Gets withdrawalDate.
     *
     * @return Value of withdrawalDate.
     */
    public Date getWithdrawalDate() {
        return withdrawalDate;
    }
}
