// 카카오 API를 사용하기 위해 외부 스크립트 로드
// 새로운 html 요소를 만들고 html 파일 헤드에 심기
export function loadKakao() {
  const script = document.createElement('script')
  script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${import.meta.env.VITE_KAKAO_API_KEY}`
}
