import { ref, computed } from "vue";
import { defineStore } from "pinia";


export const useVideoStore = defineStore("Video", () => {

  let videoList = ref(null);
  

  return { videoList, };
});
