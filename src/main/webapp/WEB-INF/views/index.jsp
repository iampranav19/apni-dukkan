<%@ page import="com.pranav.entity.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ include file="./base.jsp" %>
  </head>
  <body>
    <div class="container mt-3">
      <div class="col-md-12">
        <h1 class="text-center">Welcome to Apni Desi Dukkan</h1>
        <table class="table table-dark">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Product Name</th>
              <th scope="col">Product Description</th>
              <th scope="col">Price</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <%
    List<Product> productList = (List<Product>) request.getAttribute("productList");
    if (productList.isEmpty()) {
%>
    <tr>
      <div class="container text-center">
        <td colspan="4" class="text-center text-secondary">No products found</td>
      </div>
    </tr>
<%
    } else {
        for (Product product : productList) {
%>
    <tr>
        <td>Product- <%= product.getPId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getDescription() %></td>
        <td class="font-weight-bold">&#8377; <%= product.getPrice() %></td>
        <td>
          <a href="/delete/<%= product.getPId() %>" ><i class="fa-sharp fa-solid fa-trash text-danger"></i></a>
          <a href="/update?pid=<%= product.getPId() %>"><i class="fa-solid fa-pen"></i></a>
        </td>
        
    </tr>
<%
        }
    }
%>

          </tbody>
        </table>
        <div class="container text-center">
          <a href="add" class="btn btn btn-dark">Add Product</a>
        </div>
      </div>
    </div>
  </body>
</html>
