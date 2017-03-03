<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" >
  function changeStorePath(obj){
	 var value= obj.value;
	 document.forms[0].setAttribute("action","<%=basePath %>store/fileUploadAction_upload.action?flag="+value);
  }
</script>
</head>
<body>
  ${msg}
  <br>
  下面实现文件是上传操作
  <form action="<%=basePath %>store/fileUploadAction_upload.action" method="post"  enctype="multipart/form-data">
    文件：<input type="file" name="myfile"><br>
    文件存储位置：项目根目录：<input type="radio" name="flag" value="0" onclick="changeStorePath(this)">
            非项目目录：<input type="radio" name="flag" value="1" onclick="changeStorePath(this)">
     注：不选择目录则认为非项目根目录
  <input type="submit" value="提交">
  </form>
</body>
</html>