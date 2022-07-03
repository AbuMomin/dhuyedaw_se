package com.se.dhuye_daw.services;

import com.se.dhuye_daw.entities.UsersEntity;
import com.se.dhuye_daw.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<UsersEntity> getUsersList(){
        List<UsersEntity> userEntities = usersRepository.findAll();
        return userEntities;
    }

    public UsersEntity addUser(String userName, String password, int role) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserName(userName);
        usersEntity.setPassword(password);
        usersEntity.setRole(role);
        usersEntity = usersRepository.save(usersEntity);
        return usersEntity;
    }

    public void deleteUser(String userName) {
        usersRepository.deleteAllByUserName(userName);
    }
}
