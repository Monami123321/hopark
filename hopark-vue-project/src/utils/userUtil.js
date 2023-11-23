import axios from "axios";

export async function getLoginUserInfo() {
    try {
        const res = await axios({
            method:"GET",
            url: `${import.meta.env.VITE_BACK_URI}user/info`,
            headers: { Authorization: localStorage.getItem("jwt") },
        })
        console.log(res.data)
        return res.data

    } catch(e) {
        console.log(e)
        return
    }
    
}