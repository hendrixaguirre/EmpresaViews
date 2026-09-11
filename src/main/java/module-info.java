module ni.edu.uam.empresaviews {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.empresaviews to javafx.fxml;
    exports ni.edu.uam.empresaviews;
    opens ni.edu.uam.empresaviews.controller to javafx.fxml;
}