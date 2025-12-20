package com.example.demo.service.impl;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UrgencyPolicyServiceImpl implements UrgencyPolicyService{

    private final UrgencyPolicyRepository policyRepository;
    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository policyRepository){
        this.policyRepository=policyRepository;
    }
}