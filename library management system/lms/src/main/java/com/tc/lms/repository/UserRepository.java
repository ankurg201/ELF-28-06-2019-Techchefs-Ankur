package com.tc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tc.lms.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
