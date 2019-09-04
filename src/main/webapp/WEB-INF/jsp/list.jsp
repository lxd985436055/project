<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index_work.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
<form action="list.do" method="post" id="page">
	<input type="hidden" name="cpage" value="${page.pageNum }">
	名称:<input type="text" name="pname" value="${map.pname}">
	<button>查询</button>
</form>
<form action="deleteAll.do" method="post" id="delete">
<table>
	<tr>		
		<td>全选<input type="checkbox" onclick="quan()"></td>
		<td>编号</td>
		<td>名称</td>
		<td>简介</td>
		<td>类型</td>
		<td><input type="button" value="添加" onclick="location='toAdd.do'"></td>
	</tr>
	<c:forEach items="${plantList}" var="p">
	<tr>
		<td><input type="checkbox" name="pids" value="${p.pid}"></td>
		<td>${p.pid }</td>
		<td>${p.pname }</td>
		<td>${p.content }</td>
		<td>${p.tname }</td>
		<td>
			<input type="button" value="查看" onclick="location='toLook.do?pid=${p.pid}'">
			<input type="button" value="修改" onclick="location='toUpdate.do?pid=${p.pid}'">
			<input type="button" value="删除" onclick="location='delete.do?pid=${p.pid}'">
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
			<input type="button" value="批量删除" onclick="deleteAll()">
			<input type="button" value="首页" onclick="page('1')">
			<input type="button" value="上页" onclick="page('${page.pageNum-1}')">
			<input type="button" value="下页" onclick="page('${page.pageNum+1}')">
			<input type="button" value="尾页" onclick="page('${page.pages}')">
			当前第${page.pageNum}页,共${page.pages}页
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript">
	function quan(){
		$("[name='pids']").each(function(){
			$(this).attr("checked",!$(this).attr("checked"));
		});
	}
	
	function page(cpage){
		$('[name="cpage"]').val(cpage);
		$("#page").submit();
	}

	function deleteAll(){
		$.post("deleteAll.do",$("#delete").serialize(),function(obj){
			if(obj>0){
				alert("删除成功");
				location = 'list.do';
			}else{
				alert("删除失败");
			}
		},'json');
	}
</script>
</html>