package com.example.demo.tcpclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class TcpClient implements CommandLineRunner {

    private static final String SERVER_IP = "172.22.96.124";
    private static final int SERVER_PORT = 12345;

    @Override
    public void run(String... args) throws Exception {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        OutputStream outputStream = socket.getOutputStream();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    String message = "Hello\n";
                    outputStream.write(message.getBytes());
                    outputStream.flush();
                    System.out.println("Sent: " + message.trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000); // 每 2 秒发送一次
    }
}
