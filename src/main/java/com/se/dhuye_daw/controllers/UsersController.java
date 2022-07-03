package com.se.dhuye_daw.controllers;

import com.se.dhuye_daw.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object userList(){
        Object list = usersService.getUsersList();
        return list;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public Object userAdd(@RequestParam(value = "name") String userName, @RequestParam(value = "pass") String password, @RequestParam(value = "role") int role){
        return usersService.addUser(userName, password, role);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@RequestParam(value = "name") String userName){
        try{
            usersService.deleteUser(userName);
            return usersService.getUsersList();
        }
         catch (Exception e){
            e.printStackTrace();
            return "Couldn't delete";
         }
    }


}
