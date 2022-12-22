import java.net.*;
import java.io.*;
import java.util.Scanner;



public class Client {
  public static void main(String[] args) throws Exception {
    while(true){
      Socket s=new Socket("localhost",1942);
      PrintWriter pr= new PrintWriter(s.getOutputStream());
      System.out.print("SGBD-Socket >");
      Scanner scan = new Scanner(System.in);
      String req=scan.nextLine();
      pr.println(req);
      pr.flush();
      try{
        ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
        Relation re=(Relation) ois.readObject();
        System.out.println("");
        re.cmd();
      }catch (Exception e){
        InputStreamReader in=new InputStreamReader(s.getInputStream());
        BufferedReader bf=new BufferedReader(in);
        String exe=bf.readLine();
        System.out.println("ERROR: "+exe);
      }
      System.out.println("");
      s.close();
    }
  }
}