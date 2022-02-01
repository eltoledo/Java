/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
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
@Table(name = "feature", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"})}) 
public class Feature implements Serializable{
    
    @Id
    private long id;
    
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean active;
    
    @Column(unique = true, nullable = false)
    private String code;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int position;    
    
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Type type;    
    
    @Column
    private String image;
    
    @Column
    private String value;
    
    @Column
    private long productId;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;
}
