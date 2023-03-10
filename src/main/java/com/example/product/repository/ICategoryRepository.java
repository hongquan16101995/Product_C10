package com.example.product.repository;

import com.example.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
