/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.mapper;

import domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import service.dto.EcommerceProductDTO;

@Mapper(componentModel = "spring")
public interface EcommerceProductMapper {

    EcommerceProductMapper INSTANCE = Mappers.getMapper(EcommerceProductMapper.class);

    EcommerceProductDTO toDTO(Product product);

    @Mappings({
        @Mapping(target = "product.name", source = "name"),
        @Mapping(target = "product.code", source = "code"),
        @Mapping(target = "product.description", source = "description"),
        @Mapping(target = "product.category.code", source = "category.code"),
        @Mapping(target = "product.category.name", source = "category.name"),
        @Mapping(target = "product.features.code", source = "features.code"),
        @Mapping(target = "product.features.name", source = "features.name"),
        @Mapping(target = "product.features.image", source = "features.image"),
        @Mapping(target = "product.features.value", source = "features.value")
    })
    default List<EcommerceProductDTO> toDTOList(List<Product> products) {
        if (products == null) {
            return new ArrayList<>();
        }
        return products.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
