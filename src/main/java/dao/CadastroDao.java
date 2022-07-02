package dao;

// andreza do nascimento pessoa
//lidiane souza soares

import model.Customer;
import model.Order;
import model.Salesman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public CadastroDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertSalesman(Salesman salesman) throws SQLException {
        String sql = "INSERT INTO salesman (name, city, commission) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, salesman.getName());
        statement.setString(2, salesman.getCity());
        statement.setFloat(3, salesman.getCommission());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Salesman> listAllSalesman() throws SQLException {
        List<Salesman> listSalesman = new ArrayList<>();

        String sql = "SELECT * FROM salesman";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("salesman_id");
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            float commission = resultSet.getFloat("commission");

            Salesman salesman = new Salesman(id, name, city, commission);
            listSalesman.add(salesman);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listSalesman;
    }

    public boolean insertOrder(Order orders) throws SQLException {
        String sql = "INSERT INTO orders (purch_amt, ord_date, salesman_id, customer_id) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, orders.getPurch_amt());
        statement.setDate(2, new java.sql.Date(orders.getOrd_date().getTime()));
        statement.setInt(3, orders.getSalesman_id());
        statement.setInt(4, orders.getCustomer_id());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Order> listAllOrder() throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM orders";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int ord_no = resultSet.getInt("ord_no");
            float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date = resultSet.getDate("ord_date");
            int salesman_id = resultSet.getInt("salesman_id");
            int customer_id = resultSet.getInt("customer_id");

            Order orders = new Order(ord_no,purch_amt, ord_date, salesman_id, customer_id);
            listOrder.add(orders);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }

    public boolean insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (cust_name, city, grade) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getCust_name());
        statement.setString(2, customer.getCity());
        statement.setFloat(3, customer.getGrade());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Customer> listAllCustomer() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int customer_id = resultSet.getInt("customer_id");
            String cust_name = resultSet.getString("cust_name");
            String city = resultSet.getString("city");
            float grade = resultSet.getFloat("grade");
            int salesman_id = resultSet.getInt("salesman_id");

            Customer customer = new Customer(customer_id, cust_name, city, grade, salesman_id);
            listCustomer.add(customer);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listCustomer;
    }



}
