package com.info.springboot.controller;

import com.info.springboot.exception.ResourceNotFoundException;
import com.info.springboot.model.Investor;
import com.info.springboot.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Title: InvestorController
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
@RequestMapping("/api/v1/investors")
public class InvestorController {

    @Autowired
    private InvestorRepository investorRepository;

    @GetMapping
    public List<Investor> getInvestors(){
        return investorRepository.findAll();
    }

    // build create investor REST API
    @PostMapping
    public Investor createInvestor(@RequestBody Investor investor) {
        return investorRepository.save(investor);
    }

    // build get Investor by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable  long id){
        Investor investor = investorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not exist with id:" + id));
        return ResponseEntity.ok(investor);
    }

    // build update Investor REST API
    @PutMapping("{id}")
    public ResponseEntity<Investor> updateInvestor(@PathVariable long id,@RequestBody Investor investorDetails) {
        Investor updateInvestor = investorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not exist with id: " + id));

        updateInvestor.setAddress(investorDetails.getAddress());
        updateInvestor.setContact(investorDetails.getContact());
        updateInvestor.setProducts(investorDetails.getProducts());

        investorRepository.save(updateInvestor);

        return ResponseEntity.ok(updateInvestor);
    }

    // build delete Investor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteInvestor(@PathVariable long id){

        Investor investor = investorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        investorRepository.delete(investor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // Method
    // To withdraw money
    private void withdrawn(String name, int withdrawal)
    {
        int total = 100;

        if (total >= withdrawal) {
            System.out.println(name + " withdrawn "
                    + withdrawal);

            total = total - withdrawal;
            System.out.println("Balance after withdrawal: "
                    + total);
            // Making the thread sleep for 1 second after
            // each withdrawal

            // Try block to check for exceptions
            try {

                // Making thread t osleep for 1 second
                Thread.sleep(1000);
            }

            // Catch block to handle the exceptions
            catch (InterruptedException e) {

                // Display the exception along with line
                // number
                // using printStacktrace() method
                e.printStackTrace();
            }
        }

        // If the money requested for withdrawal is greater
        // than the balance then deny transaction*/
        else {

            // Print statements
            System.out.println(name
                    + " you can not withdraw "
                    + withdrawal);

            System.out.println("your balance is: " + total);

            // Making the thread sleep for 1 second after
            // each transaction failure

            // Try block to check for exceptions
            try {
                Thread.sleep(1000);
            }

            catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}