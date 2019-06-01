package org.com.wink.IO.socket;

import java.net.ServerSocket;

public class SocketServer {

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器端口已打开8888，开始准备接收数据。。。。");
        SocketWrapper socket = null;
        try {
            socket = new SocketWrapper(server.accept());
            System.out.println("S1");
            String line = socket.readLine();
            System.out.println("S2");
            while (!"bye".equals(line)){
                System.out.println("客户端传来数据：" + line);
                socket.writeLine("我是服务端，接收到你的数据是：" + line);
                System.out.println("S3");
                line = socket.readLine();
                System.out.println("S4");
            }
            socket.writeLine("close");
        } finally {
            if(socket != null){
                socket.close();
            }
        }
    }
}
