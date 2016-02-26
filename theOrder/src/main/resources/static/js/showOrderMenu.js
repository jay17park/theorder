/**
 * 메뉴를 선택하는 화면의 js파일입니다.
 */

	var count=0;
	
$(function(){
/*	$( "#totalCntBtn" ).click(function(event){
//    $( "#pattern" ).click(function(event){
	  debugger;
	  if($(event.target).get("Name")=="menuBtn")
		  $(event.target).find("span")[0].innerHTML++;
	  else
		  $(event.target).parent().find("span")[0].innerHTML++;
	  
	  count++;
	  $("#totalCntBtn").text(count + " 잔");
	  
  } );*/
  
  
  
  /* 숨김기능로직*/
  $("#detailMenuDiv").hide();
	debugger;
  $("#totalCntBtn").click(function(){
	  debugger;
      $("#pattern").slideToggle();
      $("#waitingDiv").slideToggle();
  });
});