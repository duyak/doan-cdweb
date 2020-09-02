package com.laptrinhjavaweb.controller;

import com.google.gson.Gson;
import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.server.BrandService;
import com.laptrinhjavaweb.server.ProductLineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class ProductLineController {

    @Autowired
    ProductLineServer productLineServer;
    @Autowired
    ServletContext application;
    @Autowired
    private BrandService brandService;

    @RequestMapping("/getAllProductLine")
    public ModelAndView getAllProductLine() {
        List<ProductLine> productLines = productLineServer.getAllProductLines();
        return new ModelAndView("listProductLine", "productLines", productLines);
    }

    //form them product
    @RequestMapping(value = "/admin/productLine/addProductLine", method = RequestMethod.GET)
    public String fromAdd(Model model) {
        ProductLine productLine = new ProductLine();
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("productLineFormObj", productLine);
        model.addAttribute("brands", brands);
        return "addProductLine";
    }

    @RequestMapping(value = "/admin/productLine/addProductLine", method = RequestMethod.POST)
    public String addProductLine(@Valid @ModelAttribute(value = "productLineFormObj") ProductLine productLine, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors())
            return "addProductLine";
        productLineServer.addProductLine(productLine);
        return "redirect:/getAllProductLine";
    }


}
