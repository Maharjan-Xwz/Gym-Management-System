
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

//calling swing class
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//calling awt class
import java.awt.Font;
public class GymGUI implements ActionListener{
    
    private String id,name, location, phone, email, gender, dob, membershipStartDate, referralSource ;
            
    private JFrame frame;
    
    private JPanel Main_Panel, side_Panel, premium_Panel, attendancePanel;
    
    private JLabel welcome, ID, Name, Location, Phone, Email, Gender, DOB,
    Membership_Start_Date, Referral_Source, Removal_Reason,
    Trainer$s_name, Paid_Amount,Plan,regular_Plan_Price,Discount;
    
    private JLabel Intro;
    
    private ButtonGroup group;
    private JRadioButton gender_radio_male, gender_radio_female;
    
    private JComboBox<String> membership_date_year;
    private JComboBox<String> membership_date_month;
    private JComboBox<String> membership_date_day; 
    private JComboBox<String> dob_Date_Year;
    private JComboBox<String> dob_Date_Month;
    private JComboBox<String> dob_Date_Day;
    private JComboBox<String> plan_combo;
    private JComboBox<String> price_combo;
    
    private JButton regular_btn,premium_btn,membership_btn,deactivate_btn,
    mark_btn,revert_btn,display_btn,clear_btn,regular_done_btn, premium_done_btn;
    
    private JTextField id_Text_Field, name_Text_Field, location_Text_Field, phone_Text_Field, email_Text_Field,
    referral_Source_Text_Field, removal_Reason_Text_Field,
    Trainer$s_name_Text_Field, paid_Amount_Text_Field, discount_Text_Field;
    
    //Premium//
    private JLabel premium_Membership_Start_Date;
    private ButtonGroup premium_group;
    private JRadioButton premium_gender_radio_male, premium_gender_radio_female;
    
    private JComboBox<String> premium_membership_date_year;
    private JComboBox<String>premium_membership_date_month;
    private JComboBox<String>premium_membership_date_day;
    private JComboBox<String>premium_dob_Date_Year;
    private JComboBox<String>premium_dob_Date_Month;
    private JComboBox<String>premium_dob_Date_Day;
    private JComboBox<String>premium_plan_combo;
    private JComboBox<String>premium_price_combo;
    
    
    private JTextField premium_id_Text_Field, premium_name_Text_Field, premium_location_Text_Field, 
    premium_phone_Text_Field, premium_email_Text_Field,
    premium_referral_Source_Text_Field, premium_removal_Reason_Text_Field,
    premium_Trainer$s_name_Text_Field, premium_paid_Amount_Text_Field, premium_discount_Text_Field
    ;
    // attendace
    private JLabel attendanceMemberId;
    private JTextField attendanceIdTextField;
    private JButton attendanceSubmitBtn;
    
    private ArrayList<GymMember> members;
    
    public GymGUI(){
        
        
        //arraylist 
        members = new ArrayList<>();
         
            //working on frame
        frame = new JFrame("GymGUI");
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100,600);
        
        //working on Main panel
        Main_Panel= new JPanel();
        Main_Panel.setLayout(null);
        Main_Panel.setBackground(new Color(230,240,255));
        Main_Panel.setBounds(250, 0, 1100, 600);
        Main_Panel.setVisible(false); // to hide the panel 
        
        //working on side panel
        side_Panel = new JPanel();
        side_Panel.setLayout(null);
        side_Panel.setBackground(new Color(48,48,48));
        side_Panel.setBounds(0, 0, 250, 600);
        
        // for premium
        premium_Panel= new JPanel();
        premium_Panel.setLayout(null);
        premium_Panel.setBackground(new Color(230,240,255));
        premium_Panel.setBounds(250, 0, 1100, 600);
        premium_Panel.setVisible(false); // to hide the panel and by event handling making visible
        
        attendancePanel = new JPanel();
        attendancePanel.setLayout(null);
        attendancePanel.setBackground(new Color(85,119,79));
        attendancePanel.setBounds(0, 0, 1100, 600);
        attendancePanel.setVisible(false);

        
        //working on regular button
        regular_btn = new JButton("Regular Member");
        regular_btn.setBounds(20,30,190,50);
        side_Panel.add(regular_btn);
        regular_btn.addActionListener(this);
        
