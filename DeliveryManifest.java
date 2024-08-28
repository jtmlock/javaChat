import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DeliveryManifest extends Application {
    @Override
    public void start(Stage primaryStage) {
        // First Window
        StackPane firstWindowLayout = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Title
        Label titleLabel1 = new Label("User Support Services");
        titleLabel1.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        Label titleLabel2 = new Label("Projects & Deployment Delivery Itinerary");
        titleLabel2.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");

        gridPane.add(titleLabel1, 0, 0, 2, 1);
        gridPane.add(titleLabel2, 0, 1, 2, 1);

        // Checkboxes and Quantity Text Fields
        String[] checkBoxLabels = {"Chargers", "Carrying Case", "Anywhere Locker", "Chromebooks", "Other",
                "Ipads", "Headphones"};
        CheckBox[] checkBoxes = new CheckBox[checkBoxLabels.length];
        TextField[] qtyFields = new TextField[checkBoxLabels.length];

        for (int i = 0; i < checkBoxLabels.length; i++) {
            checkBoxes[i] = new CheckBox(checkBoxLabels[i]);
            qtyFields[i] = new TextField();
            qtyFields[i].setPromptText("Qty");
            qtyFields[i].setPrefWidth(60);
            qtyFields[i].setMaxWidth(60);
            qtyFields[i].setMaxHeight(30);
            qtyFields[i].setTextFormatter(new TextFormatter<>(change -> {
                if (change.getControlNewText().matches("\\d{0,3}")) {
                    return change;
                }
                return null;
            }));
            gridPane.add(checkBoxes[i], 0, i + 2);
            gridPane.add(new Label("(qty:"), 1, i + 2);
            gridPane.add(qtyFields[i], 2, i + 2);
        }

        // School, Driver, Signature, Date, and Time
        Label schoolLabel = new Label("School:");
        TextField schoolField = new TextField();
        Label driverLabel = new Label("Driver:");
        TextField driverField = new TextField();
        Label signatureLabel = new Label("Signature:");
        TextField signatureField = new TextField();
        Label dateLabel = new Label("Date:");
        TextField dateField = new TextField();
        Label timeLabel = new Label("Time:");
        TextField timeField = new TextField();

        gridPane.add(schoolLabel, 0, 10);
        gridPane.add(schoolField, 1, 10);
        gridPane.add(driverLabel, 0, 11);
        gridPane.add(driverField, 1, 11);
        gridPane.add(signatureLabel, 0, 12);
        gridPane.add(signatureField, 1, 12);
        gridPane.add(dateLabel, 0, 13);
        gridPane.add(dateField, 1, 13);
        gridPane.add(timeLabel, 0, 14);
        gridPane.add(timeField, 1, 14);

        // Submit and Close Buttons
        Button submitButton = new Button("Submit");
        Button closeButton = new Button("Close");

        submitButton.setOnAction(e -> handleSubmit(primaryStage, checkBoxes, qtyFields, schoolField, driverField, signatureField, dateField, timeField));
        closeButton.setOnAction(e -> primaryStage.close());

        gridPane.add(submitButton, 0, 15);
        gridPane.add(closeButton, 1, 15);

        // Image Background
        Image image = new Image("file:your-image-path.png"); // Replace with your image path
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, backgroundSize);
        Background background = new Background(backgroundImage);
        firstWindowLayout.setBackground(background);
        firstWindowLayout.getChildren().add(gridPane);

        Scene firstScene = new Scene(firstWindowLayout, 1200, 900);
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Delivery Manifest - Initial Form");
        primaryStage.show();
    }

    private void handleSubmit(Stage primaryStage, CheckBox[] checkBoxes, TextField[] qtyFields, TextField schoolField, TextField driverField, TextField signatureField, TextField dateField, TextField timeField) {
        // Second Window
        Stage secondStage = new Stage();
        StackPane secondWindowLayout = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Title
        Label titleLabel1 = new Label("User Support Services");
        titleLabel1.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        Label titleLabel2 = new Label("Projects & Deployment Delivery Itinerary");
        titleLabel2.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");

        gridPane.add(titleLabel1, 0, 0, 2, 1);
        gridPane.add(titleLabel2, 0, 1, 2, 1);

        // Checkboxes and Quantity Display
        String[] checkBoxLabels = {"Chargers", "Carrying Case", "Anywhere Locker", "Chromebooks", "Other",
                "Ipads", "Headphones"};

        for (int i = 0; i < checkBoxLabels.length; i++) {
            CheckBox checkBox = new CheckBox(checkBoxLabels[i]);
            TextField qtyField = new TextField();

            // Check if checkbox is selected or quantity is provided
            if (checkBoxes[i].isSelected() || !qtyFields[i].getText().isEmpty()) {
                checkBox.setSelected(true);
                qtyField.setText(qtyFields[i].getText());
            } else {
                checkBox.setSelected(false);
                qtyField.setText("");
            }

            // Add to layout
            gridPane.add(checkBox, 0, i + 2);
            gridPane.add(new Label("(qty:"), 1, i + 2);
            gridPane.add(qtyField, 2, i + 2);
        }

        // School, Driver, Signature, Date, and Time
        Label schoolLabel = new Label("School: ");
        Label driverLabel = new Label("Driver: ");
        Label signatureLabel = new Label("Signature: ");
        Label dateLabel = new Label("Date: ");
        Label timeLabel = new Label("Time: ");

        gridPane.add(schoolLabel, 0, 10);
        gridPane.add(new Label(schoolField.getText()), 1, 10);
        gridPane.add(driverLabel, 0, 11);
        gridPane.add(new Label(driverField.getText()), 1, 11);
        gridPane.add(signatureLabel, 0, 12);
        gridPane.add(new Label(signatureField.getText()), 1, 12);
        gridPane.add(dateLabel, 0, 13);
        gridPane.add(new Label(dateField.getText()), 1, 13);
        gridPane.add(timeLabel, 0, 14);
        gridPane.add(new Label(timeField.getText()), 1, 14);

        // Print and Close Buttons
        Button printButton = new Button("Print");
        Button closeButton = new Button("Close");

        printButton.setOnAction(e -> handlePrint());
        closeButton.setOnAction(e -> secondStage.close());

        gridPane.add(printButton, 0, 15);
        gridPane.add(closeButton, 1, 15);

        // Image Background
        Image image = new Image("file:/C:/Users/smitha15/Desktop/java/Ccsd_logo.jpg"); // Replace with your image path
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, backgroundSize);
        Background background = new Background(backgroundImage);
        secondWindowLayout.setBackground(background);
        secondWindowLayout.getChildren().add(gridPane);

        Scene secondScene = new Scene(secondWindowLayout, 1200, 900);
        secondStage.setScene(secondScene);
        secondStage.setTitle("Delivery Manifest - Final Form");
        secondStage.show();
    }

    private void handlePrint() {
        // Implement print functionality here
        System.out.println("Print functionality not implemented.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
