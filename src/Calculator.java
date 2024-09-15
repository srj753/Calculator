
//package application; // uncomment, if that's what you used in CS112

import java.util.ArrayList;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Calculator extends Application 
{
	// the calculator dimensions
	public static int CALC_WIDTH = 250;
	public static int CALC_HEIGHT = 250;

	// the calculator screen
	private TextField screen; 

	// the calculator buttons
	private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonPlus,buttonMinus,buttonMul,buttonEq, buttonDiv, buttonExp, buttonLeftParen,buttonRightParen,buttonClear, buttonDec;
	private ArrayList<Button> buttons;

	private Stack<Double> operandStack;
	private Stack<Operator> operatorStack;

	private String value;

	@Override
	public void start(Stage primaryStage) 
	{
		// create the calculator screen
		screen = new TextField();
		screen.setAlignment(Pos.CENTER_RIGHT);
		screen.setPrefHeight(40);
		screen.setEditable(false);

		// create the buttons
		button1 = new Button("1");
		button2 = new Button("2");
		button3 = new Button("3");
		button4 = new Button("4");
		button5 = new Button("5");
		button6 = new Button("6");
		button7 = new Button("7");
		button8 = new Button("8");
		button9 = new Button("9");
		button0 = new Button("0");

		buttonEq = new Button("=");
		buttonPlus = new Button("+");
		buttonMinus = new Button("-");
		buttonMul = new Button("*");
		buttonDiv = new Button("/");
		buttonExp = new Button("^");
		buttonLeftParen = new Button("(");
		buttonRightParen = new Button(")");
		buttonClear = new Button("C");
		buttonDec = new Button(".");

		buttons = new ArrayList<>();
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);
		buttons.add(button7);
		buttons.add(button8);
		buttons.add(button9);
		buttons.add(button0);

		buttons.add(buttonEq);
		buttons.add(buttonPlus);
		buttons.add(buttonMinus);
		buttons.add(buttonMul);
		buttons.add(buttonDiv);
		buttons.add(buttonExp);
		buttons.add(buttonLeftParen);
		buttons.add(buttonRightParen);
		buttons.add(buttonClear);
		buttons.add(buttonDec);

		// Style all buttons
		styleAllButtons();



		// attach a handler to process button clicks 
		ButtonHandler handler = new ButtonHandler();       
		button1.setOnAction(handler);
		button2.setOnAction(handler);
		button3.setOnAction(handler);
		button4.setOnAction(handler);
		button5.setOnAction(handler);
		button6.setOnAction(handler);
		button7.setOnAction(handler);
		button8.setOnAction(handler);
		button9.setOnAction(handler);
		button0.setOnAction(handler);
		buttonEq.setOnAction(handler);
		buttonPlus.setOnAction(handler);
		buttonMinus.setOnAction(handler);
		buttonMul.setOnAction(handler);
		buttonExp.setOnAction(handler);
		buttonDiv.setOnAction(handler);
		buttonLeftParen.setOnAction(handler);
		buttonRightParen.setOnAction(handler);
		buttonClear.setOnAction(handler);
		buttonDec.setOnAction(handler);

		// setup a grid panel for the keypad
		GridPane keypad = new GridPane();  
		keypad.setMinSize(CALC_WIDTH, CALC_HEIGHT); 
		keypad.setPadding(new Insets(5, 5, 5, 5));  
		keypad.setVgap(5); 
		keypad.setHgap(5);       
		keypad.setAlignment(Pos.CENTER); 

		// attach the buttons to the keypad grid
		keypad.add(buttonLeftParen, 0, 0);
		keypad.add(buttonRightParen, 1, 0);
		keypad.add(buttonClear, 2, 0);
		keypad.add(buttonPlus, 3, 0);

		keypad.add(button1, 0, 1);
		keypad.add(button2, 1, 1);
		keypad.add(button3, 2, 1);
		keypad.add(buttonMinus, 3, 1);

		keypad.add(button4, 0, 2);
		keypad.add(button5, 1, 2);
		keypad.add(button6, 2, 2);
		keypad.add(buttonMul, 3, 2);

		keypad.add(button7, 0, 3);
		keypad.add(button8, 1, 3);
		keypad.add(button9, 2, 3);
		keypad.add(buttonDiv, 3, 3);

		keypad.add(buttonDec, 0, 4);
		keypad.add(button0, 1, 4);
		keypad.add(buttonExp, 2, 4);
		keypad.add(buttonEq, 3, 4);


		// put screen and keypad together
		BorderPane gui = new BorderPane();
		gui.setTop(screen);
		gui.setCenter(keypad);

		operandStack = new Stack<>();
		operatorStack = new Stack<>();

		value = "";

		// set up the scene
		Scene scene = new Scene(gui); 
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void styleAllButtons() {
		for (Button button : buttons) {
			String text = button.getText();
			String style;

			switch (text) {
			case "+": case "-": case "*": case "/": case "^":
				style = "-fx-background-color: #b0b0b0; -fx-font-size: 14px;";
				break;
			case "=":
				style = "-fx-background-color: #90caf9; -fx-font-size: 14px;";
				break;
			case "C":
				style = "-fx-background-color: #ff8a80; -fx-font-size: 14px;";
				break;
			default:
				style = "-fx-background-color: #e0e0e0; -fx-font-size: 14px;";
				break;
			}

			button.setStyle(style + " -fx-pref-width: 50px; -fx-pref-height: 40px;");
		}
	}


	// Handler for processing the button clicks 
	private class ButtonHandler implements EventHandler<ActionEvent>
	{ 
		@Override 
		public void handle(ActionEvent e) 
		{
			if (e.getSource() == button1) {
				screen.appendText("1");
				value = value + button1.getText();
			}
			else if (e.getSource() == button2) {
				screen.appendText("2");
				value = value + button2.getText();
			}
			else if (e.getSource() == button3) {
				screen.appendText("3");
				value = value + button3.getText();
			}
			else if (e.getSource() == button4) {
				screen.appendText("4");
				value = value + button4.getText();
			}
			else if (e.getSource() == button5) {
				screen.appendText("5");
				value = value + button5.getText();
			}
			else if (e.getSource() == button6) {
				screen.appendText("6");
				value = value + button6.getText();
			}
			else if (e.getSource() == button7) {
				screen.appendText("7");
				value = value + button7.getText();
			}
			else if (e.getSource() == button8) {
				screen.appendText("8");
				value = value + button8.getText();
			}
			else if (e.getSource() == button9) {
				screen.appendText("9");
				value = value + button9.getText();
			}
			else if (e.getSource() == button0) {
				screen.appendText("0");
				value = value + button0.getText();
			}
			else if (e.getSource() == buttonPlus) {
				screen.appendText("+");
				AddOperator add = new AddOperator();
				addToStack(add);
			}
			else if (e.getSource() == buttonMinus) {
				screen.appendText("-");
				SubOperator sub = new SubOperator();
				addToStack(sub);
			}
			else if (e.getSource() == buttonMul) {
				screen.appendText("*");
				MulOperator mul = new MulOperator();
				addToStack(mul);
			}
			else if (e.getSource() == buttonDiv) {
				screen.appendText("/");
				DivOperator div = new DivOperator();
				addToStack(div);
			}
			else if (e.getSource() == buttonRightParen) {
				screen.appendText(")");
				RightParenOperator rParen = new RightParenOperator();
				addToStack(rParen);
				operatorStack.pop();
				operatorStack.pop();
			}
			else if (e.getSource() == buttonLeftParen) {
				screen.appendText("(");
				LeftParenOperator lParen = new LeftParenOperator();
				//				addToStack(lParen);
				operatorStack.push(lParen);
			}
			else if (e.getSource() == buttonClear) {
				screen.clear();
				operandStack.clear();
				operatorStack.clear();
				//System.out.println("clear pressed");
			}
			else if (e.getSource() == buttonExp) {
				screen.appendText("^");
				ExpOperator exp = new ExpOperator();
				addToStack(exp);
			}
			else if (e.getSource() == buttonDec) {
				screen.appendText(".");
				value = value + buttonDec.getText();
			}
			else if (e.getSource() == buttonEq) {
				//System.out.println("equal pressed");
				EqualOperator eq = new++
						
						
						
						EqualOperator();
				addToStack(eq);
				operatorStack.pop();
				screen.clear();
				screen.appendText(String.valueOf(operandStack.peek()));
			}

		} 
	}  

	private void addToStack(Operator op) {
		if (!value.isEmpty()) {
			operandStack.push(Double.parseDouble(value));
			value = "";
		}
		while (!operatorStack.isEmpty() && operatorStack.peek().getPrecedence() >= op.getPrecedence()) {
			Double a = operandStack.pop();
			Double b = operandStack.pop();
			Operator operator = operatorStack.pop();
			double result = operator.evaluate(a, b);
			operandStack.add(result);
			//System.out.println(result);
		}
		operatorStack.add(op);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}