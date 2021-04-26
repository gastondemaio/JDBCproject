package data;


import java.sql.*;
import java.util.*;
import domain.Person;
import static data.Conection.*;



public class PersonDAO {
    private static final String SQL_SELECT = "SELECT id_person, name, lastName, cellphone, email FROM person";
    private static final String SQL_INSERT = "INSERT INTO person (name, lastName, cellphone, email) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE person SET name = ?, lastName = ?, cellphone = ?, email = ? WHERE id_person = ?";
    private static final String SQL_DELETE = "DELETE FROM person WHERE id_person = ? ";

    public List<Person> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPerson = rs.getInt("id_person");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String cellphone = rs.getString("cellphone");
                String email = rs.getString("email");

                person = new Person(idPerson, name, lastName, cellphone, email);

                persons.add(person);
            }

        } catch (SQLException exception) {
            exception.printStackTrace(System.out);
        }
        finally {
            try {
                close(conn);
                close(stmt);
                close(rs);
            } catch (SQLException exception) {
                exception.printStackTrace(System.out);
            }
        }


        return persons;
    }

    public int insert(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getCellphone());
            stmt.setString(4, person.getEmail());
            records = stmt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException exception) {
                exception.printStackTrace(System.out);
            }
        }
        return records;
    }

    public int update(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getCellphone());
            stmt.setString(4, person.getEmail());
            stmt.setInt(5, person.getIdPerson());
            records = stmt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException exception) {
                exception.printStackTrace(System.out);
            }
        }
        return records;
    }

    public int delete(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, person.getIdPerson());
            records = stmt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException exception) {
                exception.printStackTrace(System.out);
            }
        }
        return records;
    }

}
