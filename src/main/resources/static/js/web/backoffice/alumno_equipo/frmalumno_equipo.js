$(document).on("click", "#btnagregar", function(){
    $("#cboalumno").empty();
    $("#cboequipo").empty();
    listarCboAlumnos(0);
    listarCboEquipo(0);
    $("#txtfchreg").val("");
    $("#hddaleq").val("0");
    $("#switchactivo").hide();
    $("#cbactivo").prop("checked", true);
    $("#modaljugadores").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#cboalumno").empty();
    $("#cboequipo").empty();
    listarCboAlumnos($(this).attr("data-aleqa"));
    listarCboEquipo($(this).attr("data-aleqe"));
    $("#txtfchreg").val($(this).attr("data-aleqfch"));
    $("#hddaleq").val($(this).attr("data-aleqcod"));
    $("#switchactivo").show();
    $("#modaljugadores").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumno_equipo/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddaleq").val(),
            alumno: $("#cboalumno").val(),
            equipo: $("#cboequipo").val(),
            fecha_registro: $("#txtfchreg").val(),
            activo: $("#cbactivo").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarjugadores()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modaljugadores").modal("hide");
});

function listarjugadores(){
    $.ajax({
        type: "GET",
        url: "/alumno_equipo/list",
        datatype:"json",
        success: function(resultado){
            $("#tblalumno_equipo > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno_equipo > tbody").append(`<tr>`+
                `<td>${value.id_alumno_equipo}</td>`+
                `<td>${value.alumno.nombre}</td>`+
                `<td>${value.equipo.nombre_equipo}</td>`+
                `<td>${value.fecha_registro}</td>`+
                `<td>${value.activo}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-aleqcod="${value.id_alumno_equipo}" `+
                    `data-aleqa="${value.alumno.id}" `+
                    `data-aleqe="${value.equipo.id}" `+
                    `data-aleqfch="${value.fecha_registro}" `+
                    `data-aleqact="${value.activo}">Actualizar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboEquipo(id){
    $.ajax({
    type: "GET",
    url: "/equipos/list",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboequipo").append(
                `<option value="${value.id}"> ${value.nombre_equipo}</option>`
            )
        });
            if(id > 0){
                $("#cboequipo").val(id);
            }
        }
    })
}

function listarCboAlumnos(id){
    $.ajax({
    type: "GET",
    url: "/alumnos/list",
    datatype: "json",
    success: function(resultado){
        $.each(resultado, function(index, value){
            $("#cboalumno").append(
                `<option value="${value.id}"> ${value.nombre}</option>`
            )
        });
            if(id > 0){
                $("#cboalumno").val(id);
            }
        }
    })
}
