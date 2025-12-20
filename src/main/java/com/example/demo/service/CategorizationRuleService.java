package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import java.util.*;

public interface CategorizationRuleService{

    CategorizationRule createRule(Long categoryId,CategorizationRule rule);

    List<CategorizationRule> getRulesByCategory(Long categoryId);

    CategorizationRule getRule(Long id);
}