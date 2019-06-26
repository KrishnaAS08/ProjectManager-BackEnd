package com.cognizant.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.projectmanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
