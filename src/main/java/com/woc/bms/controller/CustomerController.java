package com.woc.bms.controller;

import com.woc.bms.data.model.Customer;
import com.woc.bms.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Log4j2
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired private CustomerService customerService;

    @GetMapping("/signup")
    public String signup(HttpServletRequest request, ModelMap model){
        return "signup";
    }

    @GetMapping("/{customerId}/profile")
    public String profile(@PathVariable("customerId") Integer customerId,  HttpServletRequest request, ModelMap model){
        Customer customer = customerService.findByCustomerId(customerId);
        model.put("customer", customer);
        return "profile";
    }

    @PostMapping(value = "/register")
    public String register(HttpServletRequest request, ModelMap model){
        log.debug("customer registration api got triggered");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        Customer customer = new Customer();
        customer.setLoginId(loginId);
        customer.setPassword(password);
        customer.setName(name);
        customer.setEmail(email);
        customer.setMobile(Long.valueOf(mobile));
        customer.setCreatedDate(new Date());

        log.debug("customer registration api input={}", customer);

        try{
            customerService.createCustomer(customer);
        }catch (Exception e){
            String errorMsg = "Unable to do the signup";
            log.error(errorMsg, e);
            model.put("msg", errorMsg);
            return "error";
        }

        model.put("msg", "SignUp completed successfully!, You can signIn now...");

        return "index";
    }

    @GetMapping("/resetPassword")
    public String resetPasswordPage(HttpServletRequest request, ModelMap model){
        return "resetPassword";
    }

    @PostMapping(value = "/resetPassword")
    public String resetPassword(HttpServletRequest request, ModelMap model) {
        String loginId = request.getParameter("loginId");
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");

        log.info("resetPassword api got triggered for loginId={}", loginId);

        try {
            customerService.resetPassword(loginId, old_password, new_password);
        } catch (Exception e) {
            String errorMsg = "Unable to do the reset password";
            log.error(errorMsg, e);
            model.put("msg", (errorMsg+"[reason="+e.getMessage()+"]"));
            return "resetPassword";
        }

        model.put("msg", "Password reset completed successfully!, You can signIn now...");

        return "index";
    }

}
