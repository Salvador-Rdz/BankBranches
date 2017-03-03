    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankbranches;
import java.util.*;
/**
 *
 * @author Salvador
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    //Constructor
    public Customer(String id, double inTrans) //Initializes the customer with a given name and a transaction
    {
        this.name = id;
        this.transactions=new ArrayList();
        this.transactions.add(inTrans);
    }
    //Getter
    public String getId() {
        return name;
    }
    //Methods
    public boolean addTransaction(double trans) //Adds a transaction to the list of transactions.
    {
        this.transactions.add(trans);
        return true;
    }
    @Override
    public String toString()    //Returns a formatted string with the info saved in the class.
    {
        String trans="";
        for(Double tempTrans : transactions)
        {
            trans+=tempTrans.toString()+" | ";
        }
        return name+" Transactions: "+trans;
    }
}
