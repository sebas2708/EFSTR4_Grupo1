$(document).on("click", "#btnagregar", function(){
    $("#txtnomprue").val("");
    $("#txtdescprue").val("");
    $("#hddpruecod").val("0");

    $("#modalpruebas").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomprue").val($(this).attr("data-pruetipo"));
    $("#txtdescprue").val($(this).attr("data-pruedesc"));
    $("#hddpruecod").val($(this).attr("data-pruecod"));

    $("#modalpruebas").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/pruebas/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddpruecod").val(),
            tipo_prueba: $("#txtnomprue").val(),
            descripcion: $("#txtdescprue").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarPruebas()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalpruebas").modal("hide");
});

function listarPruebas(){
    $.ajax({
        type: "GET",
        url: "/pruebas/list",
        datatype:"json",
        success: function(resultado){
            $("#tblpruebas > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblpruebas > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.tipo_prueba}</td>`+
                `<td>${value.descripcion}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-pruecod="${value.id}" `+
                    `data-pruetipo="${value.tipo_prueba}" `+
                    `data-pruedesc="${value.descripcion}">Actualizar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}