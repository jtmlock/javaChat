import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IntegratedApplication extends Application {

    private CheckBox chargersBox;
    private CheckBox carryingCaseBox;
    private CheckBox anywhereLockerBox;
    private CheckBox chromebooksBox;
    private CheckBox otherBox;
    private CheckBox ipadsBox;
    private CheckBox headphonesBox;

    private TextField chargersQty;
    private TextField carryingCaseQty;
    private TextField anywhereLockerQty;
    private TextField chromebooksQty;
    private TextField otherQty;
    private TextField ipadsQty;
    private TextField headphonesQty;

    private TextField schoolField;
    private TextField driverField;
    private TextField signatureField;
    private TextField dateField;
    private TextField timeField;

    @Override
    public void start(Stage primaryStage) {
        // Create checkboxes and quantity fields
        chargersBox = new CheckBox("Chargers");
        carryingCaseBox = new CheckBox("Carrying Case");
        anywhereLockerBox = new CheckBox("Anywhere Locker");
        chromebooksBox = new CheckBox("Chromebooks");
        otherBox = new CheckBox("Other");
        ipadsBox = new CheckBox("Ipads");
        headphonesBox = new CheckBox("Headphones");

        chargersQty = new TextField();
        carryingCaseQty = new TextField();
        anywhereLockerQty = new TextField();
        chromebooksQty = new TextField();
        otherQty = new TextField();
        ipadsQty = new TextField();
        headphonesQty = new TextField();

        schoolField = new TextField();
        driverField = new TextField();
        signatureField = new TextField();
        dateField = new TextField();
        timeField = new TextField();

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // Set button actions
        submitButton.setOnAction(event -> openDeliveryManifestStage());
        cancelButton.setOnAction(event -> primaryStage.close());

        // Layout for the initial stage
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add checkboxes and quantity fields to the grid pane
        gridPane.add(chargersBox, 0, 0);
        gridPane.add(chargersQty, 1, 0);
        gridPane.add(new Label("(qty:)"), 2, 0);

        gridPane.add(carryingCaseBox, 0, 1);
        gridPane.add(carryingCaseQty, 1, 1);
        gridPane.add(new Label("(qty:)"), 2, 1);

        gridPane.add(anywhereLockerBox, 0, 2);
        gridPane.add(anywhereLockerQty, 1, 2);
        gridPane.add(new Label("(qty:)"), 2, 2);

        gridPane.add(chromebooksBox, 0, 3);
        gridPane.add(chromebooksQty, 1, 3);
        gridPane.add(new Label("(qty:)"), 2, 3);

        gridPane.add(otherBox, 0, 4);
        gridPane.add(otherQty, 1, 4);
        gridPane.add(new Label("(qty:)"), 2, 4);

        gridPane.add(ipadsBox, 1, 0);
        gridPane.add(ipadsQty, 2, 0);
        gridPane.add(new Label("(qty:)"), 3, 0);

        gridPane.add(headphonesBox, 1, 1);
        gridPane.add(headphonesQty, 2, 1);
        gridPane.add(new Label("(qty:)"), 3, 1);

        gridPane.add(submitButton, 2, 5);
        gridPane.add(cancelButton, 3, 5);

        // Create and show the initial scene
        Scene scene = new Scene(gridPane, 900, 750); // Increased size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Items");
        primaryStage.show();
    }

    private void openDeliveryManifestStage() {
        Stage manifestStage = new Stage();

        // Create labels and text area
        Label titleLabel = new Label("User Support Services");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label subtitleLabel = new Label("Projects & Deployment Pickup Delivery Itinerary");
        subtitleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextArea manifestArea = new TextArea();
        manifestArea.setEditable(false);
        manifestArea.setWrapText(true);

        Button printButton = new Button("Print");
        Button closeButton = new Button("Close");

        // Set button actions
        printButton.setOnAction(event -> printManifest(manifestArea.getText()));
        closeButton.setOnAction(event -> manifestStage.close());

        // Create layout for the delivery manifest stage
        VBox vbox = new VBox(15, titleLabel, subtitleLabel, manifestArea, printButton, closeButton);
        vbox.setPrefSize(1200, 1000); // Increased size
        vbox.setStyle("-fx-padding: 15;");

        // Set the selected items to the text area
        manifestArea.setText(getSelectedItems());

        // Create and show the delivery manifest scene
        Scene manifestScene = new Scene(vbox);
        manifestStage.setScene(manifestScene);
        manifestStage.setTitle("Delivery Manifest");
        manifestStage.show();
    }

    private String getSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        appendItem(selectedItems, chargersBox, chargersQty);
        appendItem(selectedItems, carryingCaseBox, carryingCaseQty);
        appendItem(selectedItems, anywhereLockerBox, anywhereLockerQty);
        appendItem(selectedItems, chromebooksBox, chromebooksQty);
        appendItem(selectedItems, otherBox, otherQty);
        appendItem(selectedItems, ipadsBox, ipadsQty);
        appendItem(selectedItems, headphonesBox, headphonesQty);

        // Add additional fields
        selectedItems.append("\nSchool: ").append(schoolField.getText()).append("\n");
        selectedItems.append("Driver: ").append(driverField.getText()).append("\n");
        selectedItems.append("Signature: ").append(signatureField.getText()).append("\n");
        selectedItems.append("Date: ").append(dateField.getText()).append(" Time: ").append(timeField.getText()).append("\n");

        return selectedItems.toString();
    }

    private void appendItem(StringBuilder sb, CheckBox checkBox, TextField qtyField) {
        if (checkBox.isSelected()) {
            sb.append(checkBox.getText()).append(" (qty: ").append(qtyField.getText()).append(")\n");
        }
    }

    private void printManifest(String text) {
        // Implement print functionality here
        System.out.println("Printing delivery manifest:\n" + text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
