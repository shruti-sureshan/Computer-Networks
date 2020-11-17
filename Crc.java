import java.util.Scanner;
public class Crc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Dataword:");
        String data=sc.next();
        System.out.println("Enter Generator:");
        String gen=sc.next();
        int r=gen.length()-1;
        System.out.println("Value of r: "+r);
        String newzero=new String();
        for(int i=1;i<=r;i++)
        {
          newzero=newzero+'0';  
        }
        String msg=data+newzero;
        System.out.println("Message is: "+msg);
   
        String p=msg; 
        String q=gen; 
        
        int x=p.length()-q.length();
        char[] a=p.toCharArray(); 
        char[] b=q.toCharArray();

        for(int k=0;k<=x;k++){
            if( a[0]=='1'){
                for(int i=0;i<q.length();i++){
                        if(b[i]==a[i]){
                              a[i]='0';
                        }
                        else{
                              a[i]='1';
                        }
                }
       
                for(int l=0;l<p.length()-k-1;l++){
                              a[l]=a[l+1];
                 }
            }
            else{
                  for(int l=0;l<p.length()-k-1;l++){
                      a[l]=a[l+1];
                  }
            }
       }
       char[] c=new char[50];
       for(int d=0;d<r;d++){
              c[d]=a[d];
       }
       String o=new String(c);  
       System.out.println("code="+o);
       System.out.println("Encoded word="+data+o);


    }
}
/*
OUTPUT:
Enter Dataword:1010
Enter Generator:10111
Value of r: 4
Message is: 10100000
code=1111
Encoded word=10101111

Enter Dataword:1001
Enter Generator:1011
Value of r: 3
Message is: 1001000
code=110
Encoded word=1001110

*/