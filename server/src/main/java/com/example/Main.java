package com.example;

import java.net.*;

public class Main {
    public static void main( String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        while(true)
        {
            Socket s = ss.accept();
            ServerThread thread = new ServerThread(s);
            thread.start();
        }
    }
}