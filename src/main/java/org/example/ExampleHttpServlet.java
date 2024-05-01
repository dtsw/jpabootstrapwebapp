package org.example;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExampleHttpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ( null != request.getParameter("test")
        ) {
            if ( request.getParameter("test").isEmpty() ) {
                response.sendRedirect("login.jsp");
                return;
            }
            request.setAttribute("name", "Oliver Frick");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.write("Servlet 3 web.xml example configuration");

            Faker faker = new Faker();

            EntityManagerFactory entityManagerFactory = null;
            EntityManager entityManager = null;

            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("OrderManagement");
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();

                for (int i = 0; i < 500; i++) {
                    Book b = faker.book();
                    Product p = new Product();
                    p.setName(b.title());
                    p.setDescription("Book of genre: " + b.genre());
                    entityManager.persist(p);
                }

                entityManager.getTransaction().commit();

//            Long id = b.getId();
//            Product a = entityManager.find(Product.class, id);

//            if ( null != a ) {
//                out.println(a.getName());
//            }
                List<Product> allProds =
                        entityManager.createQuery(
                                        "SELECT p FROM Product p")
                                .getResultList();
                request.setAttribute("products", allProds);
                getServletContext().getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

            } finally {
                try {
                    entityManager.close();
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ( null != request.getParameter("username" ) && null != request.getParameter("password")
        ) {
            String username = request.getParameter("username" );
            String password = request.getParameter("password" );
            if ( username.isEmpty() || password.isEmpty() ) {
                PrintWriter out = response.getWriter();
                out.write("No login information in request");
                return;
            }
            PrintWriter out = response.getWriter();
            out.write("Welcome " + username);
        } else {
            PrintWriter out = response.getWriter();
            out.write("No login information in request");
        }
    }
}
