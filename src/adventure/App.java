package adventure;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private Scene cenaPrincipal;
    private TextField comando;
    private TextArea descricao;
    private List<Image> images;
    private ImageView imgView;

    private Engine engine;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        engine = new Engine(this);

        GridPane gp = new GridPane();

        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));

        images = new ArrayList<>();

        images.add(new Image("file:telas/hall.jpg"));
        images.add(new Image("file:telas/salaDireita.jpg"));
        images.add(new Image("file:telas/salaEsquerdaEscuro.jpg"));
        images.add(new Image("file:telas/salaEsquerda.jpg"));
        images.add(new Image("file:telas/subsoloEscuro.jpg"));
        images.add(new Image("file:telas/subsolo.jpg"));

        imgView = new ImageView();
        imgView.setImage(images.get(0));
        imgView.setFitWidth(520);
        imgView.setPreserveRatio(true);
        imgView.setSmooth(true);
        imgView.setCache(true);

        HBox boxImg = new HBox(10);
        boxImg.getChildren().add(imgView);
        boxImg.setAlignment(Pos.CENTER);
        gp.add(boxImg,0,0);

        descricao = new TextArea();
        descricao.setEditable(false);
        gp.add(descricao, 0, 1);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        Label lbCmd = new Label("Comando");
        hbBtn.getChildren().add(lbCmd);
        comando = new TextField();
        hbBtn.getChildren().add(comando);
        Button btOk = new Button("Ok");
        btOk.setOnAction(e -> engine.joga(comando.getText()));
        hbBtn.getChildren().add(btOk);
        gp.add(hbBtn, 0, 2);

        cenaPrincipal = new Scene(gp);

        primaryStage.setTitle("Adventure");
        primaryStage.setScene(cenaPrincipal);
        primaryStage.setResizable(false);
        primaryStage.show();

        engine.joga("start");
    }

    public void exibeTexto(String texto) {
        descricao.appendText(texto);
        descricao.setScrollTop(Double.MAX_VALUE);
        comando.setText("");
    }

    public void setImagem(int i) {
        imgView.setImage(images.get(i));
    }

    public static void main(String[] args) {
        launch(args);
    }
}