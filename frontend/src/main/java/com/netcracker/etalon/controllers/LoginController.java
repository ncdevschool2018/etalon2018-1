package com.netcracker.etalon.controllers;

import com.netcracker.etalon.security.LoginUserService;
import com.netcracker.etalon.security.impl.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anton Petkun on 19.11.2017.
 */
@Controller
public class LoginController {


    @Autowired
    private LoginUserService loginUserService;

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public void login(@RequestBody CustomUser loginData, HttpServletRequest request, HttpServletResponse response) {
        try {
            loginUserService.authenticateUserAndSetSession(loginData.getUsername(), loginData.getPassword(), request, response);
        } catch (BadCredentialsException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
