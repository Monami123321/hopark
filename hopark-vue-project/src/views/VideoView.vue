<template>
    <div>
        <header class="d-flex justify-content-between">
            <div>
                <a >Video</a>
                <a >location</a>
            </div>

            <div>
                <span class="fs-3 fw-bold">{{ userStore.loginUser.name }}</span>님 반갑습니다.
            </div>

        </header>
        <main>
            <div>
                <h2>나의 관심 운동 목록 : </h2>
                <button @click="">{{ userStore.loginUser.work1 }}</button>
                <button @click="">{{ userStore.loginUser.work2 }}</button>
                <button @click="">{{ userStore.loginUser.work3 }}</button>
                <button @click="">{{ userStore.loginUser.work4 }}</button>

            </div>

            <div v-for="video in videoStore.videoList">
                {{ video }}
            
            </div>





        </main>

    </div>
</template>

<script setup>
import { getLoginUserInfo } from '@/utils/userUtil';
import { youtubeSearch } from '../utils/videoUtil';
import {useUserStore} from '@/stores/UserStore'
import {useVideoStore} from '@/stores/VideoStore'
import { onMounted } from 'vue';

const userStore = useUserStore();
const videoStore = useVideoStore();

onMounted(async () => {
    userStore.loginUser = await getLoginUserInfo()
    videoStore.videoList = await youtubeSearch(userStore.loginUser.work1)

})



</script>

<style scoped>

</style>