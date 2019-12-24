package musteriadrestakipsistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DBConnection {

	
	   
    //private static final Logger logger = LogManager.getLogger();
    
    public static Connection getConnection(){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //logger.warn("Mysql Driver Bulunamadı. Hata: "+ e);
	}
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customertrackingsystem?useTimezone=true&serverTimezone=UTC", "root", "root");
            //logger.info("Mysql Baglandık.");
        } catch (Exception e) {
        }
            //logger.warn("Mysql bağlanırken hata meydana geldi. " );

        return connection;
    }
    
    
    public static void closeConnection(Connection connection,PreparedStatement preparedStatement){
        
        if(preparedStatement != null){  //her statement kullanıldığında close işlemi yapılcak. create,delete, update hepsinde
            try {
            	preparedStatement.close();
             } catch (Exception e) {
                //logger.warn("preparedStatement kapatılırken hata meydana geldi");
            }
        }        
        
        if(connection != null){
            try {
                connection.close();
                
               // logger.info("Veritabani baglantisi kapatildi");
            } catch (Exception e) {
                //logger.warn("Veritabani baglantisi kapatılırken hata meydana geldi. HATA : " + e);
                
            }
        
        }
    }
    
}
