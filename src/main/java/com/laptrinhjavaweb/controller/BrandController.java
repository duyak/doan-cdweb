package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    public BrandService getBrandService() {
        return brandService;
    }

    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver;
    }

    @RequestMapping("/getAllBrands")
    public ModelAndView getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return new ModelAndView("listBrand", "brands", brands);
    }

    @RequestMapping("/getBrandById/{brandId}")
    public ModelAndView getBrandById(@PathVariable(value = "brandId") Integer brandId) {
        Brand brand = brandService.getBrandById(brandId);
        return new ModelAndView("brandPage", "brandObj", brand);

    }

    @RequestMapping("/admin/delete/{brandId}")
    public String deleteBrand(@PathVariable(value = "brandId") Brand brandId) {
        Path path = Paths.get("C:/Users/Ismail/workspace/ShoppingCart/src/main/webapp/WEB-INF/resource/images/products/" + brandId + ".jpg");

        if (Files.exists(path)) {
            try {
                Files.delete(path);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        brandService.deleteBrand(brandId);
        return "redirect:/getAllBrands";

    }

    @RequestMapping("admin/delete1/{brandId}")
    public String deleteBrand(@PathVariable(value = "brandId") int brandId) {

        brandService.deleteBrand(brandId);
        return "redirect:/getAllBrands";

    }

    @RequestMapping(value = "/admin/brand/addBrand", method = RequestMethod.GET)
    public String getBrandForm(Model model) {
        Brand brand = new Brand();
        model.addAttribute("brandFormObj", brand);
        return "addBrand";
    }

    @RequestMapping(value = "/admin/brand/addBrand", method = RequestMethod.POST)
    public String addBrand(@Valid @ModelAttribute(value = "brandFormObj") Brand brand, BindingResult result) {
        // Binding Result is used if the form that has any error then it will
        // redirect to the same page without performing any functions
        if (result.hasErrors())
            return "addBrand";
        brandService.addBrand(brand);
        MultipartFile logo = brand.getLogo();
        if (logo != null && !logo.isEmpty()) {
            Path path = Paths.get("C:/Users/Ismail/workspace/ShoppingCart/src/main/webapp/WEB-INF/resource/images/products/" + brand.getId() + ".jpg");

            try {
                logo.transferTo(new File(path.toString()));

            } catch (IllegalStateException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/getAllBrands";
    }

    @RequestMapping(value = "/admin/brand/editBrand/{brandId}")
    public ModelAndView getEditForm(@PathVariable(value = "brandId") Integer brandId) {
        Brand brand = brandService.getBrandById(brandId);
        return new ModelAndView("editBrand", "editBrandObj", brand);
    }

    @RequestMapping(value = "/admin/brand/editBrand/", method = RequestMethod.POST)
    public String editBrand(@ModelAttribute(value = "editBrandObj") Brand brand) {
        brandService.editBrand(brand);
        return "redirect:/getAllBrands";
    }

    @RequestMapping("/getBrandsList")
    public @ResponseBody
    List<Brand> getBrandListInJson() {
        return brandService.getAllBrands();
    }

    @RequestMapping("/brandListAngular")
    public String getBrands() {
        return "brandListAngular";
    }


}
