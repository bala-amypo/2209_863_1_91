package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.demo.model
import java.util.*;

public interface CategorizationEngineService{

    Ticket categorizeTicket(Long ticketId);

    List<CategorizationLog> getLogsForTicket(Long ticketId);

    CategorizationLog getLog(Long id);
}