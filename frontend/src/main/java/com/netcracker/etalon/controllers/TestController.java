/*
        This software is the confidential information and copyrighted work of
        NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
        is only distributed under the terms of a separate license agreement
        with NetCracker.
        Use of the software is governed by the terms of the license agreement.
        Any use of this software not in accordance with the license agreement
        is expressly prohibited by law, and may result in severe civil
        and criminal penalties.

        Copyright (c) 1995-2017 NetCracker Technology Corp.

        All Rights Reserved.

        */
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.etalon.controllers;

import com.netcracker.etalon.models.UserViewModel;
import org.apache.commons.logging.impl.NoOpLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anpi0316
 *         Date: 04.03.2018
 *         Time: 14:44
 */
@Controller
public class TestController {

    private static final String VIEW_NAME_LOGIN = "login";
    private static final String MODEL_USERS = "users";


    @RequestMapping(value = "/users-view", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);
        modelAndView.addObject(MODEL_USERS, getStubUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserViewModel> getUsersAsJson() {
        return getStubUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public UserViewModel getUsersAsJson(@RequestBody UserViewModel userViewModel) {
        return userViewModel;
    }

    private List<UserViewModel> getStubUsers() {
        List<UserViewModel> userViewModels = new ArrayList<>();
        UserViewModel userViewModelIvan  = new UserViewModel();
        userViewModelIvan.setId("113");
        userViewModelIvan.setName("Ivan");
        UserViewModel userViewModelLeopold = new UserViewModel();
        userViewModelLeopold.setId("114");
        userViewModelLeopold.setName("Leopold");
        userViewModels.add(userViewModelIvan);
        userViewModels.add(userViewModelLeopold);
        return userViewModels;
    }
}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER.

 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.

 Copyright (c) 1995-2017 NetCracker Technology Corp.

 All Rights Reserved.
*/