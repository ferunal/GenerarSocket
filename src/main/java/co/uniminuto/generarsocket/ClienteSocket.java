/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.generarsocket;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fercris
 */
public class ClienteSocket {
    public static void main(String[] args) {
        try {
            Socket socket = null;
            String host = "172.17.1.2";
            
            socket = new Socket(host, 11207);
            
//            File file = new File("f:\\copiag\\test.xml");
            // Get the size of the file
//            long length = file.length();
            Path pathArchSalida=Paths.get("f:","copiag","test.xml");
          
            InputStream in =socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStream salida=socket.getOutputStream();
            String strDatoSocket="1*111*";
           byte[] bytesPeticion = strDatoSocket.getBytes();
            int count;
            while ((count = in.read(bytesPeticion)) > 0) {
                salida.write(bytesPeticion, 0, count);
            }
            byte[] respuesta=new byte[Integer.MAX_VALUE];
            in.read(bytesPeticion);
            System.out.println("Respuesta= "+respuesta);
            
            baos.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
