package org.com.wink.IO.socket;

import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        SocketWrapper socketWrapper = new SocketWrapper(new Socket("localhost",8888));
        try {
            System.out.println("已连接到服务器，现在可以输入数据开始通信。。。。");
            System.out.println("C1");
            String sendMsg = scanner.nextLine();
            socketWrapper.writeLine(sendMsg);
            String reciveMsg = socketWrapper.readLine();
            while (!"close".equals(reciveMsg)){
                System.out.println("服务器返回消息：" + reciveMsg);
                sendMsg = scanner.nextLine();
                socketWrapper.writeLine(sendMsg);
                reciveMsg = socketWrapper.readLine();
            }
            System.out.println("我是客户端，收到close消息之后关闭。。。。。");
        } finally {
            if(socketWrapper != null){
                socketWrapper.close();
            }
        }
    }
}
