
import java.util.*;
import java.io.*;
class Dictionary1
{
    String[] list1= new String[5];
	int select,top3=0;
	Dictionary1()
	{
    	try 
  	  {
    	 
  		  FileInputStream fstream = new FileInputStream("words"+level.j+".txt");
  		  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
  		  String strLine;
  		  while ((strLine = br.readLine()) != null)   
  		  list1[top3++]=strLine;
       }
  	  catch (Exception e)
  	  {
  	 //     System.err.println(e.getMessage()); 
  	  }
}
}
class Random1
{
 static public String[] rand=new String[120];
 static int top=0;
 static int select1;
 static Dictionary1 dr;
 Random1()
 {   
	 Random1.top=0;
	 Random1.dr = new Dictionary1();
	 dr.select=(new Random()).nextInt(dr.list1.length);
	 per.permutation(Random1.dr.list1[Random1.dr.select]); 
	 Random1.select1=(new Random()).nextInt(Random1.rand.length);
	 if(Random1.dr.list1[Random1.dr.select].equals(Random1.rand[Random1.select1]))
	 System.out.println(Random1.rand[Random1.select1+1]);
	 else
	 System.out.println(Random1.rand[Random1.select1]);
 }
 
}
class per{
public static void permutation(String str) { 
    permutation("", str); 
}

private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) {Random1.rand[Random1.top]=prefix;if(Random1.top<119)Random1.top++;}
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
}
class level
{
	 public static int i=12;
	 public static int j=0;
	 public static Random1 rd;
}

public class jumble1 {
	
	static int score;
	static String strLine1;
       static void update(int score)
	{
		  
		try 
	  	  {
	  		  FileInputStream fstream = new FileInputStream("highscore.txt");
	  		  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                          strLine1= br.readLine();
                           	                     }	    
                  catch (Exception e)
	  	  {
	  	      System.err.println(e.getMessage()); 
	  	  }
		
		if(Integer.parseInt(strLine1)<score)
                {System.out.println("Congrats!!");
                 System.out.println("New highscore == "+score+" old High score == "+strLine1 );       
                  try{  
                      String s=Integer.toString(score);
                      FileOutputStream fout=new FileOutputStream("highscore.txt");    
                      byte b[]=s.getBytes();
                      fout.write(b);  
                      fout.close();  
                      }catch(Exception e){System.out.println(e);}  
                }

		
	}
   	
	
	public static void main(String[] args) {
        int res=0,res1=0;
        System.out.println("Level 1::: 2 Points for correct answer\n");
		for(int i=0;i<level.i;i++)
		{
		System.out.println("Solve this::");    
        level.rd=new Random1();
        
        System.out.println("Enter answer");
        Scanner input= new Scanner(System.in);
		String y=input.nextLine();
		if(y.equalsIgnoreCase(Random1.dr.list1[Random1.dr.select]))
        {
         
        System.out.println("\nCorrect\n");if(res<3)res++;else res1++;level.j++;}
        else
        {
         
         System.out.println("\nWrong\n");break;}
		if((res==3)&&(res1==0))
		System.out.println("\nLevel 2::: 4 Point for correct answer\n ");
                 
		}
	     score=(res*2)+(res1*4);
		System.out.println("\nYour score is "+((res*2)+(res1*4)));
		update(score);
}
}