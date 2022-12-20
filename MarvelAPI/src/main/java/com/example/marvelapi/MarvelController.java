package com.example.marvelapi;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.Property;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class MarvelController implements Initializable {
    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private ImageView imageMarvel;

    @FXML
    private TableView<personaje> tableView;

    @FXML
    private Label labelNombre;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    private ObservableList<personaje> listaPersonajes;
    private FilteredList<personaje> filtroPersonaje;
    @FXML
    private TextField textNombreFiltro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        listaPersonajes = FXCollections.observableArrayList();
    }

    private void acciones(){
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<personaje>() {
            @Override
            public void changed(ObservableValue<? extends personaje> observableValue, personaje personaje, personaje t1) {
                imageMarvel.setImage(new Image(t1.getImagen()));
                textArea1.setWrapText(true);
                textArea1.setText(new String(t1.getDescription()));
                labelNombre.setText(new String(t1.getNombre()));
            }
        });

        textNombreFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!textNombreFiltro.getText().equals("")){
                    filtroPersonaje=new FilteredList(listaPersonajes);
                    filtroPersonaje.setPredicate(new Predicate<personaje>() {
                        @Override
                        public boolean test(personaje pokemon) {
                            return pokemon.getNombre().toUpperCase().contains(t1.toUpperCase());
                        }
                    });
                    columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
                    tableView.setItems(filtroPersonaje);
                }
            }
        });
        boton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("info-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,boton1.getScene().getWidth(),boton1.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Info");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private void asociarDatos() {
        for (int i=0; i<1600 ; i+=100) {
            //String urlquery="https://gateway.marvel.com/v1/public/characters?ts=1&apikey=8b1cbdaa50df4552bee5b35f4b77a659&hash=6d582e56eb80fc1b3058b2beb6cd135c";
            String urlquery = "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=8b1cbdaa50df4552bee5b35f4b77a659&hash=6d582e56eb80fc1b3058b2beb6cd135c&limit=100&offset=" + String.valueOf(i);
            try {
                URL url = new URL(urlquery);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
                StringBuilder lectura = new StringBuilder();
                String linea = null;

                while ((linea = bufferedReader.readLine()) != null) {
                    lectura.append(linea);
                }

                JSONObject jsonGeneral = new JSONObject(lectura.toString());
                JSONObject objectResultados = jsonGeneral.getJSONObject("data");
                JSONArray arrayResultados = objectResultados.getJSONArray("results");
                //JSONObject objectComics = objectResultados.getJSONObject("comics");
                //JSONArray arrayItems = objectComics.getJSONArray("items");
                for (int j = 0; j < arrayResultados.length(); j++) {
                    JSONObject resultado = arrayResultados.getJSONObject(j);
                    JSONObject comics = arrayResultados.getJSONObject(j);
                    String nombre = resultado.getString("name");
                    String description = resultado.getString("description");
                    JSONObject thumbnail = resultado.getJSONObject("thumbnail");
                    String path = thumbnail.getString("path");
                    String extension = thumbnail.getString("extension");
                    String imagen = path + "." + extension;
                    //String comicName = comics.getString("name");

                    listaPersonajes.add(new personaje(nombre, description, imagen));

                }
                columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
                tableView.setItems(listaPersonajes);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}