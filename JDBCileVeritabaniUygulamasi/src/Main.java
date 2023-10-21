import java.sql.*;
import java.sql.Connection;

public class Main {
    public static final String DB_URL="jdbc:mysql://localhost/office";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="mysql";

    public static void main(String[] args) {
        Connection connect=null;
        String sql="SELECT*FROM employees";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st=connect.createStatement();
            ResultSet data= st.executeQuery(sql);
            System.out.println("**Şirket Yöneticileri Bilgileri**");
            System.out.println("------------------------------------------------------------------------------------------");
            while(data.next()){

                System.out.println("|"+"id : " +data.getInt("id")+"\t"+"|"+"Name :" +data.getString("name")+"\t"+"|"+"Position :" +data.getString("position")+"\t"+"|"+"Salary:" +data.getInt("salary")+"|");
                System.out.println("------------------------------------------------------------------------------------------");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
