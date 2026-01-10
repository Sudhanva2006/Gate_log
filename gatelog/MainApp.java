package gatelog;

import java.util.Scanner;



public class MainApp {

    

  

    public static void main(String[] args) {
        if (DBConnection.getConnection() != null) {
        System.out.println("Database connected successfully!");
    }

         
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin", "1234");
        Faculty faculty = new Faculty("faculty", "abcd");

        System.out.println("===== GATE LOG SYSTEM =====");
        System.out.print("Enter role (admin/faculty): ");
        String role = sc.next();

        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        if (role.equalsIgnoreCase("admin") && admin.login(username, password)) {
            showAdminMenu(sc);
        }
        else if (role.equalsIgnoreCase("faculty") && faculty.login(username, password)) {
            showFacultyMenu(sc);
        }
        else {
            System.out.println("Invalid credentials. Access denied.");
        }

        sc.close();
    }

    // Admin Menu
    private static void showAdminMenu(Scanner sc) {

    int choice;

    do {
        System.out.println("\n--- ADMIN MENU ---");
        System.out.println("1. Add Visitor Entry");
        System.out.println("2. Verify Student Exit");
        System.out.println("3. View Visitor Log");
        System.out.println("4. Logout");


        System.out.print("Enter choice: ");

        choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            
            case 1:
                System.out.print("Enter Visitor Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();

                System.out.print("Enter Purpose: ");
                String purpose = sc.nextLine();

                System.out.print("Enter In-Time: ");
                String inTime = sc.nextLine();

                Visitor v = new Visitor(name, phone, purpose, inTime);

                if (VisitorDAO.addVisitor(v)) {
                System.out.println("Visitor entry stored in database.");
                } else {
                     System.out.println("Failed to store visitor entry.");                    }
                break;


            case 2:
                System.out.print("Enter Student USN to verify: ");
                String searchUsn = sc.nextLine();

                 boolean found = false;

                 StudentExit exit = StudentExitDAO.getExitByUsn(searchUsn);

                 if (exit != null) {
                 exit.displayExitStatus();
                 } else {
                    System.out.println("No exit permission found for this USN.");
                 }


                if (!found) 
                {
                    System.out.println("No exit permission found for this USN.");
                }
                break;


            
            case 3:
                VisitorDAO.viewVisitors();
                break;


            case 4:
                
                System.out.println("Admin logged out.");
            break;


            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 4);
}


    // Faculty Menu
    private static void showFacultyMenu(Scanner sc) {

   

    int choice;

    do {
        System.out.println("\n--- FACULTY MENU ---");
        System.out.println("1. Approve Student Exit");
        System.out.println("2. Logout");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            case 1:
                System.out.print("Enter Student USN: ");
                String usn = sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Reason for Exit: ");
                String reason = sc.nextLine();

                StudentExit exit = new StudentExit(usn, name, dept, year, reason);
                exit.approveExit("Faculty");

                boolean stored = StudentExitDAO.insertExit(exit);

                if (stored) {
                     System.out.println("Student exit approved and stored in database.");
                } else {
                     System.out.println("Failed to store student exit.");
                }


                System.out.println("Student exit approved successfully.");
                break;

            case 2:
                System.out.println("Faculty logged out.");
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 2);
}
}
