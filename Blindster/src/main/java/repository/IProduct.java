/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author eltoledo
 */
public interface IProduct extends Repository<Product, Long>{
    List<Product> findAll();
    Product findById(Long id);
    Product findByCode(String code);
    Product save(Product product);
    void delete(Product product);   

    
    @Query(value = "SELECT * FROM product p WHERE p.code=:code and p.active;", nativeQuery = true)    
    Product findProductByCodeAndActive(@Param("code") String code);
    
    @Query(value = "SELECT * FROM product p WHERE p.categoryId=:categoryId and p.active ORDER BY p.position;", nativeQuery = true)    
    List<Product> findProductByCategoryIdActive(@Param("categoryId") long categoryId);
}
