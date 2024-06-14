$(document).ready(function () {
    $("#loadData").click(function () {
        $.ajax({
            url: 'https://www.tongtongball.com/api/search/recommend/list',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                var jsonData = JSON.stringify(data);
                $("#dataList").text(jsonData);
            },
            error: function (xhr, status, error) {
                console.error("AJAX Error: ", status, error);
            }
        });
    });
});

$(document).ready(function () {
    // 페이지가 로드되면 AJAX 요청을 보냅니다
    $.ajax({
        url: 'https://www.tongtongball.com/api/search/recommend/list',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            var dataList = $("#test");

            $.each(data, function (index, item) {
                console.log(item);
                var listItem = $("<div class='text-3xl'></div>").text(item.content);
                dataList.append(listItem);
            });
        },
        error: function (xhr, status, error) {
            console.error("AJAX Error: ", status, error);
        }
    });
});