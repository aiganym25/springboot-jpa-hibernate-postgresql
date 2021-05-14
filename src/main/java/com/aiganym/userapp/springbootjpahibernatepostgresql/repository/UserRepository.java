package com.aiganym.userapp.springbootjpahibernatepostgresql.repository;


import com.aiganym.userapp.springbootjpahibernatepostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
}