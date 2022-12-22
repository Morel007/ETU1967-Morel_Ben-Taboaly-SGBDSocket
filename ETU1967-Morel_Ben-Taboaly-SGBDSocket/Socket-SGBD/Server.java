import java.net.*;
import java.io.*;
public class Server {
  public static void main(String[] args) throws Exception {
   while(true) {
      ServerSocket ss= new ServerSocket(1942);
      Socket s=ss.accept();
      InputStreamReader in=new InputStreamReader(s.getInputStream());
      BufferedReader bf=new BufferedReader(in);
      String req=bf.readLine();
      Relation re=new Relation();
      try {
        Relation r=new Relation();
        re=r.request(req);
      }catch (Exception e) {
        PrintWriter pr= new PrintWriter(s.getOutputStream());
        pr.println(e.getMessage());
        pr.flush();
      }
      OutputStream ot=s.getOutputStream();
      ObjectOutputStream oot=new ObjectOutputStream(ot);
      oot.writeObject(re);
      ss.close();
    }
  }
}