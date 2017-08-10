package Rupee;


/**
 *
 * @author Kaushik Deb Nath
 */
public class InWords {

    static String units[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine",};
    static String teens[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen",};
    static String hndrd[] = {"Hundred", "Thousand", "Lakh", "Crore"};
    static String tens[] = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
        "Eighty", "Ninty"};

    public static String convert(Double number) {
        if (number == null) {
            return "";
        } else {
            String currency = String.format("%.2f", number);
            if (currency.contains(".") && !currency.substring(currency.indexOf(".")).equals(".00")) {
                return convert(Long.parseLong(currency.substring(0, currency.indexOf("."))))
                        +" and "+ convert(Long.parseLong(currency.substring(currency.indexOf(".") + 1)))+" Paisa";
            } else {
                return convert(Long.parseLong(currency.substring(0, currency.indexOf("."))));
            }
        }
    }

    public static String convert(long number) {
        int n = 1;
        long word;
        String string = "";
        while (number != 0) {
            switch (n) {
                case 1:
                    word = number % 100;
                    string = pass(word, string);
                    if (number > 100 && number % 100 != 0) {
                        string = "and " + string;
                    }
                    number /= 100;
                    break;

                case 2:
                    word = number % 10;
                    if (word != 0) {
                        string = " " + string;
                        string = hndrd[0] + string;
                        string = " " + string;
                        string = pass(word, string);
                    }
                    number /= 10;
                    break;

                case 3:
                    word = number % 100;
                    if (word != 0) {
                        string = " " + string;
                        string = hndrd[1] + string;
                        string = " " + string;
                        string = pass(word, string);
                    }
                    number /= 100;
                    break;

                case 4:
                    word = number % 100;
                    if (word != 0) {
                        string = " " + string;
                        string = hndrd[2] + string;
                        string = " " + string;
                        string = pass(word, string);
                    }
                    number /= 100;
                    break;

                case 5:
                    if (number != 0) {
                        string = " " + string;
                        string = hndrd[3] + string;
                        string = " " + string;
                        string = convert(number) + string;
                    }
                    number = 0;
                    break;

            }
            n++;
        }
        return string;
    }

    private static String pass(long number, String string) {
        int word, q;
        if (number < 10) {
            string = units[(int) number] + string;
        }
        if (number > 9 && number < 20) {
            string = teens[(int) number - 10] + string;
        }
        if (number > 19) {
            word = (int) number % 10;
            if (word == 0) {
                q = (int) number / 10;
                string = tens[(int) q - 2] + string;
            } else {
                q = (int) number / 10;
                string = units[word] + string;
                string = " " + string;
                string = tens[q - 2] + string;
            }
        }
        return string;
    }
//
//    public static void main(String[] args) {
//        //System.out.print("Enter Number: ");
//        int num = 567891;
//        String inwords = convert(num);
//        System.out.println(inwords);
//    }
}
