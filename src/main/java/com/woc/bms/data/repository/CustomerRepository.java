package com.woc.bms.data.repository;

import com.woc.bms.data.model.Customer;
import com.woc.bms.data.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByLoginId(String loginId);
    Customer findByLoginIdAndPassword(String loginId, String password);
}
