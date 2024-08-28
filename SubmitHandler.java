import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class SubmitHandler implements EventHandler<ActionEvent> {
    private Stage primaryStage;
    private CheckBox[] checkBoxes;
    private TextField[] qtyFields;
    private TextField schoolField, driverField, signatureField, dateField, timeField;

    public SubmitHandler(Stage primaryStage, CheckBox cb1, TextField qty1,
                         CheckBox cb2, TextField qty2, CheckBox cb3, TextField qty3,
                         CheckBox cb4, TextField qty4, CheckBox cb5, TextField qty5,
                         CheckBox cb6, TextField qty6, CheckBox cb7, TextField qty7,
                         TextField schoolField, TextField driverField,
                         TextField signatureField, TextField dateField, TextField timeField) {
        this.primaryStage = primaryStage;
        this.checkBoxes = new CheckBox[]{cb1, cb2, cb3, cb4, cb5, cb6, cb7};
        this.qtyFields = new TextField[]{qty1, qty2, qty3, qty4, qty5, qty6, qty7};
        this.schoolField = schoolField;
        this.driverField = driverField;
        this.signatureField = signatureField;
        this.dateField = dateField;
        this.timeField = timeField;
    }

    @Override
    public void handle(ActionEvent event) {
        // Create the second window
        Stage secondStage = new Stage();

        // Load image with transparency
        Image image = new Image("file:/C:/Users/smitha15/Desktop/java/Ccsd_logo.jpg"); // Update path accordingly
        ImageView imageView = new ImageView(image);
        imageView.setOpacity(0.5); // Make the image more translucent

        // Title and Labels for second window
        Label title1 = new Label("User Support Services");
        title1.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        Label title2 = new Label("Projects & Deployment Delivery Itinerary");
        title2.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        // Display Information
        VBox checkBoxesInfo = new VBox(10);
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected() || !qtyFields[i].getText().isEmpty()) {
                Label infoLabel = new Label(checkBoxes[i].getText() + " (Qty: " + qtyFields[i].getText() + ")");
                infoLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
                checkBoxesInfo.getChildren().add(infoLabel);
            }
        }

        // Display Additional Information
        VBox additionalInfo = new VBox(10,
            new Label("School: " + schoolField.getText()),
            new Label("Driver: " + driverField.getText()),
            new Label("Signature: " + signatureField.getText()),
            new Label("Date: " + dateField.getText() + " Time: " + timeField.getText())
        );
        additionalInfo.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        // Layout setup
        VBox root = new VBox(20, title1, title2, checkBoxesInfo, additionalInfo);
        root.setAlignment(Pos.CENTER);

        // Background Image
        BackgroundImage backgroundImage = new BackgroundImage(image,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(backgroundImage));

        // Buttons
        Button printButton = new Button("Print");
        Button closeButton = new Button("Close");

        printButton.setOnAction(e -> {
            // Print logic goes here
        });

        closeButton.setOnAction(e -> secondStage.close());

        HBox buttonBox = new HBox(10, printButton, closeButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox finalLayout = new VBox(20, root, buttonBox);
        finalLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(finalLayout, 1200, 800); // Same size as first window
        secondStage.setScene(scene);
        secondStage.setTitle("Delivery Manifest");
        secondStage.show();
    }
}
