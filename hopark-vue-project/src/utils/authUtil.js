/*
localStorage에 jwt가 있는지 없는지 확인하는 함수.
createRouter에 import해서 전역 네비게이션가드를 정의할 때 쓸 예정



*/

export function isAuthenticated() {
  if (!!localStorage.getItem("jwt")) {
    return true;
  } else {
    return false;
  }
}
/*
router.BeforeEach() 에서 to, from은 이런 객체로 옴
targetUrl 넣을 때 참고
{
    "path": "/",
    "params": {},
    "query": {},
    "hash": "",
    "fullPath": "/",
    "matched": [],
    "meta": {}
}

*/
export function isOpenedUrl(targetUrl) {
    // 로그인 상관 없이 허용한 url 목록
    const opened = ["/", "/login", "/regist", "/select"]
     
    // 허용한 목록 안에 포함 되는지 확인
    // opend를 순회하면서 targetUrl.path랑 똑같으면 그 element를 반환함
    const res = opened.find((element) => element === targetUrl.path);

    if(!res) {
        return false;
    } else {
        return true;
    }


}


