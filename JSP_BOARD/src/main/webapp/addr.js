
function open_Postcode() {  //다음 카카오 주소찾기 
	new daum.Postcode({
		oncomplete: function(data) {


			// 우편번호와 주소 정보를 해당 필드에 넣는다. 
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("road_address").value = data.roadAddress ;
			document.getElementById("extra_address").value = data.buildingName;

		}
	}).open();
} 

