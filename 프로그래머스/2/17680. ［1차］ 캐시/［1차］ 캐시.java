import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        
        if(cacheSize == 0){
            answer = cities.length * 5;
            return answer;
        }
        
        for(int i = 0; i<cities.length; i++){
            if(list.size() < cacheSize){
                if(list.contains(cities[i].toUpperCase())){
                    list.remove(cities[i].toUpperCase());
                    list.add(cities[i].toUpperCase());
                    answer += 1;
                } else{
                    list.add(cities[i].toUpperCase());
                    answer+=5;
                }
            } else{
                if(list.contains(cities[i].toUpperCase())){
                    list.remove(cities[i].toUpperCase());
                    list.add(cities[i].toUpperCase());
                    answer += 1;
                } else{
                    if(!list.isEmpty()){
                        list.remove(0);
                        list.add(cities[i].toUpperCase());
                        answer+=5;
                    }
                }
            }
            
        }
        
        
        return answer;
    }
}