/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"})}) 
public class Category implements Serializable{
    
    @Id
    private long id;
    
    @Column(unique = true, nullable = false)
    private String code;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int position;       
    
    @Column(nullable = true)
    private long parentId = 0;       
    
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parentId", insertable = false, updatable = false, nullable = true)
    private Category category;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;    


}
