package testtabla;

//Importante importar la librería SQL para poder integrar la conexión de una base de datos MySQL al programa
import java.sql.*;

public class ConexionBD {

    //Estas son constantes, declaralas como constantes...
    private static final String SQL_DRIVER_URL = "jdbc:mysql://localhost:3306/predictor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static ConexionBD conexionBD = null;
    private Connection connection;
 
    // Constructor
    private ConexionBD(){
        try{
            Class.forName(DRIVER_CLASSNAME);
            connection = DriverManager.getConnection(SQL_DRIVER_URL, USERNAME, PASSWORD);
            System.out.println("Conectado!");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    } // Fin constructor

    public static synchronized ConexionBD getInstance() { //synchronized es muy importante, evita que si varios hilos quieren obtener la instancia hagan lo que se llama "racing condition"
        if(conexionBD == null) {
            conexionBD = new ConexionBD();//Fijate como asigno el valor, nunca se hacen "news al aire sin asignacion, es una mala practica, estas construyendo objeto agarras inmediatamente la referencia de ese objeto..."
        }
        return conexionBD;//Fijate como se devuelve a si mismo, y tiene control de la creacion puesto que el constructor es privado...
    }

    // Métodos
    public Connection getConnection() {//Este ya nomas va a ser unico porque todo este objeto[ConexionBD] es "singleton"(solo uno en todo el ciclo de vida de la app...)
        return connection;
    }

    public void closeConexion() throws SQLException {//O usas ingles o usas español, pero no combines... getConnection/cerrarConexion...
        if (connection != null && !connection.isClosed()) {//Siempre hay que verificar que la conexion no este cerrada ya... si intentas cerrar una conexion ya cerrada, truena...
            connection.close();
        }
    }


    // //Variables de la base de datos
    // protected Connection connBD;
    // private static final String driver = "com.mysql.cj.jdbc.Driver";
    // private static final String user = "root";
    // private static final String password = "";
    // private static final String url = "jdbc:mysql://localhost:3306/multivideo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";



    // //create an object of SingleObject
    // private static ConexionBD singletonConn = new ConexionBD();

    // //make the constructor private so that this class cannot be
    // //instantiated
    // private ConexionBD(){}

    // //Get the only object available
    // public static ConexionBD getInstance(){
    //     return singletonConn;
    // }

    // // Método singleton
    // public void hacerConexion(){
    //     connBD = null;

    //     try{
    //         Class.forName(driver);
    //         connBD = DriverManager.getConnection(url, user, password);

    //         if(connBD != null){
    //             System.out.println("Conexión establecida");
    //         }
                
    //     }catch(ClassNotFoundException | SQLException errorBD){
    //         System.out.println("Error con la BD \n" + errorBD);
    //     }
    // }

    // //Método para desconectar y cerrar base de datos
    // public void desconectarBD(){
    //     connBD = null;

    //     if(connBD == null){
    //         System.out.println("Conexión terminada");
    //     }
    // }

    // public Connection getConexion(){
    //     return connBD;
    // }

    // //Constructor de la clase para conectarse a la BD
    // public ConexionBD(){
    //     connBD = null;

        // try{
        //     Class.forName(driver);
        //     connBD = DriverManager.getConnection(url, user, password);

        //     if(connBD != null){
        //         //System.out.println("Conexión establecida");

        //         //Esta sección valida si se puede obtener información de la base de datos y mostrarlos en consola
        //         /*Statement stnt = conn.createStatement();
        //         ResultSet rs = stnt.executeQuery("select * from employees");
        //         while(rs.next()){
        //             System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6));
        //             stnt.close();
        //             conn.close();
        //         }*/
        //     }
            
    //     }catch(ClassNotFoundException | SQLException errorBD){
    //         System.out.print("PRUEBA\n\n" + errorBD);
    //     }
    // }

    // //Método para poder conectarse y hacer una instancia de este método
    // public Connection getConexion(){
    //     return connBD;
    // }
}
