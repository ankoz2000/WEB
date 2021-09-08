$(document).ready(function() {
    $('.delete').on('click', function() {
         let note = $(this).parent().next();
         let content = note.html();
         let id = content.split(".")[0];
         alert('IndexOf: ' + id);
         let url = 'notes/' + id + '?delete';
         let toDelete = $(this).parent().parent();
         $.ajax(url, {
             type: "POST",//Метод передачи
             data: id,//Передаваемые данные в JSON - формате
             url: 'DispatcherServlet',//Название сервлета
             success: function(content) {
                toDelete.remove();
                alert(toDelete);
                 alert('Element ' + id + " removed successfully");
             },
             error: function(e) {
                 alert('Element ' + id + " may not be deleted");
             }
         })
     });

});