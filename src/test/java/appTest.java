import java.sql.Connection;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionDocumento.DocumentoDao;
import com.docudigitalsds.model.entities.gestionDocumento.Documento;


public class appTest {
    
    public static void main(String[] args) {
        
        //2. Metodo aprovado | Crear conexion a la base de datos
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();

        //Crear un nuevo DocumentoDao
        DocumentoDao documentoDao = new DocumentoDao(connection);

        //2. Metodo aprovado | Crear un nuevo DocumentoDao

        // Documento documento = new Documento();
        // documento.setTitulo("Documento de prueba #2");
        // documento.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        // documento.setFechaUltimaEdicion(new Timestamp(System.currentTimeMillis()));
        // documento.setDescripcion("Este es un documento de prueba #2");
        // documento.setTamaño(2.0);
        // documento.setNumeroDeFolios(15);
        // documento.setIdCategorias(1);
        // documento.setIdFechasRetencionlegal(1);
        // documento.setIdUbicacionFisica(1);

        // Insertar el Documento en la base de datos 
        //documentoDao.create(documento);

        //2. Metodo aprovado | Actualizar un Documento de la base de datos 
       // documentoDao.update(1, "descripcion", "Nueva descripción documento 1");
        //System.out.println(documento.getIdDocumento());

        //2. Metodo aprovado | Eliminar el Documento de la base de datos
        //Eliminar el Documento de la base de datos
       // documentoDao.delete(2);

        //2. Metodo aprovado | Obtener un Documento de la base de datos
        //Obtener un Documento de la base de datos y mostrarlo en consola
        //Documento getDocumento = documentoDao.get(1);
        //System.out.println(getDocumento.getTitulo());

        //2. Metodo aprovado | Obtener todos los Documentos de la base de datos
        //Obtener todos los Documentos de la base de datos y mostrarlos en consola
        for (Documento document : documentoDao.getAll()) {
            System.out.println("-----------------------");
            System.out.println(document.getIdDocumento());
            System.out.println(document.getTitulo());
            System.out.println("-----------------------");
        }

    }

}
