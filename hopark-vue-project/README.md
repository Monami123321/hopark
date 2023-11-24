# hopark-vue-project

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```

```
hopark-vue-project
├─ .env
├─ .gitignore
├─ index.html
├─ package-lock.json
├─ package.json
├─ public
│  └─ favicon.ico
├─ README.md
├─ src
│  ├─ App.vue
│  ├─ assets
│  │  ├─ logo.png
│  │  ├─ main_bg.jpg
│  │  └─ nocturne.mp3
│  ├─ components
│  │  └─ common
│  │     ├─ LoginForm.vue
│  │     ├─ RegistForm.vue
│  │     ├─ Sidebar.vue
│  │     └─ TheHeaderNav.vue
│  ├─ main.js
│  ├─ router
│  │  └─ index.js
│  ├─ stores
│  │  ├─ counter.js
│  │  ├─ SportsStore.js
│  │  ├─ UserStore.js
│  │  └─ VideoStore.js
│  ├─ utils
│  │  ├─ authUtil.js
│  │  ├─ kakaoUtil.js
│  │  ├─ sportsUtil.js
│  │  ├─ userUtil.js
│  │  └─ videoUtil.js
│  └─ views
│     ├─ AboutView.vue
│     ├─ HomeView.vue
│     ├─ LogoutView.vue
│     ├─ RecommendView.vue
│     ├─ SelectView.vue
│     └─ VideoView.vue
└─ vite.config.js

```