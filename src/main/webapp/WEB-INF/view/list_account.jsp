<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->

</head>
<body>
<h3>查询所有账户</h3>

<c:forEach items="${accounts}" var="account">
    ${account.name}
</c:forEach>

<form>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">File input</label>
        <input type="file" id="exampleInputFile">
        <p class="help-block">Example block-level help text here.</p>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Check me out
        </label>
    </div>
    <button type="submit" class="btn btn-default" id="btn_1">Submit</button>
</form>

<script type="text/javascript" src="/js/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/layer/layer/layer.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#btn_1').click(function () {
            layer.alert('内容')
            //第三方扩展皮肤
        })
    })
</script>
</body>
</html>