
$(document).ready(function() {
    let idOpened = [];
    $('.parent').on('click', function(){
        let dictionaryId = $(this).next().find(".add").attr("id");
        if (!idOpened.includes(dictionaryId)) {
            let url = "notes/" + dictionaryId + "?get";
            let strId = "#" + dictionaryId;
            $.ajax(url, {
                type: 'GET',
                success: function(content) {
                    $(strId).parent().parent().parent().append(content);
                    $("#toBeDelete").remove();
                    let src = $("#toBeDelete").attr("src");
                    $("body").append('<script id="toBeDelete" src="res/js/additional.js"></script>')
                }
            });
            idOpened.push(dictionaryId);
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

});