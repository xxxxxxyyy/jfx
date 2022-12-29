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
import pojo.Room;
import pojo.roomSevers;
import pojo.student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class RoomMeun implements Initializable {

    public ComboBox comFind;
    public TableView tbroom;
    public TableColumn tcroomStuno;
    public TableColumn tcrwz;
    public TableColumn tcrs;
    public TableColumn tcmsg;
    public TextField txtkey;
    public TableColumn tckw;
    Room r=new Room();

    roomSevers rs=new roomSevers();
    public void findClick(ActionEvent actionEvent) {
        //initTable方法加载指定学生成绩对象List集合数据到数据表格
        //findStu方法自定义数据操作类按查询成绩方法
        //txtKey.getText()获取文本框输入的值
        initTable(rs.findRoom(txtkey.getText()));
    }

    public void btnAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/addRoom.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),600,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/picture/添加.png"))));
        stage.setTitle("添加宿舍信息");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void btnEdit(ActionEvent actionEvent) throws IOException {
        r=(Room) tbroom.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/baoxadd.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),600,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/picture/添加.png"))));
        stage.setTitle("报修信息");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void delClick(ActionEvent actionEvent) throws SQLException {
        //获取选定行数据
        Room s1 = (Room) tbroom.getSelectionModel().getSelectedItem();
        //使用系统确认框询问
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("您确定要删除宿舍号为【" + s1.getRoomid() + "】的 信息吗？");
        // 设置对话框的内容文本
        //alert.setContentText("尊敬的用户，你真的要卸载我吗？");
        // 显示对话框，并等待按钮返回
        Optional<ButtonType> result = alert.showAndWait();
        // 判断返回的按钮类型是确定还是取消，再据此分别进一步处理
        if (result.get() == ButtonType.OK) { // 单击了确定按钮OK
            //调用数据操作类删除学生成绩的方法
            rs.delRoom(s1);
            //重新加载数据表格视图数据
            initTable(rs.getRlist());//表格数据加载
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //下拉框填充数据，sitem为ComboBox下拉列表组件的fx:id
        comFind.getItems().add("宿舍号");
        comFind.getItems().add("人数");
        //选中下拉框中的第一项
        comFind.getSelectionModel().select(0);
        //调用数据操作类获取数据加载数据表格（TableView）
        initTable(rs.getRlist());

        initTable(rs.getRlist());
       // ControllerManger.controllerMap.put("stuController",this);
       // initTable(severs.getStudentArrayList());
        ControllerManger.controllerMap.put("roomController",this);
    }
    public void initTable(ArrayList<Room> rooms) {
        //设置数据表格源
        ObservableList<Room> data = FXCollections.observableArrayList(
               rooms
        );
        //设置每一列的值，【tcStuno】等为界面数据表格中列的fx:id，【stuno】等 Student类中的成员变量名称
        tcroomStuno.setCellValueFactory(new PropertyValueFactory<>("roomid"));
        tcrwz.setCellValueFactory(new PropertyValueFactory<>("wz"));
        tcrs.setCellValueFactory(new PropertyValueFactory<>("rs"));
        tcmsg.setCellValueFactory(new PropertyValueFactory<>("bmsg"));
        tckw.setCellValueFactory(new PropertyValueFactory<>("kw"));
        //设置TableView（tbStudent）的数据源
        tbroom.setItems(data);
    }

}
