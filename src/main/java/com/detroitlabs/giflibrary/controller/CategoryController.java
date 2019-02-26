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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/search", method = GET)
    public String searchAllGifs(@RequestParam ("q") String search, ModelMap modelMap){

        List<Gif> searchedGifs = gifRepository.searchResults(search);
        modelMap.put("searchedGifs",searchedGifs);
        return "search";

    }





}
