package com.info.springboot.controller;

import com.info.springboot.enums.EProduct;
import com.info.springboot.exception.BusinessTransactionException;
import com.info.springboot.exception.ResourceNotFoundException;
import com.info.springboot.model.AccountDetails;
import com.info.springboot.model.Investor;
import com.info.springboot.model.Product;
import com.info.springboot.model.WithdrawalHistory;
import com.info.springboot.repository.AccountDetailsRepository;
import com.info.springboot.repository.InvestorRepository;
import com.info.springboot.repository.ProductRepository;
import com.info.springboot.repository.WithdrawalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Title: AccountDetailsController
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
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/accountDetails")
public class AccountDetailsController {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
    private WithdrawalHistoryRepository withdrawalHistoryRepository;

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Gets account details.
     *
     * @return the account details
     */
    @GetMapping
    public List<AccountDetails> getAccountDetails() {
        return accountDetailsRepository.findAll();
    }


    /**
     * Create account details account details.
     *
     * @param accountDetails the account details
     * @return the account details
     */
    @PostMapping
    public AccountDetails createAccountDetails(@RequestBody AccountDetails accountDetails) {
        return accountDetailsRepository.save(accountDetails);
    }

    /**
     * Gets account details by id.
     *
     * @param id the id
     * @return account details by id
     */
    @GetMapping("{id}")
    public ResponseEntity<AccountDetails> getAccountDetailsById(@PathVariable long id) {
        AccountDetails accountDetails = accountDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountDetails not exist with id:" + id));
        return ResponseEntity.ok(accountDetails);
    }

    /**
     * Update account details response entity.
     *
     * @param id             the id
     * @param accountDetails the account details
     * @return response entity
     */
    @PutMapping("{id}")
    public ResponseEntity<AccountDetails> updateAccountDetails(@PathVariable long id, @RequestBody AccountDetails accountDetails) {
        AccountDetails updateAccountDetails = accountDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountDetails not exist with id: " + id));

        updateAccountDetails.setName(accountDetails.getName());
        updateAccountDetails.setBalance(accountDetails.getBalance());
        updateAccountDetails.setInvestors(accountDetails.getInvestors());

        accountDetailsRepository.save(updateAccountDetails);

        return ResponseEntity.ok(updateAccountDetails);
    }

    /**
     * Delete account details response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAccountDetails(@PathVariable long id) {

        AccountDetails accountDetails = accountDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountDetails not exist with id: " + id));

        accountDetailsRepository.delete(accountDetails);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    /**
     * Withdrawn withdrawal history.
     *
     * @param type  the type
     * @param id    the id
     * @param value the value
     * @return the withdrawal history
     */
    @GetMapping("{type}/{id}/{value}")
    public WithdrawalHistory withdrawn(@PathVariable String type, @PathVariable long id, @PathVariable long value) {

        Optional<Product> productOptional = productRepository.findAll().stream()
                .filter(product -> product.getType().equalsIgnoreCase(type)).findFirst();

        if (productOptional.isPresent()) {

            Product product = productOptional.get();


            AccountDetails accountDetails = accountDetailsRepository.findById(id)
                    .orElseThrow(() -> new BusinessTransactionException("AccountDetails does not exist with id: " + id));
            Investor investor = investorRepository.findById(id)
                    .orElseThrow(() -> new BusinessTransactionException("Investor does not exist with id: " + id));
            Product investorProduct = investor.getProducts().stream().filter(product1 -> product1.getType().equalsIgnoreCase(type)).findFirst()
                    .orElseThrow(() -> new BusinessTransactionException("Investor does not have " +type+" product type "));
            BigDecimal total = investorProduct.getCurrentBalance();
            if (EProduct.RETIREMENT.name().equals(product.getType()) && investor.getAge() < 65)
            {
                throw new BusinessTransactionException("Withdrawal not allowed for this age : " + investor.getAge());
            }
            if ((new BigDecimal(value)).compareTo(total) <= 0) {
                System.out.println(accountDetails.getName() + " withdrawn "
                        + value);

                BigDecimal newTotal = total.subtract(new BigDecimal(value));
                WithdrawalHistory withdrawalHistory = new WithdrawalHistory();
                withdrawalHistory.setInvestor(investor);
                withdrawalHistory.setProduct(investorProduct);
                withdrawalHistory.setInitialBalance(total);
                withdrawalHistory.setBalance(newTotal);

                investorProduct.setCurrentBalance(newTotal);
                productRepository.save(investorProduct);
                withdrawalHistory.setWithdrawalDate(new Date());
                return withdrawalHistoryRepository.save(withdrawalHistory);

            }
            else {
                throw new BusinessTransactionException("Withdrawal amount is greater than the balance : " + total);
            }
        }
        else{
            throw new BusinessTransactionException("Product type with name " + type + " is not found");
        }
    }
}