
    function guardarAdmin() {
        let idAdmin = $("#idAdmin").val();
        let nombre = $("#nombreAdmin").val();
        let mailAdmin = $("#mailAdmin").val();
        let password = $("#passwordAdmin").val();

        let data = {
            id: idAdmin,
            name: nombre,
            email: mailAdmin,
            password: password
        };

        let dataToSend = JSON.stringify(data);
        //console.log(dataToSend);


        $.ajax({
            url: 'http://localhost:8080/api/Admin/save',
            type: 'POST',
            //   dataType : 'json',
            data: dataToSend,
            contentType: 'application/json',
            success: function (guardaradmin) {
                $("#idAdmin").val("");
                $("#nombreAdmin").val("");
                $("#mailAdmin").val("");
                $("#passwordAdmin").val("");
            },
            error: function (xhr, status) {
                //     alert('ha sucedido un problema');
            },
            complete: function () {
                guardarAdmin();
            }

        });
    }


    function leerAdmin(){
//FUNCION GET
        $.ajax({
            url : '',
            type : 'GET',
            dataType : 'json',

            success : function(Admin) {
                let cs=admin.items;
                $("#listaAdmin").empty();
                for(i=0;i<cs.length;i++){
                    $("#listaAdmin").append(cs[i].id+" <b>"+cs[i].name+"</b> "+cs[i].email+" ");
                    $("#listaAdmin").append("<button onclick='borrarAdmin("+cs[i].id+")'>Borrar</button><br>");

                }
            },
            error : function(xhr, status) {
                alert('ha sucedido un problema');
            }
        });
    }


    function editarAdmin(){
        let idAdmin = $("#idAdmin").val();
        let nombre = $("#nombreAdmin").val();
        let mailAdmin = $("#mailAdmin").val();
        let password = $("#passwordAdmin").val();

        let data = {
            id: idAdmin,
            name: nombre,
            email: mailAdmin,
            password: password
        };
        let dataToSend=JSON.stringify(data);
        //console.log(dataToSend);
        $.ajax({
            url : 'http://localhost:8080/api/Admin/',
            type : 'PUT',
            //   dataType : 'json',
            data:dataToSend,
            contentType:'application/json',
            success : function(editarAdmin) {
                $("#idAdmin").val("");
                $("#nombreAdmin").val("");
                $("#mailAdmin").val("");
                $("#passwordAdmin").val("");
                },

            error : function(xhr, status) {
                //     alert('ha sucedido un problema');
            },
            complete: function(){
                editarAdmin();
            }
        });

    }

    function borrarAdmin(idAdmin){
        let data={
            id:idAdmin
        };
        let dataToSend=JSON.stringify(data);
        //console.log(dataToSend);
        $.ajax({
            url : 'http://localhost:8080/api/Admin/id',
            type : 'DELETE',
            //   dataType : 'json',
            data:dataToSend,
            contentType:'application/json',
            success : function(borrarAdmin) {
                $("#idAdmin").val("");
                $("#nombreAdmin").val("");
                $("#mailAdmin").val("");
                $("#passwordAdmin").val("");
            },
            error : function(xhr, status) {
                //     alert('ha sucedido un problema');
            },
            complete: function(){
                borrarAdmin();
            }
        });

    }










