<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index_work.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
<form action="addPlant.do" method="post">
	植物名称:<input type="text" name="pname"><br>
	植物简介:<textarea rows="2" cols="20" name="content"></textarea><br>
	类别:
		<select name="tid">
			
		</select><br>
	<input type="button" value="添加" onclick="add()">
</form>
</body>
<script type="text/javascript">
	$(function(){
		$.post("getTypeList.do",{},function(obj){
			var TypeSelect = $("[name='tid']");
			TypeSelect.append("<option value='0'>==请选择==</option>");
			for (var i = 0; i < obj.length; i++) {
				TypeSelect.append("<option value='"+obj[i].tid+"'>"+obj[i].tname+"</option>");
			}
		},'json');
	});

	function add(){
		$.post("addPlant.do",$("form").serialize(),function(obj){
			if(obj>0){
				alert("添加成功");
				location = 'list.do';
			}else{
				alert("添加失败");
			}
		},'json');
	}
</script>
</html>