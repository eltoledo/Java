/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import org.springframework.data.repository.Repository;
import domain.Category;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ICategory extends Repository<Category, Long>{
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void delete(Category category);
    
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM category c LEFT JOIN product p ON p.categoryId = c.id WHERE p.active GROUP BY c.id ORDER BY c.position, p.position", nativeQuery = true)    
    List<Category> queryCategories();
}
