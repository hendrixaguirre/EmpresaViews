package ni.edu.uam.empresaviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicioApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServicioApplication.class.getResource("/ni/edu/uam/empresaviews/solicitud-servicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Solicitud Servicio");
        stage.setScene(scene);
        stage.show();
    }
}
