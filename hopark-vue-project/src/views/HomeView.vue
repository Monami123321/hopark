<template>
  <div>
    <!-- <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
      </nav>
    </header> -->
    <div class="position-absolute end-0 bottom-0">
      <router-link :to="{name: 'select'}" class="mx-4 mimibutton">직접 선택하기</router-link>
      <router-link :to="{name: 'home'}" class="mimibutton">FFIT 추천받기</router-link>
    </div>
    <!-- <RouterView/> -->
    <Sidebar></Sidebar>
  </div>
</template>

<script setup>
  import Sidebar from '@/components/common/Sidebar.vue';
  import {RouterLink, RouterView} from 'vue-router'
</script>

<style>
  body {
    background-image: url("@/assets/main_bg.jpg");
    background-position: 0% 10%;
  }
  .mimibutton {
    background-color: #73D0BB;
    border: none;
    border-radius: 30px;
    color: white;
    padding: 15px 20px;
    font-size: 20px;
  }
</style>