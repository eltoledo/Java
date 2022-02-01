package service.mapper;

import domain.Category;
import domain.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import service.dto.ProductDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-01T08:00:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setActive( productDTO.isActive() );
        product.setCode( productDTO.getCode() );
        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );
        product.setPosition( productDTO.getPosition() );
        product.setCategoryId( productDTO.getCategoryId() );

        return product;
    }

    @Override
    public ProductDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategoryName( productCategoryName( product ) );
        productDTO.setId( product.getId() );
        productDTO.setActive( product.isActive() );
        productDTO.setCode( product.getCode() );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setPosition( product.getPosition() );
        productDTO.setCategoryId( product.getCategoryId() );

        return productDTO;
    }

    private String productCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
