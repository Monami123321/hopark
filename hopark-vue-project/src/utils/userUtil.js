import axios from "axios";

export async function getLoginUserInfo() {
    try {
        const res = await axios({
            method:"GET",
            url: `${import.meta.env.VITE_BACK}user/info`
        })
        return res.data

    } catch(e) {
        console.log(e)
        return
    }
    
}