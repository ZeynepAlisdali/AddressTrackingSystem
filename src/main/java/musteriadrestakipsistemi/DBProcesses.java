package musteriadrestakipsistemi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DBProcesses {
	
	//private static Logger logger = LogManager.getLogger();
	
	public static void saveAddress(Address addres) {
		//PreparedStatement'a ekleme işlemi için verceğimiz sql sorgusunu oluşturduk
		String sorgu = "INSERT INTO adress(customerID, street, mainStreet, district, city, country, addressType) "
				+ "VALUES(?,?,?,?,?,?,?)";	
		
		Connection connection = DBConnection.getConnection();//veritabanına bağlantı sağlıyoruz sorgu öncesi
				
		PreparedStatement preparedStatement = null;
		
		try {
			//preparedStatement'a oluşturduğumuz sorguyu verdik	    
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, addres.customerID);
			preparedStatement.setString(2, addres.street);
			preparedStatement.setString(3, addres.mainStreet);
			preparedStatement.setString(4, addres.district);
			preparedStatement.setString(5, addres.city);
			preparedStatement.setString(6, addres.country);
			preparedStatement.setString(7, addres.addressType);
	
			int i =  preparedStatement.executeUpdate();
			
			//logger.info("Musteri adresi eklendi. i : " +i );
			
		} catch (SQLException e) {
			//logger.warn("Musteri adresi eklenirken hata meydana geldi. HATA : " + e);	
		}finally {//kapatma işleminde kullanıyoruz
			DBConnection.closeConnection(connection, preparedStatement);
                        //ekleme işlemi sonrası Connection ve PreparedStatement'ı kapatıyoruz
		}
	}
	
	public static void saveIndividualCustomerInformation(IndividualCustomer individualCustomer) {
		//PreparedStatement'a ekleme işlemi için verceğimiz sql sorgusunu oluşturduk
		String sorgu = "INSERT INTO ındividualcustomer(id, surname, tckn, phonenumber, customername) "
				+ "VALUES(?,?,?,?,?)";	
		//veritabanına bağlantı sağlıyoruz sorgu öncesi
		Connection connection = DBConnection.getConnection();
				
		PreparedStatement preparedStatement = null;
		
		try {
			//preparedStatement'a oluşturduğumuz sorguyu verdik	    
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, individualCustomer.id);
			preparedStatement.setString(2, individualCustomer.surName);
			preparedStatement.setInt(3, individualCustomer.TCKN);
			preparedStatement.setInt(4, individualCustomer.phoneNumber);
			preparedStatement.setString(5, individualCustomer.customerName);
	
			int i =  preparedStatement.executeUpdate();
			
			//logger.info("Bireysel musteri eklendi. i : " +i );
			
		} catch (SQLException e) {
			//logger.warn("Bireysel musteri eklenirken hata meydana geldi. HATA : " + e);	
		}finally {//kapatma işleminde kullanıyoruz
                    //ekleme işlemi sonrası Connection ve PreparedStatement'ı kapatıyoruz
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}
        
	
	public static void saveCorporateCustomerInformation(CorporateCustomer corporateCustomer) {
		//PreparedStatement'a ekleme işlemi için verceğimiz sql sorgusunu oluşturduk
		String sorgu = "INSERT INTO corporatecustomer(id, taxnumber, customername) "
				+ "VALUES(?,?,?)";	
		//veritabanına bağlantı sağlıyoruz sorgu öncesi
		Connection connection = DBConnection.getConnection();
				
		PreparedStatement preparedStatement = null;
		
		try {
			//preparedStatement'a oluşturduğumuz sorguyu verdik	    
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, corporateCustomer.id);
			preparedStatement.setString(2, corporateCustomer.taxNumber);
			preparedStatement.setString(3, corporateCustomer.customerName);
                        
		
	
			int i =  preparedStatement.executeUpdate();
			
                    //logger.info("Kurumsal musteri eklendi. i : " +i );
			
		} catch (SQLException e) {
			//logger.warn("Kurumsal musteri eklenirken hata meydana geldi. HATA : " + e);	
		}finally { //kapatma işleminde kullanıyoruz
                    //ekleme işlemi sonrası Connection ve PreparedStatement'ı kapatıyoruz
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}        
        
        
        public static void deleteAddressByAddressId(int AddressId) {
            //PreparedStatement'a silme işlemi için verceğimiz sql sorgusunu oluşturduk
            String sorgu = "DELETE FROM adress WHERE id = ?";
            //veritabanına bağlantı sağlıyoruz sorgu öncesi
            Connection connection = DBConnection.getConnection();
		
            PreparedStatement preparedStatement = null;
		
		try {
                        //preparedStatement'a oluşturduğumuz sorguyu verdik
			preparedStatement = (PreparedStatement)connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, AddressId);
			
			preparedStatement.executeUpdate();
			
			//logger.info(AddressId +" id'li adres silindi.");
		} catch (SQLException e) {
			//logger.warn(AddressId  + "id'li adres silinirken hata meydana geldi. HATA : " + e);
			
		}finally {
                    //ekleme işlemi sonrası Connection ve PreparedStatement'ı kapatıyoruz
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}       	
}
