<template>
    <div>
        <div style="background-color: #FFFBEF">
            <div>
                <p class="fs-6 text-muted">최대 4개 선택 가능</p>
                <h2>맘에 드는 운동을 선택해주세요!</h2>

            </div>
            <div v-if="!!sportsList">
                <div v-for="sports in sportsList">
                    <p>{{ sports }}</p>



                </div>
            </div>
            <div v-else>
                <p>로딩중..</p>
            </div>








        </div>

    </div>
</template>

<script setup>
import { computed, ref, onMounted } from 'vue';
import { getAllSports, searchByCondition } from '@/utils/sportsUtil.js'
import { useSportsStore } from '@/stores/SportsStore.js'

const store = useSportsStore();

// 직접 선택하기 버튼을 눌렀으면 이쪽으로 넘어오고, 백에서 모든 운동정보를 받아옴
onMounted(async () => {
    sportsList.value = await getAllSports()
})



// 카테고리만 발라내고 set으로 중복 제거한다음 다시 배열 할당하고 가나다순 정렬함
const sportsList = ref([])
const categoryList = sportsList.value.map((e) => e.category)
const category = [...new Set(categoryList)].sort()

let sortedSportsList = []

for(let i = 0; i<category.length; i++) {

}







// function test() {
//     sportsList.value = [1, 4, 2, 3, 142, 3]
// }


// setInterval(() => {
//     console.log(sportsList.value)
// },1000)









</script>

<style scoped></style>