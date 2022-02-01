/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Feature;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IFeature;

@Service
public class FeatureService {
    
    @Autowired
    private IFeature featureRepository;
    
    public List<Feature> toList() {
        return featureRepository.findAll();
    }

    public Feature toListById(long id) {
        return featureRepository.findById(id);
    }

    public Feature add(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature edit(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature delete(long id) {
        Feature feature = featureRepository.findById(id);
        if(feature != null)
             featureRepository.delete(feature);
        return feature;
    }
    
    public List<Feature> toListFeatures(long productId) {
        return featureRepository.findAllByProductId(productId);
    }
    
    public Feature toListByProductId(long productId) {
        return featureRepository.findByProductId(productId);
    }
}
