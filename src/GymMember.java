//class GymMember is an abstract class and also parent class.
public abstract class GymMember{
    
    //attributes with respestive data types and with protected access modifier
    protected int id;
    protected int attendance;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    // constructor accepting the following parameters
    public GymMember(
    int id, 
    String name, 
    String location, 
    String phone, 
    String email, 
    String gender, 
    String DOB, 
    String membershipStartDate){
        
        //assigning the parameter values.
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;     
        }
    
    //corresponding accessor method for each attributive 
    public int getId(){
        return this.id;
    }
     public int getAttendance(){
        return this.attendance;
    }
     public String getName(){
        return this.name;
    }
     public String getLocation(){
        return this.location;
    }
     public String getPhone(){
        return this.phone;
    }
     public String getEmail(){
        return this.email;
    }
     public String getGender(){
        return this.gender;
    }
     public String getDOB(){
        return this.DOB;
    }
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return this.activeStatus;
    }
    
    /* an abstract method, basically, this method doesn't have body because, 
     first of all, Java have not given permission to create an object of abstract class, 
     so without object, the method can't be invoked or perform opertaion*/
    
    public abstract void markAttendance();
    
    // creating method for activemembers + deactivemembers
    // a method to activate the activestatus of the members
    public void activateMembership(){
        this.activeStatus = true;
    }
    
    //a method with return type String to deactivate members
    public String deactivateMembership(){
        
        if(!this.activeStatus){ //if activestatus is false, the (logical not) makes it true
            return "Cannot be deactivated"; //because membership is already inactive.
        }
            this.activeStatus = false;
            return "Deactivated Successfull"; // deactivation completed.  
     }
     
     //a method to resetmember
    public void resetMember(){
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }
    
    public void display(){
        System.out.println("ID = "+ id +"\n" +
        "Name: "+ name + "\n" +
        "Location: " + location + "\n" +
        "Phone no: " + phone + "\n" +
        "Email: "+ email + "\n" +
        "Gender: "+ gender + "\n" +
        "DOB: " + DOB + "\n" +
        "MembershipStartDate: "+ membershipStartDate + "\n" +
        "Attendace: " + attendance + "\n" +
        "Loyaltypoints: " +loyaltyPoints+ "\n" +
        "Activestatus: " + activeStatus+"\n" );
    }
}
 