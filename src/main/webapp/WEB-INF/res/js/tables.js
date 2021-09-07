
$(document).ready(function() {
    let idOpened = [];
    $('.parent').on('click', function(){
    let dictionaryId = $(this).next().find(".add").attr("id");
    let url = "notes/" + dictionaryId + "?get";
    let strId = "#" + dictionaryId;
    if ($(this).next().children().map(function(elem) {

    }
    )) {
        $.ajax(url, {
            type: 'GET',
            success: function(content) {
                $(strId).parent().parent().parent().append(content);
            }
        });
    }
        $(this).next('.hide').toggle();
    });

    $('.add').on('click', function() {
        let dictionaryId = $(this).attr("id");
        let url = "dictionaries/" + dictionaryId + "?new";
        $.get(url);
        $.ajax({
            type: 'GET',
            url: url,
            contentType: 'multipart/form-data; charset=UTF-8',
            success: function(content) {
                $(location).attr('href', url);
            }
        });
    });


    $('.delete').on('click', function() {
        let note = $(this).parent().next();
        let content = note.html();
        let id = content.slice(0, 1);
        let url = 'dictionaries/' + id + '?delete';
        $.ajax(url, {
            type: "POST",//Метод передачи
            data: id,//Передаваемые данные в JSON - формате
            url: 'DispatcherServlet',//Название сервлета
            success:function(serverData) {
                $(location).attr('href', "/dictionaries?show");
                alert('Element ' + id + " removed successfully");
            },
            error: function(e) {
                alert('Element ' + id + " may not be deleted");
            }
        })
    });

});