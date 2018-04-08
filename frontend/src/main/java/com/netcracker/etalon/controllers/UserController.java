package com.netcracker.etalon.controllers;

import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.models.UserViewModel;
import com.netcracker.etalon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));
    private final TypeDescriptor userViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserViewModel.class));


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<UserEntity> allStudents = userService.findAllStudents();
        return (List<StudentViewModel>) conversionService.convert(allStudents, userEntityTypeDescriptor, userViewModelTypeDescriptor);
    }
}
