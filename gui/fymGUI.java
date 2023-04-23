package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fymGUI  extends JFrame {
   private CardLayout cardLayout;
   private JPanel cards;
   private JButton transactionsButton;
   private JButton statsButton;
   private JButton accountsButton;

   public fymGUI() {
      // Tạo các trang và thêm chúng vào bố cục CardLayout
      TransactionGUI transactionGUI = new TransactionGUI();
      StatsGUI statsGUI = new StatsGUI();
      AccountGUI accountGUI = new AccountGUI();

      cards = new JPanel();
      cardLayout = new CardLayout();
      cards.setLayout(cardLayout);
      cards.add(transactionGUI, "transactions");
      cards.add(statsGUI, "stats");
      cards.add(accountGUI, "accounts");

      // Tạo các nút để chuyển đổi giữa các trang
      transactionsButton = new JButton("Transactions");
      transactionsButton.addActionListener(event -> cardLayout.show(cards, "transactions"));

      statsButton = new JButton("Stats");
      statsButton.addActionListener(event -> cardLayout.show(cards, "stats"));

      accountsButton = new JButton("Accounts");
      accountsButton.addActionListener(event -> cardLayout.show(cards, "accounts"));

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(transactionsButton);
      buttonPanel.add(statsButton);
      buttonPanel.add(accountsButton);

      // Thêm các thành phần vào khung chứa
      getContentPane().add(cards, BorderLayout.CENTER);
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);

      // Thiết lập kích thước và hiển thị giao diện
      setTitle("My Application");
      setSize(500, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      new fymGUI();
   }
}

