import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeliveryManifest extends Application {
    private TextArea manifestArea;

    @Override
    public void start(Stage primaryStage) {
        // Create components
        Label label = new Label("Delivery Manifest");
        manifestArea = new TextArea();
        manifestArea.setEditable(false);

        // Create buttons
        Button printButton = new Button("Print");
        Button closeButton = new Button("Close");

        // Set button actions
        printButton.setOnAction(event -> printManifest());
        closeButton.setOnAction(event -> primaryStage.close());

        // Create layout
        VBox vbox = new VBox(10, label, manifestArea, printButton, closeButton);
        vbox.setPrefSize(400, 300);

        // Create scene
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delivery Manifest");
        primaryStage.show();
    }

    private void printManifest() {
        // Implement print functionality here
        // For simplicity, we'll just print a placeholder message
        System.out.println("Printing delivery manifest...");
    }

    public void setManifestText(String text) {
        manifestArea.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
