package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

// Farben:  siehe sample/Farben.png
//          #222614 blauschwarz (Schrift)
//          #355B8C blaugrau dunkel
//          #5684BF blaugrau hell
//          #82B0D9 hellblau
//          #ADD4D9 türkis
//          #090a0c Button schwarz

public class Main extends Application {
    // static ArrayList<Kontakt> kontaktDatenList = new ArrayList<>();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DbKontakte.load();
        try {
            primaryStage.setTitle("Kontaktbuch");



// Erstellen eines neuen BorderPane Objektes
            BorderPane root = new BorderPane();
            //root.setPadding(new Insets(10, 20, 10, 20));


// Style aus app.css wird eingelesen
            root.getStyleClass().add("gridstyle");

// Borderpane Top
            //  HBox erstellen...
            VBox topVBox = new VBox();
            // topVBox.setSpacing(10);
            topVBox.setPadding(new Insets(10, 20, 10, 20));
            topVBox.setStyle("-fx-background-color: #355B8C;");
            //  ...und im TopBereich einbinden
            root.setTop(topVBox);

            // Label erstellen und einbinden
            Label proglabel = new Label("AdressbuchFX");
            topVBox.getChildren().add(proglabel);

            proglabel.setFont(Font.font("Cambria", 28));
            proglabel.setTextFill(Color.web("#5684BF"));

            Effect glow = new Glow(0.8);
            proglabel.setEffect(glow);

            Line topLine = new Line(0, 40, 350, 40);
            topVBox.getChildren().add(topLine);
            // Stroke Width
            topLine.setStrokeWidth(2);
            topLine.setStroke(Color.web("#5684BF"));//#ADD4D9
            topLine.setEffect(glow);

// Borderpane Center
            VBox vBoxCenter = new VBox();
            root.setCenter(vBoxCenter);
            vBoxCenter.setPadding(new Insets(20));
            vBoxCenter.setSpacing(10);
            vBoxCenter.setStyle("-fx-background-color: #82B0D9;");

                Label centerlabelSuche = new Label("Suche");
                centerlabelSuche.setFont(Font.font("Cambria", 20));
                vBoxCenter.getChildren().add(centerlabelSuche);

                TextField suche = new TextField();
                suche.setMaxWidth(300);
                suche.setPromptText("Nachname");
                vBoxCenter.getChildren().add(suche);


                Button btnSuche = new Button("suchen");
                btnSuche.setPrefSize(80, 30);
                vBoxCenter.getChildren().add(btnSuche);

                Label label = new Label();
                vBoxCenter.getChildren().add(label);

                VBox vboxAction = new VBox();
                vboxAction.setSpacing(10);
                vBoxCenter.getChildren().add(vboxAction);

                    Label centerlabelNeu = new Label("Neuer Kontakt");
                    centerlabelNeu.setFont(Font.font("Cambria", 20));
                    vboxAction.getChildren().add(centerlabelNeu);

                    Button btnNeu = new Button("+");
                    btnNeu.setPrefSize(80, 30);
                    vboxAction.getChildren().add(btnNeu);

                    VBox vBoxKontaktDetails = new VBox();
                    vBoxKontaktDetails.setPadding(new Insets(10));
                    vBoxKontaktDetails.setSpacing(20);
                    vboxAction.getChildren().add(vBoxKontaktDetails);

                    vBoxKontaktDetails.setVisible(false);

                        TextField vornameNew = new TextField();
                        vornameNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(vornameNew);

                        TextField nameNew = new TextField();
                        nameNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(nameNew);

                        TextField plzNew = new TextField();
                        plzNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(plzNew);

                        TextField ortNew = new TextField();
                        ortNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(ortNew);

                        TextField strasseNrNew = new TextField();
                        strasseNrNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(strasseNrNew);

                        TextField telNrNew = new TextField();
                        telNrNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(telNrNew);

                        TextField mailNew = new TextField();
                        mailNew.setMaxWidth(300);
                        vBoxKontaktDetails.getChildren().add(mailNew);

                        HBox hboxNeuerKontaktAction = new HBox();
                        hboxNeuerKontaktAction.setSpacing(17);
                        vBoxKontaktDetails.getChildren().add(hboxNeuerKontaktAction);

                        Button btnSpeichern = new Button("speichern");
                        btnSpeichern.setPrefSize(80, 30);
                        hboxNeuerKontaktAction.getChildren().add(btnSpeichern);

                        Button btnAbbrechen = new Button("abbrechen");
                        btnAbbrechen.setPrefSize(100, 30);
                        hboxNeuerKontaktAction.getChildren().add(btnAbbrechen);

                        Button btnDelete = new Button("löschen");
                        btnDelete.setPrefSize(80, 30);
                        hboxNeuerKontaktAction.getChildren().add(btnDelete);
                        btnDelete.setVisible(true);


// Borderpane Right

            VBox vboxRight = new VBox();
            root.setRight(vboxRight);
            vboxRight.setPadding(new Insets(20));
            vboxRight.setSpacing(10);
            vboxRight.setStyle("-fx-background-color: #ADD4D9;");
            vboxRight.setPrefWidth(500);

            Label rightlabel = new Label("Kontaktdaten");
            rightlabel.setFont(Font.font("Cambria", 20));
            vboxRight.getChildren().add(rightlabel);

            // Ausgabefeld rechts
            VBox vBoxAusgabe = new VBox();
            vboxRight.getChildren().add(vBoxAusgabe);

            TextArea tAKontaktausgabe = new TextArea();
            vBoxAusgabe.getChildren().add(tAKontaktausgabe);

            HBox aendermenu = new HBox();
            aendermenu.setPadding(new Insets(0));
            aendermenu.setSpacing(20);
            vboxRight.getChildren().add(aendermenu);

                Button btnAendern = new Button("ändern");
                btnAendern.setPrefSize(100, 30);
                aendermenu.getChildren().add(btnAendern);
                btnAendern.setVisible(false);

                Button btnLoeschen = new Button("löschen");
                btnLoeschen.setPrefSize(100, 30);
                aendermenu.getChildren().add(btnLoeschen);
                btnLoeschen.setVisible(false);

                Label feedbacklabel = new Label();
                feedbacklabel.setFont(Font.font("Cambria", 20));
                aendermenu.getChildren().add(feedbacklabel);




   // Aktion für den SUCHEN Button
            btnSuche.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {

                    String name = suche.getText();

                            if (!suche.getText().isEmpty()) {

                                tAKontaktausgabe.setText(DbKontakte.showSingle(name));
                                suche.clear();
                                label.setText("");

                                btnAendern.setVisible(true);
                                btnLoeschen.setVisible(true);
                                feedbacklabel.setText("");

                  // Aktion für den ÄNDERN Button

                            btnAendern.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {

                                    if (!tAKontaktausgabe.getText().isEmpty()) {

                                        vBoxKontaktDetails.setVisible(true);
                                        feedbacklabel.setText("");
                                        btnDelete.setVisible(false);
                                        btnSpeichern.setVisible(true);

                                        int pos = DbKontakte.actNameID;

                                        vornameNew.setText(DbKontakte.kontaktDatenList.get(pos).getVorname());
                                        nameNew.setText(DbKontakte.kontaktDatenList.get(pos).getName());
                                        plzNew.setText(DbKontakte.kontaktDatenList.get(pos).getPlz());
                                        ortNew.setText(DbKontakte.kontaktDatenList.get(pos).getOrt());
                                        strasseNrNew.setText(DbKontakte.kontaktDatenList.get(pos).getStrasseNr());
                                        telNrNew.setText(DbKontakte.kontaktDatenList.get(pos).getTelNr());
                                        mailNew.setText(DbKontakte.kontaktDatenList.get(pos).getMail());

                                        // Aktion für den ABBRECHEN Button

                                        btnAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent e) {
                                                vBoxKontaktDetails.setVisible(false);
                                            }
                                        });

                                        // Aktion für den AENDERUNG-SPEICHERN Button
                                        btnSpeichern.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent e) {

                                                DbKontakte.kontaktDatenList.get(pos).setName(nameNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setVorname(vornameNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setPlz(plzNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setOrt(ortNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setStrasseNr(strasseNrNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setTelNr(telNrNew.getText());
                                                DbKontakte.kontaktDatenList.get(pos).setMail(mailNew.getText());

                                                String nameNeu = nameNew.getText();

                                                tAKontaktausgabe.setText(DbKontakte.showSingle(nameNeu));
                                                feedbacklabel.setText("gespeichert");

                                                vBoxKontaktDetails.setVisible(false);
                                            }
                                        });

                                    }
                                }
                            });

                        }
                        else {
                            label.setText("Bitte Nachnamen eingeben");
                        }
                }

            });

        // Aktion für den NeuerKontakt Button
            btnNeu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    vBoxKontaktDetails.setVisible(true);
                    btnSpeichern.setVisible(true);
                    btnDelete.setVisible(false);
                    feedbacklabel.setVisible(false);

                        vornameNew.clear();
                        vornameNew.setPromptText("Vorname");
                        nameNew.clear();
                        nameNew.setPromptText("Nachname");
                        plzNew.clear();
                        plzNew.setPromptText("PLZ");
                        ortNew.clear();
                        ortNew.setPromptText("Ort");
                        strasseNrNew.clear();
                        strasseNrNew.setPromptText("Strasse Nr");
                        telNrNew.clear();
                        telNrNew.setPromptText("Telefonnummer");
                        mailNew.clear();
                        mailNew.setPromptText("E-Mail");

       // Aktion für den ABBRECHEN Button

                btnAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        vBoxKontaktDetails.setVisible(false);
                    }
                });

       // Aktion für den SPEICHERN Button
                btnSpeichern.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        if (!nameNew.getText().isEmpty()) {
                            String name = nameNew.getText();
                            String vorname = vornameNew.getText();
                            String plz = plzNew.getText();
                            String ort = ortNew.getText();
                            String strasseNr = strasseNrNew.getText();
                            String telNr = telNrNew.getText();
                            String mail = mailNew.getText();

                            Kontakt neuerKontakt = new Kontakt(name, vorname, telNr, mail, ort, plz, strasseNr);
                            DbKontakte.kontaktDatenList.add(neuerKontakt);

                            String nameNeu = nameNew.getText();

                            tAKontaktausgabe.setText(DbKontakte.showSingle(nameNeu));
                            feedbacklabel.setText("gespeichert");
                            btnAendern.setVisible(true);
                            btnLoeschen.setVisible(true);
                            vBoxKontaktDetails.setVisible(false);
                        }
                    }
                });

            }
            });

    // LÖSCHEN BUTTON

            btnLoeschen.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    if (!tAKontaktausgabe.getText().isEmpty()) {

                        vBoxKontaktDetails.setVisible(true);
                        feedbacklabel.setText("");
                        btnDelete.setVisible(true);
                        btnSpeichern.setVisible(false);

                        int pos = DbKontakte.actNameID;

                        vornameNew.setText(DbKontakte.kontaktDatenList.get(pos).getVorname());
                        nameNew.setText(DbKontakte.kontaktDatenList.get(pos).getName());
                        plzNew.setText(DbKontakte.kontaktDatenList.get(pos).getPlz());
                        ortNew.setText(DbKontakte.kontaktDatenList.get(pos).getOrt());
                        strasseNrNew.setText(DbKontakte.kontaktDatenList.get(pos).getStrasseNr());
                        telNrNew.setText(DbKontakte.kontaktDatenList.get(pos).getTelNr());
                        mailNew.setText(DbKontakte.kontaktDatenList.get(pos).getMail());

                        // Aktion für den Löschen-ABBRECHEN Button

                        btnAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                vBoxKontaktDetails.setVisible(false);
                            }
                        });

                        // Aktion für den Löschen Button

                        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {

                                vBoxKontaktDetails.setVisible(false);

                                vornameNew.setText("");
                                nameNew.setText("");
                                plzNew.setText("");
                                ortNew.setText("");
                                strasseNrNew.setText("");
                                telNrNew.setText("");
                                mailNew.setText("");

                                DbKontakte.delete(pos);

                                tAKontaktausgabe.setText("");
                                btnAendern.setVisible(false);
                                btnLoeschen.setVisible(false);
                                feedbacklabel.setVisible(true);
                                feedbacklabel.setText("gelöscht");

                            }
                        });


                    }
                }
            });



// Borderpane Bottom

            Pane paneBottom = new Pane();
            root.setBottom(paneBottom);

            HBox bottomHBox = new HBox();
            root.setBottom(bottomHBox);
            // bottomHBox.setPadding(new Insets(10));
            bottomHBox.setStyle("-fx-background-color: white;");
            bottomHBox.setSpacing(20);
            bottomHBox.setPrefHeight(60);

            Label complabel = new Label("erstellt von Frank Burkert");
            complabel.setFont(Font.font("Cambria", 16));
            complabel.setTextFill(Color.web("#0076a3"));
            complabel.setPadding(new Insets(10));
            bottomHBox.getChildren().add(complabel);

            Image image;
            image = new Image (Main.class.getResource("foto.png").toExternalForm());
            ImageView iv1 = new ImageView();
            iv1.setFitHeight(40);
            iv1.setFitWidth(60);
            iv1.setImage(image);
            bottomHBox.getChildren().add(iv1);


            // Erstellen eines neuen SceneObjektes mit Übergabe der Bordepane
            Scene scene = new Scene(root, 1000, 800);

// CSS einbinden
            scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());

            // Übergabe der Scene an die Stage
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}