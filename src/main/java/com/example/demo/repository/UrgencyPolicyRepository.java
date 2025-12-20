package com.example.demo.repository;

import com.example.demo.model.UrgencyPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UrgencyPolicyRepository extends JpaRepository<UrgencyPolicy,Lomg>{
    List<UrgencyPolicy>findByKeywordContainingIgnoreCase(String keyword);
}