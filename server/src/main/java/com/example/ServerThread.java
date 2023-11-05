package com.example;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{

    Socket s;
    public ServerThread(Socket s){
        this.s = s;
    }
    public void run()
    {
        try {
        int rand = (int) (Math.random() * 100) +1;
        System.out.println(rand);
        System.out.println("Server avviato");
        System.out.println("Un client si è connesso");
    
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String numeroRicevuto;
        int num = 0;
        int tentativi = 0;
        do {
            tentativi++;
            numeroRicevuto = in.readLine();
            num = Integer.parseInt(numeroRicevuto);
            System.out.println("Il client ha inviato " + numeroRicevuto);
            if(num > rand && num != 0)
            {
                System.out.println("1");
                out.writeBytes("1" + '\n');
            }
            else if(num < rand && num != 0)
            {
                System.out.println("2");
                out.writeBytes("2" + '\n');
            }
            else if(num > 100 || num == 0)
            {
                System.out.println("3");
                out.writeBytes("3" + '\n');
            }
        } while (num != rand);
            System.out.println("4");
            out.writeBytes("4" + '\n');
            System.out.println(tentativi);
            s.close();
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
            System.exit(1);
        }
    } 
}