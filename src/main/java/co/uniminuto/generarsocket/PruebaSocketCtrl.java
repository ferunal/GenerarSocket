/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.generarsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author fercris
 */
public class PruebaSocketCtrl extends Application implements Initializable {

    ServerSocket serverSocket = null;
    Socket socket = null;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void btnGenArch_AE(ActionEvent ae) {

    }

    /**
     * Initializes the controller class.
     *
     * @param stage
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // stage.getIcons().add(imgFavIcon);
        stage.setTitle("SEAQ");
        stage.initStyle(StageStyle.DECORATED);

        BorderPane move = new BorderPane();

        move.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        move.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PruebaSocket.fxml"));
        move.getChildren().add(root);
        move.setStyle("-fx-background-color:white;-fx-border-color:black;-fx-border-width:1");
        Scene scene = new Scene(move, 529, 594);
        stage.setScene(scene);
        stage.show();
        try {
            aceptarConSocket();
        } catch (IOException ex) {
            Logger.getLogger(PruebaSocketCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarComponentes() {

    }

    private void aceptarConSocket() throws IOException {
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Socket creado");

        } catch (IOException e) {
            System.err.println("Error al inical el socket");
        }
        socket = serverSocket.accept();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarComponentes();

    }

}
