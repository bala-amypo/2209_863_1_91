package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {
    
    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;
    
    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository, 
                                         CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public CategorizationRule createRule(CategorizationRule rule) {
        return ruleRepository.save(rule);
    }
    
    @Override
    public CategorizationRule getRule(Long id) {
        return ruleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
    }
    
    @Override
    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }
    
    @Override
    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        return ruleRepository.findAll().stream()
            .filter(rule -> rule.getCategory() != null && 
                           rule.getCategory().getId().equals(categoryId))
            .collect(Collectors.toList());
    }
}