import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CurrencyConverterGUI extends Application {
public void start(Stage stage) {

        Button exchange = new Button("Exchange");
        Label inputValue = new Label("Input value: $");
        TextField userInput = new TextField();
        Label result = new Label();

        exchange.setOnAction(event -> {
                        String inputString = userInput.getCharacters().toString();
                        try{
                                double input = Double.parseDouble(inputString);
                                double converted = convert(input);
                                result.setText(String.format("%.2f", converted));
                        }
                        catch (NumberFormatException e) {
                                Alert a = new Alert(Alert.AlertType.ERROR);
                                a.setTitle("Error");
                                a.setHeaderText("Invalid Dollar Amount");
                                a.setContentText("Please use only digits.");
                                a.showAndWait();
                        }
                });

        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren().addAll(inputValue, userInput);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(input, exchange, result);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Dollars to Shekel");
        stage.setScene(scene);
        stage.show();
}

private double convert(double input) {
        double output = input * 3.16;
        return output;
}
}
