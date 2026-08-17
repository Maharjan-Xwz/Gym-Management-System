//RegularMember is a subclass of GymMember
public class RegularMember extends GymMember{
    
    //six privated access modifier
    private final int attendanceLimit; // final is used to put the attendance to remain constants
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //construcutor parameterized method
    public RegularMember(
    int id,
    String name,
    String location,
    String phone,
    String email,
    String gender,
    String DOB,
    String membershipStartDate,
    String referralSource){
        //invoke towards parentclass by using superkeyword
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        
        //values are given accordingly
        this.isEligibleForUpgrade = false;
        this.attendanceLimit = 30;
        this.plan ="Basic";
        this.price = 6500.0;
        this.removalReason = "";
        this.referralSource = referralSource;
        
    }
    
    //corresponding accessor method 
    public int getAttendanceLimit(){
        return this.attendanceLimit;
    }
    
    public boolean getIsEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }
    
    public String getRemovalReason(){
        return this.removalReason;
    }
    
    public String getReferralSource(){
        return this.referralSource;
    }
     
    public String getPlan(){
        return this.plan;
    }
     
    public double getPrice(){
        return this.price;
    }
    
    //Implementation of abstract method
    @Override 
    public void markAttendance(){
        // increatment by 1 and loyality increased by 5 points
            attendance++;
            loyaltyPoints += 5;
    }
    
    //a method to retrieve the price of the plan.
    // getplanPrice a new method
    public double getPlanPrice(String plan) {
        //applied switch statement
        switch(plan.toLowerCase()){
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }
    
    //a new method for upgrading the plan 
    public String upgradePlan(String plan){
           /*java buit-in method -> ".equalsIgnoreCase" which checks the provided string, and ignoring any upper or lower cases */
        // checking if plan is the same as current plan
        if(this.plan.equalsIgnoreCase(plan)) {
            return "Already Upgraded to "+ plan;
        }
        
        //checking if requested plan is valid and getting its price
        double newPlanPrice = getPlanPrice(plan); //updating according to by calling getPlanPrice()
        if(getPlanPrice(plan) == -1) {
            return "Invalid Plan. Please select Basic, Standard or Deluxe";
        }
        
        //determining if they are eligibile or not, based on attendance
        boolean isEligible = getAttendance() >= attendanceLimit;
        isEligibleForUpgrade = isEligible;
       
        if(isEligibleForUpgrade == false){
            return "Sorry, not eligible for an upgrade.";
        }
        //with the upgrade
        this.plan = plan;
        this.price = newPlanPrice;
        return "Plan Upgrade to "+ "\n" + plan + "with a price "+newPlanPrice;
    }
    
    public void revertRegularMember(String removalReason){
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500.0;
        this.removalReason = removalReason;
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println("Plan: "+ plan +"\nPrice: "+ price);
        if(removalReason != null && removalReason.isEmpty() == false){
            System.out.println("Removal Reason: "+ removalReason);
        }
    }
}

