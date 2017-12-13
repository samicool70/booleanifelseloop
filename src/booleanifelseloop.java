import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.util.Optional;
import javax.swing.JOptionPane;
import javafx.scene.control.Alert;


public class booleanifelseloop extends Application {

    @Override

    public void start(Stage Primarystage){

        //create custom dialog
        Dialog<Pair<String, String>> dialog=new Dialog<>();
        dialog.setTitle("login Dialog");
        dialog.setHeaderText("look a custom login dialog");
        dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

        //Set the icon (must be included in the project).
        // dialog.setGraphic(new javafx.scene.image.ImageView(this.getClass().getResource("login.png").toString()));

        // Set the button types.
        ButtonType loginButtonType= new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid =new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        TextField username= new TextField();
        username.setPromptText("Username");
        PasswordField password= new PasswordField();
        password.setPromptText("Password");


        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);



        dialog.getDialogPane().setContent(grid);


        Optional<Pair<String, String>> input = dialog.showAndWait();


        System.out.println(input.get());
        if (String.valueOf(username.getText()).equals("ElektraKatsonis")){
            if (String.valueOf(password.getText()).equals("LizCash26")){
                int N1;

                String input1=JOptionPane.showInputDialog(null,"Enter number of people");
                N1 = Integer.parseInt(input1);

                if (N1>=11 && N1<=55){
                    JOptionPane.showMessageDialog(null,"you have "+ N1 +" player. And the group size is" +N1/11);
                }
                else if (N1 >=3 && N1<11){
                    JOptionPane.showMessageDialog(null, "you have " +N1+" players. And your team size is "+N1/3);
                }
                else{
                    JOptionPane.showMessageDialog(null, "the number of people has to be atleast 3. Try again!");
                }
                return;
            } else {
                int ATTEMPTS =1;
                while (ATTEMPTS<3){
                    dialog.showAndWait();
                    ATTEMPTS++;
                }
            }
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Account blocked.Please contact administrator");
            alert.showAndWait();
        }
        else {
            int USERNAMEATTEMPTS=1;
            while (USERNAMEATTEMPTS<3){
                dialog.showAndWait();
                USERNAMEATTEMPTS++;
            }
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Invalid username");
            alert.showAndWait();
        }

    }
}