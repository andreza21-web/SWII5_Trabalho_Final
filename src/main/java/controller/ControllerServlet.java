package controller;

import dao.CadastroDao;
import model.Customer;
import model.Order;
import model.Salesman;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CadastroDao cadastroDao;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        cadastroDao = new CadastroDao(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newCustomer":
                    showNewFormCustomer(request, response);
                    break;
                case "/insertCustomer":
                    insertCustome(request, response);
                    break;
                case "/newOrder":
                    showNewFormOrder(request, response);
                    break;
                case "/insertOrder":
                    insertOrders(request, response);
                    break;
                case "/newSalesman":
                    showNewFormSalesman(request, response);
                    break;
                case "/insertSalesman":
                    insertsalesman(request, response);
                    break;
                case "/listSalesman":
                    listSalesman(request, response);
                    break;
                case "/listOrder":
                    listOrder(request, response);
                    break;
                case "/listCustomer":
                    listCustomer(request, response);
                    break;
                default:
                    creditosDupla(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void creditosDupla(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("creditosAlunos.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = cadastroDao.listAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Order> listOrder = cadastroDao.listAllOrder();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
        dispatcher.forward(request, response);
    }

    private void listSalesman(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Salesman> listSalesman = cadastroDao.listAllSalesman();
        request.setAttribute("listSalesman", listSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
        dispatcher.forward(request, response);
    }

    private void insertsalesman(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float commission = Float.parseFloat(request.getParameter("comission"));

        Salesman newSalesman = new Salesman(name, city, commission);
        cadastroDao.insertSalesman(newSalesman);
        response.sendRedirect("listSalesman");
    }

    private void insertOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        float purch_amt = Float.parseFloat(request.getParameter("purch_amt"));
        Date ord_date = Date.valueOf(request.getParameter("ord_date"));
        int customer_id = Integer. parseInt(request.getParameter("customer_id"));
        int salesman_id = Integer. parseInt(request.getParameter("salesman_id"));

        Order newOrders = new Order(purch_amt, ord_date, customer_id, salesman_id);
        cadastroDao.insertOrder(newOrders);
        response.sendRedirect("listOrder");
    }

    private void insertCustome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cust_name = request.getParameter("cust_name");
        String city = request.getParameter("city");
        float grade = Float.parseFloat(request.getParameter("grade"));

        Customer newCustomer = new Customer(cust_name, city, grade);
        cadastroDao.insertCustomer(newCustomer);
        response.sendRedirect("listCustomer");
    }
    private void showNewFormOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewFormSalesman(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        dispatcher.forward(request, response);
    }

}
