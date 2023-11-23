import axios from "axios";
import { useVideoStore } from "../stores/videoStore";


export async function youtubeSearch(keyword) {
  const store = useVideoStore();
  const URL = "https://www.googleapis.com/youtube/v3/search";
  const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
  try {
    const res = await axios({
      method: "GET",
      url: URL,
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: "video",
        maxResults: 10,
      },
    });
    console.log(res)
    store.videoList = res.data;
  } catch (e) {
    console.log(e);
  }
}
