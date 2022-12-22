import java.util.*;

public class Fonction{
  public boolean compare_ligne(Vector<String> a,Vector<String> b){
    int count=0;
    if(a.size() != b.size()){
      return false;
    }
    for(int i=0;i<a.size();i++){
      if(a.get(i) == b.get(i)){
        count++;
      }
    }
    if(count==a.size()){
      return true;
    }else{
      return false;
    }
  }
  public Vector<String> addVectString(Vector<String> a,Vector<String> b){
		Vector<String> response=new Vector<String>();
		for(int i=0;i<a.size();i++) {
			response.addElement(a.get(i));
		}
		for(int i=0;i<b.size();i++) {
			response.addElement(b.get(i));
		}
		return response;
	}
}