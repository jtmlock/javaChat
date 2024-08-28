import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterimStage extends Application {

    private CheckBox chargersBox;
    private CheckBox carryingCaseBox;
    private CheckBox anywhereLockerBox;
    private CheckBox chromebooksBox;
    private CheckBox otherBox;
    private CheckBox ipadsBox;
    private CheckBox headphonesBox;

    @Override
    public void start(Stage primaryStage) {
        // Initialize checkboxes
        chargersBox = new CheckBox("Chargers");
        carryingCaseBox = new CheckBox("Carrying Case");
        anywhereLockerBox = new CheckBox("Anywhere Locker");
        chromebooksBox = new CheckBox("Chromebooks");
        otherBox = new CheckBox("Other");
        ipadsBox = new CheckBox("Ipads");
        headphonesBox = new CheckBox("Headphones");

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // Set button actions
        submitButton.setOnAction(event -> {
            String selectedItems = getSelectedItems();
            DeliveryManifest manifest = new DeliveryManifest();
            manifest.setManifestText(selectedItems);
            manifest.start(new Stage()); // Open DeliveryManifest
            primaryStage.close();
        });

        cancelButton.setOnAction(event -> primaryStage.close());

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add checkboxes to the grid pane
        gridPane.add(chargersBox, 0, 0);
        gridPane.add(carryingCaseBox, 0, 1);
        gridPane.add(anywhereLockerBox, 0, 2);
        gridPane.add(chromebooksBox, 0, 3);
        gridPane.add(otherBox, 0, 4);
        gridPane.add(ipadsBox, 1, 0);
        gridPane.add(headphonesBox, 1, 1);
        gridPane.add(submitButton, 1, 2);
        gridPane.add(cancelButton, 1, 3);

        // Create scene
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select Items");
        primaryStage.show();
    }

    private String getSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        if (chargersBox.isSelected()) selectedItems.append("Chargers\n");
        if (carryingCaseBox.isSelected()) selectedItems.append("Carrying Case\n");
        if (anywhereLockerBox.isSelected()) selectedItems.append("Anywhere Locker\n");
        if (chromebooksBox.isSelected()) selectedItems.append("Chromebooks\n");
        if (otherBox.isSelected()) selectedItems.append("Other\n");
        if (ipadsBox.isSelected()) selectedItems.append("Ipads\n");
        if (headphonesBox.isSelected()) selectedItems.append("Headphones\n");
        return selectedItems.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
