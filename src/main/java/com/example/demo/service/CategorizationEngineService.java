package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import java.util.List;

public interface CategorizationEngineService {

    CategorizationLog categorizeTicket(Long ticketId, String engineName, String decision, String confidenceScore);

    List<CategorizationLog> getLogsByTicketId(Long ticketId);

    List<CategorizationLog> getAllLogs();
}
