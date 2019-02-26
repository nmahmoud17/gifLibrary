package com.detroitlabs.giflibrary.controller;
import com.detroitlabs.giflibrary.data.CategoryRepository;
import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Category;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //instatiated when we need it at running time
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String displayCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }

    @RequestMapping("/categories/{id}")
    public String findGifByCategoryById(@PathVariable int id, ModelMap modelMap){

        Category category  = categoryRepository.findById(id);
        modelMap.put("category",category);

        List<Gif> gifs = gifRepository.findGifByCategoryId(id);
        modelMap.put("gifs", gifs);

        return "category" ;

    }


}
