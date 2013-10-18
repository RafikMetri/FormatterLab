import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 10/17/13
 * Time: 8:22 AM
 */

public class Format {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private String[] products = new String[3];
    private int[] qty = new int[3];
    private double[] price = new double[3];
    private StringBuffer width = new StringBuffer();
    private StringBuffer width2 = new StringBuffer();

    public static void main(String[] args){
        Format format = new Format();
        format.addProducts();
        format.printTitle();
        format.printProducts();
        format.printTotal();
    }

    public void printTitle(){
        System.out.print(width);
        System.out.println(width2);
        f.format(width.toString(), "Desc", "Quantity", "Price");
        f.format(width.toString(), dashes(largestStringLength(products)), "----------", "----------");
    }

    public void print(String product, int qty, double price){
        f.format(width2.toString(), product, qty, price, price);
        total += price * qty;
    }

    public void printProducts(){
        print(products[0], qty[0], price[0]);
        print(products[1], qty[1], price[1]);
        print(products[2], qty[2], price[2]);
    }

    public void printTotal(){
        f.format(width2.toString(), "Tax", "", total*0.06);
        f.format(width.toString(), "", "", "----------");
        f.format(width2.toString(), "Total", "", total*1.06);
    }

    public void addProducts(){
        products[0] = "Hard Drive Encoder";
        qty[0] = 3;
        price[0] = 19.99;
        products[1] = "SATA Cable";
        qty[1] = 10;
        price[1] = 11.50;
        products[2] = "1 TB HD";
        qty[2] = 1;
        price[2] = 145.80;

        width.append("%-" + largestStringLength(products) + "s %10s %10s\n");
        width2.append("%-" + largestStringLength(products) + "." + largestStringLength(products) + "s %10s %10.2f\n");
    }

    public int largestStringLength(String[] stringArray){
        String largestString = stringArray[0];
        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i].length() > largestString.length()){
                largestString = stringArray[1];
            }
        }
        return largestString.length();
    }

    public String dashes(int length){
        StringBuffer dashes = new StringBuffer();

        for(int i = 0; i < length; i++)
            dashes.append('-');

        return dashes.toString();
    }
}