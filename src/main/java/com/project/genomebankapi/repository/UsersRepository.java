package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByEmail(String email);
}
