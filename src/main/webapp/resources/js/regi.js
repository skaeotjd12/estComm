const button = $("#btn_join");

const buttonClickHandler = () =>{

  
 let data = {
        mbr_Id : $("#mbr_Id").val(),
        mbr_Nm: $("#mbr_Nm").val(),
        mbr_Pw: $("#mbr_Pw").val()
    };


$.ajax({
        type:'post',
        url:'/regi',
        data: JSON.stringify(data),
        contentType : 'application/json; charset=utf-8',
        dataType: "json"
    }).done(res => {
        alert("회원가입 실행")
        console.log("회원가입 실행", res);	
        location.reload();
    }).fail(error =>{
        console.log("오류", error);
    });
};
 
button.on('click',buttonClickHandler);