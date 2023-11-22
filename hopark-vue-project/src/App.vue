<template>
  <div>
    <TheHeaderNav/>
    <router-view></router-view>
    <button @click="getAllSports()">모든운동가져오기</button>
  </div>

  <Sidebar></Sidebar>
  
  


</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue'
import Sidebar from './components/common/Sidebar.vue';
import {getAllSports} from '@/utils/sportsUtil.js'




</script>

<style >
/* scoped를 삭제해서 컴포넌트 전역에 적용되도록 바꿈 */
body {
  background-image: url('https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg');
  background-size: auto;
  background-position: center;
  
}

</style>