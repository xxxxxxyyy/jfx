package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.student;
import pojo.studentSevers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentMain implements Initializable {
    public ComboBox comFind;
    public TableView tbstudent;
    public TableColumn tcStuno;
    public TableColumn tcRoomid;
    public TableColumn tcAge;
    public TableColumn tcName;
    public TextField txtkey;
    public TableColumn tcSex;
    public MenuItem editStu;
    public TableColumn roomStuno;
    public TableColumn rwz;
    public TableColumn tcRs;
    public TableColumn tcbmsg;
    public TableColumn tcbed;

    student stu=new student();
    studentSevers severs = new studentSevers();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //下拉框填充数据，sitem为ComboBox下拉列表组件的fx:id
        comFind.getItems().add("宿舍号");
        comFind.getItems().add("学名");
        comFind.getItems().add("姓名");
      //选中下拉框中的第一项
        comFind.getSelectionModel().select(0);
        //调用数据操作类获取数据加载数据表格（TableView）
        //initTable(severs.getStudentArrayList());

     initTable(severs.getStudentArrayList());
        ControllerManger.controllerMap.put("stuController",this);
    }
    public void initTable(ArrayList<student> stus) {
              //设置数据表格源
        ObservableList<student> data = FXCollections.observableArrayList(
               stus
        );
            //设置每一列的值，【tcStuno】等为界面数据表格中列的fx:id，【stuno】等 Student类中的成员变量名称
            tcStuno.setCellValueFactory(new PropertyValueFactory<>("stuno"));
            tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tcSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
            tcAge.setCellValueFactory(new PropertyValueFactory<>("age"));
            tcRoomid.setCellValueFactory(new PropertyValueFactory<>("room"));
            tcbed.setCellValueFactory(new PropertyValueFactory<>("bed"));
             //设置TableView（tbStudent）的数据源
        tbstudent.setItems(data);
    }



    public void findClick(ActionEvent actionEvent) {
        //initTable方法加载指定学生成绩对象List集合数据到数据表格
        //findStu方法自定义数据操作类按查询成绩方法
        //txtKey.getText()获取文本框输入的值
        initTable(severs.findStu(txtkey.getText()));
    }

    public void delClick(ActionEvent actionEvent) throws SQLException {
        //获取选定行数据
        student s1 = (student) tbstudent.getSelectionModel().getSelectedItem();
       //使用系统确认框询问
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("您确定要删除学号为【" + s1.getStuno() + "】的 成绩吗？");
       // 设置对话框的内容文本
       //alert.setContentText("尊敬的用户，你真的要卸载我吗？");
        // 显示对话框，并等待按钮返回
                Optional<ButtonType> result = alert.showAndWait();
       // 判断返回的按钮类型是确定还是取消，再据此分别进一步处理
        if (result.get() == ButtonType.OK) { // 单击了确定按钮OK
       //调用数据操作类删除学生成绩的方法
            severs.delStudent(s1/*.getStuno()*/);
       //重新加载数据表格视图数据
            initTable(severs.getStudentArrayList());//表格数据加载
        }
    }

    public void btnAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/addStu.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),600,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/picture/添加.png"))));
        stage.setTitle("添加学生信息");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }



   public void btnEdit(ActionEvent actionEvent) throws IOException {
        stu=(student)tbstudent.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/editStu.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),600,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/picture/添加.png"))));
        stage.setTitle("编辑学生信息");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }


}
