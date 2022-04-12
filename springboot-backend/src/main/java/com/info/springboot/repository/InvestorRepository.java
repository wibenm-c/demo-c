package com.info.springboot.repository;

import com.info.springboot.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * Title: InvestorRepository
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
 * @created 21/03/2022
 */
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
