
import { createApp, provide } from 'vue'
import { createPinia } from 'pinia'
import axios from 'axios' // axios 전역 사용 위해 import
import 'bootstrap/dist/css/bootstrap.min.css' // 부트스트랩사용을 위해 전역 주입

import App from './App.vue'
import router from '@/router'

//provide('$axios',axios) // provide- inject로 하위 컴포넌트에 axios를 $axios라는 key로 주입

const app = createApp(App)
app.provide("$axios",axios) //app 전역에 provide로 axios 주입 (key: value = $axios : axios)



app.use(createPinia())
app.use(router)
app.mount('#app')


//app.provide('$axios', axios)  // 안 됨
//app.config.globalProperties.$axios = axios; // vue2에서 쓰는 방법
