/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IProduct;

@Service
public class ProductService {
    
    @Autowired
    private IProduct productReposity;
    
    public List<Product> toList() {
        return productReposity.findAll();
    }

    public Product toProductById(long id) {
        return productReposity.findById(id);
    }

    public Product add(Product product) {
        return productReposity.save(product);
    }

    public Product edit(Product product) {
        return productReposity.save(product);
    }

    public Product delete(long id) {
        Product product = productReposity.findById(id);
        if(product != null)
             productReposity.delete(product);
        return product;
    }
    
    public Product findProductByCode(String code){
        return productReposity.findProductByCodeAndActive(code);
    }
    
    public List<Product> findProductByCategoryIdActive(long categoryId){
        return productReposity.findProductByCategoryIdActive(categoryId);
    }
}
