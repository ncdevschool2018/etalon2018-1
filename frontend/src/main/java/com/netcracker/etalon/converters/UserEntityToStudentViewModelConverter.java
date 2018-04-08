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
package com.netcracker.etalon.converters;


import com.netcracker.etalon.entities.FacultyEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.models.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

/**
 * @author anpi0316
 *         Date: 24.10.2017
 *         Time: 21:02
 */
public class UserEntityToStudentViewModelConverter implements Converter<UserEntity, UserViewModel> {


    @Override
    public UserViewModel convert(UserEntity userEntity)  {
        StudentViewModel userViewModel = new StudentViewModel();
        userViewModel.setRole(userEntity.getRole());
        userViewModel.setUsername(userEntity.getUsername());
        userViewModel.setId(String.valueOf(userEntity.getId()));
        userViewModel.setEmail(userEntity.getEmail());
        userViewModel.setFirstName(userEntity.getFirstname());
        userViewModel.setLastName(userEntity.getLastname());

       StudentEntity student = userEntity.getStudent();
        if (student != null) {
            userViewModel.setGroup(student.getGroup());
            userViewModel.setStudentId(String.valueOf(student.getId()));
            SpecialityEntity speciality = student.getSpeciality();
            if (speciality != null) {
                userViewModel.setSpecialityId(String.valueOf(speciality.getId()));
                userViewModel.setSpecialityName(speciality.getName());
                FacultyEntity faculty = speciality.getFaculty();
                if (faculty != null) {
                    userViewModel.setFacultyId(String.valueOf(faculty.getId()));
                    userViewModel.setFacultyName(faculty.getName());
                }
            }

        }
        return userViewModel;
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