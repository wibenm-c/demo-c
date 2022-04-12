package com.info.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * <p>
 * Title: Investor
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
@Table(name = "account_details")
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountDetailsId;

    @OneToMany
    @JoinTable(inverseJoinColumns=@JoinColumn(name="id"))
    private List<Investor> investors;

    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private String balance;


    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new balance.
     *
     * @param balance New value of balance.
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * Gets investors.
     *
     * @return Value of investors.
     */
    public List<Investor> getInvestors() {
        return investors;
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
     * Sets new accountDetailsId.
     *
     * @param accountDetailsId New value of accountDetailsId.
     */
    public void setAccountDetailsId(long accountDetailsId) {
        this.accountDetailsId = accountDetailsId;
    }

    /**
     * Gets balance.
     *
     * @return Value of balance.
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Sets new investors.
     *
     * @param investors New value of investors.
     */
    public void setInvestors(List<Investor> investors) {
        this.investors = investors;
    }

    /**
     * Gets accountDetailsId.
     *
     * @return Value of accountDetailsId.
     */
    public long getAccountDetailsId() {
        return accountDetailsId;
    }
}
