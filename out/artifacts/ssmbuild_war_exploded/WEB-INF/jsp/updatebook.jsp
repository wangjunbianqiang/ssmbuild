<%--
  Created by IntelliJ IDEA.
  User: 王俊
  Date: 2022/5/18
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
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
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updatebook" method="post">
        <%--前端传递信息给value属性--%>
        <%--前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${Qbook.bookID}"/> <!--添加隐藏域。实现修改后跳转回修改后的所有书籍的界面-->
        书籍名称：<input type="text" name="bookName" value="${Qbook.bookName}"><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${Qbook.bookCounts}"><br><br><br>
        书籍详情：<input type="text" name="detail" value="${Qbook.detail}"><br><br><br>
        <input type="submit" value="修改"/>
    </form>

</div>
</body>
</html>
