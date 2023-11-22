<template>
    <div>
      <div class="position-absolute top-0 end-0">
        <!-- 사이드 메뉴 토글 버튼 -->
        <button class="" @click="toggleMenu">메뉴</button>
  
        <!-- 동적으로 보일 메뉴 영역 -->
        <transition name="sidebar" class="position-relative top-0 end-0">
          <div v-if="isMenuOpen" class="sidebar-menu">
            <div @click="closeMenu">닫기</div>
            <!-- 여기에 메뉴 항목 추가 -->
            <router-link v-if="!jwt" :to="{name: 'login'}" >로그인</router-link>
            <button @click="store.userLogout()" v-else> 로그아웃</button>
            <div>사이트 소개</div>
            <div>고객센터</div>
          </div>
        </transition>
        
  
        <!-- 나머지 컨텐츠 영역 -->
        <div>
          <!-- 나머지 컨텐츠 내용 -->
        </div>
  
      </div>
    </div>
  </template>
    
  <script setup>
  import { ref, computed, } from 'vue';
  import { useUserStore } from '@/stores/UserStore';
  
  const store = useUserStore()
  
  
  const jwt = computed(() => {
    return localStorage.getItem('jwt')
  })
  
  
  const isMenuOpen = ref(false);
  
  const toggleMenu = () => {
    isMenuOpen.value = !isMenuOpen.value;
  };
  
  const closeMenu = () => {
    isMenuOpen.value = false;
  };
  </script>
    
  <style scoped>
  
  
  /*  vue에서 제공하는 transition 컴포넌트를 이용해서 DOM전환, 애니메이션 효과 등을 만들 수 있다. (트랜지션 효과)
      템플릿에서 transition에 name속성으로 준 값을 css에서 참조할 수 있는데, -를 이용해서 미리 정의된 단계들을 꾸밀 수 있다.
      위 템플릿에서 <transition name="sidebar">로 해놨으니까 여기서 sidebar로 쓰면 된다.
  
    name-enter: 트랜지션의 등장(enter) 시작 시 적용되는 클래스.
    name-enter-to: 트랜지션의 등장(enter) 종료 시 적용되는 클래스.
    name-enter-active: 트랜지션의 등장(enter) 동작이 활성화되는 동안 적용되는 클래스.
    name-leave: 트랜지션의 퇴장(leave) 시작 시 적용되는 클래스.
    name-leave-to: 트랜지션의 퇴장(leave) 종료 시 적용되는 클래스.
    name-leave-active: 트랜지션의 퇴장(leave) 동작이 활성화되는 동안 적용되는 클래스.
        
  
  
  
  
  */
  .sidebar-enter-active, .sidebar-leave-active  {
    transition: transform 0.3s ease;
  }
  
  .sidebar-enter-to {
    transform: translateX(-10%);
  }
  .sidebar-leave-to {
    transform: translateX(100%);
  }
  
  
  .sidebar-menu {
    position: relative;
    top: 0;
    left: 0;
    width: 200px;
    height: 100vh;
    background-color: #E4C1A3;
    padding: 10px;
  }
  </style>
    