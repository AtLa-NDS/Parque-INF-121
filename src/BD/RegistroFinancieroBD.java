package BD;

import personas.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroFinancieroBD {

    public static void guardarRegistro(double ingreso, double gasto) {
        String sql = "INSERT INTO registroFinanciero (ingreso, gasto) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, ingreso);
            stmt.setDouble(2, gasto);
            stmt.executeUpdate();
            System.out.println("Registro guardado en la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos:");
            e.printStackTrace();
        }
    }
}