        //working on premium button
        premium_btn = new JButton("Premium Member");
        premium_btn.setBounds(20,90,190,50);
        side_Panel.add(premium_btn);
        premium_btn.addActionListener(this);
        
        //working on button
        membership_btn = new JButton("Membership Activation");
        membership_btn.setBounds(20,150,190,50);
        side_Panel.add(membership_btn);
        membership_btn.addActionListener(this);
        
        //working on button
        deactivate_btn = new JButton("Membership Deactivation");
        deactivate_btn.setBounds(20,210,190,50);
        side_Panel.add(deactivate_btn);
        deactivate_btn.addActionListener(this);
        
        //working on button
        mark_btn = new JButton("Attendance");
        mark_btn.setBounds(20,270,190,50);
        side_Panel.add(mark_btn);
        mark_btn.addActionListener(this);
        
        //working on button
        revert_btn = new JButton("Member Revert");
        revert_btn.setBounds(20,330,190,50);
        side_Panel.add(revert_btn);
        revert_btn.addActionListener(this);
        
        //working on button
        display_btn = new JButton("Display");
        display_btn.setBounds(20,390,190,50);
        side_Panel.add(display_btn);
        display_btn.addActionListener(this);
        
        //working on button
        clear_btn = new JButton("Clear");
        clear_btn.setBounds(20,450,190,50);
        side_Panel.add(clear_btn);
        clear_btn.addActionListener(this);
        
        welcome = new JLabel("Welcome to My GYM");
        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        welcome.setBounds(350, 200, 400, 50);
        frame.add(welcome);
        
        //////-----------------------------------Regular GUI-----------------------------//////
        Membership_Start_Date = new JLabel("Membership Start Date");
        Membership_Start_Date.setBounds(400,60,200,25);
        Membership_Start_Date.setFont(new Font("Arial",Font.BOLD, 17));
        Main_Panel.add(Membership_Start_Date);
        
        //combox for membership date
        String[] date_year = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
        membership_date_year = new JComboBox<>(date_year);
        membership_date_year.setBounds(600,60,60,25);
        Main_Panel.add(membership_date_year);
        
