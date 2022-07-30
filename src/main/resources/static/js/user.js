let index={
    init: function(){
//        let _this = this; function 사용하렴ㄴ
        $("#btn-save").on("click", ()=>{ //function 사용안하는 이유는 this를 바인딩 하기 위해서
            this.save();

        })
    },

    save: function(){
//        alert('user의 save함수 호출 됨 ');
        let data={
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        };

//        console.log(data);
        //ajax 호출시 default가 비동기 호출
        //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청할 것임.
        //ajax가 통신을 성공하고 json을 리턴하면 서버가 자동으로 자바 오브젝트로 변환
        $.ajax({
            type:"POST",
            url:"/blog/api/user",
            data:JSON.stringify(data), //json 문자열열 , http body 데이터
            contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지
            dataType:"json" //요청에 대한 응답이 왔을 때(기본 적으로 모든 것이 문자열) 생긴게 json이라면 => dataType:"json"적으면 javascript 객체로 변환

            //통신 수행 회원가입 수행 요청
        }).done(function(resp){
          //응답 정상
          alert("회원가입이 완료되었습니다");
          console.log(resp)
          //location.href = "/blog";
        }).fail(function(error){
           //실패
           alert(JSON.stringify(error));
        });

    }


}
//쭉 읽어 내려가닥 init() 만나면 버튼활성화
index.init();