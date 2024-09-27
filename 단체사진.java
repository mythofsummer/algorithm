import java.util.*;

class Solution {
    char people[] = {'A','C','F','J','M','N','R','T'};
    int answer = 0;
    
    public int solution(int n, String[] data) {
        char[] arr = new char[8];
        boolean[] vst = new boolean[8];
        generatePer(vst, arr, 0, data);
        return answer;
    }
    
    public void generatePer(boolean[] vst, char[] arr, int depth, String[] data){
        if(depth == 8){
            if(isValid(arr,data)){
                answer++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!vst[i]){
                arr[depth] = people[i];
                vst[i] = true;
                generatePer(vst, arr, depth+1, data);
                vst[i] = false;
            }
        }
    }
    
    public boolean isValid(char[] arr, String[] data){
        for(String d : data){
            int from = -1;
            int to = -1;
            for(int i=0; i<8; i++){
                if(arr[i] == d.charAt(0)){
                    from = i;
                }else if(arr[i] == d.charAt(2)){
                    to = i;
                }
            }
            int gap = Math.abs(from - to) - 1;
            if(d.charAt(3) == '='){
                if(gap != d.charAt(4) - '0'){
                    return false;
                }
            }else if(d.charAt(3) == '<'){
                if(gap >= d.charAt(4) - '0'){
                    return false;
                }
            }else if(d.charAt(3) == '>'){
                if(gap <= d.charAt(4) - '0'){
                    return false;
                }
            }
        }
        return true;
    }
}