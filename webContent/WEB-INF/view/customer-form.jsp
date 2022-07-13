<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>


<head>
<title>SAVE CUSTOMER</title>
<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>
<body>
   <div id="wrapper">
   <div id="header">
   <h2>CRM- Customer Relationship Manager</h2>
   </div>
   </div>
   
   
   <div id="container">
   <h3>Save Customer</h3>
   <form:form action="saveCustomer" modelAttribute="customer" method="POST"><!-- model attribute is same as defined in controller and is used to pre rpopulate -->
   <!--saveCustomer mapping->send tp Spring MVC  -->
   <!-- modelAttribute "cusstomer" binds data to theCustomer defined in Controller -->
  <!-- need to associate data with customer id -->
  
  <form:hidden path="id"/><!-- while submit this will submit data by customer.setId()...vvimp  -->
   
   <table>
   
   <tbody>
       <tr> 
       <td><label>First name:</label></td>
   <td><form:input path="firstName"/></td>
   </tr>
   
    <tr> 
       <td><label>last name:</label></td>
   <td><form:input path="lastName"/></td>
   </tr>
   
    <tr> 
       <td><label>Email:</label></td>
   <td><form:input path="email"/></td>
   </tr>
   
   <tr> 
       <td><label></label></td>
   <td><input type="submit" value="Save" class="save"/></td>
   </tr>
   
  
   </tbody>
   </table>
   </form:form>
   
   <div style="clear; both;"></div>
   <p>
   <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
   </p>
   
   
   </div>
</body>
</html>