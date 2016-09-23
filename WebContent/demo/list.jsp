<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style type="text/css">
body {
	margin: 30px 30px 30px 30px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal" role="form">
		<table class="table">
			<tr>
				<td><div class="form-group">
						<label class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Username">
						</div>
					</div></td>
				<td><div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Email">
						</div>
					</div></td>
				<td>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">状态</label>
						<div class="col-sm-10">
							<select class="form-control">
								<option>Please Select</option>
								<option>在职</option>
								<option>离职</option>
							</select>
						</div>
					</div>
				</td>
			</tr>
		</table>

		
		
		<table width="100%">
			<tr align="center">
				<td>
					<button type="button" class="btn btn-primary">查询</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-default">重置</button>
				</td>
			</tr>
		</table>
		
	</form>

	<br/><br/>
	
	<table class="table table-hover">
		<tr>
			<th>#</th>
			<th>姓名</th>
			<th>邮箱</th>
			<th>手机</th>
			<th>状态</th>
			<th>部门</th>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>zhangsan@icloud.com</td>
			<td>13700000000</td>
			<td>正常</td>
			<td>测试部门</td>
		</tr>
		<tr>
			<td>2</td>
			<td>张三</td>
			<td>zhangsan@icloud.com</td>
			<td>13700000000</td>
			<td>正常</td>
			<td>测试部门</td>
		</tr>
		<tr>
			<td>3</td>
			<td>张三</td>
			<td>zhangsan@icloud.com</td>
			<td>13700000000</td>
			<td>正常</td>
			<td>测试部门</td>
		</tr>
		<tr>
			<td>4</td>
			<td>张三</td>
			<td>zhangsan@icloud.com</td>
			<td>13700000000</td>
			<td>正常</td>
			<td>测试部门</td>
		</tr>
		<tr>
			<td>5</td>
			<td>张三</td>
			<td>zhangsan@icloud.com</td>
			<td>13700000000</td>
			<td>正常</td>
			<td>测试部门</td>
		</tr>
	</table>

	<table width="100%">
		<tr>
			<td align="left">
				<p>共 100 行结果，当前是第 1 到 5 行</p>
			</td>
			<td align="right">
				<div class="btn-group">
					<button type="button" class="btn btn-default">&#60;&#60;</button>
					<button type="button" class="btn btn-default">&#60;</button>
					<button type="button" class="btn btn-default">1</button>
					<button type="button" class="btn btn-default">2</button>
					<button type="button" class="btn btn-default">3</button>
					<button type="button" class="btn btn-default">...</button>
					<button type="button" class="btn btn-default">10</button>
					<button type="button" class="btn btn-default">&#62;</button>
					<button type="button" class="btn btn-default">&#62;&#62;</button>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>