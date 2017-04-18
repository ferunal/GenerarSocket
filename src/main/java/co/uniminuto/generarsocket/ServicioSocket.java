/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.generarsocket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fercris
 */
public class ServicioSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = null;
            
            try {
                serverSocket = new ServerSocket(4444);
            } catch (IOException ex) {
                System.out.println("Can't setup server on this port number. ");
            }
            
            Socket socket = null;
            byte[] arrByteDatosArch= Files.readAllBytes(Paths.get("F:", "copiag","test2.xml"));
            //InputStream in = Files.newInputStream(, LinkOption.NOFOLLOW_LINKS);
            OutputStream out = null;
            
            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                System.out.println("Can't accept client connection. ");
            }
            
            
            
            try{
             out = socket.getOutputStream();
             out.write(arrByteDatosArch);
             
            }catch(IOException ex){
               System.out.println("Error al enviar dato. ");
            }
//            try {
//                in = socket.getInputStream();
//               
//                
//            } catch (IOException ex) {
//                System.out.println("Can't get socket input stream. ");
//            }
            
//            try {
//                out = new FileOutputStream("f:\\copiag\\test2.xml");
//            } catch (FileNotFoundException ex) {
//                System.out.println("File not found. ");
//            }
            
//            byte[] bytes = new byte[16*1024];
            
//            int count;
//            while ((count = in.read(bytes)) > 0) {
//                out.write(bytes, 0, count);
//            }
            
            out.close();
//            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServicioSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
