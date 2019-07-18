
package p.e.manager;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PEMService {
    public PEMService(){
        prepareSampleData();
        delay();
    }
    Repository rep= Repository.getRepository();
    public Scanner in=new Scanner(System.in);
    int choice;
    public void showMenu(){
        while(true){
            printMenu();
            switch(choice){
                case 1:
                    onAddCotegory();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 2:
                    categoryList();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 3:
                    expenseEntry();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 4:
                    expenseList();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 5:
                    monthlyExpenseList();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 6:
                    yearlyExpenseList();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 7:
                    categoryExpenseList();
                    System.out.print("Press To Continue");
                    toContinue();
                    break;
                case 0:
                    System.exit(0);
                    break;
               
            }
        }
    }
    public void printMenu(){
        System.out.println("---------Menu--List---------");
        System.out.println("1.Add category");
        System.out.println("2. Category List");
        System.out.println("3. Expense Entry");
        System.out.println("4.Expense List");
        System.out.println("5.Monthly Expense List");
        System.out.println("6.Yearly Expense List");
        System.out.println("7.Category Expense List");
        System.out.println("8.Clear Screen");
        System.out.println("0.Exit");
        System.out.println("----------------------");
        System.out.print("Enter Your choice---::");
        
        choice=in.nextInt();
//        for(char a=2365;a<=2398;a++){
//            System.out.println(a);
//        }
    }
    
    public void onAddCotegory(){
        in.nextLine();//now we read one line
        System.out.println("Entry Add category");
        String name=in.nextLine();
        Category cat=new Category(name);
        rep.catList.add(cat);
        System.out.println("successfully Added");
    }
    public void categoryList(){
        try{
        System.out.println("category list");
       List<Category> clist=rep.catList;
       for(int a=0;a<clist.size();a++){
           Category c=clist.get(a);
           String s=new String(c.getName());
           String s1=new String(String.valueOf(c.getCategoryId()));
           System.out.println((a)+"Category Name::"+s.toUpperCase()+"  "+"ID::"+s1.toUpperCase());
       
       }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void expenseEntry(){
        System.out.println("Enter Details for Expense Entry");
        categoryList();
        System.out.println("Choice Category Index Number");
        int catChoice=in.nextInt();
       Category selectCat= rep.catList.get(catChoice-1);
        System.out.println("your category choice-"+selectCat.getName());
       
        System.out.println("Enter Amount for selected category");
       
        Long amt=in.nextLong();
         in.nextLine();
         System.out.println("Enter Remark for selected category");
         String rmk=in.nextLine();
            System.out.println("Enter Date(DD/MM/YYYY)");
            String sd=in.nextLine();
           Date d= DateUtil.toStringDate(sd);
         Expense ex=new Expense();
         ex.setCategoryId(selectCat.getCategoryId());
         ex.setAmount(amt);
         ex.setRemark(rmk);
         ex.setDate(d);
         rep.expList.add(ex);
         
    }
 
    public void expenseList(){
        System.out.println("expenseList");
        List<Expense> elist=rep.expList;
        for(int i=0;i<elist.size();i++){
            Expense ex=elist.get(i);
            String name=getCategoryByName(ex.getCategoryId());
            System.out.println("Category id\tName\tAmount\tRemark");
            //System.out.print(i+1);
            String ydate=DateUtil.dateToString(ex.getDate());
            System.out.print(ex.getCategoryId()+"\t"+name+"\t"+ex.getAmount()+"\t"+ex.getRemark()+"\t"+ydate);
            System.out.println("");
           // System.out.print((i+1)+"\t"+ex.getCategoryId()+"\t"+ex.getAmount()+"\t"+ex.getRemark()+"\t"+ex.getDate());
                    
        }
    }
 
    public void monthlyExpenseList(){
        System.out.println("monthlyExpenseList");
        ReportService reportService=new ReportService();
        reportService.calculateMonthlyTotal();
    }
    public void yearlyExpenseList(){
      System.out.println("yearlyExpenseList");  
    }
    public void categoryExpenseList(){
       System.out.println("categoryExpenseList"); 
    }
   public String getCategoryByName(Long categoryId){
       for(Category c:rep.catList){
           if(c.getCategoryId().equals(categoryId)){
              return c.getName();
           }
          
            
       }
        return null;
   }
   
    public void toContinue(){
        try {
            System.in.read();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    public void prepareSampleData(){
        Category party=new Category("party");
        delay();
        Category shoping=new Category("shoping");
        delay();
        Category gift=new Category("gift");
        rep.catList.add(gift);
        rep.catList.add(shoping);
        rep.catList.add(party);
        Expense e1=new Expense(party.getCategoryId(),1000.0F,DateUtil.toStringDate("01/01/2016"),"N/A");
        Expense e2=new Expense(party.getCategoryId(),1200.0F,DateUtil.toStringDate("01/02/2016"),"N/A");
        Expense e3=new Expense(gift.getCategoryId(),3000.0F,DateUtil.toStringDate("01/01/2017"),"N/A");
        Expense e4=new Expense(gift.getCategoryId(),4000.0F,DateUtil.toStringDate("01/08/2017"),"N/A");
        Expense e5=new Expense(shoping.getCategoryId(),5000.0F,DateUtil.toStringDate("01/01/2018"),"N/A");
        Expense e6=new Expense(shoping.getCategoryId(),5000.0F,DateUtil.toStringDate("01/01/2018"),"N/A");
        rep.expList.add(e6);
        rep.expList.add(e5);
        rep.expList.add(e4);
        rep.expList.add(e3);
        rep.expList.add(e2);
        rep.expList.add(e1);
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
