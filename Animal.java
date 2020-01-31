
import java.util.*;
public class Animal
{
    /*Not to be overloaded...
     * STATIC: belongs to class: we do not need an instance to 
     * access this member.
     */
    public static final int base_food_cost = 10;
    
    /*Must be overloaded...*/
    protected static int cost = 0;
    protected int age = 1;
    protected int num_babies = 0;
    protected double feed_multiplier = 0;
    protected double payoff_multiplier = 0;
    protected Species type = Species.ANIMAL;
    
    public static int get_cost(){   //tb overloaded
        return cost;   
    }
    
    public int get_base_food_cost()
    {
        return base_food_cost;
    }
    
    public int get_age()
    {
        return age;
    }
    
    public int increment_age()
    {
        return ++age;
    }
    
    public void reset_age()
    {
        this.age = 0;
    }
    
    public boolean is_adult()
    {
        if (age > 2) {return true;} else return false;
    }
    
    public int get_num_babies()
    {
        return num_babies;
    }
    
    public int get_feeding_cost()
    {
        return (int) (base_food_cost * feed_multiplier);
    }
    
    public int get_payoff(){
        return (int) (cost * payoff_multiplier);
    }
    
    public Species what_am_i(){
        return type;
    }
    
    public ArrayList<Animal> give_birth(){
        ArrayList<Animal> litter = new ArrayList<Animal>();
        switch(type)
        {
            case ANIMAL: break; //error!
            case TIGER: {
                for(int i = 0; i < num_babies; i++){
                    litter.add(new Tiger());
                }
                break;
            }
            case TURTLE: {
                for(int i = 0; i < num_babies; i++){
                    litter.add(new Turtle());
                }
                break;
            }
            case PENGUIN: {
                for(int i = 0; i < num_babies; i++){
                    litter.add(new Penguin());
                }
                break;
            }
        }
        return litter;
    }
}
