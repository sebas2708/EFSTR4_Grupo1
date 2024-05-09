$(document).on("click", "#btnagregar", function(){
    $("#txtnomequi").val("");
    $("#hddequicod").val("0");
    listarCboEntrenador(0, 0);

    $("#modalequipos").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomequi").val($(this).attr("data-equinom"));
    $("#hddequicod").val($(this).attr("data-equicod"));
    $("#cboentrenador").empty();
    listarCboEntrenador($(this).attr("data-equient"));
    $("#modalequipos").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/equipos/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddequicod").val(),
            nombre_equipo: $("#txtnomequi").val(),
            entrenador: $("#cboentrenador").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarequipos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalequipos").modal("hide");
});

function listarequipos(){
    $.ajax({
        type: "GET",
        url: "/equipos/list",
        datatype:"json",
        success: function(resultado){
            $("#tblequipo > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblequipo > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.nombre_equipo}</td>`+
                `<td>${value.entrenador.nombre + ' ' + value.entrenador.apellido}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-libcod="${value.id}" `+
                    `data-libtit="${value.nombre_equipo}" `+
                    `data-libtem="${value.entrenador.id}">Actualizar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboEntrenador(id){
    $.ajax({
    type: "GET",
    url: "/profesores/get",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboentrenador").append(
                `<option value="${value.id}">${value.nombre} ${value.apellido}</option>`
            )
        });
        if(id > 0){
            $("#cboentrenador").val(id);
        }
    }
    })
}
