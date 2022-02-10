package service.mapper;

import domain.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import service.dto.CategoryDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-10T07:53:38-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO categotyDTO) {
        if ( categotyDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categotyDTO.getId() );
        category.setCode( categotyDTO.getCode() );
        category.setName( categotyDTO.getName() );
        category.setPosition( categotyDTO.getPosition() );

        return category;
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setParentName( categoryCategoryName( category ) );
        categoryDTO.setParentId( categoryCategoryId( category ) );
        categoryDTO.setId( category.getId() );
        categoryDTO.setCode( category.getCode() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setPosition( category.getPosition() );

        return categoryDTO;
    }

    @Override
    public CategoryDTO toDTOProducts(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setParentName( categoryCategoryName( category ) );
        categoryDTO.setParentId( categoryCategoryId( category ) );
        categoryDTO.setId( category.getId() );
        categoryDTO.setCode( category.getCode() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setPosition( category.getPosition() );

        return categoryDTO;
    }

    private String categoryCategoryName(Category category) {
        if ( category == null ) {
            return null;
        }
        Category category1 = category.getCategory();
        if ( category1 == null ) {
            return null;
        }
        String name = category1.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private long categoryCategoryId(Category category) {
        if ( category == null ) {
            return 0L;
        }
        Category category1 = category.getCategory();
        if ( category1 == null ) {
            return 0L;
        }
        long id = category1.getId();
        return id;
    }
}
