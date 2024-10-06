package front;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void main(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX !");
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Librairie Elite");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
