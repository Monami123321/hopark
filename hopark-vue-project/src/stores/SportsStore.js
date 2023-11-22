import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";
import { getAllSports, searchByCondition } from "@/utils/sportsUtil";

// 여기서 정의하면 defineStore 안쪽 콜백함수가 동작할 떄 router가 정의되지 않아서 오류남
// const router = useRouter();

export const useSportsStore = defineStore("Sports", () => {
  

  return {
  };
});
