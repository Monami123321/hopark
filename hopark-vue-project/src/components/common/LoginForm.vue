<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h4 class="card-title text-center">로그인</h4>
          </div>
          <div class="card-body">
            <form @submit.prevent="store.userLogin(userLoginData)">
              <div class="mb-3">
                <label for="username" class="form-label">아이디</label>
                <input type="text" class="form-control" id="username" v-model="userId" required />
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="password" v-model="userPassword" required />
              </div>
              <button type="submit" class="btn btn-primary w-100">
                로그인
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, watch } from "vue";
import { ref, computed } from "vue";
import { useUserStore } from "@/stores/UserStore";
const axios = inject("$axios");

const userId = ref("");
const userPassword = ref("");

const userLoginData = computed(() => {
  return { id: userId.value, password: userPassword.value };
});

const store = useUserStore();
</script>


<style scoped></style>
