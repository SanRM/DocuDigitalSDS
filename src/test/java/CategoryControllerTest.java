import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.docudigitalsds.controller.gestionDocumentoControlller.CategoryController;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;

import jakarta.servlet.http.HttpServletRequest;

public class CategoryControllerTest {

    @Test
    public void testCreateCategory() {
        // Crear un mock del HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);

        // Crear un mock del CategoriaDao
        CategoriaDao categoriaDao = mock(CategoriaDao.class);

        // Crear una instancia de CategoryController y pasarle el CategoriaDao mockeado
        CategoryController categoryController = new CategoryController();

        // Nombre de la categoría a crear
        String nombreCategoria = "Nueva Categoría";

        // Configurar el comportamiento del mock para que devuelva el nombre de la categoría cuando se llame a getParameter
        when(request.getParameter("nuevaCategoria")).thenReturn(nombreCategoria);

        // Llamar al método createCategory
        categoryController.createCategory(request);

        // Verificar que se llama al método create en categoriaDao con la categoría adecuada
        verify(categoriaDao).create(any(Categoria.class));
    }
}
