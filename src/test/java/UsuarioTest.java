
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import org.junit.jupiter.api.Test;
import com.docudigitalsds.model.entities.gestionUsuario.Usuario;

public class UsuarioTest {

    @Test
    public void testIdUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        assertEquals(1, usuario.getIdUsuario());
    }

    @Test
    public void testNombre() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Santi");
        assertEquals("Santi", usuario.getNombre());
    }

    @Test
    public void testApellidoPaterno() {
        Usuario usuario = new Usuario();
        usuario.setApellidoPaterno("Perez");
        assertEquals("Perez", usuario.getApellidoPaterno());
    }

    @Test
    public void testApellidoMaterno() {
        Usuario usuario = new Usuario();
        usuario.setApellidoMaterno("Gomez");
        assertEquals("Gomez", usuario.getApellidoMaterno());
    }

    @Test
    public void testEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("santi@example.com");
        assertEquals("santi@example.com", usuario.getEmail());
    }

    @Test
    public void testContraseña() {
        Usuario usuario = new Usuario();
        usuario.setContraseña("password123");
        assertEquals("password123", usuario.getContraseña());
    }

    @Test
    public void testFechaCreacion() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Usuario usuario = new Usuario();
        usuario.setFechaCreacion(now);
        assertEquals(now, usuario.getFechaCreacion());
    }

    @Test
    public void testFechaUltimaEdicion() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Usuario usuario = new Usuario();
        usuario.setFechaUltimaEdicion(now);
        assertEquals(now, usuario.getFechaUltimaEdicion());
    }

    @Test
    public void testIdRoles() {
        Usuario usuario = new Usuario();
        usuario.setIdRoles(2);
        assertEquals(2, usuario.getIdRoles());
    }

    @Test
    public void testEmailValido() {
        Usuario usuario = new Usuario();
        usuario.setEmail("santi@example.com");
        assertTrue(usuario.emailValido());

        usuario.setEmail("santiexample.com");
        assertFalse(usuario.emailValido());
    }
}
