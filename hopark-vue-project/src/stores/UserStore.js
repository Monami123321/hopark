import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";

// 여기서 정의하면 defineStore 안쪽 콜백함수가 동작할 떄 router가 정의되지 않아서 오류남
// const router = useRouter();

export const useUserStore = defineStore("User", () => {

  const router = useRouter();

  //로그인 요청시 이용할 정보
  const userLoginData = ref({});

  // 로그인 메서드 - 백에 axios 요청을 보낸다
  function userLogin(userLoginData) {
    console.log(import.meta.env.VITE_BACK_URI + "user/login");
    axios({
      method: "POST",
      url: import.meta.env.VITE_BACK_URI + "user/login",
      data: userLoginData,
    })
      .then((res) => {
        console.log(res);
        console.log(res.headers.get("Authorization"));
        // axios 응답이 정상적으로 왔으면 http header에서 jwt를 추출한 다음 localStorage에 저장한다. 따로 분리하지 않고 bearer까지 그냥 저장함 (백에서 처리함)

        localStorage.setItem("jwt", res.headers.get("Authorization"));
        alert("로그인 성공!");
        router.push("/");
      })
      .catch((err) => {
        alert("아이디와 비밀번호를 확인하세요.");
        router.push("/");
      });
  }

  //로그아웃 -> localStorage에서 jwt를 지우고 첫화면으로 돌아가기
  function userLogout() {
    localStorage.removeItem("jwt");
    router.push("/");
  }

  // 회원가입 요청에 사용할 정보
  const userRegistData = ref({});
  // 회원가입 메서드 - 백에 axios 요청을 보낸다.
  function userRegist() {
    axios({
      method: "POST",
      url: import.meta.env.VITE_BACK_URI + "user/regist",
      data: registData.value,
    })
      .then((res) => {
        // axios 응답이 정상적으로 왔으면
        alert("회원가입 성공!");
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
        alert("정확한 정보가 입력되었는지 확인해주세요.");
        router.push("/");
      });
  }

  // 회원정보 수정에 사용할 정보
  const userUpdateData = ref({});

  // 회원정보수정 메서드 - 백에 axios 요청을 보낸다. http header에 Authorization: <token> 형태로 심어서 보낸다. localStorage에 'jwt' key로 저장되어있다 (bearer 포함)
  function userUpdate() {
    axios({
      method: "PUT",
      url: import.meta.env.VITE_BACK_URI + "user/update",
      headers: { Authorization: localStorage.get("jwt") },
      data: registData.value,
    })
      .then((res) => {
        alert("정보가 성공적으로 수정되었습니다.");
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
        alert("입력한 정보를 다시 한 번 확인해주세요.");
        router.push("/");
      });
  }

  // 회원탈퇴 메서드 - 백에 axios 요청을 보낸다.
  function userDelete() {
    axios({
      method: "DELETE",
      url: import.meta.env.VITE_BACK_URI + "user/delete",
      headers: { Authorization: localStorage.get("jwt") },
    })
      .then((res) => {
        alert("회원탈퇴가 완료되었습니다.");
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
        alert("오류 발생");
        router.push("/");
      });
  }

  return {
    userLoginData,
    userLogin,
    userLogout,
    userRegistData,
    userRegist,
    userUpdateData,
    userUpdate,
    userDelete,
  };
});
