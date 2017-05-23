import java.sql.*;

/**
 * @author Den-Art
 */
public class DatabaseConnection {

	public DatabaseConnection() {
	
	}
	
/**************************************** CONNECTION TO DATABASE ****************************************/
/********************************************************************************************************/
	public static void Connection() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
/******************************************** INSERTING DATA ********************************************/
/********************************************************************************************************/
	public static void insertionIntoDatabase() {
		
		Connection();
		
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
	
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
		
			String query = "INSERT INTO books(title, author_name, author_surname, isbn, year_published)"
							+ "VALUES('newBook','Dj','Beetle', '666', '2000-10-01')";					
			PreparedStatement statement = connect.prepareStatement(query);			
			System.out.println("Connection successful");

			statement.executeUpdate();	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
/******************************************* DISPLAYING DATA ********************************************/
/********************************************************************************************************/
	public static void selectingFromDatabase() {
		
		Connection();
		
		int itemNumber1 = 0;
		int itemNumber2 = 0;
		int itemNumber3 = 0;
		int itemNumber4 = 0;
		int itemNumber5 = 0;
		
		//declare arrays of names, addresses and passwords
		String [] titles = new String[10];
		String [] names = new String[10];
		String [] surnames = new String[10];
		String [] isbns = new String [10];
		String [] dates = new String [10];
			
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
		
			String query = "SELECT* FROM books";
			
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(query);
	
				while(rs.next()) {
					titles[itemNumber1] = rs.getString("title");
					itemNumber1++;
					names[itemNumber2] = rs.getString("author_name");
					itemNumber2++;
					surnames[itemNumber3] = rs.getString("author_surname");
					itemNumber3++;
					isbns[itemNumber4] = rs.getString("isbn");
					itemNumber4++;
					dates[itemNumber5] = rs.getString("year_published");
					itemNumber5++;
				}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < titles.length; i++) {
			System.out.println(i+1+" -> " + titles[i] + ", " + names[i] + " " + surnames[i] + ", "
										  + isbns[i] + ", " + dates[i]);
		}		
	}
	
/********************************************* DELETING DATA ********************************************/
/********************************************************************************************************/
	public static void deletingFromDatabase() {
		
		Connection();
	
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			
			String query = "DELETE FROM books WHERE title = 'newBook'";						
			PreparedStatement statement = connect.prepareStatement(query);			
			statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
/********************************************* MAIN METHOD **********************************************/
/********************************************************************************************************/
	public static void main(String[] args) {

		insertionIntoDatabase();
		selectingFromDatabase();
		deletingFromDatabase();
		selectingFromDatabase();
	}
} //end of class
