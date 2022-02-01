/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
public class Product implements Serializable {

    @Id
    private long id;
    
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean active;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int position;
            
    @Column(nullable = false)
    private long categoryId;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<Feature> features;    
}
