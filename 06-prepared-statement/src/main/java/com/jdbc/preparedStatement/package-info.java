package com.jdbc.preparedStatement;
/*
 * A `PreparedStatement` is a concept in Java used for database access via JDBC
 * (Java Database Connectivity). It is an interface provided by the Java
 * standard library to execute parameterized SQL queries against a relational
 * database. `PreparedStatement` is a subclass of `Statement` and offers several
 * advantages over regular `Statement` objects when it comes to security,
 * performance, and maintainability.
 * 
 * Here are some key features and benefits of using `PreparedStatement`:
 * 
 * 1. **Precompilation and Caching**: When you create a `PreparedStatement`, the
 * SQL query is precompiled by the database management system. This means that
 * the query is parsed, optimized, and a query execution plan is generated. This
 * can improve the performance of subsequent executions of the same query since
 * the database doesn't have to repeat these steps.
 * 
 * 2. **Parameter Binding**: `PreparedStatement` allows you to use placeholders
 * (usually represented by `?` symbols) in your SQL queries. You can then bind
 * specific values to these placeholders, which are automatically sanitized to
 * prevent SQL injection attacks. This is a critical security feature.
 * 
 * 3. **Improved Code Readability**: By separating the SQL query from the
 * parameter values, your code becomes more readable and maintainable. It's
 * easier to see what the query does without being distracted by embedded
 * values.
 * 
 * Here's an example of how to use a `PreparedStatement` to insert data into a
 * database:
 * 
 * ```java import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.SQLException;
 * 
 * public class PreparedStatementExample { public static void main(String[]
 * args) { String jdbcUrl = "jdbc:mysql://localhost:3306/mydb"; String username
 * = "myuser"; String password = "mypassword";
 * 
 * try (Connection connection = DriverManager.getConnection(jdbcUrl, username,
 * password)) { String sql =
 * "INSERT INTO users (username, email) VALUES (?, ?)";
 * 
 * // Create a PreparedStatement PreparedStatement preparedStatement =
 * connection.prepareStatement(sql);
 * 
 * // Set parameter values preparedStatement.setString(1, "john_doe");
 * preparedStatement.setString(2, "john@example.com");
 * 
 * // Execute the query int rowsAffected = preparedStatement.executeUpdate();
 * 
 * if (rowsAffected > 0) { System.out.println("Data inserted successfully."); }
 * else { System.out.println("Data insertion failed."); } } catch (SQLException
 * e) { e.printStackTrace(); } } } ```
 * 
 * In this example, we create a `PreparedStatement` to insert a new user into a
 * database. We use placeholders `?` for the values we want to insert, and then
 * we set those values using the `setString` method, which automatically handles
 * parameter binding and sanitation.
 * 
 * Overall, `PreparedStatement` is a powerful and essential tool for working
 * with databases in Java, providing both security benefits and performance
 * improvements over regular `Statement` objects.
 * 
 * The major difference between a Statement and PreparedStatement is that, in
 * normal statement the sql statement will be compiled each and every time when
 * we try to perform operations on database where as in prepareStatement the sql
 * statement will compiled and once and will be executed multiple times without
 * compiling the statement again.
 */