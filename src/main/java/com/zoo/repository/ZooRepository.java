package com.zoo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zoo.bean.Zoo;

@Repository
public interface ZooRepository extends JpaRepository<Zoo,Integer>{

}