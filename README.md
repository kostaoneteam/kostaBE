// JSON 데이터
const data = {
  carModel: "string",
  brand: "string",
  carType: "string",
  carYear: "string",
  mileage: 0,
  price: 0,
  displacement: "string",
  color: "string"
};

// 요청 보내기
fetch('http://localhost:8080/carpost/post', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Accept': '*/*'
  },
  body: JSON.stringify(data) // JSON으로 변환하여 본문에 포함
})
.then(response => response.json()) // 서버 응답을 JSON으로 변환
.then(data => {
  console.log('Success:', data); // 성공적으로 데이터를 수신했을 때 처리
})
.catch((error) => {
  console.error('Error:', error); // 오류 발생 시 처리
});


## 프로젝트 소개
KOSTA 1팀
<br>
지금까지 수업으로 학습을 토대로 중고차 거래 사이트를 만들어 보며 재학습 하는 기회를 만들기 위해 제작하였습니다. 
## 구현 기능 목록
1. 로그인 기능
2. 게시판 기능
3. 좋아요 기능
## 기술 스택
### Back-End
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<br>
### Front-End
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">


## ERD
![img.png](img.png)
## ARCHITECTURE
