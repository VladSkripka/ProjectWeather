package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller {

    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;

    @FXML
    private Button getData;

    @FXML
    public TextField city;

    @FXML
    public Text temperature;

    @FXML
    public Text feelslike;

    @FXML
    public Text visibility;

    @FXML
    public Text probablyOfRain;

    @FXML
    public Text pressure;

    @FXML
    void initialize() {
        getData.setOnAction(actionEvent -> {
            System.out.print("JR");

        });
    }
}
