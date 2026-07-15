import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();

        // 장르별 총 재생수
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        Map<String, List<Song>> map2 = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {

            if (!map2.containsKey(genres[i])) {
                map2.put(genres[i], new ArrayList<>());
            }

            map2.get(genres[i]).add(new Song(plays[i], i));
        }

        for (List<Song> li : map2.values()) {
            Collections.sort(li, (a, b) -> {
                if (a.play == b.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            });
        }

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : list) {

            List<Song> li = map2.get(entry.getKey());

            for (int i = 0; i < li.size() && i < 2; i++) {
                answer.add(li.get(i).index);
            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}

class Song {
    int play;
    int index;

    public Song(int play, int index) {
        this.play = play;
        this.index = index;
    }
}