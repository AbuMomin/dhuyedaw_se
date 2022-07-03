package com.se.dhuye_daw.repositories;

import com.se.dhuye_daw.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
   List<UsersEntity> findAllByRole(int role);
   List<UsersEntity> findAllByRoleAndUserNameStartsWith(int role, String alias);
   @Modifying
   @Transactional
   void deleteAllByUserName(String userName);
}
