package insurance_system;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();
        for (Policy policy : treeSetPolicies) {
            if (!policy.getExpiryDate().isBefore(now) && !policy.getExpiryDate().isAfter(limit)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    public List<Policy> getPoliciesByCoverage(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }
    public Set<Policy> findDuplicatePolicies(List<Policy> policies) {
        Set<Policy> unique = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();
        for (Policy policy : policies) {
            if (!unique.add(policy)) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

}
