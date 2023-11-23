<template>
  <div class="wrap">
    <h2>무료 운동 성향 테스트</h2>
    <ul>
      <div>
        <p>혼자하는 운동 vs 함께하는 운동</p>
        <form>
          <input type="radio" id="alone" name="people" value="alone" />
            <label class="btn1" for="alone">혼자</label>
          <input type="radio" id="together" name="people" value="together" />
            <label class="btn2" for="together">함께</label>
          <input type="radio" id="together" name="people" value="together" />
            <label class="btn3" for="together">상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>집에서 운동 vs 밖에서 운동</p>
        <form>
          <input type="radio" />
            <label class="btn1">집</label>
          <input type="radio" />
            <label class="btn2">야외</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>편안하고 다소 정적인 운동 vs 빠르고 격정적인 운동</p>
        <form>
          <input type="radio" />
            <label class="btn1">정적</label>
          <input type="radio" />
            <label class="btn2">활동적</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>운동 목표 : 스트레스 해소 vs 몸 만들기</p>
        <form>
          <input type="radio" />
            <label class="btn1">스트레스 해소</label>
          <input type="radio" />
            <label class="btn2">몸 만들기</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>유연성을 기르고 싶으신가요?</p>
        <form>
          <input type="radio" />
            <label class="btn1">네</label>
          <input type="radio" />
            <label class="btn2">아니요</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>공과 함께하는 운동 vs 공을 사용하지 않는 운동</p>
        <form>
          <input type="radio" />
            <label class="btn1">공 좋아</label>
          <input type="radio" />
            <label class="btn2">공 싫어</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>음악과 함께하는 운동 vs 음악 필요없는 운동</p>
        <form>
          <input type="radio" />
            <label class="btn1">노래 좋아</label>
          <input type="radio" />
            <label class="btn2">노래 싫어</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>대중적인 운동 vs 생소한 운동</p>
        <form>
          <input type="radio" />
            <label class="btn1">대중적인 운동</label>
          <input type="radio" />
            <label class="btn2">새로운 운동</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>소비할 수 있는 금액은?</p>
        <form>
          <input type="radio" />
            <label class="btn1">10만원 이하</label>
          <input type="radio" />
            <label class="btn2">금액 제한 없음</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
      <hr />
      <div>
        <p>강화시키고 싶은 부위는?</p>
        <form>
          <input type="radio" />
            <label class="btn1">상체</label>
          <input type="radio" />
            <label class="btn2">하체</label>
          <input type="radio" />
            <label>상관 없음</label>
        </form>
      </div>
    </ul>
    <router-link :to="{name: 'regist'}" class="submit">FFIT 시작하기</router-link>
  </div>
</template>

<script setup>
</script>

<style scoped>
.wrap{
    background-color: #FFFBEF;
}
.submit{
    background-color: #73D0BB;
    border: none;
    border-radius: 30px;
    color: white;
    padding: 15px 20px;
    font-size: 20px;
}
.btn1, .btn2{
    margin-right: 20px;
}
</style>
