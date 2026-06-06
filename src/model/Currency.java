package model;
/*Following are the supported Currencies
* INR = Indian Rupee
* GBP = British Pound
* USD = US Dollar
* EUR = Euro*/
public enum Currency {
    INR("Indian Rupee" , "₹"),
    GBP("British Pound" , "£"),
    USD("US Dollar" , "$"),
    EUR("Euro", "€");
    private final  String name;//Attribute for currency name.
    private final String symbol;//Attribute for currency symbol.
    //Following is a constructor.
    Currency(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    //Following is a getter for name.
    public String getName(){
        return name;
    }
    //Following is a getter for symbol.
    public String getSymbol(){
        return symbol;
    }
}
