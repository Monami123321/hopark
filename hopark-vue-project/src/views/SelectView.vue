<template>
    <div class="wrap">
        <div>
            <div v-if="!!sportsList">
                <form>
                    <div v-for="sorted in store.sortedList">
                        <div class="d-flex flex-column justify-content">
                            <div class="my -3 mx-3 fs-3 fw-bold">{{ sorted[0].category }}</div>
                            <div class="d-flex justify-content">
                                <div class="mx-1" v-for="item in sorted">
                                    <input type="radio" :name="item.category" :id="item.name">
                                    <label :for="item.name">{{item.name+" "+item.engName}}</label>
                                    
                                    <!-- {{ item.engName }} -->
                                </div>
                            </div>
                            <hr/>
                        </div>
                        <hr>
                    </div>
                </form>
                <div class="mt-4">
                    <button @click="gotoVideo(router)" class="submit">FFIT 시작하기</button>
                </div>

            </div>
            <div v-else>
                <h2>로딩중..</h2>
            </div>








        </div>

    </div>
</template>

<script setup>
import { watch, computed, ref, onMounted } from 'vue';
import { getAllSports, searchByCondition } from '@/utils/sportsUtil.js'
import { useSportsStore } from '@/stores/SportsStore.js'
import { useRouter } from "vue-router";
import { pickRandomSports } from "@/utils/sportsUtil.js"
import axios from 'axios';
const router = useRouter();

const store = useSportsStore();
const sportsList = ref([])

async function gotoVideo(router) {
  const work = await pickRandomSports()
  
  let worksData = work.map(e => e.name)
  let finalData = {
    work1: worksData[0],
    work2: worksData[1],
    work3: worksData[2],
    work4: worksData[3],
  }
  try {
    const res = await axios({
      method: "PUT",
      url: `${import.meta.env.VITE_BACK_URI}user/work`,
      headers: { Authorization: localStorage.getItem("jwt") },
      data: finalData
    })
    router.push("/video")
    return

  } catch(e) {
    console.log(e)
    return;
  }
  


}



// 직접 선택하기 버튼을 눌렀으면 이쪽으로 넘어오고, 백에서 모든 운동정보를 받아옴
onMounted(async () => {
    sportsList.value = await getAllSports()
    // 카테고리만 발라내고 set으로 중복 제거한다음 다시 배열 할당하고 가나다순 정렬함
    const categoryList = sportsList.value.map((e) => e.category)
    const category = [...new Set(categoryList)].sort()
    // 배열의 배열로 여기에 카테고리별로 운동을 분류해서 저장할거임 [[],[],[]]
    const sortedList = [null]

    for (let i = 0; i < category.length; i++) {
        // 카테고리 정리해놓은 배열을 순회하면서 얘랑 같은 애를 발라서 다시 배열로 리턴
        const sortedElement = sportsList.value.filter((e) =>
            e.category === category[i]
        )
        // 최종 배열에 저장
        sortedList[i] = sortedElement
    }
    // 비동기 변수 처리가 힘들어서.. 피니아에 저장하고 가져다 쓰기로
    store.sortedList = sortedList
})

const selectedList = ref([])







</script>

<style scoped>
.wrap {
    background-color: #FFFBEF;
}

.submit {
    background-color: #73D0BB;
    border: none;
    border-radius: 30px;
    color: white;
    padding: 15px 20px;
    font-size: 20px;
}
</style>