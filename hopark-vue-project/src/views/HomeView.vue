<template>
  <div>
    <button @click="test">axios테스트테스트</button>


  </div>
</template>

<script setup>
  import { inject } from 'vue';

  const axios = inject("$axios")

  function test() {
    axios({
      url: "http://localhost:8080/user/login",
      method:"POST",
      data: {
        id: "zzz",
        password: "zzz"

      }
    }).then((res) => {
      console.log(res)
      return;
    }).catch((e) => {
      console.log(e)
      return
    })
  }


</script>

<style scoped>

</style>