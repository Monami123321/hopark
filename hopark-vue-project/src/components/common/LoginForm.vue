<template>
    <div>
        <form @submit.prevent="">
            <label for="id">아이디</label>
            <input id="id" v-model="userId" type="text">
            <label for="password">아이디</label>
            <input id="password" v-model="userPassword" type="text">

        </form>


    </div>
</template>
  
<script setup>
import { inject } from 'vue';
import { ref } from 'vue';

const userId = ref('')
const userPassword = ref('')

const axios = inject("$axios")

function login() {
    axios({
        method
    })
}



</script>
  
<style scoped></style>