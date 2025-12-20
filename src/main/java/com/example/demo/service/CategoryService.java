package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.*;

public interface CategoryService{

    Category createCategory(Category category);

    List<Category>getAllCategories();

    Category getCategory(Long id);
}