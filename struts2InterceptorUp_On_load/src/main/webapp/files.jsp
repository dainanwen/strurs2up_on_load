<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


  
  
  
     <s:iterator value="fileList" var="obj">
      文件存储路径
      ${obj.storePATH}:扫描的文件列表有如下：<br>
      <s:iterator value="#obj.list" var="fileNames">
       ${fileNames} <a href="<%=basePath %>download/downLoadAction_downLoad.action?path=${obj.storePATH}&fileName=${fileNames}">下载</a><br>
      </s:iterator>
      
     </s:iterator>
  
  
  
</body>
</html>