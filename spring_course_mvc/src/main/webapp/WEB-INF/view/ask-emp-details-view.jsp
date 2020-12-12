<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <style>
        .errorString {
            color: red;
        }
        .errorInt {
            color: blue;
        }
    </style>
    <title></title>
</head>

<body>

<h2>Dear Employee, Please enter your details</h2>

<br>
<br>

<form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"/>
    <form:errors path="name" cssClass="errorString"/>
    <br><br>
    Surname <form:input path="surname" />
    <form:errors path="surname" cssClass="errorString"/>
    <br><br>
    Salary <form:input path="salary"/>
    <form:errors path="salary"  cssClass="errorInt"/>
    <br><br>
    Department
    <form:select path="department">
        <form:options items="${employee.departments}" />
<%--        <form:option value="Information Technology" label="IT" />--%>
<%--        <form:option value="Human Resources" label="HR" />--%>
<%--        <form:option value="Sales" label="Sales" />--%>
    </form:select>
    <br><br>
    Which car do you want?
<%--    BMW <form:radiobutton path="carBrand" value="BMW" />--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi" />--%>
<%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz" />--%>
    <form:radiobuttons path="carBrand" items="${employee.carBrands}" />
    <br><br>
    Foreign Language(s)
<%--    EN <form:checkbox path="languages" value="English" />--%>
<%--    DE <form:checkbox path="languages" value="Deutch" />--%>
<%--    FR <form:checkbox path="languages" value="French" />--%>
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <br><br>
    Phone number <form:input path="phoneNumber" />
    <form:errors path="phoneNumber" cssClass="errorString" />
    <br><br>
    Email <form:input path="email" />
    <form:errors path="email" cssClass="errorString" />
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>

</html>
