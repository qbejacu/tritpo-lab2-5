package sample;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Scene mainWindow;
    Scene editWindow;
    Button addnewBtn;
    Button editBtn;
    Button deleteBtn;
    Button create_submitBtn;
    Button backBtn;
    CheckBox altView;
    TableView<event> tableMainView = new TableView<>();
    List<event> eventList = new ArrayList<>();
    String mainStyle= new String("-fx-background-color:rgb(7, 142, 150)");
    String userStyle= new String("-fx-background-color:rgb(144, 144, 144)");
    String currStyle= new String();
    Boolean editFl=false;

    final ObservableList<event> data = FXCollections.observableArrayList(
        new event("Jacob", "15","Smith", "jacob.smith@example.com"),
        new event("Isabella", "19","Johnson", "isabella.johnson@example.com"),
        new event("Ethan", "97","Williams", "ethan.williams@example.com"),
        new event("Emma", "99","Jones", "emma.jones@example.com"),
        new event("Michael", "105","Brown", "michael.brown@example.com")
    );

    private void addEvent(Stage primaryStage){
        primaryStage.setScene(editWindow);

    };


    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane mainPane = new StackPane();
        StackPane editPane = new StackPane();
        mainWindow= new Scene(mainPane,400,500);
        editWindow= new Scene(editPane,400,500);
        primaryStage.setResizable(false);

        tableMainView.setEditable(false);

        FlowPane horFlowMainPane = new FlowPane();
        FlowPane verFlowMainPane = new FlowPane();
        addnewBtn=new Button("add new");
        editBtn = new Button("edit");
        deleteBtn =  new Button("delete");
        altView = new CheckBox("altenative Color cheme");
        mainPane.setStyle(currStyle);
        editPane.setStyle(currStyle);

        TableColumn eventNameCol = new TableColumn("event_name");
        eventNameCol.setCellValueFactory(new PropertyValueFactory<event,String>("event_name"));
        eventNameCol.setResizable(false);

        TableColumn dateCol = new TableColumn("date");
        dateCol.setCellValueFactory(new PropertyValueFactory<event,String>("date"));
        dateCol.setResizable(false);

        TableColumn authorCol = new TableColumn("author");
        authorCol.setCellValueFactory(new PropertyValueFactory<event,String>("author"));
        authorCol.setResizable(false);

        TableColumn textCol = new TableColumn("text");
        textCol.setCellValueFactory(new PropertyValueFactory<event,String>("text"));
        tableMainView.setPrefWidth(300);
        tableMainView.getColumns().addAll(eventNameCol,dateCol,authorCol,textCol);
        tableMainView.setItems(data);

        horFlowMainPane.getChildren().addAll(addnewBtn,editBtn,deleteBtn,altView);
        horFlowMainPane.setHgap(10);
        horFlowMainPane.setOrientation(Orientation.HORIZONTAL);
        horFlowMainPane.setAlignment(Pos.BASELINE_CENTER);

        verFlowMainPane.getChildren().addAll(tableMainView,horFlowMainPane);
        verFlowMainPane.setHgap(10);
        verFlowMainPane.setOrientation(Orientation.VERTICAL);
        verFlowMainPane.setAlignment(Pos.TOP_LEFT);

        //>editWindow
        final TextField add_eventName = new TextField();
        add_eventName.setPromptText("event_name");
        add_eventName.setMaxWidth(eventNameCol.getPrefWidth());

        final TextField add_Date = new TextField();
        add_Date.setMaxWidth(dateCol.getPrefWidth());
        add_Date.setPromptText("Date");

        final TextField add_author = new TextField();
        add_author.setMaxWidth(authorCol.getPrefWidth());
        add_author.setPromptText("author");

        final TextField add_text = new TextField();
        add_text.setMaxWidth(textCol.getPrefWidth());
        add_text.setPromptText("text");


        FlowPane horFlowEditPane = new FlowPane();
        FlowPane verFlowEditPane = new FlowPane();
        create_submitBtn = new Button("create/submit");
        backBtn = new Button("back");
        horFlowEditPane.getChildren().addAll(add_eventName,add_Date,add_author,add_text);

        horFlowEditPane.getChildren().addAll(create_submitBtn,backBtn);
        horFlowEditPane.setHgap(10);
        horFlowEditPane.setOrientation(Orientation.HORIZONTAL);
        horFlowEditPane.setAlignment(Pos.CENTER);

        verFlowEditPane.getChildren().addAll(horFlowEditPane);
        verFlowEditPane.setHgap(10);
        verFlowEditPane.setOrientation(Orientation.VERTICAL);
        verFlowEditPane.setAlignment(Pos.TOP_LEFT);

        editPane.getChildren().add(verFlowEditPane);
        //editWindow
        mainPane.getChildren().add(verFlowMainPane);


        addnewBtn.setOnAction(e-> {
            addEvent(primaryStage);
        });
        backBtn.setOnAction(e -> {
            if (editFl){
                data.add(new event(add_eventName.getText(),
                    add_Date.getText(),
                    add_author.getText(),
                add_text.getText()));
                add_eventName.clear();
                add_Date.clear();
                add_author.clear();
                add_text.clear();
                editFl=false;
            }
            primaryStage.setScene(mainWindow);
        });
        create_submitBtn.setOnAction(e-> {
                    data.add(new event(
                        add_eventName.getText(),
                        add_Date.getText(),
                        add_author.getText(),
                        add_text.getText()
                    ));
                    add_eventName.clear();
                    add_Date.clear();
                    add_author.clear();
                    add_text.clear();
                    primaryStage.setScene(mainWindow);
            });
        deleteBtn.setOnAction(e-> {
            data.remove(tableMainView.getSelectionModel().getSelectedItem());
        });
        editBtn.setOnAction(e->{
            if (!tableMainView.getSelectionModel().isEmpty()) {
                editFl=true;
                addEvent(primaryStage);
                add_eventName.setText(tableMainView.getSelectionModel().getSelectedItem().getEvent_name());
                add_Date.setText(tableMainView.getSelectionModel().getSelectedItem().getDate());
                add_author.setText(tableMainView.getSelectionModel().getSelectedItem().getAuthor());
                add_text.setText(tableMainView.getSelectionModel().getSelectedItem().getText());
                data.remove(tableMainView.getSelectionModel().getSelectedItem());
            }
        });

        altView.setOnAction(e->{
            if(altView.isSelected()) currStyle=mainStyle; else currStyle=userStyle;
            mainPane.setStyle(currStyle);
            editPane.setStyle(currStyle);
            tableMainView.setStyle(currStyle);


        });

        primaryStage.setTitle("Unfunny event manager");
        primaryStage.setScene(mainWindow);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
