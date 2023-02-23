/**
 * 
 */

 function check_pw(){
 
            var pw = document.getElementById('pwd').value;
            
            var SC = ["!","@","#","$","%","."];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pw').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }/**/
            if(check_SC == 0){
                window.alert('!,@,#,$,%,.의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('pw').value='';
            }
           
            if(document.getElementById('pwd').value !='' && document.getElementById('pwd_again').value!=''){
                if(document.getElementById('pwd').value==document.getElementById('pwd_again').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                }
            }
        }