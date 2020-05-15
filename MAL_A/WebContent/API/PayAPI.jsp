<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 21. 오후 2:42:34   sist         최초 생성
  *
  * author 쌍용교육센터 E반
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PaymentPage</title>
</head>
<body>
<%
      int price=10000000;
      String name="박종훈";
      String tel="010-9190-3181";
      String addr="서울시 노원구";
            

%>>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" ></script>
<script type="text/javascript">

        var IMP = window.IMP; // 생략가능
        IMP.init('iamport'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        //onclick, onload 등 원하는 이벤트에 호출합니다
        IMP.request_pay({
            
            
            pg : 'inicis', // version 1.1.0부터 지원.
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '숙박의 민족',
            amount : <%=price%>,
            buyer_email : 'iamport@siot.do',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=tel%>',
            buyer_addr : '<%=addr%>',
            buyer_postcode : '123-456',
            m_redirect_url : 'https://www.yourdomain.com/payments/complete',
            app_scheme : 'iamportapp'
              
             

        }, function(rsp) {
            if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            document.getElementById("result").innerHTML = msg;
            alert(msg);
        });
        

        
</script>
 <main>
</main>
</body>
</html>