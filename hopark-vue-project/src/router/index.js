import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import SelectView from "@/views/SelectView.vue";
import LoginForm from "@/components/common/LoginForm.vue";
import { isAuthenticated, isOpenedUrl } from "@/utils/authUtil.js";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "default",
      component: HomeView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginForm,
    },

    {
      path: "/home",
      name: "home",
      component: HomeView,
    },
    {
      path: "/select",
      name: "select",
      component: SelectView,
    },
  ],
});
/*
 - 전역 네비게이션 설정 -> jwt가 있는지 없는지 확인함
 - 로그인, 회원가입은 없어도 넘어가기
 - 경고창띄우기
 - 이전 페이지로 돌려놓기 (push로)


 */
router.beforeEach((to, from) => {
  if (isAuthenticated()) {
    return true;
  } else {
      if (isOpenedUrl(to)) {
      return true;

    } else {
      alert("로그인 유저만 접근할 수 있습니다.");
      router.push("/")
      return false;
    }
  }
});

export default router;
