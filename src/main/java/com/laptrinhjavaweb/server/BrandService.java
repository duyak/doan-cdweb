package com.laptrinhjavaweb.server;



import com.laptrinhjavaweb.entity.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getAllBrands();

    Brand getBrandById(Integer brandId);

    void deleteBrand(Brand brand);

    void addBrand(Brand brand);

    void editBrand(Brand brand);

    void deleteBrand(Integer brandId);
}
