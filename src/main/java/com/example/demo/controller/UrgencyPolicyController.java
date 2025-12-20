package dom.example.model.controller;

import dom.example.model.UrgencyPolicy;
import dom.example.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.;
import java.util.*;

@RestController
@RequestMapping("/api/policies")
public class UrgencyPolicyController{

    private final UrgencyPolicyService urgencyPolicyService;
    public UrgencyPolicyController(UrgencyPolicyService urgencyPolicyService){
        this.urgencyPolicyService=urgencyPolicyService;
    }

    @PostMapping
    public UrgencyPolicy createPolicy(@RequestBody UrgencyPolicy policy){
        return urgencyPolicyService.createPolicy(policy);
    }

    @GetMapping
    public List<UrgencyPolicy> getAllPolicies(){
        return urgencyPolicyService.listAllPolicies();
    }

    @GetMapping("/{id}")
    public UrgencyPolicy getPolicyById(@PathVariable Long id){
        return urgencyPolicyService.getPolicyById(id);
    }
}