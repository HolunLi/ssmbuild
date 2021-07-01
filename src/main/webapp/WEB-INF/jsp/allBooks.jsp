<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书籍列表</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header" >
                <table>
                    <tr>
                        <td style="width: 400px;" >
                            <h1>
                            <small>书籍列表 —— 显示所有书籍</small>
                            </h1>
                        </td>
                        <td style="width: 900px;" align="right">
                            <h1><a href="${pageContext.request.contextPath}/user/logout" style="font-size: 18px; text-decoration: none" >退出登录</a></h1>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBookPage">新增</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBooks">显示全部书籍</a>
        </div>
        <div class="col-md-4 column" ></div>
        <div class="col-md-4 column">
           <!-- 搜索框 -->
            <form action="${pageContext.request.contextPath}/book/queryBooksByName" method="post" class="form-inline">
                <input type="text" name="bookName" class="form-control" placeholder="请输入书籍名称" required />
                <input type="submit" value="搜索" class="btn btn-primary" />
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
                <c:forEach var="book" items="${requestScope.books}">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetail()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBookPage?id=${book.bookID}">修改</a> |
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
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
