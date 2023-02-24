package com.example.product.repository;

import com.example.product.model.Category;
import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategory(Category category, Pageable pageable);

    List<Product> findAllByPriceBetween(Double price, Double price1);

    @Query(value = "select p from Product p where p.name like :name")
    //annotation @Query sử dụng để build customize query trong JPA
    //annotation @Param dùng để thêm tham số vào câu native query theo tên tương ứng
    List<Product> findByName(@Param("name") String name);


}
