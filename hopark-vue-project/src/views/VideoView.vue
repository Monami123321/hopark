<template>
    <div>
        <header class="d-flex justify-content-between">
            <div>
                <a>Video</a>
                <a>location</a>
            </div>

            <div>
                <span class="fs-3 fw-bold">{{ name }}</span>님 반갑습니다.
            </div>

        </header>
        <main>
            <div>
                <p class="fs-2 fw-bold">나의 관심 운동 목록 : </p>
                <button class="mx-2 btn btn-dark" @click="youtubeSearch(works[0])">{{ works[0] }}</button>
                <button class="mx-2 btn btn-dark" @click="youtubeSearch">{{ works[1] }}</button>
                <button class="mx-2 btn btn-dark" @click="youtubeSearch">{{ works[2] }}</button>
                <button class="mx-2  btn btn-dark" @click="youtubeSearch">{{ works[3] }}</button>

            </div>

            <div v-for="video in videoStore.videoList">
                <div>
                    {{ video }}

                </div>
                <div>

                </div>
                

            </div>





        </main>

    </div>
</template>

<script setup>
import { getLoginUserInfo } from '@/utils/userUtil';
import { youtubeSearch } from '../utils/videoUtil';
import { useUserStore } from '@/stores/UserStore'
import { useVideoStore } from '@/stores/VideoStore'
import { onMounted, onBeforeMount, computed } from 'vue';

const userStore = useUserStore();
const videoStore = useVideoStore();
const name = computed(() => {
    return userStore.loginUser.name
})
const works = computed(() => {
    return [userStore.loginUser.work1,userStore.loginUser.work2,userStore.loginUser.work3,userStore.loginUser.work4]
})

const videoUrl = computed(() => {
    videoStore.videoList
})



onBeforeMount(async () => {
    console.log("akgdksdgb")
    userStore.loginUser = await getLoginUserInfo();
    videoStore.videoList = await youtubeSearch(userStore.loginUser.work1);


})
console.log(userStore.loginUser)
console.log(videoStore.videoList)



</script>

<style scoped></style>