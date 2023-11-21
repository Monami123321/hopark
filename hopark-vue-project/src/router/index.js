import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import LoginForm from "@/components/common/LoginForm.vue";

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
  ],
});

export default router;
