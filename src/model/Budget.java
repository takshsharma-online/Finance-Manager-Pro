package model;

public class Budget {//The main goal of this class is to allow user to create a budget.
    private int id;//Attribute for id.
    private String category;//Attribute for category.
    private double monthlyLimit;//Attribute for monthly limit.
    private Currency currency;//Attribute for currency.
    //Following is a Constructor.
    public Budget(int id, String category, double monthlyLimit, Currency currency){
        this.id = id;
        this.category = category;
        this.monthlyLimit = monthlyLimit;
        this.currency = currency;
    }
    //Following are the Getters.
    public int getId(){//This is a getter for id.
        return id;
    }
    public String getCategory(){//This is a getter for category.
        return category;
    }
    public double getMonthlyLimit(){//This is a getter for monthly limit.
        return monthlyLimit;
    }
    public Currency getCurrency(){//This is a getter for currency.
        return currency;
    }
    //Following are the Setters.
    public void setId(int id){//This is a setter for id.
        this.id = id;
    }
    public void setCategory(String category){//This is a setter for category.
        this.category = category;
    }
    public void setMonthlyLimit(double monthlyLimit){//This is a setter for monthly limit.
        this.monthlyLimit = monthlyLimit;
    }
    public void setCurrency(Currency currency){//This is a setter for currency.
        this.currency = currency;
    }
    //Following is an Overridden toString() method.
    public String toString(){
        return "Budget: ID: " + id + " Category: " + category + " Monthly Limit: " + monthlyLimit + " Currency: " + currency;
    }

}
