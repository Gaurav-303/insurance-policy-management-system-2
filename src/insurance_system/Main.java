package insurance_system;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(25), "Home", 7000);
        Policy p4 = new Policy("P004", "David", LocalDate.now().plusDays(5), "Health", 4000);
        Policy p5 = new Policy("P001", "Alice Duplicate", LocalDate.now().plusDays(10), "Health", 5000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        System.out.println("All Unique Policies:");
        System.out.println(manager.getAllUniquePolicies());

        System.out.println("\nPolicies Expiring Soon:");
        System.out.println(manager.getPoliciesExpiringSoon());

        System.out.println("\nHealth Policies:");
        System.out.println(manager.getPoliciesByCoverage("Health"));

        System.out.println("\nDuplicate Policies:");
        System.out.println(manager.findDuplicatePolicies(Arrays.asList(p1, p2, p3, p4, p5)));

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance(Arrays.asList(p1, p2, p3, p4, p5));
    }
}

