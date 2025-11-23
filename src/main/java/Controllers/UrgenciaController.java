package Controllers;

import Models.MaxHeap;
import Models.Nodo;
import Models.Paciente;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UrgenciaController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private CheckBox chkDificultadRespiratoria;
    @FXML private CheckBox chkHemorragia;
    @FXML private CheckBox chkPerdidaConsciencia;
    @FXML private CheckBox chkQuemaduras;
    @FXML private CheckBox chkFiebreAlta;
    @FXML private CheckBox chkDolorAbdominal;
    @FXML private CheckBox chkVomitos;
    @FXML private CheckBox chkTraumatismoLeve;

    @FXML private TableView<Nodo> tablaPacientes;
    @FXML private TableColumn<Nodo, String> colNombre;
    @FXML private TableColumn<Nodo, Integer> colEdad;
    @FXML private TableColumn<Nodo, Integer> colPrioridad;

    @FXML private TextArea txtSalida;

    private MaxHeap heap = new MaxHeap();

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().paciente.nombre));
        colEdad.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().paciente.edad).asObject());
        colPrioridad.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().prioridad).asObject());
    }

    private void actualizarTabla() {
        tablaPacientes.getItems().clear();
        tablaPacientes.getItems().addAll(heap.obtenerElementos());
    }   


    @FXML
    private void registrarPaciente() {
        String nombre = txtNombre.getText();
        if(nombre == null) return;

        String edadTexto = txtEdad.getText();
        if(edadTexto == null) return;

        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
            if (edad <= 0) return;
        } catch (NumberFormatException e) {
            return;
        }
        
        heap.registrar(new Paciente(nombre, edad), calcularPrioridad());
        txtSalida.appendText("Registrado: " + nombre + "\n");

        limpiarCampos();
        actualizarTabla();
    }

    private int calcularPrioridad(){
        int prioridad = 0;
        if(chkDificultadRespiratoria.isSelected()) prioridad+=5;
        if(chkHemorragia.isSelected()) prioridad+=5;
        if(chkPerdidaConsciencia.isSelected()) prioridad+=5;
        if(chkQuemaduras.isSelected()) prioridad+=4;
        if(chkFiebreAlta.isSelected()) prioridad+=3;
        if(chkDolorAbdominal.isSelected()) prioridad+=3;
        if(chkVomitos.isSelected()) prioridad+=2;
        if(chkTraumatismoLeve.isSelected()) prioridad+=1;
        return prioridad;
    }

    private void limpiarCampos(){
        txtNombre.clear();
        txtEdad.clear();
        chkDificultadRespiratoria.setSelected(false);
        chkHemorragia.setSelected(false);
        chkPerdidaConsciencia.setSelected(false);
        chkQuemaduras.setSelected(false);
        chkFiebreAlta.setSelected(false);
        chkDolorAbdominal.setSelected(false);
        chkVomitos.setSelected(false);
        chkTraumatismoLeve.setSelected(false);
    }

    @FXML
    private void consultarSiguiente() {
        Nodo n = heap.consultarSiguiente();
        txtSalida.appendText("Siguiente: " + (n == null ? "Nadie" : n) + "\n");
    }

    @FXML
    private void atenderPaciente() {
        Nodo n = heap.atender();
        txtSalida.appendText("Atendiendo: " + (n == null ? "Nadie" : n) + "\n");
        actualizarTabla();
    }
}
