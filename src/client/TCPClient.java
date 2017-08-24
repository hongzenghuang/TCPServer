package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket=new Socket("localhost", 8888);
            //2.获取输出流，向服务器端发送信息
            
            while(true){
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	        System.out.print("Enter String");
    	        String cmd = br.readLine();
    	        
    	        OutputStream op = socket.getOutputStream();
    	        op.write(cmd.getBytes());
    	        op.flush();
    	        
                //socket.shutdownOutput();//关闭输出流
                //3.获取输入流，并读取服务器端的响应信息
                InputStream is=socket.getInputStream();
                BufferedReader br2=new BufferedReader(new InputStreamReader(is));
                String info=null;
                while((info=br.readLine())!=null){
                    System.out.println("我是客户端，服务器说："+info);
                }
                
                Thread.sleep(5000);
            }
        }catch(Exception e)
        {e.printStackTrace();}

         
    }
}