package model;
public class Transaction {
    private int id;//Attribute for id.
    private String date;//Attribute for transaction date.
    private String type;//Attribute for type. (Determining whether it is an income or an expense)
    private String category;//Attribute for categories such as rent, food, utilities, etc.
    private double amount;//Attribute for the money value.
    private String description;//Attribute for any optional notes.
    //Following is a Constructor.
    public Transaction(int id, String date, String type, String category, double amount, String description){
        this.id = id;
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
    //Following are the Getters for all the attributes.
    public int getId(){//Getter for id.
        return id;
    }
    public String getDate(){//Getter for date.
        return date;
    }
    public String getType(){//Getter for type.
        return type;
    }
    public String getCategory(){//Getter for category.
        return category;
    }
    public double getAmount(){//Getter for amount.
        return amount;
    }
    public String getDescription(){//Getter for description.
        return  description;
    }
    //Following are all the Setters.
    public void setId(int id){//Setter for id.
        this.id = id;
    }
    public void setDate(String date){//Setter for date.
        this.date = date;
    }
    public void setType(String type){//Setter for type.
        this.type = type;
    }
    public void setCategory(String category){//Setter for category.
        this.category = category;
    }
    public void setAmount(double amount){//Setter for amount.
        this.amount = amount;
    }
    public void setDescription(String description){//Setter for description.
        this.description = description;
    }
    //Following is an Overridden toString method.
    @Override
    public String toString(){
        return "Transaction Details: ID: " + id + "Date: " + date + " Type: " + type + " Category: " + category + " Amount: " + amount + " Description: " + description ;
    }


}
