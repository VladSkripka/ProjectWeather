package sample;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getData;

    @FXML
    private TextField city;

    @FXML
    private Text temperature;

    @FXML
    private Text feelslike;

    @FXML
    private Text visibility;

    @FXML
    private Text humidity;

    @FXML
    private Text pressure;

    @FXML
    void initialize() {
        getData.setOnAction(actionEvent -> {
            String usersCity = city.getText().trim();
            String output = getContent("http://api.openweathermap.org/data/2.5/weather?q="+usersCity+"&appid=9aa56c780cc99d8b8091d128dd348bb2&units=metric");

            if(!output.isEmpty()){
                JSONObject obj = new JSONObject(output);
                temperature.setText("Температура: "+obj.getJSONObject("main").getDouble("temp"));
                feelslike.setText("Відчувається: "+obj.getJSONObject("main").getDouble("feels_like"));
                visibility.setText("Видимість: "+obj.getDouble("visibility"));
                humidity.setText("Вологість: "+obj.getJSONObject("main").getDouble("humidity"));
                pressure.setText("Тиск: "+obj.getJSONObject("main").getDouble("pressure"));

            }

        });
    }

    private static String getContent(String urlAdress){

        StringBuffer content = new StringBuffer();
        try{
          URL url = new URL (urlAdress);
          URLConnection urlCon = url.openConnection();
          BufferedReader bufRead = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
          String line;
          while ((line = bufRead.readLine())!=null){
              content.append(line + "\n");
          }
          bufRead.close();
        }
        catch(Exception e){
            System.out.print("Oh no, problem");
        }
        return content.toString();
    }

}
