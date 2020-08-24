package com.laptrinhjavaweb.entity;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Brand {
    @Transient
    @Column(name = "logo")
    MultipartFile logo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "username phải ít nhất 2 kí tự")
    @NotEmpty(message = "Không được để trống username !")
    private String name;
    @Column(name = "activeFlag")
    private Integer activeFlag;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY)
    private Collection<ProductLine> productLines;

    @OneToMany(mappedBy = "brandId",fetch = FetchType.LAZY)
    private Collection<Product> products;

    public Brand() {
    }

    public Brand(Integer id, String name, MultipartFile logo, Integer activeFlag, Date createDate, Date updateDate, Integer status) {
        id = id;
        name = name;
        logo = logo;
        activeFlag = activeFlag;
        createDate = createDate;
        updateDate = updateDate;
        status = status;

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

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<ProductLine> getProductLines() {
        return productLines;
    }

    public void setProductLines(Collection<ProductLine> productLines) {
        this.productLines = productLines;
    }


}
