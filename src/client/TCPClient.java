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
 * �ͻ���
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            //1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
            Socket socket=new Socket("localhost", 8888);
            //2.��ȡ���������������˷�����Ϣ
            
            while(true){
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	        System.out.print("Enter String");
    	        String cmd = br.readLine();
    	        
    	        OutputStream op = socket.getOutputStream();
    	        op.write(cmd.getBytes());
    	        op.flush();
    	        
                //socket.shutdownOutput();//�ر������
                //3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
                InputStream is=socket.getInputStream();
                BufferedReader br2=new BufferedReader(new InputStreamReader(is));
                String info=null;
                while((info=br.readLine())!=null){
                    System.out.println("���ǿͻ��ˣ�������˵��"+info);
                }
                
                Thread.sleep(5000);
            }
        }catch(Exception e)
        {e.printStackTrace();}

         
    }
}