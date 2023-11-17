<template>
  <div>
    <TheHeaderNav/>
    <router-view></router-view>
  </div>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue'
const YOUTUBE_API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY
console.log(YOUTUBE_API_KEY)


</script>

<style >
/* scoped를 삭제해서 컴포넌트 전역에 적용되도록 바꿈 */
body {
  background-image: url('https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_1280.jpg');
  background-size: auto;
  background-position: center;
  
}

</style>