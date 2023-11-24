<template>
  <div>
    <audio class="opacity-25 position-absolute top-0 start-0" style="width: 10rem; height: 3rem;" controls autoplay="true"
      loop="true" src="./src/assets/nocturne.mp3">
    </audio>
    <div class="bgImg">
      <img src="@/assets/logo.png" />
    </div>

    <router-view></router-view>

  </div>
</template>

<script setup>

</script>

<style >
.bgImg {
  background-image: url("@/assets/main_bg.jpg");
  width: 1920px;
  height: 1080px;
  z-index: -1;
  position: fixed;
  /* background-position: 0% 10%; */
}

img {
  padding: 200px 300px;
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