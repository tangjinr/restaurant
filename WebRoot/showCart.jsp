<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>购物车</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	text="#000000" link="#000000" vlink="#000000" alink="#000000">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	bgcolor="#FFFFFF" height="100%">
	<tr valign="top">
		<td>
		<table width="98%" border="0" cellspacing="1" cellpadding="2"
			align="center">
			<tr valign="bottom">
				<td height="30"><img
					src="images/lcart_cn.gif"> <font
					color="#000000">您的购物车中有以下商品</font></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="2" cellpadding="0"
			align="center">
			<tr bgcolor=#808000>
				<td height="1" bgcolor="#999999"></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="2" cellpadding="0"
			align="center">
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="0" cellpadding="0"
			align="center">
			<tr>
				<td>
				<table width="100%" border="0" align="CENTER" cellpadding="2"
					cellspacing="1" bgcolor="#c0c0c0">
					<tr bgcolor="#dadada">
						<td height="22" width="50">
						<div align="CENTER"><font color="#000000">编号</font></div>
						</td>
						<td width="610" height="22">
						<div align="CENTER"><font color="#000000">商品名称</font></div>
						</td>
						<td height="22" width="104">
						<div align="CENTER"><font color="#000000">单价</font></div>
						</td>
						<td height="22" width="100">
						<div align="CENTER"><font color="#000000">数量</font></div>
						</td>
						<td width="116" height="22">
						<div align="CENTER"><font color="#000000">金额</font></div>
						</td>
					</tr>

					<c:forEach items="${sessionScope.cart.cartitems}" var="cartitem">
					<tr bgcolor="#ffffff">
						<td width="50" align="center" height="22"><font
							color="#000000">${cartitem.value.dish.dishid}</font></td>
						<td align="center" height="22"><font color="#000000">${cartitem.value.dish.dishname}</font>
						<input type="hidden" name="prodid" value="500047"></td>
						<td width="104" align="center" height="22"><font
							color="#000000">${cartitem.value.dish.price}</font></td>
						<td width="100" class="hh" align="center" height="22">${cartitem.value.quantity}</td>
						<td width="116" class="bb" align="center" height="22"><font
							color="#000000">${cartitem.value.totalprice}</font></td>
					</tr>
					</c:forEach>
					<tr bgcolor="#dadada">
						<td width="50" height="22" align="center"><font
							color="#000000">合计</font></td>
						<td height="22" align="center"><font color="#000000">-</font></td>
						<td width="104" height="22" align="center"><font
							color="#000000">-</font></td>
						<td width="100" class="hh" height="22" align="center"><font
							color="#000000">-</font></td>
						<td width="116" class="bb" align="center" height="22"><font
							color="#000000">${cart.amount}</font></td>
					</tr>
				</table>
				<br>
				<table width="300" border="0" cellspacing="1" cellpadding="4"
					align="CENTER" bgcolor="#c0c0c0">
					<tr bgcolor="#dadada">
						<td height="10" align="center"><a href="#"><font
							color="#000000">清空购物车</font></a></td>
						<td height="10" align="center" style="cursor:hand" onClick=""><font
							color="#000000">继续购物</font></td>
						<td height="10" align="center" style="cursor:hand" onClick=""><font
							color="#000000">生成订单</font></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br>
</body>
</html>