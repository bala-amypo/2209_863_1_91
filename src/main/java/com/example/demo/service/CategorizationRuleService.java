package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule addRule(CategorizationRule rule);
    List<CategorizationRule> getRules();
    List<CategorizationRule> search(String keyword);
}
