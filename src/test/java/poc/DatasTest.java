package poc;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
public class DatasTest {
    private JdbcDatabaseTester tester;
    public void setUp() throws Exception {
        // Configuration de la connexion à la base de données
        tester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/test", "wil", "wil");
        IDatabaseConnection conn = tester.getConnection();

        // Configuration de la connexion DBUnit
        conn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());

        // Chargement des données de test
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("test-data.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(conn, dataSet);
    }
}