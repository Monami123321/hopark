<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h4 class="card-title text-center">회원가입</h4>
          </div>
          <div class="card-body">
            <form @submit.prevent="store.userRegist(registData)">
              <div class="mb-3">
                <label for="username" class="form-label">아이디</label>
                <input
                  type="text"
                  class="form-control"
                  id="username"
                  v-model="userId"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input
                  type="password"
                  class="form-control"
                  id="password"
                  v-model="password"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  v-model="name"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  id="email"
                  v-model="email"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="age" class="form-label">나이</label>
                <input
                  type="number"
                  class="form-control"
                  id="age"
                  v-model="age"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="location" class="form-label">사는곳</label>
                <input
                  type="text"
                  class="form-control"
                  id="location"
                  v-model="location"
                  required
                />
              </div>
              <button type="submit" class="btn btn-primary w-100">
                회원가입
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useUserStore } from "@/stores/userStore.js";
const store = useUserStore();

const userId = ref("");
const password = ref("");
const name = ref("");
const email = ref("");
const age = ref(0);
const location = ref("");

const registData = computed(() => {
  return {
    id: userId.value,
    password: password.value,
    name: name.value,
    email: email.value,
    age: age.value,
    location: location.value,
  };
});
</script>

<style>
/* 추가적인 스타일링을 원하면 여기에 추가하세요. */
</style>
