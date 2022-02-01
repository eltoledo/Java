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
    Product save(Product product);
    void delete(Product product);   

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM product p LEFT JOIN category ON category.id=p.categoryId LEFT JOIN feature ON feature.productId=p.id WHERE p.code=:code AND feature.active AND p.active GROUP BY p.id ORDER BY p.position, category.position, feature.position", nativeQuery = true)    
    List<Product> queryProductsByCode(@Param("code") String code);
}
