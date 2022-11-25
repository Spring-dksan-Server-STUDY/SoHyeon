package com.dksanServer.sohyeon.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerJdbcRepository implements CustomerRepository {
    private static final Logger logger = LoggerFactory.getLogger(CustomerJdbcRepository.class);

    private static final String url = "jdbc:mysql://localhost/anmuserver";
    private static final String user = "root";
    private static final String password = "root1234!";

    @Override
    public Customer insert(Customer customer) {
        String INSERT_SQL = "INSERT INTO customers(customer_id, name, age, email, created_at) " +
                "VALUES (UUID_TO_BIN(?), ?, ?, ?, ?)";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
        ) {
            statement.setBytes(1, customer.getCustomerId().toString().getBytes());
            statement.setString(2, customer.getName());
            statement.setInt(3, customer.getAge());
            statement.setString(4, customer.getEmail());
            statement.setTimestamp(5, Timestamp.valueOf(customer.getCreateAt()));
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("[INSERT] sql error", e);
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        String UPDATE_SQL = "UPDATE customers SET name = ?, age = ? WHERE email = ?";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
        ) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("[UPDATE] sql error", e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        String FIND_ALL_SQL = "SELECT * FROM customers";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                UUID customerId = toUUID(resultSet.getBytes("customer_id"));
                String customerName = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                customers.add(new Customer(customerId, customerName, age, email, createdAt));
            }
        } catch (SQLException e) {
            logger.error("[FIND_ALL] sql error", e);
        }
         return customers;
    }

    private static UUID toUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

    @Override
    public Optional<Customer> findById(UUID customerId) {
        List<Customer> customers = new ArrayList<>();
        String FIND_BY_ID_SQL = "SELECT * FROM customers WHERE customer_id = UUID_TO_BIN(?)";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL);
        ) {
            statement.setBytes(1, customerId.toString().getBytes());
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UUID id = toUUID(resultSet.getBytes("customer_id"));
                    String customerName = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                    customers.add(new Customer(id, customerName, age, email, createdAt));
                }
            }
        } catch (SQLException e) {
            logger.error("[FIND_ALL] sql error", e);
        }

        if (customers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(customers.get(0));
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String FIND_BY_NAME_SQL = "SELECT * FROM customers WHERE name = ?";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME_SQL);
        ) {
            statement.setString(1, name);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UUID id = toUUID(resultSet.getBytes("customer_id"));
                    String customerName = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                    customers.add(new Customer(id, customerName, age, email, createdAt));
                }
            }
        } catch (SQLException e) {
            logger.error("[FIND_NAME] sql error", e);
        }
        return customers;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {
        String DELETE_SQL = "DELETE FROM customers";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(DELETE_SQL);
        ) {
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("DELETE error", e);
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerJdbcRepository();
        repository.deleteAll();
    }
}
