<%@page import="java.util.List"%>
<%@page import="org.example.Product"%>
<!DOCTYPE html>
<%@ page session="false" %>
<html lang="en">
    <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>.card { margin: 0.75em; }</style>
    </head>
   <body>
   <div class="container-fluid">
      <h2>Hello World!</h2>
      <% List<Product> prodList=(List<Product>) request.getAttribute("products");
      out.println("<div class=\"row\">");
      for ( Product p : prodList ) {
      %>
      <div class="col-md-3">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://picsum.photos/seed/picsum<%= p.getId() %>/286/180" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title"><%= p.getName() %></h5>
          <p class="card-text"><%= p.getDescription() %></p>
        </div>
      </div>
      </div>
      <%
      }
      out.println("</div>");
      %>
      </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   </body>
</html>