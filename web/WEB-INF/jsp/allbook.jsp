<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王俊
  Date: 2022/5/18
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <%--新增书籍--%>
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toaddbook">新增</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allbook">显示全部书籍</a>
        </div>
        <%--查询书籍--%>
        <div class="col-md-8 column">
            <form action="${pageContext.request.contextPath}/book/queryBookByName" method="post" style="float:right">
                <span style="color: red;font-weight: bold">${error}</span>
                <input type="text" name="queryBookName" placeholder="请输入要查询的书籍名称"> <!--name中的值时要传回后端的-->
                <input type="submit" value="查询">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>

<%--                            <a href="${pageContext.request.contextPath}/book/toupdatebook?id=${book.getBookID()}">更改</a> |--%>
                            <a href="${pageContext.request.contextPath}/book/toupdatebook?id=${book.bookID}">更改</a> |
<%--                            <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>--%>
<%--                            <a href="${pageContext.request.contextPath}/book/del/${book.bookID}">删除</a>  restful风格出现了错误--%>
                            <a href="${pageContext.request.contextPath}/book/del?id=${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
