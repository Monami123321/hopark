# SSAFY 1학기 최종 프로젝트 호박조

### ***운동은 재밌어야합니다.***
###### FFIT과 함께하면 다양한 운동을 경험하며 나에게 맞는 운동을 찾을 수 있어 운동이 즐거워집니다.
###### 퍼스널 컬러, 각자의 체형에 맞는 옷이 존재하듯 여러분에게 맞는 운동을 찾아보세요.
###### 얼마나 다양한 운동이 있는지 알게되면 놀라울거예요.
###### 당신의 운동 여정, 지금 시작해볼까요? <br><br><br><br>

## 첫화면

![대문](images/대문.png){: width="600" height="400"}

## 핵심 서비스 - 자기에게 맞는 운동 찾기! 

### 설문조사 -> 설문조사 결과에 따라 알맞은 운동을 추천해드립니다.

![설문조사](images/설문조사.png){: width="700" height="1000"}

### 직접 선택 -> 맘에 드는 운동을 직접 선택할 수 있습니다.

![직접선택](images/직접선택.png){: width="700" height="1000"}

### 운동 영상 추천 -> 딱 맞는 운동 영상을 추천해드립니다.

![영상추천](images/영상추천.png){: width="800" height="600"}
 
## 프론트 vue 프로젝트 구조
----------------------------------------------------------------------
├─ .env <br>
├─ .gitignore <br>
├─ index.html <br>
├─ package-lock.json <br>
├─ package.json <br>
├─ public <br>
│  └─ favicon.ico <br>
├─ README.md <br>
├─ src <br>
│  ├─ App.vue <br>
│  ├─ assets <br>
│  │  ├─ logo.png <br>
│  │  ├─ main_bg.jpg <br>
│  │  └─ nocturne.mp3 <br>
│  ├─ components <br>
│  │  └─ common <br>
│  │     ├─ LoginForm.vue <br>
│  │     ├─ RegistForm.vue <br>
│  │     ├─ Sidebar.vue <br>
│  │     └─ TheHeaderNav.vue <br>
│  ├─ main.js <br>
│  ├─ router <br>
│  │  └─ index.js <br>
│  ├─ stores <br>
│  │  ├─ counter.js <br>
│  │  ├─ SportsStore.js <br>
│  │  ├─ UserStore.js <br>
│  │  └─ VideoStore.js <br>
│  ├─ utils <br>
│  │  ├─ authUtil.js <br>
│  │  ├─ kakaoUtil.js <br>
│  │  ├─ sportsUtil.js <br>
│  │  ├─ userUtil.js <br>
│  │  └─ videoUtil.js <br>
│  └─ views <br>
│     ├─ AboutView.vue <br>
│     ├─ HomeView.vue <br>
│     ├─ LogoutView.vue <br>
│     ├─ RecommendView.vue <br>
│     ├─ SelectView.vue <br>
│     └─ VideoView.vue <br>
└─ vite.config.js <br>
-------------------------------------------------------------------------------

## ERD
![ERD](images/ERD.PNG){: width="1000" height="500"}

## 백엔드 클래스 다이어그램
![클래스다이어그램](images/classDiagram.png){: width="1000" height="500"}

## 백 API
![스웨거](images/swagger.PNG){: width="1000" height="500"}

# 특장점

## **spring-security + JWT 적용**

### DB 암호화 적용 -> 관리자도 비밀번호를 알 수 없습니다.
![DB암호화예시](images/DB암호.png){: width="1000" height="800"}

### 토큰 활용 인증/인가 관리 -> 네비게이션가드 + spring-security + JWT

![네비게이션가드](images/네비게이션가드.PNG){: width="1000" height="800"}

![JWT](images/jwt.PNG){: width="1000" height="800"}



