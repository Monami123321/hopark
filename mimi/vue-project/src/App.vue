<template>
  <div>
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink>
      </nav>
    </header>
    <button @click="select">직접 선택하기</button>
    <RouterView/>
  </div>
</template>

<script setup>

</script>

<style>
  body {
    background-image: url("@/assets/main_bg.jpg");
    background-position: 0% 10%;
  }
</style>