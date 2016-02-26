/**
 * 메뉴를 선택하는 화면의 js파일입니다.
 */

var count = 0;
var totalPrice = 0;


$(function() {
	
	// 최초화면로딩시 ==> 결제버튼 비활성화
	$("#orderBtn").attr("disabled", true);
	
	$("button[name=menuBtn]").click(function(event) {
		var span;
		if ($(event.target).get("Name") == "menuBtn")
			span = $(event.target).find("span")[0];
		else
			span = $(event.target).parent().find("span")[0];

		span.innerHTML++;
		
		count++;
		$("#totalCntBtn").text("총 " + count + " 잔");
		
		// 주문잔수 > 0 => 결제버튼 활성화
		if (count > 0) {
			$("#orderBtn").attr("disabled", false);
		}
		
		var menuId = $(span).attr('id');

		//총 금액 계산
		totalPrice += Number($("#" + menuId + "price").text());
		$("#orderBtn").text(totalPrice+"원 결제");
		
		//상세 메뉴에 내역 추가.
		if($(span).text()==1)
		{
			$("#detailMenuDiv").prepend("<div><h4 onclick='toggleDetailMenuFunc(event)'><span class='glyphicon glyphicon-glass'></span><strong>&nbsp"+$("#" + menuId + "name").text()+"</strong></h4>" +
					"<ol class='list-group' name="+menuId+"></ol></div>");
		}
		
		var li = $("<li class='list-group-item'></li>");
		
		if($("#"+menuId+"ice").text() == "Y")
		{
			$(li).prepend("<span tag='1' class='optInactive' onclick='detailMenuFunc(event)'>얼음적게</span>");
			$(li).prepend(" <b>/ </b>");
			$(li).prepend("<span tag='2' class='optInactive' onclick='detailMenuFunc(event)'>얼음많이</span>");
			if($("#"+menuId+"shot").text() == "Y")
				$(li).prepend(" <b>/ </b>");
		}
		if($("#"+menuId+"shot").text() == "Y")
		{
			$(li).prepend("<span tag='Y' class='optInactive' onclick='detailMenuFunc(event)'>샷추가</span>");
		}
		
		$(li).append("<span class='glyphicon glyphicon-remove right' aria-hidden='true' onclick='deleteFunc(event)'></span>");
		$("ol[name="+menuId+"]").append(li);
	});

	/* 숨김기능로직*/
	$("#detailMenuDiv").hide();
	$("#totalCntBtn").click(function() {
		$("#pattern").slideToggle();
		$("#detailMenuDiv").slideToggle();
	});
	
	$("#orderBtn").click(function(){
		
		if(count==0)return;
		
		var jsonString = '{"orderMenuVOList": [';
		
$("button[name=menuBtn]").each(function(index){
			
			var menuId = $($(this).find("span")[0]).attr('id');
			
			$("ol[name="+menuId+"] li").each(function(index){

				jsonString += '{"menuId":';
				jsonString += menuId+',';
				jsonString += '"iceOpt":';
				
				if ( $($(this).find("span[tag='1']")[0]).hasClass('optActive') == 1 ) {
					jsonString += '"1"';
				} else if ( $($(this).find("span[tag='2']")[0]).hasClass('optActive') == 1 ) {
					jsonString += '"2"';
				} else {
					jsonString += '"Z"';
				}	
				jsonString += ",";
				
				jsonString += '"shotOpt":';
				
				if ( $($(this).find("span[tag='Y']")[0]).hasClass('optActive') == 1 ) {
					jsonString += '"Y"';
				} else {
					jsonString += '"N"';
				}
				jsonString += "},";
			});
		});
		jsonString = jsonString.substring(0,jsonString.length-1);
		jsonString += '],';
		jsonString += '"togoYn":';
		if ( $("#togoYn").prop('checked') ) {
			jsonString += '"N"';
		} else {
			jsonString += '"Y"';
		}
			
		jsonString += ",";
	
		jsonString += '"orderAmtSum": '+totalPrice+'}';
		debugger;
		
		$("#jsonData").val(jsonString);
		
		//setTimeout(submitFunc(), 100);
		
		/*$.ajax({
			url:"./order",
			type:"POST",
			data:jsonString,
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			success:function(data){
				window.location.href("/waitingStatus");//성공적
			}
		});*/
	});
});

var toggleDetailMenuFunc = function(event){
	$($($($(event.target).parent()).parent()).find("ol")[0]).slideToggle();
};

var submitFunc = function() {
	$("#orderForm").submit();
};
//상세 메뉴 클릭
var detailMenuFunc = function(event){
	
	$(event.target).toggleClass('optActive');
	$(event.target).toggleClass('optInactive');
	
	if($(event.target).prop('class') == 'optActive')
	{
		if($(event.target).attr('tag') == '1')
		{
			$(event.target).parent().find("span[tag=2]").prop("class","optInactive");
		}
		else if($(event.target).attr('tag') == '2')
		{
			$(event.target).parent().find("span[tag=1]").prop("class","optInactive");
		}
	}
};

//취소버튼 클릭
var deleteFunc = function(event) {
	//총 잔 수 감소
	count--;
	$("#totalCntBtn").text("총 " + count + " 잔");
	
	//해당 메뉴 잔 수 감소
	var menuId = $(event.target).parent().parent().attr('name');
	var menuCnt = $("#"+menuId).text();
	$("#"+menuId).text(menuCnt-1);

	//총 금액 계산
	totalPrice -= Number($("#" + menuId + "price").text());
	$("#orderBtn").text(totalPrice+"원 결제");
	
	//해당 메뉴 li 제거
	$(event.target).parent().remove();
	
	//0개일경우 OL도 제거
	if($("#"+menuId).text()=='0')
	{
		$("ol[name="+menuId+"]").parent().remove();
	}
	// 주문잔수 = 0 => 결제버튼 비활성화
	if (count == 0) {
		$("#orderBtn").attr("disabled", true);
	}
}