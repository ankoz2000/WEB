$(document).ready(function() {
    $('.delete').on('click', function() {
         let note = $(this).parent().next();
         let content = note.html();
         let id = content.split(".")[0];
         let url = 'notes/' + id + '?delete';
         let toDelete = $(this).parent().parent();
         $.ajax(url, {
             type: "POST",//Метод передачи
             data: id,//Передаваемые данные в JSON - формате
             url: 'DispatcherServlet',//Название сервлета
             success: function(content) {
                toDelete.remove();
                 alert('Element ' + id + " removed successfully");
             },
             error: function(e) {
                 alert('Element ' + id + " may not be deleted");
             }
         })
     });

         $('.edit').on('click', function() {
              let note = $(this).parent().next();
              let content = note.html();
              let id = content.split(".")[0];
              let url = 'notes/' + id + '?edit';
              let toDelete = $(this).parent().parent();
              $.ajax(url, {
                  type: "GET",//Метод передачи
                  url: 'DispatcherServlet',//Название сервлета
                  success: function(content) {
                    $(location).attr('href', url);
                  }
              })
          });

});