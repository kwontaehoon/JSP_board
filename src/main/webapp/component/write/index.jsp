<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-07-02
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <script>

        let category = "";

        const categoryFunc = (category) => {
            console.log(123);
            console.log(category);
            this.category = category;
        }

        const submitFunc = () => {

            const category = this.category;
            const title = document.querySelector('input[name="title"]').value;
            const content = document.querySelector('input[name="content"]').value;
            const nickname = document.querySelector('input[name="nickname"]').value;

            const data = {
                userId: 123,
                category: category,
                subCategory: 'subCategory',
                title: title,
                content: content,
                nickname: nickname
            }

            fetch('/boardWrite', {
                method: 'post',
                headers: {
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(data)
            })
        }
    </script>
</head>
<body>
<jsp:include page="/component/header/index.jsp" />
<jsp:include page="/component/main/search/index.jsp" />
<div class="md:px-40 px-20">
    <div class="my-12 bg-red-400 py-16 px-3 font-bold text-white rounded-lg">롤체 게시판</div>
    <div class="flex my-3 gap-1 text-xs">
        <div onclick="categoryFunc('롤체 게시판')" class="border rounded px-2 py-1">롤체 게시판</div>
        <div onclick="categoryFunc('팁/공략')" class="border rounded px-2 py-1">팁/공략</div>
        <div onclick="categoryFunc('홍보 게시판')" class="border rounded px-2 py-1">홍보 게시판</div>
    </div>
    <div class="flex justify-end text-xs gap-1">
        <div class="border rounded px-2 py-1">생강편 말랑이</div>
        <div class="border rounded px-2 py-1">로그아웃</div>
    </div>
    <div class="my-5">
        <div class="text-xs mb-2">닉네임</div>
        <input name="nickname" class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">제목</div>
        <input name="title" class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">내용</div>
        <input name="content" class="h-40 border mb-4 w-[300px] rounded px-3 py-1" />
    </div>
    <span onclick="submitFunc()" class="text-xs px-2 py-1 text-white bg-red-400 rounded">게시글 등록</span>
</div>
</body>
</html>
