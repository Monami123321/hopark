import axios from "axios";

// DB에 저장된 모든 운동 정보 다 가져오기
// 운동 객체 배열로 리턴
export async function getAllSports() {
  try {
    const res = await axios({
      method: "GET",
      url: import.meta.env.VITE_BACK_URI + "sports/getAll",
      headers: { Authorization: localStorage.getItem("jwt") },
    });
    return res.data;
  } catch (err) {
    console.log(err);
    alert("오류 발생");
    return;
  }
}

// DB에서 검색조건에 따라 맞는 운동만 가져와서 리턴한다.
// searchCondition은 백에서 정의된 DTO에 맞게 객체로 입력
export function searchByCondition(searchCondition) {
  axios({
    method: "POST",
    url: import.meta.env.VITE_BACK_URI + "sports/search",
    headers: { Authorization: localStorage.getItem("jwt") },
    data: searchCondition,
  })
    .then((res) => {
      return res.data;
    })
    .catch((err) => {
      console.log(err);
      alert("오류 발생");
      return;
    });
}

// DB에서 랜덤으로 4개 뽑아오기
export async function pickRandomSports() {
  try {
    const res = await axios({
      method: "GET",
      url: `${import.meta.env.VITE_BACK_URI}sports/pick`,
      headers: { Authorization: localStorage.getItem("jwt") },
    });
    return res.data;
  } catch (err) {
    alert("오류발생");
    return;
  }
}
