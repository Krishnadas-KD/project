package sample.Arts;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import java.io.IOException;

public class Controller {
    public Button studententry;
    public StackPane stackc;
    public Button winnerentry;
    public ImageView closegreen;
    public ImageView closered;
    public ImageView image2;

    public Button printBU;

    public Pane printPane;
    public Pane panel;


    public void gostudententry(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        stackc.getChildren().add(root);

    }

    public void gowinnerentry(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        stackc.getChildren().add(root);
    }

    public void gotoprinter(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("page3.fxml"));
        stackc.getChildren().add(root);
    }

    public void closeprogram(MouseEvent mouseEvent) {
System.exit(0);

    }

    public void closeentry(MouseEvent mouseEvent) {
        closered.setVisible(true);
        closegreen.setVisible(false);
    }

    public void closeecite(MouseEvent mouseEvent) {
        closered.setVisible(false);
        closegreen.setVisible(true);

    }

    public void printit(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("page3.fxml"));
        doPrintSecond(root);

        //Second Method
        if (doPrint(panel)) {
            System.out.println("Print");
        } else {
            System.out.println("error");
        }
    }

    //First
    void doPrintSecond(Node panel) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            //boolean printed = job.printPage(panel);
           // if (printed) {
           //     job.endJob();
           // } else {
           //     System.out.print("Faled");

          //  }
      //  } else {
            System.out.print("could");

        }
    }
    //Second
    boolean doPrint(Node panel) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job == null) {
            System.out.println("1");
            return false;
        }
        if (!job.showPrintDialog(null)) {
            System.out.println("2");
            return false;
        }
        if (!job.printPage(panel)) {
            System.out.println("3");
            return false;
        }
        return job.endJob();

    }

    public void printActionPane(ActionEvent actionEvent) {
    }
}
