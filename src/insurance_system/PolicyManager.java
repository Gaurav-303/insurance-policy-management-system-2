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
    public void comparePerformance(List<Policy> policies) {
        testPerformance(new HashSet<>(), policies, "HashSet");
        testPerformance(new LinkedHashSet<>(), policies, "LinkedHashSet");
        testPerformance(new TreeSet<>(), policies, "TreeSet");
    }

    private void testPerformance(Set<Policy> set, List<Policy> policies, String type) {
        long start, end;

        start = System.nanoTime();
        set.addAll(policies);
        end = System.nanoTime();
        System.out.println(type + " - Add time: " + (end - start) + " ns");

        Policy sample = policies.get(0);
        start = System.nanoTime();
        set.contains(sample);
        end = System.nanoTime();
        System.out.println(type + " - Search time: " + (end - start) + " ns");

        start = System.nanoTime();
        set.remove(sample);
        end = System.nanoTime();
        System.out.println(type + " - Remove time: " + (end - start) + " ns");
    }

}
