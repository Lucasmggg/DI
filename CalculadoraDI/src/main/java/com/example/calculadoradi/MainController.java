package com.example.calculadoradi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class MainController implements Initializable {

    @FXML private Button botonExponente;
    @FXML private Button boton0;
    @FXML private Button boton1;
    @FXML private Button boton2;
    @FXML private Button boton3;
    @FXML private Button boton4;
    @FXML private Button boton5;
    @FXML private Button boton6;
    @FXML private Button boton7;
    @FXML private Button boton8;
    @FXML private Button boton9;
    @FXML private Button botonAc;
    @FXML private Button botonDivision;
    @FXML private Button botonE;
    @FXML private Button botonElevar;
    @FXML private Button botonFactorizar;
    @FXML private Button botonIgual;
    @FXML private Button botonLn;
    @FXML private Button botonMas;
    @FXML private Button botonMasMenos;
    @FXML private Button botonMenos;
    @FXML private Button botonMostarRegistro;
    @FXML private Button botonMostrarSCI;
    @FXML private Button botonMultiplicacion;
    @FXML private Button botonOcultarCientifica;
    @FXML private Button botonPorcentaje;
    @FXML private Button botonPunto;
    @FXML private Button botonRaiz;
    @FXML private Button botonSeno;
    @FXML private TextArea textAreaSolucion;
    @FXML private TextArea textAreaRegistro;
    @FXML private BorderPane panelGeneral;
    @FXML private GridPane panelSCI;
    @FXML private GridPane panelRegistro;
    @FXML private Button botonOcultarRegistro;
    @FXML private Button botonBorrarRegistro;
    private double primeraCifra = 0.0;
    private double segundaCifra = 0.0;
    private String operador="";
    private DropShadow sombraExterior;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        acciones();
    }



    private void initGUI() {
        panelGeneral.getChildren().remove(panelSCI);
        panelGeneral.getChildren().remove(panelRegistro);
    }

    private void acciones() {
        botonMostrarSCI.setOnAction(new ManejoPulsaciones());
        botonMostarRegistro.setOnAction(new ManejoPulsaciones());
        botonOcultarCientifica.setOnAction(new ManejoPulsaciones());
        botonOcultarRegistro.setOnAction(new ManejoPulsaciones());
        boton0.setOnAction(new ManejoPulsaciones());
        boton1.setOnAction(new ManejoPulsaciones());
        boton2.setOnAction(new ManejoPulsaciones());
        boton3.setOnAction(new ManejoPulsaciones());
        boton4.setOnAction(new ManejoPulsaciones());
        boton5.setOnAction(new ManejoPulsaciones());
        boton6.setOnAction(new ManejoPulsaciones());
        boton7.setOnAction(new ManejoPulsaciones());
        boton8.setOnAction(new ManejoPulsaciones());
        boton9.setOnAction(new ManejoPulsaciones());
        botonAc.setOnAction(new ManejoPulsaciones());
        botonMultiplicacion.setOnAction(new ManejoPulsaciones());
        botonMas.setOnAction(new ManejoPulsaciones());
        botonMasMenos.setOnAction(new ManejoPulsaciones());
        botonMenos.setOnAction(new ManejoPulsaciones());
        botonDivision.setOnAction(new ManejoPulsaciones());
        botonPorcentaje.setOnAction(new ManejoPulsaciones());
        botonPunto.setOnAction(new ManejoPulsaciones());
        botonIgual.setOnAction(new ManejoPulsaciones());
        botonBorrarRegistro.setOnAction(new ManejoPulsaciones());
        botonExponente.setOnAction(new ManejoPulsaciones());
        botonSeno.setOnAction(new ManejoPulsaciones());
        botonElevar.setOnAction(new ManejoPulsaciones());
        botonRaiz.setOnAction(new ManejoPulsaciones());
        botonSeno.setOnAction(new ManejoPulsaciones());
        botonE.setOnAction(new ManejoPulsaciones());
        botonFactorizar.setOnAction(new ManejoPulsaciones());
        botonLn.setOnAction(new ManejoPulsaciones());
    }

    public double factorizar(double inumero){
        int iFactorial = 1;
        for (int x=2;x<=inumero;x++)
            iFactorial = iFactorial * x;
        return iFactorial;
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento raton generado");
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) mouseEvent.getSource()).setEffect(sombraExterior);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource()==botonMostrarSCI){
                panelGeneral.setLeft(panelSCI);
            }
            if (actionEvent.getSource()==botonMostarRegistro){
                panelGeneral.setRight(panelRegistro);
            }
            else if (actionEvent.getSource()==botonOcultarCientifica) {
                panelGeneral.getChildren().remove(panelSCI);
            }
            else if (actionEvent.getSource()==botonOcultarRegistro) {
                panelGeneral.getChildren().remove(panelRegistro);
            }
            else if (actionEvent.getSource()==botonBorrarRegistro) {
                textAreaRegistro.setText("");
            }
            else if (actionEvent.getSource()==boton0) {
                textAreaSolucion.appendText("0");
            }
            else if (actionEvent.getSource()==boton1) {
                textAreaSolucion.appendText("1");
            }
            else if (actionEvent.getSource()==boton2) {
                textAreaSolucion.appendText("2");
            }
            else if (actionEvent.getSource()==boton3) {
                textAreaSolucion.appendText("3");
            }
            else if (actionEvent.getSource()==boton4) {
                textAreaSolucion.appendText("4");
            }
            else if (actionEvent.getSource()==boton5) {
                textAreaSolucion.appendText("5");
            }
            else if (actionEvent.getSource()==boton6) {
                textAreaSolucion.appendText("6");
            }
            else if (actionEvent.getSource()==boton7) {
                textAreaSolucion.appendText("7");
            }
            else if (actionEvent.getSource()==boton8) {
                textAreaSolucion.appendText("8");
            }
            else if (actionEvent.getSource()==boton9) {
                textAreaSolucion.appendText("9");
            }
            else if (actionEvent.getSource()==botonAc) {
                textAreaSolucion.setText("");
                botonPunto.setDisable(false);
                primeraCifra=0.0;
                segundaCifra=0.0;
            }
            else if (actionEvent.getSource()==botonMultiplicacion) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("*");
                textAreaSolucion.setText("");
                operador="*";
            }
            else if (actionEvent.getSource()==botonMas) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("+");
                textAreaSolucion.setText("");
                operador="+";
            }
            else if (actionEvent.getSource()==botonMenos) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("-");
                textAreaSolucion.setText("");
                operador="-";
            }
            else if (actionEvent.getSource()==botonDivision) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("/");
                textAreaSolucion.setText("");
                operador="/";
            }
            else if (actionEvent.getSource()==botonPorcentaje) {
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaSolucion.setText(String.valueOf(Double.valueOf(textAreaSolucion.getText())*0.01));
                textAreaRegistro.appendText("*0.01="+textAreaSolucion.getText()+"\n");
            }
            else if (actionEvent.getSource()==botonExponente) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("E");
                textAreaSolucion.setText("");
                operador="E";
            }
            else if (actionEvent.getSource()==botonElevar) {
                primeraCifra=parseDouble(textAreaSolucion.getText());
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaRegistro.appendText("^");
                textAreaSolucion.setText("");
                operador="^";
            }
            else if (actionEvent.getSource()==botonRaiz) {
                textAreaSolucion.appendText("√");
                operador="√";
            }
            else if (actionEvent.getSource()==botonSeno) {
                textAreaSolucion.appendText("sin ");
                operador="sin";
            }
            else if (actionEvent.getSource()==botonLn) {
                textAreaSolucion.appendText("ln ");
                operador="ln";
            }
            else if (actionEvent.getSource()==botonMasMenos) {
                double numero = parseDouble(textAreaSolucion.getText());
                textAreaSolucion.setText(String.valueOf(-numero));
            }
            else if (actionEvent.getSource()==botonPunto) {
                textAreaSolucion.appendText(".");
                botonPunto.setDisable(true);
            }
            else if (actionEvent.getSource()==botonE) {
                textAreaSolucion.appendText(String.valueOf(Math.E));
            }
            else if (actionEvent.getSource()==botonFactorizar) {
                textAreaRegistro.appendText(textAreaSolucion.getText());
                textAreaSolucion.setText(String.valueOf(factorizar(parseDouble(textAreaSolucion.getText()))));
                textAreaRegistro.appendText("!="+textAreaSolucion.getText()+"\n");
            }
            else if (actionEvent.getSource()==botonIgual) {
                if (operador.equals("√")){
                    String partes[] = textAreaSolucion.getText().split("√");
                    double primeraCifra = parseDouble(partes[1]);
                    textAreaRegistro.appendText(textAreaSolucion.getText());
                    textAreaRegistro.appendText("=");
                    textAreaSolucion.setText(String.valueOf(Math.sqrt(primeraCifra)));
                    textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                }
                else if (operador.equals("sin")){
                    String partes[] = textAreaSolucion.getText().split("sin");
                    double primeraCifra = parseDouble(partes[1]);
                    textAreaRegistro.appendText(textAreaSolucion.getText());
                    textAreaRegistro.appendText("=");
                    textAreaSolucion.setText(String.valueOf(Math.sin(primeraCifra)));
                    textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                }
                else if (operador.equals("ln")){
                    String partes[] = textAreaSolucion.getText().split("ln");
                    double primeraCifra = parseDouble(partes[1]);
                    textAreaRegistro.appendText(textAreaSolucion.getText());
                    textAreaRegistro.appendText("=");
                    textAreaSolucion.setText(String.valueOf(Math.log(primeraCifra)));
                    textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                }
                else{
                    segundaCifra=parseDouble(textAreaSolucion.getText());
                    textAreaRegistro.appendText(textAreaSolucion.getText());
                    textAreaRegistro.appendText("=");
                    if (operador.equals("+")){
                        textAreaSolucion.setText(String.valueOf(primeraCifra+segundaCifra));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                    else if (operador.equals("-")){
                        textAreaSolucion.setText(String.valueOf(primeraCifra-segundaCifra));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                    else if (operador.equals("*")){
                        textAreaSolucion.setText(String.valueOf(primeraCifra*segundaCifra));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                    else if(operador.equals("/")){
                        textAreaSolucion.setText(String.valueOf(primeraCifra/segundaCifra));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                    else if(operador.equals("E")){
                        double elevado = Math.pow(10,segundaCifra);
                        textAreaSolucion.setText(String.valueOf(primeraCifra*elevado));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                    else if(operador.equals("^")){
                        textAreaSolucion.setText(String.valueOf(Math.pow(primeraCifra, segundaCifra)));
                        textAreaRegistro.appendText(textAreaSolucion.getText()+"\n");
                    }
                }
            }
        }
    }
}