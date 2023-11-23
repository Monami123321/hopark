<template>
  <div>
    <header class="d-flex justify-content-end">
      <div>
        <span class="fs-3 fw-bold">{{ name }}</span
        >님 반갑습니다.
      </div>
    </header>
    <main>
      <div>
        <p class="fs-2 fw-bold">나의 관심 운동 목록 :</p>
        <button class="mx-2 btn btn-dark" @click="youtubeSearch(works[0])">
          {{ works[0] }}
        </button>
        <button class="mx-2 btn btn-dark" @click="youtubeSearch(works[1])">
          {{ works[1] }}
        </button>
        <button class="mx-2 btn btn-dark" @click="youtubeSearch(works[2])">
          {{ works[2] }}
        </button>
        <button class="mx-2 btn btn-dark" @click="youtubeSearch(works[3])">
          {{ works[3] }}
        </button>
      </div>
      <hr>
      <div class="d-flex justify-content-between flex-wrap">
        
        <div v-for="video in videoUrl">
          <iframe
            width="300"
            height="200"
            :src="youtubePlayerUri + video.id.videoId"
            title="YouTube video player"
            frameborder="1"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
          ></iframe>
          <!-- <div class="fw-bold">
            {{ video.snippet.title }}
          </div> -->
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
import { getLoginUserInfo } from "@/utils/userUtil";
import { youtubeSearch } from "../utils/videoUtil";
import { useUserStore } from "@/stores/UserStore";
import { useVideoStore } from "@/stores/VideoStore";
import { onMounted, onBeforeMount, computed, ref } from "vue";

const userStore = useUserStore();
const videoStore = useVideoStore();
const youtubePlayerUri = ref("http://www.youtube.com/embed/");
const name = computed(() => {
  return userStore.loginUser.name;
});
const works = computed(() => {
  return [
    userStore.loginUser.work1,
    userStore.loginUser.work2,
    userStore.loginUser.work3,
    userStore.loginUser.work4,
  ];
});

// videoStore 안에 객체가 반응을 안해서 임시로
const videoUrl = computed(() => {
  return videoStore.videoList;
});

onBeforeMount(async () => {
  userStore.loginUser = await getLoginUserInfo();
  videoStore.videoList = await youtubeSearch(userStore.loginUser.work1);
});

/*

res.items -> 동영상 객체 배열 -> videoStore.videoList에 저장
res.items[i] -> 동영상
res.items[i].id.videoId -> 동영상 고유 번호 ex("EgDpBh0q2ZE")
res.items[i].snippet.title -> 동영상 타이틀




res.data.items -> 동영상배열
res.data.items.id.videoId -> 동영상고유값
res.data.items.snippet.title -> 동영상 제목

*/
</script>

<style scoped></style>
