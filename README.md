# Zerobase 백엔드 스쿨 4번째 개인과제 - 간단한 cms 서비스 만들기.

## 특이사항
- user-api 모듈과 order-api 모듈에서 이메일 발송을 위한 용도로는 FeignClient를 사용하지 않고, mailgun 공식문서에서 안내하는 com.mashape.unirest:unirest-java:1.4.9 라이브러리를 사용했습니다.
- 나중에 알고보니, FeignClient는 스프링부트의 버전에 따라서 다른 버전으로 설치해줘야 정상작동하는 것이었기 때문에 초반에 메일을 보내는 기능에서는 작동을 하지 않았던 것이었습니다. order-api 모듈에서는 이를 반영하여 스프링부트 2.7.8 버전에 맞도록 mavenBom "org.springframework.cloud:spring-cloud-dependencies:2021.0.5" 버전으로 설치하여 정상작동하는 것을 확인했습니다.
- CartApplication.java 클래스를 테스트하면서 마주한 " failed to lazily initialize a collection of role could not initialize proxy - no session "라는 에러를 해결하는 방법으로서 강의에서 제공한 방법과 다른 방법을 찾았습니다. CartApplication.java 파일 내의 getCart()메서드에 Transactional 어노테이션을 붙여주는 것이었습니다.

## 결제내역 메일 발송 기능 구현완료 : 이미지 첨부
- 고객이 10만 원을 충전
![4E633B7D-0856-4E67-95E5-5DE2B1B04EE2](https://user-images.githubusercontent.com/99060708/216908843-187243e7-ed80-4925-bc02-f09ce062f327.jpeg)
- 판매자가 상품을 등록
![E401E9B1-9BFF-493C-A433-9CE92BDF98FD](https://user-images.githubusercontent.com/99060708/216909319-a22c31df-8779-4fa9-9e83-e70aeff137df.jpeg)
- 고객이 상품을 장바구니에 추가
![9A5EEFF9-D4F3-4889-B615-5E1DD28DB33D](https://user-images.githubusercontent.com/99060708/216909577-c9172396-d4d1-4dc5-b2d0-0401d37c34d3.jpeg)
- 고객이 자기 카트를 확인
![0CDFC023-08F2-4650-B315-0CB779344E56](https://user-images.githubusercontent.com/99060708/216909808-cf07f2af-cba0-4e68-a795-573c7d0d4a1b.jpeg)
- 고객이 결제를 완료하고, 결제 내역이 고객의 아이디 메일로 전송됨.
![CC674007-FFEF-40CC-B42A-5052AE70F0F6](https://user-images.githubusercontent.com/99060708/216910112-6dbe54d0-c005-48e5-bbe6-ba86049a08da.jpeg)
![FF9C4730-54EB-4956-9705-F1C83C27F6AC](https://user-images.githubusercontent.com/99060708/216910176-6d4f04da-6348-4ce2-a395-879ab50cfb07.jpeg)
- 고객이 결제 일시, 품목, 가격, 총액을 자신의 메일함에서 확인
![6DDA3906-0B5C-4105-9C1A-D6AA7003BA79](https://user-images.githubusercontent.com/99060708/217700152-ee7b4722-3f41-4394-92f4-4b2bb9e587f5.jpeg)
