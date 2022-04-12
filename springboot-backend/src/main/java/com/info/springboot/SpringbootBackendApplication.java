package com.info.springboot;

import com.info.springboot.enums.EProduct;
import com.info.springboot.model.AccountDetails;
import com.info.springboot.model.Investor;
import com.info.springboot.model.Product;
import com.info.springboot.repository.AccountDetailsRepository;
import com.info.springboot.repository.InvestorRepository;
import com.info.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Springboot backend application.
 */
@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private InvestorRepository investorRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	@Override
	public void run(String... args) throws Exception{

		List<Product> productList = new ArrayList<>();
		Product product = new Product();

		//product.setProductId(9);
		product.setName("Investment");
		product.setType(EProduct.RETIREMENT.name());
		product.setCurrentBalance(new BigDecimal(5668));
		productList.add(product);
		productRepository.save(product);
		Product product2 = new Product();
		//product2.setProductId(10);
		product2.setName("Save");
		product2.setType(EProduct.SAVINGS.name());
		product2.setCurrentBalance(new BigDecimal(2887));
		productList.add(product2);
		productRepository.save(product2);

		Investor investor = new Investor();
		investor.setAddress("Address1");
		investor.setContact("093233222");
		investor.setAge(60);
		investor.setProducts(productList);
		investorRepository.save(investor);

		List<Product> productList2 = new ArrayList<>();
		Product product3 = new Product();

		//product.setProductId(9);
		product3.setName("Investment");
		product3.setType(EProduct.RETIREMENT.name());
		product3.setCurrentBalance(new BigDecimal(4455));
		productList2.add(product3);
		productRepository.save(product3);

		Product product4 = new Product();
		//product2.setProductId(10);
		product4.setName("Save");
		product4.setType(EProduct.SAVINGS.name());
		product4.setCurrentBalance(new BigDecimal(233));

		productRepository.save(product4);
		productList2.add(product4);

		Investor investor1 = new Investor();
		investor1.setAddress("Address2");
		investor1.setContact("333233222");
		investor1.setProducts(productList2);
		investor1.setAge(67);

		investorRepository.save(investor1);

		AccountDetails accountDetails = new AccountDetails();
		List<Investor> investors = new ArrayList<>();
		investors.add(investor1);
		investors.add(investor);
		accountDetails.setName(product2.getName());
		accountDetails.setBalance(product.getCurrentBalance().toString());
		accountDetails.setInvestors(investors);

		accountDetailsRepository.save(accountDetails);
	}
}
