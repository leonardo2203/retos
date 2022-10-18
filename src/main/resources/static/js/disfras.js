function editarDisfras(){
    let idDisfras=$("#idDisfras").val();
    let nombre=$("#nombreDisfras").val();
    let marcaDisfras=$("#marcaDisfras").val();
    let año=$("#añoDisfras").val();
    let descripcion=$("#descripcionDisfras").val();

    let data={
        id:idDisfras,
        name:nombre,
        marca:marcaDisfras,
        año:año,
        descripcion:descripcion
    };
    let dataToSend=JSON.stringify(data);
    //console.log(dataToSend);
    $.ajax({
        url : '',
        type : 'PUT',
        //   dataType : 'json',
        data:dataToSend,
        contentType:'application/json',
        success : function(editar) {
            $("#idDisfras").val("");
            $("#nombreDisfras").val("");
            $("#añoDisfras").val("");
            $("#descripcionDisfras").val("");
        },
        error : function(xhr, status) {
            //     alert('ha sucedido un problema');
        },
        complete: function(){
            editarDisfras();
        }
    });

}


function borrarDisfras(idCliente){
    let data={
        id:idDisfras
    };
    let dataToSend=JSON.stringify(data);
    //console.log(dataToSend);
    $.ajax({
        url : 'http://localhost:8080/api/Costume/id',
        type : 'DELETE',
        //   dataType : 'json',
        data:dataToSend,
        contentType:'application/json',
        success : function(borrar) {
            $("#idDisfras").val("");
            $("#nombreDisfras").val("");
            $("#añoDisfras").val("");
            $("#descripcionDisfras").val("");
        },
        error : function(xhr, status) {
            //     alert('ha sucedido un problema');
        },
        complete: function(){
            borrarDisfras();
        }
    });

}

function guardarDisfras() {
    let idDisfras = $("#idDisfras").val();
    let nombre = $("#nombreDisfras").val();
    let marcaDisfras = $("#marcaDisfras").val();
    let año = $("#añoDisfras").val();
    let descripcion = $("#descripcionDisfras").val();

    let data = {
        id: idDisfras,
        name: nombre,
        marca: marcaDisfras,
        año: año,
        descripcion: descripcion
    };

    let dataToSend = JSON.stringify(data);
    //console.log(dataToSend);


    $.ajax({
        url: 'http://localhost:8080/api/Costume/update',
        type: 'POST',
        //   dataType : 'json',
        data: dataToSend,
        contentType: 'application/json',
        success: function (guardar) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#mailCliente").val("");
            $("#edadCliente").val("");
        },
        error: function (xhr, status) {
            //     alert('ha sucedido un problema');
        },
        complete: function () {
            guardarDisfras();
        }
    });
}


