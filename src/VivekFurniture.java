import java.util.Scanner;

class CustomerDetails {

   private String customerName;
   private long phoneNumber;
   private String address;
    public  CustomerDetails(String customerName,long phoneNumber,String address){
        this.customerName=customerName;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

abstract class Bero{
    protected String beroType;
    protected String beroColour;
    protected double price;

    public Bero(String beroType, String beroColour){
        this.beroType=beroType;
        this.beroColour=beroColour;
    }


    public String getBeroType() {
        return beroType;
    }

    public void setBeroType(String beroType) {
        this.beroType = beroType;
    }

    public String getBeroColour() {
        return beroColour;
    }

    public void setBeroColour(String beroColour) {
        this.beroColour = beroColour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract void calculatePrice();

}

 class SteelBero extends Bero{
    private int beroHeight;

    public SteelBero(String beroType, String beroColour,int beroHeight){
        super(beroType,beroColour);
        this.beroHeight=beroHeight;
    }

     public int getBeroHeight() {
         return beroHeight;
     }

     public void setBeroHeight(int beroHeight) {
         this.beroHeight = beroHeight;
     }
//ye wala part rhe rha hai neeche
     public void calculatePrice(){
        if (beroHeight==3){price=5000;}
        else if (beroHeight==5) {price=8000; }
        else if (beroHeight==7) {price=10000; }
     }
 }
 class WoodenBero extends Bero {
     private String woodType;

     public WoodenBero(String beroType, String beroColour, String woodType) {
         super(beroType, beroColour);
         this.woodType = woodType;

     }

     public String getWoodType() {
         return woodType;
     }

     public void setWoodType(String woodType) {
         this.woodType = woodType;
     }


     @Override
     public void calculatePrice() {
         if (woodType.equals("Ply Wood")) {
             price = 15000;
         } else if (woodType.equals("Teak Wood")) {
             price = 12000;
         } else if (woodType.equals("Engineered Wood")) {
             price = 10000;
         }

     }
 }

 class Discount{
    public double calculateDiscount(Bero bObj){
        if (bObj instanceof SteelBero){
            return (bObj.getPrice()*10/100);
        } else if (bObj instanceof WoodenBero) {
            return (bObj.getPrice()*15/100);
        }
        return 0;
    }
 }

 public class VivekFurniture {
     public static void main(String[] args) {
         Scanner user = new Scanner(System.in);
         System.out.print("Enter Customer Name:- ");
         String cname = user.nextLine();
         System.out.print("Enter phone number:- ");
         long phn = user.nextLong();
         user.nextLine();
         System.out.print("enter Address:- ");
         String address = user.nextLine();
         System.out.print("Enter Bero Type:-  [[!!Warning!!:- These are case sensitve]]\nonly options are :-(Steel Bero,Wooden Bero):- ");
         String beroType = user.nextLine();

         CustomerDetails customer = new CustomerDetails(cname, phn, address);
         Bero bero = null;
         if (beroType.equals("Steel Bero")) {
             System.out.print("Enter Bero Colour:- ");
             String colour = user.nextLine();

             System.out.print("Enter Bero Height:- only options are-(3,5,7): ");
             int height = Integer.parseInt(user.nextLine());

             bero = new SteelBero(beroType, colour, height);
         } else if (beroType.equals("Wooden Bero")) {
             System.out.print("Enter Bero Colour:- ");
             String colour = user.nextLine();

             System.out.println("Enter Wood Type:-  only options are-(Ply Wood,Teak Wood, Engineered Wood)\nNote- these are case sensitive");
             String woodType = user.nextLine();

             bero = new WoodenBero(beroType, colour, woodType);
         } else {
             System.out.println(beroType + " is an invalid bero type");
             return;
         }
         bero.calculatePrice();
         Discount dis = new Discount();
         double discount = dis.calculateDiscount(bero);
         double totalPrice = bero.getPrice() - discount;
         System.out.println("total amount to pay now : "+ String.format("%.2f",totalPrice));
     }
 }


