package webadv.s17206104.p01;

import java.io.*;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
/**
* Hello world!
*/
public class App {
  public static void main(String[] args)throws IOException {
  //写入账号和密码
    FileWriter fw = new FileWriter("password.txt");
    BufferedWriter osw = new BufferedWriter(fw);
    osw.write("17206104\n");//账号
    osw.write(sha256hex("123456"));//密码
    osw.close();
    fw.close();
    //控制台获取账号和密码
    String username = "";
    String password = "";
    Scanner input = new Scanner(System.in);
    System.out.println("请输入账号: ");
    username = input.nextLine();
    System.out.println("请输入密码: ");
    password = input.nextLine();
    //从文件获取账号和密码
    FileReader fr = new FileReader("password.txt");
    BufferedReader bf = new BufferedReader(fr);
    String txtUsername = bf.readLine();
    System.out.println(txtUsername);
    String txtPassword = bf.readLine();
    System.out.println(txtPassword);
    bf.close();
    fr.close();
    //验证账号和密码
    if(username.equals(txtUsername)&&sha256hex(password).equals(txtPassword)){
        System.out.println("账号密码验证成功! ");
    }else{
        System.out.println("验证失败! ");
    }
}
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}