         //combox for membership date
        String[] date_month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        membership_date_month = new JComboBox<>(date_month);
        membership_date_month.setBounds(670,60,60,25);
        Main_Panel.add(membership_date_month);
        
        
         //combox for membership date
        String[] date_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        membership_date_day = new JComboBox<>(date_day);
        membership_date_day.setBounds(740,60,60,25);
        Main_Panel.add(membership_date_day);
                
        
        // working on ID
        ID = new JLabel("ID");
        ID.setBounds(10,60,24,25);
        ID.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(ID);
        //Textfield
        id_Text_Field = new JTextField();
        id_Text_Field.setBounds(35,60,90,25);
        Main_Panel.add(id_Text_Field);
                
        
        // working on name
        Name = new JLabel("Name:");
        Name.setBounds(10,130,120,25);
        Name.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Name);
        //Textfield
        name_Text_Field = new JTextField();
        name_Text_Field.setBounds(80,130,150,25);
        Main_Panel.add(name_Text_Field);
        
        
        // working on phone // 
        Phone = new JLabel("Phone:");
        Phone.setBounds(500,130,120,25);
        Phone.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Phone);
        //Textfield
        phone_Text_Field = new JTextField();
        phone_Text_Field.setBounds(580,130,180,25);
        Main_Panel.add(phone_Text_Field);        
        
        
        // working on Location
        Location = new JLabel("Location:");
        Location.setBounds(10,180,120,25);
        Location.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Location);
        //Textfield
        location_Text_Field = new JTextField();
        location_Text_Field.setBounds(110,180,170,25);
        Main_Panel.add(location_Text_Field);
        
        // working on Email // baki 
        Email = new JLabel("Email:");
        Email.setBounds(500,180,120,25);
        Email.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Email);
        //Textfield
        email_Text_Field = new JTextField();
        email_Text_Field.setBounds(580,180,200,25);
        Main_Panel.add(email_Text_Field);    
        
        // working on Gender
        Gender = new JLabel("Gender:");
        Gender.setBounds(10,230,80,25);
        Gender.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Gender);
        
        //Male radio button
        gender_radio_male = new JRadioButton("Male");
        gender_radio_male.setFont(new Font("Arial",Font.BOLD, 20));
        gender_radio_male.setBounds(90,230,80,20);
        Main_Panel.add(gender_radio_male);
        //female radio button
        gender_radio_female = new JRadioButton("Female");
        gender_radio_female.setFont(new Font("Arial",Font.BOLD, 20));
        gender_radio_female.setBounds(190,230,100,20);
        Main_Panel.add(gender_radio_female);
        
        //creating a group so that it can select one at a time
        group = new ButtonGroup();
        group.add(gender_radio_male);
        group.add(gender_radio_female);
        
        // working on DOB  //baki
        DOB = new JLabel("DOB:");
        DOB.setBounds(500,230,120,25);
        DOB.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(DOB);
        
        //combox for membership date
        String[] born_year = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
        dob_Date_Year = new JComboBox<>(born_year);
        dob_Date_Year.setBounds(560,230,70,25);
        Main_Panel.add(dob_Date_Year);
        
         //combox for membership date
        String[] born_month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        dob_Date_Month = new JComboBox<>(date_month);
        dob_Date_Month.setBounds(640,230,70,25);
        Main_Panel.add(dob_Date_Month);
        
        
         //combox for membership date
        String[] born_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        dob_Date_Day = new JComboBox<>(born_day);
        dob_Date_Day.setBounds(720,230,70,25);
        Main_Panel.add(dob_Date_Day);
        
        // working on Referral Source
        Referral_Source = new JLabel("Referral Source:");
        Referral_Source.setBounds(10,280,190,25);
        Referral_Source.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Referral_Source);
        
        referral_Source_Text_Field = new JTextField();
        referral_Source_Text_Field.setBounds(180,280,170,25);
        Main_Panel.add(referral_Source_Text_Field);  
        
        // working on Removal Reason
        Removal_Reason = new JLabel("Removal Reason:");
        Removal_Reason.setBounds(500,280,190,25);
        Removal_Reason.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Removal_Reason);
        
        removal_Reason_Text_Field = new JTextField();
        removal_Reason_Text_Field.setBounds(670,280,150,25);
        Main_Panel.add(removal_Reason_Text_Field); 
        
        
        //-----------------------seperate plan next-stage-----//
        //working on regular plan
        Plan = new JLabel("Plan:");
        Plan.setBounds(10,330,60,25);
        Plan.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Plan);
        
        //combox for membership date
        String[] plan_ = {"Basic","Standard","Deluxe"};
        plan_combo = new JComboBox<>(plan_);
        plan_combo.setBounds(70,330,120,25);
        Main_Panel.add(plan_combo);
        
        //working on regular plan price
        regular_Plan_Price = new JLabel("Plan Price:");
        regular_Plan_Price.setBounds(220,330,140,25);
        regular_Plan_Price.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(regular_Plan_Price);
        
        //regular plan price combo
        String[] plan_Price = {"6500","12500","18500"};
        price_combo = new JComboBox<String>(plan_Price);
        price_combo.setBounds(340,330,120,25);
        Main_Panel.add(price_combo);
        
        //working on regular trainer amount
        Trainer$s_name = new JLabel("Trainer's Name:");
        Trainer$s_name.setBounds(470,330,200,25);
        Trainer$s_name.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Trainer$s_name);
        
        //text field of trainer amount
        Trainer$s_name_Text_Field = new JTextField();
        Trainer$s_name_Text_Field.setBounds(650,330,160,25);
        Main_Panel.add(Trainer$s_name_Text_Field);
        
        //working on paid amount
        Paid_Amount = new JLabel("Paid Amount:");
        Paid_Amount.setBounds(470,390,170,25);
        Paid_Amount.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Paid_Amount);
        
        //text field of trainer amount
        paid_Amount_Text_Field = new JTextField();
        paid_Amount_Text_Field.setBounds(610,390,150,25);
        Main_Panel.add(paid_Amount_Text_Field);
        
        //working on discount
        Discount = new JLabel("Discount:");
        Discount.setBounds(470,450,170,25);
        Discount.setFont(new Font("Arial",Font.BOLD, 20));
        Main_Panel.add(Discount);
        
        //text field of discount amount
        discount_Text_Field = new JTextField("1200");
        discount_Text_Field.setBounds(580,450,150,25);
        discount_Text_Field.setEditable(false);
        Main_Panel.add(discount_Text_Field);
        
        
        //working on button done
        regular_done_btn = new JButton("Done");
        regular_done_btn.setFont(new Font("Arial",Font.BOLD, 20));
        regular_done_btn.setBounds(250,490,200,50);
        Main_Panel.add(regular_done_btn);
        regular_done_btn.addActionListener(this);
        
                 //-------------------------input values insertion to arraylist------/////   
        
        
        
        
        
        ////-------------------premium GUI-------------------////
        //working on membershipdate
        Membership_Start_Date = new JLabel("Membership Start Date");
        Membership_Start_Date.setBounds(400,60,200,25);
        Membership_Start_Date.setFont(new Font("Arial",Font.BOLD, 17));
        premium_Panel.add(Membership_Start_Date);
        
        //combox for membership date
        String[] premium_date_year = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
        premium_membership_date_year = new JComboBox<>(premium_date_year);
        premium_membership_date_year.setBounds(600,60,60,25);
        premium_Panel.add(premium_membership_date_year);
        
         //combox for membership date
        String[] premium_date_month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        premium_membership_date_month = new JComboBox<>(premium_date_month);
        premium_membership_date_month.setBounds(670,60,60,25);
        premium_Panel.add(premium_membership_date_month);
        
        
         //combox for membership date
        String[] premium_date_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        premium_membership_date_day = new JComboBox<>(premium_date_day);
        premium_membership_date_day.setBounds(740,60,60,25);
        premium_Panel.add(premium_membership_date_day);
        
        
        
        
        // working on ID
        ID = new JLabel("ID");
        ID.setBounds(10,60,24,25);
        ID.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(ID);
        //Textfield
        premium_id_Text_Field = new JTextField();
        premium_id_Text_Field.setBounds(35,60,90,25);
        premium_Panel.add(premium_id_Text_Field);
                
        
        // working on name
        Name = new JLabel("Name:");
        Name.setBounds(10,130,120,25);
        Name.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Name);
        //Textfield
        premium_name_Text_Field = new JTextField();
        premium_name_Text_Field.setBounds(80,130,150,25);
        premium_Panel.add(premium_name_Text_Field);
        
        
        // working on phone // 
        Phone = new JLabel("Phone:");
        Phone.setBounds(500,130,120,25);
        Phone.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Phone);
        //Textfield
        premium_phone_Text_Field = new JTextField();
        premium_phone_Text_Field.setBounds(580,130,180,25);
        premium_Panel.add(premium_phone_Text_Field);        
        
        
        // working on Location
        Location = new JLabel("Location:");
        Location.setBounds(10,180,120,25);
        Location.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Location);
        //Textfield
        premium_location_Text_Field = new JTextField();
        premium_location_Text_Field.setBounds(110,180,170,25);
        premium_Panel.add(premium_location_Text_Field);
        
        // working on Email // baki 
        Email = new JLabel("Email:");
        Email.setBounds(500,180,120,25);
        Email.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Email);
        //Textfield
        premium_email_Text_Field = new JTextField();
        premium_email_Text_Field.setBounds(580,180,200,25);
        premium_Panel.add(premium_email_Text_Field);    
        
        // working on Gender
        Gender = new JLabel("Gender:");
        Gender.setBounds(10,230,80,25);
        Gender.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Gender);
        
        //Male radio button
        premium_gender_radio_male = new JRadioButton("Male");
        premium_gender_radio_male.setFont(new Font("Arial",Font.BOLD, 20));
        premium_gender_radio_male.setBounds(90,230,80,20);
        premium_Panel.add(premium_gender_radio_male);
        //female radio button
        premium_gender_radio_female = new JRadioButton("Female");
        premium_gender_radio_female.setFont(new Font("Arial",Font.BOLD, 20));
        premium_gender_radio_female.setBounds(190,230,100,20);
        premium_Panel.add(premium_gender_radio_female);
        
        //creating a group so that it can select one at a time
        premium_group = new ButtonGroup();
        premium_group.add(premium_gender_radio_male);
        premium_group.add(premium_gender_radio_female);
        
        // working on DOB  
        DOB = new JLabel("DOB:");
        DOB.setBounds(500,230,120,25);
        DOB.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(DOB);
        
        //combox for membership date
        String[] premium_born_year = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
        premium_dob_Date_Year = new JComboBox<>(premium_born_year);
        premium_dob_Date_Year.setBounds(560,230,70,25);
        premium_Panel.add(premium_dob_Date_Year);
        
         //combox for membership date
        String[] premium_born_month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        premium_dob_Date_Month = new JComboBox<>(premium_date_month);
        premium_dob_Date_Month.setBounds(640,230,70,25);
        premium_Panel.add(premium_dob_Date_Month);
        
        
         //combox for membership date
        String[] premium_born_day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        premium_dob_Date_Day = new JComboBox<>(premium_born_day);
        premium_dob_Date_Day.setBounds(720,230,70,25);
        premium_Panel.add(premium_dob_Date_Day);
        
        // working on Referral Source
        Referral_Source = new JLabel("Referral Source:");
        Referral_Source.setBounds(10,280,190,25);
        Referral_Source.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Referral_Source);
        
        premium_referral_Source_Text_Field = new JTextField();
        premium_referral_Source_Text_Field.setBounds(180,280,170,25);
        premium_Panel.add(premium_referral_Source_Text_Field);  
        
        // working on Removal Reason
        Removal_Reason = new JLabel("Removal Reason:");
        Removal_Reason.setBounds(500,280,190,25);
        Removal_Reason.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Removal_Reason);
        
        premium_removal_Reason_Text_Field = new JTextField();
        premium_removal_Reason_Text_Field.setBounds(670,280,150,25);
        premium_Panel.add(premium_removal_Reason_Text_Field); 
        
        //-----------------------seperate plan next-stage-----//
        //working on regular plan
        Plan = new JLabel("Plan:");
        Plan.setBounds(10,330,60,25);
        Plan.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Plan);
        
        //combox for membership date
        JTextField premium_plan = new JTextField("Premium");
        premium_plan.setBounds(70,330,120,25);
        premium_plan.setEditable(false);
        premium_Panel.add(premium_plan);

        
        //working on regular plan price
        regular_Plan_Price = new JLabel("Plan Price:");
        regular_Plan_Price.setBounds(220,330,140,25);
        regular_Plan_Price.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(regular_Plan_Price);
        
        //regular plan price combo
        JTextField price_ = new JTextField("50,000");
        price_.setEditable(false);
        price_.setBounds(340,330,120,25);
        premium_Panel.add(price_);
        
        
        
        
          //working on regular trainer amount
        Trainer$s_name = new JLabel("Trainer's Name:");
        Trainer$s_name.setBounds(470,330,200,25);
        Trainer$s_name.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Trainer$s_name);
        
        //text field of trainer amount
        premium_Trainer$s_name_Text_Field = new JTextField();
        premium_Trainer$s_name_Text_Field.setBounds(650,330,160,25);
        premium_Panel.add(premium_Trainer$s_name_Text_Field);
        
        //working on paid amount
        Paid_Amount = new JLabel("Paid Amount:");
        Paid_Amount.setBounds(470,390,170,25);
        Paid_Amount.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Paid_Amount);
        
        //text field of trainer amount
        premium_paid_Amount_Text_Field = new JTextField();
        premium_paid_Amount_Text_Field.setBounds(610,390,150,25);
        premium_Panel.add(premium_paid_Amount_Text_Field);
        
        //working on discount
        Discount = new JLabel("Discount:");
        Discount.setBounds(470,450,170,25);
        Discount.setFont(new Font("Arial",Font.BOLD, 20));
        premium_Panel.add(Discount);
        
        //text field of discount amount
        premium_discount_Text_Field = new JTextField("1200");
        premium_discount_Text_Field.setBounds(580,450,150,25);
        premium_discount_Text_Field.setEditable(false);
        premium_Panel.add(premium_discount_Text_Field);
        
        
        //working on button done
        premium_done_btn = new JButton("Done");
        premium_done_btn.setFont(new Font("Arial",Font.BOLD, 20));
        premium_done_btn.setBounds(250,490,200,50);
        premium_Panel.add(premium_done_btn);
        premium_done_btn.addActionListener(this);
        
      
       
        // regular member button done
    
       
        
        frame.add(side_Panel);
        frame.add(Main_Panel);
        frame.add(premium_Panel);
        frame.add(attendancePanel);
        frame.setVisible(true);
    }
    
    
    
    private void activateRegular(){
         try{   
                // get the values from user
            String id = id_Text_Field.getText();
            String name = name_Text_Field.getText();
            String location = location_Text_Field.getText();
            String phone = phone_Text_Field.getText();
            String email = email_Text_Field.getText();
            String gender = gender_radio_male.isSelected() ? "Male" :
                            (gender_radio_female.isSelected() ? "Female" : "");
            String dob = dob_Date_Year.getSelectedItem() + "-" +
                         dob_Date_Month.getSelectedItem() + "-" +
                         dob_Date_Day.getSelectedItem();
            String membershipStartDate = membership_date_year.getSelectedItem() + "-" +
                                         membership_date_month.getSelectedItem() + "-" +
                                         membership_date_day.getSelectedItem();
            String referralSource = referral_Source_Text_Field.getText();
            String Trainer = Trainer$s_name.getText();
            String Paid_Amt = paid_Amount_Text_Field.getText();
            String Removal_Reason = removal_Reason_Text_Field.getText();
            
            // converting id from string to integer by using parse which means a wrapper class
            int id$ = Integer.parseInt(id);
            
             for (GymMember member : members) {
                if (member.getId() == id$) {
                    JOptionPane.showMessageDialog(null, "Member ID already exists.");
                    return;
                }
            }
            
            // creating an object of an arraylist for regular member
            RegularMember regular_new_members = new RegularMember(id$,name,location, phone,email,gender,
            dob,membershipStartDate, referralSource);
            
            //adding value to arraylist
            members.add(regular_new_members);
            
            JOptionPane.showMessageDialog(frame, "Submission Successful!",
            "Success", JOptionPane.INFORMATION_MESSAGE);
            
            
            //after sucessful, clearing all the input fields 
            id_Text_Field.setText("") ;
            name_Text_Field.setText("");
            location_Text_Field.setText("");
            email_Text_Field.setText("");
            phone_Text_Field.setText("");
            gender_radio_male.setSelected(false);
            gender_radio_female.setSelected(false);
            dob_Date_Year.setSelectedItem("1990");
            dob_Date_Month.setSelectedItem("1");
            dob_Date_Day.setSelectedItem("1");
            membership_date_year.setSelectedItem("2020");
            membership_date_month.setSelectedItem("1");
            membership_date_day.setSelectedItem("1");
            referral_Source_Text_Field.setText("");
            Trainer$s_name.setText("");
            paid_Amount_Text_Field.setText("");
            plan_combo.setSelectedItem("Basic") ;
            price_combo.setSelectedItem("6500");
            removal_Reason_Text_Field.setText("");

            //having trouble in this exception
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(frame,"input the value","Input Error", JOptionPane.ERROR_MESSAGE); 
            
        }
        

    }
    private void activatePremium(){
         try{   
                // get the values from user
            String id = premium_id_Text_Field.getText();
            String name = premium_name_Text_Field.getText();
            String location = premium_location_Text_Field.getText();
            String phone = premium_phone_Text_Field.getText();
            String email = premium_email_Text_Field.getText();
            String gender = gender_radio_male.isSelected() ? "Male" :
                            (gender_radio_female.isSelected() ? "Female" : "");
            String dob = dob_Date_Year.getSelectedItem() + "-" +
                         dob_Date_Month.getSelectedItem() + "-" +
                         dob_Date_Day.getSelectedItem();
            String membershipStartDate = membership_date_year.getSelectedItem() + "-" +
                                         membership_date_month.getSelectedItem() + "-" +
                                         membership_date_day.getSelectedItem();
            String referralSource = premium_referral_Source_Text_Field.getText();
            String $Paid_Amt = premium_paid_Amount_Text_Field.getText();
            
            
            
            // converting id from string to integer by using parse which means a wrapper class
            int id$ = Integer.parseInt(id);
            
             for (GymMember member : members) {
                if (member.getId() == id$) {
                    JOptionPane.showMessageDialog(null, "Do you want to upgrade to premium?");
                    return;
                }
            }
            
            // creating an object of an arraylist for regular member
            PremiumMember premium_new_members = new PremiumMember(id$,name,location, phone,email,gender,dob,membershipStartDate
            ,referralSource);
            
            //adding value to arraylist
            members.add(premium_new_members);
            
            JOptionPane.showMessageDialog(frame, "Submission Successful!",
            "Success", JOptionPane.INFORMATION_MESSAGE);
            
            
            //after sucessful, clearing all the input fields 
            premium_id_Text_Field.setText("") ;
            premium_name_Text_Field.setText("");
            premium_location_Text_Field.setText("");
            premium_email_Text_Field.setText("");
            premium_phone_Text_Field.setText("");
            premium_gender_radio_male.setSelected(false);
            premium_gender_radio_female.setSelected(false);
            premium_dob_Date_Year.setSelectedItem("1990");
            premium_dob_Date_Month.setSelectedItem("1");
            premium_dob_Date_Day.setSelectedItem("1");
            premium_membership_date_year.setSelectedItem("2020");
            premium_membership_date_month.setSelectedItem("1");
            premium_membership_date_day.setSelectedItem("1");
            premium_referral_Source_Text_Field.setText("");
            premium_paid_Amount_Text_Field.setText("");


            //having trouble in this exception
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(frame,"input the value","Input Error", JOptionPane.ERROR_MESSAGE); 
            
        }
       
    }
    
    private void mark_btn(){

        attendanceMemberId = new JLabel("Enter Member ID:");
        attendanceMemberId.setBounds(390, 225, 200, 30);
        attendanceMemberId.setFont(new Font("Arial", Font.BOLD, 20));
        attendancePanel.add(attendanceMemberId);

        attendanceIdTextField = new JTextField();
        attendanceIdTextField.setBounds(600, 220, 150, 35);
        attendancePanel.add(attendanceIdTextField);

        attendanceSubmitBtn = new JButton("Submit");
        attendanceSubmitBtn.setBounds(610, 280, 120, 30);
        attendancePanel.add(attendanceSubmitBtn);
        attendanceSubmitBtn.addActionListener(this);

        frame.add(attendancePanel);
        frame.setVisible(true);
        }
    
       
    
        @Override
        public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == regular_btn) {
            welcome.setVisible(false);
            premium_Panel.setVisible(false);
            Main_Panel.setVisible(true);
        } else if (e.getSource() == premium_btn) {
            welcome.setVisible(false);
            Main_Panel.setVisible(false);
            premium_Panel.setVisible(true);
        } else if (e.getSource() == regular_done_btn) {
            activateRegular();
        } else if (e.getSource() == premium_done_btn){
            activatePremium();
        } else if(e.getSource() == mark_btn){
            welcome.setVisible(false);
            premium_Panel.setVisible(false);
            Main_Panel.setVisible(false);
            attendancePanel.setVisible(false); //requried to be true in future
            mark_btn();  
            String memberId = JOptionPane.showInputDialog(frame, "Enter Member ID to Mark Attendance:");

        if (memberId != null && !memberId.trim().isEmpty()) {
        String inputId = memberId.trim();
        boolean memberFound = false;

        for (GymMember member : members) {
            String memberIdStr = String.valueOf(member.getId());

            if (memberIdStr.equals(inputId)) {
                memberFound = true;

                if (member.getActiveStatus()) {
                    member.markAttendance(); // Calls overridden method in Regular/Premium class
                    JOptionPane.showMessageDialog(frame,
                        "Attendance marked successfully for Member ID: " + inputId,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "Cannot mark attendance. This member is not active.",
                        "Inactive Member",
                        JOptionPane.WARNING_MESSAGE);
                }
                break;
            }
        }

        if (!memberFound) {
            JOptionPane.showMessageDialog(frame,
                "No Member Found with ID: " + inputId,
                "Member Not Found",
                JOptionPane.ERROR_MESSAGE);
        }
        } else {
        JOptionPane.showMessageDialog(frame,
            "Please enter a valid Member ID.",
            "Invalid Input",
            JOptionPane.WARNING_MESSAGE);
        }
            } 

        
             
    }


    public static void main(String[] args){
        new GymGUI();
        //here is main method
       
    }
}