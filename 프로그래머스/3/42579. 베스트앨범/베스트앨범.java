import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 횟수를 누적하여 저장할 맵 생성 (key: 장르, value: 총 재생 횟수)
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 장르별 총 재생 횟수를 기준으로 내림차순 정렬하기 위해 리스트로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // 3. 장르별로 속한 노래(Song 객체)들의 리스트를 저장할 맵 생성
        Map<String, List<Song>> map2 = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {

            if (!map2.containsKey(genres[i])) {
                map2.put(genres[i], new ArrayList<>());
            }

            // 각 장르에 해당하는 리스트에 노래 정보(재생 횟수, 고유 번호) 추가
            map2.get(genres[i]).add(new Song(plays[i], i));
        }

        // 4. 각 장르 내에서 노래들을 기준에 맞게 정렬
        for (List<Song> li : map2.values()) {
            Collections.sort(li, (a, b) -> {
                // 재생 횟수가 같다면 고유 번호(index) 기준 오름차순 정렬
                if (a.play == b.play) {
                    return a.index - b.index;
                }
                // 재생 횟수가 다르다면 재생 횟수 기준 내림차순 정렬
                return b.play - a.play;
            });
        }

        // 5. 정렬된 결과를 바탕으로 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 저장
        List<Integer> answer = new ArrayList<>();

        // 총 재생 횟수가 가장 많은 장르부터 순회
        for (Map.Entry<String, Integer> entry : list) {

            List<Song> li = map2.get(entry.getKey());

            // 각 장르별로 가장 많이 재생된 노래를 최대 2곡까지만 선택
            for (int i = 0; i < li.size() && i < 2; i++) {
                answer.add(li.get(i).index);
            }
        }

        // 6. List 형식의 결과를 반환 타입에 맞게 int 배열로 변환
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}

// 노래의 재생 횟수와 원래 고유 번호(인덱스)를 묶어서 관리하기 위한 헬퍼 클래스
class Song {
    int play;
    int index;

    public Song(int play, int index) {
        this.play = play;
        this.index = index;
    }
}