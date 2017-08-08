<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>掲示板アプリケーション</h2>
<form:form modelAttribute="articleForm" action="${pageContext.request.contextPath}/article/add">
投稿者名：<form:input path="name"/><br>
投稿内容：<form:input path="content"/><br>
<input type="submit" value="記事投稿"><br>
</form:form>
<c:forEach var="article" items="${articleList}">
投稿ID:<c:out value="${article.id}"/><br>
投稿者名：<c:out value="${article.name}"/><br>
投稿内容：<c:out value="${article.content}"/><br>
<form:form modelAttribute="articleForm" action="${pageContext.request.contextPath}/article/deleteArticle">
<form:hidden path="id" value="${article.id}"/>
<input type="submit" value="記事削除"><br>
</form:form>
<c:forEach var="Comment" items="${article.commentList}">
コメントID：<c:out value="${Comment.id}"/><br>
コメント者名：<c:out value="${Comment.name}"/><br>
コメント内容：<c:out value="${Comment.content}"/><br>
</c:forEach>
<form:form modelAttribute="commentForm" action="${pageContext.request.contextPath}/article/commentadd">
コメント者名：<form:input path="name"/><br>
コメント内容：<form:input path="content"/><br>
<form:hidden path="article_id" value="${article.id}"/>
<input type="submit" value="コメント投稿">
</form:form>
</c:forEach>
</body>
</html>