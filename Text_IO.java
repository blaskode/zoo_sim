
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Text_IO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Text_IO
{   /*prints menu from ArrayList<String>*/
    public static void print_message(String instruction, ArrayList<String> menu)
    {
        int i = 1;
        System.out.println(instruction);
        for(String element: menu){
            System.out.println(i++ + ". " + element);
        }
    }
    
    public static void print_block(ArrayList<String> message)
    {
        for(String element: message){
            System.out.println(element);
        }
    }
    
    /*Prints menu, solicits choice, returns int.*/
    public static int menu_prompt(String instruction, ArrayList<String> menu)
    {
        print_message(instruction, menu);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }
    
    public static void main(String[] args){
        ArrayList<String> m = new ArrayList<String>();
        m.add("Carrot");
        m.add("Apple");
        m.add("Pear");
        int choice = menu_prompt("Make a choice...", m);
        System.out.println("You chose " + choice);
    }
    
}

