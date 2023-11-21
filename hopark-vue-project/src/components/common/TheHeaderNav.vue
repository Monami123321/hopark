<template>
    <div id="container">
        <header style="height: 3rem">
            <nav class="bg-light d-flex justify-content-end h-100">
                <!-- <div v-if="!loginUser">
                    <LoginForm>로그인</LoginForm>
                </div> -->
                
                <RouterLink class="fs-5 mx-2" to="/">Home</RouterLink>
                <RouterLink class="fs-5 mx-2" to="/regist">회원가입</RouterLink>
            </nav>
        </header>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import LoginForm from './LoginForm.vue';

// const loginUser = computed(() => {
//     sessionStorage.getItem("loginUser")
// })


</script>

<style scoped>

</style>