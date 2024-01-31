<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link href="${path}/resources/css/list.css" rel="stylesheet" type="text/css">
    <title>detail.jsp</title>
</head>
<body>
<table>
    <tr>
        <th>index</th>
        <td>${board.index}</td>
    </tr>
    <tr>
        <th>writer</th>
        <td>${board.boardWriter}</td>
    </tr>
    <tr>
        <th>date</th>
        <td>${board.boardCreatedTime}</td>
    </tr>
    <tr>
        <th>hits</th>
        <td>${board.boardHits}</td>
    </tr>
    <tr>
        <th>title</th>
        <td>${board.boardTitle}</td>
    </tr>
    <tr>
        <th>contents</th>
        <td>${board.boardContents}</td>
    </tr>
</table>
<button onclick="listFn()">목록</button>
<button onclick="updateFn()">수정</button>
<button onclick="deleteFn()">삭제</button>
</body>
<script>
    const listFn = () => {
        location.href = "/board/";
    }
    const updateFn = () => {
        const uuid = '${board.uuid}';
        location.href = "/board/update?uuid=" + uuid;
    }
    const deleteFn = () => {
        const uuid = '${board.uuid}';
        location.href = "/board/delete?uuid=" + uuid;
    }
</script>
</html>