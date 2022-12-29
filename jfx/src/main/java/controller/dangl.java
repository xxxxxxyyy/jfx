package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import pojo.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dangl implements Initializable {
    public TextField txtzhanhao;
    public TextField txtpassword;
    public Label errormsg;
    public Button user;
    public Button manager;
    public String stuno;
    public String mima;

//    userSevers service=new userSevers();
    userSevers us=new userSevers();
   /* public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });
    }

    */
  //  managerSevers ms=new managerSevers();
    public void userdl(ActionEvent actionEvent) throws IOException {
        String p=txtpassword.getText();
        String use=txtzhanhao.getText();
      //  user u1=new user(p,use);
       if(us.findByusername(use).getPassword().equals(p))
       {
           stuno=use;
           mima=p;
           FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/usermeun1.fxml"));
           Pane cmdPane=(Pane) fxmlLoader.load();
           mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
           mainController.mainpane.setRight(cmdPane);
       }
       else {
           errormsg.setText("账号密码不正确");
       }
    }


    public void managerdl(ActionEvent actionEvent) throws IOException {
        String p=txtpassword.getText();
        String man=txtzhanhao.getText();
        ArrayList<user> ulist=new ArrayList<>();
        File f=new File("d:"+File.separator+"用户账号密码.txt");
        FileReader filereader=new FileReader(f);
        LineNumberReader reader=new LineNumberReader(filereader);
        boolean b=false;
        String txt=" ";
        while (txt!=null&&b==false){
            txt =reader.readLine();
            if(txt.equals(man+"："+p))
            {
                stuno=man;
                mima=p;
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/glymeun1.fxml"));
                Pane cmdPane=(Pane) fxmlLoader.load();
                mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
                mainController.mainpane.setRight(cmdPane);
                b=true;
                break;
            }

        }
        if(b==false){
            errormsg.setText("账号密码不正确");
        }

    }
   public boolean isadd=true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* txtzhanhao.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String stuno=txtzhanhao.getText();

                    if(stuno.length()==0){
                        errormsg.setText("学号不能为空！");
                        txtzhanhao.requestFocus();
                        isadd=false;
                    }else if(us.findByusername(stuno)!=null){
                        errormsg.setText("学号已经存在！");
                        txtzhanhao.requestFocus();
                        isadd=false;
                    }else {
                        errormsg.setText("");
                        isadd=true;
                    }
                }
            }
        });*/
        ControllerManger.controllerMap.put("stunomsgController",this);
    }

    public void zc(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/zhuce.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }
}

