package com.laptrinhjavaweb.entity;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Transient
    @Column(name = "logo")
    private MultipartFile logo;
    @Column(name = "activeFlag")
    private Integer activeFlag;
    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "brandId",fetch = FetchType.LAZY)
    private Collection<ProductLine> productLines;

    public Brand() {
    }

    public Brand(Integer id, String name, MultipartFile logo, Integer activeFlag, Date createDate, Date updateDate, Integer status) {
        id = id;
        name = name;
        logo = logo;
        activeFlag = activeFlag;
        createDate = createDate;
        updateDate = updateDate;
        status=status;

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
