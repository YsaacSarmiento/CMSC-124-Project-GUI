package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GuiStage {
	private Stage stage;
	private Scene scene;
	private Group root;
	private GraphicsContext gc;
	private Canvas canvas;
	private TableView lexical;
	private TableView symbolTable;
	private Button brButton;
	TableColumn lexemeCol;
	TableColumn classificationCol;
	TableColumn identifierCol;
	TableColumn valueCol;
	public static final int WINDOW_W = 1080;
	public static final int WINDOW_H = 720;
	public GuiStage(){
		this.root = new Group();
		this.scene = new Scene(root, GuiStage.WINDOW_W, GuiStage.WINDOW_H);
		this.canvas = new Canvas(GuiStage.WINDOW_W, GuiStage.WINDOW_H);
		this.gc = canvas.getGraphicsContext2D();
		this.lexical = new TableView();
		this.symbolTable = new TableView();
		//table columns
		this.lexemeCol = new TableColumn("Lexeme");
		this.classificationCol = new TableColumn("Classification");
		this.identifierCol = new TableColumn("Identifiers");
		this.valueCol = new TableColumn("Values");
	}

	public void setStage(Stage stage){
		//initialize table;
		initTable();
		//initialize buttons;
		initButtons();

		//text
		TextArea compileText = new TextArea();
		TextArea displayText = new TextArea();

		compileText.setLayoutX(GuiStage.WINDOW_W * 0.02);
		compileText.setLayoutY(GuiStage.WINDOW_H * 0.10);
		compileText.setPrefSize(300, 350);
		displayText.setLayoutX(GuiStage.WINDOW_W * 0.02);
		displayText.setLayoutY(GuiStage.WINDOW_H * 0.65);
		displayText.setPrefSize(1040, 235);
		displayText.setEditable(false);

		this.stage = stage;
		this.root.getChildren().add(brButton);
		this.root.getChildren().add(canvas);
		this.root.getChildren().add(compileText);
		this.root.getChildren().add(displayText);
		this.root.getChildren().add(lexical);
		this.root.getChildren().add(symbolTable);
		this.stage.setTitle("Hello Sekai Compiler");
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	//initialize table
	public void initTable(){
		identifierCol.setPrefWidth(150);
		identifierCol.setResizable(false);
		valueCol.setPrefWidth(150);
		valueCol.setResizable(false);
		lexemeCol.setPrefWidth(150);
		lexemeCol.setResizable(false);
		classificationCol.setPrefWidth(150);
		classificationCol.setResizable(false);

		lexical.getColumns().addAll(lexemeCol,classificationCol);

		symbolTable.getColumns().addAll(identifierCol,valueCol);

		lexical.setLayoutX(GuiStage.WINDOW_W * 0.33);
		lexical.setLayoutY(GuiStage.WINDOW_H * 0.1);
		lexical.setPrefSize(300, 350);
		symbolTable.setLayoutX(GuiStage.WINDOW_W * 0.65);
		symbolTable.setLayoutY(GuiStage.WINDOW_H * 0.1);
		symbolTable.setPrefSize(300, 350);
	}
	public void initButtons(){
		brButton = new Button("Browse Files");
		brButton.setLayoutX(GuiStage.WINDOW_W * 0.02);
		brButton.setLayoutY(GuiStage.WINDOW_H * 0.06);
		brButton.setPrefSize(300, 10);
		Button executeButton = new Button("Execute");
		brButton.setLayoutX(GuiStage.WINDOW_W * 0.02);
		brButton.setLayoutY(GuiStage.WINDOW_H * 0.06);
		brButton.setPrefSize(300, 10);
	}
}
