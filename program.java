import java.io.*;
public class serializable
{
public static void main(String[] args) throws ClassNotFoundException
 {
  //Object Serialization
  try
  {
    myclass object1=new myclass("hello",-7,2.7e10);
    System.out.println("Object1:"+object1);
    FileOutputStream fos=new FileOutputStream("serial.txt");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    oos.writeObject(object1);
    oos.flush();
    oos.close();
  }
  catch(IOException e)
  {
    System.out.println("Exception during serialization:"+e);
    System.exit(0);
  }
  //Object deserialization
  try
  {
    myclass object2;
    FileInputStream fis=new FileInputStream("serial.txt");
    ObjectInputStream ois=new ObjectInputStream(fis);
    object2=(myclass)ois.readObject();
    ois.close();
    System.out.println("object2:"+object2);
  }
  catch(IOException e)
  {
    System.out.println("Exception during deserialization:"+e);
    System.exit(0);
  }
 }
}
class myclass implements Serializable
{
  String s;
  int i;
  double d;
  public myclass(String s, int i, double d)
  {
    this.s=s;
    this.i=i;
    this.d=d;
  }
  public String toString()
  {
    return "s="+s+",i="+i+",d="+d;
  }
}
