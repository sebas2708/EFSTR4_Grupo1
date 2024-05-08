$(document).on("click", "#btnagregar", function(){
    $("#txtnompro").val("");
    $("#txtapepro").val("");
    $("#txttelpro").val("");
    $("#txtcorpro").val("");
    $("#txtesppro").val("");
    $("#hddprocod").val("0");

    $("#modalprofesores").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnompro").val($(this).attr("data-proname"));
    $("#txtapepro").val($(this).attr("data-prolast"));
    $("#txttelpro").val($(this).attr("data-protel"));
    $("#txtcorpro").val($(this).attr("data-procor"));
    $("#txtesppro").val($(this).attr("data-proesp"));
    $("#hddprocod").val($(this).attr("data-procod"));

    $("#modalprofesores").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/profesores/register",
        contentType: "application/json",
        data: JSON.stringify({
            id: $("#hddprocod").val(),
            nombre: $("#txtnompro").val(),
            apellido: $("#txtapepro").val(),
            telefono: $("#txttelpro").val(),
            correo_electronico: $("#txtcorpro").val(),
            especializacion: $("#txtesppro").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProfesores();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalprofesores").modal("hide");
});

function listarProfesores(){
    $.ajax({
        type: "GET",
        url: "/profesores/list",
        datatype:"json",
        success: function(resultado){
            $("#tblprofesor > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblprofesor > tbody").append(`<tr>`+
                `<td>${value.id}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.apellido}</td>`+
                `<td>${value.telefono}</td>`+
                `<td>${value.correo_electronico}</td>`+
                `<td>${value.especializacion}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-procod="${value.id}" `+
                    `data-proname="${value.nombre}" `+
                    `data-prolast="${value.apellido}" `+
                    `data-protel="${value.telefono}" `+
                    `data-procor="${value.correo_electronico}" `+
                    `data-proesp="${value.especializacion}">Actualizar `+
                    `</button></td>`+
                `</tr>`);
            });
        }
    });
}