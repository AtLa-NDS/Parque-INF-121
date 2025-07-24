package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import personas.Trabajador;;
public class TrabajadorBD {

    public static void insertarTrabajador(Trabajador t) {
        String sql = "INSERT INTO trabajador (nombre, edad, nroId, cargo, sueldo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getNombre());
            stmt.setInt(2, t.getEdad());
            stmt.setInt(3, t.getNroId());
            stmt.setString(4, t.getCargo());
            stmt.setDouble(5, t.getSueldo());

            stmt.executeUpdate();
            System.out.println("Trabajador insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar trabajador: " + e.getMessage());
        }
    }
}
