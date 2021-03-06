import java.util.*;
import java.lang.System.*;
import static java.util.stream.Collectors.toList;

/**
 * Simulates a Zoo with three animals: Penguin, Tiger, and Turtle. Designed for
 * use with command-line standard input.
 *
 * @Damien Blasko
 * @11 December 19
 */
public class Zoo
{
    private ArrayList<Animal> inventory = new ArrayList<Animal>();
    private int days = 0;
    private int money = 100000;
    
    
    public Zoo(int money, int num_penguins, int num_tigers, 
        int num_turtles)
    {
        this.money = money;    

        // The second arg of 'buy' is an enum defined
        // in its own file...
        buy(num_penguins, Species.PENGUIN);     
        buy(num_tigers, Species.TIGER);
        buy(num_turtles, Species.TURTLE);
    }
    
    /*
        Returns the amount of money in the Zoo's treasury.
    */
    public int get_money(){
        return money;
    }
    
    /*
      The returned value is a multi-line message stored in an array that
      describes the transaction performed by invoking the method. The messages
      can be printed to Standard Output using the Text_IO stub class that I
      have included in this project.

      The first argument is the number of animals we wish to buy; the
      second argument is the type of animal we wish to buy. The second arg
      is an enum defined in a separate file; it makes the method polymorphic
      over a discrete set of 'Animal' subclasses.    
    */
    private ArrayList<String> buy(int num, Species type)
    {
        int cost = 0;
        ArrayList<String> message = new ArrayList<String>();
        /* 
          The following switch lends polymorphic behavior to the function. 
          Although it works well for the small number of 'Animal' subclasses, 
          that we are working with, it would be cumbersome for bigger sets, due 
          to code-repetition: each case-statement performs the same action 
        */
        switch(type)
        {
            /* 
              The first branch has been included for testing purposes, if 
              it is ever actually triggered, the program is in a state of error 
            */ 
            case ANIMAL :  
            {
              throw new IllegalArgumentException("Superclass not valid input."); 
            }
            case PENGUIN : 
            {
              int i = 0;
              for(; i < num; i++)
              {
                inventory.add(new Penguin());
                cost += Penguin.get_cost();
              }
              message.add("You bought " + i + " penguins.");
              break;
            }
            case TIGER : 
            {
              int i = 0;
              for(; i < num; i++)
              {
                inventory.add(new Tiger());
                cost += Tiger.get_cost();
              }
              message.add("You bought " + i + " tigers.");
              break;
            }
            case TURTLE :
            {
              int i = 0;
              for(; i < num; i++)
              {
                inventory.add(new Turtle());
                cost += Turtle.get_cost();
              }
              message.add("You bought " + i + " turtles.");
              break;
            }
            default : break;
        }
        money -= cost;
        message.add("You have spent $" + -cost);
        return message;
    }

    public ArrayList<String> increment_day()
    {
        ArrayList<String> message = new ArrayList<String>();
        for(Animal element : inventory)
        {
            element.increment_age();
        }
        message.add("Day " + ++days + " of operation.");
        return message;
    }
   
   
    public ArrayList<String> random_birth()
    {
        ArrayList<String> message = new ArrayList<String>();
        /*
          This is where things get interesting. We create a new collection--
          a 'list'--called 'adults' which only contains adult animals from our
          Zoo inventory. We do this by using the 'stream' functionality introduced
          in Java 8:

          A stream is a wrapper that allows a container to be processed as if it
          were a recursive data structure in a functional context, i.e., sequential 
          processing that yields new-from-old structures, rather than a modification 
          of the existing structure.

          '.filter' allows only cases for which the condition is true to be added to the new
          collection
          '.collect(toList)' gathers the vetted items into a new list.
          
          New line characters between '.stream', '.filter', and '.collect' indicate the use of
          Java's stream pipe operator.
        */
        List<Animal> adults =
            inventory.stream()
                     .filter(a -> a.is_adult())
                     .collect(toList());
        Random r = new Random();
        if(adults.size() > 0) {
            int rand = r.nextInt(adults.size());
            //System.out.println("Random: " + rand);
            message.add("A " + adults.get(rand).what_am_i().name().toLowerCase()
                            + " has given birth");
            inventory.addAll(adults.get(rand).give_birth());
        } else {
            message.add("Nothing happened today.");
        }
        return message;
    }
    
    
    public ArrayList<String> deduct_all_feeding_costs()
    {
        int penguins, tigers, turtles;
        penguins = tigers = turtles = 0;
        ArrayList<String> message = new ArrayList<String>();
        for(Animal element: inventory)
        {
            if (element.what_am_i() == Species.PENGUIN) {
                penguins += element.get_feeding_cost();
            }
            else if (element.what_am_i() == Species.TIGER) {
                tigers += element.get_feeding_cost();
            }
            else if (element.what_am_i() == Species.TURTLE) {
                turtles += element.get_feeding_cost();
            }
        }
        message.add("Total feeding cost of Penguins is " + penguins);
        message.add("Total feeding cost of Tigers is " + tigers);
        message.add("Total feeding cost of Turtles is " + turtles);
        int sum = penguins + tigers + turtles;
        money -= sum;
        message.add("Total of feeding costs: $" + (sum));
        return message;
    }
    
