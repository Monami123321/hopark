<template>
    <div>
        <form @submit.prevent="store.userLogin(userLoginData)">
            <label for="id">아이디</label>
            <input id="id" v-model="userId" type="text">
            <label for="password">비밀번호</label>
            <input id="password" v-model="userPassword" type="text">
            <button>로그인</button>

        </form>
        <!-- localStorage에 jwt가 있으면 로그인 상태라고 판단 -->
        <button v-if="jwt">로그아웃</button>


    </div>
</template>
  
<script setup>
import { inject } from 'vue';
import { ref, computed } from 'vue';
import { useUserStore } from '../../stores/UserStore';
const axios = inject("$axios")

const userId = ref('')
const userPassword = ref('')


const userLoginData = computed(() => {
    return {id: userId.value, password: userPassword.value}

})

const jwt = computed(() => {
    localStorage.getItem('jwt')
})

//const userLoginData = {id: userId.value, password: userPassword.value}

const store = useUserStore();





</script>
  
<style scoped></style>