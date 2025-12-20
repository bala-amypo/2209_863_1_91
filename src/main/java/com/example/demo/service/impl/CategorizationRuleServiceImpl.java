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
    private 
    public CategorizationRuleServiceImpl(CategorizationRuleRepository categorizationRuleRepository){
        this.categorizationRuleRepository=categorizationRuleRepository;
    }
    
}