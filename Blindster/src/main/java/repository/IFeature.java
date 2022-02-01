/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.Feature;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author eltoledo
 */
public interface IFeature extends Repository<Feature, Long>{
    List<Feature> findAll();
    Feature findById(long id);
    Feature save(Feature feature);
    void delete(Feature feature);
    List<Feature> findAllByProductId(long productId);
    Feature findByProductId(long productId);
}
