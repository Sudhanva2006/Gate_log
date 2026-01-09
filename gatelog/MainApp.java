package gatelog;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin","1234");
        Faculty faculty = new Faculty("faculty","abcd");

        System.out.println("==== GATE LOG SYSTEM ====");
        System.out.print("Enter role (admin/faculty)");
        String role = sc.next();

        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        if (role.equalsIgnoreCase("admin") && admin.login(username,password))
        {
            System.out.println("Admin login successful.");
        }
        else if (role.equalsIgnoreCase("faculty") && faculty.login(username,password))
        {
            System.out.println("Faculty login successful.");
        }
        else
        {
            System.out.println("Invalid credentials");
        }


        sc.close();
    }
}