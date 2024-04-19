<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>메인</title>
</head>
<body>
	<h1>메인</h1>
	
	<h2>게시판 목록</h2>
	<ul>
		<li class="category" id="QnA">Q&A</li>
		<li class="category" id="INTELL">지식인</li>
		<li class="category" id="EVT">이벤트</li>
		<li class="category" id="COMM">커뮤니티</li>
		<li class="category" id="NOTI">공지사항</li>
	</ul>
	
	
	<select hidden id="detailCategoryList"></select>
	<select hidden id="sorting">
		<option value="REGIST">최신순</option>
		<option value="VW">조회순</option>
		<option value="RECMMND">추천순</option>
	</select>
	<table id="board">
	
	</table>
	
<script type="text/javascript">
	$(document).ready(function () {
		
		let mainCategory = "";
		let detailCategory = "";
		
		$(".category").click(function () {
			 mainCategory = $(this).attr("id");
		     
		     let detailCategoryList = $('#detailCategoryList');
		     
		     detailCategoryList.show();
		     $('#sorting').show();
		     
		     if (mainCategory === 'QnA') {
                 detailCategoryList.empty().append(
                	 $('<option>', { value: '', text: '전체' }),
                     $('<option>', { value: 'ANWR_WT', text: '답변대기' }),
                     $('<option>', { value: 'SLT_CMPL', text: '채택완료' }),
                     $('<option>', { value: 'ANWR_CMPL', text: '답변완료' })
                 );
		     } else if (mainCategory === 'INTELL') {
		    	 detailCategoryList.empty().append(
		    			 $('<option>', { value: '', text: '전체' }),
	                     $('<option>', { value: 'NWS', text: '뉴스' }),
	                     $('<option>', { value: 'INFORM', text: '정보' }),
	                     $('<option>', { value: 'INTELL_ETC', text: '기타' })
	                 );
		     } else if (mainCategory === 'EVT') {
		    	 detailCategoryList.empty().append(
		    			 $('<option>', { value: '', text: '전체' }),
	                     $('<option>', { value: 'PROMO', text: '홍보' }),
	                     $('<option>', { value: 'EVT_INFORM', text: '행사정보' }),
	                     $('<option>', { value: 'EVT_ECT', text: '기타' })
	                 );
		     } else if (mainCategory === 'COMM') {
		    	 detailCategoryList.empty().append(
		    			 $('<option>', { value: '', text: '전체' }),
	                     $('<option>', { value: 'HMR', text: '유머' }),
	                     $('<option>', { value: 'IT_DLY', text: 'IT일상' }),
	                     $('<option>', { value: 'CHT', text: '잡담' }),
	                     $('<option>', { value: 'COMM_ETC', text: '기타' })
	                 );
		     } else if (mainCategory === 'NOTI') {
		    	 detailCategoryList.hide();
		     }
		     
		     
		     $.ajax({
		    	type: "GET",
		    	url: "/board?category=" + mainCategory,
		    	dataType: "json",
		    	success: function (result) {
		    		showView(result);
				},
				error: function (xhr, status, error) {
					alert("실패");
				}
		     });
		});
		
		
		
		$('#detailCategoryList').change(function() {
		    detailCategory = $(this).val();
		    
		    $.ajax({
		        type: "GET",
		        url: "/board?category=" + mainCategory + "&detailCategory=" + detailCategory,
		        dataType: "json",
		        success: function (result) {
		            showView(result);
		        },
		        error: function (xhr, status, error) {
		            alert("실패");
		        }
		    });
		});
		

	});	
	
	
	function showView(result) {
		console.log(result);
		let tmp = `
			<tr>
				<td>카테고리</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
				<td>추천수</td>
			</tr>
		`;
		$.each(result.dtoList, function(index, obj) {
        tmp += "<tr>" +
               "<td>" + convertDetailCategory(obj.brd_DTL_DIV_CD) + "</td>" +
               "<td>" + obj.brd_TTL + "</td>" +
               "<td>" + obj.mbr_SQ + "</td>" +
               "<td>" + convertTimestamp(obj.brd_REGIST_DTM) + "</td>" +
               "<td>" + obj.brd_VW_CNT + "</td>" +
               "<td>" + obj.brd_RECMMND_CNT + "</td>" +
               "</tr>";
    	});
		
		$('#board').html(tmp);
	}
	
	
	function convertDetailCategory(brd_DTL_DIV_CD) {
		let result;
		 switch (brd_DTL_DIV_CD) {
		 	case "ANWR_WT":
		 		result = "답변대기";
		 		break;
		 	case "SLT_CMPL":
		 		result = "채택완료";
		 		break;	
		 	case "ANWR_CMPL":
		 		result = "답변완료";
		 		break;
		 		
		 	case "NWS":
		 		result = "뉴스";
		 		break;		
		 	case "INFORM":
		 		result = "정보";
		 		break;		
		 	case "INTELL_ETC":
		 		result = "기타";
		 		break;
		 		
		 	case "PROMO":
		 		result = "홍보";
		 		break;		
		 	case "EVT_INFORM":
		 		result = "행사정보";
		 		break;		
		 	case "EVT_ECT":
		 		result = "기타";
		 		break;
		 		
		 	case "HMR":
		 		result = "유머";
		 		break;		
		 	case "IT_DLY":
		 		result = "IT일상";
		 		break;		
		 	case "CHT":
		 		result = "잡담";
		 		break;		
		 	case "COMM_ETC":
		 		result = "기타";
		 		break;
		 	default:
		 		result = '공지사항';	
		 		
		 }
		 return result;
	}
	
	
	
	function convertTimestamp(timestamp) {
	    let date = new Date(timestamp);

	    let year = date.getFullYear();
	    let month = ("0" + (date.getMonth() + 1)).slice(-2); 
	    let day = ("0" + date.getDate()).slice(-2); 
	    let hours = ("0" + date.getHours()).slice(-2);
	    let minutes = ("0" + date.getMinutes()).slice(-2);

	    let formattedDateTime = year + "-" + month + "-" + day + " " + hours + ":" + minutes;
	    return formattedDateTime;
	}
	
	
	
		
</script>
</body>
</html>