package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.entity.Brand;
import com.laptrinhjavaweb.entity.ProductLine;
import com.laptrinhjavaweb.repository.BrandRepository;
import com.laptrinhjavaweb.server.BrandService;
import com.laptrinhjavaweb.server.ProductLineServer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/productline")
public class ProductLineController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductLineServer productLineServer;


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("brandss", brandService.getAllBrands());
        return "addProductLine";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String getProductLineForm(Model model) {
//        ProductLine productLine = new ProductLine();
//        model.addAttribute("productLineFormObj", productLine);
//        return "addProductLine";
//    }
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String getProductLineForm(Model model) {
//        ProductLine productLine = new ProductLine();;
//        model.addAttribute("productLineFormObj",productLine);
//        return "addProductLine";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addProductLine(@Valid @ModelAttribute(value = "productLineFormObj") ProductLine productLine, BindingResult result) {
//        if (result.hasErrors())
//            return "addProductLine";
//        productLineServer.addProductLine(productLine);
//        return "redirect:/getAllBrands";
//
//    }


}
