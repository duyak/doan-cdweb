package com.laptrinhjavaweb.server.impl;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.repository.BrandRepository;
import com.laptrinhjavaweb.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(value = "brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandRepository getBrandRepository() {
        return brandRepository;
    }

    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    @Transactional
    public List<Brand> getAllBrands() {
        return brandRepository.getAllBrands();
    }

    @Override
    public Brand getBrandById(Integer brandId) {
        return brandRepository.getBrandById(brandId);
    }

    @Override
    public void deleteBrand(Brand brand) {
        brand.setActiveFlag(0);
        brand.setStatus(0);
        this.brandRepository.deleteBrand(brand);

    }

    @Override
    public void addBrand(Brand brand) {
        brand.setCreateDate(new Date());
        brand.setUpdateDate(new Date());
        brand.setActiveFlag(1);
        brand.setStatus(1);
        brandRepository.addBrandId(brand);

    }

    @Override
    public void editBrand(Brand brand) {
        brand.setUpdateDate(new Date());
        brandRepository.editBrand(brand);

    }

    @Override
    public void deleteBrand(Integer brandId) {

        brandRepository.deleteBrand(brandId);


    }
}
