package com.zoo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zoo.bean.Animals;

@Repository
public interface AnimalRepository extends JpaRepository<Animals, Long>{
 List<Animals> findByZooId(Integer zooId);
 Optional<Animals> findByIdAndZooId(Integer id, Integer zooId);
}