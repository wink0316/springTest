package org.com.wink.IO.socket;

import java.io.*;
import java.net.Socket;

public class SocketWrapper {

    private Socket socket;
    private InputStream inputStream;
    private BufferedReader inpuReader;
    private BufferedWriter outputWriter;

    public SocketWrapper(Socket socket) throws Exception{
        this.socket = socket;
        this.inputStream = socket.getInputStream();
        this.inpuReader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
        this.outputWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
    }

    public String readLine() throws Exception{
        return inpuReader.readLine();
    }

    public void writeLine(String line) throws Exception{
        outputWriter.write(line + '\n');
        outputWriter.flush();
    }

    public void close(){
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
