function guardaradmin(){
    $("#guardar").empty();

    function guardarCliente() {
        let idCliente=$("#idCliente").val();
        let nombre=$("#nombreCliente").val();
        let mailCliente=$("#mailCliente").val();
        let edad=$("#edadCliente").val();

        let data={
            id:idCliente,
            name:nombre,
            email:mailCliente,
            age:edad
        };

        let dataToSend=JSON.stringify(data);
        //console.log(dataToSend);


        $.ajax({
            url : 'https://g63fff1066a70d4-rpdx9iaeumkh4lwu.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
            type : 'POST',
            //   dataType : 'json',
            data:dataToSend,
            contentType:'application/json',
            success : function(pepito) {
                $("#idCliente").val("");
                $("#nombreCliente").val("");
                $("#mailCliente").val("");
                $("#edadCliente").val("");
            },
            error : function(xhr, status) {
                //     alert('ha sucedido un problema');
            },
            complete: function(){
                leerClientes();
            }
        });








