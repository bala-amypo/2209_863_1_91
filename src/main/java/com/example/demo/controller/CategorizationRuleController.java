package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController{

    private final CategorizationRuleService categorizationRuleService;
    public CategorizationRuleController(CategorizationRuleService categorizationRuleService){
        this.categorizationRuleService=categorizationRuleService;
    }

    @PostMapping("/{categoryId}")
}