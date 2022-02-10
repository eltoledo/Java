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
        
    @Query(value = "SELECT * FROM category c ORDER BY c.position", nativeQuery = true)    
    List<Category> queryCategories();
    
    @Query(value = "SELECT * FROM category c WHERE c.parentId=:parentId ORDER BY c.position", nativeQuery = true)   
    List<Category> findByParentId(Long parentId);
    
    
}
