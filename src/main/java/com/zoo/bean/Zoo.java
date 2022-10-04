package com.zoo.bean;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zoo")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "zoo_name")
    private String zooname;
 
    
//one to many mapping code
    @OneToMany(mappedBy = "zoo", cascade = {
        CascadeType.ALL
    })
    private List < Animals > animals;

    public Zoo() {

    }

    public Zoo(String zooname ) {
        this.zooname = zooname;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZooName() {
        return zooname;
    }

    public void setZooName(String zooname) {
        this.zooname = zooname;
    }

   

    public List < Animals > getAnimals() {
        return animals;
    }

    public void setAnimals(List < Animals > animals) {
        this.animals = animals;
    }
}
