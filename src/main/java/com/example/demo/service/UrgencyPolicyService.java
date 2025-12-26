package com.example.demo.service;

import com.example.demo.model.UrgencyPolicy;
import java.util.List;

public interface UrgencyPolicyService {
    UrgencyPolicy addPolicy(UrgencyPolicy policy);
    List<UrgencyPolicy> search(String keyword);
}
