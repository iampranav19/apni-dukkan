<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ include file="./base.jsp" %>
  </head>
  <body>
    <div class="container mt-3">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <h1 class="text-center mb-3">Fill the Product Details</h1>
          <form action="saveProduct" method="post">
            <div class="form-group">
              <label for="name">Product Name</label>
              <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                aria-describedby="emailHelp"
                placeholder="Enter Product Name"
                required
              />
            </div>
            <div class="form-group">
              <label for="description">Product Description</label>
              <textarea
                class="form-control"
                name="description"
                id="description"
                rows="5"
                placeholder="Enter the Product Description"
                required
              ></textarea>
            </div>
            <div class="form-group">
              <label for="price">Product Price</label>
              <input
                type="number"
                class="form-control"
                id="price"
                name="price"
                aria-describedby="emailHelp"
                placeholder="Enter Product Price"
                required
              />
            </div>
            <div class="form-group text-center">
              <a href="/" class="btn btn btn-secondary mt-3">Back</a>
              <button type="submit" class="btn btn-success mt-3">Submit</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
