$(document).on("click", "#btnagregar", function(){
    $("#txtnomalu").val("");
    $("#txtapealu").val("");
    $("#txtfecalu").val("");
    $("#txtdiralu").val("");
    $("#txttelalu").val("");
    $("#hddalucod").val("0");

    $("#modalalumnos").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomalu").val($(this).attr("data-aluname"));
    $("#txtapealu").val($(this).attr("data-alulast"));
    $("#txtfecalu").val($(this).attr("data-alufec"));
    $("#txtdiralu").val($(this).attr("data-aludir"));
    $("#txttelalu").val($(this).attr("data-alutel"));
    $("#hddalucod").val($(this).attr("data-alucod"));

    $("#modalalumnos").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumnos/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddalucod").val(),
            nombre: $("#txtnomalu").val(),
            apellido: $("#txtapealu").val(),
            fecha_nacimiento: $("#txtfecalu").val(),
            direccion: $("#txtdiralu").val(),
            telefono: $("#txttelalu").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalalumnos").modal("hide");
});

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/alumnos/list",
        datatype:"json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.apellido}</td>`+
                `<td>${value.fecha_nacimiento}</td>`+
                `<td>${value.direccion}</td>`+
                `<td>${value.telefono}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-alucod="${value.id}" `+
                    `data-aluname="${value.nombre}" `+
                    `data-alulast="${value.apellido}" `+
                    `data-alufec="${value.fecha_nacimiento}" `+
                    `data-aludir="${value.direccion}" `+
                    `data-alutel="${value.telefono}">Actualizar `+
                    `</button></td>`+ // Aquí estaba la coma extra después de `data-alutel`
                `</tr>`);
            });
        }
    });
}