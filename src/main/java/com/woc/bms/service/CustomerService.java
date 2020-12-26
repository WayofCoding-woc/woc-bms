package com.woc.bms.service;

import com.woc.bms.data.model.Customer;
import com.woc.bms.data.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomerService implements UserDetailsService {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private PasswordEncoder passwordEncoder;


    public Customer createCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public void resetPassword(String loginId, String old_password, String new_password) {
        Customer customer = customerRepository.findByLoginId(loginId);
        if(null == customer){
            throw new IllegalStateException("No such user exists in our system");
        }

        if(!passwordEncoder.matches(old_password, customer.getPassword())){
            throw new IllegalStateException("Invalid credentials, please try again...");
        }

        customer.setPassword(passwordEncoder.encode(new_password));
        customerRepository.save(customer);
    }

    public Customer findByCustomerId(Integer customerId){
        return customerRepository.findById(customerId).orElseThrow(()->new IllegalStateException("Customer does not exist with customerId="+customerId));
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByLoginId(loginId);
        if(null == customer){
            throw new IllegalStateException("No such user exists in our system");
        }
        return new CustomerAuthDetails(customer);
    }
}
