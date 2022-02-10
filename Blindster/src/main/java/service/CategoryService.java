package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICategory;

@Service
public class CategoryService {
    
    @Autowired
    private ICategory categoryReposity;
    
    public List<Category> toList() {
        return categoryReposity.findAll();
    }
    
    public List<Category> toListCategoriesByParentId(long parentId) {
        return categoryReposity.findByParentId(parentId);
    }
    
    public List<Category> toListCategories() {
        return categoryReposity.queryCategories();
    }

    public Category toCategoryById(Long id) {
        return categoryReposity.findById(id);
    }

    public Category add(Category category) {
        return categoryReposity.save(category);
    }

    public Category edit(Category category) {
        return categoryReposity.save(category);
    }

    public Category delete(Long id) {
        Category category = categoryReposity.findById(id);
        if(category != null)
             categoryReposity.delete(category);
        return category;
    }
}
