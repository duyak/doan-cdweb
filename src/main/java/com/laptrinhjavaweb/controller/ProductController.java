package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.server.BrandService;
import com.laptrinhjavaweb.server.CategoryServer;
import com.laptrinhjavaweb.server.ProductLineServer;
import com.laptrinhjavaweb.server.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
@Transactional
public class ProductController {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryServer categoryServer;

    @Autowired
    ProductServer productServer;

    @Autowired
    ProductLineServer productLineServer;

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver;
    }

    @RequestMapping("/getAllProduct")
    public ModelAndView getAllProduct() {
        List<Product> products = productServer.getAllProduct();
        return new ModelAndView("listProduct", "products", products);
    }

    // form them product
    @RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
    public String fromAdd(Model model) {
        Product product = new Product();
        List<Brand> brands = brandService.getAllBrands();
        List<Category> categories = categoryServer.getAllCategory();
        List<ProductLine> productLines = productLineServer.getAllProductLines();
        model.addAttribute("productFormObj", product);
        model.addAttribute("brands", brands);
        model.addAttribute("productLines",productLines);
        model.addAttribute("categories", categories);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute(value = "productFormObj") Product product, BindingResult result, HttpServletRequest servletRequest) {

        if (result.hasErrors())
            return "addProduct";
        productServer.addProduct(product);
        //Get the uploaded files and store them
        List<MultipartFile> imgList = product.getImgList();
        List<String> fileNames = new ArrayList<String>();
        if (null != imgList && imgList.size() > 0)
        {
            for (MultipartFile multipartFile : imgList) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return "redirect:/getAllProduct";
    }
}


// if (result.hasErrors())
//         return "addProduct";
//         productServer.addProduct(product);
//         return "redirect:/getAllProductLine";