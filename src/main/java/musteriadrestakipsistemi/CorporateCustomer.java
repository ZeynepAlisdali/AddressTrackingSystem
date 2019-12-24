package musteriadrestakipsistemi;


public class CorporateCustomer extends Customer {

    public String taxNumber;

    public CorporateCustomer() {
        super(0);
    }
    
    
    
    public CorporateCustomer(int id) {
        super(id);
        
    }
    
    
    public CorporateCustomer(int id, String CustomerName) {
        super(id,CustomerName);
        
    }
    
    
   /**ask if we use two parameter*/    
   /* 
    public String gettaxNumber() 
    {
        return taxNumber;
    }

    public void settaxNumber(String taxNumber) 
    {
        this.taxNumber = taxNumber;
    }
    */
    @Override
    public void printCurrentCustomerInfo()
    {
        System.out.println("-------Customer Information:----------");
        System.out.println("CustomerId : " + this.id + ", Customer Name : " + this.customerName + ", TaxNumber : " + this.taxNumber);
        System.out.println("-------Customer Information:----------");
    }
}