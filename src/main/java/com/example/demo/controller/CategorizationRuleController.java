package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {
    
    private final CategorizationRuleService ruleService;
    
    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }
    
    @PostMapping
    public ResponseEntity<CategorizationRule> createRule(@RequestBody CategorizationRule rule) {
        // Fixed: Now calling with just the rule parameter, not (categoryId, rule)
        CategorizationRule created = ruleService.createRule(rule);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> getRule(@PathVariable Long id) {
        CategorizationRule rule = ruleService.getRule(id);
        return ResponseEntity.ok(rule);
    }
    
    @GetMapping
    public ResponseEntity<List<CategorizationRule>> getAllRules() {
        List<CategorizationRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategorizationRule>> getRulesByCategory(@PathVariable Long categoryId) {
        List<CategorizationRule> rules = ruleService.getRulesByCategory(categoryId);
        return ResponseEntity.ok(rules);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        // Add delete functionality if needed
        return ResponseEntity.noContent().build();
    }
}