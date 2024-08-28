import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;


public class PrintHandler implements EventHandler<ActionEvent> {
    private final TextArea textArea;

    public PrintHandler(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void handle(ActionEvent event) {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null) {
            boolean success = printerJob.printPage(textArea);
            if (success) {
                printerJob.endJob();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to print the document.", ButtonType.OK);
                alert.setTitle("Print Error");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No printer available.", ButtonType.OK);
            alert.setTitle("Print Error");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
}
