package io.github.astonbitecode.xdgopen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Launch browser");

        VBox vbox = new VBox(8);

        Button openWithJavaFx = new Button("Open Browser using JavaFX");
        openWithJavaFx.setOnAction(ev -> getHostServices().showDocument("https://snapcraft.io/"));
        Button openWithXdg = new Button("Open Browser using xdg-open");
        openWithXdg.setOnAction(ev -> {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("xdg-open", "https://snapcraft.io/");
            try {
                processBuilder.start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        vbox.getChildren().addAll(openWithJavaFx, openWithXdg);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
