import { createApp } from 'vue'
import { createPinia } from 'pinia'
import axios from 'axios' // axios 전역 사용 위해 import
import 'bootstrap/dist/css/bootstrap.min.css' // 부트스트랩사용을 위해 전역 주입

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
