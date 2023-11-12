package exceptionsHW;
import java.util.Scanner;


public class CredentialsValidation {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = in.nextLine();
        System.out.println("Enter your password:");
        String userPass = in.nextLine();

        System.out.println("Name: " + userName + "\n" + "Password: " + userPass);
        try {
            checkCredentials(userName, userPass);
        } catch (InputIsEmptyException | InvalidCredentialsException | PasswordIsShort e) {
            e.printStackTrace();
        }

    }
  public static void checkCredentials (String name, String pass) throws InputIsEmptyException, InvalidCredentialsException, PasswordIsShort{
      String mockName = "John";
      String mockPass = "123456";
      if (name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
          throw new InputIsEmptyException("Name/password is empty");
      } else if (pass.length() < 6) {
          throw new PasswordIsShort("Password must contain at least 6 symbols");
      } else if (!mockName.equals(name) || !mockPass.equals(pass)) {
          throw new InvalidCredentialsException("Invalid username/password");
      } else {
          System.out.println("Successful login");
      }

  }
}
