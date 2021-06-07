import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class design {
    public static void main(String[] args) {
        Connection connection=DBConnection.getConnection();
        System.out.println(Ranking(1));
    }
    public static List<Stu> Ranking(int id){
        List<Stu> stus=new ArrayList<>();
        Connection connection=DBConnection.getConnection();// 获取连接
        Statement statement=null;
        ResultSet set=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String selectStr="";
            if (id!=0){
                selectStr="select * from stu order by time desc";
            }else {
                selectStr="select * from stu ";
            }

            set= statement.executeQuery(selectStr);

            while (set.next()){   //遍历 resultSet
                Stu stu=new Stu();
                stu.setId(set.getInt("id"));
                stu.setTime(set.getInt("time"));
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (set!=null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return stus;
    }
}
