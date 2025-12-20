package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService{

    private final CategorizationRuleRepository categorizationRuleRepository;
    private final CategoryRepository categoryRepository;
    public CategorizationRuleServiceImpl(CategorizationRuleRepository categorizationRuleRepository,CategoryRepository categoryRepository){
        this.categorizationRuleRepository=categorizationRuleRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public CategorizationRule createRule(Long categoryId,CategorizationRule rule){
        Category category=categoryRepository.
    }
    
}