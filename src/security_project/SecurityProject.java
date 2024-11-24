package security_project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class SecurityProject extends Application {
 Stage caesarScreen = caesarScreen();
 Stage MainScreen = mainScreen();
 Stage Rot13Screen = Rot13Screen();
 @Override
 public void start(Stage primaryStage) {

 MainScreen.show();

 }
 public Stage mainScreen() {
 // Create a vertical box (VBox) and set alignment and paddings
 VBox pane = new VBox(20);
 pane.setAlignment(Pos.CENTER);
 pane.setPadding(new Insets(20, 0, 0, 0));
 //create title for the application and set font
 Text title = new Text("Text Encryption and Decryption Tool");
 title.setFont(Font.font("modern no. 20", FontWeight.BOLD, 24));
 // Load and display the main icon and image for the application
 Image icon = new
Image("file:C:\\Users\\aryam\\Documents\\NetBeansProjects\\SecurityProject\\src\\SecurityProject\\icon.png");
 ImageView img = new ImageView(icon);
 img.setFitHeight(176);
 img.setFitWidth(146);
 Image wave = new
Image("file:C:\\Users\\aryam\\Documents\\NetBeansProjects\\SecurityProject\\src\\SecurityProject\\waven.png");
 ImageView imgwave = new ImageView(wave);
 imgwave.setFitHeight(60);
 imgwave.setFitWidth(599);
 // Create a subtitle prompting the user to choose an encryption algorithm
 Text subtitle = new Text("Choose an encryption algorithm");
 subtitle.setFont(Font.font("modern no. 20", FontWeight.NORMAL, 22));
 //create buttons and in a horizontal box
 Button caesar = new Button("Caesar Cipher");
 caesar.setFont(Font.font("Times New Roman", 18));
 caesar.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fx-bordercolor:black;");
 caesar.setPrefSize(200, 40);
 Button transposition = new Button("Rot13 Cipher");
 transposition.setFont(Font.font("Times New Roman", 18));
 transposition.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fxborder-color:black;");
 transposition.setPrefSize(200, 40);
 HBox buttonBox = new HBox(10, caesar, transposition);
 buttonBox.setAlignment(Pos.CENTER);
 // Set the action for the Caesar Cipher button
 caesar.setOnAction(e -> {
 MainScreen.close();
 caesarScreen.show();
 });
 // Set the action for the Rot13 Cipher button
 transposition.setOnAction(e -> {
 MainScreen.close();
 Rot13Screen.show();
 });
 // Add all elements to the main VBox pane
 pane.getChildren().addAll(title, img, subtitle, buttonBox, imgwave);
 // Create a new scene with the pane and set its dimensions
 Scene scene = new Scene(pane, 600, 419);
 pane.setStyle("-fx-background-color:white");
 Stage stage = new Stage();
 stage.setTitle("Encryption Tool");
 stage.setScene(scene);
 return stage;
 }
 // Caesar Cipher Screen
 public Stage caesarScreen() {
 // Create a BorderPane layout (divides the screen into top, center, and bottom sections)
 BorderPane bpane = new BorderPane();
 bpane.setPadding(new Insets(23, 23, 0, 0));
 // Create a horizontal box (HBox) for the subtitle and radio buttons, with 20 pixels spacing
 HBox pane = new HBox(20);
 pane.setAlignment(Pos.TOP_CENTER);
 pane.setPadding(new Insets(90, 12, 0, 19));
 // Subtitle prompting the user to choose an operation
 Text subtitle = new Text("What to do with message");
 subtitle.setFont(Font.font("modern no. 20", FontWeight.NORMAL, 22));

 // Create a ToggleGroup to group radio buttons for selection
 ToggleGroup operationGroup = new ToggleGroup();

 // Create radio buttons for "Encrypt" and "Decrypt" options
 RadioButton encryptOption = new RadioButton("Encrypt");
 encryptOption.setToggleGroup(operationGroup);
 RadioButton decryptOption = new RadioButton("Decrypt");
 decryptOption.setToggleGroup(operationGroup);

 // Add the subtitle and radio buttons to the HBox
 pane.getChildren().addAll(subtitle, encryptOption, decryptOption);
 bpane.setTop(pane);
 BorderPane.setAlignment(pane, Pos.TOP_CENTER);

 // Create a GridPane for user input fields
 GridPane gpane = new GridPane();
 gpane.setHgap(10);
 gpane.setVgap(20);
 gpane.setPadding(new Insets(20, 20, 20, 20));
 gpane.setAlignment(Pos.CENTER);

 // Labels and input fields
 Text label1 = new Text("");// label is left empty to set dynamically
 label1.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(label1, 0, 0);
 TextArea plainTF = new TextArea();
 plainTF.setWrapText(true);
 gpane.add(plainTF, 1, 0);
 Text label2 = new Text("");// label is left empty to set dynamically
 label2.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(label2, 0, 1);
 TextField keyTF = new TextField();
 gpane.add(keyTF, 1, 1);

 // Button to perform encryption or decryption
 Button send = new Button(""); // Button label is left empty to set dynamically
 send.setFont(Font.font("Times New Roman", 18));
 send.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fx-bordercolor:black;");
 send.setPrefSize(150, 25);
 gpane.add(send, 1, 3);

 gpane.setVisible(false);// Initially hide the input grid until an operation isselected
 bpane.setCenter(gpane);// Set the grid pane in the center of the BorderPane
 BorderPane.setAlignment(gpane, Pos.TOP_CENTER);
 // Load and display an image at the bottom
 Image wave = new
Image("file:C:\\Users\\aryam\\Documents\\NetBeansProjects\\SecurityProject\\src\\SecurityProject\\waven.png");
 ImageView imgwave = new ImageView(wave);
 imgwave.setFitHeight(60);
 imgwave.setFitWidth(699);
 bpane.setBottom(imgwave);
 // Display the result of encryption/decryption
 Text output = new Text("The result is :");
 output.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(output, 0, 4);
 // Text area to show the result, non-editable
 TextArea result = new TextArea("");
 result.setWrapText(true);
 result.setEditable(false);
 gpane.add(result, 1, 4);
 // Back button to return to the main screen
 Button back = new Button("\u2190 Back");// Unicode for left arrow
 back.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
 back.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fx-bordercolor:black;");
 back.setPrefSize(150, 25);
 gpane.add(back, 1,5 );
 // Define the action when the back button is clicked
 back.setOnAction(e -> {
 caesarScreen.close();
 MainScreen.show();
 });
 // Define the action when the send button is clicked (encrypt or decrypt)
 send.setOnAction(e -> {
 try {
 String message = plainTF.getText();// Get the user input message
 int shiftKey = Integer.parseInt(keyTF.getText());// Parse the encryption key
 boolean encrypt = encryptOption.isSelected();// Check if 'Encrypt' isselected
 result.setText(caesarCipher(message, shiftKey, encrypt)); // Call caesarmethod and show result
 } catch (NumberFormatException ex) {
 result.setText("Invalid shift key! Please enter a valid number.");// Handleinvalid key input
 }
 });
 // Add a listener to handle radio button selection changes
 operationGroup.selectedToggleProperty().addListener((observable, oldValue,
newValue) -> {
 if (newValue == encryptOption) {
 //update gridpane for encryption
 label1.setText("Enter plain text");
 label2.setText("Enter encryption key");
 send.setText("Encrypt");
 gpane.setVisible(true);
 } else if (newValue == decryptOption) {
 //update gridpane for decryption
 label1.setText("Enter encrypted message");
 label2.setText("Enter decryption key");
 send.setText("Decrypt");
 gpane.setVisible(true);
 }
 });
 // Create and configure the scene
 Scene scene = new Scene(bpane, 700, 510);
 bpane.setStyle("-fx-background-color:white");
 Stage stage = new Stage();
 stage.setTitle("Caesar Cipher Encryption/Decryption");
 stage.setScene(scene);
 return stage;
 }
 // Rot13 Encryption
 public Stage Rot13Screen() {
 // Create a BorderPane layout (divides the screen into top, center, and bottom sections)
 BorderPane bpane = new BorderPane();
 bpane.setPadding(new Insets(0, 23, 0, 0));
 // Create a horizontal box (HBox) for the subtitle and radio buttons, with 20 pixels spacing
 HBox pane = new HBox(20);
 pane.setAlignment(Pos.TOP_CENTER);
 pane.setPadding(new Insets(90, 12, 0, 19));
 // Subtitle prompting the user to choose an operation
 Text subtitle = new Text("What to do with message");
 subtitle.setFont(Font.font("modern no. 20", FontWeight.NORMAL, 22));
 // Create a ToggleGroup to group radio buttons for selection
 ToggleGroup operationGroup = new ToggleGroup();
 // Create radio buttons for "Encrypt" and "Decrypt" options
 RadioButton encryptOption = new RadioButton("Encrypt");
 encryptOption.setToggleGroup(operationGroup);
 RadioButton decryptOption = new RadioButton("Decrypt");
 decryptOption.setToggleGroup(operationGroup);
 // Add the subtitle and radio buttons to the HBox
 pane.getChildren().addAll(subtitle, encryptOption, decryptOption);
 bpane.setTop(pane);
 BorderPane.setAlignment(pane, Pos.TOP_CENTER);
 // Create a GridPane for user input fields
 GridPane gpane = new GridPane();
 gpane.setHgap(10);
 gpane.setVgap(20);
 gpane.setPadding(new Insets(20, 20, 20, 20));
 gpane.setAlignment(Pos.CENTER);
 // Labels and input fields
 Text label1 = new Text("");// label is left empty to set dynamically
 label1.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(label1, 0, 0);
 TextArea message = new TextArea();
 message.setWrapText(true);
 gpane.add(message, 1, 0);
 Text output = new Text("The result is :");
 output.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(output, 0, 3);
 TextArea result = new TextArea("");// Button label is left empty to set dynamically
 result.setWrapText(true);
 result.setFont(Font.font("modern no. 20", FontWeight.BOLD, 20));
 gpane.add(result, 1, 3);
 // Button to perform encryption or decryptio
 Button send = new Button(""); // Button label is left empty to set dynamically
 send.setFont(Font.font("Times New Roman", 18));
 send.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fx-bordercolor:black;");
 send.setPrefSize(150, 25);
 gpane.add(send, 1, 1);
 gpane.setVisible(false);// Initially hide the input grid until an operation isselected
 bpane.setCenter(gpane);// Set the grid pane in the center of the BorderPane
 BorderPane.setAlignment(gpane, Pos.TOP_CENTER);
 //load image
 Image wave = new
Image("file:C:\\Users\\aryam\\Documents\\NetBeansProjects\\SecurityProject\\src\\SecurityProject\\waven.png");
 ImageView imgwave = new ImageView(wave);
 imgwave.setFitHeight(60);
 imgwave.setFitWidth(699);
 bpane.setBottom(imgwave);
 //Back button to return to the main screen
 Button back = new Button("\u2190 Back");
 back.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
 back.setStyle("-fx-text-fill: white; -fx-background-color: LIGHTPINK; -fx-bordercolor:black;");
 back.setPrefSize(150, 25);
 gpane.add(back, 1, 4);


 //define action when the back button is clicked to show main screen
 back.setOnAction(e -> {
 Rot13Screen.close();
 MainScreen.show();
 });
 // Define the action when the send button is clicked (encrypt or decrypt)
 send.setOnAction(e -> {
 // An error message is displayed when entering numbers.
 if (message.getText().matches("[a-zA-Z ,. ]+")) {
 result.setText(encryptRot13(message.getText()));// Encrypts and displays the message
 } else {
 result.setText("Enter characters only");// Displays an error message for invalid input.
 }
 });
 // Add a listener to handle radio button selection changes
 operationGroup.selectedToggleProperty().addListener((observable, oldValue,
newValue) -> {
 if (newValue == encryptOption) {
 //update grid pane for encryption
 label1.setText("Enter plain text:");
 send.setText("Encrypt");
 gpane.setVisible(true);
 } else if (newValue == decryptOption) {
 //update grid pane for decryption
 label1.setText("Enter encrypted message");
 send.setText("Decrypt");
 gpane.setVisible(true);
 }
 });
 // Create and configure the scene
 Scene scene = new Scene(bpane, 700, 515);
 bpane.setStyle("-fx-background-color:white");
 Stage stage = new Stage();
 stage.setTitle("Rot13 Encryption");
 stage.setScene(scene);
 return stage;
 }
 // Rot13 encrypt method
 public static String encryptRot13(String text) {
 StringBuilder result = new StringBuilder();
 for (char encryption : text.toCharArray()) {
 if (encryption >= 'a' && encryption <= 'z') // For lowercase letters
 {
 encryption = (char) ('a' + (encryption - 'a' + 13) % 26);
 } else if (encryption >= 'A' && encryption <= 'Z')// For uppercase letters
 {
 encryption = (char) ('A' + (encryption - 'A' + 13) % 26);
 }
 result.append(encryption);
 } // Return the encrypted string
 return result.toString();
 }
 // Caesar Cipher Method
 // Caesar Cipher Method
 public static String caesarCipher(String text, int shift, boolean isEncrypt) {
 StringBuilder result = new StringBuilder();
 shift = shift % 26; // 0-25
 for (int i = 0; i < text.length(); i++) { // Loop for each character in the input text
 char charAt = text.charAt(i);
 if (Character.isLetter(charAt)) { // Check if the character is a letter
 char base = (Character.isLowerCase(charAt)) ? 'a' : 'A'; // a for lowercase, A for uppercase)
 int charPosition = charAt - base; // Calculate the position of the letter
 int newPos; // to store the new position after shifting
 if (isEncrypt) { // Encrypt or decrypt
 newPos = (charPosition + shift) % 26; // Encryption
 } else {
 newPos = (charPosition - shift + 26) % 26; // Decryption
 }
 result.append((char) (base + newPos)); // adding the new character after shifting to the result
 } else {
 result.append(charAt);
 }
 }
 return result.toString();
 }
 public static void main(String[] args) {
 launch(args);
 }
}