    public ArrayList<String> accrue_payoffs()
    {
        int penguins, tigers, turtles;
        penguins = tigers = turtles = 0;
        ArrayList<String> message = new ArrayList<String>();
        for(Animal element: inventory)
        {
            if (element.what_am_i() == Species.PENGUIN) {
                penguins += element.get_payoff();
            }
            else if (element.what_am_i() == Species.TIGER) {
                tigers += element.get_payoff();
            }
            else if (element.what_am_i() == Species.TURTLE) {
                turtles += element.get_payoff();
            }
        }
        message.add("Total Penguin profit is " + penguins);
        message.add("Total Tiger profit is " + tigers);
        message.add("Total Turtle profit is " + turtles);
        int sum = penguins + tigers + turtles;
        money += sum;
        message.add("Total profit: $" + (sum));
        return message;
    }
    
    public boolean is_solvent()
    {
        if (money > 0) {return true;}
        else {return false;}
        
    }
    
    private int random_inventory_index()
    {
        Random r = new Random();
        int rand = r.nextInt(inventory.size());
        return rand;
    }
    
    private void remove_from_inventory(int index)
    {
        inventory.remove(index);
    }
    
    public ArrayList<String> kill_random(){
        ArrayList<String> message = new ArrayList<String>();
        if (inventory.size() > 0){
            int r = random_inventory_index();
            message.add("A " + inventory.get(r).what_am_i().name().toLowerCase()
                    + " has died.");
            remove_from_inventory(r);
        } else {
            message.add("Nothing happened today.");
        }
        return message;
    }
    
    public ArrayList<String> boom(){
        ArrayList<String> message = new ArrayList<String>();
        int sum = 0;
        
        List<Animal> tigers =
            inventory.stream()
                     .filter(a -> a.what_am_i()== Species.TIGER)
                     .collect(toList());
        if (tigers.size() > 0)
        {
            Random r = new Random();
            for(Animal a : tigers)
            {
                sum += r.nextInt(250) + 250;
            }
            message.add("A boom in Zoo attendance increased profits by " + sum);
            money += sum;
        } else {
            message.add("Nothing happened today.");
        }
        return message;
    }
   
    public ArrayList<String> daily_status()
    {
        ArrayList<String> message = new ArrayList<String>();
        message.add("At the end of day " + days + " you have " + "$" + money);
        return message;
    }
    
    public static void main(String[] args)
    {   
       if (args.length != 4) throw new IllegalArgumentException ("Incorrect number of arguments.");
       
       int money_, penguins_, tigers_, turtles_;
       money_ = penguins_ = tigers_ = turtles_ = 0;
       
       try {
           money_ = Integer.parseInt(args[0]);
           penguins_ = Integer.parseInt(args[1]); 
           tigers_ = Integer.parseInt(args[2]); 
           turtles_ = Integer.parseInt(args[3]); 
        } catch(IllegalArgumentException e) {
           System.out.println("Illegal Arguments.");
        }  
       
       Zoo z = new Zoo(money_, penguins_, tigers_, turtles_); 
       System.out.println("Zoo initialized...");
       int i = 0;
       
       while(z.is_solvent() && i < 50)
       {
           Random r = new Random();
           Text_IO.print_block(z.increment_day());
           Text_IO.print_block(z.deduct_all_feeding_costs());
           Text_IO.print_block(z.accrue_payoffs());
           int choice = r.nextInt(3) + 1;
           switch(choice)
           {
               case 1: 
               {
               Text_IO.print_block(z.kill_random());
               break;
               }
               case 2:
               {
                Text_IO.print_block(z.random_birth());  
                break;
               }
               case 3:
               {
               Text_IO.print_block(z.boom());
               break;
               }
               default: break;
            }
           System.out.println();
           i++;
           Text_IO.print_block(z.daily_status());
       }
       System.out.println("End simulation.");
       System.out.println("Zoo remained solvent: " + Boolean.toString(z.is_solvent()));  
       System.out.println("***************");
    }
    
    
}
