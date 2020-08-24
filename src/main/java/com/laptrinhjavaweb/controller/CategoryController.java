package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.server.CategoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
public class CategoryController {

    @Autowired
    CategoryServer categoryServer;

    @RequestMapping("/getAllCategory")
    public ModelAndView getAllCategory() {
        List<Category> categories = categoryServer.getAllCategory();
        return new ModelAndView("listCategory", "categories", categories);

    }

    //form them category
    @RequestMapping(value = "/admin/category/addCategory", method = RequestMethod.GET)
    public String formAdd(Model model) {
        Category category = new Category();
        model.addAttribute("categoryFormObj", category);
        return "addCategory";

    }
    @RequestMapping(value = "/admin/category/addCategory",method =RequestMethod.POST )
    public String addCategory(@Valid @ModelAttribute(value = "categoryFormObj") Category category, BindingResult result){
        if(result.hasErrors())
            return "addCategory";
        categoryServer.addCategoryId(category);
        return "redirect:/getAllCategory";
    }


}
