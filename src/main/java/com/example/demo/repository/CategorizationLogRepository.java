package com.example.demo.repository;

import com.example.demo.model.CategorizationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface CategorizationLogRepository extends JpaRepository<CategorizationLog,Long>{
    List<CategorizationLog>findByTicketId(Long ticketId);
}