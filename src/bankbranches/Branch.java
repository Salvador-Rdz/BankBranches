/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankbranches;

import java.util.ArrayList;

/**
 *
 * @author Salvador
 */
public class Branch {
    private String name;    //Name of the branch
    private ArrayList <Customer> customers; //Arraylist where the customers and their respective info will be located
    //Three constructors, one that defaults only to branch name, and two others that add a customer when created.
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList();
    }
    public Branch(String brName, Customer customer)
    {
        this.name=brName;
        this.customers = new ArrayList();
        this.customers.add(customer);
    }
    public Branch(String brName, String cName, double inTrans)
    {
        this.name=brName;
        this.customers = new ArrayList();
        this.customers.add(new Customer(cName, inTrans));
    }
    //Getters
    public String getName() 
    {
        return name;
    }
    //Methods
    public boolean addCustomer(String id, double inTrans)   //Receives the information necessary to initialize a customer
    {
        if(findCustomer(id)==-1)    //Uses the method findcustomer to check for duplicates
        {   
            this.customers.add(new Customer(id, inTrans));  //Adds the new customer to the arraylist if not found
            return true;
        }
        return false;
    }
    public boolean addTransaction(String id, double trans)  //Receives the information necessary to find and add a transaction to a customer
    {
        int index=findCustomer(id); //Gets the index from findcustomer
        if(index!=-1)               //if it returns a value from within the list
        {
            this.customers.get(index).addTransaction(trans);    //It adds the transaction to the customer using the method defined in that class.
            return true;
        }
        return false;
    }
    public int findCustomer(String id)  //Finds a customer with a given id (in this case, its name), and returns its index in the list
    {
        for(int i=0; i < customers.size(); i++) //
        {
            if(customers.get(i).getId().equals(id)) //Compares the identifiers
            {
                return i;   //Returns the index
            }
        }
        return -1;  //Returns -1, which is a value an arraylist will never have, serving as a "false"
    }   
    @Override
    public String toString()    //Turns the data into a String, which can be printed.
    {
        String trans="";
        for(Customer tempCustomer : customers)  //Iterates the list to get the String of each customer
        {
            trans+=tempCustomer.toString()+" // ";  //Formats
        }
        return name+" Customers and Transactions: "+trans;  //Prints
    }                                                                      
}
