import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static Integer compareLength(int n1,int n2){
        if(n1>n2){
            return n1;
        }else if(n2>n1){
            return n2;
        }else{
            return 0;
        }
        
    }
    public static ArrayList<List> createArrayN( Integer n1, Integer n2){
        Integer maiorNum = compareLength(n1, n2);
        
        
       ArrayList<Character> n1List = new ArrayList<Character>(); 
       ArrayList<Character> n2List = new ArrayList<Character>();
     
       for (int i = 0; i < n1.toString().length(); i++) {
        n1List.add(n1.toString().charAt(i));
       }
       for (int i = 0; i < n2.toString().length(); i++) {
        n2List.add(n2.toString().charAt(i));
       }
       
       

       int diferencadeTamanho = Math.abs(n1List.size() - n2List.size());
       

       ArrayList<Character> n1ListFinal = new ArrayList<Character>(); 
       ArrayList<Character> n2ListFinal = new ArrayList<Character>();

       ArrayList<List> listaN = new ArrayList<List>();
       if(diferencadeTamanho == 0){
        listaN.add(n1List);
       listaN.add(n2List);
        return listaN;
       }else{
        for (int i = 0; i < diferencadeTamanho; i++) {
            if(!n1.equals(maiorNum)){
                n1ListFinal.add('0');
            }else if(!n2.equals(maiorNum)){
                n2ListFinal.add('0');

            }
        }
        for (int i = 0; i < n1List.size(); i++) {
            n1ListFinal.add(n1List.get(i));    
        }
        for (int i = 0; i < n2List.size(); i++) {
            n2ListFinal.add(n2List.get(i));    
        }
        listaN.add(n1ListFinal);
       listaN.add(n2ListFinal);
       return listaN;
       }
    
    }
    public static String [] compareArrays(List listaN){
        
        List  Array =  (List) listaN.get(0);
        List  Array2 =  (List) listaN.get(1);

        ArrayList <Integer>  n1 = new ArrayList<Integer>();
        ArrayList <Integer>  n2 = new ArrayList<Integer>();
        for (int i = 0; i < Array.size(); i++) {
            n1.add(Character.getNumericValue((char) Array.get(i)));
        }
        for (int i = 0; i < Array2.size(); i++) {
            n2.add(Character.getNumericValue((char) Array2.get(i)));
        }
       String n1Final = ""; 
       String n2Final = ""; 
        for (int i = 0; i < n1.size(); i++) {
            if(n1.get(i) > n2.get(i)){
                 n1Final+= n1.get(i).toString();   
            }else if(n2.get(i) >n1.get(i)){
                n2Final+=n2.get(i).toString(); 
            }else if(n1.get(i) == n2.get(i)){
                n1Final+=n1.get(i).toString();   
                n2Final+=n2.get(i).toString();
            }
        
        }
        if(n1Final.equals("")){
            n1Final = "-1"; 
        }else if(n2Final.equals("")){
            n2Final = "-1";
        }
        String []resultado = {n1Final,n2Final};
        return resultado;    
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o numero 1: ");
        Integer n1 = scan.nextInt();
        
        System.out.println("Digite o numero 2: ");
        Integer n2 = scan.nextInt();
        

        //System.out.println(n1.toString());
        ArrayList<List> listaN = new ArrayList<List>();
        List nS = createArrayN(n1,n2);

        listaN.add((List) nS.get(0));
        listaN.add((List)nS.get(1));
        String [] resultado = compareArrays(listaN);
        System.out.println("Arrays Organizados:");
       System.err.println(nS);
       System.out.println("Resultados");

        System.out.println(resultado[0]);
        System.out.println(resultado[1]);


        
    }
}
