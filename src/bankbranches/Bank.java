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
public class Bank {
    private ArrayList<Branch> branches;
    private String name;
    //Constructors
    public Bank(String name) // Defines the name, but only initializes the Arraylist
    {
        this.name=name;
        this.branches = new ArrayList();
    }
    public Bank(String name, String brName, String customer, double inTrans) //Defines the name, and adds a branch, customer and initial transaction
    {
        this.name = name;
        this.branches = new ArrayList();
        this.branches.add(new Branch(brName, customer, inTrans)); //Uses the constructor in the Branch class
    }
    //Methods
    public boolean addBranch(String name) //Adds a new branch, without creating a customer
    {
        if(findBranch(name)==-1) //Checks for duplicates
        {
            this.branches.add(new Branch(name));    //Adds it to the list
            return true;
        }
        return false;
    }
    public boolean addBranch(String name, String customer, double inTrans) //Adds a new branch, creating a customer
    {
        if(findBranch(name)==-1) //Checks for duplicates
        {
            this.branches.add(new Branch(name, customer, inTrans)); //Adds both to the lists
            return true;
        }
        return false;
    }
    public boolean addCustomer(String brName, String customer, double inTrans) //Adds a customer to a specified branch
    {
        int brIndex = findBranch(brName); //Gets the index of the branch
        if(brIndex!=-1)
        {
            this.branches.get(brIndex).addCustomer(customer, inTrans); //Adds it to the list
            return true;
        }
        return false;
    }
    public boolean addTransaction(String brName, String cName, double trans) //Adds a transaction to a specified customer.
    {
        int brIndex = findBranch(brName);
        if(brIndex!=-1)
        {
            this.branches.get(brIndex).addTransaction(cName, trans); //Uses the method addTransaction from the customer class.
            return true;
        }
        return false;
    }
    public String getBranchCustomers(String brName) //Returns a String of branch customers
    {
        int index = findBranch(brName);
        return this.branches.get(index).toString(); //Uses the method toString from the branch class.
    }
    public int findBranch(String name) //Returns the index of a given branch
    {
        for(int i=0; i<branches.size();i++)
        {
            if(name.equals(branches.get(i).getName()))
            {
                return i; //Returns the index
            }
        }
        return -1; //Returns -1 if not found.
    }
}
