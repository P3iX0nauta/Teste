module edu.ifba.saj.ads.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ifba.saj.ads.poo to javafx.fxml;
    opens edu.ifba.saj.ads.poo.controller to javafx.fxml;
    opens edu.ifba.saj.ads.poo.model to javafx.fxml, javafx.base;
    exports edu.ifba.saj.ads.poo;
}
