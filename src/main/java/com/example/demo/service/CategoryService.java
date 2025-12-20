package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.*;

public interface CategoryService{

    Categoty createCategory(Category category);

    List<Category>getAllCategories();

    Category getCategoryById(Long id);
}