

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.docudigitalsds.model.entities.gestionUsuario.Rol;


public class RolTest {

    @Test
    public void testIdRoles() {
        Rol rol = new Rol();
        rol.setIdRoles(1);
        assertEquals(1, rol.getIdRoles());
    }

    @Test
    public void testRol() {
        Rol rol = new Rol();
        rol.setRol("Admin");
        assertEquals("Admin", rol.getRol());
    }

    @Test
    public void testDescripcion() {
        Rol rol = new Rol();
        rol.setDescripcion("Administrador del sistema");
        assertEquals("Administrador del sistema", rol.getDescripcion());
    }
}
