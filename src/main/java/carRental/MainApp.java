package carRental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Scene.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        stage.setTitle("Wypożyczalnia samochodów");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
