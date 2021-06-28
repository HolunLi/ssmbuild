<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍信息</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${requestScope.book.bookID}"/>
        书籍名称：<input type="text" name="bookName" value="${requestScope.book.bookName}" required />
        书籍数量：<input type="text" name="bookCounts" value="${requestScope.book.bookCounts}" required />
        书籍详情：<input type="text" name="detail" value="${requestScope.book.detail}" required />
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>
