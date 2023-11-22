<template>
  <div>
    <!-- <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
      </nav>
    </header> -->
    <div class="position-absolute end-0 bottom-0">
      <button class="mx-4" @click="select">직접 선택하기</button>
      <button @click="select">FFIT 추천받기</button>
    </div>
    <!-- <RouterView/> -->
    <Sidebar></Sidebar>
  </div>
</template>

<script setup>
  import Sidebar from '@/components/common/Sidebar.vue';
</script>

<style>
  body {
    background-image: url("@/assets/main_bg.jpg");
    background-position: 0% 10%;
  }
  button {
    background-color: #73D0BB;
    border: none;
    border-radius: 30px;
    color: white;
    padding: 15px 20px;
    font-size: 20px;
  }
</style>