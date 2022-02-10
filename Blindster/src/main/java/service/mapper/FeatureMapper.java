/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.mapper;

import domain.Feature;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import service.dto.FeatureDTO;

@Mapper(componentModel = "spring")
public interface FeatureMapper {
    
    FeatureMapper INSTANCE = Mappers.getMapper(FeatureMapper.class);
    
    Feature toEntity(FeatureDTO featureDTO);
    
    @Mappings({
        @Mapping(target = "productName", source = "product.name"),
        @Mapping(target = "productId", source = "product.id")                
    })
    FeatureDTO toDTO(Feature feature);
    
    default List<FeatureDTO> toDtoList(List<Feature> features){
        if(features == null)
            return new ArrayList<>();
        return features.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
