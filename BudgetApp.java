import java.util.Scanner;

public class BudgetApp {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        double balance = 0.0;
        
        while (true) {
            System.out.println("------FYM-------");
            System.out.println("1. Them thu nhap");
            System.out.println("2. Them chi tieu");
            System.out.println("3. Check so du");
            System.out.println("4. Thoat");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear the input buffer
            
            switch (choice) {
                case 1:
                    System.out.print("Them so tien thu nhap: ");
                    double income = scanner.nextDouble();
                    balance += income;
                    System.out.printf("Da them %.2f vao so du. So du moi la %.2f\n", income, balance);
                    break;
                case 2:
                    System.out.print("Them so tien chi tieu: ");
                    double expense = scanner.nextDouble();
                    balance -= expense;
                    System.out.printf("Tru %.2f khoi tai khoan. So du moi la %.2f\n", expense, balance);
                    break;
                case 3:
                    System.out.printf("So du hien tai la %.2f\n", balance);
                    break;
                case 4:
                    System.out.println("Thoat...");
                    System.exit(0);
                default:
                    System.out.println("Chon dung vao");
            }
        }
    }
}

