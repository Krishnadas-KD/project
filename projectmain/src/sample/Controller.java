package sample;



import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.security.cert.PolicyNode;

public class Controller {

    public TextField userfeild;
    public Button LogineB;
    public ImageView useric;
    public ImageView CloseB2;
    public TextField passfeild;
    public ImageView passic;
    public ImageView closeB1;
    public ImageView loginesic;
    public Label warning;
    public Pane pane2;

    public StackPane stack1;
    public StackPane stack2;

    public ImageView slider1;
    public ImageView image2;
    public ImageView Bu2;
    public ImageView Bu1;

    public Button GOpage1;
    public Button GOpage2;
    public ImageView image1;


    public void checkuser(MouseEvent mouseEvent) {
        warning.setVisible(false);
        if(userfeild.getText().equals("Admin")){

            ColorAdjust col=new ColorAdjust();
            col.setHue(.70);
            useric.setEffect(col);
            userfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        else
        {
            ColorAdjust col=new ColorAdjust();
            col.setHue(0);
            useric.setEffect(col);
            userfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){

            Image image = new Image(getClass().getResourceAsStream("/img/unclock.png"));
            loginesic.setImage(image);

            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("/img/locked.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-width: 2; -fx-border-radius: 30;");

        }


    }

    public void closeclick(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void closeenter(MouseEvent mouseEvent) {
        CloseB2.setVisible(false);
        closeB1.setVisible(true);
    }

    public void closeexit(MouseEvent mouseEvent) {
        CloseB2.setVisible(true);
        closeB1.setVisible(false);
    }

    public void checkpass(MouseEvent mouseEvent) {
        warning.setVisible(false);
        if (passfeild.getText().equals("Admin")) {
            ColorAdjust col = new ColorAdjust();
            col.setHue(.70);
            passic.setEffect(col);
            passfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        else{
            ColorAdjust col=new ColorAdjust();
            col.setHue(0);
            passic.setEffect(col);
            passfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){

            Image image = new Image(getClass().getResourceAsStream("/img/unclock.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("/img/locked.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-width: 2; -fx-border-radius: 30;");

        }
    }
    public void logmouseenter(MouseEvent mouseEvent) {
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")) {
            ColorAdjust ss = new ColorAdjust();
            ss.setBrightness(-1.0);
            loginesic.setEffect(ss);
            LogineB.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 30; -fx-border-color: #ffffff; -fx-border-width: 2; -fx-border-radius: 30;");
        }
    }

    public void logmouseexit(MouseEvent mouseEvent) {
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")) {
            ColorAdjust ss = new ColorAdjust();
            ss.setBrightness(0);
            loginesic.setEffect(ss);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
    }

    public void loginescuss(ActionEvent actionEvent) throws IOException {

        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){
            Parent root1 = FXMLLoader.load(getClass().getResource("page1.fxml"));
            Scene scene=new Scene(root1, 647.5,375);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.setTitle("Choose");
            scene.setFill(Color.TRANSPARENT);
            stage1.initStyle(StageStyle.TRANSPARENT);
            stage1.show();


        }
        else {
             warning.setVisible(true);

                }
            }

    public void change2(MouseEvent mouseEvent) throws IOException {



            Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
            Scene scene = Bu2.getScene();
            root.translateXProperty().set(-1*scene.getWidth());
            stack2.getChildren().add(root);
            System.out.println("1");
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        System.out.println("2");
        Bu2.setVisible(false);
        image2.setVisible(false);
        GOpage2.setVisible(false);
        System.out.println("3");
        Bu1.setVisible(true);
        image1.setVisible(true);
        GOpage1.setVisible(true);


        }


    public void imcolorchange1(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.5);
        Bu1.setEffect(ss);
    }

    public void chnage1(MouseEvent mouseEvent) throws IOException {



        Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        Scene scene = Bu1.getScene();
        root.translateXProperty().set(scene.getWidth());
        stack1.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        GOpage1.setVisible(false);
        Bu1.setVisible(false);
        image1.setVisible(false);

        Bu2.setVisible(true);
        image2.setVisible(true);
        GOpage2.setVisible(true);

    }

    public void imcolorchange2(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.5);
        Bu2.setEffect(ss);
    }

    public void imcolorchange15(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        Bu1.setEffect(ss);
    }

    public void imcolorchange25(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        Bu2.setEffect(ss);
    }

    public void gotoArts(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("Arts/Arts.fxml"));

        Scene scene=new Scene(root1);
        Stage stage1=new Stage();
        stage1.setScene(scene);
        stage1.setTitle("Arts");
        scene.setFill(Color.TRANSPARENT);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.show();

    }

    public void gotoSports(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("Sports/Sports.fxml"));
        Scene scene=new Scene(root1);
        Stage stage1=new Stage();
        stage1.setScene(scene);
        stage1.setTitle("Sports");
        scene.setFill(Color.TRANSPARENT);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.show();
    }
}



