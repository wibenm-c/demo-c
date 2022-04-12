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
@Table(name = "investor")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long investorId;

    @OneToMany
    @JoinTable(inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Product> products;

    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;

    @Column(name = "age")
    private int age;


    /**
     * Sets new contact.
     *
     * @param contact New value of contact.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Sets new investorId.
     *
     * @param investorId New value of investorId.
     */
    public void setInvestorId(long investorId) {
        this.investorId = investorId;
    }

    /**
     * Gets address.
     *
     * @return Value of address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets new address.
     *
     * @param address New value of address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets contact.
     *
     * @return Value of contact.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Gets InvestorId.
     *
     * @return Value of investorId.
     */
    public long getInvestorId() {
        return investorId;
    }

    /**
     * Gets products.
     *
     * @return Value of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets new products.
     *
     * @param products New value of products.
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Gets age.
     *
     * @return Value of age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets new age.
     *
     * @param age New value of age.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
