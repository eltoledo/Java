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
import service.dto.ProductDTO;

@Mapper(componentModel = "spring", uses = {FeatureMapper.class, CategoryMapper.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDTO productDTO);
    
    @Mappings({
        @Mapping(target = "categoryName", source = "category.name")
    })
    ProductDTO toDTO(Product product);
    
    @Mappings({
        @Mapping(target = "productName", source = "name"),
        @Mapping(target = "products", ignore = true)
    })
    default List<ProductDTO> toDtoList(List<Product> products) {
        if (products == null) {
            return new ArrayList<>();
        }
        return products.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
