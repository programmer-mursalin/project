package online_voting_system;

import java.util.*;



class Commission {
    private int p1 = 0;
    private int p2 = 0;
    private int p3 = 0;
    private Set<String> votedNames = new HashSet<>();

    private static final String PASSWORD = "supersecret"; // Change this to your desired password
    private boolean authorized = false;

    public boolean login(String inputPassword) {
        authorized = PASSWORD.equals(inputPassword);
        return authorized;
    }

    public void addVote(String name, int choice) {
        if (votedNames.equals(name)) {
            System.out.println(name + " has already voted.");
            return;
        }

        votedNames.add(name);

        if (choice == 1) {
            p1++;
        } else if (choice == 2) {
            p2++;
        } else if (choice == 3) {
            p3++;
        }
    }

    public void displayResults() {
        if (authorized) {
            System.out.println("===== VOTING RESULTS =====");
            System.out.println("Party A: " + p1 + " votes");
            System.out.println("Party B: " + p2 + " votes");
            System.out.println("Party C: " + p3 + " votes");

            if (p1 > p2 && p1 > p3) {
                System.out.println("PARTY A has a lead");
            } else if (p2 > p1 && p2 > p3) {
                System.out.println("PARTY B has a lead");
            } else if (p3 > p1 && p3 > p2) {
                System.out.println("PARTY C has a lead");
            }
        } else {
            System.out.println("Unauthorized access. Please log in to view results.");
        }
    }

    boolean hasVoted(String name) {
        return votedNames.contains(name);
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ONLINE VOTING SYSTEM ");

        Commission commission = new Commission();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Vote");
            System.out.println("2. Commission");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                if (commission.hasVoted(name)) {
                    System.out.println(name + ", you have already voted.");
                } else {
                    System.out.print("Cast your vote:");
                    System.out.print("\n"); // Clear previous line
                    System.out.println("1. PARTY A");
                    System.out.println("2. PARTY B");
                    System.out.println("3. PARTY C");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    commission.addVote(name, choice);

                    System.out.println("Thank you for voting, " + name + "!");
                }
            } else if (option == 2) {
                System.out.print("Enter the password to proceed: ");
                String inputPassword = scanner.nextLine();
                if (commission.login(inputPassword)) {
                    commission.displayResults();
                } else {
                    System.out.println("Incorrect password. Unable to proceed.");
                }
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

