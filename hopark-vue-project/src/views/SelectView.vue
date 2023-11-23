<template>
    <div>
        <div style="background-color: #FFFBEF">
            <div v-if="!!sportsList">
                <form>
                    <div v-for="sorted in store.sortedList">
                        <div class="d-flex flex-column justify-content">
                            <div class="my -3 mx-3 fs-3 fw-bold">{{ sorted[0].category}}</div>
                            <div class="d-flex justify-content">
                                <div class="mx-1" v-for="item in sorted">
                                        <input type="radio" :name="item.category" id="">
                                        {{ item.name }}
                                        {{ item.engName }}
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
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

const store = useSportsStore();
const sportsList = ref([])



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







</script>

<style scoped></style>