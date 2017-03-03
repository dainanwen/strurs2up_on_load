<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="<%=basePath %>sys/deleteAction_delete.action">删除操作</a><br>
  <a href="<%=basePath %>sys/updateAction_update.action">修改操作</a><br>
  <a href="<%=basePath %>sys/saveAction_save.action">新增操作</a>
  <a href="<%=basePath %>sys/selectAction_select.action">查询操作</a>
  <br>
  <a href="<%=basePath %>scan/scanFilesAction_scanFiles.action">检索文件列表信息</a>
</body>
</html>