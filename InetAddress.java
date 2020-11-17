import java.util.Scanner;
public class InetAddress {
    private static String ipv4;
    private static int val;
    static String [] ipv4string;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IPv4 Address: ");
        ipv4 = sc.next();
        ipv4string = ipv4.split("\\.");
        System.out.println("Class is: "+findClass());
        System.out.println("Default Mask is: " + findDefaultMask(findClass()));
        System.out.println("Net ID is: " + findNetID(findClass()));
        System.out.println("Host ID is: " + findHostID(findClass()));
        System.out.println("Network Address is: " + findNetworkAddress());
        System.out.println("Broadcast Address is: " + findBroadcastAddress());
    }
    public static char findClass(){

        int firstOctet = Integer.parseInt(ipv4string[0]);
        if(firstOctet>1 && firstOctet<=127)
            return 'A';
        if(firstOctet>=128 && firstOctet<=191)
            return 'B';
        if(firstOctet>=192 && firstOctet<=223)
            return 'C';
        if(firstOctet>=224 && firstOctet<=255)
            return 'D';
        return 'E';

    }

    public static String findNetID(char c){
        String x = "";
        val = (int)c - (int)'A'+1;
        for(int i=0; i<val; i++){
            x = x + ipv4string[i] + ".";
        }
        x = x.substring(0, x.length()-1);
        return x;

    }

    public static String findDefaultMask(char c){
        if(c == 'A') return "255.0.0.0";
        if(c == 'B') return "255.255.0.0";
        if(c == 'C') return "255.255.255.0";
        if(c == 'D') return "255.255.255.255";
        return "";
    }
    public static String findHostID(char c){
        String y = "";
        for(int l = val; l < ipv4string.length; l++)
            y = y + ipv4string[l]+".";
        y = y.substring(0, y.length()-1);
        return y;
    }

    public static String findNetworkAddress(){
        String x = findNetID(findClass());
        for(int i=0; i<4-val; i++){
            x = x + ".0";
        }
        return x;
    }

    public static String findBroadcastAddress(){
        String x = findNetID(findClass());
        for(int i=0; i<4-val; i++){
            x = x + ".255";
        }
        return x;
    }
}
