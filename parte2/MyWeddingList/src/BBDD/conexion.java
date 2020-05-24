package BBDD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
// en esta clase se hace la conexion con la base de datos, se añade clave y usuario para hacerla posible
public class conexion {
    //nombre de la base de datos
    private final String base = "listadeinvitados";
	//nombre de usuario que hara la conexion
    private final String user = "root";
	//clave que hara la conexion
    private final String password = "manolo1";
	//numero de puerto al que ira la bbdd
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }

	

}
