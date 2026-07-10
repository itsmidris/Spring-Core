package com.test.SecurityP03;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("isAuthenticated")
    public String getBalance() {
        return "Balance: 10000";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeAccount() {
        return "account closed.";
    }

}
