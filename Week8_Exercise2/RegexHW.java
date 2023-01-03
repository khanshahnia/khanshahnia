import java.util.regex.*;
import java.util.Scanner;
public class RegexHW {
    public static boolean addressValidation(String str)
    {
        String regex = "^[0-9\\\\\\/# ,a-zA-Z]+[ ,]+[0-9\\\\\\/#, a-zA-Z]{1,}$";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher(str);

        return matcher.matches();
    }
    public static boolean emailValidation(String str)
    {
        String regexEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pt = Pattern.compile(regexEmail);
        Matcher matcher = pt.matcher(str);
        
        return matcher.matches();
    }
    public static boolean phoneNoValidation(String str)
    {
        String regex = "^(1\\s?)?(\\d{3}|\\(\\d{3}\\))[\\s\\-]?\\d{3}[\\s\\-]?\\d{4}$";
        Pattern pt = Pattern.compile(regex);
        Matcher matcher = pt.matcher(str);

        return matcher.matches();
    }
    public static String findingAreaCode(String strn)
    {
        String areaCode = "";


        for (int i = 0; i < strn.length(); i++)
        {
            char c = strn.charAt(i);
            if (c >= 48 && c <= 57)
                areaCode = areaCode + c;
            else if (c == '-' || c == ')') break;
        }

        return areaCode;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of total inputs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEnter any  input (phone number, email or address)  " + (i + 1) + ":");
            String str = sc.nextLine();

            System.out.println(str);

            if (emailValidation(str))
            {
                System.out.println("It's username email");
            }
            else if (phoneNoValidation(str))
            {
                String code = findingAreaCode(str);
                System.out.println("It's a phone number with area code " + code);
            }
            else if (addressValidation(str))
            {
                System.out.println("It's an address");
            }
            else
            {
                System.out.println("No match found");
            }
        }

        sc.close();
    }
}