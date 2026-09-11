package ni.edu.uam.empresaviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuApplication.class.getResource("/ni/edu/uam/empresaviews/menu-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menú Principal");
        stage.setScene(scene);
        stage.show();
    }
}
