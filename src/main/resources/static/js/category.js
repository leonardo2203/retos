function traerInformacionCategoria(){




  $.ajax(
      {
  
  
          url: 'http://localhost:8080/api/Category/all',
          type: 'GET',
          dataType: 'JSON',
          data: dataToSend,
          success: function (respuesta) {
  
  
              pintarRespuestaCategoria(respuesta);
  
          },
  
          error: function (xhr, status) {
  
              alert('Opercacion no satisfactoria', +xhr, status)
          }
  
  
      });
  
  
  }
  
  
  function guardarcategoria(){
    $("#resultado").empty();
  
  let myData ={name : $("#namecategoria").val() }
  let dataToSend = JSON.stringify(myData);
  
  $.ajax(
  
  {
  
  
        url      : 'http://localhost:8080/api/Category/save',
        type : 'POST',
        dataType : 'json',
        data:dataToSend,
        contentType:'application/json',
        success : function(respuesta) {
           //console.log(respuesta);
          alert("Insercion exitosa");
           
        },
        error : function(xhr, status) {
              //     alert('ha sucedido un problema');
          },
  
  
  });
  
  }
  
  function pintarRespuestaCategoria(iteams) {
      $("#resultado").empty();
  
      let myTable = "<table>";
      myTable += "<tr><th>Codigo/th><th>Nombre</th></tr>";
      for (i = 0; i < iteams.length; i++) {
        myTable += "<tr>";
        myTable += "<td>"; iteams[i].id+ "<td>";
        myTable += "<td>"; iteams[i].name+ "<td>";
        myTable += "<tr>";
 }
  
 myTable += "</table>";
 $ ("#resultado").append(myTable);
  
  }
  