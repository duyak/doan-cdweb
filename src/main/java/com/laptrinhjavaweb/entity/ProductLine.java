package com.laptrinhjavaweb.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId")
    private Brand brandId;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "createUpdate")
    private Date createUpdate;



    public ProductLine() {
    }

    public ProductLine(Integer id, String name, Brand brandId) {
        id = id;
        name = name;
        brandId = brandId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateUpdate() {
        return createUpdate;
    }

    public void setCreateUpdate(Date createUpdate) {
        this.createUpdate = createUpdate;
    }
}

