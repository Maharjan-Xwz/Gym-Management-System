public class PremiumMember extends GymMember{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructor
    public PremiumMember(int id,
    String name,
    String location,
    String phone,
    String email,
    String gender,
    String DOB,
    String membershipStartDate,
    String personalTrainer){
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.paidAmount = 0;
        this.isFullPayment = false;
        this.discountAmount = 0;
        this.personalTrainer = personalTrainer;
    }
    
    //accessor method of the attribute
    public double getPremiumCharge(){
        return this.premiumCharge;
    }
       public String getPersonalTrainer(){
        return this.personalTrainer;
    }
       public boolean getIsFullPayment(){
        return this.isFullPayment;
    }
       public double getPaidAmount(){
        return this.paidAmount;
    }
       public double getDiscountAmount(){
        return this.discountAmount;
    }
    
    // a method to pay the due amount
   
    public String payDueAmount(double paidAmount){
        //isfullpayment == true, then amount less than 50, returns your payment is already full, without showing remaining amount
        if(isFullPayment== true){
            return "Your Payment is already Full";
        }
        // adding new payment to paid amount
        this.paidAmount += paidAmount;
        
        if(paidAmount  > premiumCharge){
            return "total paid amount is more the required charge: ";
        }
        
        if(this.paidAmount == premiumCharge){
                isFullPayment = true;
                return "Payment successful! Your full payment is completed.";
        } 
        // this.paidAmount gives result no remaining.only 50000
        double remainingAmount = premiumCharge - paidAmount;
        return "remaining is : "+ remainingAmount;
            
        }
    
        // discount method
    public void calculateDiscount(){
        if(isFullPayment){
            discountAmount = 0.1* premiumCharge;
            System.out.println("discounted 10%: $"+ discountAmount);
        } else {
            discountAmount = 0.0;
            System.out.println("no discount");
        }
    }
    
    //method to call resetmethod from superclass
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }
    
    //method to display //method overriding 
    @Override
    public void display(){
        super.display();
        System.out.println("Personal Trainer: "+ personalTrainer);
        System.out.println("Paid Amount: "+ paidAmount);
        System.out.println("Full Payment: "+ isFullPayment);
        
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining: "+ remainingAmount);
        
        if (isFullPayment){
            System.out.println("Discount" + discountAmount);
        } else {
            System.out.println("No Discount" + discountAmount);
        }
    }
    
    //method markattendance overriding 
    @Override 
       public void markAttendance(){
           attendance ++;
           loyaltyPoints += 10;
        }
}
