
package DataStructre;
import java.util.Scanner;

public class EmployeesDataBase {
    private Node head;
      private  class Node{
        private int ID;
        private String Name,Day,phone_mumber,address;
        private double hours,salary;
        private Node next;
        public Node(int ID,String Name,String Day,String phone_mumber,String address,double hours,double salary){
            this.ID=ID;
            this.Name=Name;
            this.Day=Day;
            this.phone_mumber=phone_mumber;
            this.address=address;
            this.hours=hours;
            this.salary=salary;
            this.next=null;
        }
    }
    
   public void insertEmployee(int ID,String name,String day,String phone_mumber,String address,double hours,double salary){
      
           System.out.println("----------------------");
       Node NewNode=new Node(ID,name,day,phone_mumber,address,hours,salary);
       Node ptr=head;
       
       if(head==null){
            head=NewNode;
            return;
        }
    
        while(ptr.next!=null){
            ptr=ptr.next;
        }
        ptr.next=NewNode;
       
    }
   boolean checkRecord(int ID){
       Node ptr=head;
       if(head==null)
           return false;
       
        while(ptr!=null&&head!=null){
            if(ptr.ID==ID)
                return true;
            ptr=ptr.next;
        }
       return false;
   }
   
   public void search(int ID){
        Node ptr=head;
        while (ptr!= null) {
              if(ptr.ID == ID){
                System.out.println("Employee Data :\n ID:"+ID+"\n Name:"+ptr.Name+"\n First day of work: "+
                        ptr.Day+"\n Phone number: "+ptr.phone_mumber+"\n Address :"+ptr.address+"\n Work hours: "+ptr.hours
                +"\n Salary: "+ptr.salary);
               return;
            }else{
                ptr=ptr.next;
            }
        }
        System.out.println("This Employee ("+ID+") is not registered" );
   }
     public  int deleteEmployee(int ID){
         
         Node ptr=head,prev=null;
         if (ptr != null && ptr.ID == ID) {
            head = ptr.next; 
            return 1;
        }
         while (ptr != null && ptr.ID != ID) {
            prev = ptr;
            ptr = ptr.next;
        }
        if(ptr==null){
            return 0;
        }
        prev.next=ptr.next;
        return 1;
   }
     public void showRecord(){
        Node ptr=head;
        while(ptr!=null){
              System.out.println("Employee Info :\n- ID:"+ptr.ID+"\n- Name:"+ptr.Name+"\n- First day of work: "+
                        ptr.Day+"\n- Phone number: "+ptr.phone_mumber+"\n- Address :"+ptr.address+"\n- Work hours: "+ptr.hours
                +"\n- Salary: "+ptr.salary);
            ptr=ptr.next;
        }
    
     }
     public void updateSalary(){
        
         if(head==null){
             return;
         }
          
         Node ptr=head;
        while(ptr!=null){
            if(ptr.hours>32){
                ptr.salary+=(ptr.salary*.02);
            
            }
            ptr=ptr.next;
        }
         System.out.println("Record updated");
     }
     public void updateEmployee(int ID){
         if(!checkRecord(ID)){
             System.out.println("This Employee is not found");
         }else{
             Scanner input=new Scanner(System.in);
             String name,day,phone_mumber,address;
             double hours,salary;
                        System.out.print("Enter a new employee's Name:");  
                        name=input.nextLine();
                        System.out.print("Enter a new date of First day at work:");  
                        day=input.nextLine();
                        System.out.print("Enter a new Phone number:");  
                        phone_mumber=input.nextLine();
                        System.out.print("Enter a new Address:");  
                        address=input.nextLine();
                        System.out.print("Enter a new Work hours:");  
                        hours=input.nextDouble();
                        System.out.print("Enter a new Salary:");  
                        salary=input.nextDouble();
              Node ptr=head;
                while(ptr!=null){
                    if(ptr.ID==ID){
                          ptr.Name=name;
                          ptr.salary=salary;
                          ptr.address=address;
                          ptr.Day=day;
                          ptr.hours=hours;
                          ptr.phone_mumber=phone_mumber;
                          break;
                    }
                    ptr=ptr.next;
                }
         }
         
     }
      public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            int choice,ID;
            String name,day,phone_number,address;
            double hours,salary;
            boolean loop=true;
            Project employees=new Project();
           
           while(loop){
                System.out.println("1- Insert Employee record\n" +
                               "2- Delete Employee record\n" +
                               "3- Update Employee record\n" +
                               "4- Show Employee\n" +
                               "5- Search Employee\n" +
                               "6- Update salary\n"+
                               "7- Exit\n");
                System.out.println("Select your choice ");
                choice=input.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("Enter employee ID:");  
                        ID=input.nextInt();
                        input.nextLine();
                        if(employees.checkRecord(ID)){
                            System.out.println("Employee with ID "+ID+ " already exist ");
                        }else{
                        System.out.print("Enter employee Name:");  
                        name=input.nextLine();
                        System.out.print("Enter First day of work:");  
                        day=input.nextLine();
                        System.out.print("Enter Phone number:");  
                        phone_number=input.nextLine();
                        System.out.print("Enter Address:");  
                        address=input.nextLine();
                        System.out.print("Enter Work hours:");  
                        hours=input.nextDouble();
                        System.out.print("Enter Salary:");  
                        salary=input.nextDouble();
                        employees.insertEmployee(ID, name, day, phone_number, address, hours, salary);
                        }
                      break;
                    case 2: 
                        System.out.println("Enter employee ID to delete :");
                        ID=input.nextInt();
                        if(employees.deleteEmployee(ID)==1){
                            System.out.println("Emplyee has been deleted ");
                            
                        }else{
                            System.out.println("This Employee "+ID+" doesn't Exist");
                        }
                        break;
                    case 3:
                         System.out.println("Enter Employee ID to Update :");
                         ID=input.nextInt();
                         employees.updateEmployee(ID);
                        break;
                    case 4:
                        employees.showRecord();
                        break;
                    case 5:
                        System.out.println("Enter employee ID to Search :");
                        ID=input.nextInt();
                        employees.search(ID);
                        break;
                    case 6:
                        employees.updateSalary();
                        break;
                    case 7:
                        loop=false;
                        break;
                    default:
                        System.out.println("Please select number from 1-7");
                        
                        
                }
           }
            
      
    }
    
}
